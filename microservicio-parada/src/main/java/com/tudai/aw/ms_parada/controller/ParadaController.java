package com.tudai.aw.ms_parada.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tudai.aw.ms_parada.model.Parada;
import com.tudai.aw.ms_parada.service.ParadaService;

@RestController
@RequestMapping("paradas")
public class ParadaController {
	
	@Autowired
	private ParadaService paradaService;
	
	@PostMapping("")
    public ResponseEntity<?> save(@RequestBody Parada parada) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(paradaService.save(parada));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. No se pudo guardar la parada, revise los campos e intente nuevamente.\"}");
        }
    }

}
