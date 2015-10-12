package g4;
import java.util.ArrayList;
import java.util.List;

public class Alumno {
	private Historial_Academico historial_academico;
	// Lista de los id de las carreras a las que pertenece
	private List<Integer> carreras;
	// Lista de los id de las mallas a las que pertenece
	private List<Integer> mallas_curriculares;
	private boolean acceso;
	private Semestre semestre_actual;
	
	// Constructor
	public Alumno(){
		historial_academico = new Historial_Academico();
		carreras = new ArrayList<Integer>();
		mallas_curriculares = new ArrayList<Integer>();
		acceso = true;		
	}
	
	public void Inscribir_carrera(int id_carrera){
		// agregar carrera por id
		carreras.add(id_carrera);
	}
	
	public void Inscribir_malla_curricular(int id_malla){
		// agregar carrera por id
		mallas_curriculares.add(id_malla);
	}
	
	public Historial_Academico GetHistorialAcademico(){return historial_academico;}
	public List<Integer> GetCarreras(){return carreras;}
	public List<Integer> GetMallas(){return mallas_curriculares;}
	public boolean GetAcceso(){return acceso;}
	public Semestre GetSemestreActual(){return semestre_actual;}
}
