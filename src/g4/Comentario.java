package g4;

import java.util.Date;
import fx.view.main;

public class Comentario {
	private Usuario usuario;
	private String tipo_de_usuario; // entiendase como "alumno" o "profesor".
	private String texto;
	private Date fecha;
	
	
	// constructor de Comentario!
	public Comentario(String texto){
		this.texto = texto;
		if (main.U.alumno_actual!= null ){
			this.usuario = main.U.alumno_actual;
			this.tipo_de_usuario= "alumno";
		}
		else{
			this.usuario = main.U.profesor_actual;
			this.tipo_de_usuario= "profesor";
		}
		this.fecha = new Date();		
	}
	
	// getters de Comentario!
	public Usuario getUsuario(){
		return usuario;
	}
	public Date getFecha(){
		return fecha;
	}
	public String getTipoDeUsuario(){
		return tipo_de_usuario;
	}
	public String getTexto(){
		return texto;
	}
	
}
