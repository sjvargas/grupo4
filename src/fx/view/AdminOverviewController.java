package fx.view;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import jdk.nashorn.internal.runtime.ListAdapter;
import java.util.ArrayList;
import java.util.List;

import g4.Administrador_academico;
import g4.Profesor;

public class AdminOverviewController {
	protected Administrador_academico usuarioAdministrador;

	// Constructor que recibe el administrador
	public AdminOverviewController(Administrador_academico usuarioAdministrador){
		this.usuarioAdministrador = usuarioAdministrador;
		paneAdminBasico.setVisible(true);
		CambiarAPanel(paneAdminInicio);
	}
	
	
	// Botones del menu de inicio
	@FXML
	private Button buttonAdminInicio;
	@FXML
	private Button buttonAdminProfesor;
	@FXML
	private Button buttonAdminAlumnos;
	@FXML
	private Button buttonAdminRamos;
	@FXML
	private Button buttonAdminCarreras;
	@FXML
	private Button buttonAdminProgramacionA;
	@FXML
	private Button buttonAdminModificarD;
	@FXML
	private Button buttonAdminCerrarSesion;
	
	// Paneles del Administrador:
	@FXML
	private Pane paneAdminBasico;
	@FXML
	private Pane paneAdminInicio;	
	@FXML
	private Pane paneAdminProfesores;	
	@FXML
	private Pane paneAdminAlumnos;	
	@FXML
	private Pane paneAdminRamos;	
	@FXML
	private Pane paneAdminCarreras;	
	@FXML
	private Pane paneAdminProgramacionAcademica;	
	@FXML
	private Pane paneAdminModificarDatos;

	// Label Panel Admin Estado
	private Label LabelPanelAdminEstado;
	
	// Metodo para cambiar el panel
	protected void CambiarAPanel(Pane paneDeseado){
		paneAdminInicio.setVisible(false);
		paneAdminProfesores.setVisible(false);
		paneAdminAlumnos.setVisible(false);
		paneAdminRamos.setVisible(false);
		paneAdminCarreras.setVisible(false);
		paneAdminProgramacionAcademica.setVisible(false);
		paneAdminModificarDatos.setVisible(false);
		paneDeseado.setVisible(true);
	}
	
	// Eventos de apretar el boton en el menu
	public void ApretarBotonInicio(ActionEvent event){
		CambiarAPanel(paneAdminInicio);
		LabelPanelAdminEstado.setText("Inicio");
	}
	public void ApretarBotonProfesores(ActionEvent event){
		CambiarAPanel(paneAdminProfesores);
		LabelPanelAdminEstado.setText("Profesores");
	}
	public void ApretarBotonAlumnos(ActionEvent event){
		CambiarAPanel(paneAdminAlumnos);
		LabelPanelAdminEstado.setText("Alumnos");
	}
	public void ApretarBotonRamos(ActionEvent event){
		CambiarAPanel(paneAdminRamos);
		LabelPanelAdminEstado.setText("Ramos");
	}
	public void ApretarBotonCarreras(ActionEvent event){
		CambiarAPanel(paneAdminCarreras);
		LabelPanelAdminEstado.setText("Carreras");
	}
	public void ApretarBotonProgramacion(ActionEvent event){
		CambiarAPanel(paneAdminProgramacionAcademica);
		LabelPanelAdminEstado.setText("Programacion Academica");
	}
	public void ApretarBotonModificarDatos(ActionEvent event){
		CambiarAPanel(paneAdminModificarDatos);
		LabelPanelAdminEstado.setText("Modificar Datos");
	}
	public void ApretarBotonCerrarSesion(ActionEvent event){
	}
	
	
	// MODULO PROFESORES:
	private TextField campoANombreProfesor;
	private TextField campoAApellidosProfesor;
	private TextField campoASueldoProfesor;
	private TextField campoAFacultadProfesor;
	private TextField campoEliminarProfID;
	private Label labelAvisoProfesor;
	// Tabla Lista Profesores:
	
	// Agregar Nuevo Profesor:
	public void ApretarAgregarProfesor(ActionEvent event){
		String nombreProfesor = campoANombreProfesor.getText();
		String apellidoProfesor = campoAApellidosProfesor.getText();
		String sueldoProfesor = campoASueldoProfesor.getText();
		int sueldoProfesor2 = Integer.parseInt(sueldoProfesor);
		String facultadProfesor = campoAFacultadProfesor.getText();
		if(nombreProfesor != "" && apellidoProfesor!= "" && facultadProfesor!= "")
		{
			usuarioAdministrador.agregar_profesor(nombreProfesor, apellidoProfesor, sueldoProfesor2, facultadProfesor);
			labelAvisoProfesor.setText("Agregado");
		}
		else{
			labelAvisoProfesor.setText("Completar");
		}
	}
	
	// Eliminar Profesor:
	public void ApretarEliminarProfesor(ActionEvent event){
		
	}
	
	// MODULO ALUMNOS
	private TextField textFieldIdAlumno;
	private Label labelEstadoRestringirAlumno;
	public void ApretarRestringirAlumno(ActionEvent event){
		String idAlumno = textFieldIdAlumno.getText();
		if(idAlumno != ""){
			//usuarioAdministrador.restringir_acceso_alumno(idAlumno);
		}
		else{
			labelEstadoRestringirAlumno.setText("Campo Vacio");
		}
	}
	
	// MODULO RAMOS
}
