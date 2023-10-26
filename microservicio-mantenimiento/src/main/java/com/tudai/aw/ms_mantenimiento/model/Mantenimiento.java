package com.tudai.aw.ms_mantenimiento.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
public class Mantenimiento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private LocalDateTime fechaHoraInicio;
	
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime fechaHoraFin;
	
	@Column(name = "id_monopatin", nullable = false)
	private Long idMonopatin;
	
	@Column(nullable = false)
	private boolean reparado;
	
	public Mantenimiento () {}
	
	public Mantenimiento (LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin, Long idMonopatin, boolean reparado) {
		this.fechaHoraInicio = fechaHoraInicio;
		this.fechaHoraFin = fechaHoraFin;
		this.idMonopatin = idMonopatin;
		this.reparado = reparado;
	}
}

