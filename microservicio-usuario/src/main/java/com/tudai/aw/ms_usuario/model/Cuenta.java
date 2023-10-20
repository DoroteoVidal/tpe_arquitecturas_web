package com.tudai.aw.ms_usuario.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
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
	
	@Column(name = "fecha_de_alta")
	private Date fechaDeAlta;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_mercado_pago")
	private MercadoPago mercadoPago;
	
	@ManyToMany
	private List<Usuario> usuarios;

	public Cuenta() {}

	public Cuenta(double dinero, MercadoPago mercadoPago, List<Usuario> usuarios) {
		super();
		this.dinero = dinero;
		this.fechaDeAlta = Date.valueOf(LocalDate.now());
		this.mercadoPago = mercadoPago;
		this.usuarios = usuarios;
	}	
	
}
