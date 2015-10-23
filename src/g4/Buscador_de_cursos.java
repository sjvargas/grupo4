package g4;
import java.util.List;
import java.util.ArrayList;

//  Como el alumno no puede crear un curso y para inscribirlo solo necesita el id, de algun lado se debe obtener el curso para que 
//  se agregue al semestre y asi poder obtener mas datos del curso como lo son los creditos y asi poder restringir los creditos inscritos
// Entonces lo que pense fue hacer que la clase buscacursos sea singleton y cada vez que se tenga que agregar, se obtenga la instancia
// de buscacursos y realizar un metodo que me entregue el curso al darle la sigla.


public class Buscador_de_cursos {
	private static Buscador_de_cursos instancia = null;
	
	public ArrayList<Curso> todo_cursos;
	public String periodo;
	protected Buscador_de_cursos(String periodo)
	{
		todo_cursos = new ArrayList<Curso>();
		this.periodo = periodo;
	}
	
	/// uno le entrega una lista de horarios y
	/// entrega los cursos que como minimo tenga esos horarios.
	
	public ArrayList<Curso> filtrar_por_horario(List<String> horarios)
	{
		ArrayList<Curso> cursos_encontrados = new ArrayList<Curso>();
		
		for (Curso j : this.todo_cursos) {

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
	
	public ArrayList<Curso> filtrar_por_profesor(String nombre_profesor)
	{
		ArrayList<Curso> cursos_encontrados = new ArrayList<Curso>();
		
		for (Curso j : this.todo_cursos) {

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
	public ArrayList<Curso> filtrar_por_carrera(int id_carrera)
	{
		ArrayList<Curso> cursos_encontrados = new ArrayList<Curso>();
		
		for (Curso j : this.todo_cursos) {
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
		
	public ArrayList<Curso> filtrar_por_sigla(String sigla)
	{
		ArrayList<Curso> cursos_encontrados = new ArrayList<Curso>();
		
		for (Curso j : this.todo_cursos) {

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
	
	
	public static Buscador_de_cursos getInstancia(){
		if(instancia == null){
			instancia = new Buscador_de_cursos();
		}
		return instancia;
	}
}
