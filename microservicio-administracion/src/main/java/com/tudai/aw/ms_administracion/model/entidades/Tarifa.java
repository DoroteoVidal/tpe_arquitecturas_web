package com.tudai.aw.ms_administracion.model.entidades;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	
	@Column(name = "valor_agregado_por_pausa")
	private double valorAgregadoPorPausa;
	
	@Column(nullable = false)
	private LocalDate fechaVigencia;
	
	public Tarifa() {}

	public Tarifa(String clave, double valor, double valorAgregadoPorPausa, LocalDate fechaVigencia) {
		super();
		this.clave = clave;
		this.valor = valor;
		this.valorAgregadoPorPausa = valorAgregadoPorPausa;
		this.fechaVigencia = fechaVigencia;
	}
	
}
