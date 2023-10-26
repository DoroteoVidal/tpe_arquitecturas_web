package com.tudai.aw.ms_administracion.service;

import java.time.LocalDateTime;

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

@Service("AdministracionService")
public class AdministracionService {
	
	@Autowired
	private RestTemplate restTemplate;
	
    public ResponseEntity<?> agregarMonopatin(Monopatin monopatin) {
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

	public ResponseEntity<?> agregarMonopatinAMantenimiento(Long id) {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
		
		ResponseEntity<Monopatin> response = restTemplate.exchange(
				"http://localhost:8011/monopatines/" + id, 
				HttpMethod.GET, 
				requestEntity, 
				new ParameterizedTypeReference<Monopatin>() {} //convierte en Json
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
			}
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro el monopatin que quiere agregar a mantenimiento");
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
			return ResponseEntity.ok("Se elimino el monopatin con exito");
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro el monopatin que quiere eliminar");
	}

	public ResponseEntity<?> agregarParada(Parada parada) {
		// TODO Auto-generated method stub
		return null;
	}
}
