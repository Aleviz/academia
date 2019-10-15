package com.academia.core.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.academia.core.entidad.Carreras;
import com.academia.core.entidad.Materias;

@Repository
public interface MateriaDao extends JpaRepository<Materias, Serializable> {
	public abstract List<Materias> findByIdCarrera(Carreras nombre);
	
	/*
	 *Consulta y Extraccion de todos los datos que contenga la tabla materias en la base de datos 
	 *y pasarlo en una lista de tipo Materias 
	*/
	public abstract List<Materias> findAll();
	
	


}
