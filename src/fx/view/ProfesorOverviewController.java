package fx.view;

import java.util.ArrayList;

import g4.Programacion_Academica;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
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
	private ChoiceBox choicebox_historial_periodo,choicebox_evaluar_cursos;
	
	
	// EVENTOS BOTONES DEL MENU LATERAL
	
	public void ClickInicio(ActionEvent event) {
		CambiarAPanel(pane_inicio);
	}	
	public void ClickHistorialCursos(ActionEvent event) {
		CambiarAPanel(pane_historial);
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
	
	
	
	
	// evento para cambiar de paginas.
	@Override
	public void setScreenParent(ScreensController ScreenPage) {
		controlador = ScreenPage;
	}

	
	
}
