package com.tudai.aw.ms_administracion.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tudai.aw.ms_administracion.model.entidades.Tarifa;

public interface TarifaRepository extends JpaRepository<Tarifa, Long> {
	
	@Query("SELECT t FROM Tarifa t "
			+ "WHERE t.fechaVigencia <= :fecha "
			+ "ORDER BY t.fechaVigencia DESC LIMIT 1")
	public Optional<Tarifa> obtenerTarifaVigente(LocalDate fecha);

}
