package com.tudai.aw.ms_administracion.model.clases;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Mantenimiento {
	private LocalDateTime fechaHoraInicio;
	private LocalDateTime fechaHoraFin;
	private Long idMonopatin;
	private boolean reparado;
	
	public Mantenimiento() {}
	
	public Mantenimiento(Mantenimiento m) {
		this.fechaHoraInicio = m.getFechaHoraInicio();
		this.fechaHoraFin = m.getFechaHoraFin();
		this.idMonopatin = m.getIdMonopatin();
		this.reparado = m.isReparado();
	}
}
