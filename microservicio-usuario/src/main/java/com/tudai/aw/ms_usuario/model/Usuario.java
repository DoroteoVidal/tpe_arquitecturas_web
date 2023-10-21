package com.tudai.aw.ms_usuario.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
	
	@Column(name = "fecha_de_alta")
	private Date fechaDeAlta;
	
	@OneToMany(mappedBy = "usuario")
	private List<Cuenta> cuentas;
	
	public Usuario() {}

	public Usuario(String nombre, String apellido, Long telefono, String email, Date fechaDeAlta) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.email = email;
		this.fechaDeAlta = fechaDeAlta;
		this.cuentas = new ArrayList<>();
	}
	
	
}
