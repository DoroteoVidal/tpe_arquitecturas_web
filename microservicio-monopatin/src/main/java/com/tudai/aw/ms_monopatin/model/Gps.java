package com.tudai.aw.ms_monopatin.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Gps {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private double latitud;
	
	@Column(nullable = false)
	private double longitud;
	
	public Gps() {}

	public Gps(double latitud, double longitud) {
		super();
		this.latitud = latitud;
		this.longitud = longitud;
	}
	
}
