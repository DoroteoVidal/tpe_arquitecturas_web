package com.tudai.aw.ms_monopatin.dto;

import lombok.Getter;

@Getter
public class MonopatinConViajesDto {
	private Long id;
	private Long cantViajes;
	private Integer anio;
	
	public MonopatinConViajesDto() {}
	
	public MonopatinConViajesDto(Long id, Long cantViajes, Integer anio) {
		super();
		this.id = id;
		this.cantViajes = cantViajes;
		this.anio = anio;
	}
	
}
