package g4;

public class Usuario {
	String nombre;
	String contrase�a;
	String sexo;
	int edad;
	Boolean conectado;

	public Usuario(String nom, String cont, String sex, int ed){
		nombre = nom;
		contrase�a = cont;
		sexo = sex;
		edad = ed;
		conectado = false;
	}
	
	public void Iniciar_sesion(String nombre_usuario, String contrase�a_usuario){
		if ( this.nombre == nombre_usuario || this.contrase�a == contrase�a_usuario)
		{
			conectado = true;
			
		}
	}
	public void Cerrar_sesion(){
		conectado = false;
	}

}
