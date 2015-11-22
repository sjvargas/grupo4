package g4;

import java.util.ArrayList;
import java.util.List;

public class Semestre implements java.io.Serializable{
	private String periodo;
	// Lista de todos los id de los cursos del semestre
	private List<Integer> cursos;
	// Lista de todas las notas
	private List<Nota> notas;
	private int creditosActuales;
	private int maximoCreditosPermitidos;
	public boolean semestreCerrado;
	
	
	private int creditosTotales;
	private int creditosAprobados;
	private int creditosReprobados;
	private float promedioPonderado;
	
	public Semestre(String periodo){ //falta que el constructor tenga maximoCreditosPermitidos
		this.periodo = periodo;
		//this.maximoCreditosPermitidos = maximoCreditosPermitidos;
		cursos = new ArrayList<Integer>();
		notas = new ArrayList<Nota>();
		creditosActuales = 0;
		semestreCerrado = false;
	}
	
	public void Poner_Nota(int id_curso, float nota){
		for(int i = 0; i<notas.size(); i++){
			Nota n = notas.get(i);
			if(id_curso == n.GetCurso()){
				n.SetNota(nota);
			}
		}
	}
	
	public void Agregar_Curso(int id_curso){
		// falta buscar el curso
		cursos.add(id_curso);
		// falta sumar creditos del curso, cuando se tenga
		
		// crea la nota
		Nota n = new Nota(id_curso);
		notas.add(n);	
	}
	
	public void Eliminar_Curso(int id_curso){
		// falta buscar el curso
		cursos.remove((Integer) id_curso);
		// falta restar creditos del curso, cuando se tenga el curso
	}
	// Entrega la nota del curso segun el id
	public float Ver_Nota(int id_curso){
		for(int i = 0; i< notas.size(); i++){
			Nota n = notas.get(i);
			if(n.GetCurso() == id_curso){
				return n.GetNota();
			}
		}
		// si no esta curso retorna cero?
		return 0;
	}
	// Cierra el semestre
	public void CerrarSemestre(){
		boolean sePuedeCerrar = true;
		
		if(notas.size()<1 || cursos.size()<1){
			sePuedeCerrar=false;
			return;
		}
		// revisa que todos tengan nota
		for(int i = 0; i < notas.size(); i++ ){
			if(notas.get(i).GetNota()!= null){
				sePuedeCerrar = sePuedeCerrar && true;
			}
			else{
				sePuedeCerrar = sePuedeCerrar && false;
			}
		}
		// si se puede cerrar se cierra
		semestreCerrado = sePuedeCerrar;
		
		
		
	}
	
	public String GetPeriodo(){return periodo;}
	public int GetMaximoCreditosPermitidos(){ return maximoCreditosPermitidos;}
	public List<Integer> GetCursos(){return cursos;}
	public List<Nota> GetNotas(){return notas;}
	public int GetCreditos(){return creditosActuales;}
	
	public int getCreditosTotales() {
		return creditosTotales;
	}
	public int getCreditosAprobados() {
		return creditosAprobados;
	}
	public int getCreditosReprobados() {
		return creditosReprobados;
	}
	public float getPromedioPonderado() {
		return promedioPonderado;
	}
	public void setCreditosAprobados(int creditosAprobados) {
		this.creditosAprobados = creditosAprobados;
	}
	public void setCreditosReprobados(int creditosReprobados) {
		this.creditosReprobados = creditosReprobados;
	}
	public void setCreditosTotales(int creditosTotales) {
		this.creditosTotales = creditosTotales;
	}
	public void setPromedioPonderado(float promedioPonderado) {
		this.promedioPonderado = promedioPonderado;
	}
	
	  @Override
	  public String toString() {
		   return "Semestre del periodo: "+this.periodo;
	   }
	  
	 public void setPeriodo(String periodo){
		 this.periodo= periodo;
	 }
		   
	
}
