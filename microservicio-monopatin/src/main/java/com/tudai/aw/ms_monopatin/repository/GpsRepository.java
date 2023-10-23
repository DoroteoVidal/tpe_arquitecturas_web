package com.tudai.aw.ms_monopatin.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tudai.aw.ms_monopatin.model.Gps;

public interface GpsRepository extends JpaRepository<Gps, Long> {
	
	@Query("SELECT g FROM Gps g WHERE g.id = :id")
	public Optional<Gps> obtenerPorId(Long id);
}
