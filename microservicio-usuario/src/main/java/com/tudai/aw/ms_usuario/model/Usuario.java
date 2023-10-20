package com.tudai.aw.ms_usuario.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
	
	@ManyToMany(mappedBy = "usuarios")
	private List<Cuenta> cuentas;
	
	public Usuario() {}

	public Usuario(String nombre, String apellido, Long telefono, String email, List<Cuenta> cuentas) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.email = email;
		this.cuentas = cuentas;
	}
	
	
}
