package com.tudai.aw.ms_mantenimiento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tudai.aw.ms_mantenimiento.dto.MonopatinDto;
import com.tudai.aw.ms_mantenimiento.model.Mantenimiento;
import com.tudai.aw.ms_mantenimiento.repository.MantenimientoRepository;

import jakarta.transaction.Transactional;

@Service("MantenimientoService")
public class MantenimientoService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private MantenimientoRepository mantenimientoRepository;
	
	public ResponseEntity<?> generarReporteMonopatinPorKm(int pausa) {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
		
		if(pausa == 1) {
			ResponseEntity<List<MonopatinDto>> response = restTemplate.exchange(
					"http://localhost:8011/monopatines/reportesPorTiempoConPausa", 
					HttpMethod.GET, 
					requestEntity, 
					new ParameterizedTypeReference<List<MonopatinDto>>() {} 
			);		
			return response;
		}
		
		if(pausa == 0) {
			ResponseEntity<List<MonopatinDto>> response2 = restTemplate.exchange(
					"http://localhost:8011/monopatines/reportesPorTiempoSinPausa", 
					HttpMethod.GET, 
					requestEntity, 
					new ParameterizedTypeReference<List<MonopatinDto>>() {} 
			);			
			return response2;
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
	}
	
	@Transactional	
	public Mantenimiento obtenerPorIdMonopatin(Long id) throws Exception {
		try {
			return mantenimientoRepository.obtenerPorIdMonopatin(id).get();
		}catch (Exception e){
            throw new Exception(e.getMessage());
        }
	}
	
	@Transactional
	public Mantenimiento guardar(Mantenimiento mantenimiento) throws Exception {
		try{
            return mantenimientoRepository.save(mantenimiento);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
	}

	@Transactional
    public boolean eliminar(Long id) throws Exception {
        try{
            if(mantenimientoRepository.existsById(id)){
            	mantenimientoRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
	
	@Transactional
	public Mantenimiento obtenerPorId(Long id) throws Exception {
		try {
			return mantenimientoRepository.findById(id).get();
		}catch (Exception e){
            throw new Exception(e.getMessage());
        }
	}
	
	@Transactional
    public Mantenimiento actualizar(Mantenimiento mantenimiento, Long id) throws Exception {
        try{
        	Mantenimiento busqueda = mantenimientoRepository.findById(id).get();
            
        	busqueda.setFechaHoraInicio(mantenimiento.getFechaHoraInicio());
        	busqueda.setFechaHoraFin(mantenimiento.getFechaHoraFin());
        	busqueda.setIdMonopatin(mantenimiento.getIdMonopatin());
        	busqueda.setReparado(mantenimiento.isReparado());
        	
            return busqueda;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
