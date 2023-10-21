package com.tudai.aw.ms_mantenimiento.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

public class Mantenimiento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date fechaHoraInicio;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date fechaHoraFin;
	
	@Column(name = "id_monopatin")
	private Long idMonopatin;
}
