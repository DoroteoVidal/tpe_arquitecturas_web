package com.tudai.aw.ms_monopatin.service;

import java.util.List;

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
	public List<Monopatin> obtenerMonopatinesConRecorridosEntre(double km1, double km2) throws Exception {
		try{    		
            return monopatinRepository.obtenerMonopatinesConRecorridosEntre(km1, km2);       	
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
	}
	
	@Transactional
	public List<Monopatin> obtenerMonopatinesConTiempoConPausa() throws Exception {
		try{    		
            return monopatinRepository.obtenerMonopatinesConTiempoConPausa();       	
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
	}
	
	@Transactional
	public List<Monopatin> obtenerMonopatinesConTiempoSinPausa() throws Exception {
		try{    		
            return monopatinRepository.obtenerMonopatinesConTiempoSinPausa();       	
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
	}
	
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
            
            busqueda.setEstado(monopatin.getEstado()); 
            busqueda.setLatitud(monopatin.getLatitud());
            busqueda.setLongitud(monopatin.getLongitud());
            busqueda.setGps(monopatin.getGps());
            busqueda.setKilometrosRecorridos(monopatin.getKilometrosRecorridos());
            
            return busqueda;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
	
}
