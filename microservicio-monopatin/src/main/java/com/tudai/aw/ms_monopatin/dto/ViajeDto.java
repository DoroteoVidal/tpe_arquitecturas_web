package com.tudai.aw.ms_monopatin.dto;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class ViajeDto {
	private Long idMonopatin;
	private Long idUsuario;
	private LocalDateTime fechaHoraInicio;
	private LocalDateTime fechaHoraFin;
	private double kilometrosRecorridos;
	private Long tiempoPausa;
	private boolean pausa;
	private LocalDateTime inicioPausa;
	
	public ViajeDto() {}
	
	public ViajeDto(Long idMonopatin, Long idUsuario, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin,
			double kilometrosRecorridos, Long tiempoPausa, boolean pausa, LocalDateTime inicioPausa) {
		super();
		this.idMonopatin = idMonopatin;
		this.idUsuario = idUsuario;
		this.fechaHoraInicio = fechaHoraInicio;
		this.fechaHoraFin = fechaHoraFin;
		this.kilometrosRecorridos = kilometrosRecorridos;
		this.tiempoPausa = tiempoPausa;
		this.pausa = pausa;
		this.inicioPausa = inicioPausa;
	}
		
}
