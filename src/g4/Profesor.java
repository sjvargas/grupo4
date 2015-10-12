package g4;

public class Profesor {
	
	public String nombre;
	public int id_profesor=1;
	public int sueldo;
	public String facultad;
	
	public Profesor(int id, String nombre, int sueldo, String facultad)
	{
		this.id_profesor = id;
		this.nombre = nombre;
		this.sueldo = sueldo;
		this.facultad = facultad;
	}
	
	
}
