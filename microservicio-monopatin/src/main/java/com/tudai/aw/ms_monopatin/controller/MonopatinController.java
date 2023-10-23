package com.tudai.aw.ms_monopatin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tudai.aw.ms_monopatin.dto.MonopatinDTO;
import com.tudai.aw.ms_monopatin.service.MonopatinService;

@RestController
@RequestMapping("monopatines")
public class MonopatinController {
	
	@Autowired
	private MonopatinService monopatinService;
	
	@PostMapping("")
    public ResponseEntity<?> save(@RequestBody MonopatinDTO monopatin) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(monopatinService.save(monopatin));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. No se pudo guardar el monopatin, revise los campos e intente nuevamente.\"}");
        }
    }
	
	@DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(monopatinService.delete(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. El monopatin que usted quiere borrar no existe.\"}");
        }
    }
}
