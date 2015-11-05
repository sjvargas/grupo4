package fx.view;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import jdk.nashorn.internal.runtime.ListAdapter;
import java.util.ArrayList;
import java.util.List;

import g4.Administrador_academico;
import g4.Alumno;
import g4.Universidad;
import g4.Carrera;
import g4.Curso;
import g4.Malla_curricular;
import g4.Usuario;
import javafx.beans.property.SimpleStringProperty;

public class InicioController implements PrincipalController {
	
	
/// objeto para realizar el cambio de paginas
	ScreensController controlador;
	Universidad U;
		
// el siguiente boolean es para saber si esta en modo alumno (en true) o en modo Admin(en false)
	boolean modoAlumnoSelecionado;
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

	
	
	
	public void IngresarUsuario(ActionEvent event){
		List<Alumno> r = main.U.lista_alumnos;
		String nombre = a_nombre.getText() ;
		String clave = a_clave.getText();
		System.out.println("1");
		if (modoAlumnoSelecionado)
		{
			System.out.println("2");
			if (main.U.lista_alumnos.isEmpty())
				error_ingreso.setText("no existe ningun alumno");			
			boolean aux = false;
			System.out.println("3b");
			for (Alumno j : main.U.lista_alumnos)
			{
				if ( j.nombre.equals(nombre) && j.contraseña.equals(clave) )
				{
					aux = true;
					if (j.acceso== true)
					{
						System.out.println("con acceso");
						j.Iniciar_sesion();
						main.U.alumno_actual = j;
						error_ingreso.setText("perfecto te conectaste!!");
						
						controlador.setScreen(main.AlumnoID);
					}
					else {
						error_ingreso.setText("tu excediste el numero de creditos reprobados :(");

					}
					break;
				}
			}
			if (!aux){
				error_ingreso.setText("tu usuario o contraseña son incorrectas");
				}
		}
		else
		{
			error_ingreso.setText("admiiin");
			Administrador_academico administrador = null;
			boolean existeElAdmin = false;
			for(Administrador_academico a : main.U.lista_administradores){
				if (main.U.lista_administradores.isEmpty())
				{
					error_ingreso.setText("no existe ningun administrador");
					break;
				}
				if ( a.nombre.equals(nombre) && a.contraseña.equals(clave)){
					administrador = a;
					existeElAdmin = true;
				}
			}
			if(existeElAdmin){
				
				administrador.Iniciar_sesion();
				main.U.administrador_actual = administrador;
				controlador.setScreen(main.AdminID);
			}
			else{
				error_ingreso.setText("no existe ese administrador");
			}			
		}	
	}
	

	public InicioController(){
		U = main.getU();
		modoAlumnoSelecionado = true;
	}

	
	
	
	public void registrarse(){
		
		
		if(modoAlumnoSelecionado){
			
			
			System.out.println("nombre: "+tfNombre.getText());
			Alumno a = new Alumno(tfNombre.getText(), tfCont.getText(), tfSexo.getText(), Integer.parseInt(tfEdad.getText()));
			main.U.agregarAlumno(a);
			a.Iniciar_sesion();
			main.U.alumno_actual = a;
			controlador.setScreen(main.AlumnoID);

		}
		
		else{
			Administrador_academico a =new Administrador_academico(tfNombre.getText(), tfCont.getText(), tfSexo.getText(), Integer.parseInt(tfEdad.getText()));
			main.U.agregarAdministrador(a);
			
			a.Iniciar_sesion();
			main.U.administrador_actual = a;
			controlador.setScreen(main.AdminID);

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
	
	
	
	/// metodo para realizar el cambio de paginas.
	@Override
	public void setScreenParent(ScreensController ScreenPage) {
		controlador = ScreenPage;	
	}
	
	
	
	
}
