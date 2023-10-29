package com.tudai.aw.ms_monopatin.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Monopatin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String estado; //disponible, en uso, en mantenimiento
	
	@Column(nullable = false)
	private double latitud;
	
	@Column(nullable = false)
	private double longitud;
	
	@Column(nullable = false)
	private String gps;
	
	@Column(nullable = false)
	private double kilometrosRecorridos;
	
	public Monopatin() {}

	public Monopatin(String estado, double latitud, double longitud, String gps, double kilometrosRecorridos) {
		super();
		this.estado = estado;
		this.latitud = latitud;
		this.longitud = longitud;
		this.gps = gps;
		this.kilometrosRecorridos = kilometrosRecorridos;
	}	
	
}
