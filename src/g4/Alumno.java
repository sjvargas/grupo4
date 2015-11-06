package g4;
import java.util.ArrayList;
import java.util.List;

public class Alumno extends Usuario {
	private Historial_Academico historial_academico;
	// Lista de los id de las carreras a las que pertenece
	private List<Integer> carreras;
	// Lista de los id de las mallas a las que pertenece
	private List<Integer> mallas_curriculares;
	public boolean acceso;
	private Semestre semestre_actual;
	
	// Constructor
	public Alumno(String nombreUsuario, String nombre, String apellidoPaterno, String apellidoMaterno, String contrasena, Sexo sexo, int edad){
		super(nombreUsuario, nombre, apellidoPaterno, apellidoMaterno, contrasena, sexo, edad);
		historial_academico = new Historial_Academico();
		carreras = new ArrayList<Integer>();
		mallas_curriculares = new ArrayList<Integer>();
		acceso = true;		
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

			
		}
	}
	public void eliminar_carrera(int id_carrera){
		for(int i=0;i<carreras.size();i++){
			if(carreras.get(i) == id_carrera){
				carreras.remove(i);
				break;
			}
		}
	}
	
	public void Inscribir_malla_curricular(int id_malla){
		// agregar carrera por id
		mallas_curriculares.add(id_malla);
	}
	
	public void setSemestreActual(Semestre semestre){
		this.semestre_actual = semestre;
	}
	public Historial_Academico GetHistorialAcademico(){return historial_academico;}
	public List<Integer> GetCarreras(){return carreras;}
	public List<Integer> GetMallas(){return mallas_curriculares;}
	public boolean GetAcceso(){return acceso;}
	public Semestre GetSemestreActual(){return semestre_actual;}
}
