package g4;

import java.util.ArrayList;
import java.util.List;

import jdk.nashorn.internal.runtime.ListAdapter;

public class AplicacionInicio {
	
	
	
	public List<Alumno> listaAlumnos;
	public List<Administrador_academico> listaAdministradores;
	public List<Carrera>  listaCarreras; /// cada vez que se agrege una carrera hay que agregarla aca tambien.
	
	public AplicacionInicio(){
		


		listaAlumnos = new ArrayList<Alumno>();
		listaAdministradores = new ArrayList<Administrador_academico>();
		listaCarreras = new ArrayList<Carrera>();

		// datos iniciales
		listaAlumnos.add(new Alumno("juan", "123", "hombre", 20 ));
		listaAlumnos.add(new Alumno("max", "1", "hombre", 21 ));
		listaAdministradores.add( new Administrador_academico("ana","123","mujer", 40));
		listaCarreras.add(new Carrera(1, "juan perez", "artes", "teatro"));
		listaCarreras.add(new Carrera(2, "juan perez", "artes", "coreografia"));
		
	}
	
	
	public void agregarAlumno(Alumno A){
		
		listaAlumnos.add(A);
		
	}
	
	public void agregarAdministrador(Administrador_academico a){
		listaAdministradores.add(a);
		
	}


}
