package g4;

import java.util.ArrayList;
import java.util.List;

import fx.view.main;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;


/*
 * Clase Curso: Clase que cuenta con identificador único, 
 *  una lista de profesores que dan clases en el 
 *  curso, un numero asociado al semestre (primero o segundo),
 *  una lista de salas en las cuales se dicta (puede ser más de una, por ejemplo si hay sala de cátedra y otra de ayudantía),
 *  una lista de los horarios del curso y una lista de los alumnos del curso.
 *  Esta clase Permite (mediante sus métodos) agregar y eliminar profesores,
 *  obtener su identificador.
 * 
 * 
 * 
 */
public class Curso implements java.io.Serializable {

    private static int NextId = 0;
	public int id_curso;
	public List<Profesor> profesores;
	public int seccionCurso;
	public String periodo;
	public int creditos;
	public List<String> salas;
	public List<String> horario;
	public List<Alumno> lista_alumnos;
	public Ramo ramo;
	
	
	public Curso(String periodo,List<String> salas,List<String> horario, int creditos, int seccion , Profesor profesor, Ramo ramo){
		this.id_curso =NextId++;
		this.profesores = new ArrayList<Profesor>();
		profesores.add(profesor);
		this.seccionCurso = seccion;
		this.periodo = periodo;
		this.horario = horario;
		this.lista_alumnos = new ArrayList<Alumno>();
		this.creditos = creditos;
		this.ramo = ramo;
		this.salas = salas;
		
	//	profesores = new ArrayList<Profesor>();
	//	salas = new ArrayList<String>();
	//	horario = new ArrayList<String>();
		
	}
	

//// GETTERS de atributos
	public List<String> getHorario() {
		return horario;
	}
	public int getId_curso() {
		return id_curso;
	}
	public List<Alumno> getLista_alumnos() {
		return lista_alumnos;
	}
	public List<Profesor> getProfesores() {
		return profesores;
	}
	public List<String> getSalas() {
		return salas;
	}
	public String getPeriodo() {
		return periodo;
	}
	public int getSeccionCurso(){ return seccionCurso;}
	public int getCreditos(){ return creditos;}	
	public void agregar_profesor(Profesor profesor){
		// este metodo recibe un objeto de la case Profesor
		this.profesores.add(profesor);
		
		// este metodo agrega el profesor a la lista de profesores
		
	}
	public Ramo getRamo(){
		return this.ramo;
	}
	public String getNombreProfesorPrincipal(){
		return profesores.get(0).toString();
	}
	public String getNombreCurso(){ return ramo.getNombreRamo();}
	
	
	public void AgregarAlumno(Alumno alumno){
		lista_alumnos.add(alumno);
	}
	public void eliminar_profesor(int id_profesor){
		// este metodo recibe un indice que es un atributo del objeto de la case Profesor

		for(int i=0; i< profesores.size();i++){
			if((((Profesor)profesores.get(i)).GetEdad()) == id_profesor){
				profesores.remove(i);
				break;
			}
		}
		
		// este metodo elima al objeto de la clase profesor que tiene como atributo id el numero ingresado
	}	
	public ArrayList<TableColumn<Curso,?>> getColumn(TableView tabla){
		int i;
		ArrayList<TableColumn<Curso,?>> columns = new ArrayList<TableColumn<Curso,?>>();
		
		String[] columns_names = {"sigla", "secc","nombre","profesor","horario"};
		return columns;
	}
	
	 @Override
	 public String toString() {
		   return this.ramo.getNombreRamo()+"-"+this.seccionCurso;
	  }
	

}
