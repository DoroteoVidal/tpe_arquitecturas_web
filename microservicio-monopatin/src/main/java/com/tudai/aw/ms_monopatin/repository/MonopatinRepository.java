package com.tudai.aw.ms_monopatin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tudai.aw.ms_monopatin.model.Monopatin;

public interface MonopatinRepository extends JpaRepository<Monopatin, Long> {
	
	@Query("SELECT m FROM Monopatin m WHERE m.kilometrosRecorridos BETWEEN :km1 AND :km2")
	public List<Monopatin> obtenerMonopatinesConRecorridosEntre(double km1, double km2);
	
	@Query("SELECT m FROM Viaje v JOIN v.monopatin m ON (v.monopatin.id = m.id) WHERE v.pausa = true AND v.tiempoPausa > 0")
	public List<Monopatin> obtenerMonopatinesConTiempoConPausa();
	
	@Query("SELECT m FROM Viaje v JOIN v.monopatin m ON (v.monopatin.id = m.id) WHERE v.pausa = false AND v.tiempoPausa = 0")
	public List<Monopatin> obtenerMonopatinesConTiempoSinPausa();

}
