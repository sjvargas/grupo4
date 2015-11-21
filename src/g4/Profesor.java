package g4;

import java.util.List;

public class Profesor extends Usuario implements java.io.Serializable{
	private int id_profesor;
	private int sueldo;
	private String facultad;
    private static int NextId = 0;
	private Double likes;
	private List<Integer> dificultad;
	
	public Profesor(String nombreUsuario, String nombre, String apellidoPaterno, String apellidoMaterno, String contrasena, Sexo sexo, int edad , int sueldo, String facultad)
	{	super(nombreUsuario, nombre, apellidoPaterno, apellidoMaterno, contrasena, sexo, edad);
		this.sueldo = sueldo;
		this.facultad = facultad;
		this.id_profesor = NextId++;
	}
	
	public void CalificarAlumno(Curso curso, Alumno alumno ,Float nota){
		
	}
	
	
	
	public int getSueldo(){return sueldo;}
	public int getId_profesor(){ return id_profesor;}
	public String getFacultad(){ return facultad;}
	public Double getLikes() {return likes;}
	public Double getDificultad() {return calculateAverage(dificultad);}
	
	@Override
	public String toString(){
		return (getNombre()+" "+getApellidoPaterno()+" "+getApellidoMaterno());
	}
	// funcion de (http://stackoverflow.com/questions/10791568/calculating-average-of-an-array-list)
	private double calculateAverage(List <Integer> marks) {
		  Integer sum = 0;
		  if(!marks.isEmpty()) {
		    for (Integer mark : marks) {
		        sum += mark;
		    }
		    return sum.doubleValue() / marks.size();
		  }
		  return sum;
		}
	
	public void DarLike(){
		likes= likes +1;
	}
	public void DarDificultad(Integer nota){
		dificultad.add(nota);
	}
}
