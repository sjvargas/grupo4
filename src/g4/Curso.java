package g4;

import java.util.ArrayList;
import java.util.List;

import fx.view.main;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;


/*
 * Clase Curso: Clase que cuenta con identificador �nico, 
 *  una lista de profesores que dan clases en el 
 *  curso, un numero asociado al semestre (primero o segundo),
 *  una lista de salas en las cuales se dicta (puede ser m�s de una, por ejemplo si hay sala de c�tedra y otra de ayudant�a),
 *  una lista de los horarios del curso y una lista de los alumnos del curso.
 *  Esta clase Permite (mediante sus m�todos) agregar y eliminar profesores,
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
	public List<Tema> temas;
	private List<ProgramacionHoraria> listaProgramacionHoraria;
	private List<Archivo> apuntes;
	
	
	public Curso(String periodo,List<String> salas,List<String> horario, int creditos, int seccion , Profesor profesor, Ramo ramo){
		this.id_curso =NextId++;
		this.profesores = new ArrayList<Profesor>();
		profesores.add(profesor);
		this.seccionCurso = seccion;
		this.periodo = periodo;
		this.horario = horario;
		this.lista_alumnos = new ArrayList<Alumno>();
		this.apuntes = new ArrayList<Archivo>();
		this.creditos = creditos;
		this.ramo = ramo;
		this.salas = salas;
		this.temas = new ArrayList<Tema>();
		
		listaProgramacionHoraria = new ArrayList<ProgramacionHoraria>();
		int i = 0;
		for(String sala: salas){
			String[] divisionHorario = horario.get(i).split(":");
			listaProgramacionHoraria.add(new ProgramacionHoraria(getDiaCompleto(divisionHorario[0]),
																				Integer.parseInt(divisionHorario[1]),sala));
			i++;
		}
	}
	private String getDiaCompleto(String diaIncompleto){
		switch (diaIncompleto){
		case "lu":
			return "Lunes";
		case "ma":
			return "Martes";
		case "mi":
			return "Miercoles";
		case "ju":
			return "Jueves";
		case "vi":
			return "Viernes";
		case "sa":
			return "Sabado";
		default:
			return "Lunes";
		
		}
	}

//// GETTERS de atributos
	public List<Archivo> getApuntes(){
		return apuntes;
	}
	public void agregarApunte(Archivo arch){
		apuntes.add(arch);
	}	
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
	
	 public List<Tema> getTema(){
		 return temas;
	 }
	 public String  AgregarTema(String titulo, String texto, Usuario usuario, String status){
		 temas.add(new Tema(titulo,texto, usuario, status));
		 return "tema creado con exito!";
	 }
	 public List<ProgramacionHoraria> getListaProgramacionHoraria(){ return listaProgramacionHoraria;}
	 public boolean HaceClasesProfesor(int idProfesor){
		 for(Profesor profesor: profesores){
			 if(idProfesor==profesor.getId_profesor()){
				 return true;
			 }
		 }
		 return false;
	 }

	 public void ModificarDatosCurso(String periodo,List<String> salas,List<String> horario, int creditos, int seccion , Profesor profesor, Ramo ramo){
		profesores.set(0, profesor);
		this.seccionCurso = seccion;
		this.periodo = periodo;
		this.horario = horario;
		this.creditos = creditos;
		this.ramo = ramo;
		this.salas = salas;
		
		listaProgramacionHoraria = new ArrayList<ProgramacionHoraria>();
		int i = 0;
		for(String sala: salas){
			String[] divisionHorario = horario.get(i).split(":");
			listaProgramacionHoraria.add(new ProgramacionHoraria(getDiaCompleto(divisionHorario[0]),
																				Integer.parseInt(divisionHorario[1]),sala));
			i++;
		}
	 }
}
