package com.tudai.aw.ms_monopatin.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
public class Viaje {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_monopatin")
	private Monopatin monopatin;
	
	@Column(name = "id_usuario")
	private Long idUsuario;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private LocalDateTime fechaHoraInicio;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private LocalDateTime fechaHoraFin;
	
	@Column(nullable = false)
	private double kilometrosRecorridos;
	
	@Column(nullable = false)
	private Long tiempoPausa; //tiempo de pausa en segundos
	
	@Column(nullable = false)
	private boolean pausa;

	public Viaje() {}

	public Viaje(Monopatin monopatin, Long idUsuario, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin, double kilometrosRecorridos, Long tiempoPausa, boolean pausa) {
		super();
		this.monopatin = monopatin;
		this.idUsuario = idUsuario;
		this.fechaHoraInicio = fechaHoraInicio;
		this.fechaHoraFin = fechaHoraFin;
		this.kilometrosRecorridos = kilometrosRecorridos;
		this.tiempoPausa = tiempoPausa;
		this.pausa = pausa;
	}
	
	
}
