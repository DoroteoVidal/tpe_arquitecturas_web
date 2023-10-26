package com.tudai.aw.ms_usuario.model;

import jakarta.persistence.CascadeType;
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
public class Cuenta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private double dinero;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	public Cuenta() {}

	public Cuenta(double dinero, Usuario usuario) {
		super();
		this.dinero = dinero;	
		this.usuario = usuario;
	}	
	
}
