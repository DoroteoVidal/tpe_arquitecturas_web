package com.tudai.aw.ms_parada.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tudai.aw.ms_parada.model.Parada;
import com.tudai.aw.ms_parada.repository.ParadaRepository;

@Component
public class CargaDatos {
	
	@Autowired
	private ParadaRepository paradaRepository;
	
	public void cargar() {
		Parada p1 = new Parada(230, 124, "parada-238");
		Parada p2 = new Parada(890, 799, "parada-500");
		
		paradaRepository.save(p1);
		paradaRepository.save(p2);
	}

}
