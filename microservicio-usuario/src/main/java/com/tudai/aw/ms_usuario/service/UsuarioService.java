package com.tudai.aw.ms_usuario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tudai.aw.ms_usuario.model.clases.Monopatin;
import com.tudai.aw.ms_usuario.model.Usuario;
import com.tudai.aw.ms_usuario.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service("UsuarioService")
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public ResponseEntity<?> obtenerMonopatinesCercanos(double latitud, double longitud) {
		HttpHeaders headers = new HttpHeaders();
    	Monopatin monopatinNuevo = new Monopatin();
		HttpEntity<Monopatin> requestEntity = new HttpEntity<>(monopatinNuevo, headers);
		
		ResponseEntity<List<Monopatin>> response = restTemplate.exchange(
				"http://localhost:8011/monopatines/cercanos/latitud/"+latitud+"/longitud/"+longitud,
				HttpMethod.GET,
				requestEntity,
				new ParameterizedTypeReference<List<Monopatin>>() {}
		);
		
		return response;
	}
	
	@Transactional
    public Usuario guardar(Usuario usuario) throws Exception {	
        try{    		
            return usuarioRepository.save(usuario);       	
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
	
	@Transactional
    public boolean eliminar(Long id) throws Exception {
        try{
            if(usuarioRepository.existsById(id)){
            	usuarioRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
	
	@Transactional
	public Usuario obtenerPorId(Long id) throws Exception {
		try {
			return usuarioRepository.findById(id).get();
		}catch (Exception e){
            throw new Exception(e.getMessage());
        }
	}
	
	@Transactional
    public Usuario actualizar(Usuario usuario, Long id) throws Exception {
        try{
        	Usuario busqueda = usuarioRepository.findById(id).get();
            
        	busqueda.setNombre(usuario.getNombre());
        	busqueda.setApellido(usuario.getApellido());
        	busqueda.setTelefono(usuario.getTelefono());
        	busqueda.setEmail(usuario.getEmail());
        	busqueda.setFechaDeAlta(usuario.getFechaDeAlta());
        	
            return busqueda;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
	
}
