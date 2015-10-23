package g4;

import java.util.ArrayList;
import java.util.List;

import jdk.nashorn.internal.runtime.ListAdapter;

public class AplicacionInicio {
	
	
	
	public List<Alumno> listaAlumnos;
	public List<Administrador_academico> listaAdministradores;
	
	public AplicacionInicio(){
		listaAlumnos = new ArrayList<Alumno>();
		listaAdministradores = new ArrayList<Administrador_academico>();

	}
	
	
	public void agregarAlumno(Alumno A){
		
		listaAlumnos.add(A);
		
	}
	
	public void agregarAdministrador(Administrador_academico a){
		listaAdministradores.add(a);
		
	}


}
