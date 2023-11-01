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
		
		Viaje v1 = new Viaje(m1, 1L, LocalDateTime.of(2023, 8, 7, 12, 34), LocalDateTime.of(2023, 8, 7, 12, 45), 12, 0L, false, null);
		Viaje v2 = new Viaje(m1, 2L, LocalDateTime.of(2023, 9, 19, 9, 2), LocalDateTime.of(2023, 9, 19, 9, 24), 10, 5L, true, LocalDateTime.of(2023, 9, 19, 9, 7));
		Viaje v3 = new Viaje(m2, 1L, LocalDateTime.of(2023, 10, 23, 11, 22), LocalDateTime.of(2023, 10, 23, 11, 46), 12, 16L, true, LocalDateTime.of(2023, 10, 23, 11, 26));
		
		viajeRepository.save(v1);
		viajeRepository.save(v2);
		viajeRepository.save(v3);
		
	}
}
