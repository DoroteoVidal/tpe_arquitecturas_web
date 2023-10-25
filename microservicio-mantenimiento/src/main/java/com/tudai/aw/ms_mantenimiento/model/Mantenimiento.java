package com.tudai.aw.ms_mantenimiento.model;

import java.sql.Date;

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
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date fechaHoraInicio;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date fechaHoraFin;
	
	@Column(name = "id_monopatin")
	private Long idMonopatin;
	
	@Column(nullable = false)
	private boolean reparado;
	
	public Mantenimiento () {}
	
	public Mantenimiento (Date fechaHoraInicio, Date fechaHoraFin, Long idMonopatin, boolean reparado) {
		this.fechaHoraInicio = fechaHoraInicio;
		this.fechaHoraFin = fechaHoraFin;
		this.idMonopatin = idMonopatin;
		this.reparado = reparado;
	}
}

