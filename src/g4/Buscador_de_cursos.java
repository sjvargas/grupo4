package g4;
import java.util.List;
import java.util.ArrayList;

//  Como el alumno no puede crear un curso y para inscribirlo solo necesita el id, de algun lado se debe obtener el curso para que 
//  se agregue al semestre y asi poder obtener mas datos del curso como lo son los creditos y asi poder restringir los creditos inscritos
// Entonces lo que pense fue hacer que la clase buscacursos sea singleton y cada vez que se tenga que agregar, se obtenga la instancia
// de buscacursos y realizar un metodo que me entregue el curso al darle la sigla.


public class Buscador_de_cursos {
	
	public ArrayList<Curso> todo_cursos;
	
	public Buscador_de_cursos()
	{
		todo_cursos = new ArrayList<Curso>();
	}
	
	/// uno le entrega una lista de horarios y
	/// entrega los cursos que como minimo tenga esos horarios.
	/// NUevo: se le agrega una lista de cursos a filtrar: cursosAFiltrar
	
	private ArrayList<Curso> filtrar_por_horario(ArrayList<Curso> cursosAFiltrar,List<String> horarios)
	{
		ArrayList<Curso> cursos_encontrados = new ArrayList<Curso>();
		
		for (Curso j : cursosAFiltrar) {

			boolean aux1 = true;
			for (String i : horarios) {
				if (!(j.horario.contains(i))) {
					aux1 = false;
				break;
				}
			}
			if (aux1)
			{
				cursos_encontrados.add(j);
			}
		}
		
		return cursos_encontrados;
	}

	/// uno le entrega un nombre de profesor o parte del nombre (ejemplo: "juan") y
	/// te entrega todos los cursos que contengan algun profesor que haga mach.
	/// NUevo: se le agrega una lista de cursos a filtrar: cursosAFiltrar
	private ArrayList<Curso> filtrar_por_profesor(ArrayList<Curso> cursosAFiltrar,String nombre_profesor)
	{
		ArrayList<Curso> cursos_encontrados = new ArrayList<Curso>();
		
		for (Curso j : cursosAFiltrar) {

			boolean aux1 = false;
			
			for (Profesor i : j.profesores) {
				if (i.nombre.toLowerCase().contains(nombre_profesor.toLowerCase()))
				{
					aux1 = true;
				}
			}
			
			if (aux1)
			{
				cursos_encontrados.add(j);
			}
		}
		
		return cursos_encontrados;
	}
	
	/// uno le entrega el id de la carrera y
	/// entrega los cursos que pertenesen a esa carrera.
	/// NUevo: se le agrega una lista de cursos a filtrar: cursosAFiltrar
	private ArrayList<Curso> filtrar_por_carrera(ArrayList<Curso> cursosAFiltrar, int id_carrera)
	{
		ArrayList<Curso> cursos_encontrados = new ArrayList<Curso>();
		
		for (Curso j : cursosAFiltrar) {
			Carrera i = j.ramo.getCarrera();	
			if (i.getId_carrera() == id_carrera){
				{
					cursos_encontrados.add(j);
				}
			}
		}
		return cursos_encontrados;
	}

	/// uno le entrega una sigla o parte de una  (ejemplo: "iic") y
	/// te entrega todos los cursos que hagan mach.
		
	private ArrayList<Curso> filtrar_por_sigla(ArrayList<Curso> cursosAFiltrar,String sigla)
	{
		ArrayList<Curso> cursos_encontrados = new ArrayList<Curso>();
		
		for (Curso j : cursosAFiltrar) {

			boolean aux1 = false;
			
			String i = j.ramo.getSigla();
			
			if (i.toLowerCase().contains(sigla.toLowerCase())){
				{
					aux1 = true;
				}
			}
			
			if (aux1)
			{
				cursos_encontrados.add(j);
			}
		}
		
		
		return cursos_encontrados;
	}
	//
	
	// metodo unico para filtrar, si no se quiere filtrar por algo, se coloca Null.
	public ArrayList<Curso> filtrar(List<String> horarios, String nombre_profesor,Integer id_carrera,String sigla){
		
		
		ArrayList<Curso> cursosFiltrados = new ArrayList<Curso>();
		
		// filtrar por horarios
		if(horarios!=null && horarios.size()>0){
			cursosFiltrados = this.filtrar_por_horario(cursosFiltrados, horarios);
		}
		
		if(nombre_profesor!=null && nombre_profesor!=""){
			
			cursosFiltrados = this.filtrar_por_profesor(cursosFiltrados, nombre_profesor);
			
		}
		//
		if(id_carrera!= null && id_carrera!=-1){
			this.filtrar_por_carrera(cursosFiltrados, id_carrera);
		}
		if(sigla!=null && sigla!="" && sigla.length()>0){
			this.filtrar_por_sigla(cursosFiltrados, sigla);
		}
		
		
		
		return cursosFiltrados;
		
		
		
		
	}
}
