package com.tudai.aw.ms_mantenimiento.controller;

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

import com.tudai.aw.ms_mantenimiento.model.Mantenimiento;
import com.tudai.aw.ms_mantenimiento.service.MantenimientoService;

@RestController
@RequestMapping("mantenimientos")
public class MantenimientoController {
	
	@Autowired
	private MantenimientoService mantenimientoService;
	
	@GetMapping("/monopatines/reportePorKm/{pausa}")
	public ResponseEntity<?> generarReporteMonopatinPorKm(@PathVariable int pausa) {
		return ResponseEntity.status(HttpStatus.OK).body(mantenimientoService.generarReporteMonopatinPorKm(pausa));
	}
	
	@GetMapping("/porIdMonopatin/{id}")
	public ResponseEntity<?> porIdMonopatin(@PathVariable Long id) {
		try{
            return ResponseEntity.status(HttpStatus.OK).body(mantenimientoService.obtenerPorIdMonopatin(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. No existe mantenimiento con el id de monopatin ingresado, revise el campo e intente nuevamente.\"}");
        }
	} 
	
	@PostMapping("")
	public ResponseEntity<?> guardar(@RequestBody Mantenimiento mantenimiento) {
		try{
			return ResponseEntity.status(HttpStatus.OK).body(mantenimientoService.guardar(mantenimiento));
		}catch (Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. No se pudo guardar el mantenimiento, revise los campos e intente nuevamente.\"}");
		}
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(mantenimientoService.eliminar(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. El mantenimiento que usted quiere borrar no existe.\"}");
        }
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<?> obtenerPorId(@PathVariable Long id) {
		try{
            return ResponseEntity.status(HttpStatus.OK).body(mantenimientoService.obtenerPorId(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. No existe mantenimiento con el id ingresado, revise el campo e intente nuevamente.\"}");
        }
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@RequestBody Mantenimiento mantenimiento, @PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(mantenimientoService.actualizar(mantenimiento, id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. No se pudo actualizar el mantenimiento, revise los campos e intente nuevamente.\"}");
        }
    }

}
