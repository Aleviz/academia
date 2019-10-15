package com.academia.core.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.academia.core.entidad.Estudiantes;
@Repository
public interface EstudiantesDao extends JpaRepository<Estudiantes, Serializable> {
	
	/*
	 *Consulta y Extraccion de todos los datos que contenga la tabla estudiantes en la base de datos
	 * y pasarlo en una lista de tipo Estudiantes 
	*/
	public abstract List<Estudiantes> findAll();
}
