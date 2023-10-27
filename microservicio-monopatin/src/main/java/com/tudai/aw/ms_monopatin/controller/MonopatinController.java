package com.tudai.aw.ms_monopatin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tudai.aw.ms_monopatin.model.Monopatin;
import com.tudai.aw.ms_monopatin.service.MonopatinService;

@RestController
@RequestMapping("monopatines")
public class MonopatinController {
	
	@Autowired
	private MonopatinService monopatinService;
	
	@GetMapping("/reportesPorKm/{km1}/a/{km2}")
	public ResponseEntity<?> obtenerMonopatinesConRecorridosEntre(@PathVariable double km1, @PathVariable double km2) {
		try{
            return ResponseEntity.status(HttpStatus.OK).body(monopatinService.obtenerMonopatinesConRecorridosEntre(km1, km2));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. No existen monopatines con recorridos entre los valores ingresados, revise los campos e intente nuevamente.\"}");
        }
	}
	
	@GetMapping("/reportesPorTiempoConPausa")
	public ResponseEntity<?> obtenerMonopatinesConTiempoConPausa() {
		try{
            return ResponseEntity.status(HttpStatus.OK).body(monopatinService.obtenerMonopatinesConTiempoConPausa());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. No existen monopatines con tiempos con pausa, por favor intente más tarde.\"}");
        }
	}
	
	@GetMapping("/reportesPorTiempoSinPausa")
	public ResponseEntity<?> obtenerMonopatinesConTiempoSinPausa() {
		try{
            return ResponseEntity.status(HttpStatus.OK).body(monopatinService.obtenerMonopatinesConTiempoSinPausa());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. No existen monopatines con tiempos sin pausa, por favor intente más tarde.\"}");
        }
	}
	
	@PostMapping("")
    public ResponseEntity<?> guardar(@RequestBody Monopatin monopatin) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(monopatinService.guardar(monopatin));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. No se pudo guardar el monopatin, revise los campos e intente nuevamente.\"}");
        }
    }
	
	@DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(monopatinService.eliminar(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. El monopatin que usted quiere borrar no existe.\"}");
        }
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<?> obtenerPorId(@PathVariable Long id) {
		try{
            return ResponseEntity.status(HttpStatus.OK).body(monopatinService.obtenerPorId(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. No existe monopatin con el id ingresado, revise el campo e intente nuevamente.\"}");
        }
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@RequestBody Monopatin monopatin, @PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(monopatinService.actualizar(monopatin, id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. No se pudo actualizar el monopatin, revise los campos e intente nuevamente.\"}");
        }
    }
}
