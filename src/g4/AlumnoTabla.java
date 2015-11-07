package g4;

import java.util.List;

public class AlumnoTabla  implements java.io.Serializable {
	private final String nombre;
	private String nota;
	
	public AlumnoTabla(Alumno alumno,int curso){
		nombre = alumno.GetNombre();
		List<Nota> notas = alumno.GetSemestreActual().GetNotas() ;
		nota = "--";
		if (!notas.isEmpty()){
			for (Nota j : notas){
				if (j.GetCurso().equals(curso)){
					if (j.GetNota()!=null){
						nota = j.GetNota().toString();}
				}
			}
		}
	}

	public String getNota() {
		return nota;
	}	
	public String getNombre() {
		return nombre;
	}	
	
}
