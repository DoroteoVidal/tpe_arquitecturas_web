package com.tudai.aw.ms_monopatin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tudai.aw.ms_monopatin.dto.MonopatinConViajesDto;
import com.tudai.aw.ms_monopatin.dto.MonopatinDto;
import com.tudai.aw.ms_monopatin.model.Monopatin;

public interface MonopatinRepository extends JpaRepository<Monopatin, Long> {
	
	@Query("SELECT new com.tudai.aw.ms_monopatin.dto.MonopatinDto(v.monopatin.id, SUM(v.kilometrosRecorridos)) "
			+ "FROM Viaje v  "
			+ "GROUP BY v.monopatin.id "
			+ "HAVING SUM(v.kilometrosRecorridos) BETWEEN :km1 AND :km2")
	public List<MonopatinDto> obtenerConRecorridosEntre(double km1, double km2);
	
	@Query("SELECT new com.tudai.aw.ms_monopatin.dto.MonopatinDto(v.monopatin.id, SUM(v.kilometrosRecorridos), SUM(v.tiempoPausa)) "
			+ "FROM Viaje v "
			+ "WHERE v.tiempoPausa > 0 "
			+ "GROUP BY v.monopatin.id")
	public List<MonopatinDto> obtenerConTiempoConPausa();
	
	@Query("SELECT new com.tudai.aw.ms_monopatin.dto.MonopatinDto(v.monopatin.id, SUM(v.kilometrosRecorridos)) "
			+ "FROM Viaje v "
			+ "WHERE v.tiempoPausa = 0 "
			+ "GROUP BY v.monopatin.id")
	public List<MonopatinDto> obtenerConTiempoSinPausa();
	
	@Query("SELECT new com.tudai.aw.ms_monopatin.dto.MonopatinConViajesDto(m.id, COUNT(v), FUNCTION('year', DATE(v.fechaHoraFin))) "
			+ "FROM Viaje v JOIN Monopatin m ON (v.monopatin.id = m.id) "
			+ "WHERE FUNCTION('year', DATE(v.fechaHoraFin)) = :anio "
			+ "GROUP BY m.id "
			+ "HAVING COUNT(v) > :viajes")
	public List<MonopatinConViajesDto> obtenerConViajesPorAnio(int viajes, int anio);
	
	@Query("SELECT COUNT(m) FROM Monopatin m WHERE m.estado = :estado")
	public Long obtenerCantidad(String estado);
	
	@Query("SELECT m FROM Monopatin m "
			+ "WHERE (m.estado = 'disponible') "
			+ "AND (m.latitud BETWEEN :latMin AND :latMax) "
			+ "AND (m.longitud BETWEEN :longMin AND :longMax)")
	public List<Monopatin> obtenerCercanosZona(double latMin, double latMax, double longMin, double longMax);

}
