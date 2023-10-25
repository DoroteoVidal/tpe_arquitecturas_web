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
	public Mantenimiento save(Mantenimiento mantenimiento) throws Exception {
		try{
            return mantenimientoRepository.save(mantenimiento);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
	}

}
