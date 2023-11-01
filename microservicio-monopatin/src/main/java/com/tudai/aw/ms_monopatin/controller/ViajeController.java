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

import com.tudai.aw.ms_monopatin.dto.ViajeDto;
import com.tudai.aw.ms_monopatin.model.Viaje;
import com.tudai.aw.ms_monopatin.service.ViajeService;

@RestController
@RequestMapping("viajes")
public class ViajeController {
	
	@Autowired
	private ViajeService viajeService;
	
	@GetMapping("/entre/{mes1}/a/{mes2}/anio/{anio}")
	public ResponseEntity<?> obtenerFacturacionEntreLosMeses(@PathVariable int mes1, @PathVariable int mes2, @PathVariable int anio) {
		try{
			return ResponseEntity.status(HttpStatus.OK).body(viajeService.obtenerFacturacionEntreLosMeses(mes1, mes2, anio));
		}catch (Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. No existen viajes, revise los campos e intente nuevamente.\"}");
		}
	}
	
	@PostMapping("")
    public ResponseEntity<?> guardar(@RequestBody ViajeDto dto) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(viajeService.guardar(dto));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. No se pudo guardar el viaje, revise los campos e intente nuevamente.\"}");
        }
    }
	
	@DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(viajeService.eliminar(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. El viaje que usted quiere borrar no existe.\"}");
        }
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<?> obtenerPorId(@PathVariable Long id) {
		try{
            return ResponseEntity.status(HttpStatus.OK).body(viajeService.obtenerPorId(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. No existe viaje con el id ingresado, revise el campo e intente nuevamente.\"}");
        }
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@RequestBody Viaje viaje, @PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(viajeService.actualizar(viaje, id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. No se pudo actualizar el viaje, revise los campos e intente nuevamente.\"}");
        }
    }
}
