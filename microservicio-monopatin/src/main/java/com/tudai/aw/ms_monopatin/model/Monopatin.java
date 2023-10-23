package com.tudai.aw.ms_monopatin.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Monopatin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String estado; //disponible, en uso, mantenimiento
	
	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "id_gps")
	private Gps gps;
	
	@Column(nullable = false)
	private double kilometrosRecorridos;
	
	public Monopatin() {}
	
	public Monopatin(String estado, Gps gps, double kilometrosRecorridos) {
		super();
		this.estado = estado;
		this.gps = gps;
		this.kilometrosRecorridos = kilometrosRecorridos;
	}
	
}
