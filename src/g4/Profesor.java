package g4;

public class Profesor extends Usuario {
	private int id_profesor;
	private int sueldo;
	private String facultad;
	
	public Profesor(String nombreUsuario, String nombre, String apellidoPaterno, String apellidoMaterno, String contrasena, Sexo sexo, int edad , int sueldo, String facultad)
	{	super(nombreUsuario, nombre, apellidoPaterno, apellidoMaterno, contrasena, sexo, edad);
		this.sueldo = sueldo;
		this.facultad = facultad;
	}
	
	public void CalificarAlumno(Curso curso, Alumno alumno ,Float nota){
		
	}
	
	
}
