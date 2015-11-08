package g4;

import java.util.ArrayList;
import java.util.List;

public class Historial_Academico implements java.io.Serializable{
	
	private Semestre semestreActual;
	private List<Semestre> semestres;
	private int creditosAprobados;
	private int cantidad_cursos_aprovados;
	private int cantidad_cursos_reprobados;
	public int creditosMaximos;
	
	public Historial_Academico(){
		semestreActual = null;
		semestres = new ArrayList<Semestre>();
		int creditosAprobados = 0;
		cantidad_cursos_aprovados = 0;
		cantidad_cursos_reprobados = 0;
	}
	
	public void CrearSemestre(String periodo){
		if(semestreActual == null || semestreActual.semestreCerrado == true){
			Semestre semestre = new Semestre(periodo);
			semestreActual = semestre;
			semestres.add(semestre);
		}
	}
	public void ActualizarEstadoCursos(){
		// Actualiza Ramos aprovados y reprobados, cuando se cierra un semestre
		List<Nota> listaNotas = semestreActual.GetNotas();
		for(int i = 0; listaNotas.size() < i ; i++){
			Nota n = listaNotas.get(i);
			if(n.GetNota() >= 4.0){
				cantidad_cursos_aprovados += 1;
				// Falta sumar lo creditos aprovados
			}
			else{
				cantidad_cursos_reprobados += 1;
			}
		}		
	}
	
	public void agregarSemestre(Semestre semestre){
		this.semestreActual = semestre;
		this.ActualizarEstadoCursos();
		
		semestres.add(semestre);
	}
	
	public List<Semestre> getSemestres() {
		return semestres;
	}
	
}
