package com.academia.core.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.academia.core.entidad.Carreras;
import com.academia.core.entidad.Matriculas;
@Repository
public interface MatriculaDao extends JpaRepository<Matriculas, Serializable> {
	
	/*
	 * Consulta y extraccion de los datos que contenga la tabla materias,
	 *  especificamente del id de la materias, la cual es llamada desde el controlador
	 */
	public abstract Matriculas findByIdMatricula(Integer idMatricula);
	
	/*
	 * Consulta y extraccion de los datos que contenga la tabla matriculas,
	 *  especificamente el id de la carrera, la cual es llamada desde el controlador 
	 */
	public abstract List<Matriculas> findByIdCarrera(Carreras idCarrera);
}
