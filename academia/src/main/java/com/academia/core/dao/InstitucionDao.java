package com.academia.core.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academia.core.entidad.Institucion;

public interface InstitucionDao extends JpaRepository<Institucion, Serializable> {
	public abstract Institucion findByIdInstitucion(Integer idInstitucion);

}
