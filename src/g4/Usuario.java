package g4;

public class Usuario implements java.io.Serializable{
	private String nombreUsuario;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String contrasena;
	private Sexo sexo;
	private int edad;
	private Boolean conectado;

	public Usuario(String nombreUsuario, String nombre, String apellidoPaterno, String apellidoMaterno, String contrasena, Sexo sexo, int edad){
		this.nombreUsuario = nombreUsuario;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.contrasena = contrasena;
		this.sexo = sexo;
		this.edad = edad;
		this.conectado = false;
	}
	
	public void Iniciar_sesion(){
			conectado = true;
	}
	
	public void Cerrar_sesion(){
		conectado = false;
	}
	
	public String GetNombreUsuario(){ return nombreUsuario;}
	public String GetNombre(){ return nombre+" "+apellidoPaterno;}
	public String GetApellidoPaterno(){return apellidoPaterno;}
	public String GetApellidoMaterno(){return apellidoMaterno;}
	public String GetContrasena(){return contrasena;}
	public Sexo GetSexo(){return sexo;}
	public Integer GetEdad(){return edad;}
	public String GetEdadString(){return Integer.toString(edad);}
	public Boolean GetConectado(){return conectado;}

}
