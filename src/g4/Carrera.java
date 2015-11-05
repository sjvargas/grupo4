package g4;

import java.util.ArrayList;
import java.util.List;

/*
 * 
 * Clase Carrera: Esta clase se asocia a instancias de las clases que heredan de la clase Usuario.
 *  Cuenta con las diferentes mallas curriculares de las cuales se compone
 *  (es una lista de mallas ya que estas pueden variar para distintos años de ingreso),
 *  cuenta con un decano, una facultad y un identificador único para cada instancia de la clase.
 *  Permite (mediante sus métodos) crear mallas curriculares
 *   y eliminar mallas curriculares de la lista contenida en la carrera.
 * 
 * 
 */
public class Carrera {
	
	private int id_carrera;
	private List<Malla_curricular> mallas_curriculares;
	private String Decano;
	private String facultad;
	private String nombre;
	
	public Carrera(int id, String decano, String facultad,String nombre){
		this.id_carrera = id;
		this.Decano= decano;
		this.nombre= nombre;
		this.facultad = facultad;
		
		mallas_curriculares = new ArrayList<Malla_curricular>();
	}
	
	
	
////////////////////////////////////
//// GETTERS de atributos
	
	public String getDecano() {
		return Decano;
	}
	public String getFacultad() {
		return facultad;
	}
	public int getId_carrera() {
		return id_carrera;
	}
	public String getnombre_carrera() {
		return nombre;
	}
	public List<Malla_curricular> getMallas_curriculares() {
		return mallas_curriculares;
	}
	
	////////////////////////////////////
	/////////////////////////////////////
	
	public void crear_malla_curricular(Malla_curricular malla){
		// metodo que recibe un objeto de la clase malla_curricular
		this.mallas_curriculares.add(malla);
		// agrega el objeto recibido a la lista de mallas curriculares
	}
	
	public void eliminar_malla_curricular(int id_malla){
		
		// metodo que recibe un identificador de una instancia de malla curricular
		for(int i=0; i< mallas_curriculares.size();i++){
			if(((mallas_curriculares.get(i)).id_malla) == id_malla){
				mallas_curriculares.remove(i);
				break;
			}
		}
		// si ese id corresponde a alguno de los id de las mallas que estan en la lista, entonces se elimina 
	}
	
	
	   @Override
	   public String toString() {
	       return nombre;
	   }

}
