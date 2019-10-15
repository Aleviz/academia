package com.academia.core.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.academia.core.entidad.Profesores;

@Repository
public interface ProfesoresDao extends JpaRepository<Profesores, Serializable> {
	/*
	 *Consulta y Extraccion de todos los datos que contenga la tabla profesores en la base de datos 
	 *y pasarlo en una lista de tipo Profesores 
	*/
	public abstract List<Profesores> findAll();
	
	/*
	 * Consulta y extraccion de los datos que contenga la tabla profesores ,
	 *  especificamente el id de la profesores, la cual es llamada desde el controlador
	 */
	public abstract Profesores findByIdProfesor(Integer idProfesor);

	
	


}
