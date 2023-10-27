package com.tudai.aw.ms_monopatin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tudai.aw.ms_monopatin.model.Monopatin;

public interface MonopatinRepository extends JpaRepository<Monopatin, Long> {
	
	@Query("SELECT m FROM Monopatin m WHERE m.kilometrosRecorridos BETWEEN :km1 AND :km2")
	public List<Monopatin> obtenerConRecorridosEntre(double km1, double km2);
	
	@Query("SELECT m.id, SUM(v.kilometrosRecorridos), SUM(v.tiempoPausa) "
			+ "FROM Viaje v JOIN v.monopatin m ON (v.monopatin.id = m.id) "
			+ "WHERE v.pausa = true AND v.tiempoPausa > 0")
	public List<Object[]> obtenerConTiempoConPausa();
	
	@Query("SELECT m.id, SUM(v.kilometrosRecorridos) "
			+ "FROM Viaje v JOIN v.monopatin m ON (v.monopatin.id = m.id) "
			+ "WHERE v.pausa = false AND v.tiempoPausa = 0")
	public List<Object[]> obtenerConTiempoSinPausa();
	
	@Query("SELECT m.id, COUNT(v), EXTRACT(YEAR FROM v.fechaHoraFin) "
			+ "FROM Viaje v JOIN v.monopatin m ON (v.monopatin.id = m.id) "
			+ "WHERE EXTRACT(YEAR FROM v.fechaHoraFin) = :anio "
			+ "GROUP BY m.id, EXTRACT(YEAR FROM v.fechaHoraFin) "
			+ "HAVING COUNT(v) > :viajes")
	public List<Object[]> obtenerConViajesPorAnio(int viajes, Long anio);

}
