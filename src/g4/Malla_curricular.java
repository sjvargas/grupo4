package g4;

import java.util.List;

/*
 * 
 * Clase Malla_curricular: Clase que cuenta con una lista de Ramos
 *  y un identificador �nico para cada instancia de esta clase.
 *  Permite (mediante sus m�todos) agregar y eliminar ramos de la malla curricular. 
 * 
 */
public class Malla_curricular implements java.io.Serializable{
	

	
	public int id_malla;
	private List<Ramo> ramos;
	
	
	public Malla_curricular(int id_malla){
		//constructor
		this.id_malla = id_malla;
	}
////////////////////////////////////
//// GETTERS de atributos
	public int getId_malla() {
		return id_malla;
	}
	public List<Ramo> getRamos() {
		return ramos;
	}
	/////////////////////////////
	///////////////////////////////
	
	public void agregar_ramo(Ramo ramo){
		// recibe un objeto de la clase Ramo
		this.ramos.add(ramo);
		
		// agrega el objeto recibido a la lista de ramos
	}
	
	public void eliminar_ramo(String sigla){
		// metodo que recibe un identificador de una instancia de ramo
				for(int i=0; i< ramos.size();i++){
					if(((ramos.get(i)).getSigla()).equalsIgnoreCase(sigla)){
						ramos.remove(i);
						break;
					}
				}
		// si ese id corresponde a alguno de los id de los ramos que estan en la lista, entonces se elimina 
	}
	
	@Override
	   public String toString() {
	       return "Malla con codigo: "+id_malla;
	   }


}
