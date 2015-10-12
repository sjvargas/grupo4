package g4;

public class Usuario {
	String nombre;
	String contraseņa;
	String sexo;
	int edad;
	Boolean conectado;

	public Usuario(String nom, String cont, String sex, int ed){
		nombre = nom;
		contraseņa = cont;
		sexo = sex;
		edad = ed;
		conectado = false;
	}
	
	public void Iniciar_sesion(String nombre_usuario, String contraseņa_usuario){
		if ( this.nombre == nombre_usuario || this.contraseņa == contraseņa_usuario)
		{
			conectado = true;
			
		}
	}
	public void Cerrar_sesion(){
		conectado = false;
	}

}
