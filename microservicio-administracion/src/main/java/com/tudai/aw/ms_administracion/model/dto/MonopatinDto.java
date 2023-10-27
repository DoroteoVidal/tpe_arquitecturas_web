package com.tudai.aw.ms_administracion.model.dto;

import lombok.Getter;

@Getter
public class MonopatinDto {
	private Long id;
	private double kilometrosRecorridos;
	private Long tiempoPausa;
	
	public MonopatinDto() {}
	
	public MonopatinDto(Long id, double kilometrosRecorridos, Long tiempoPausa) {
		super();
		this.id = id;
		this.kilometrosRecorridos = kilometrosRecorridos;
		this.tiempoPausa = tiempoPausa;
	}
	
	public MonopatinDto(Long id, double kilometrosRecorridos) {
		super();
		this.id = id;
		this.kilometrosRecorridos = kilometrosRecorridos;
	}
}
