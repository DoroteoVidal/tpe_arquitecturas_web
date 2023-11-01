package com.tudai.aw.ms_administracion.model.clases;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class Viaje implements Serializable {
	private Monopatin monopatin;
	private Long idUsuario;
	private LocalDateTime fechaHoraInicio;
	private LocalDateTime fechaHoraFin;
	private double kilometrosRecorridos;
	private Long tiempoPausa;
	private boolean pausa;
	private LocalDateTime inicioPausa;
	
	public Viaje() {}
	
	public Viaje(Viaje v) {
		this.monopatin = v.getMonopatin();
		this.idUsuario = v.getIdUsuario();
		this.fechaHoraInicio = v.getFechaHoraInicio();
		this.fechaHoraFin = v.getFechaHoraFin();
		this.kilometrosRecorridos = v.getKilometrosRecorridos();
		this.tiempoPausa = v.getTiempoPausa();
		this.pausa = v.isPausa();
		this.inicioPausa = v.getInicioPausa();
	}
}
