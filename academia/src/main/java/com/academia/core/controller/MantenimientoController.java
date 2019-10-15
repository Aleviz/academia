package com.academia.core.controller;



import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.academia.core.entidad.*;
import com.academia.core.modelo.*;
import com.academia.core.service.MantenimientoInstitucionService;


@RestController
@RequestMapping("/academia")
public class MantenimientoController {

	//Inyeccion del servicio MantenimientoInstitucionService
	@Autowired(required = true)
	MantenimientoInstitucionService mantenimientoService;
	
	
	//Variables a utilizar
	private List<CarrerasModelo> listCarrerasModel;
	private List<MateriasModelo> listMateriasModel;
	private List<ProfesoresModelo> listProfesoresModel;
	private List<EstudiantesModelo> listEstudianteModel;
	private Matriculas matricula;
	private Profesores profesor;
	private Institucion institucion;
	
	
	/*
	 * Este metodo muestra las materias dependiendo el nombre de la carrera
	 * @param nombreCarrera El parametro que es utilizado para hacer la consulta en el servicio.
	 * @return una lista de tipo MateriaModel en formato json las cuales contiene todos los datos de la materia dependiendo del nombre
	 */
	@RequestMapping( value = "/mostrarMaterias" , method = RequestMethod.GET)
	public ResponseEntity<List<MateriasModelo>> mostrarMateriasPorCarreras(@RequestParam String nombreCarrera) {
		listMateriasModel = mantenimientoService.mostrarMateriasPorCarrera(nombreCarrera);
		return new ResponseEntity<List<MateriasModelo>>(listMateriasModel ,HttpStatus.OK);
	}
	

	/*
	 * Este metodo muestra todas las carreras.
	 * @return una lista de tipo CarrerasModelo en formato json las cuales contiene todos los datos de la tabla carreras
	 */	
	@RequestMapping( value = "/mostrarCarreras" , method = RequestMethod.GET)
	public ResponseEntity<List<CarrerasModelo>> mostrarCarreras() {
		listCarrerasModel = mantenimientoService.findAllCarreras();
		return new ResponseEntity<List<CarrerasModelo>>(listCarrerasModel, HttpStatus.OK);
	}
	

	/*
	 * Este metodo muestra todas los profesores.
	 * @return una lista de tipo ProfesoresModelo en formato json las cuales contiene todos los datos de la tabla profesores
	 */	
	@RequestMapping( value = "/mostrarProfesores" , method = RequestMethod.GET)
	public ResponseEntity<List<ProfesoresModelo>> mostrarProfesores() {
		listProfesoresModel = mantenimientoService.findAllProfesores();
		return new ResponseEntity<List<ProfesoresModelo>>(listProfesoresModel, HttpStatus.OK);
		}
	
	
	
	/*
	 * Este metodo muestra los alumnos dependiendo del id de la carrera
	 * @param idCarrera El parametro es utilizado para hacer la consulta en el servicio.
	 * @return una lista de tipo EstudiantesModel en formato json las cuales contiene todos los datos de los alumnos dependiendo del id de la carrera
	 */	
	@RequestMapping( value = "/mostrarAlumnos/{idCarrera}" , method = RequestMethod.GET)
	public ResponseEntity<List<EstudiantesModelo>> mostrarAlumnos(@PathVariable Integer idCarrera) {
		listEstudianteModel = mantenimientoService.findEstudianteByCarrera(idCarrera);
		return new ResponseEntity<List<EstudiantesModelo>>(listEstudianteModel, HttpStatus.OK);
	}
	
	
	
	/*
	 * Este metodo registra a una nueva matricula en la base de datos.
	 * @return un objeto de tipo Matriculas en formato json las cuales contiene todos los datos de la nueva matricula registrada
	 */		
	@RequestMapping( value = "/saveMatricula" , method = RequestMethod.POST)
	public ResponseEntity<Matriculas> saveMatricula(@Valid @RequestBody Matriculas mat) {
		matricula =mantenimientoService.saveMatricula(mat);
		return new ResponseEntity<Matriculas>(matricula, HttpStatus.OK);
	}
	
	/*
	 * Este metodo registra a un nuevo profesor en la base de datos.
	 * @return un objeto de tipo Profesores en formato json las cuales contiene todos los datos del nuevo profesor registrada
	 */	
	@RequestMapping( value = "/saveProfesor" , method = RequestMethod.POST , consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Profesores> saveProfesor(@Valid @RequestBody Profesores prof) {
		profesor = mantenimientoService.saveProfesor(prof);
		return new ResponseEntity<>(profesor, HttpStatus.OK);
	}
	
	
	
	/*
	 * Este metodo actualiza a una institucion existente en la base de datos.
	 * @return un objeto de tipo Institucionen formato json las cuales contiene todos los nuevos datos de la institucion actualizado
	 */		
	@RequestMapping( value = "/updateInstitucion" , method = RequestMethod.PUT , consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Institucion> updateInstitucion(@Valid @RequestBody Institucion instituciones) {
		institucion = mantenimientoService.updateInstitucion(instituciones);
		return new ResponseEntity<>(institucion, HttpStatus.OK);		
	}
	
	/*
	 * Este metodo actualiza a una profesor existente en la base de datos.
	 * @return un objeto de tipo Profesor formato json las cuales contiene todos los nuevos datos del profesor actualizado
	 */		
	@RequestMapping( value = "/updateProfesor" , method = RequestMethod.PUT , consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Profesores> updateProfesor(@Valid @RequestBody Profesores prof) {
		profesor = mantenimientoService.saveProfesor(prof);
		return new ResponseEntity<>(profesor, HttpStatus.OK);
	}
	
	
	
	
	
	

	public MantenimientoInstitucionService getMantenimientoService() {
		return mantenimientoService;
	}


	public void setMantenimientoService(MantenimientoInstitucionService mantenimientoService) {
		this.mantenimientoService = mantenimientoService;
	}
	
	


	
	
	
	
}
