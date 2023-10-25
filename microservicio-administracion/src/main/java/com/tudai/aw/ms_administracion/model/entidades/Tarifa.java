package com.tudai.aw.ms_administracion.model.entidades;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
public class Tarifa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String clave;
	
	@Column
	private double valor;
	
	@Column
	private double valorAgregadoPorPausa;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date fechaVigencia;
	
	public Tarifa() {}

	public Tarifa(String clave, double valor, double valorAgregadoPorPausa, Date fechaVigencia) {
		super();
		this.clave = clave;
		this.valor = valor;
		this.valorAgregadoPorPausa = valorAgregadoPorPausa;
		this.fechaVigencia = fechaVigencia;
	}
	
}
