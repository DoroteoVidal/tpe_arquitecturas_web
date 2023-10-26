package com.tudai.aw.ms_administracion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tudai.aw.ms_administracion.model.entidades.Administrador;

public interface AdministracionRepository extends JpaRepository<Administrador, Long> {

}
