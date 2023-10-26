package com.tudai.aw.ms_parada.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tudai.aw.ms_parada.model.Parada;
import com.tudai.aw.ms_parada.repository.ParadaRepository;

import jakarta.transaction.Transactional;

@Service("ParadaService")
public class ParadaService {
	
	@Autowired
	private ParadaRepository paradaRepository;
	
	@Transactional
    public Parada guardar(Parada parada) throws Exception {
        try{
            return paradaRepository.save(parada);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
	
	@Transactional
    public boolean eliminar(Long id) throws Exception {
        try{
            if(paradaRepository.existsById(id)){
            	paradaRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
	
	@Transactional
	public Parada obtenerPorId(Long id) throws Exception {
		try {
			return paradaRepository.findById(id).get();
		}catch (Exception e){
            throw new Exception(e.getMessage());
        }
	}
	
	@Transactional
    public Parada actualizar(Parada parada, Long id) throws Exception {
        try{
        	Parada busqueda = paradaRepository.findById(id).get();
            
        	busqueda.setLatitud(parada.getLatitud());
        	busqueda.setLongitud(parada.getLongitud());
        	busqueda.setNombre(parada.getNombre());
        	
            return busqueda;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
