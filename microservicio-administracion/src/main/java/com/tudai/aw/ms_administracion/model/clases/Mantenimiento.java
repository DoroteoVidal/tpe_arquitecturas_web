package com.tudai.aw.ms_administracion.model.clases;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class Mantenimiento implements Serializable {
	private Long id;
	private LocalDateTime fechaHoraInicio;
	private LocalDateTime fechaHoraFin;
	private Long idMonopatin;
	private boolean reparado;
	
	public Mantenimiento() {}
	
	public Mantenimiento(Mantenimiento m) {
		this.id = m.getId();
		this.fechaHoraInicio = m.getFechaHoraInicio();
		this.fechaHoraFin = m.getFechaHoraFin();
		this.idMonopatin = m.getIdMonopatin();
		this.reparado = m.isReparado();
	}
}
