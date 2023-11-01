package com.tudai.aw.ms_usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tudai.aw.ms_usuario.utils.CargaDatos;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class MicroservicioUsuarioApplication {
	
	@Autowired
	private CargaDatos datos;

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioUsuarioApplication.class, args);
	}
	
	@PostConstruct
	public void iniciar() {
		datos.cargar();
	}

}
