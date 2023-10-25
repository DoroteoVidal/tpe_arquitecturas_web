package com.tudai.aw.ms_administracion.model.clases;

import java.io.Serializable;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class Gps implements Serializable {
	private double latitud;
	private double longitud;
	
	public Gps() {}
	
	public Gps(Gps gps) {
		this.latitud = gps.getLatitud();
		this.longitud = gps.getLongitud();	
	}
}
