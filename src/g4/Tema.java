package g4;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fx.view.main;

public class Tema {
	private Usuario usuario;
	private String tipo_de_usuario; // entiendase como "alumno" o "profesor".
	private String titulo;
	private String texto;
	private Date fecha;
	private List<Comentario> comentarios;
	
	//constructor de Tema!
	public Tema(String titulo,String texto){
		this.texto = texto;
		this.titulo = titulo;
		if (main.U.alumno_actual!= null ){
			this.usuario = main.U.alumno_actual;
			this.tipo_de_usuario= "alumno";
		}
		else{
			this.usuario = main.U.profesor_actual;
			this.tipo_de_usuario= "profesor";
		}
		this.comentarios = new ArrayList<Comentario>();
		this.fecha = new Date();
	}
	
	// getters de Tema!
	public Usuario getUsuario(){
		return usuario;
	}
	public Date getFecha(){
		return fecha;
	}	
	public String getTitulo(){
		return titulo;
	}
	public String getTipoDeUsuario(){
		return tipo_de_usuario;
	}
	public String getTexto(){
		return texto;
	}
	public List<Comentario> getComentarios(){
		return comentarios;
	}
	
	// metodos de la clase Tema!
	public String AgregarComentario(String texto){
		comentarios.add( new Comentario(texto));
		return "comentario creado con exito!";
	}
	public String EliminarComentario(Comentario comm){
		if (main.U.alumno_actual== comm.getUsuario() && comm.getTipoDeUsuario().equals("alumno")){
			comentarios.remove(comm);
			return "comentario eliminado con exito!";
		}
		else if (main.U.profesor_actual== comm.getUsuario() && comm.getTipoDeUsuario().equals("profesor")){
			comentarios.remove(comm);
			return "comentario eliminado con exito!";
		}
		else {
			return "no eres el autor del comentario, no puedes eliminarlo.";
		}
	}
}
