package com.tudai.aw.ms_administracion.model.dto;

import lombok.Getter;

@Getter
public class MonopatinConViajesDto {
	private Long id;
	private Long cantViajes;
	private Long anio;
	
	public MonopatinConViajesDto() {}
	
	public MonopatinConViajesDto(Long id, Long cantViajes, Long anio) {
		super();
		this.id = id;
		this.cantViajes = cantViajes;
		this.anio = anio;
	}
}
