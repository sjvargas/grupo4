package g4;

import java.util.ArrayList;
import java.util.List;

/*
 * 
 * 
 * 12.	Clase Administrador_academico:
 *  Clase que no tiene atributos, puede realizar todas las modificaciones a las mallas y cursos,
 *   además de fijar los límites de créditos de la universidad.
 * 
 */

public class Administrador_academico extends Usuario {
	
	//
	
	private List<Programacion_Academica> historial_de_progrmacion_academica;
	
	private List<Carrera> lista_carreras;
	private List<Ramo> lista_ramos;
	private List<Profesor> lista_profesores;
	private List<Alumno> lista_alumnos_restringidos;
	
	
	public Administrador_academico(String nombreUsuario, String nombre, String apellidoPaterno, String apellidoMaterno, String contrasena, Sexo sexo, int edad){
		super(nombreUsuario, nombre, apellidoPaterno, apellidoMaterno, contrasena, sexo, edad);
		historial_de_progrmacion_academica = new ArrayList<Programacion_Academica>();
		lista_carreras = new ArrayList<Carrera>();
		lista_profesores = new ArrayList<Profesor>();
		lista_ramos = new ArrayList<Ramo>();
	}
	
	public void crear_programacion_academica(String periodo){
		Programacion_Academica nueva_progra = new Programacion_Academica(periodo);
	}
	
	public void agregar_carrera(String decano, String facultad, String nombre){
		
		Carrera nuevaCarrera = new Carrera(lista_carreras.size()+1,decano,facultad, nombre);
		
		lista_carreras.add(nuevaCarrera);
	}
	
	public void agregar_ramo(String sigla,Carrera carrera, int creditos, String semestre_impartido,String contenidos,String objetivos){
		

			Ramo nuevoRamo = new Ramo( sigla, creditos, carrera, semestre_impartido, contenidos, objetivos);
			lista_ramos.add(nuevoRamo);
			
	}
	
	public void agregar_profesor(String nombreUsuario, String nombre, String apellidoPaterno, String apellidoMaterno, String contrasena, Sexo sexo, int edad, int sueldo, String facultad){
		Profesor nuevoProfesor = new Profesor(nombreUsuario, nombre, apellidoPaterno, apellidoMaterno, contrasena, sexo, edad, sueldo, facultad);
		lista_profesores.add(nuevoProfesor);
	}
	
	public void restringir_acceso_alumno(Alumno alumno){
		
		lista_alumnos_restringidos.add(alumno);
		
	}
	
	public List<Carrera> getListaCarrera(){
		return this.lista_carreras;
	}
	
	public Carrera GetCarrera(int id_Carrera){
		for(Carrera c : lista_carreras){
			if(c.getId_carrera() == id_Carrera){
				return c;
			}
		}
		return null;
	}
	
	public Carrera GetCarrera(String nombreCarrera){
		for(Carrera c : lista_carreras){
			if(c.getnombre_carrera() == nombreCarrera){
				return c;
			}
		}
		return null;
	}

}
