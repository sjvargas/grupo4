package g4;
import java.util.ArrayList;
import java.util.List;

public class Alumno {
	Historial_Academico historial_academico;
	List<Carrera> carreras;
	List<Malla_curricular> mallas_curriculares;
	boolean acceso;
	Semestre semestre_actual;
	
	public Alumno(){
		historial_academico = new Historial_Academico();
		carreras = new ArrayList<Carrera>();
		mallas_curriculares = new ArrayList<Malla_curricular>();
		acceso = true;		
	}
	
	public void Inscribir_carrera(int id_carrera){
		// agregar carrera por id, deberia hacer un buscador de carreras
		carreras.add(id_carrera);
	}
	
	public void Inscribir_malla_curricular(int id_malla){
		// agregar carrera por id, deberia hacer un buscador de carreras
		mallas_curriculares.add(id_malla);
	}
}
