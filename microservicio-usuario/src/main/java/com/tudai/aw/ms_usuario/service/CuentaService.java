package com.tudai.aw.ms_usuario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tudai.aw.ms_usuario.model.Cuenta;
import com.tudai.aw.ms_usuario.repository.CuentaRepository;

import jakarta.transaction.Transactional;

@Service("CuentaService")
public class CuentaService {
	
	@Autowired
	private CuentaRepository cuentaRepository;
	
	@Transactional
    public Cuenta guardar(Cuenta cuenta) throws Exception {	
        try{    		
            return cuentaRepository.save(cuenta);       	
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
