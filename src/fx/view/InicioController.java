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
import java.util.Arrays;
import java.util.List;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import g4.Administrador_academico;
import g4.Alumno;
import g4.Universidad;
import g4.Carrera;
import g4.Curso;
import g4.Malla_curricular;
import g4.Profesor;
import g4.Sexo;
import g4.Usuario;
import javafx.beans.property.SimpleStringProperty;

public class InicioController implements PrincipalController {
	
	
/// objeto para realizar el cambio de paginas
	ScreensController controlador;
	Universidad U;
		
// el siguiente boolean es para saber si esta en modo alumno (en true) o en modo Admin(en false)
	boolean modoAlumnoSelecionado;
	boolean modoProfesorSelecionado;
	@FXML
    private TextField tFNombreUsuarioIngreso;
	@FXML
    private TextField tFContrasenaIngreso;
	@FXML
    private TextField tfNombreUsuarioRegistro;
	@FXML
    private TextField tFNombreRegistro;
	@FXML
    private TextField tFApPatRegistro;
	@FXML
    private TextField tFApMatRegistro;
	@FXML
    private TextField tFContrasenaRegistro;
	@FXML
    private TextField tFSexoRegistro;
	@FXML
    private TextField tFEdadRegistro;
	@FXML
	private ChoiceBox cBSexoRegistro;
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
		String nombre = tFNombreUsuarioIngreso.getText() ;
		String clave = tFContrasenaIngreso.getText();
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
				if ( j.GetNombreUsuario().equals(nombre) && j.GetContrasena().equals(clave) )
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
		else if (modoProfesorSelecionado){
			error_ingreso.setText("profeeesor");
			Profesor profe = null;
			boolean aux = false;
			for(Profesor a : main.U.lista_profesores){
				if (main.U.lista_administradores.isEmpty())
				{
					error_ingreso.setText("no existe ningun Profesor");
					break;
				}
				if ( a.GetNombreUsuario().equals(nombre) && a.GetContrasena().equals(clave)){
					profe = a;
					aux = true;
				}
			}
			if(aux){
				
				profe.Iniciar_sesion();
				main.U.profesor_actual = profe;
				controlador.setScreen(main.ProfesorID);
			}
			else{
				error_ingreso.setText("no existe ese Profesor");
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
				if ( a.GetNombreUsuario().equals(nombre) && a.GetContrasena().equals(clave)){
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
			System.out.println("nombre: "+tfNombreUsuarioRegistro.getText());
			// arreglar el sexo
			Alumno alumno = new Alumno(tfNombreUsuarioRegistro.getText(), tFNombreRegistro.getText(), tFApPatRegistro.getText(), tFApMatRegistro.getText(), tFContrasenaRegistro.getText(), Sexo.Masculino, Integer.parseInt(tFEdadRegistro.getText()));
			main.U.agregarAlumno(alumno);
			alumno.Iniciar_sesion();
			main.U.alumno_actual = alumno;
			controlador.setScreen(main.AlumnoID);
		}
		else{
			Administrador_academico admin =new Administrador_academico(tfNombreUsuarioRegistro.getText(), tFNombreRegistro.getText(), tFApPatRegistro.getText(), tFApMatRegistro.getText(), tFContrasenaRegistro.getText(), Sexo.Masculino, Integer.parseInt(tFEdadRegistro.getText()));
			main.U.agregarAdministrador(admin);
			
			admin.Iniciar_sesion();
			main.U.administrador_actual = admin;
			controlador.setScreen(main.AdminID);
		}
	}
	public void seleccionarModoAlumno(){
		modoProfesorSelecionado = false;
		modoAlumnoSelecionado = true;
		//System.out.println("Modo alumno seleccionado");
	}
	public void seleccionarModoAdmin(){
		modoProfesorSelecionado = false;
		modoAlumnoSelecionado = false;
		//System.out.println("Modo Admin seleccionado");
	}
	public void seleccionarModoProfesor(){
		modoProfesorSelecionado = true;
		modoAlumnoSelecionado = false;
		//System.out.println("Modo alumno seleccionado");
	}

	public void ActualizarChoiceBoxSexo(ActionEvent event){
		ObservableList<Sexo> listaSexos = FXCollections.observableList(Arrays.asList(Sexo.values()));
		cBSexoRegistro.setItems(listaSexos);
		cBSexoRegistro.setValue(listaSexos);
	}
	/// metodo para realizar el cambio de paginas.
	@Override
	public void setScreenParent(ScreensController ScreenPage) {
		controlador = ScreenPage;	
	}
	
	
	
	
}
