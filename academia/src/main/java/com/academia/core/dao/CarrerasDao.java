package com.academia.core.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.academia.core.entidad.Carreras;

@Repository
public interface CarrerasDao extends JpaRepository<Carreras, Serializable> {
	
	/*
	 *Consulta y Extraccion de todos los datos que contenga la tabla Carreras en la base de datos 
	 *y pasarlo en una lista de tipo Carreras 
	*/
	public abstract List<Carreras> findAll();
	
	/*
	 * Consulta y extraccion de los datos que contenga la tabla carreras,
	 *  especificamente del nombre de la carrera, la cual es llamada desde el controlador
	 */
	public abstract Carreras findByNombreCarrera(String nombreCarrera);
	
	
	


}
