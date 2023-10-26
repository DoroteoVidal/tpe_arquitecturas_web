package com.tudai.aw.ms_mantenimiento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tudai.aw.ms_mantenimiento.model.Mantenimiento;
import com.tudai.aw.ms_mantenimiento.repository.MantenimientoRepository;

import jakarta.transaction.Transactional;

@Service("MantenimientoService")
public class MantenimientoService {
	
	@Autowired
	private MantenimientoRepository mantenimientoRepository;
	
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
