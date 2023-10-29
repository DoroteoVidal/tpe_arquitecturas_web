package com.tudai.aw.ms_administracion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tudai.aw.ms_administracion.model.entidades.Tarifa;

public interface TarifaRepository extends JpaRepository<Tarifa, Long> {
	
	@Query("SELECT t FROM Tarifa t WHERE t.fechaVigencia <= CURRENT_TIMESTAMP ORDER BY t.fechaVigencia DESC LIMIT 1")
	public Tarifa obtenerTarifaVigente();

}
