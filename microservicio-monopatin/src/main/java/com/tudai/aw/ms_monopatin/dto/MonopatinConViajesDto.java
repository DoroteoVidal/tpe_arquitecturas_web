package com.tudai.aw.ms_monopatin.dto;

import lombok.Getter;

@Getter
public class MonopatinConViajesDto {
	private Long id;
	private int cantViajes;
	private Long anio;
	
	public MonopatinConViajesDto() {}
	
	public MonopatinConViajesDto(Long id, int cantViajes, Long anio) {
		super();
		this.id = id;
		this.cantViajes = cantViajes;
		this.anio = anio;
	}
	
}
