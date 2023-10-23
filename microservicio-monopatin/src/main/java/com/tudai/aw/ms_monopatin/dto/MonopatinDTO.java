package com.tudai.aw.ms_monopatin.dto;

import lombok.Getter;

@Getter
public class MonopatinDTO {
	
	private String estado; //disponible, en uso, mantenimiento
	private Long gps;
	private double kilometrosRecorridos;
	
	public MonopatinDTO() {}
	
	public MonopatinDTO(String estado, Long gps, double kilometrosRecorridos) {
		super();
		this.estado = estado;
		this.gps = gps;
		this.kilometrosRecorridos = kilometrosRecorridos;
	}

}
