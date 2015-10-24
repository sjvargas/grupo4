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
		buscador = new Buscador_de_cursos("2015-2");
		
//		listaCarreras = new ArrayList<Carrera>();

		// datos iniciales
		listaAlumnos.add(new Alumno("juan", "123", "hombre", 20 ));
		listaAlumnos.add(new Alumno("max", "1", "hombre", 21 ));
		listaAdministradores.add( new Administrador_academico("ana","123","mujer", 40));

		listaAdministradores.get(0).agregar_carrera("juan perez", "ing", "ingeniera");
		listaAdministradores.get(0).agregar_carrera("juan perez", "artes", "teatro");
		listaAdministradores.get(0).agregar_carrera("juan perez", "artes", "coreografia");
		
		
		//carreras parten desde indice 1
		listaAlumnos.get(0).Inscribir_carrera(2);
		
		Malla_curricular malla1 = new Malla_curricular(0);
		Malla_curricular malla2 = new Malla_curricular(1);
		
		listaAdministradores.get(0).getListaCarrera().get(0).crear_malla_curricular(malla1);
		listaAdministradores.get(0).getListaCarrera().get(0).crear_malla_curricular(malla2);
		
		Ramo calculo1 = new Ramo("MAT1610", 10, listaAdministradores.get(0).getListaCarrera().get(0),"3", "derivadas,integrales", "desarrollar pensamiento");

		//Curso calculo11 = new Curso(1, 1, "a1,a2", null, 10, null, calculo1);
		
		
	//	listaCarreras.add(new Carrera(1, "juan perez", "artes", "teatro"));
	//	listaCarreras.add(new Carrera(2, "juan perez", "artes", "coreografia"));
		
	}
	
	
	public void agregarAlumno(Alumno A){
		
		listaAlumnos.add(A);
		
	}
	
	public void agregarAdministrador(Administrador_academico a){
		listaAdministradores.add(a);
		
	}


}
