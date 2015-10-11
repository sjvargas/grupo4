package g4;

public class Nota {
	private Curso curso;
	private float valor;
	
	// constructor solo con el curso
	public Nota(Curso curso){
		this.curso = curso;
	}
	// constructor con el curso y la nota
	public Nota(Curso curso, float valor){
		this.curso = curso;
		this.valor = valor;
	}
	
	public float GetNota(){
		return valor;
	}
	public Curso GetCurso(){
		return curso;
	}
	public void SetNota(float nota){
		if(1 <= nota && nota <= 7.0){
			this.valor = nota;
		}
	}
}
