package com.tudai.aw.ms_monopatin.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tudai.aw.ms_monopatin.dto.MonopatinConViajesDto;
import com.tudai.aw.ms_monopatin.dto.MonopatinDto;
import com.tudai.aw.ms_monopatin.model.Monopatin;
import com.tudai.aw.ms_monopatin.repository.MonopatinRepository;

import jakarta.transaction.Transactional;

@Service("MonopatinService")
public class MonopatinService {
	
	@Autowired
	private MonopatinRepository monopatinRepository;
	
	@Transactional
	public String obtenerCantidadEnUsoYEnMantenimiento()throws Exception {
		try{    
			 Long enUso = monopatinRepository.obtenerCantidad("en uso");
			 Long enMantenimiento = monopatinRepository.obtenerCantidad("en mantenimiento");   
			 Long disponibles = monopatinRepository.obtenerCantidad("disponible");   
			 
			 return "Monopatines disponibles: "+ disponibles + ", en uso: " + enUso + ", en mantenimiento: " + enMantenimiento;
			 
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
	}
	
	@Transactional
	public List<MonopatinConViajesDto> obtenerConViajesPorAnio(int viajes, int anio) throws Exception {
		try{    		
            var result = monopatinRepository.obtenerConViajesPorAnio(viajes, anio);
            return result.stream().map(m -> new MonopatinConViajesDto((Long)m[0], (Long)m[1], (Long)m[2])).collect(Collectors.toList());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
	}
	
	@Transactional
	public List<Monopatin> obtenerConRecorridosEntre(double km1, double km2) throws Exception {
		try{    		
            return monopatinRepository.obtenerConRecorridosEntre(km1, km2);       	
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
	}
	
	@Transactional
	public List<MonopatinDto> obtenerConTiempoConPausa() throws Exception {
		try{    		
            var result = monopatinRepository.obtenerConTiempoConPausa();
            return result.stream().map(m -> new MonopatinDto((Long)m[0], (double)m[1], (Long)m[2])).collect(Collectors.toList());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
	}
	
	@Transactional
	public List<MonopatinDto> obtenerConTiempoSinPausa() throws Exception {
		try{    		
			var result = monopatinRepository.obtenerConTiempoSinPausa();
            return result.stream().map(m -> new MonopatinDto((Long)m[0], (double)m[1])).collect(Collectors.toList());      	
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
