package g4;

import java.util.ArrayList;
import java.util.List;

import fx.view.main;

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
	
	
	public Administrador_academico(String nom, String cont, String sex, int ed){
		
		
		super(nom, cont, sex, ed);
		

		historial_de_progrmacion_academica = new ArrayList<Programacion_Academica>();
	}
	
	public void crear_programacion_academica(String periodo){
		Programacion_Academica nueva_progra = new Programacion_Academica(periodo);
	}
	
	public void agregar_carrera(String decano, String facultad, String nombre){
		
		main.U.lista_carreras.add(new Carrera(main.U.lista_carreras.size()+1,decano,facultad, nombre));
	}
	
	public void agregar_ramo(String sigla,Carrera carrera, int creditos, String semestre_impartido,String contenidos,String objetivos){
		

			Ramo nuevoRamo = new Ramo( sigla, creditos, carrera, semestre_impartido, contenidos, objetivos);
			main.U.lista_ramos.add(nuevoRamo);
			
	}
	
	public void agregar_profesor(String nombre, String apellidos, int sueldo, String facultad){
		Profesor nuevoProfesor = new Profesor(main.U.lista_profesores.size()+1, nombre, apellidos, sueldo, facultad);
		
		main.U.lista_profesores.add(nuevoProfesor);
	}
	
	public void restringir_acceso_alumno(Alumno alumno){
		
		alumno.acceso= false;
		
	}
	
	public List<Carrera> getListaCarrera(){
		
		return main.U.lista_carreras;
	}
	
	public Carrera GetCarrera(int id_Carrera){
		for(Carrera c : main.U.lista_carreras){
			if(c.getId_carrera() == id_Carrera){
				return c;
			}
		}
		return null;
	}
	
	public Carrera GetCarrera(String nombreCarrera){
		for(Carrera c : main.U.lista_carreras){
			if(c.getnombre_carrera() == nombreCarrera){
				return c;
			}
		}
		return null;
	}

}
