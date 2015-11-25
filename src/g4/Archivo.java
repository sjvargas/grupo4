package g4;

import java.util.List;

public class Archivo {
	private String autor; 
	private String nombre;
	private List<String> contenido;
	
	public Archivo(String nombre, String autor,List<String> contenido){
		this.autor = autor;
		this.nombre = nombre;
		this.contenido = contenido;
	}
	
	public List<String> getContenido(){
		return contenido;
	}
	public String getNombre(){
		return nombre;
	}	
	public String getAutor(){
		return autor;
	}
}
