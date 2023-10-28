package com.tudai.aw.ms_monopatin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tudai.aw.ms_monopatin.model.Viaje;

public interface ViajeRepository extends JpaRepository<Viaje, Long> {
	
	@Query("SELECT v FROM Viaje v WHERE EXTRACT(YEAR FROM v.fechaHoraFin) = :anio AND EXTRACT(MONTH FROM v.fechaHoraFin) BETWEEN :mes1 AND :mes2")
	public List<Viaje> obtenerFacturacionEntreLosMeses(int mes1, int mes2, int anio);

}
