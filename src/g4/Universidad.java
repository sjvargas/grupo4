package g4;

import java.util.ArrayList;
import java.util.List;

public class Universidad {

	public List<Programacion_Academica> historial_de_progrmacion_academica;
	
	public List<Carrera> lista_carreras;
	public List<Ramo> lista_ramos;
	public List<Profesor> lista_profesores;
	public List<Alumno> lista_alumnos;
	public List<Administrador_academico> lista_administradores;
	
	public Buscador_de_cursos buscador;
	
	public Administrador_academico administrador_actual;
	public Alumno alumno_actual;
	
	public Universidad(){
			
		historial_de_progrmacion_academica = new ArrayList<Programacion_Academica>();
		lista_carreras = new ArrayList<Carrera>();
		lista_profesores = new ArrayList<Profesor>();
		lista_ramos = new ArrayList<Ramo>();		
		lista_alumnos = new ArrayList<Alumno>();
		lista_administradores = new ArrayList<Administrador_academico>();
		buscador = new Buscador_de_cursos();
		
		alumno_actual = null;
		administrador_actual = null;
		
		//carreras parten desde indice 1
		lista_alumnos.add(new Alumno("juan", "123", "hombre", 20 ));
		lista_alumnos.add(new Alumno("max", "1", "hombre", 21 ));
		lista_administradores.add( new Administrador_academico("ana","123","mujer", 40));

		lista_administradores.get(0).agregar_carrera("juan perez", "ing", "ingeniera");
		lista_administradores.get(0).agregar_carrera("juan perez", "artes", "teatro");
		lista_administradores.get(0).agregar_carrera("juan perez", "artes", "coreografia");
		
		
		

		lista_alumnos.get(0).Inscribir_carrera(2);
		Malla_curricular malla1 = new Malla_curricular(0);
		Malla_curricular malla2 = new Malla_curricular(1);
		
		lista_administradores.get(0).getListaCarrera().get(0).crear_malla_curricular(malla1);
		lista_administradores.get(0).getListaCarrera().get(0).crear_malla_curricular(malla2);
		
		Ramo calculo1 = new Ramo("MAT1610", 10, lista_administradores.get(0).getListaCarrera().get(0),"3", "derivadas,integrales", "desarrollar pensamiento");

		//Curso calculo11 = new Curso(1, 1, "a1,a2", null, 10, null, calculo1);
		
		
		lista_carreras.add(new Carrera(1, "juan perez", "artes", "teatro"));
		lista_carreras.add(new Carrera(2, "juan perez", "artes", "coreografia"));
		
		
		
	}
	
	
	public void agregarAlumno(Alumno A){
		lista_alumnos.add(A);	
	}
	
	public void agregarAdministrador(Administrador_academico a){
		lista_administradores.add(a);	
	}
	
	
	
	
}
