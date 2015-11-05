package g4;

public class Profesor {
	
	public String nombre;
	public String apellidos;
	public int id_profesor=1;
	public int sueldo;
	public String facultad;
	
	public Profesor(int id, String nombre, String apellidos, int sueldo, String facultad)
	{
		this.id_profesor = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.sueldo = sueldo;
		this.facultad = facultad;
	}
	
	
}
