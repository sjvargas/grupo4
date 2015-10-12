package g4;

public class Usuario {
	String nombre;
	String contraseña;
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
	
	public void Iniciar_sesion(String nombre_usuario, String contraseña_usuario){
		if ( this.nombre == nombre_usuario || this.contraseña == contraseña_usuario)
		{
			conectado = true;
			
		}
	}
	public void Cerrar_sesion(){
		conectado = false;
	}

}
