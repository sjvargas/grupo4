package g4;

public class Usuario {
	public String nombre;
	public String contraseña;
	String sexo;
	int edad;
	Boolean conectado;

	public Usuario(String nom, String cont, String sex, int ed){
		nombre = nom;
		contraseña = cont;
		sexo = sex;
		edad = ed;
		conectado = false;
	}
	
	public void Iniciar_sesion(){
			conectado = true;
	}
	
	public void Cerrar_sesion(){
		conectado = false;
	}

}
