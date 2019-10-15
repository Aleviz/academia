package com.academia.core.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Service;

import com.academia.core.entidad.*;


@Repository
public class MantenimientoInstitucionRepository {

	@Autowired
	MateriaDao md;

	@Autowired
	CarrerasDao cd;
	
	@Autowired
	ProfesoresDao pd;
	
	@Autowired
	EstudiantesDao ed;
	
	@Autowired
	MatriculaDao matriculaDao;

	@Autowired
	InstitucionDao insDao;
	
	
	//MATERIAS
	
	/*
	 * Metodo que devuelve una lista de todas las materias dependendiendo del nombre de la carrera
	 * @param nombre El parametro nombre trae todos los datos de la carrera para la busque de las materias.
	 * @return datos que trae de la consulta ya realizada en el MateriaDao
	 */
	public List<Materias> findMateria(Carreras nombre) {
		return md.findByIdCarrera(nombre);
	}
	
	
	/*
	 * Metodo que devuelve una lista de todas las carreras
	 * @return datos que trae de la consulta ya realizada en CarrerasDao
	 */	
	public List<Carreras> findAllCarreras() {
		return cd.findAll();
	}
	
	
	
	/*
	 * Metodo que devuelve datos especificos dependendiendo del nombre de la carrera
	 * @param nombreCarrera El parametro nombreCarrera trae todos los datos de la carrera.
	 * @return datos que trae de la consulta ya realizada en el repository CarrerasDao
	 */
	public Carreras findByNombreCarreras(String nombreCarrera) {
		return cd.findByNombreCarrera(nombreCarrera);
	}
	
	
	
	//PROFESORES
	/*
	 * Metodo que devuelve una lista de todas los Profesores
	 * @return datos que trae de la consulta ya realizada en ProfesoresDao
	 */
	public List<Profesores> findAllProfesores(){
		return pd.findAll();
	}
	
	/*
	 * Metodo que realiza actualizacion en sus datos en especifico a un solo profesor.
	 * @param prof El parametro prof trae todos los datos especificamente del profesor a editar.
	 * @return datos que trae de la actualizacion ya realizada en ProfesoresDao
	 */
	public Profesores updateProfesor(Profesores prof) {
		return pd.save(prof);	
	}
	
	/*
	 * Metodo que devuelve datos dependiendo del id del Profesor.
	 * @param id El parametro id trae el id del profesor a buscar.
	 * @return datos que trae de la consulta ya realizada en el ProfesoresDao
	 */
	public Profesores findByIdProfesor(Integer id) {
		System.out.println("idRepo "+id);
		return pd.findByIdProfesor(id);
	}

	/*
	 * Metodo que realiza un nuevo registro en la base de datos en la tabla profesores.
	 * @param prof El parametro prof trae todos los datos especificamente del profesor a registrar.
	 * @return datos que trae de la registro ya realizada en ProfesoresDao
	 */
	public Profesores saveProfesor(Profesores prof) {
		return pd.save(prof);
	}
	
	


	
	
	//ESTUDIANTES
	/*
	 * Metodo que devuelve una lista de todos los estudiantes.
	 * @return datos que trae de la consulta ya realizada en el EstudianteDao
	 */
	public List<Estudiantes> findAllEstudiantes(){
		return ed.findAll();
	}
	
	
	
	//MATRICULAS

	/*
	 * Metodo que realiza un nuevo registro en la base de datos en la tabla matricula.
	 * @param matricula El parametro matricula trae todos los datos especificamente de la matricula a registrar.
	 * @return datos que trae de la registro ya realizada en MatriculaDao
	 */
	public Matriculas saveMatricula(Matriculas matricula) {
		return matriculaDao.save(matricula);	
	}
	
	/*
	 * Metodo que devuelve datos dependiendo del id de la carrera.
	 * @param idCarrera El parametro idCarrera trae el id de la carrera a buscar.
	 * @return datos que trae de la consulta ya realizada en el CarrerasDao
	 */
	public List<Matriculas> findByIdCarrera(Carreras idCarrera){
		return matriculaDao.findByIdCarrera(idCarrera);
	}
	
	
	
	
	
	//NOMBRE INSTITUCION
	/*
	 * Metodo que realiza actualizacion en sus datos, en especifico a un sola consulta de nombre_institucion.
	 * @param nombreInstitucion El parametro nombreInstitucion trae todos los datos especificamente de nombre_institucion a editar.
	 * @return datos que trae de la actualizacion ya realizada en InstitucionDao
	 */
	public Institucion updateNombreInstitucion(Institucion institucion) {
		return insDao.save(institucion);
	}
	
	/*
	 * Metodo que devuelve datos dependiendo del id de la Institucion.
	 * @param id El parametro id trae el id de la institucion a buscar.
	 * @return datos que trae de la consulta ya realizada en el InstitucionDao
	 */
	public Institucion findByIdInstitucion(Integer id) {
		return insDao.findByIdInstitucion(id);
	}
}
