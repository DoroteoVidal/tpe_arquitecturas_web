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
	private boolean disponible;
	
	@Column(nullable = false)
	private double latitud;
	
	@Column(nullable = false)
	private double longitud;
	
	@Column(nullable = false)
	private String idGps;
	
	@Column(nullable = false)
	private double kilometrosRecorridos;
	
	public Monopatin() {}
	
	public Monopatin(boolean disponible, double latitud, double longitud, String idGps, double kilometrosRecorridos) {
		super();
		this.disponible = disponible;
		this.latitud = latitud;
		this.longitud = longitud;
		this.idGps = idGps;
		this.kilometrosRecorridos = kilometrosRecorridos;
	}
	
}
