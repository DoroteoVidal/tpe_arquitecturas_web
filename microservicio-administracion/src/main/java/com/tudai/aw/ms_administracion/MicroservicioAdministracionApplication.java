package com.tudai.aw.ms_administracion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tudai.aw.ms_administracion.utils.CargaDatos;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class MicroservicioAdministracionApplication {
	
	@Autowired
	private CargaDatos datos;

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioAdministracionApplication.class, args);
	}
	
	@PostConstruct
	public void iniciar() {
		datos.cargar();
	}

}
