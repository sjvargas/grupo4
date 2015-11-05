package g4;

import fx.view.main;

public class Profesor {
	

    private static int NextId = 0;
	public String nombre;
	public String apellidos;
	public int id_profesor=1;
	public int sueldo;
	public String facultad;
	
	public Profesor( String nombre, String apellidos, int sueldo, String facultad){
		this.id_profesor = NextId++;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.sueldo = sueldo;
		this.facultad = facultad;
	}	
}
