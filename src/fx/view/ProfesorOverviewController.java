package fx.view;

import java.util.ArrayList;

import g4.Carrera;
import g4.Curso;
import g4.CursoTabla;
import g4.Programacion_Academica;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

public class ProfesorOverviewController implements PrincipalController {
	/// objeto para realizar el cambio de paginas
	ScreensController controlador;
	

	@FXML
	private Pane pane_inicio,pane_historial,pane_evaluar,pane_foros,pane_info_profesor,pane_evaluar_alumno; 
	@FXML
	private Button boton_evaluar_guardar_cambios,boton_inicio,boton_evaluar_cursos,boton_historial_cursos,boton_foro_cursos,boton_buscador_cursos,boton_cerrar_sesion;
	@FXML
	private Button boton_historial_ir,boton_evaluar_ir,boton_evaluar_seleccionar;
	@FXML
	private ChoiceBox<String> choicebox_historial_periodo;
	@FXML
	private ChoiceBox<Curso> choicebox_evaluar_cursos;
	@FXML
	private TableView<CursoTabla> tabla_historial_cursos;
	@FXML
	private TableColumn<CursoTabla,String> columna_historial_sigla,columna_historial_nombre,columna_historial_carrera,columna_historial_horarios;
	@FXML
	private ObservableList<CursoTabla> data_historial = FXCollections.observableArrayList();
	
	
	// EVENTOS BOTONES DEL MENU LATERAL
	
	public void ClickInicio(ActionEvent event) {
		CambiarAPanel(pane_inicio);
	}	
	public void ClickHistorialCursos(ActionEvent event) {
		CambiarAPanel(pane_historial);
		columna_historial_sigla.setCellValueFactory(new PropertyValueFactory<CursoTabla,String>("sigla"));
		columna_historial_nombre.setCellValueFactory(new PropertyValueFactory<CursoTabla,String>("nombre"));
		columna_historial_carrera.setCellValueFactory(new PropertyValueFactory<CursoTabla,String>("carrera"));
		columna_historial_horarios.setCellValueFactory(new PropertyValueFactory<CursoTabla,String>("horarios"));
		tabla_historial_cursos.setItems(data_historial);
		
		ArrayList<String> periodos = new ArrayList<String>();
		for (Programacion_Academica j : main.U.historial_de_progrmacion_academica){
			periodos.add(j.periodo);}
		ObservableList<String> uu = FXCollections
				.observableList(periodos);
		choicebox_historial_periodo.setItems(uu);
		choicebox_historial_periodo.setValue(periodos.get(0));

	}	
	public void ClickEvaluarCursos(ActionEvent event) {
		CambiarAPanel(pane_evaluar);
	}	
	public void ClickForoCursos(ActionEvent event) {
		CambiarAPanel(pane_foros);
	}	
	public void ClickBuscadorCursos(ActionEvent event) {
		controlador.setScreen(main.BuscadorID);
	}	
	public void ClickCerrarSesion(ActionEvent event) {
		main.U.profesor_actual.Cerrar_sesion();
		main.U.profesor_actual = null;
		controlador.setScreen(main.InicioID);
		Serializador.serializar(main.U);
	}
	
	protected void CambiarAPanel(Pane paneDeseado){
		pane_inicio.setVisible(false);
		pane_historial.setVisible(false);
		pane_evaluar.setVisible(false);
		pane_foros.setVisible(false);
		paneDeseado.setVisible(true);
	}
	/// EVENTOS HISTORIAL CURSOS
	public void ClickHistorialIr(ActionEvent event) {
		String prof = main.U.profesor_actual.GetNombre();
		String periodo = choicebox_historial_periodo.getValue();
		ArrayList<Curso> cursos = main.U.buscador.filtrar(null, prof, -1, null,periodo);
		ArrayList<CursoTabla> ct = new ArrayList<CursoTabla>();
		for (Curso j : cursos){
			ct.add(new CursoTabla(j));
		}
		data_historial = FXCollections.observableArrayList(ct);
		ActualizarBusqueda();
	}	
	
	public void ActualizarBusqueda(){
		tabla_historial_cursos.setItems(data_historial);
	}
	/// EVENTOS EVALUAR CURSOS
	
	public void ClickSelccionarAlumno(ActionEvent event) {
		controlador.setScreen(main.BuscadorID);
	}	
	
	
	// evento para cambiar de paginas.
	@Override
	public void setScreenParent(ScreensController ScreenPage) {
		controlador = ScreenPage;
	}

	
	
}
