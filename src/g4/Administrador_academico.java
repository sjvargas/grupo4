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

public class Administrador_academico extends Usuario implements java.io.Serializable {
	
	//
	
	private List<Programacion_Academica> historial_de_progrmacion_academica;
	

	public Administrador_academico(String nombreUsuario, String nombre, String apellidoPaterno, String apellidoMaterno, String contrasena, Sexo sexo, int edad){
		super(nombreUsuario, nombre, apellidoPaterno, apellidoMaterno, contrasena, sexo, edad);

	}
	
	public void crear_programacion_academica(String periodo){
		main.U.UsarPeriodo(periodo);
		Programacion_Academica nueva_progra = new Programacion_Academica(periodo);
	}
	
	public void agregar_carrera(String decano, String facultad, String nombre){
		main.U.lista_carreras.add(new Carrera(decano,facultad, nombre));
	}
	
	public void agregar_ramo(String nombreRamo, String sigla,Carrera carrera, int creditos, String semestre_impartido,List<String> programa){
		

			Ramo nuevoRamo = new Ramo(nombreRamo, sigla, creditos, carrera, semestre_impartido);
			nuevoRamo.agregarPrograma(programa);
			main.U.lista_ramos.add(nuevoRamo);
			
	}
	
	public void AgregarPrerrequisito(String siglaRamo, String siglaPrerrequisito){
		main.U.GetRamo(siglaRamo).AgregarPrerrequisito(siglaPrerrequisito);
	}
	
	public void agregar_profesor(String nombreUsuario, String nombre, String apellidoPaterno, String apellidoMaterno, String contrasena, Sexo sexo, int edad, int sueldo, String facultad){
		Profesor nuevoProfesor = new Profesor(nombreUsuario, nombre, apellidoPaterno, apellidoMaterno, contrasena, sexo, edad, sueldo, facultad);
		main.U.lista_profesores.add(nuevoProfesor);

	}
	
	public void restringir_acceso_alumno(Alumno alumno){
		
		alumno.acceso = false;
		
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
			if(c.getNombreCarrera() == nombreCarrera){
				return c;
			}
		}
		return null;
	}

}
