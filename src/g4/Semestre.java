package g4;

import java.util.ArrayList;
import java.util.List;

public class Semestre {
	private String periodo;
	private List<Curso> cursos;
	private List<Nota> notas;
	private int creditosActuales;
	public boolean semestreCerrado;
	
	public Semestre(String periodo){
		this.periodo = periodo;
		cursos = new ArrayList<Curso>();
		notas = new ArrayList<Nota>();
		creditosActuales = 0;
		semestreCerrado = false;
	}
	
	public void Poner_Nota(int id_curso, float nota){
		for(int i = 0; i<notas.size(); i++){
			Nota n = notas.get(i);
			if(id_curso == n.GetCurso().getId_curso()){
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
		cursos.remove();
		// falta restar creditos del curso, cuando se tenga el curso
	}
	
	public float Ver_Nota(int id_curso){
		for(int i = 0; i< notas.size(); i++){
			Nota n = notas.get(i);
			if(n.GetCurso().getId_curso() == id_curso){
				return n.GetNota();
			}
		}
		// si no esta curso retorna cero?
		return 0;
	}

	public void CerrarSemestre(){
		boolean sePuedeCerrar = true;
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
	public List<Curso> GetCursos(){return cursos;}
	public List<Nota> GetNotas(){return notas;}
	public int GetCreditos(){return creditosActuales;}
	
}
