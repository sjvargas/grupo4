package fx.view;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import jdk.nashorn.internal.runtime.ListAdapter;

import java.util.List;

import g4.Administrador_academico;
import g4.Alumno;
import g4.AplicacionInicio;
import g4.Curso;
import g4.Usuario;



public class InicioController {
	
	

	public List<Alumno> alumnos;
	public List<Administrador_academico> admins;
	public Usuario Usuario_conectado;
	public String Usuario_tipo;  /// aca va un string que si es "alumno" o si es "admin".
	
	
	
	
	// el siguiente boolean es para saber si esta en modo alumno (en true) o en modo Admin(en false)
	boolean modoAlumnoSelecionado;
	AplicacionInicio aplicacionInicio;
	@FXML
    private TextField tfNombre;
	@FXML
    private TextField tfCont;
	@FXML
    private TextField tfSexo;
	@FXML
    private TextField tfEdad;
	@FXML
    private TextField a_nombre;
	@FXML
    private TextField a_clave;
	@FXML
	private Button ingresar;
	@FXML
	private Button registrar;
	@FXML
    private Label error_ingreso;
	@FXML
	private Pane pantalla_inicio;
	@FXML
	private Pane pantalla_alumno;
	@FXML
	private Button cerrar_sesion;
	
	
	//crea instancia de  Apicacion inicio-.. No estoy seguro de si se crea acá o en Main
	
	
	
	
	
	
	public void IngresarUsuario(ActionEvent event){
		if (modoAlumnoSelecionado)
		{
			String nombre = a_nombre.getText() ;
			String clave = a_clave.getText();
			
			for (Alumno j : aplicacionInicio.listaAlumnos)
			{
				if ( j.nombre == nombre || j.contraseña == clave )
				{
					if (j.acceso== true)
					{
						pantalla_inicio.managedProperty().bind(pantalla_inicio.visibleProperty());
						pantalla_alumno.managedProperty().bind(pantalla_alumno.visibleProperty());
						pantalla_inicio.setVisible(false);
						pantalla_alumno.setVisible(true);
						j.Iniciar_sesion();
						Usuario_conectado = j;
						Usuario_tipo = "alumno";
					}
					else {
						error_ingreso.setText("tu excediste el numero de creditos reprobados :(");

						}
				}
				else {
					error_ingreso.setText("tu usuario o contraseña son incorrectas");

					}
			}
		}
		else
		{
			error_ingreso.setText("admiiin");
		}
		
		
	}
	

	public InicioController(){
		
		aplicacionInicio = new AplicacionInicio();
		
		
		modoAlumnoSelecionado = true;
		
	}

	public void CerrarSesion(ActionEvent event){
		pantalla_inicio.managedProperty().bind(pantalla_inicio.visibleProperty());
		pantalla_alumno.managedProperty().bind(pantalla_alumno.visibleProperty());
		pantalla_inicio.setVisible(true);
		pantalla_alumno.setVisible(false);
		Usuario_conectado.Cerrar_sesion();
	}
	
	
	
	public void registrarse(){
		
		
		if(modoAlumnoSelecionado){
			
			
			System.out.println("nombre: "+tfNombre.getText());
			Alumno a = new Alumno(tfNombre.getText(), tfCont.getText(), tfSexo.getText(), Integer.parseInt(tfEdad.getText()));
			
			aplicacionInicio.agregarAlumno(a);
			
			pantalla_inicio.managedProperty().bind(pantalla_inicio.visibleProperty());
			pantalla_alumno.managedProperty().bind(pantalla_alumno.visibleProperty());
			pantalla_inicio.setVisible(false);
			pantalla_alumno.setVisible(true);
			
			a.Iniciar_sesion();
			Usuario_conectado = a;
			Usuario_tipo = "alumno";
		}
		
		else{
			Administrador_academico a =new Administrador_academico(tfNombre.getText(), tfCont.getText(), tfSexo.getText(), Integer.parseInt(tfEdad.getText()));
			aplicacionInicio.agregarAdministrador(a);
			
			pantalla_inicio.managedProperty().bind(pantalla_inicio.visibleProperty());
			pantalla_alumno.managedProperty().bind(pantalla_alumno.visibleProperty());
			pantalla_inicio.setVisible(false);
			pantalla_alumno.setVisible(true); /// cambiar esta pantalla que se vea
			a.Iniciar_sesion();
			Usuario_conectado = a;
			Usuario_tipo = "admin";
		}
		
		//if()
		
	}
	
	
	public void seleccionarModoAlumno(){
		modoAlumnoSelecionado = true;
		//System.out.println("Modo alumno seleccionado");
	}
	public void seleccionarModoAdmin(){
		modoAlumnoSelecionado = false;
		//System.out.println("Modo Admin seleccionado");
		
	}
	

}
