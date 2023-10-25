package com.tudai.aw.ms_monopatin.dto;

import lombok.Getter;

@Getter
public class MonopatinDTO {
	
	private String estado; //disponible, en uso, mantenimiento
	private Long idGps;
	private double kilometrosRecorridos;
	
	public MonopatinDTO() {}
	
	public MonopatinDTO(String estado, Long idGps, double kilometrosRecorridos) {
		super();
		this.estado = estado;
		this.idGps = idGps;
		this.kilometrosRecorridos = kilometrosRecorridos;
	}

}
