package com.tudai.aw.ms_usuario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tudai.aw.ms_usuario.dto.CuentaDto;
import com.tudai.aw.ms_usuario.model.Cuenta;
import com.tudai.aw.ms_usuario.model.Usuario;
import com.tudai.aw.ms_usuario.repository.CuentaRepository;
import com.tudai.aw.ms_usuario.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service("CuentaService")
public class CuentaService {
	
	@Autowired
	private CuentaRepository cuentaRepository;
	
	@Autowired 
	private UsuarioRepository usuarioRepository;
	
	@Transactional
	public boolean anularCuenta(Long id) throws Exception {
		try{
			if(cuentaRepository.existsById(id)) {
				Cuenta busqueda = cuentaRepository.findById(id).get();
	            busqueda.setEstado("anulada");
	            return true;
			}else {
				throw new Exception();
			}
        	
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
	}
	
	@Transactional
    public Cuenta guardar(CuentaDto dto) throws Exception {	
        try{    		
        	Usuario usuario = usuarioRepository.findById(dto.getIdUsuario()).get();
            return cuentaRepository.save(new Cuenta(dto.getDinero(), usuario, dto.getEstado()));       	
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
	
	@Transactional
    public boolean eliminar(Long id) throws Exception {
        try{
            if(cuentaRepository.existsById(id)){
            	cuentaRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
	
	@Transactional
	public Cuenta obtenerPorId(Long id) throws Exception {
		try {
			return cuentaRepository.findById(id).get();
		}catch (Exception e){
            throw new Exception(e.getMessage());
        }
	}
	
	@Transactional
    public Cuenta actualizar(Cuenta cuenta, Long id) throws Exception {
        try{
        	Cuenta busqueda = cuentaRepository.findById(id).get();
            
        	busqueda.setDinero(cuenta.getDinero());
        	busqueda.setUsuario(cuenta.getUsuario());
        	busqueda.setEstado(cuenta.getEstado());
        	
            return busqueda;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
