package com.tudai.aw.ms_administracion.model.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Administrador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name = "rol_id")
	private Rol rol;
	
	public Administrador() {}

	public Administrador(String nombre, Rol rol) {
		super();
		this.nombre = nombre;
		this.rol = rol;
	}
	
}
