package g4;

import java.util.Date;
import fx.view.main;

public class Comentario implements java.io.Serializable  {
	private Usuario usuario;
	private String tipo; // entiendase como "alumno" o "profesor".
	private String texto;
	private Date fecha;
	
	
	// constructor de Comentario!
	public Comentario(String texto,Usuario u , String status){
		this.texto = texto;
		this.usuario = u;
		this.tipo= status;
		this.fecha = new Date();		
	}
	
	// getters de Comentario!
	public String getUsuario(){
		return usuario.getNombre();
	}
	public Date getFecha(){
		return fecha;
	}
	public String getTipo(){
		return tipo;
	}
	public String getTexto(){
		return texto;
	}
	public Usuario getUsuario2(){
		return usuario;
	}
	
}
