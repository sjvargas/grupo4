package g4;


/*
 *  Clase Ramo:
 *  Clase de la cual se compone curso,
 *   cuenta con una sigla, los créditos del ramo, una carrera,
 *    el semestre en el cual se imparte,
 *   los contenidos y los objetivos del curso. 
 */
public class Ramo {

	
	//
//	public int id_ramo;
	//
	private String sigla;
	private int creditos;
	
	private Carrera carrera;
	
	private String semestre_impartido;
	
	private String contenidos;
	
	private String objetivos;
	
	////////////////////////////////////
	//// GETTERS de atributos
	public Carrera getCarrera() {
		return carrera;
	}
	public String getContenidos() {
		return contenidos;
	}
	public int getCreditos() {
		return creditos;
	}
	/*
	public int getId_ramo() {
		return id_ramo;
	}
	*/
	public String getObjetivos() {
		return objetivos;
	}
	public String getSemestre_impartido() {
		return semestre_impartido;
	}
	public String getSigla() {
		return sigla;
	}
	////////////////////////////////////
	
	public Ramo(String sigla, int creditos, Carrera carrera, String semestre_impartido, String contenidos, String objetivos){
		//this.id_ramo=id;
		this.sigla = sigla;
		this.creditos = creditos;
		this.carrera = carrera;
		this.semestre_impartido = semestre_impartido;
		this.contenidos = contenidos;
		this.objetivos = objetivos;
		
	}
	
	
	
	
	
	
	

}
