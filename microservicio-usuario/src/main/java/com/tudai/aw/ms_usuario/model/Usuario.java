package com.tudai.aw.ms_usuario.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nombre;
	
	@Column(nullable = false)
	private String apellido;
	
	@Column(nullable = false)
	private Long telefono;
	
	@Column(nullable = false)
	private String email;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_de_alta", nullable = false)
	private LocalDateTime fechaDeAlta;
	
	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
	private List<Cuenta> cuentas;
	
	public Usuario() {}

	public Usuario(String nombre, String apellido, Long telefono, String email, LocalDateTime fechaDeAlta) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.email = email;
		this.fechaDeAlta = fechaDeAlta;
		this.cuentas = new ArrayList<>();
	}
	
	
}
