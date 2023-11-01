package com.tudai.aw.ms_monopatin.utils;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tudai.aw.ms_monopatin.model.Monopatin;
import com.tudai.aw.ms_monopatin.model.Viaje;
import com.tudai.aw.ms_monopatin.repository.MonopatinRepository;
import com.tudai.aw.ms_monopatin.repository.ViajeRepository;

@Component
public class CargaDatos {
	
	@Autowired
	private MonopatinRepository monopatinRepository;
	
	@Autowired
	private ViajeRepository viajeRepository;
	
	public void cargar() {
		Monopatin m1 = new Monopatin("disponible", 230, 124, "gps-200", 0);
		Monopatin m2 = new Monopatin("disponible", 230, 124, "gps-201", 0);
		Monopatin m3 = new Monopatin("disponible", 298, 22, "gps-202", 0);
		Monopatin m4 = new Monopatin("disponible", 871, 231, "gps-203", 0);
		Monopatin m5 = new Monopatin("disponible", 651, 378, "gps-204", 0);
		
		monopatinRepository.save(m1);
		monopatinRepository.save(m2);
		monopatinRepository.save(m3);
		monopatinRepository.save(m4);
		monopatinRepository.save(m5);
		
		Viaje v1 = new Viaje(m1, 1L, LocalDateTime.of(2023, 8, 7, 12, 34), LocalDateTime.of(2023, 8, 7, 12, 45), 12, 0L, false);
		Viaje v2 = new Viaje(m1, 2L, LocalDateTime.of(2023, 9, 19, 9, 2), LocalDateTime.of(2023, 9, 19, 9, 24), 10, 5L, true);
		Viaje v3 = new Viaje(m2, 1L, LocalDateTime.of(2023, 10, 23, 11, 22), LocalDateTime.of(2023, 10, 23, 11, 46), 12, 16L, true);
		Viaje v4 = new Viaje(m3, 3L, LocalDateTime.of(2022, 3, 3, 10, 14), LocalDateTime.of(2022, 3, 3, 10, 22), 12, 2L, true);
		Viaje v5 = new Viaje(m3, 3L, LocalDateTime.of(2022, 12, 3, 20, 2), LocalDateTime.of(2022, 12, 3, 20, 10), 3, 0L, false);
		Viaje v6 = new Viaje(m3, 2L, LocalDateTime.of(2022, 4, 9, 12, 5), LocalDateTime.of(2022, 4, 9, 12, 13), 6, 0L, false);
		Viaje v7 = new Viaje(m4, 1L, LocalDateTime.of(2022, 9, 28, 21, 13), LocalDateTime.of(2022, 9, 28, 21, 21), 7, 0L, false);
		
		viajeRepository.save(v1);
		viajeRepository.save(v2);
		viajeRepository.save(v3);
		viajeRepository.save(v4);
		viajeRepository.save(v5);
		viajeRepository.save(v6);
		viajeRepository.save(v7);
		
	}
}
