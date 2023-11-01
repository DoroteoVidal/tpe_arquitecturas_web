package com.tudai.aw.ms_administracion.utils;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tudai.aw.ms_administracion.model.entidades.Tarifa;
import com.tudai.aw.ms_administracion.repository.TarifaRepository;

@Component
public class CargaDatos {
	
	@Autowired
	private TarifaRepository tarifaRepository;
	
	public void cargar() {
		Tarifa t1 = new Tarifa("tarf02-21", 6.3, 2.8, LocalDate.of(2023, 8, 2));
		Tarifa t2 = new Tarifa("tarf02-22", 6.9, 3.1, LocalDate.of(2023, 9, 4));
		Tarifa t3 = new Tarifa("tarf02-23", 7.5, 3.9, LocalDate.of(2023, 10, 4));
		
		tarifaRepository.save(t1);
		tarifaRepository.save(t2);
		tarifaRepository.save(t3);
	}

}
