package com.academia.core.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.academia.core.dao.MantenimientoInstitucionRepository;
import com.academia.core.entidad.*;
import com.academia.core.modelo.*;


@Service
public class MantenimientoInstitucionService {

	
	//Inyeccion de MantenimientoInstitucionRepository
	@Autowired
	private MantenimientoInstitucionRepository mantInst;


// Declaraciones de variables a ocupar
	private List<Materias> listMat;
	private MateriasModelo matModel;
	private List<MateriasModelo> listMatModel;
	
	private Carreras car;
	private List<Carreras> listCar;
	private CarrerasModelo carModel;
	private List<CarrerasModelo> listCarreraModelo;
	
	private Profesores prof;
	private List<Profesores> listProf;
	private ProfesoresModelo profModel;
	private List<ProfesoresModelo> listProfModel;

	private EstudiantesModelo estModel;
	private List<EstudiantesModelo> listEstudModel;
	
	private Matriculas matricula;
	private List<Matriculas> listMatricula;


	private static final Log logger = LogFactory.getLog(MantenimientoInstitucionService.class);


	/*
	 * Este metodo generera una lista de tipo MatriculaModelo lo cual hace una consulta de busqueda por nombre
	 * en MantenimientoInstitucionRepository luego lo retorna al objecto car, y este lo pasa a otra
	 * consulta donde trae una lista dependiendo del nombre de la carrera, 
	 * tambien cuenta con logs, para identificar posibles errores , al igual que contiene try catch.
	 * @param nombreCarrera El parametro nombreCarrera trae el nombre de la carrera para hacer la consulta
	 * @return una lista de tipo MatriculaModelo hacia el controlador, dependiendo del nombre de la carrera.
	 */
	public List<MateriasModelo> mostrarMateriasPorCarrera(String nombreCarrera) {

		try {
			car = mantInst.findByNombreCarreras(nombreCarrera);
			listMat = mantInst.findMateria(car);
			listMatModel = new ArrayList<>();

			for (int i = 0; i < listMat.size(); i++) {
				matModel = new MateriasModelo();
				matModel.setIdMateria(String.valueOf(listMat.get(i).getIdMateria()));
				matModel.setNombreMateria(listMat.get(i).getNombreMateria());
				matModel.setCarrera(listMat.get(i).getIdCarrera().getNombreCarrera());
				listMatModel.add(matModel);
			}
			logger.info("Consultando las materias por carrera");
			return listMatModel;

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error en la consulta");
			return null;
		}
	}

	
	
	/*
	 * Este metodo generera una lista de tipo CarrerasModelo lo cual hace una consulta donde trae todos 
	 * los datos de la tabla carreras
	 * tambien cuenta con logs, para identificar posibles errores , al igual que contiene try catch.
	 * @return una lista de tipo CarrerasModelo hacia el controlador.
	 */
	public List<CarrerasModelo> findAllCarreras() {

		try {
			listCar = mantInst.findAllCarreras();
			listCarreraModelo = new ArrayList<>();
			for (int i = 0; i < listCar.size(); i++) {
				carModel = new CarrerasModelo();
				carModel.setIdCarrera(String.valueOf(listCar.get(i).getIdCarrera()));
				carModel.setCarrera(listCar.get(i).getNombreCarrera());
				carModel.setSeccion(listCar.get(i).getSeccion());
				listCarreraModelo.add(carModel);
			}
			logger.info("Consultando todas las carreras");
			return listCarreraModelo;

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error en la consulta de las carreras");
			return null;

		}
	}

	
	
	/*
	 * Este metodo generera una lista de tipo ProfesoresModelo lo cual hace una consulta donde trae todos 
	 * los datos de la tabla profesores
	 * tambien cuenta con logs, para identificar posibles errores , al igual que contiene try catch.
	 * @return una lista de tipo ProfesoresModelo hacia el controlador.
	 */
	public List<ProfesoresModelo> findAllProfesores() {

		try {
			listProf = mantInst.findAllProfesores();
			listProfModel = new ArrayList<>();
			for (int i = 0; i < listProf.size(); i++) {
				profModel = new ProfesoresModelo();
				profModel.setIdProfesor(String.valueOf(listProf.get(i).getIdProfesor()));
				profModel.setNombreProfesor(listProf.get(i).getNombres());
				profModel.setApellidoProfesor(listProf.get(i).getApellido());
				listProfModel.add(profModel);
			}
			logger.debug("Consultando a todos los profesores registrados");
			return listProfModel;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error en la consulta");
			return null;
		}
	}

	
	
	/*
	 * Este metodo generera una lista de tipo EstudiantesModelo lo cual hace una consulta de busqueda por el id
	 * de la carrera en MantenimientoInstitucionRepository,
	 * tambien cuenta con logs, para identificar posibles errores , al igual que contiene try catch.
	 * @param idCarrera El parametro idCarrera trae el id de la carrera para hacer la consulta
	 * @return una lista de tipo EstudiantesDao hacia el controlador, dependiendo del id de la carrera .
	 */

	public List<EstudiantesModelo> findEstudianteByCarrera(Integer idCarreras) {

		try {

			Carreras idCarrera = new Carreras();
			idCarrera.setIdCarrera(idCarreras);
			listMatricula = mantInst.findByIdCarrera(idCarrera);
			listEstudModel = new ArrayList<>();
			for (int i = 0; i < listMatricula.size(); i++) {
				estModel = new EstudiantesModelo();
				estModel.setIdEstudiante(String.valueOf(listMatricula.get(i).getIdEstudiante().getIdEstudiante()));
				estModel.setNombreEstudiante(listMatricula.get(i).getIdEstudiante().getNombres());
				estModel.setApellidoEstudiante(listMatricula.get(i).getIdEstudiante().getApellido());
				listEstudModel.add(estModel);
			}
			logger.info("Consultando los alumnos por carrera");
			return listEstudModel;

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error en la consulta");
			return null;
		}
	}

	
	/*
	 * Este metodo guarda un registro en la base de datos en la tabla matricula 
	 * tambien cuenta con logs, para identificar posibles errores , al igual que contiene try catch.
	 * @param matriculacion El parametro matriculacion trae todos los datos que se registraran en la base de datos de la tabla matriculas 
	 * @return un objeto de tipo Matriculas, hacia el controlador.
	 */
	public Matriculas saveMatricula(Matriculas matriculacion) {
		try {
			matricula = mantInst.saveMatricula(matriculacion);
			logger.info("Matricula registrada");
			return matricula;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error al guardar la matricula");
			return null;
		}
	}

	
	/*
	 * Este metodo guarda un registro en la base de datos en la tabla profesores 
	 * tambien cuenta con logs, para identificar posibles errores , al igual que contiene try catch.
	 * @param profesor El parametro profe trae todos los datos que se registraran en la base de datos tabla profesores 
	 * @return un objeto de tipo Profesores, hacia el controlador.
	 */
	public Profesores saveProfesor(Profesores profesor) {
		try {
			prof = mantInst.saveProfesor(profesor);
			logger.info("Profesor registrado");
			return prof;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error al guardar profesor");
			return null;
		}
	}

	
	/*
	 * Este metodo actualiza un registro en la base de datos en la tabla institucion 
	 * tambien cuenta con logs, para identificar posibles errores , al igual que contiene try catch.
	 * @param institucion El parametro institucion trae todos los datos que se actualizaran en la base de datos de la tabla institucion
	 * @return un objeto de tipo Institucion, hacia el controlador.
	 */
	public Institucion updateInstitucion(Institucion institucion) {
		try {

			Institucion institucionn = mantInst.updateNombreInstitucion(institucion);
			logger.info("Exito al actualizar el nombre de la institucion");
			return institucionn;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error al actualizar nombre de la insttucion");
			return null;
		}
	}


	/*
	 * Este metodo actualiza un registro en la base de datos en la tabla profesores 
	 * tambien cuenta con logs, para identificar posibles errores , al igual que contiene try catch.
	 * @param profesor El parametro profesor trae todos los datos que se actualizaran en la base de datos de la tabla profesores
	 * @return un objeto de tipo Profesores, hacia el controlador.
	 */
	public Profesores updateProfesor(Profesores profesor) {
		try {

			prof = mantInst.updateProfesor(profesor);
			logger.info("Exito al actualizar informacion del profesor");
			return prof;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error al actualizar profesor");
			return null;
		}
	}

}
