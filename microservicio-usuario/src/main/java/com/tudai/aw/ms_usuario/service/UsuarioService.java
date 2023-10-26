package com.tudai.aw.ms_usuario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tudai.aw.ms_usuario.model.Usuario;
import com.tudai.aw.ms_usuario.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service("UsuarioService")
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
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
