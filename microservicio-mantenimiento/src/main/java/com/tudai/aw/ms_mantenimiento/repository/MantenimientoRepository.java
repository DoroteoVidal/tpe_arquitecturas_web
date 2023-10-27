package com.tudai.aw.ms_mantenimiento.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tudai.aw.ms_mantenimiento.model.Mantenimiento;

public interface MantenimientoRepository extends JpaRepository<Mantenimiento, Long> {
	
	@Query("SELECT m FROM Mantenimiento m WHERE m.idMonopatin = :id AND m.reparado = false")
	public Optional<Mantenimiento> obtenerPorIdMonopatin(Long id);

}
