package g4;

import java.util.ArrayList;
import java.util.List;

import fx.view.main;

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
		
		lista_profesores.add( new Profesor("sofia", "Sofia", "Hidalgo", "Jullian", "123", Sexo.Femenino, 62, 2200000, "Ingenieria"));
		
		//carreras parten desde indice 1 nombreUsuario, nombre, apellidoPaterno, apellidoMaterno, contrasena, sexo, edad
		lista_alumnos.add(new Alumno("juan","juan", "perez", "lopez", "123", Sexo.Masculino, 20 ));
		lista_alumnos.add(new Alumno("max", "max", "garcia", "sanchez", "1", Sexo.Masculino, 21 ));
		lista_administradores.add( new Administrador_academico("ana", "ana", "guzman", "alvarez","123",Sexo.Femenino, 40));

		lista_carreras.add(new Carrera("decano","facultad", "carrera baisca"));
		historial_de_progrmacion_academica.add(new Programacion_Academica("2015-2"));
		historial_de_progrmacion_academica.add(new Programacion_Academica("2016-1"));

		lista_alumnos.get(0).Inscribir_carrera(2);
		Malla_curricular malla1 = new Malla_curricular(0);
		Malla_curricular malla2 = new Malla_curricular(1);
		
		lista_carreras.get(0).crear_malla_curricular(malla1);
		lista_carreras.get(0).crear_malla_curricular(malla2);
		
		Ramo calculo1 = new Ramo("Calculo 1","MAT1610", 10, lista_carreras.get(0),"3", "derivadas,integrales", "desarrollar pensamiento");
		lista_ramos.add(calculo1);
		//Curso calculo11 = new Curso(1, 1, "a1,a2", null, 10, null, calculo1);
		
		
		lista_carreras.add(new Carrera( "juan perez", "artes", "teatro"));
		lista_carreras.add(new Carrera( "Patricio Correa", "artes", "coreografia"));
		
		
		for (int i=0; i<6; i++){
			Curso u = new Curso( 1, null, null, null, 10, null, calculo1);
			lista_cursos.add(u);
			historial_de_progrmacion_academica.get(0).cursos_en_progreso.add(u);
		}
		
		
		

		
		
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
	
	public Ramo GetRamo(String siglaRamo){
		for(int i=0;i<lista_ramos.size();i++){
			if(lista_ramos.get(i).getSigla()== siglaRamo){
				return lista_ramos.get(i);
			}
		}
		return null;
	}

	public List<String> GetSiglasRamos(){
		List<String> listaRetorno = new ArrayList<String>();
		for(Ramo ramo: lista_ramos){
			listaRetorno.add(ramo.getSigla());
			System.out.print(ramo.getSigla());
		}
		return listaRetorno;
	}
}
