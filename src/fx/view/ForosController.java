package fx.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ForosController  implements PrincipalController , Initializable{

	ScreensController controlador;
	
	@FXML
	private Pane pane_temas, pane_comentarios;
	@FXML
	private Button boton_menu, boton_cerrar_sesion,boton_todo_tema;
	@FXML
	public static Label l;
	@FXML
	public AnchorPane padre;
	
	public ForosController(){
	}
	
	
	//EVENTOS BOTONES MENU SUPERIOR
	public void ClickVolverMenu(ActionEvent event) {
		if (main.U.alumno_actual!=null){
			controlador.setScreen(main.AlumnoID);
		}
		else if (main.U.administrador_actual!=null){
			controlador.setScreen(main.AdminID);
		}		
		else if (main.U.profesor_actual!=null){
			controlador.setScreen(main.ProfesorID);
		}
		else{
			controlador.setScreen(main.InicioID);
		}
		
	}
	public void ClickCerrarSesion(ActionEvent event) {
		controlador.setScreen(main.InicioID);
		if (main.U.alumno_actual!=null){
			main.U.alumno_actual.Cerrar_sesion();
			main.U.alumno_actual=null;
		}
		if (main.U.administrador_actual!=null){
			main.U.administrador_actual.Cerrar_sesion();
			main.U.administrador_actual=null;
		}		
		if (main.U.profesor_actual!=null){
			main.U.profesor_actual.Cerrar_sesion();
			main.U.profesor_actual=null;
		}
		controlador.setScreen(main.InicioID);
		Serializador.serializar(main.U);
	}
	public void ClickTodoTema(ActionEvent event){
		CambiarAPanel(pane_temas);
	}
	
	//EVENTOS PANEL TEMAS!!
	public void SeleccionarTema(ActionEvent event){
		CambiarAPanel(pane_comentarios);
	}
	
	
	
	public static void CambiarNombreMenu(String nombre){
		l.setText(nombre);
	}
	// EVENTO PARA CAMBIAR PANES
	public void CambiarAPanel(Pane paneDeseado){
		pane_temas.setVisible(false);
		pane_comentarios.setVisible(false);
		paneDeseado.setVisible(true);
	}
	// EVENTO PARA CAMBIAR DE PAGINAS
	@Override
	public void setScreenParent(ScreensController ScreenPage) {
		controlador = ScreenPage;
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		l = new Label("soy nuevooo!!!");
		padre.getChildren().add(l);
		l.setTextFill(Color.web("#0000ff"));
		l.setFont(new Font("System Bold", 14));
		l.relocate(642.0, 20.0);
	}
}
