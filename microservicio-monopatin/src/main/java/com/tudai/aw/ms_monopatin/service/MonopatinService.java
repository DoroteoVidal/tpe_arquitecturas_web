package com.tudai.aw.ms_monopatin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tudai.aw.ms_monopatin.model.Monopatin;
import com.tudai.aw.ms_monopatin.repository.MonopatinRepository;

import jakarta.transaction.Transactional;

@Service("MonopatinService")
public class MonopatinService {
	
	@Autowired
	private MonopatinRepository monopatinRepository;
	
	@Transactional
    public Monopatin guardar(Monopatin monopatin) throws Exception {	
        try{    		
            return monopatinRepository.save(monopatin);       	
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
	
	@Transactional
    public boolean eliminar(Long id) throws Exception {
        try{
            if(monopatinRepository.existsById(id)){
            	monopatinRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
	
	@Transactional
	public Monopatin obtenerPorId(Long id) throws Exception {
		try {
			return monopatinRepository.findById(id).get();
		}catch (Exception e){
            throw new Exception(e.getMessage());
        }
	}
	
	@Transactional
    public Monopatin actualizar(Monopatin monopatin, Long id) throws Exception {
        try{
            Monopatin busqueda = monopatinRepository.findById(id).get();
            busqueda = monopatinRepository.save(monopatin);         
            return busqueda;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
	
}
