package g4;

public class CursoTabla  implements java.io.Serializable {
	private final String sigla;
	private final String profesores;
	private final String horarios;
	private final String nombre;
	private final Integer seccion;
	private final String carrera;
	private final String prerrequisitos;
	
	public CursoTabla(Curso curso){
		sigla = new String(curso.getRamo().getSigla());
		String list = "";
		if (curso.getProfesores()== null){
			profesores = new String(" ");
		}
		else{
			for (Profesor s : curso.getProfesores())
			{
			    list += s.getNombre()+ " "+s.getApellidoPaterno() + ", ";
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
		list = "";
		if (curso.getRamo().GetPrerrequisitos()== null || curso.getRamo().GetPrerrequisitos().size()<1){
			prerrequisitos = new String("no tiene");
		}
		else{
			for (String s : curso.getRamo().GetPrerrequisitos())
			{
			    list += s+",";
			}
			prerrequisitos = new String(list.substring(0,list.length()-1));
		}
		nombre = new String(curso.getRamo().getNombreRamo());
		seccion = curso.seccionCurso;
		carrera = new String(curso.getRamo().getCarrera().getNombreCarrera());
	}

	public String getSigla() {
		return sigla;
	}	
	public String getPrerrequisitos() {
		return prerrequisitos;
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
