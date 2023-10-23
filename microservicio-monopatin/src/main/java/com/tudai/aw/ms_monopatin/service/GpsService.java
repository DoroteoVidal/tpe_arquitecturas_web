package com.tudai.aw.ms_monopatin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tudai.aw.ms_monopatin.model.Gps;
import com.tudai.aw.ms_monopatin.repository.GpsRepository;

import jakarta.transaction.Transactional;

@Service("GpsService")
public class GpsService {
	
	@Autowired
	private GpsRepository gpsRepository;
	
	@Transactional
    public Gps save(Gps gps) throws Exception {
        try{
            return gpsRepository.save(gps);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
