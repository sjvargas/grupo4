package g4;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fx.view.main;

public class Tema implements java.io.Serializable {
	private Usuario usuario;
	private String tipo; // entiendase como "alumno" o "profesor".
	private String titulo;
	private String texto;
	private Date fecha;
	private List<Comentario> comentarios;
	private int respuestas;
	
	//constructor de Tema!
	public Tema(String titulo,String texto, Usuario u, String status){
		this.texto = texto;
		this.titulo = titulo;
		this.usuario = u;
		this.tipo= status;
		this.comentarios = new ArrayList<Comentario>();
		this.fecha = new Date();
		this.respuestas =0;
	}
	
	// getters de Tema!

	public String getTexto(){
		return texto;
	}
	public String getCom(){
		return texto;
	}
	
	public String getUsuario(){
		return usuario.getNombre();
	}
	public Date getFecha(){
		return fecha;
	}	
	public String getTitulo(){
		return titulo;
	}
	public String getTipo(){
		return tipo;
	}	
	public Integer getRespuestas(){
		return respuestas;
	}
	public List<Comentario> getComentarios(){
		return comentarios;
	}
	
	// metodos de la clase Tema!
	public String AgregarComentario(String texto,Usuario u , String status){
		comentarios.add( new Comentario(texto,u, status));
		this.respuestas = this.respuestas+1;
		return "comentario creado con exito!";
	}
	public String EliminarComentario(Comentario comm){
		if (main.U.alumno_actual== comm.getUsuario2() && comm.getTipo().equals("alumno")){
			comentarios.remove(comm);
			this.respuestas = this.respuestas-1;
			return "comentario eliminado con exito!";
		}
		else if (main.U.profesor_actual== comm.getUsuario2() && comm.getTipo().equals("profesor")){
			comentarios.remove(comm);
			this.respuestas = this.respuestas-1;
			return "comentario eliminado con exito!";
		}
		else {
			return "no eres el autor del comentario, no puedes eliminarlo.";
		}
	}
}
