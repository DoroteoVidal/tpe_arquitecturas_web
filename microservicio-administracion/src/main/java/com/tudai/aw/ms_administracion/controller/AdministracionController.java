package com.tudai.aw.ms_administracion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tudai.aw.ms_administracion.model.clases.Monopatin;
import com.tudai.aw.ms_administracion.model.clases.Parada;
import com.tudai.aw.ms_administracion.service.AdministracionService;

@RestController
@RequestMapping("administradores")
public class AdministracionController {
	
	@Autowired
	private AdministracionService administracionService;
	
	@PostMapping("/monopatines")
    public ResponseEntity<?> agregarMonopatin(@RequestBody Monopatin monopatin) {
		return ResponseEntity.status(HttpStatus.OK).body(administracionService.agregarMonopatin(monopatin));       
    }
	
	@PutMapping("/monopatines/{id}")
    public ResponseEntity<?> agregarMonopatinAMantenimiento(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(administracionService.agregarMonopatinAMantenimiento(id));       
    }
	
	@DeleteMapping("/monopatines/{id}")
	public ResponseEntity<?> eliminarMonopatin(@PathVariable Long id) {
		return administracionService.eliminarMonopatin(id);
	}
	
	@PostMapping("/paradas")
    public ResponseEntity<?> agregarParada(@RequestBody Parada parada) {
        return ResponseEntity.status(HttpStatus.OK).body(administracionService.agregarParada(parada));       
    }
	
	//Agregar metodos propios de administrador get, post, put, delete
}
