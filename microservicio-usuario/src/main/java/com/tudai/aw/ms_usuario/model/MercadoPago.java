package com.tudai.aw.ms_usuario.model;

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
public class MercadoPago {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	@Column
	private double dinero;
	
	public MercadoPago() {}

	public MercadoPago(Usuario usuario, double dinero) {
		super();
		this.usuario = usuario;
		this.dinero = dinero;
	}
	
}
