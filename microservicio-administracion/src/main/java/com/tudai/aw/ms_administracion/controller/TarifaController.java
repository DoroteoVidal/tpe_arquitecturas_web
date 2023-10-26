package com.tudai.aw.ms_administracion.controller;

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

import com.tudai.aw.ms_administracion.model.entidades.Tarifa;
import com.tudai.aw.ms_administracion.service.TarifaService;

@RestController
@RequestMapping("tarifas")
public class TarifaController {
	
	@Autowired
	private TarifaService tarifaService;
	
	@PostMapping("")
	public ResponseEntity<?> guardar(@RequestBody Tarifa tarifa) {
		try{
			return ResponseEntity.status(HttpStatus.OK).body(tarifaService.guardar(tarifa));
		}catch (Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. No se pudo guardar la tarifa, revise los campos e intente nuevamente.\"}");
		}
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(tarifaService.eliminar(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. La tarifa que usted quiere borrar no existe.\"}");
        }
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<?> obtenerPorId(@PathVariable Long id) {
		try{
            return ResponseEntity.status(HttpStatus.OK).body(tarifaService.obtenerPorId(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. No existe tarifa con el id ingresado, revise el campo e intente nuevamente.\"}");
        }
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@RequestBody Tarifa tarifa, @PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(tarifaService.actualizar(tarifa, id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. No se pudo actualizar la tarifa, revise los campos e intente nuevamente.\"}");
        }
    }
	
	@PutMapping("/agregarTarifaExtra/{id}")
    public ResponseEntity<?> agregarTarifaExtra(@RequestBody double extra, @PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(tarifaService.agregarTarifaExtra(extra, id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. No se pudo agregar la tarifa extra, revise los campos e intente nuevamente.\"}");
        }
    }
}
