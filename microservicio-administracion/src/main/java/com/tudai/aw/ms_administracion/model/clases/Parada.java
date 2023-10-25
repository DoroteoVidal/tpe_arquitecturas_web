package com.tudai.aw.ms_administracion.model.clases;

import java.io.Serializable;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class Parada implements Serializable {
	private double latitud;
	private double longitud;
	private String nombre;
	
	public Parada() {}
	
	public Parada(Parada p) {
		this.latitud = p.getLatitud();
		this.longitud = p.getLongitud();
		this.nombre = p.getNombre();
	}
}
