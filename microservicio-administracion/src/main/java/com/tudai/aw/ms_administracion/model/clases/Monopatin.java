package com.tudai.aw.ms_administracion.model.clases;

import java.io.Serializable;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class Monopatin implements Serializable {
	private String estado;
	private double latitud;
	private double longitud;
	private String gps;
	private double kilometrosRecorridos;
	
	public Monopatin() {}
	
	public Monopatin(Monopatin m) {
		this.estado = m.getEstado();
		this.latitud = m.getLatitud();
		this.longitud = m.getLongitud();
		this.gps = m.getGps();
		this.kilometrosRecorridos = m.getKilometrosRecorridos();
	}
}
