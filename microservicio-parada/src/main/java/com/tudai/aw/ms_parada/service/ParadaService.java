package com.tudai.aw.ms_parada.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tudai.aw.ms_parada.model.Parada;
import com.tudai.aw.ms_parada.repository.ParadaRepository;

import jakarta.transaction.Transactional;

@Service("ParadaService")
public class ParadaService {
	
	@Autowired
	private ParadaRepository paradaRepository;
	
	@Transactional
    public Parada save(Parada parada) throws Exception {
        try{
            return paradaRepository.save(parada);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
