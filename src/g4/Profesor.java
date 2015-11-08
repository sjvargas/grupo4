package g4;

public class Profesor extends Usuario implements java.io.Serializable{
	private int id_profesor;
	private int sueldo;
	private String facultad;
    private static int NextId = 0;
	
	public Profesor(String nombreUsuario, String nombre, String apellidoPaterno, String apellidoMaterno, String contrasena, Sexo sexo, int edad , int sueldo, String facultad)
	{	super(nombreUsuario, nombre, apellidoPaterno, apellidoMaterno, contrasena, sexo, edad);
		this.sueldo = sueldo;
		this.facultad = facultad;
		this.id_profesor = NextId++;
	}
	
	public void CalificarAlumno(Curso curso, Alumno alumno ,Float nota){
		
	}
	public int GetId(){ return id_profesor;}
	
	@Override
	public String toString(){
		return (GetNombre()+" "+GetApellidoPaterno()+" "+GetApellidoPaterno());
	}
}
