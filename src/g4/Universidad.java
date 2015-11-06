package g4;

import java.util.ArrayList;
import java.util.List;

import fx.view.main;

public class Universidad implements java.io.Serializable {

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
		lista_profesores.add( new Profesor("ian", "ian", "sapallo", "casuela", "123", Sexo.Masculino, 42, 2000000, "Ingenieria"));
		lista_profesores.add( new Profesor("jorge", "jorge", "zanahoria", "ensalada", "123", Sexo.Masculino, 45, 1000000, "Ingenieria"));
		lista_profesores.add( new Profesor("jaime", "jaime", "vargas", "vargas", "123", Sexo.Femenino, 55, 2200000, "Ingenieria"));
		
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
		
		List<String> salas = new ArrayList<String>();
		salas.add("A1"); salas.add("B16");
		List<String> salas1 = new ArrayList<String>();
		salas1.add("A2");
		List<String> salas2 = new ArrayList<String>();
		salas2.add("A7"); salas2.add("B16");
		List<String> salas3 = new ArrayList<String>();
		salas3.add("B15"); salas3.add("B21");
		List<String> salas4 = new ArrayList<String>();
		salas4.add("BC25"); salas4.add("B25");
		
		List<String> horario = new ArrayList<String>();
		horario.add("lu:1"); horario.add("mi:1"); horario.add("vi:1");
		List<String> horario1 = new ArrayList<String>();
		horario1.add("ma:1");horario1.add("ju:1");horario1.add("vi:1");
		List<String> horario2 = new ArrayList<String>();
		horario2.add("lu:2"); horario2.add("mi:2"); horario2.add("vi:2");
		List<String> horario3 = new ArrayList<String>();
		horario3.add("lu:5"); horario3.add("mi:5"); horario2.add("vi:1");
		List<String> horario4 = new ArrayList<String>();
		horario4.add("ma:2"); horario4.add("ju:2"); horario4.add("ju:3");
		
		List<Alumno> alumnos = new ArrayList<Alumno>();
		
		List<Profesor> profesores = new ArrayList<Profesor>();
		profesores.add(lista_profesores.get(0));
		List<Profesor> profesores1 = new ArrayList<Profesor>();
		profesores1.add(lista_profesores.get(1));
		List<Profesor> profesores2 = new ArrayList<Profesor>();
		profesores2.add(lista_profesores.get(2));
		List<Profesor> profesores3 = new ArrayList<Profesor>();
		profesores3.add(lista_profesores.get(3));
		List<Profesor> profesores4 = new ArrayList<Profesor>();
		profesores4.add(lista_profesores.get(0));
		profesores4.add(lista_profesores.get(2));
				
		
		

		Curso u = new Curso( 1,salas, horario, alumnos, 10, profesores, calculo1);
		historial_de_progrmacion_academica.get(0).cursos_en_progreso.add(u);
		Curso u2 = new Curso( 1,salas1, horario1, alumnos, 10, profesores1, calculo1);
		historial_de_progrmacion_academica.get(0).cursos_en_progreso.add(u2);
		Curso u3 = new Curso( 1,salas2, horario2, alumnos, 10, profesores2, calculo1);
		historial_de_progrmacion_academica.get(0).cursos_en_progreso.add(u3);
		Curso u4 = new Curso( 1,salas3, horario3, alumnos, 10, profesores3, calculo1);
		historial_de_progrmacion_academica.get(0).cursos_en_progreso.add(u4);
		Curso u5 = new Curso( 1,salas4, horario4, alumnos, 10, profesores4, calculo1);
		historial_de_progrmacion_academica.get(0).cursos_en_progreso.add(u5);
		Curso u6 = new Curso( 1,salas, horario2, alumnos, 10, profesores, calculo1);
		historial_de_progrmacion_academica.get(0).cursos_en_progreso.add(u6);
		Curso u7 = new Curso( 1,salas1, horario4, alumnos, 10, profesores2, calculo1);
		historial_de_progrmacion_academica.get(0).cursos_en_progreso.add(u7);


		
		
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
