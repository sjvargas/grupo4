package g4;
import java.util.ArrayList;
import java.util.List;

public class Alumno extends Usuario {
	private Historial_Academico historial_academico;
	// Lista de los id de las carreras a las que pertenece
	private List<Carrera> carreras;
	// Lista de los id de las mallas a las que pertenece
	private List<Malla_curricular> mallas_curriculares;
	public boolean acceso;
	private Semestre semestre_actual;
	
	// Constructor
	public Alumno(String nom, String cont, String sex, int ed){
		//	public Usuario(String nom, String cont, String sex, int ed){
		super(nom, cont, sex, ed);

		historial_academico = new Historial_Academico();
		carreras = new ArrayList<Carrera>();
		mallas_curriculares = new ArrayList<Malla_curricular>();
		acceso = true;		
	}
	
	public void Inscribir_carrera(Carrera carrera){
		// agregar carrera por id
		if (!carreras.contains(carrera)){
			carreras.add(carrera);
		}
	}
	
	public void setSemestreActual(Semestre semestre){
		this.semestre_actual = semestre;
	}
	
	public void Inscribir_malla_curricular(Malla_curricular malla){
		// agregar carrera por id
		mallas_curriculares.add(malla);
	}
	
	public Historial_Academico GetHistorialAcademico(){return historial_academico;}
	public List<Carrera> GetCarreras(){return carreras;}
	public List<Malla_curricular> GetMallas(){return mallas_curriculares;}
	public boolean GetAcceso(){return acceso;}
	public Semestre GetSemestreActual(){return semestre_actual;}

	public void eliminar_carrera(String carreraAEliminar){
		for(int i=0;i<carreras.size();i++){
			if(carreras.get(i).getnombre_carrera().equals(carreraAEliminar)){
				carreras.remove(i);
				break;
			}
		}
	}
}
