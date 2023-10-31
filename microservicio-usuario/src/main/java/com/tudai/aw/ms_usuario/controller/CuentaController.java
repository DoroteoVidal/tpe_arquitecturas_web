package com.tudai.aw.ms_usuario.controller;

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

import com.tudai.aw.ms_usuario.dto.CuentaDto;
import com.tudai.aw.ms_usuario.model.Cuenta;
import com.tudai.aw.ms_usuario.service.CuentaService;

@RestController
@RequestMapping("cuentas")
public class CuentaController {
	
	@Autowired
	private CuentaService cuentaService;
	
	@PutMapping("/anular/{id}")
	public ResponseEntity<?> anularCuenta(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(cuentaService.anularCuenta(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. No se pudo anular la cuenta. Por favor intente mas tarde.\"}");
        }
    }
	
	@PostMapping("")
    public ResponseEntity<?> guardar(@RequestBody CuentaDto dto) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(cuentaService.guardar(dto));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. No se pudo guardar la cuenta, revise los campos e intente nuevamente.\"}");
        }
    }
	
	@DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(cuentaService.eliminar(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. La cuenta que usted quiere borrar no existe.\"}");
        }
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<?> obtenerPorId(@PathVariable Long id) {
		try{
            return ResponseEntity.status(HttpStatus.OK).body(cuentaService.obtenerPorId(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. No existe cuenta con el id ingresado, revise el campo e intente nuevamente.\"}");
        }
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@RequestBody Cuenta cuenta, @PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(cuentaService.actualizar(cuenta, id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. No se pudo actualizar la cuenta, revise los campos e intente nuevamente.\"}");
        }
    }
}
