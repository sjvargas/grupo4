package fx.view;

import java.util.Date;
import java.util.List;

import g4.Comentario;
import g4.CursoTabla;
import g4.Profesor;
import g4.Ramo;
import g4.Tema;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

public class RedDeOpinionesController implements PrincipalController  {
	/// objeto para realizar el cambio de paginas
	ScreensController controlador;
	
	//IDS OBJETOS DE LA VISTA
	@FXML
	public AnchorPane padre;
	@FXML
	private Pane pane_inicio,pane_buscar,pane_ramo,pane_profesor,pane_top_profesores,pane_top_ramos;
	@FXML
	private ImageView boton_buscar,foto_profesor; 
	@FXML
	public TextField text_field_buscar;
	@FXML
	public Label error_seleccion_profesor, error_seleccion_ramo,label_nombre_profesor,label_facultad_profesor;
	@FXML
	private TableView<Profesor> tabla_busqueda_profesor;
	@FXML
	private TableColumn<Profesor,String> columna_profesor_nombre;
	@FXML
	private TableColumn<Profesor,Double> columna_profesor_likes,columna_profesor_dificultad;
	@FXML
	private TableView<Ramo> tabla_busqueda_ramo;
	@FXML
	private TableColumn<Ramo,String> columna_ramo_sigla,columna_ramo_nombre;
	@FXML
	private TableColumn<Ramo,Double> columna_ramo_likes,columna_ramo_utilidad,columna_ramo_dificultad;
	@FXML
	private ObservableList<Profesor> data_ver_profesor = FXCollections.observableArrayList();
	@FXML
	private ObservableList<Ramo> data_ver_ramo = FXCollections.observableArrayList();
	@FXML
	private Button boton_calificar,boton_volver_cuenta,boton_inicio, boton_cerrar_sesion,boton_rn_profesor,boton_rn_ramo,boton_top_profesores,boton_top_ramos,boton_ver_ramo,boton_ver_profesor;
	@FXML
	private Button boton_ver_top_ramo,boton_ramo_a1,boton_ramo_a2,boton_ramo_a3,boton_ramo_a4,boton_ramo_a5, boton_ramo_d1,boton_ramo_d2,boton_ramo_d3,boton_ramo_d4,boton_ramo_d5;
	@FXML
	private Button boton_ver_top_profesor,boton_profesor_a1,boton_profesor_a2,boton_profesor_a3,boton_profesor_a4,boton_profesor_a5, boton_profesor_d1,boton_profesor_d2,boton_profesor_d3,boton_profesor_d4,boton_profesor_d5;
	@FXML
	private RadioButton radio_boton_dificultad,radio_boton_utilidad,radio_boton_likes,radio_boton_dificultad_profesor,radio_boton_likes_profesor;
	@FXML
	private Circle pl1,pl2,pl3,pl4,pl5,pd1,pd2,pd3,pd4,pd5;
	
	boolean modoDificultadSelecionado;
	boolean modoLikesSelecionado;
	boolean modoUtilidadSelecionado;
	boolean modoLikesSelecionadoProfesor;
	boolean modoDificultadSelecionadoProfesor;
	
	Ramo ramo_seleccionado;
	Profesor profesor_seleccionado;
	List<Profesor> profesores_buscados;
	List<Ramo> ramo_buscados;
	
	
	// EVENTOS PANTALLA PRINCIPAL
	public void ClickBuscar(ActionEvent event) {
		
		String texto = text_field_buscar.getText();
		
		profesores_buscados = main.U.BuscarProfesores(texto);
		ramo_buscados = main.U.BuscarRamos(texto);
		data_ver_profesor = FXCollections.observableArrayList(profesores_buscados);
		data_ver_ramo = FXCollections.observableArrayList(ramo_buscados);
		
		columna_ramo_sigla.setCellValueFactory(new PropertyValueFactory<Ramo,String>("sigla"));
		columna_ramo_nombre.setCellValueFactory(new PropertyValueFactory<Ramo,String>("nombre"));
		columna_ramo_likes.setCellValueFactory(new PropertyValueFactory<Ramo,Double>("likes"));
		columna_ramo_utilidad.setCellValueFactory(new PropertyValueFactory<Ramo,Double>("utilidad"));
		columna_ramo_dificultad.setCellValueFactory(new PropertyValueFactory<Ramo,Double>("dificultad"));
		tabla_busqueda_ramo.setItems(data_ver_ramo);		
		
		columna_profesor_nombre.setCellValueFactory(new PropertyValueFactory<Profesor,String>("nombre"));
		columna_profesor_likes.setCellValueFactory(new PropertyValueFactory<Profesor,Double>("likes"));
		columna_profesor_dificultad.setCellValueFactory(new PropertyValueFactory<Profesor,Double>("dificultad"));
		tabla_busqueda_profesor.setItems(data_ver_profesor);

		CambiarAPanel(pane_buscar);
	}
	public void ClickVolverCuenta(ActionEvent event) {
		CambiarAPanel(pane_inicio);
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
		CambiarAPanel(pane_inicio);
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
	public void ClickVolverInicio(ActionEvent event){
		error_seleccion_profesor.setText("");
		error_seleccion_ramo.setText("");
		CambiarAPanel(pane_inicio);
	}
	
	//EVENTOS PANTALLA INICIO
	public void ClickTopRamos(ActionEvent event) {
		CambiarAPanel(pane_top_ramos);
	}
	public void ClickTopProfesores(ActionEvent event) {
		CambiarAPanel(pane_top_profesores);
	}
	public void ClickRandomRamo(ActionEvent event) {
		CambiarAPanel(pane_ramo);
	}
	public void ClickRandomProfesor(ActionEvent event) {
		CambiarAPanel(pane_profesor);
	}
	
	//EVENTOS PANTALLA TOP RAMO
	public void SeleccionarModoLike(){
		modoDificultadSelecionado  = false;
		modoLikesSelecionado = true;
		modoUtilidadSelecionado = false;
	}
	public void SeleccionarModoDificultad(){
		modoDificultadSelecionado  = true;
		modoLikesSelecionado = false;
		modoUtilidadSelecionado = false;
	}
	public void SeleccionarModoUtilidad(){
		modoDificultadSelecionado  = false;
		modoLikesSelecionado = false;
		modoUtilidadSelecionado = true;
	}
	
	public void ClickBotonRamoTop(ActionEvent e){
		if (e.getSource() instanceof Button) {
			Button chk = (Button) e.getSource(); // getText es la sigla
			ramo_seleccionado = main.U.GetRamo(chk.getText());
			CambiarAPanel(pane_ramo);
		}
	}
	public void ClickVerTopRamo (ActionEvent e){
		
	}
	
	//EVENTOS PANTALLA TOP PROFESORES
	public void SeleccionarModoLikeProfesor(){
		modoDificultadSelecionadoProfesor  = false;
		modoLikesSelecionadoProfesor = true;
	}
	public void SeleccionarModoDificultadProfesor(){
		modoDificultadSelecionadoProfesor  = true;
		modoLikesSelecionadoProfesor = false;
	}
	
	public void ClickBotonProfesorTop(ActionEvent e){
		if (e.getSource() instanceof Button) {
			Button chk = (Button) e.getSource(); // getText es la sigla
			String str = chk.getText().split("-")[0];
			profesor_seleccionado = main.U.GetProfesor(Integer.parseInt(str));
			CambiarAPanel(pane_profesor);
		}
	}
	public void ClickVerTopProfesor (ActionEvent e){
		
	}
	
	// EVENTOS PANTALLA BUSQUEDA
	public void ClickVerProfesor(ActionEvent e){
		Profesor p = tabla_busqueda_profesor.getSelectionModel().getSelectedItem();
		if (p!=null){
			error_seleccion_profesor.setText("");
			error_seleccion_ramo.setText("");
			profesor_seleccionado = p;
			CambiarAPanel(pane_profesor);
		}else{
			error_seleccion_profesor.setText("Error en la seleccion intente de nuevo");
		}
	}	
	public void ClickVerRamo(ActionEvent e){
		Ramo r = tabla_busqueda_ramo.getSelectionModel().getSelectedItem();
		if (r!=null){
			error_seleccion_profesor.setText("");
			error_seleccion_ramo.setText("");
			ramo_seleccionado = r;
			CambiarAPanel(pane_ramo);
		}else{
			error_seleccion_ramo.setText("Error en la seleccion intente de nuevo");
		}
	}
	
	// EVENTOS PANTALLA PROFESOR
	public void ClickClificar(ActionEvent e){
	
	}
	
	//EVENTOS PANTALLA RAMO
	
	
	
	
	//EVENTOS EXTRAS
	// evento para cambiar de paginas.
	@Override
	public void setScreenParent(ScreensController ScreenPage) {
		controlador = ScreenPage;
	}
	// EVENTO PARA CAMBIAR PANES
	public void CambiarAPanel(Pane paneDeseado){
		pane_inicio.setVisible(false);
		pane_buscar.setVisible(false);
		pane_ramo.setVisible(false);
		pane_profesor.setVisible(false);
		pane_top_profesores.setVisible(false);
		pane_top_ramos.setVisible(false);
		paneDeseado.setVisible(true);
	}
}
