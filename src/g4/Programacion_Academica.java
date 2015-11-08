package g4;
import java.util.ArrayList;
import java.util.List;


public class Programacion_Academica implements java.io.Serializable {
	public ArrayList<Curso> cursos_en_progreso;
	public String periodo;  
	public Buscador_de_cursos buscador_de_cursos;
	
	public Programacion_Academica(String periodo)
	{
		this.periodo = periodo;
		cursos_en_progreso = new ArrayList<Curso>();
		buscador_de_cursos = new Buscador_de_cursos();
	}
	
	// se le da toda la informacion, habia que revisar antes cual es el id_curso mas alto para darselo pero eso es otra cosa
	public  void crear_curso(int semestre,List<String> salas,List<String> horario, int creditos, int seccion , Profesor profesor, Ramo ramo)
	{
		Curso curso_nuevo = new Curso (semestre,salas,horario,creditos ,seccion, profesor, ramo);
		this.cursos_en_progreso.add(curso_nuevo);
		this.buscador_de_cursos.todo_cursos.add(curso_nuevo);
	}
	
	// se le entrega un id del curso y con ese se va a buscar el curso y se remueve
	public void eliminar_curso(int id_curs){

		for(int i=0; i< this.cursos_en_progreso.size();i++){
			if((((Curso)cursos_en_progreso.get(i)).id_curso) == id_curs){
				cursos_en_progreso.remove(i);
				break;
			}
		}
		this.buscador_de_cursos.todo_cursos = this.cursos_en_progreso;
		
	}
	
	// se le entregamos el id de un curso y toda la informacion a cambiar, y si no se decea cambiar, se pone 0 o un null.
	public  void modificar_curso(int id,int semestre,List<String> salas,List<String> horario, List<Alumno> Alumnos, int creditos , List<Profesor> profesores, Ramo ramo)
	{
		for(int i=0; i< this.cursos_en_progreso.size();i++){
			if((((Curso)cursos_en_progreso.get(i)).id_curso) == id){
				
				 Curso curso_modificado = cursos_en_progreso.get(i);
				 cursos_en_progreso.remove(i);

				 if (profesores != null) {curso_modificado.profesores = profesores;}
				 if (ramo != null) {curso_modificado.ramo = ramo;}
				 if (semestre != 0) {curso_modificado.semestre = semestre;}
				 if (horario != null) {curso_modificado.horario = horario;}
				 if (Alumnos != null) {curso_modificado.lista_alumnos = Alumnos;}
				 if (creditos != 0) {curso_modificado.creditos = creditos;}
				 
				 this.cursos_en_progreso.add(curso_modificado);
				 
				break;
			}
		}
		this.buscador_de_cursos.todo_cursos = this.cursos_en_progreso;
	
	}

   // nos da un id libre para crear un curso.


}
