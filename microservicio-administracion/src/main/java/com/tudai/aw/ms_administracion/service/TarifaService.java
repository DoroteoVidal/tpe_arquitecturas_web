package com.tudai.aw.ms_administracion.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
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

import com.tudai.aw.ms_administracion.model.clases.Viaje;
import com.tudai.aw.ms_administracion.model.dto.MonopatinDto;
import com.tudai.aw.ms_administracion.model.entidades.Tarifa;
import com.tudai.aw.ms_administracion.repository.TarifaRepository;

import jakarta.transaction.Transactional;

@Service("TarifaService")
public class TarifaService {
	
	@Autowired
	private TarifaRepository tarifaRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public ResponseEntity<?> obtenerFacturacionEntreLosMeses(int mes1, int mes2, int anio) {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
		
		ResponseEntity<List<Viaje>> response = restTemplate.exchange(
				"http://localhost:8011/viajes/entre/"+mes1+"/a/"+mes2+"/enAnio/"+anio, 
				HttpMethod.GET, 
				requestEntity, 
				new ParameterizedTypeReference<List<Viaje>>() {} 
		);
		
		if(response.getStatusCode().is2xxSuccessful()) {
			Tarifa tarifa = tarifaRepository.getById(1L);
			int minutos = this.extraerMinutosDeViajes(response.getBody());
			
			return ResponseEntity.ok("Total facturado entre el mes: " + mes1 + ", y mes: " + mes2 + " en el anio " + anio + " es: " + minutos * tarifa.getValor());
			
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe facturacion");
	}
	
	private int extraerMinutosDeViajes(List<Viaje> viajes) {
		int minutos = 0;
		for(Viaje v : viajes) {
			minutos += obtenerMinutosEntreDosHorarios(v.getFechaHoraInicio(), v.getFechaHoraFin());
		}
		return minutos;
	}
	
	private static int obtenerMinutosEntreDosHorarios(LocalDateTime inicio, LocalDateTime fin) {
		return (int) ChronoUnit.MINUTES.between(inicio, fin);
    }
	
	@Transactional
	public Tarifa guardar(Tarifa tarifa) throws Exception {
		try{
            return tarifaRepository.save(tarifa);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
	}

	@Transactional
    public boolean eliminar(Long id) throws Exception {
        try{
            if(tarifaRepository.existsById(id)){
            	tarifaRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
	
	@Transactional
	public Tarifa obtenerPorId(Long id) throws Exception {
		try {
			return tarifaRepository.findById(id).get();
		}catch (Exception e){
            throw new Exception(e.getMessage());
        }
	}
	
	@Transactional
    public Tarifa actualizar(Tarifa tarifa, Long id) throws Exception {
        try{
        	Tarifa busqueda = tarifaRepository.findById(id).get();
            
        	busqueda.setClave(tarifa.getClave());
        	busqueda.setValor(tarifa.getValor());
        	busqueda.setValorAgregadoPorPausa(tarifa.getValorAgregadoPorPausa());
        	busqueda.setFechaVigencia(tarifa.getFechaVigencia());
        	
            return busqueda;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
	
	@Transactional
    public Tarifa agregarTarifaExtra(double extra, Long id) throws Exception {
        try{
        	Tarifa busqueda = tarifaRepository.findById(id).get();          
        	busqueda.setValorAgregadoPorPausa(extra);       	
            return busqueda;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
	}
	
}
