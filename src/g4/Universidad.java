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
	public List<Curso> lista_cursos;

	
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
		lista_cursos = new ArrayList<Curso>();
		
		alumno_actual = null;
		administrador_actual = null;
		
		//carreras parten desde indice 1
		lista_alumnos.add(new Alumno("juan", "123", "hombre", 20 ));
		lista_alumnos.add(new Alumno("max", "1", "hombre", 21 ));
		lista_administradores.add( new Administrador_academico("ana","123","mujer", 40));

		lista_carreras.add(new Carrera(1, "valentina perez", "artes", "teatro"));
		lista_carreras.add(new Carrera(2, "juan perez", "artes", "coreografia"));
		lista_carreras.add(new Carrera(2, "luis Correa", "ing", "ingeniera"));
		
		lista_ramos.add(new Ramo("icc1001", 10, lista_carreras.get(0), "3", "hacerte odiar la universidad", "1) hacerte extrañar tu colegio \n 2) aprender algo de logaritmos"));
		ArrayList<Ramo> aux = new ArrayList<Ramo>();
		aux.add(lista_ramos.get(0));
		lista_ramos.add(new Ramo("icc2001", 10, lista_carreras.get(0), "3", "¿querias mas calculo I? aca tienes mas!!", "1) ver series \n 2) intentar aprender series \n 3) rendirte con series"));
		aux.remove(0);
		aux.add(lista_ramos.get(1));
		lista_ramos.add(new Ramo("icc3001", 10, lista_carreras.get(0), "3", " Si sabemos que te encanta calculo, por eso hacemos otro mas", "1) reaprender todo lo que no aprendiste en calculo I \n 2) lo mismo con calculo II"));
	
		aux.remove(0);
		lista_ramos.add(new Ramo("ttr1001", 10, lista_carreras.get(1), "3", "expreciones faciales y mas", "1) hacerte extrañar tu colegio \n 2) aprender algo de logaritmos"));
		aux.add(lista_ramos.get(3));
		lista_ramos.add(new Ramo("ttr1002", 10, lista_carreras.get(1), "3", "canto basico y tonos del habla", "1) ver series \n 2) intentar aprender series \n 3) rendirte con series"));
		aux.add(lista_ramos.get(4));
		lista_ramos.add(new Ramo("ttr2001", 10, lista_carreras.get(1), "3", "Primera practica de los alumnos para enfrentar el mundo real", "1) presentaciones reales \n 2) musicales"));
		
	
		
		lista_alumnos.get(0).Inscribir_carrera(lista_carreras.get(2));
		Malla_curricular malla1 = new Malla_curricular(0);
		Malla_curricular malla2 = new Malla_curricular(1);
		
		lista_carreras.get(0).crear_malla_curricular(malla1);
		lista_carreras.get(0).crear_malla_curricular(malla2);
		

		
	}
	
	
	public void agregarAlumno(Alumno A){
		lista_alumnos.add(A);	
	}
	
	public void agregarAdministrador(Administrador_academico a){
		lista_administradores.add(a);	
	}
	
	// metodo que retorna el curso de la lista que tiene el id indicado
	public Curso getCursoConID(int id){
		for(int i=0;i<lista_cursos.size();i++){
			if(lista_cursos.get(i).getId_curso()==id){
				return lista_cursos.get(i);
			}
		}
		return null;
	}
	
	
}
