package com.tudai.aw.ms_usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tudai.aw.ms_usuario.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
