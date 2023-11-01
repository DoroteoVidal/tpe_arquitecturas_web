package com.tudai.aw.ms_monopatin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tudai.aw.ms_monopatin.dto.ViajeDto;
import com.tudai.aw.ms_monopatin.model.Monopatin;
import com.tudai.aw.ms_monopatin.model.Viaje;
import com.tudai.aw.ms_monopatin.repository.MonopatinRepository;
import com.tudai.aw.ms_monopatin.repository.ViajeRepository;

import jakarta.transaction.Transactional;

@Service("ViajeService")
public class ViajeService {
	
	@Autowired
	private ViajeRepository viajeRepository;
	
	@Autowired
	private MonopatinRepository monopatinRepository;
	
	@Transactional
	public List<Viaje> obtenerFacturacionEntreLosMeses(int mes1, int mes2, int anio) throws Exception {
		try {
			return viajeRepository.obtenerFacturacionEntreLosMeses(mes1, mes2, anio);
		}catch (Exception e){
            throw new Exception(e.getMessage());
        }
	}
	
	@Transactional
    public Viaje guardar(ViajeDto dto) throws Exception {	
        try{    		
        	Monopatin m = monopatinRepository.findById(dto.getIdMonopatin()).get();
            return viajeRepository.save(new Viaje(m, dto.getIdUsuario(), dto.getFechaHoraInicio(), 
            		dto.getFechaHoraFin(), dto.getKilometrosRecorridos(), dto.getTiempoPausa(), dto.isPausa(), dto.getInicioPausa()));       	
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
	
	@Transactional
    public boolean eliminar(Long id) throws Exception {
        try{
            if(viajeRepository.existsById(id)){
            	viajeRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
	
	@Transactional
	public Viaje obtenerPorId(Long id) throws Exception {
		try {
			return viajeRepository.findById(id).get();
		}catch (Exception e){
            throw new Exception(e.getMessage());
        }
	}
	
	@Transactional
    public Viaje actualizar(Viaje viaje, Long id) throws Exception {
        try{
        	Viaje busqueda = viajeRepository.findById(id).get();
            
            busqueda.setMonopatin(viaje.getMonopatin());
            busqueda.setIdUsuario(viaje.getIdUsuario());
            busqueda.setFechaHoraInicio(viaje.getFechaHoraInicio());
            busqueda.setFechaHoraFin(viaje.getFechaHoraFin());
            busqueda.setKilometrosRecorridos(viaje.getKilometrosRecorridos());
            busqueda.setTiempoPausa(viaje.getTiempoPausa());
            busqueda.setPausa(viaje.isPausa());
            
            return busqueda;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
