package g4;

import java.util.List;


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
public class Curso {
	
	private int id_curso;
	
	private List<Profesor> profesores;
	
	private int semestre;
	
	private int creditos;
	
	private List<String> salas;
	
	private List<String> horario;
	
	private List<Alumno> lista_alumnos;
	
	
	public Curso(int id,int semestre,List<String> salas,List<String> horario, List<Alumno> Alumnos, int creditos){
		this.id_curso = id;
		//this.profesores = new List<Profesor>();
		this.semestre = semestre;
		this.horario = horario;
		this.lista_alumnos = Alumnos;
		this.creditos = creditos;
	}
	
////////////////////////////////////
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
	public int getSemestre() {
		return semestre;
	}
	public int GetCreditos(){ return creditos;}
	
	public void agregar_profesor(Profesor profesor){
		// este metodo recibe un objeto de la case Profesor
		this.profesores.add(profesor);
		
		// este metodo agrega el profesor a la lista de profesores
		
	}
	
	///////////////////////////////
	//////////////////////////////
	
	public void eliminar_profesor(int id_profesor){
		// este metodo recibe un indice que es un atributo del objeto de la case Profesor

		for(int i=0; i< profesores.size();i++){
			if((((Profesor)profesores.get(i)).id_profesor) == id_profesor){
				profesores.remove(i);
				break;
			}
		}
		
		// este metodo elima al objeto de la clase profesor que tiene como atributo id el numero ingresado
	}
	
	public int obtener_id(){
		return this.id_curso;
		// este metodo devudelve el atributo id_curso
	}
	
	
	

}
