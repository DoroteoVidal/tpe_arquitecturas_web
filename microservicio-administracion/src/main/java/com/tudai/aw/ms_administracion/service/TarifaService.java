package com.tudai.aw.ms_administracion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tudai.aw.ms_administracion.model.entidades.Tarifa;
import com.tudai.aw.ms_administracion.repository.TarifaRepository;

import jakarta.transaction.Transactional;

@Service("TarifaService")
public class TarifaService {
	
	@Autowired
	private TarifaRepository tarifaRepository;
	
	@Transactional
	public Tarifa guardar(Tarifa tarifa) throws Exception {
		try{
            return tarifaRepository.save(tarifa);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
	}

	@Transactional
    public boolean eliminar(Long id) throws Exception {
        try{
            if(tarifaRepository.existsById(id)){
            	tarifaRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
	
	@Transactional
	public Tarifa obtenerPorId(Long id) throws Exception {
		try {
			return tarifaRepository.findById(id).get();
		}catch (Exception e){
            throw new Exception(e.getMessage());
        }
	}
	
	@Transactional
    public Tarifa actualizar(Tarifa tarifa, Long id) throws Exception {
        try{
        	Tarifa busqueda = tarifaRepository.findById(id).get();
            
        	busqueda.setClave(tarifa.getClave());
        	busqueda.setValor(tarifa.getValor());
        	busqueda.setValorAgregadoPorPausa(tarifa.getValorAgregadoPorPausa());
        	busqueda.setFechaVigencia(tarifa.getFechaVigencia());
        	
            return busqueda;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
	
	@Transactional
    public Tarifa agregarTarifaExtra(double extra, Long id) throws Exception {
        try{
        	Tarifa busqueda = tarifaRepository.findById(id).get();          
        	busqueda.setValorAgregadoPorPausa(extra);       	
            return busqueda;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
	}
	
}
