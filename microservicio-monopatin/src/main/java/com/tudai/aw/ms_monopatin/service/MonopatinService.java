package com.tudai.aw.ms_monopatin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tudai.aw.ms_monopatin.dto.MonopatinDTO;
import com.tudai.aw.ms_monopatin.model.Gps;
import com.tudai.aw.ms_monopatin.model.Monopatin;
import com.tudai.aw.ms_monopatin.repository.GpsRepository;
import com.tudai.aw.ms_monopatin.repository.MonopatinRepository;

import jakarta.transaction.Transactional;

@Service("MonopatinService")
public class MonopatinService {
	
	@Autowired
	private MonopatinRepository monopatinRepository;
	
	@Autowired
	private GpsRepository gpsRepository;
	
	@Transactional
    public MonopatinDTO save(MonopatinDTO dto) throws Exception {	
        try{
        	Gps gps = gpsRepository.obtenerPorId(dto.getIdGps()).get();
    		Monopatin monopatin = new Monopatin(dto.getEstado(), gps, dto.getKilometrosRecorridos());
    		
            if(monopatinRepository.save(monopatin) != null) {
            	return dto;
            }
            
        	return null;
        	
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
	
	@Transactional
    public boolean delete(Long id) throws Exception {
        try{
            if(monopatinRepository.existsById(id)){
            	monopatinRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
	
	@Transactional
	public MonopatinDTO obtenerMonopatin(Long id) throws Exception {
		try {
			Monopatin m = monopatinRepository.findById(id).get();
			return new MonopatinDTO(m.getEstado(), m.getGps().getId(), m.getKilometrosRecorridos());
		}catch (Exception e){
            throw new Exception(e.getMessage());
        }
	}
	
	@Transactional
    public MonopatinDTO actualizar(MonopatinDTO dto, Long id) throws Exception {
        try{
            Monopatin monopatin = monopatinRepository.findById(id).get();
            Gps gps = gpsRepository.findById(dto.getIdGps()).get();
            monopatin = monopatinRepository.save(new Monopatin(dto.getEstado(), gps, dto.getKilometrosRecorridos()));   
            
            return new MonopatinDTO(monopatin.getEstado(), monopatin.getGps().getId(), monopatin.getKilometrosRecorridos());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
	
}
