package g4;

import java.util.ArrayList;
import java.util.List;

import jdk.nashorn.internal.runtime.ListAdapter;

public class AplicacionInicio {
	
	
	
	public List<Alumno> listaAlumnos;
	public List<Administrador_academico> listaAdministradores;
	//public List<Carrera>  listaCarreras; /// cada vez que se agrege una carrera hay que agregarla aca tambien.
	
	public Buscador_de_cursos buscador;
	
	public AplicacionInicio(){
		


		listaAlumnos = new ArrayList<Alumno>();
		listaAdministradores = new ArrayList<Administrador_academico>();
		buscador = new Buscador_de_cursos();
		
//		listaCarreras = new ArrayList<Carrera>();

		// datos iniciales
		listaAlumnos.add(new Alumno("juan","juan", "perez", "lopez", "123", Sexo.Masculino, 20 ));
		listaAlumnos.add(new Alumno("max", "max", "garcia", "sanchez", "1", Sexo.Masculino, 21 ));
		listaAdministradores.add( new Administrador_academico("ana", "ana", "guzman", "alvarez","123",Sexo.Femenino, 40));

		listaAdministradores.get(0).agregar_carrera("juan perez", "ing", "ingeniera");
		listaAdministradores.get(0).agregar_carrera("juan perez", "artes", "teatro");
		listaAdministradores.get(0).agregar_carrera("juan perez", "artes", "coreografia");
		
	}
	
	
	public void agregarAlumno(Alumno A){
		
		listaAlumnos.add(A);
		
	}
	
	public void agregarAdministrador(Administrador_academico a){
		listaAdministradores.add(a);
		
	}


}
