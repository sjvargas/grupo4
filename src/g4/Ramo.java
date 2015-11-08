package g4;

import java.util.ArrayList;
import java.util.List;

/*
 *  Clase Ramo:
 *  Clase de la cual se compone curso,
 *   cuenta con una sigla, los créditos del ramo, una carrera,
 *    el semestre en el cual se imparte,
 *   los contenidos y los objetivos del curso. 
 */
public class Ramo implements java.io.Serializable{

	
	//
//	public int id_ramo;
	//
	private String nombreRamo;
	private String sigla;
	private int creditos;
	private Carrera carrera;
	private String semestre_impartido;
	private String contenidos;
	private String objetivos;
	private List<String> prerrequisitos;
	
	////////////////////////////////////
	//// GETTERS de atributos
	public Carrera getCarrera() {
		return carrera;
	}
	public String getNombreCarrera(){ return carrera.getNombreCarrera();}
	public String getNombreRamo() {
		return nombreRamo;
	}
	public String getContenidos() {
		return contenidos;
	}
	public int getCreditos() {
		return creditos;
	}
	public String getObjetivos() {
		return objetivos;
	}
	public String getSemestre_impartido() {
		return semestre_impartido;
	}
	public String getSigla() {
		return sigla;
	}
	public String getSemestreImpartidoString(){
		switch(semestre_impartido){
		case "1":
			return "Primero";
		case "2":
			return "Segundo";
		case "0":
			return "Ambos";
		default:
			return "Ambos";
		}
	}
	public List<String> GetPrerrequisitos(){return prerrequisitos;	}
	////////////////////////////////////
	
	public Ramo(String nombreRamo, String sigla, int creditos, Carrera carrera, String semestre_impartido, String contenidos, String objetivos){
		//this.id_ramo=id;
		this.nombreRamo = nombreRamo;
		this.sigla = sigla;
		this.creditos = creditos;
		this.carrera = carrera;
		this.semestre_impartido = semestre_impartido;
		this.contenidos = contenidos;
		this.objetivos = objetivos;
		this.prerrequisitos = new ArrayList<String>();
		
	}
	
	public void AgregarPrerrequisito(String siglaPrerrequisito){
		prerrequisitos.add(siglaPrerrequisito);
	}
	
}
