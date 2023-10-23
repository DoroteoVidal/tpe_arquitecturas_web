package com.tudai.aw.ms_monopatin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tudai.aw.ms_monopatin.model.Gps;
import com.tudai.aw.ms_monopatin.service.GpsService;

@RestController
@RequestMapping("gps")
public class GpsController {
	
	@Autowired
	private GpsService gpsService;
	
	@PostMapping("")
    public ResponseEntity<?> save(@RequestBody Gps gps) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(gpsService.save(gps));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. No se pudo guardar el gps, revise los campos e intente nuevamente.\"}");
        }
    }

}
