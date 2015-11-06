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
		
		//carreras parten desde indice 1 nombreUsuario, nombre, apellidoPaterno, apellidoMaterno, contrasena, sexo, edad
		lista_alumnos.add(new Alumno("juan","juan", "perez", "lopez", "123", Sexo.Masculino, 20 ));
		lista_alumnos.add(new Alumno("max", "max", "garcia", "sanchez", "1", Sexo.Masculino, 21 ));
		lista_administradores.add( new Administrador_academico("ana", "ana", "guzman", "alvarez","123",Sexo.Femenino, 40));

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
		
		lista_cursos.add(new Curso(1, 1, null, null, null, 10, null, calculo1));
		lista_cursos.add(new Curso(2, 1, null, null, null, 10, null, calculo1));
		lista_cursos.add(new Curso(3, 1, null, null, null, 10, null, calculo1));
		lista_cursos.add(new Curso(4, 1, null, null, null, 10, null, calculo1));
		lista_cursos.add(new Curso(5, 1, null, null, null, 10, null, calculo1));
		lista_cursos.add(new Curso(6, 1, null, null, null, 10, null, calculo1));
		

		
		
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
