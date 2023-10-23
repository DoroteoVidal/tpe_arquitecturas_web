package com.tudai.aw.ms_mantenimiento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tudai.aw.ms_mantenimiento.model.Mantenimiento;
import com.tudai.aw.ms_mantenimiento.repository.MantenimientoRepository;

import jakarta.transaction.Transactional;

@Service("MantenimientoService")
public class MantenimientoService {
	
	@Autowired
	private MantenimientoRepository mantenimientoRepository;
	
	@Autowired
	private RestTemplate monopatinRest;
	
	@Transactional
	public Mantenimiento registrarMantenimientoDeMonopatin(Long id) throws Exception {
		//Aca se debe obtener el monopatin mediante el id...
		//En caso de existir, consultar su estado...
		//Si esta disponible, corroborar que este en condiciones de mantenimiento (kilometros recorridos y tiempo de uso)...
		//Si no existe, retornar error
		return null;
	}

}
