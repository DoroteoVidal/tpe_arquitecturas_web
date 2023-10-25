package com.tudai.aw.ms_administracion.model.clases;

import java.io.Serializable;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class Monopatin implements Serializable {
	private String estado;
	private Long idGps;
	private double kilometrosRecorridos;
	
	public Monopatin() {}
	
	public Monopatin(Monopatin m) {
		this.estado = m.getEstado();
		this.idGps = m.getIdGps();
		this.kilometrosRecorridos = m.getKilometrosRecorridos();
	}
}
