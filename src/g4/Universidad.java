package g4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fx.view.main;

public class Universidad implements java.io.Serializable {

	public List<Programacion_Academica> historial_de_progrmacion_academica;
    private Random rn;
	
	public List<Carrera> lista_carreras;
	public List<Ramo> lista_ramos;
	public List<Profesor> lista_profesores;
	public List<Alumno> lista_alumnos;
	public List<Administrador_academico> lista_administradores;
	public List<Curso> lista_cursos;
	
	public Buscador_de_cursos buscador;
	
	public Administrador_academico administrador_actual;
	public Alumno alumno_actual;
	public Profesor profesor_actual;
	public String periodo_actual = "2015-2";
	
	public Universidad(){
		
		historial_de_progrmacion_academica = new ArrayList<Programacion_Academica>();
		lista_carreras = new ArrayList<Carrera>();
		lista_profesores = new ArrayList<Profesor>();
		lista_ramos = new ArrayList<Ramo>();		
		lista_alumnos = new ArrayList<Alumno>();
		lista_administradores = new ArrayList<Administrador_academico>();
		buscador = new Buscador_de_cursos();
		lista_cursos = new ArrayList<Curso>();
		rn = new Random();

		alumno_actual = null;
		profesor_actual = null;
		administrador_actual = null;
		
		lista_profesores.add( new Profesor("mar","mar", "Hidalgo", "Jullian", "123", Sexo.Femenino, 62, 2200000, "Ingenieria"));
		lista_profesores.add( new Profesor("ian", "ian", "sapallo", "casuela", "123", Sexo.Masculino, 42, 2000000, "Ingenieria"));
		lista_profesores.add( new Profesor("jorge", "jorge", "zanahoria", "ensalada", "123", Sexo.Masculino, 45, 1000000, "Ingenieria"));
		lista_profesores.add( new Profesor("jaime", "jaime", "vargas", "vargas", "123", Sexo.Femenino, 55, 2200000, "Ingenieria"));
		
		String[] user_names = {"oscar","alejandra","mario","felipe","luigi","miguel","laura","ines","carmen","elena","maria",
		              "jose","ana","alex","clemente","domingo","tomas","raul","luis","elisa","tere","sofia","alex","jairo",
		              "sam","mikey","piro","pascal","damian","tzo","vermont","pug","simon","farras","lola","almendra","manzana","tambor","bambi","negra","raimuno"};
		
		String[] user_last_names = {"Morillas", "Andrade","Mera De Los Santos","Barriga", "Espinosa","Buendia","Iranzo","Gaya",
				"Espinar","Barrionuevo","Peiro","Gabaldon","Moro","Davila","Martinez","Lopez Bauza","Holguin","Sotelo",
				"Paniagua","Gandia","hidalgo","jullian","perez","alvarez","correa","besa","toro","wulf","drago","rios","romani","carmona"};

		Sexo[] sex = {Sexo.Masculino,Sexo.Femenino};
		String[] fac = {"Medicina", "Ingenieria","Artes","Arquitectura dise�o y estudios urbanos","Ciencias Biol�gicas"};
		
		for (int i=0; i<40;i++){
	        int u = rn.nextInt(user_last_names.length);
	        int v = rn.nextInt(user_last_names.length);
	        int w = rn.nextInt(1);
	        lista_alumnos.add(new Alumno(user_names[i],user_names[i],user_last_names[u],user_last_names[v],"123",sex[w],22));
		}
		for (int i=0; i<40;i++){
	        int u = rn.nextInt(user_last_names.length);
	        int v = rn.nextInt(user_last_names.length);
	        int w = rn.nextInt(1);
	        lista_administradores.add(new Administrador_academico(user_names[i],user_names[i],user_last_names[u],user_last_names[v],"123",sex[w],48));
		}
			
		for (int i=0; i<40;i++){
	        int u = rn.nextInt(user_last_names.length);
	        int v = rn.nextInt(user_last_names.length);
	        int w = rn.nextInt(1);
	        int z = rn.nextInt(4);
	        lista_profesores.add(new Profesor(user_names[i],user_names[i],user_last_names[u],user_last_names[v],"123",sex[w],47,1500000,fac[z]));
		}
		
		
		//carreras parten desde indice 1 nombreUsuario, nombre, apellidoPaterno, apellidoMaterno, contrasena, sexo, edad
		lista_alumnos.add(new Alumno("juan","juan", "perez", "lopez", "123", Sexo.Masculino, 20 ));
		lista_alumnos.add(new Alumno("max", "max", "garcia", "sanchez", "1", Sexo.Masculino, 21 ));
		
		
		
		lista_administradores.add( new Administrador_academico("ana", "ana", "guzman", "alvarez","123",Sexo.Femenino, 40));

		lista_carreras.add(new Carrera("Juan Carlos","Ingenieria", "Ingenieria"));
		lista_carreras.add(new Carrera("Juan Carlos","Ingenieria", "Cnstruccion civil"));
		lista_carreras.add(new Carrera("Martin Chuaqui Farr�","Matem�ticas", "Matem�ticas"));
		lista_carreras.add(new Carrera("Luis Ib��ez Anr�que","Medicina", "Medicina"));
		lista_carreras.add(new Carrera("Luis Ib��ez Anr�que","Medicina", "Enfermeria"));
		lista_carreras.add(new Carrera("Juan Correa Maldonado","Ciencias Biol�gicas", "Ciencias Biol�gicas"));
		lista_carreras.add(new Carrera("Mario Ubilla Sanz","Arquitectura dise�o y estudios urbanos", "Arquitectura"));
		lista_carreras.add(new Carrera("Mario Ubilla Sanz","Arquitectura dise�o y estudios urbanos", "Dise�o"));
		lista_carreras.add(new Carrera("Mario Ubilla Sanz","Arquitectura dise�o y estudios urbanos", "Estudios Urbanos"));
		lista_carreras.add(new Carrera("Patricio Correa", "Artes", "Teatro"));
		lista_carreras.add(new Carrera("Patricio Correa", "Artes", "Coreografia"));
		
		
		
		historial_de_progrmacion_academica.add(new Programacion_Academica("2015-2"));
		historial_de_progrmacion_academica.add(new Programacion_Academica("2016-1"));

		lista_alumnos.get(0).Inscribir_carrera(2);
		Malla_curricular malla1 = new Malla_curricular(0);
		Malla_curricular malla2 = new Malla_curricular(1);
		
		lista_carreras.get(0).crear_malla_curricular(malla1);
		lista_carreras.get(0).crear_malla_curricular(malla2);
		
		Ramo ramo1 = new Ramo("Calculo 1","MAT1610", 10, lista_carreras.get(2),"3", "derivadas,integrales", "desarrollar pensamiento");
		Ramo ramo2 = new Ramo("Calculo 2","MAT1126", 10, lista_carreras.get(2),"3", "derivadas,integrales", "desarrollar pensamiento");
		Ramo ramo3 = new Ramo("Calculo 3","MAT1136", 10, lista_carreras.get(2),"3", "derivadas,integrales", "desarrollar pensamiento");
		Ramo ramo4 = new Ramo("algebra lineal","MAT1299", 10, lista_carreras.get(2),"3", "derivadas,integrales", "desarrollar pensamiento");
		Ramo ramo5 = new Ramo("Introducci�n a la Programaci�n","IIC1103", 10, lista_carreras.get(0),"3", "programacion basica", "desarrollar pensamiento");
		Ramo ramo6 = new Ramo("Programaci�n Avanzada","IIC2233", 10, lista_carreras.get(0),"3", "redes y hacer sufrir a los alumnos", "desarrollar pensamiento");
		lista_ramos.add(ramo1);lista_ramos.add(ramo2);lista_ramos.add(ramo3);lista_ramos.add(ramo4);lista_ramos.add(ramo5);lista_ramos.add(ramo6);
		
		

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
		List<Alumno> alumnos1 = new ArrayList<Alumno>();
		List<Alumno> alumnos2 = new ArrayList<Alumno>();
		List<Alumno> alumnos3 = new ArrayList<Alumno>();
		List<Alumno> alumnos4 = new ArrayList<Alumno>();
		List<Alumno> alumnos5 = new ArrayList<Alumno>();
		List<Alumno> alumnos6 = new ArrayList<Alumno>();
		List<Alumno> alumnos7 = new ArrayList<Alumno>();
		List<Alumno> alumnos8 = new ArrayList<Alumno>();
		List<Alumno> alumnos9 = new ArrayList<Alumno>();
		List<Alumno> alumnos10 = new ArrayList<Alumno>();
		List<Alumno> alumnos11 = new ArrayList<Alumno>();
		List<Alumno> alumnos12 = new ArrayList<Alumno>();
		List<Alumno> alumnos13 = new ArrayList<Alumno>();
		List<Alumno> alumnos14 = new ArrayList<Alumno>();
		List<Alumno> alumnos15 = new ArrayList<Alumno>();
		List<Alumno> alumnos16 = new ArrayList<Alumno>();
		List<Alumno> alumnos17 = new ArrayList<Alumno>();
		List<Alumno> alumnos18 = new ArrayList<Alumno>();
		List<Alumno> alumnos19 = new ArrayList<Alumno>();
		List<Alumno> alumnos20 = new ArrayList<Alumno>();
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

		List<Profesor> profesores5 = new ArrayList<Profesor>();
		profesores5.add(lista_profesores.get(rn.nextInt(40)));
		List<Profesor> profesores6 = new ArrayList<Profesor>();
		profesores6.add(lista_profesores.get(rn.nextInt(40)));
		List<Profesor> profesores7 = new ArrayList<Profesor>();
		profesores7.add(lista_profesores.get(rn.nextInt(40)));
		List<Profesor> profesores8 = new ArrayList<Profesor>();
		profesores8.add(lista_profesores.get(rn.nextInt(40)));
		List<Profesor> profesores9 = new ArrayList<Profesor>();
		profesores9.add(lista_profesores.get(rn.nextInt(40)));
		List<Profesor> profesores10 = new ArrayList<Profesor>();
		profesores10.add(lista_profesores.get(rn.nextInt(40)));
		List<Profesor> profesores11 = new ArrayList<Profesor>();
		profesores11.add(lista_profesores.get(rn.nextInt(40)));
		List<Profesor> profesores12 = new ArrayList<Profesor>();
		profesores12.add(lista_profesores.get(rn.nextInt(40)));
		List<Profesor> profesores13 = new ArrayList<Profesor>();
		profesores13.add(lista_profesores.get(rn.nextInt(40)));
		List<Profesor> profesores14 = new ArrayList<Profesor>();
		profesores14.add(lista_profesores.get(rn.nextInt(40)));
		List<Profesor> profesores15 = new ArrayList<Profesor>();
		profesores15.add(lista_profesores.get(rn.nextInt(40)));
		List<Profesor> profesores16 = new ArrayList<Profesor>();
		profesores16.add(lista_profesores.get(rn.nextInt(40)));
		List<Profesor> profesores17 = new ArrayList<Profesor>();
		profesores17.add(lista_profesores.get(rn.nextInt(40)));
		List<Profesor> profesores18 = new ArrayList<Profesor>();
		profesores18.add(lista_profesores.get(rn.nextInt(40)));
		
		Curso u = new Curso( 1,salas, horario, alumnos1, 10, profesores, ramo1);
		historial_de_progrmacion_academica.get(0).cursos_en_progreso.add(u);
		Curso u2 = new Curso( 1,salas1, horario1, alumnos2, 10, profesores1, ramo1);
		historial_de_progrmacion_academica.get(0).cursos_en_progreso.add(u2);
		Curso u3 = new Curso( 1,salas2, horario2, alumnos3, 10, profesores2, ramo1);
		historial_de_progrmacion_academica.get(0).cursos_en_progreso.add(u3);
		Curso u4 = new Curso( 1,salas3, horario3, alumnos4, 10, profesores3, ramo1);
		historial_de_progrmacion_academica.get(0).cursos_en_progreso.add(u4);
		Curso u5 = new Curso( 1,salas4, horario4, alumnos5, 10, profesores4, ramo1);
		historial_de_progrmacion_academica.get(0).cursos_en_progreso.add(u5);
		Curso u6 = new Curso( 1,salas, horario2, alumnos6, 10, profesores, ramo1);
		historial_de_progrmacion_academica.get(0).cursos_en_progreso.add(u6);
		Curso u7 = new Curso( 1,salas1, horario4, alumnos7, 10, profesores2, ramo1);
		historial_de_progrmacion_academica.get(0).cursos_en_progreso.add(u7);
		Curso u8 = new Curso( 1,salas4, horario4, alumnos8, 10, profesores5, ramo2);
		historial_de_progrmacion_academica.get(0).cursos_en_progreso.add(u8);
		Curso u9 = new Curso( 1,salas, horario2, alumnos9, 10, profesores6, ramo2);
		historial_de_progrmacion_academica.get(0).cursos_en_progreso.add(u9);
		Curso uu = new Curso( 1,salas1, horario4, alumnos10, 10, profesores7, ramo2);
		historial_de_progrmacion_academica.get(0).cursos_en_progreso.add(uu);
		Curso uu1 = new Curso( 1,salas4, horario4, alumnos11, 10, profesores8, ramo3);
		historial_de_progrmacion_academica.get(0).cursos_en_progreso.add(uu1);
		Curso uu2 = new Curso( 1,salas, horario2, alumnos12, 10, profesores9, ramo3);
		historial_de_progrmacion_academica.get(0).cursos_en_progreso.add(uu2);	
		Curso a1 = new Curso( 1,salas4, horario4, alumnos13, 10, profesores10, ramo4);
		historial_de_progrmacion_academica.get(0).cursos_en_progreso.add(a1);
		Curso a2 = new Curso( 1,salas, horario2, alumnos14, 10, profesores11, ramo4);
		historial_de_progrmacion_academica.get(0).cursos_en_progreso.add(a2);
		Curso a3 = new Curso( 1,salas, horario2, alumnos15, 10, profesores12, ramo4);
		historial_de_progrmacion_academica.get(0).cursos_en_progreso.add(a3);
		Curso uu3 = new Curso( 1,salas4, horario4, alumnos16, 10, profesores13, ramo5);
		historial_de_progrmacion_academica.get(0).cursos_en_progreso.add(uu3);
		Curso uu4 = new Curso( 1,salas, horario2, alumnos17, 10, profesores14, ramo5);
		historial_de_progrmacion_academica.get(0).cursos_en_progreso.add(uu4);
		Curso uu5 = new Curso( 1,salas, horario2, alumnos18, 10, profesores15, ramo5);
		historial_de_progrmacion_academica.get(0).cursos_en_progreso.add(uu5);
		Curso uu6 = new Curso( 1,salas, horario2, alumnos19, 10, profesores16, ramo5);
		historial_de_progrmacion_academica.get(0).cursos_en_progreso.add(uu6);
		Curso uu7 = new Curso( 1,salas4, horario4, alumnos20, 10, profesores17, ramo6);
		historial_de_progrmacion_academica.get(0).cursos_en_progreso.add(uu7);
		Curso uu8 = new Curso( 1,salas, horario2, alumnos, 10, profesores18, ramo6);
		historial_de_progrmacion_academica.get(0).cursos_en_progreso.add(uu8);	
		lista_cursos.add(u);
		lista_cursos.add(u7);
		lista_cursos.add(u2);
		lista_cursos.add(u3);
		lista_cursos.add(u4);
		lista_cursos.add(u5);
		lista_cursos.add(u6);
		lista_cursos.add(u8);
		lista_cursos.add(u9);
		lista_cursos.add(uu);
		lista_cursos.add(uu1);
		lista_cursos.add(uu2);
		lista_cursos.add(uu3);
		lista_cursos.add(uu4);
		lista_cursos.add(uu5);
		lista_cursos.add(uu6);
		lista_cursos.add(uu7);
		lista_cursos.add(uu8);
		lista_cursos.add(a1);
		lista_cursos.add(a2);
		lista_cursos.add(a3);
		
		for (int i=0;i<10;i++){
			lista_cursos.get(0).lista_alumnos.add(lista_alumnos.get(i)); 
			lista_alumnos.get(i).getSemestreActual().Agregar_Curso(lista_cursos.get(0).id_curso);
			lista_cursos.get(20).lista_alumnos.add(lista_alumnos.get(i)); 
			lista_alumnos.get(i).getSemestreActual().Agregar_Curso(lista_cursos.get(20).id_curso);
			lista_cursos.get(13).lista_alumnos.add(lista_alumnos.get(i)); 
			lista_alumnos.get(i).getSemestreActual().Agregar_Curso(lista_cursos.get(13).id_curso);
		}
		for (int i=10;i<20;i++){
			lista_cursos.get(1).lista_alumnos.add(lista_alumnos.get(i)); 
			lista_alumnos.get(i).getSemestreActual().Agregar_Curso(lista_cursos.get(1).id_curso);
			lista_cursos.get(19).lista_alumnos.add(lista_alumnos.get(i)); 
			lista_alumnos.get(i).getSemestreActual().Agregar_Curso(lista_cursos.get(19).id_curso);
		}	
		for (int i=20;i<30;i++){
			lista_cursos.get(11).lista_alumnos.add(lista_alumnos.get(i)); 
			lista_alumnos.get(i).getSemestreActual().Agregar_Curso(lista_cursos.get(11).id_curso);
			lista_cursos.get(17).lista_alumnos.add(lista_alumnos.get(i)); 
			lista_alumnos.get(i).getSemestreActual().Agregar_Curso(lista_cursos.get(17).id_curso);
		}
		
		System.out.println(lista_cursos.get(0).lista_alumnos);
		System.out.println(lista_cursos.get(1).lista_alumnos);
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
