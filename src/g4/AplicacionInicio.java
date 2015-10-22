package g4;

import java.util.ArrayList;
import java.util.List;

import jdk.nashorn.internal.runtime.ListAdapter;

public class AplicacionInicio {
	
	
	
	private List<Alumno> listaAlumnos;
	private List<Administrador_academico> listaAdministradores;
	
	public AplicacionInicio(){
		listaAlumnos = new ArrayList<Alumno>();
		listaAdministradores = new ArrayList<Administrador_academico>();

	}
	
	
	public void agregarAlumno(String nom, String cont, String sex, int ed){
		
		listaAlumnos.add(new Alumno(nom, cont, sex, ed));
		
	}
	
	public void agregarAdministrador(String nom, String cont, String sex, int ed){
		listaAdministradores.add(new Administrador_academico(nom, cont, sex, ed));
		
	}


}
