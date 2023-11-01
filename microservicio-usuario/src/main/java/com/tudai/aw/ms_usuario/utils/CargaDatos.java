package com.tudai.aw.ms_usuario.utils;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tudai.aw.ms_usuario.model.Cuenta;
import com.tudai.aw.ms_usuario.model.Usuario;
import com.tudai.aw.ms_usuario.repository.CuentaRepository;
import com.tudai.aw.ms_usuario.repository.UsuarioRepository;

@Component
public class CargaDatos {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private CuentaRepository cuentaRepository;
	
	public void cargar() {
		Usuario u1 = new Usuario("Juan", "Gutierrez", 2498754108L, "juang@hotmail.com", LocalDateTime.of(2023, 10, 14, 14, 1));
		Usuario u2 = new Usuario("Matias", "Fernandez", 2976216553L, "mati_fer21@hotmail.com", LocalDateTime.of(2023, 10, 13, 8, 1));
		Usuario u3 = new Usuario("Mariana", "Henriquez", 2973699102L, "marihen99@hotmail.com", LocalDateTime.of(2023, 8, 12, 18, 0));
		
		usuarioRepository.save(u1);
		usuarioRepository.save(u2);
		usuarioRepository.save(u3);
		
		Cuenta c1 = new Cuenta(3899, u2, "habilitada");
		Cuenta c2 = new Cuenta(3974, u3, "habilitada");
		
		cuentaRepository.save(c1);
		cuentaRepository.save(c2);
	}
}
