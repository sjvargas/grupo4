package fx.view;

import java.awt.TextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

public class BuscadorDeCursosController implements PrincipalController {
	/// objeto para realizar el cambio de paginas
	ScreensController controlador;

	@FXML
	private Button boton_eliminar;
	@FXML
	private Button boton_agregar;
	@FXML
	private Button boton_cerrar_sesion;
	@FXML
	private Button boton_menu;
	@FXML
	private Button boton_buscar;
	@FXML
	private TextField text_periodo;
	@FXML
	private TextField text_carrera;
	@FXML
	private TextField text_sigla;
	@FXML
	private TextField text_profesor;
	@FXML
	private RadioButton lu_1; 
	@FXML
	private RadioButton lu_2; 
	@FXML
	private RadioButton lu_3; 
	@FXML
	private RadioButton lu_4; 
	@FXML
	private RadioButton lu_5; 
	@FXML
	private RadioButton lu_6; 
	@FXML
	private RadioButton lu_7; 
	@FXML
	private RadioButton lu_8; 
	@FXML
	private RadioButton ma_1; 
	@FXML
	private RadioButton ma_2; 
	@FXML
	private RadioButton ma_3; 
	@FXML
	private RadioButton ma_4; 
	@FXML
	private RadioButton ma_5; 
	@FXML
	private RadioButton ma_6; 
	@FXML
	private RadioButton ma_7; 
	@FXML
	private RadioButton ma_8; 
	@FXML
	private RadioButton mi_1;
	@FXML
	private RadioButton mi_2;
	@FXML
	private RadioButton mi_3;
	@FXML
	private RadioButton mi_4;
	@FXML
	private RadioButton mi_5;
	@FXML
	private RadioButton mi_6;
	@FXML
	private RadioButton mi_7;
	@FXML
	private RadioButton mi_8;
	@FXML
	private RadioButton ju_1;
	@FXML
	private RadioButton ju_2;
	@FXML
	private RadioButton ju_3;
	@FXML
	private RadioButton ju_4;
	@FXML
	private RadioButton ju_5;
	@FXML
	private RadioButton ju_6;
	@FXML
	private RadioButton ju_7;
	@FXML
	private RadioButton ju_8;
	@FXML
	private RadioButton vi_1;
	@FXML
	private RadioButton vi_2;
	@FXML
	private RadioButton vi_3;
	@FXML
	private RadioButton vi_4;
	@FXML
	private RadioButton vi_5;
	@FXML
	private RadioButton vi_6;
	@FXML
	private RadioButton vi_7;
	@FXML
	private RadioButton vi_8;
	@FXML
	private RadioButton sa_1;
	@FXML
	private RadioButton sa_2;
	@FXML
	private RadioButton sa_3;
	@FXML
	private RadioButton sa_4;
	@FXML
	private RadioButton sa_5;
	@FXML
	private RadioButton sa_6;
	@FXML
	private RadioButton sa_7;
	@FXML
	private RadioButton sa_8;
	
	
	public void ClickCerrarSesion(ActionEvent event) {
		main.U.alumno_actual.Cerrar_sesion();
		main.U.alumno_actual = null;
		controlador.setScreen(main.InicioID);
	}
	public void ClickVolverMenu(ActionEvent event) {
		controlador.setScreen(main.AlumnoID);
	}
	
	public void ClickEliminar(ActionEvent event) {
		controlador.setScreen(main.AlumnoID);
	}	
	public void ClickBuscar(ActionEvent event) {
		controlador.setScreen(main.AlumnoID);
	}
	public void ClickAgregar(ActionEvent event) {
		controlador.setScreen(main.AlumnoID);
	}
	
	
	// evento para cambiar de paginas.
	@Override
	public void setScreenParent(ScreensController ScreenPage) {
		controlador = ScreenPage;
	}

	
	
	
	
	
	
	
}
