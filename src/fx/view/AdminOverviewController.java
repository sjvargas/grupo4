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
	}
	public void ApretarBotonProfesores(ActionEvent event){
		CambiarAPanel(paneAdminProfesores);
	}
	public void ApretarBotonAlumnos(ActionEvent event){
		CambiarAPanel(paneAdminAlumnos);
	}
	public void ApretarBotonRamos(ActionEvent event){
		CambiarAPanel(paneAdminRamos);
	}
	public void ApretarBotonCarreras(ActionEvent event){
		CambiarAPanel(paneAdminCarreras);
	}
	public void ApretarBotonProgramacion(ActionEvent event){
		CambiarAPanel(paneAdminProgramacionAcademica);
	}
	public void ApretarBotonModificarDatos(ActionEvent event){
		CambiarAPanel(paneAdminModificarDatos);
	}
	public void ApretarBotonCerrarSesion(ActionEvent event){
	}
	
	
	// En el Modulo Profesores:
	private TextField campoANombreProfesor;
	private TextField campoAApellidosProfesor;
	private TextField campoASueldoProfesor;
	private TextField campoAFacultadProfesor;
	private TextField campoEliminarProfID;
	// Tabla Lista Profesores:
	
	// Agregar Nuevo Profesor:
	public void ApretarAgregarProfesor(ActionEvent event){
		String nombreProfesor = campoANombreProfesor.getText();
		String apellidoProfesor = campoAApellidosProfesor.getText();
		String sueldoProfesor = campoASueldoProfesor.getText();
		String facultadProfesor = campoAFacultadProfesor.getText();
	}
	
}
