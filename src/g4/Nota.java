package g4;

public class Nota implements java.io.Serializable{
	private Integer curso;
	// es Float y no float para que acepte nulls
	private Float valor;
	
	// constructor solo con el curso
	public Nota(Integer id_curso){
		this.curso = id_curso;
		valor = null;
	}
	// constructor con el curso y la nota
	public Nota(Integer id_curso, float valor){
		this.curso = id_curso;
		this.valor = valor;
	}
	
	public Float GetNota(){
		return valor;
	}
	public Integer GetCurso(){
		return curso;
	}
	
	// Para guardar nota se revia que sea valida
	public void SetNota(float nota){
		if(1 <= nota && nota <= 7.0){
			this.valor = nota;
		}
	}
}
