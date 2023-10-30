package com.tudai.aw.ms_administracion.service;

import java.time.LocalDateTime;
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

import com.tudai.aw.ms_administracion.model.clases.Mantenimiento;
import com.tudai.aw.ms_administracion.model.clases.Monopatin;
import com.tudai.aw.ms_administracion.model.clases.Parada;
import com.tudai.aw.ms_administracion.model.dto.MonopatinConViajesDto;
import com.tudai.aw.ms_administracion.model.dto.MonopatinDto;
import com.tudai.aw.ms_administracion.model.entidades.Administrador;
import com.tudai.aw.ms_administracion.repository.AdministracionRepository;

import jakarta.transaction.Transactional;

@Service("AdministracionService")
public class AdministracionService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private AdministracionRepository administracionRepository;
	
	//ABM monopatines
	
    public ResponseEntity<?> guardarMonopatin(Monopatin monopatin) {
    	HttpHeaders headers = new HttpHeaders();
    	Monopatin monopatinNuevo = new Monopatin(monopatin);
		HttpEntity<Monopatin> requestEntity = new HttpEntity<>(monopatinNuevo, headers);
		
		ResponseEntity<Monopatin> response = restTemplate.exchange(
				"http://localhost:8011/monopatines",
				HttpMethod.POST,
				requestEntity,
				new ParameterizedTypeReference<Monopatin>() {}
		);
		
		return response;
    }

	public ResponseEntity<?> iniciarMantenimientoMonopatin(Long id) {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
		
		ResponseEntity<Monopatin> response = restTemplate.exchange(
				"http://localhost:8011/monopatines/" + id, 
				HttpMethod.GET, 
				requestEntity, 
				new ParameterizedTypeReference<Monopatin>() {}
		);
		
		if(response.getStatusCode().is2xxSuccessful()) {
			Monopatin monopatin = response.getBody();
			
			if(monopatin.getEstado().equals("disponible")) {
				this.agregarMantenimiento(id);
				monopatin.setEstado("en mantenimiento");
				
				HttpEntity<Monopatin> requestEntity2 = new HttpEntity<>(monopatin, headers);			
				ResponseEntity<Monopatin> response2 = restTemplate.exchange(
						"http://localhost:8011/monopatines/" + id,
						HttpMethod.PUT,
						requestEntity2,
						new ParameterizedTypeReference<Monopatin>() {}
				);
				
				return response2;
			}else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El monopatin con id: " + id + " no se encuentra disponible");
			}
		}
		//Tira error cuando no existe un monopatin...
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro el monopatin con id: " + id);
	}

	private ResponseEntity<?> agregarMantenimiento(Long id) {
		HttpHeaders headers = new HttpHeaders();		
		Mantenimiento mantenimiento = new Mantenimiento();
				
		mantenimiento.setFechaHoraInicio(LocalDateTime.now());
		mantenimiento.setFechaHoraFin(null);
		mantenimiento.setIdMonopatin(id);	
		mantenimiento.setReparado(false);
		
		HttpEntity<Mantenimiento> requestEntity = new HttpEntity<>(mantenimiento, headers);		
		ResponseEntity<Mantenimiento> response = restTemplate.exchange(
				"http://localhost:8041/mantenimientos",
				HttpMethod.POST,
				requestEntity,
				new ParameterizedTypeReference<Mantenimiento>() {}
		);
		
		return response;
	}
	
	public ResponseEntity<?> finalizarMantenimientoMonopatin(Long id) {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
		
		ResponseEntity<Monopatin> response = restTemplate.exchange(
				"http://localhost:8011/monopatines/" + id, 
				HttpMethod.GET, 
				requestEntity, 
				new ParameterizedTypeReference<Monopatin>() {} 
		);
		
		if(response.getStatusCode().is2xxSuccessful()) {
			Monopatin monopatin = response.getBody();
			
			if(monopatin.getEstado().equals("en mantenimiento")) {
				this.agregarFechaFinMantenimiento(id);
				monopatin.setEstado("disponible");
				
				HttpEntity<Monopatin> requestEntity2 = new HttpEntity<>(monopatin, headers);				
				ResponseEntity<Monopatin> response2 = restTemplate.exchange(
						"http://localhost:8011/monopatines/" + id,
						HttpMethod.PUT,
						requestEntity2,
						new ParameterizedTypeReference<Monopatin>() {}
				);			
				return response2;
			}else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El monopatin con id: " + id + " no se encuentra en mantenimiento");
			}
		}
		
		return response;
	}
	
	private ResponseEntity<?> agregarFechaFinMantenimiento(Long id) {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
		
		ResponseEntity<Mantenimiento> response = restTemplate.exchange(
				"http://localhost:8041/mantenimientos/porIdMonopatin/" + id, 
				HttpMethod.GET, 
				requestEntity, 
				new ParameterizedTypeReference<Mantenimiento>() {} 
		);
		
		if(response.getStatusCode().is2xxSuccessful()) {
			Mantenimiento mantenimiento = response.getBody();
			mantenimiento.setFechaHoraFin(LocalDateTime.now());
			mantenimiento.setReparado(true);
			
			HttpEntity<Mantenimiento> requestEntity2 = new HttpEntity<>(mantenimiento, headers);		
			ResponseEntity<Mantenimiento> response2 = restTemplate.exchange(
					"http://localhost:8041/mantenimientos/" + mantenimiento.getId(),
					HttpMethod.PUT,
					requestEntity2,
					new ParameterizedTypeReference<Mantenimiento>() {}
			);
			
			return response2;
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro el mantenimiento con el id: " + id);
	}

	public ResponseEntity<?> eliminarMonopatin(Long id) {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<Void> requestEntity = new HttpEntity<>(headers);		
		ResponseEntity<String> response = restTemplate.exchange(
				"http://localhost:8011/monopatines/" + id,
				HttpMethod.DELETE,
				requestEntity,
				String.class
		);
		
		if(response != null) {
			return ResponseEntity.ok("El monopatin con id: " + id + " fue eliminado con exito");
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro monopatin con id: " + id);
	}
	
	public ResponseEntity<?> generarReportesDeMonopatinesPorKm(double km1, double km2) {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
		
		ResponseEntity<List<Monopatin>> response = restTemplate.exchange(
				"http://localhost:8011/monopatines/reportesPorKm/" + km1 + "/a/" + km2, 
				HttpMethod.GET, 
				requestEntity, 
				new ParameterizedTypeReference<List<Monopatin>>() {} 
		);
		
		return response;
	}
	
	public ResponseEntity<?> generarReportesDeMonopatinesPorTiempoConPausa() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
		
		ResponseEntity<List<MonopatinDto>> response = restTemplate.exchange(
				"http://localhost:8011/monopatines/reportesPorTiempoConPausa", 
				HttpMethod.GET, 
				requestEntity, 
				new ParameterizedTypeReference<List<MonopatinDto>>() {} 
		);
		
		return response;
	}
	
	public ResponseEntity<?> generarReportesDeMonopatinesPorTiempoSinPausa() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
		
		ResponseEntity<List<MonopatinDto>> response = restTemplate.exchange(
				"http://localhost:8011/monopatines/reportesPorTiempoSinPausa", 
				HttpMethod.GET, 
				requestEntity, 
				new ParameterizedTypeReference<List<MonopatinDto>>() {} 
		);
		
		return response;
	}
	
	public ResponseEntity<?> obtenerMonopatinesConViajesPorAnio(int viajes, int anio) {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
		
		ResponseEntity<List<MonopatinConViajesDto>> response = restTemplate.exchange(
				"http://localhost:8011/monopatines/conViajes/"+viajes+"/enAnio/"+anio, 
				HttpMethod.GET, 
				requestEntity, 
				new ParameterizedTypeReference<List<MonopatinConViajesDto>>() {} 
		);
		
		return response;
	}
	
	public ResponseEntity<?> obtenerCantidadMonopatinesOperandoYEnMantenimiento() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
		
		ResponseEntity<String> response = restTemplate.exchange(
				"http://localhost:8011/monopatines/cantidadMonopatines", 
				HttpMethod.GET, 
				requestEntity, 
				new ParameterizedTypeReference<String>() {} 
		);
		
		return response;
	}
	
	//ABM paradas

	public ResponseEntity<?> guardarParada(Parada parada) {
		HttpHeaders headers = new HttpHeaders();
    	Parada paradaNueva = new Parada(parada);
		HttpEntity<Parada> requestEntity = new HttpEntity<>(paradaNueva, headers);
		
		ResponseEntity<Parada> response = restTemplate.exchange(
				"http://localhost:8021/paradas",
				HttpMethod.POST,
				requestEntity,
				new ParameterizedTypeReference<Parada>() {}
		);
		
		return response;
	}
	
	public ResponseEntity<?> eliminarParada(Long id) {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<Void> requestEntity = new HttpEntity<>(headers);		
		ResponseEntity<String> response = restTemplate.exchange(
				"http://localhost:8021/paradas/" + id,
				HttpMethod.DELETE,
				requestEntity,
				String.class
		);
		
		if(response != null) {
			return ResponseEntity.ok("La parada con id: " + id + " fue eliminada con exito");
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro parada con id: " + id);
	}
	
	//ABM usuarios
	
	public ResponseEntity<?> anularCuenta(Long id) {
		return null;
	}
	
	//ABM administrador
	
	@Transactional
    public Administrador guardar(Administrador admin) throws Exception {	
        try{    		
            return administracionRepository.save(admin);       	
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
	
	@Transactional
    public boolean eliminar(Long id) throws Exception {
        try{
            if(administracionRepository.existsById(id)){
            	administracionRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
	
	@Transactional
	public Administrador obtenerPorId(Long id) throws Exception {
		try {
			return administracionRepository.findById(id).get();
		}catch (Exception e){
            throw new Exception(e.getMessage());
        }
	}
	
	@Transactional
    public Administrador actualizar(Administrador admin, Long id) throws Exception {
        try{
        	Administrador busqueda = administracionRepository.findById(id).get();
            
        	busqueda.setNombre(admin.getNombre());
        	busqueda.setRol(admin.getRol());
        	
            return busqueda;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
