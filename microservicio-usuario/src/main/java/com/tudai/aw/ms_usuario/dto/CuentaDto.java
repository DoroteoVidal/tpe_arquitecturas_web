package com.tudai.aw.ms_usuario.dto;

import lombok.Getter;

@Getter
public class CuentaDto {
	private double dinero;
	private Long idUsuario;
	private String estado;
	
	public CuentaDto() {}

	public CuentaDto(double dinero, Long idUsuario, String estado) {
		super();
		this.dinero = dinero;
		this.idUsuario = idUsuario;
		this.estado = estado;
	}
	
}
