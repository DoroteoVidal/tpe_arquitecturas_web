package com.tudai.aw.ms_mantenimiento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tudai.aw.ms_mantenimiento.model.Mantenimiento;
import com.tudai.aw.ms_mantenimiento.service.MantenimientoService;

@RestController
@RequestMapping("mantenimientos")
public class MantenimientoController {
	
	@Autowired
	private MantenimientoService mantenimientoService;
	
	@PostMapping("")
	public ResponseEntity<?> save(@RequestBody Mantenimiento mantenimiento) {
		try{
			return ResponseEntity.status(HttpStatus.OK).body(mantenimientoService.save(mantenimiento));
		}catch (Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. No se pudo guardar el mantenimiento, revise los campos e intente nuevamente.\"}");
		}
	}

}
