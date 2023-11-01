package com.tudai.aw.ms_monopatin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tudai.aw.ms_monopatin.utils.CargaDatos;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class MicroservicioMonopatinApplication {
	
	@Autowired
	private CargaDatos datos;

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioMonopatinApplication.class, args);
	}
	
	@PostConstruct
	public void iniciar() {
		datos.cargar();
	}
	
}
