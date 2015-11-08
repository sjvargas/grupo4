package g4;

public class CursoTabla  implements java.io.Serializable {
	private final String sigla;
	private final String profesores;
	private final String horarios;
	private final String nombre;
	private final Integer seccion;
	private final String carrera;
	
	public CursoTabla(Curso curso){
		sigla = new String(curso.getRamo().getSigla());
		String list = "";
		if (curso.getProfesores()== null){
			profesores = new String(" ");
		}
		else{
			for (Profesor s : curso.getProfesores())
			{
			    list += s.GetNombre()+ " "+s.GetApellidoPaterno() + ", ";
			}
			profesores =  new String(list.substring(0,list.length()-2));
		}
		list = "";
		if (curso.getHorario()== null){
			horarios = new String(" ");
		}
		else{
			for (String s : curso.getHorario())
			{
			    list += s+",";
			}
			horarios = new String(list.substring(0,list.length()-1));
		}
		nombre = new String(curso.getRamo().getNombre());
		seccion = new Integer(0);
		carrera = new String(curso.getRamo().getCarrera().getnombre_carrera());
	}

	public String getSigla() {
		return sigla;
	}	
	public String getNombre() {
		return nombre;
	}	
	public String getProfesores() {
		return profesores;
	}	
	public String getHorarios() {
		return horarios;
	}	
	public String getCarrera() {
		return carrera;
	}	
	public Integer getSeccion() {
		return seccion;
	}
}
