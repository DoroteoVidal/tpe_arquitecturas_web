package com.tudai.aw.ms_parada;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tudai.aw.ms_parada.utils.CargaDatos;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class MicroservicioParadaApplication {
	
	@Autowired
	private CargaDatos datos;

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioParadaApplication.class, args);
	}
	
	@PostConstruct
	public void iniciar() {
		datos.cargar();
	}

}
