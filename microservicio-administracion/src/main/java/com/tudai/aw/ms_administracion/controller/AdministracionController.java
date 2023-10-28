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

import com.tudai.aw.ms_administracion.model.clases.Monopatin;
import com.tudai.aw.ms_administracion.model.clases.Parada;
import com.tudai.aw.ms_administracion.model.entidades.Administrador;
import com.tudai.aw.ms_administracion.service.AdministracionService;
import com.tudai.aw.ms_administracion.service.TarifaService;

@RestController
@RequestMapping("administradores")
public class AdministracionController {
	
	@Autowired
	private AdministracionService administracionService;
	
	@Autowired
	private TarifaService tarifaService;
	
	//ABM monopatines
	
	@PostMapping("/monopatines")
    public ResponseEntity<?> guardarMonopatin(@RequestBody Monopatin monopatin) {
		return ResponseEntity.status(HttpStatus.OK).body(administracionService.guardarMonopatin(monopatin));       
    }
	
	@PutMapping("/monopatines/iniciarMantenimiento/{id}")
    public ResponseEntity<?> iniciarMantenimientoMonopatin(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(administracionService.iniciarMantenimientoMonopatin(id));       
    }
	
	@PutMapping("/monopatines/finalizarMantenimiento/{id}")
    public ResponseEntity<?> finalizarMantenimientoMonopatin(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(administracionService.finalizarMantenimientoMonopatin(id));       
    }
	
	@DeleteMapping("/monopatines/{id}")
	public ResponseEntity<?> eliminarMonopatin(@PathVariable Long id) {
		return administracionService.eliminarMonopatin(id);
	}
	
	@GetMapping("monopatines/reportesPorKm/{km1}/a/{km2}")
	public ResponseEntity<?> generarReportesDeMonopatinesPorKm(@PathVariable double km1, @PathVariable double km2) {
		return ResponseEntity.status(HttpStatus.OK).body(administracionService.generarReportesDeMonopatinesPorKm(km1, km2));  
	}
	
	@GetMapping("monopatines/reportesPorTiempoConPausa")
	public ResponseEntity<?> generarReportesDeMonopatinesPorTiempoConPausa() {
		return ResponseEntity.status(HttpStatus.OK).body(administracionService.generarReportesDeMonopatinesPorTiempoConPausa());  
	}
	
	@GetMapping("monopatines/reportesPorTiempoSinPausa")
	public ResponseEntity<?> generarReportesDeMonopatinesPorTiempoSinPausa() {
		return ResponseEntity.status(HttpStatus.OK).body(administracionService.generarReportesDeMonopatinesPorTiempoSinPausa());  
	}
	
	@GetMapping("monopatines/cantidadDeViajes/{viajes}/anio/{anio}")
	public ResponseEntity<?> obtenerMonopatinesConViajesPorAnio(@PathVariable int viajes, @PathVariable int anio) {
		return ResponseEntity.status(HttpStatus.OK).body(administracionService.obtenerMonopatinesConViajesPorAnio(viajes, anio));  
	}
	
	@GetMapping("/tarifas/totalFacturadoDe/{mes1}/a/{mes2}/enAnio/{anio}")
	public ResponseEntity<?> obtenerFacturacionEntreLosMeses(@PathVariable int mes1, @PathVariable int mes2, @PathVariable int anio) {
		return ResponseEntity.status(HttpStatus.OK).body(tarifaService.obtenerFacturacionEntreLosMeses(mes1, mes2, anio));
	}
	
	
	//ABM paradas
	
	@PostMapping("/paradas")
    public ResponseEntity<?> guardarParada(@RequestBody Parada parada) {
        return ResponseEntity.status(HttpStatus.OK).body(administracionService.guardarParada(parada));       
    }
	
	@DeleteMapping("/paradas/{id}")
	public ResponseEntity<?> eliminarParada(@PathVariable Long id) {
		return administracionService.eliminarParada(id);
	}
	
	//ABM usuarios
	
	@DeleteMapping("/cuentas/{id}")
	public ResponseEntity<?> anularCuenta(@PathVariable Long id) {
		return administracionService.anularCuenta(id);
	}
	
	//ABM administrador
	
	@PostMapping("")
    public ResponseEntity<?> guardar(@RequestBody Administrador administrador) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(administracionService.guardar(administrador));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. No se pudo guardar el administrador, revise los campos e intente nuevamente.\"}");
        }
    }
	
	@DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(administracionService.eliminar(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. El administrador que usted quiere borrar no existe.\"}");
        }
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<?> obtenerPorId(@PathVariable Long id) {
		try{
            return ResponseEntity.status(HttpStatus.OK).body(administracionService.obtenerPorId(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. No existe administrador con el id ingresado, revise el campo e intente nuevamente.\"}");
        }
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@RequestBody Administrador administrador, @PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(administracionService.actualizar(administrador, id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. No se pudo actualizar el administrador, revise los campos e intente nuevamente.\"}");
        }
    }
}
