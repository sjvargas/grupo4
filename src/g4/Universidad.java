package g4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fx.view.main;

public class Universidad implements java.io.Serializable {

	public List<Programacion_Academica> historial_de_progrmacion_academica;
    private Random rn;
	
    private List<String> periodosOcupados;
    private List<String> periodosLibres;

    public List<String> dias;
    public List<String> listaSalas;
    public List<Integer> listaModulos;
    public List<Integer> listaCreditos;
    
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
	public String periodo_actual = "2016-1";
	
	public Universidad(){
		
		historial_de_progrmacion_academica = new ArrayList<Programacion_Academica>();
		periodosOcupados = new ArrayList<String>();
		periodosLibres = new ArrayList<String>();
		lista_carreras = new ArrayList<Carrera>();
		lista_profesores = new ArrayList<Profesor>();
		lista_ramos = new ArrayList<Ramo>();		
		lista_alumnos = new ArrayList<Alumno>();
		lista_administradores = new ArrayList<Administrador_academico>();
		buscador = new Buscador_de_cursos();
		lista_cursos = new ArrayList<Curso>();
		Programa programas;
		programas= null;
		try {
			programas = new Programa();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rn = new Random();

		alumno_actual = null;
		profesor_actual = null;
		administrador_actual = null;
		
		lista_profesores.add( new Profesor("juana","juana", "Hidalgo", "Jullian", "123", Sexo.Femenino, 62, 2200000, "Ingenieria"));
		lista_profesores.add( new Profesor("ian", "ian", "sapallo", "casuela", "123", Sexo.Masculino, 42, 2000000, "Ingenieria"));

		lista_profesores.add( new Profesor("jorge", "jorge", "zanahoria", "ensalada", "123", Sexo.Masculino, 45, 1000000, "Ingenieria"));
		lista_profesores.add( new Profesor("jaime", "jaime", "vargas", "vargas", "123", Sexo.Femenino, 55, 2200000, "Ingenieria"));
		
		lista_profesores.get(0).DarLike();lista_profesores.get(0).DarLike();lista_profesores.get(0).DarLike();lista_profesores.get(0).DarLike();lista_profesores.get(0).DarLike();
		lista_profesores.get(1).DarLike();lista_profesores.get(1).DarLike();lista_profesores.get(1).DarLike();
		lista_profesores.get(2).DarLike();lista_profesores.get(2).DarLike();lista_profesores.get(2).DarLike();lista_profesores.get(2).DarLike();
		lista_profesores.get(3).DarLike();lista_profesores.get(3).DarLike();lista_profesores.get(3).DarLike();
		lista_profesores.get(0).DarDificultad((double) 5);lista_profesores.get(0).DarDificultad((double) 5);lista_profesores.get(0).DarDificultad((double) 5);lista_profesores.get(0).DarDificultad((double) 5);
		lista_profesores.get(1).DarDificultad((double) 4);lista_profesores.get(1).DarDificultad((double) 4);lista_profesores.get(1).DarDificultad((double) 4);lista_profesores.get(1).DarDificultad((double) 4);
		lista_profesores.get(2).DarDificultad((double) 1);lista_profesores.get(2).DarDificultad((double) 1);lista_profesores.get(2).DarDificultad((double) 1);lista_profesores.get(2).DarDificultad((double) 1);
		lista_profesores.get(3).DarDificultad((double) 1);lista_profesores.get(3).DarDificultad((double) 1);lista_profesores.get(3).DarDificultad((double) 1);lista_profesores.get(3).DarDificultad((double) 1);lista_profesores.get(3).DarDificultad((double) 1);
		String[] user_names = {"oscar","alejandra","mario","felipe","luigi","miguel","laura","ines","carmen","elena","maria",
		              "jose","ana","alex","clemente","domingo","tomas","raul","luis","elisa","tere","sofia","alex","jairo",
		              "sam","mikey","piro","pascal","damian","tzo","vermont","pug","simon","farras","lola","almendra","manzana","tambor","bambi","negra","raimuno"};
		
		String[] user_last_names = {"Morillas", "Andrade","Mera De Los Santos","Barriga", "Espinosa","Buendia","Iranzo","Gaya",
				"Espinar","Barrionuevo","Peiro","Gabaldon","Moro","Davila","Martinez","Lopez Bauza","Holguin","Sotelo",
				"Paniagua","Gandia","hidalgo","jullian","perez","alvarez","correa","besa","toro","wulf","drago","rios","romani","carmona"};

		Sexo[] sex = {Sexo.Masculino,Sexo.Femenino};
		String[] fac = {"Medicina", "Ingenieria","Artes","Arquitectura diseño y estudios urbanos","Ciencias Biológicas"};
		
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
		
		
			periodosLibres.add("2015-2");
		for(int i=2016; i<= 2022; i++){
			periodosLibres.add(i+"-1");
			periodosLibres.add(i+"-2");
		}
		
		listaSalas = new ArrayList<String>();
		for(Integer i=1; i<27; i++){
			listaSalas.add("A".concat(i.toString()));
			listaSalas.add("B".concat(i.toString()));
			listaSalas.add("N".concat(i.toString()));
		}
		
		//carreras parten desde indice 1 nombreUsuario, nombre, apellidoPaterno, apellidoMaterno, contrasena, sexo, edad
		lista_alumnos.add(new Alumno("juan","juan", "perez", "lopez", "123", Sexo.Masculino, 20 ));
		lista_alumnos.add(new Alumno("max", "max", "garcia", "sanchez", "1", Sexo.Masculino, 21 ));
		
		
		
		lista_administradores.add( new Administrador_academico("ana", "ana", "guzman", "alvarez","123",Sexo.Femenino, 40));

		lista_carreras.add(new Carrera("Juan Carlos","Ingenieria", "Ingenieria"));
		lista_carreras.add(new Carrera("Juan Carlos","Ingenieria", "Construccion civil"));
		lista_carreras.add(new Carrera("Martin Chuaqui Farrú","Matemáticas", "Matemáticas"));
		lista_carreras.add(new Carrera("Luis Ibáñez Anríque","Medicina", "Medicina"));
		lista_carreras.add(new Carrera("Luis Ibáñez Anríque","Medicina", "Enfermeria"));
		lista_carreras.add(new Carrera("Juan Correa Maldonado","Ciencias Biológicas", "Ciencias Biológicas"));
		lista_carreras.add(new Carrera("Mario Ubilla Sanz","Arquitectura diseño y estudios urbanos", "Arquitectura"));
		lista_carreras.add(new Carrera("Mario Ubilla Sanz","Arquitectura diseño y estudios urbanos", "Diseño"));
		lista_carreras.add(new Carrera("Mario Ubilla Sanz","Arquitectura diseño y estudios urbanos", "Estudios Urbanos"));
		lista_carreras.add(new Carrera("Patricio Correa", "Artes", "Teatro"));
		lista_carreras.add(new Carrera("Patricio Correa", "Artes", "Coreografia"));
		
		dias = new ArrayList<String>();
		dias.add("Lunes");
		dias.add("Martes");
		dias.add("Miercoles");
		dias.add("Jueves");
		dias.add("Viernes");
		dias.add("Sabado");
		listaModulos = new ArrayList<Integer>();
		for(Integer i=1; i<9;i++){
			listaModulos.add(i);
		}
		listaCreditos = new ArrayList<Integer>();
		for(Integer i=1; i<51;i++){
			listaCreditos.add(i);
		}
		
		historial_de_progrmacion_academica.add(new Programacion_Academica("2015-2"));
		UsarPeriodo("2015-2");
		historial_de_progrmacion_academica.add(new Programacion_Academica("2016-1"));
		UsarPeriodo("2016-1");
		
		lista_alumnos.get(0).Inscribir_carrera(2);
		Malla_curricular malla1 = new Malla_curricular();
		Malla_curricular malla2 = new Malla_curricular();
		
		lista_carreras.get(0).crear_malla_curricular(malla1);
		lista_carreras.get(0).crear_malla_curricular(malla2);
		
		Ramo ramo1 = new Ramo("Calculo 1","MAT1610", 10, lista_carreras.get(2),"3");
		Ramo ramo2 = new Ramo("Calculo 2","MAT1620", 10, lista_carreras.get(2),"3");
		Ramo ramo3 = new Ramo("Calculo 3","MAT1630", 10, lista_carreras.get(2),"3");
		Ramo ramo4 = new Ramo("algebra lineal","MAT1299", 10, lista_carreras.get(2),"3");
		Ramo ramo5 = new Ramo("Introducción a la Programación","IIC1103", 10, lista_carreras.get(0),"3");
		Ramo ramo6 = new Ramo("Programación Avanzada","IIC2233", 10, lista_carreras.get(0),"3");
		lista_ramos.add(ramo1);lista_ramos.add(ramo2);lista_ramos.add(ramo3);lista_ramos.add(ramo4);lista_ramos.add(ramo5);lista_ramos.add(ramo6);

		System.out.println(programas.lista_programas.size());
		ramo1.agregarPrograma(programas.lista_programas.get(0));
		ramo2.agregarPrograma(programas.lista_programas.get(1));
		ramo3.agregarPrograma(programas.lista_programas.get(2));
		ramo4.agregarPrograma(programas.lista_programas.get(3));
		ramo6.agregarPrograma(programas.lista_programas.get(4));

		malla1.agregar_ramo(ramo1);
		malla1.agregar_ramo(ramo2);

		ramo1.DarLike();ramo1.DarLike();ramo1.DarLike();ramo1.DarLike();ramo1.DarLike();ramo1.DarLike();
		ramo2.DarLike();ramo2.DarLike();ramo2.DarLike();ramo2.DarLike();ramo2.DarLike();
		ramo3.DarLike();ramo3.DarLike();ramo3.DarLike();ramo3.DarLike();ramo3.DarLike();ramo3.DarLike();ramo3.DarLike();
		ramo4.DarLike();ramo4.DarLike();ramo4.DarLike();ramo4.DarLike();ramo4.DarLike();
		ramo5.DarLike();ramo5.DarLike();ramo5.DarLike();
		ramo6.DarLike();ramo6.DarLike();ramo6.DarLike();ramo6.DarLike();ramo6.DarLike();ramo6.DarLike();ramo6.DarLike();ramo6.DarLike();
		
		ramo1.DarDificultad((double) 5);ramo1.DarDificultad((double) 5);ramo1.DarDificultad((double) 5);ramo1.DarDificultad((double) 5);
		ramo2.DarDificultad((double) 1);ramo2.DarDificultad((double) 1);ramo2.DarDificultad((double) 1);ramo2.DarDificultad((double) 1);
		ramo3.DarDificultad((double) 1);ramo3.DarDificultad((double) 1);ramo3.DarDificultad((double) 1);
		ramo4.DarDificultad((double) 4);ramo4.DarDificultad((double) 4);ramo4.DarDificultad((double) 4);ramo4.DarDificultad((double) 4);
		ramo5.DarDificultad((double) 2);ramo5.DarDificultad((double) 2);ramo5.DarDificultad((double) 2);ramo5.DarDificultad((double) 2);

		ramo2.DarUtilidad((double) 5);ramo2.DarUtilidad((double) 5);ramo2.DarUtilidad((double) 5);ramo2.DarUtilidad((double) 5);
		ramo4.DarUtilidad((double) 1);ramo4.DarUtilidad((double) 1);ramo4.DarUtilidad((double) 1);ramo4.DarUtilidad((double) 1);
		ramo5.DarUtilidad((double) 1);ramo5.DarUtilidad((double) 1);ramo5.DarUtilidad((double) 1);
		ramo1.DarUtilidad((double) 4);ramo1.DarUtilidad((double) 4);ramo1.DarUtilidad((double) 4);ramo1.DarUtilidad((double) 4);
		ramo3.DarUtilidad((double) 2);ramo3.DarUtilidad((double) 2);ramo3.DarUtilidad((double) 2);ramo3.DarUtilidad((double) 2);

		
		ramo2.AgregarPrerrequisito(ramo1.getSigla());
		ramo3.AgregarPrerrequisito(ramo2.getSigla());
		ramo6.AgregarPrerrequisito(ramo5.getSigla());
		
		
		malla1.agregar_ramo(ramo1);
		malla1.agregar_ramo(ramo2);
		malla1.agregar_ramo(ramo3);
		malla1.agregar_ramo(ramo4);
	
		
		malla2.agregar_ramo(ramo1);
		malla2.agregar_ramo(ramo2);
		malla2.agregar_ramo(ramo3);
		malla2.agregar_ramo(ramo4);
		malla2.agregar_ramo(ramo5);
		malla2.agregar_ramo(ramo6);


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

		
		//int semestre,List<String> salas,List<String> horario, int creditos, int seccion , Profesor profesor, Ramo ramo		
		Curso u = new Curso( "2016-1",salas, horario, 10, 1, lista_profesores.get(0), ramo1);
		historial_de_progrmacion_academica.get(1).cursos_en_progreso.add(u);
		Curso u2 = new Curso( "2016-1",salas1, horario1, 10, 2, lista_profesores.get(1), ramo1);
		historial_de_progrmacion_academica.get(1).cursos_en_progreso.add(u2);
		Curso u3 = new Curso( "2016-1",salas2, horario2, 10, 3, lista_profesores.get(2), ramo1);
		historial_de_progrmacion_academica.get(1).cursos_en_progreso.add(u3);
		Curso u4 = new Curso( "2016-1",salas3, horario3, 10, 4, lista_profesores.get(3), ramo1);
		historial_de_progrmacion_academica.get(1).cursos_en_progreso.add(u4);
		Curso u5 = new Curso( "2016-1",salas4, horario4, 10, 5, lista_profesores.get(0), ramo1);
		historial_de_progrmacion_academica.get(1).cursos_en_progreso.add(u5);
		Curso u6 = new Curso( "2016-1",salas, horario2, 10, 6, lista_profesores.get(0), ramo1);
		historial_de_progrmacion_academica.get(1).cursos_en_progreso.add(u6);
		Curso u7 = new Curso( "2016-1",salas1, horario4, 10, 7, lista_profesores.get(2), ramo1);
		historial_de_progrmacion_academica.get(1).cursos_en_progreso.add(u7);
		Curso u8 = new Curso( "2016-1",salas4, horario4, 10, 1, lista_profesores.get(rn.nextInt(40)), ramo2);
		historial_de_progrmacion_academica.get(1).cursos_en_progreso.add(u8);
		Curso u9 = new Curso( "2016-1",salas, horario2, 10, 2, lista_profesores.get(rn.nextInt(40)), ramo2);
		historial_de_progrmacion_academica.get(1).cursos_en_progreso.add(u9);
		Curso uu = new Curso( "2016-1",salas1, horario4, 10, 3, lista_profesores.get(rn.nextInt(40)), ramo2);
		historial_de_progrmacion_academica.get(1).cursos_en_progreso.add(uu);
		Curso uu1 = new Curso( "2016-1",salas4, horario4, 10, 1, lista_profesores.get(rn.nextInt(40)), ramo3);
		historial_de_progrmacion_academica.get(1).cursos_en_progreso.add(uu1);
		Curso uu2 = new Curso( "2016-1",salas, horario2, 10, 2, lista_profesores.get(rn.nextInt(40)), ramo3);
		historial_de_progrmacion_academica.get(1).cursos_en_progreso.add(uu2);	
		Curso a1 = new Curso( "2016-1",salas4, horario4, 10, 1, lista_profesores.get(rn.nextInt(40)), ramo4);
		historial_de_progrmacion_academica.get(1).cursos_en_progreso.add(a1);
		Curso a2 = new Curso( "2016-1",salas, horario2, 10, 2, lista_profesores.get(rn.nextInt(40)), ramo4);
		historial_de_progrmacion_academica.get(1).cursos_en_progreso.add(a2);
		Curso a3 = new Curso( "2016-1",salas, horario2, 10, 3, lista_profesores.get(rn.nextInt(40)), ramo4);
		historial_de_progrmacion_academica.get(1).cursos_en_progreso.add(a3);
		Curso uu3 = new Curso( "2016-1",salas4, horario4, 10, 1, lista_profesores.get(rn.nextInt(40)), ramo5);
		historial_de_progrmacion_academica.get(1).cursos_en_progreso.add(uu3);
		Curso uu4 = new Curso( "2016-1",salas, horario2, 10, 2, lista_profesores.get(rn.nextInt(40)), ramo5);
		historial_de_progrmacion_academica.get(1).cursos_en_progreso.add(uu4);
		Curso uu5 = new Curso( "2016-1",salas, horario2, 10, 3, lista_profesores.get(rn.nextInt(40)), ramo5);
		historial_de_progrmacion_academica.get(1).cursos_en_progreso.add(uu5);
		Curso uu6 = new Curso( "2016-1",salas, horario2, 10, 4, lista_profesores.get(rn.nextInt(40)), ramo5);
		historial_de_progrmacion_academica.get(1).cursos_en_progreso.add(uu6);
		Curso uu7 = new Curso( "2016-1",salas4, horario4, 10, 1, lista_profesores.get(rn.nextInt(40)), ramo6);
		historial_de_progrmacion_academica.get(1).cursos_en_progreso.add(uu7);
		Curso uu8 = new Curso( "2016-1",salas, horario2, 10, 2, lista_profesores.get(rn.nextInt(40)), ramo6);
		historial_de_progrmacion_academica.get(1).cursos_en_progreso.add(uu8);	
		
		
		lista_cursos.add(u);lista_cursos.add(u2);lista_cursos.add(u3);lista_cursos.add(u4);lista_cursos.add(u5);
		lista_cursos.add(u6);lista_cursos.add(u7);lista_cursos.add(u8);lista_cursos.add(u9);lista_cursos.add(uu);
		lista_cursos.add(uu1);lista_cursos.add(uu2);lista_cursos.add(uu3);lista_cursos.add(uu4);
		lista_cursos.add(uu5);lista_cursos.add(uu6);lista_cursos.add(uu7);lista_cursos.add(uu8);
		lista_cursos.add(a1);lista_cursos.add(a2);lista_cursos.add(a3);
		
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
		
		
		lista_cursos.get(0).AgregarTema("duda contenido i1", "hola! \n Estaba revisando la materia y no se si entra todo de derivadas o no, ¿Alguien sabe? \n Gracias!",lista_alumnos.get(0),"alumno");
		lista_cursos.get(0).AgregarTema("duda regla de la cadena","Disculpen pero no logro entender la regla de la cadena para derivar. ¿Podrian darme un link donde se explique bien",lista_alumnos.get(1),"alumno");
		lista_cursos.get(0).AgregarTema("Se cansela la proxima clase", "Estimados, \n por temas personales, la proxima clase se cancela, avisenle a sus compañeros. \n Atte Mar Hidalgo",lista_profesores.get(0),"profesor");
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
	
	
	public Curso getCursoConSiglaYSeccion(String sigla,int seccion ){
		for(int i=0;i<lista_cursos.size();i++){
			
			System.out.println("sigla: "+lista_cursos.get(i).getRamo().getSigla()+"    Seccion: "+lista_cursos.get(i).getSeccionCurso());
			if(lista_cursos.get(i).getRamo().getSigla().equalsIgnoreCase(sigla) && lista_cursos.get(i).getSeccionCurso() == seccion ){
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
	public Profesor GetProfesor(int ID){
		for (Profesor i : lista_profesores){
			if(i.getId_profesor()== ID){
				return i;
			}
		}
		return null;
	}
	
	public Programacion_Academica GetProgramacionAcademicaPeriodo(String periodo){
		for(Programacion_Academica programacion: historial_de_progrmacion_academica){
			if(programacion.periodo.equals(periodo)){
				return programacion;
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
	
	public void UsarPeriodo(String periodo){
		periodosLibres.remove(periodo);
		periodosOcupados.add(periodo);
	}

	public List<String> GetNombresProfesores(){
		List<String> listaRetorno = new ArrayList<String>();
		for (Profesor p: lista_profesores){
			listaRetorno.add(p.getNombre()+" "+p.getApellidoPaterno()+" "+p.getApellidoPaterno());
		}
		return listaRetorno;
	}
	
	public void RestringirAccesoAlumno(int idAlumnoRestringido){
		for(Alumno alumno: lista_alumnos){
			if(alumno.getIdAlumno() == idAlumnoRestringido){
				alumno.acceso = false;
			}
		}
	}

	public Integer EstaDisponibleHorario(ProgramacionHoraria programacionHoraria, int idProfesor){
		// revisa si esta disponible el profesor y la sala. Retorna 0 si esta disponible, 1 si el sala no lo esta y 2 si la profesor no lo esta
		for(Curso curso: lista_cursos){
			for(ProgramacionHoraria pH: curso.getListaProgramacionHoraria()){
				if(pH.getDia().equals(programacionHoraria.getDia()) && 
						pH.getModulo().equals(programacionHoraria.getModulo())){
					if(curso.HaceClasesProfesor(idProfesor)){
						return 2;
					}
					if(pH.getSala().equals(programacionHoraria.getSala())){
						return 1;
					}
				}
			}
		}
		return 0;
	}

	public List<Curso> getCursosProgramacionAcademica(String periodo){
		for(Programacion_Academica PA: historial_de_progrmacion_academica){
			if(PA.periodo.equals(periodo)){
				return PA.cursos_en_progreso;
			}
		}
		return null;
	}
	public List<String> getPeriodosLibres(){ return periodosLibres;}
	public List<String> getPeriodosOcupados(){ return periodosOcupados;}

	public boolean CursoSeAgregoALista(int idCurso){
		for(Curso curso: lista_cursos){
			if(curso.id_curso == idCurso){
				return true;
			}
		}
		return false;
	}
	
	public List<String> getFacultades(){
		List<String> listaRetorno = new ArrayList<String>();
		boolean seAgrego = false;
		for(Carrera carrera: lista_carreras){
			for(String nombreFacultad: listaRetorno){
				if(nombreFacultad.equals(carrera.getFacultad())){
					seAgrego = true;
				}
			}
			if(!seAgrego){
				listaRetorno.add(carrera.getFacultad());
			}
			seAgrego = false;
		}
		return listaRetorno;
	}
	public void EliminarProfesor(int idProfesor){
		for(Profesor profesor: lista_profesores){
			if(profesor.getId_profesor()==idProfesor){
				lista_profesores.remove(profesor);
			}
		}
	}
	public List<Ramo> BuscarRamos (String texto1){
		String texto= texto1.toLowerCase();
		List<Ramo> lista = new ArrayList<Ramo>();
		for (Ramo i : lista_ramos){
			if ( i.getSigla().toLowerCase().contains(texto) || i.getNombreRamo().toLowerCase().contains(texto)){
				lista.add(i);
			}
		}
		return lista;
	}	
	public List<Profesor> BuscarProfesores (String texto1){
		String texto= texto1.toLowerCase();
		List<Profesor> lista = new ArrayList<Profesor>();
		for (Profesor i : lista_profesores){
			if (i.toString().toLowerCase().contains(texto)){
				lista.add(i);
			}
		}
		return lista;
	}
	public Ramo GetRandomRamo(){
		return lista_ramos.get(rn.nextInt(lista_ramos.size()));
	}
	public Profesor GetRandomProfesor(){
		return lista_profesores.get(rn.nextInt(lista_profesores.size()));
	}
	//sentido dice si es acendente o decreciente (1,0)
	//tipo dice que atributo se compara (1=likes,2=dificultad)
	public List<Profesor> Top5Profesores(int sentido,int tipo){
		List<Profesor> lista = new ArrayList<Profesor>();
		lista.add(null);lista.add(null);lista.add(null);lista.add(null);lista.add(null);
		if (sentido==1){//acendente
			if (tipo==1){ // likes
				for(Profesor p : lista_profesores){
					for (int i=0;i<5;i++){
						if (lista.get(i)==null){
							lista.set(i, p);
						}else{
							if (lista.get(i).getLikes()<=p.getLikes()){
								if (i==0){
									lista.set(4, lista.get(3));
									lista.set(3, lista.get(2));
									lista.set(2, lista.get(1));
									lista.set(1, lista.get(i));
									lista.set(i, p);
								}else if (i==1){
									lista.set(4, lista.get(3));
									lista.set(3, lista.get(2));
									lista.set(2, lista.get(i));
									lista.set(i, p);
								}else if (i==2){
									lista.set(4, lista.get(3));
									lista.set(3, lista.get(i));
									lista.set(i, p);
								}else if (i==3){
									lista.set(4, lista.get(i));
									lista.set(i, p);
								}else{lista.set(i, p);}
								break;}}}}
			}else{//dificultad
				for(Profesor p : lista_profesores){
					for (int i=0;i<5;i++){
						if (lista.get(i)==null){
							lista.set(i, p);
						}else{
							if (lista.get(i).getDificultad()<=p.getDificultad()){
								if (i==0){
									lista.set(4, lista.get(3));
									lista.set(3, lista.get(2));
									lista.set(2, lista.get(1));
									lista.set(1, lista.get(i));
									lista.set(i, p);
								}else if (i==1){
									lista.set(4, lista.get(3));
									lista.set(3, lista.get(2));
									lista.set(2, lista.get(i));
									lista.set(i, p);
								}else if (i==2){
									lista.set(4, lista.get(3));
									lista.set(3, lista.get(i));
									lista.set(i, p);
								}else if (i==3){
									lista.set(4, lista.get(i));
									lista.set(i, p);
								}else{lista.set(i, p);}
								break;}}}}}
		}else{// decreciente
			if (tipo==1){ // likes
				for(Profesor p : lista_profesores){
					for (int i=0;i<5;i++){
						if (lista.get(i)==null){
							lista.set(i, p);
						}else{
							if (lista.get(i).getLikes()>=p.getLikes()){
								if (i==0){
									lista.set(4, lista.get(3));
									lista.set(3, lista.get(2));
									lista.set(2, lista.get(1));
									lista.set(1, lista.get(i));
									lista.set(i, p);
								}else if (i==1){
									lista.set(4, lista.get(3));
									lista.set(3, lista.get(2));
									lista.set(2, lista.get(i));
									lista.set(i, p);
								}else if (i==2){
									lista.set(4, lista.get(3));
									lista.set(3, lista.get(i));
									lista.set(i, p);
								}else if (i==3){
									lista.set(4, lista.get(i));
									lista.set(i, p);
								}else{lista.set(i, p);}
								break;}}}}
			}else{//dificultad
				for(Profesor p : lista_profesores){
					for (int i=0;i<5;i++){
						if (lista.get(i)==null){
							lista.set(i, p);
						}else{
							if (lista.get(i).getDificultad()>=p.getDificultad()){
								if (i==0){
									lista.set(4, lista.get(3));
									lista.set(3, lista.get(2));
									lista.set(2, lista.get(1));
									lista.set(1, lista.get(i));
									lista.set(i, p);
								}else if (i==1){
									lista.set(4, lista.get(3));
									lista.set(3, lista.get(2));
									lista.set(2, lista.get(i));
									lista.set(i, p);
								}else if (i==2){
									lista.set(4, lista.get(3));
									lista.set(3, lista.get(i));
									lista.set(i, p);
								}else if (i==3){
									lista.set(4, lista.get(i));
									lista.set(i, p);
								}else{lista.set(i, p);}
								break;}}}}}}	
		return lista;
	}

	//sentido dice si es acendente o decreciente (1,0)
	//tipo dice que atributo se compara (1=likes,2=dificultad,3=utilidad)
	public List<Ramo> Top5Ramos(int sentido,int tipo){
		List<Ramo> lista = new ArrayList<Ramo>();
		lista.add(null);lista.add(null);lista.add(null);lista.add(null);lista.add(null);
		if (sentido==1){//acendente
			if (tipo==1){ // likes
				for(Ramo p : lista_ramos){
					for (int i=0;i<5;i++){
						if (lista.get(i)==null){
							lista.set(i, p);
						}else{
							if (lista.get(i).getLikes()<=p.getLikes()){
								if (i==0){
									lista.set(4, lista.get(3));
									lista.set(3, lista.get(2));
									lista.set(2, lista.get(1));
									lista.set(1, lista.get(i));
									lista.set(i, p);
								}else if (i==1){
									lista.set(4, lista.get(3));
									lista.set(3, lista.get(2));
									lista.set(2, lista.get(i));
									lista.set(i, p);
								}else if (i==2){
									lista.set(4, lista.get(3));
									lista.set(3, lista.get(i));
									lista.set(i, p);
								}else if (i==3){
									lista.set(4, lista.get(i));
									lista.set(i, p);
								}else{
									lista.set(i, p);
								}
								break;}}}}
			}else if (tipo==3){
				for(Ramo p : lista_ramos){
					for (int i=0;i<5;i++){
						if (lista.get(i)==null){
							lista.set(i, p);
						}else{
							if (lista.get(i).getUtilidad()<=p.getUtilidad()){
								if (i==0){
									lista.set(4, lista.get(3));
									lista.set(3, lista.get(2));
									lista.set(2, lista.get(1));
									lista.set(1, lista.get(i));
									lista.set(i, p);
								}else if (i==1){
									lista.set(4, lista.get(3));
									lista.set(3, lista.get(2));
									lista.set(2, lista.get(i));
									lista.set(i, p);
								}else if (i==2){
									lista.set(4, lista.get(3));
									lista.set(3, lista.get(i));
									lista.set(i, p);
								}else if (i==3){
									lista.set(4, lista.get(i));
									lista.set(i, p);
								}else{
									lista.set(i, p);
								}
								break;}}}}
			}else {//dificultad
				for(Ramo p : lista_ramos){
					for (int i=0;i<5;i++){
						if (lista.get(i)==null){
							lista.set(i, p);
						}else{
							if (lista.get(i).getDificultad()<=p.getDificultad()){
								if (i==0){
									lista.set(4, lista.get(3));
									lista.set(3, lista.get(2));
									lista.set(2, lista.get(1));
									lista.set(1, lista.get(i));
									lista.set(i, p);
								}else if (i==1){
									lista.set(4, lista.get(3));
									lista.set(3, lista.get(2));
									lista.set(2, lista.get(i));
									lista.set(i, p);
								}else if (i==2){
									lista.set(4, lista.get(3));
									lista.set(3, lista.get(i));
									lista.set(i, p);
								}else if (i==3){
									lista.set(4, lista.get(i));
									lista.set(i, p);
								}else{
									lista.set(i, p);
								}
								break;}}}}}
		}else{// decreciente
			if (tipo==1){ // likes
				for(Ramo p : lista_ramos){
					for (int i=0;i<5;i++){
						if (lista.get(i)==null){
							lista.set(i, p);
						}else{
							if (lista.get(i).getLikes()>=p.getLikes()){
								if (i==0){
									lista.set(4, lista.get(3));
									lista.set(3, lista.get(2));
									lista.set(2, lista.get(1));
									lista.set(1, lista.get(i));
									lista.set(i, p);
								}else if (i==1){
									lista.set(4, lista.get(3));
									lista.set(3, lista.get(2));
									lista.set(2, lista.get(i));
									lista.set(i, p);
								}else if (i==2){
									lista.set(4, lista.get(3));
									lista.set(3, lista.get(i));
									lista.set(i, p);
								}else if (i==3){
									lista.set(4, lista.get(i));
									lista.set(i, p);
								}else{
									lista.set(i, p);
								}
								break;}}}}
			}else if (tipo==3){ // utilidad
				for(Ramo p : lista_ramos){
					for (int i=0;i<5;i++){
						if (lista.get(i)==null){
							lista.set(i, p);
						}else{
							if (lista.get(i).getUtilidad()>=p.getUtilidad()){
								if (i==0){
									lista.set(4, lista.get(3));
									lista.set(3, lista.get(2));
									lista.set(2, lista.get(1));
									lista.set(1, lista.get(i));
									lista.set(i, p);
								}else if (i==1){
									lista.set(4, lista.get(3));
									lista.set(3, lista.get(2));
									lista.set(2, lista.get(i));
									lista.set(i, p);
								}else if (i==2){
									lista.set(4, lista.get(3));
									lista.set(3, lista.get(i));
									lista.set(i, p);
								}else if (i==3){
									lista.set(4, lista.get(i));
									lista.set(i, p);
								}else{
									lista.set(i, p);
								}
								break;}}}}
			}else {//dificultad
				for(Ramo p : lista_ramos){
					for (int i=0;i<5;i++){
						if (lista.get(i)==null){
							lista.set(i, p);
						}else{
							if (lista.get(i).getDificultad()>=p.getDificultad()){
								if (i==0){
									lista.set(4, lista.get(3));
									lista.set(3, lista.get(2));
									lista.set(2, lista.get(1));
									lista.set(1, lista.get(i));
									lista.set(i, p);
								}else if (i==1){
									lista.set(4, lista.get(3));
									lista.set(3, lista.get(2));
									lista.set(2, lista.get(i));
									lista.set(i, p);
								}else if (i==2){
									lista.set(4, lista.get(3));
									lista.set(3, lista.get(i));
									lista.set(i, p);
								}else if (i==3){
									lista.set(4, lista.get(i));
									lista.set(i, p);
								}else{
									lista.set(i, p);
								}
								break;}}}}}}	
		return lista;
	}
}



