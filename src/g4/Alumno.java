package g4;
import java.util.ArrayList;
import java.util.List;

import fx.view.main;

public class Alumno extends Usuario implements java.io.Serializable{
	private Historial_Academico historial_academico;
	// Lista de los id de las carreras a las que pertenece
	private List<Integer> carreras;
	// Lista de los id de las mallas a las que pertenece
	private List<Integer> mallas_curriculares;
	public boolean acceso;
	private Semestre semestre_actual;
	// para  el id del alumno
    private static int NextId = 0;
	private int idAlumno;
	
	
	// Constructor
	public Alumno(String nombreUsuario, String nombre, String apellidoPaterno, String apellidoMaterno, String contrasena, Sexo sexo, int edad){
		super(nombreUsuario, nombre, apellidoPaterno, apellidoMaterno, contrasena, sexo, edad);
		this.idAlumno = NextId++;
		historial_academico = new Historial_Academico();
		carreras = new ArrayList<Integer>();
		mallas_curriculares = new ArrayList<Integer>();
		acceso = true;		
		semestre_actual = new Semestre("2015-2");
	}
	
	public void Inscribir_carrera(int id_carrera){
		// agregar carrera por id
		
		boolean carreraYaInscrita =false;
		for(int i=0;i<carreras.size();i++){
			if(carreras.get(i) == id_carrera){
				carreraYaInscrita = true;
				break;
			}
		}
		
		if(carreraYaInscrita == false){
			
			carreras.add(id_carrera);
			mallas_curriculares.add(-1);

			
		}
	}
	public void eliminar_carrera(int id_carrera){
		for(int i=0;i<carreras.size();i++){
			if(carreras.get(i) == id_carrera){
				carreras.remove(i);
				
				
				//tambien hay que remover la malla asociada
				mallas_curriculares.remove(i);
				break;
			}
		}
	}
	public int getIndiceCarrera(int id_carrera){
		for(int i=0;i<carreras.size();i++){
			if(carreras.get(i)== id_carrera){
				return i;
			}
		}
		return -1;
	}
	public int getMallaEnPosicion(int indice){
		return mallas_curriculares.get(indice);
	}
	public void Inscribir_malla_curricular(int indice,int id_malla){
		// agregar carrera por id
		//primero se borra la malla actual, luego se agrega la nueva malla (por defecto tienen -1 en mallas no inscritas)
		mallas_curriculares.remove(indice);
		mallas_curriculares.add(indice,id_malla);
	}
	
	public void setSemestreActual(Semestre semestre){
		this.semestre_actual = semestre;
	}
	
	public Semestre getSemestreActual(){
		return this.semestre_actual;
	}
	public void finalizarSemestre(){
		if(semestre_actual.semestreCerrado == true){
			this.historial_academico.agregarSemestre(semestre_actual);
		}
	}
	
	
	public boolean cumplePreRequisitos(Curso cursoTentativo){
		
		
		
		List<String> siglasRamosPreRequisitos = cursoTentativo.getRamo().GetPrerrequisitos();
		
		
		//List<Boolean> cumpleRequisito = new ArrayList<Boolean>();
		
		//iteramos sobre cada uno de los pre requisitos
		for(int i=0;i<siglasRamosPreRequisitos.size();i++){
			
			String siglaRamoRequisitoActual = siglasRamosPreRequisitos.get(i);
			
			boolean cumpleRequisitoActual = false;
			
			List<Semestre> semestres = historial_academico.getSemestres();
			
			//iteramos sobre cada uno de los semestres ya cursados
			for(int j =0;j<semestres.size();j++){
				
				Semestre semestreActual = semestres.get(j);
				List<Curso> cursosDelSemestreActual = new ArrayList<Curso>();
				List<Integer> idCursos = semestreActual.GetCursos();
				
				
				for(int z=0;z<idCursos.size();z++){
					cursosDelSemestreActual.add(main.U.getCursoConID(idCursos.get(z)));
				}
				
				
				for(int w =0;w<cursosDelSemestreActual.size();w++){
					if(cursosDelSemestreActual.get(w).getRamo().getSigla().equals(siglaRamoRequisitoActual)){
						cumpleRequisitoActual = true;
						break;
						
					}
				}
				
				
				
				if(cumpleRequisitoActual==true){
					break;
				}
				
				
			}
			
			//cumpleRequisito.add(cumpleRequisitoActual);
			
			if(cumpleRequisitoActual==false){
				return false;
			}
			
			
			
			
		}
		return true;
		
		
		
	}
	
	public boolean cumpleTopesCursoPreviamenteInscritos(Curso curso){
		
		List<String> horariosNuevoCurso = curso.getHorario();
		List<Curso> cursosYaInscritosSemestreActual = new ArrayList<Curso>();
		List<Integer> idCursos = semestre_actual.GetCursos();
		
		/* Con el siguiente metodo se CONSIDERA TOPE CON EL MISMO CURSO SI YA ESTA INCRITO EL CURSO QUE QUEREMOS INSCRIBIR
		for(int z=0;z<idCursos.size();z++){
			cursosYaInscritosSemestreActual.add(main.U.getCursoConID(idCursos.get(z)));
		}
		*/
		
		// NO TIRA TOPE AL EVALUAR CON EL MISMO CURSO YA INSCRITO
		for(int z=0;z<idCursos.size();z++){
			if(idCursos.get(z).equals(curso.getId_curso())==false){
				cursosYaInscritosSemestreActual.add(main.U.getCursoConID(idCursos.get(z)));

			}
		}
		
		//vamos uno por uno los horarios del nuevo curso		
		for(int i=0;i<horariosNuevoCurso.size();i++){
			
			String horarioActual = horariosNuevoCurso.get(i);
			
			// recorremos todos los cursos ya inscritos
			for(int j=0;j<cursosYaInscritosSemestreActual.size();j++){
				List<String> horariosCursoYaInscritoActual = cursosYaInscritosSemestreActual.get(j).getHorario();
				
				
				//recorremos todos los horarios de cada curso ya inscrito
				for(int z=0;z<horariosCursoYaInscritoActual.size();z++){
					if(horarioActual.equals(horariosCursoYaInscritoActual.get(z))){
						return false;
					}
				}
			}
			
		}
		return true;
		
		
		
	}
	
	
	public boolean haCursadoEsteRamo(Ramo ramo){
		String siglaRamoAEvaluar= ramo.getSigla();
		
		
		List<Semestre> semestres = historial_academico.getSemestres();
		
		//iteramos sobre cada uno de los semestres ya cursados
		for(int j =0;j<semestres.size();j++){
			
			Semestre semestreActual = semestres.get(j);
			List<Curso> cursosDelSemestreActual = new ArrayList<Curso>();
			List<Integer> idCursos = semestreActual.GetCursos();
			
			
			for(int z=0;z<idCursos.size();z++){
				cursosDelSemestreActual.add(main.U.getCursoConID(idCursos.get(z)));
			}
			
			
			for(int w =0;w<cursosDelSemestreActual.size();w++){
				if(cursosDelSemestreActual.get(w).getRamo().getSigla().equals(siglaRamoAEvaluar)){
					return true;
					
				}
			}
			
			
			
			
			
			
		}
		
		
		return false;
		
		
	}
	
	public int getCreditosAprobados(){ return historial_academico.getCreditosAprobados();}
	public int getCreditosReprobados() { return historial_academico.getCreditosReprobados();}
	public int getIdAlumno(){ return idAlumno;}
	public Historial_Academico GetHistorialAcademico(){return historial_academico;}
	public List<Integer> GetCarreras(){return carreras;}
	public List<Integer> GetMallas(){return mallas_curriculares;}
	public boolean getAcceso(){return acceso;}
	public Semestre GetSemestreActual(){return semestre_actual;}
}
