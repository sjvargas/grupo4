package fx.view;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
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
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
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
	private ImageView foto_profesor; 
	@FXML
	public TextField text_field_buscar;
	@FXML
	public ToggleGroup tg_profesor,tg_ramo;
	@FXML
	public Slider slider_dificultad_profesor,slider_dificultad_ramo,slider_utilidad_ramo;
	@FXML
	public Label contador_likes_ramo,ramo_nombre_grande,contador_likes_profesor,profesor_nombre_grande,error_seleccion_profesor, error_seleccion_ramo,label_nombre_profesor,label_facultad_profesor;
	@FXML
	public Label label_descarga,label_carrera_ramo,label_semestre_ramo,label_creditos_ramo,label_sigla_ramo,error_ver_top_ramo,error_ver_top_profesor;
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
	private Button boton_buscar,boton_calificar_ramo2,boton_calificar,boton_volver_cuenta,boton_inicio, boton_cerrar_sesion,boton_rn_profesor,boton_rn_ramo,boton_top_profesores,boton_top_ramos,boton_ver_ramo,boton_ver_profesor;
	@FXML
	private Button boton_descargar_contenido,boton_like_ramo,boton_ver_top_ramo,boton_ramo_a1,boton_ramo_a2,boton_ramo_a3,boton_ramo_a4,boton_ramo_a5, boton_ramo_d1,boton_ramo_d2,boton_ramo_d3,boton_ramo_d4,boton_ramo_d5;
	@FXML
	private Button boton_ver_top_profesor,boton_profesor_a1,boton_profesor_a2,boton_profesor_a3,boton_profesor_a4,boton_profesor_a5, boton_profesor_d1,boton_profesor_d2,boton_profesor_d3,boton_profesor_d4,boton_profesor_d5;
	@FXML
	private RadioButton radio_boton_dificultad,radio_boton_utilidad,radio_boton_likes,radio_boton_dificultad_profesor,radio_boton_likes_profesor;
	@FXML
	private Circle pd1,pd2,pd3,pd4,pd5,ru1,ru2,ru3,ru4,ru5,rd1,rd2,rd3,rd4,rd5;
	@FXML
	private ListView<String> list_view_historial_profesor,list_view_prerrequisitos;
	
	boolean modoDificultadSelecionado= true;
	boolean modoLikesSelecionado=false;
	boolean modoUtilidadSelecionado=false;
	boolean modoLikesSelecionadoProfesor=false;
	boolean modoDificultadSelecionadoProfesor = true;
	
	Ramo ramo_seleccionado;
	Profesor profesor_seleccionado;
	List<Profesor> profesores_buscados;
	List<Ramo> ramo_buscados;
	
	
	// EVENTOS PANTALLA PRINCIPAL
	public void ClickBuscar(ActionEvent event) {
		String texto = text_field_buscar.getText();
		
		if (texto.length()>0){
			profesores_buscados = main.U.BuscarProfesores(texto);
			ramo_buscados = main.U.BuscarRamos(texto);
		}
		else{
			profesores_buscados = new ArrayList<Profesor>();
			ramo_buscados = new ArrayList<Ramo>();
		}
		
		data_ver_profesor = FXCollections.observableArrayList(profesores_buscados);
		data_ver_ramo = FXCollections.observableArrayList(ramo_buscados);
		
		columna_ramo_sigla.setCellValueFactory(new PropertyValueFactory<Ramo,String>("sigla"));
		columna_ramo_nombre.setCellValueFactory(new PropertyValueFactory<Ramo,String>("nombreRamo"));
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
		error_ver_top_ramo.setText("");
		boton_ramo_a1.setText("---");
		boton_ramo_a2.setText("---");
		boton_ramo_a3.setText("---");
		boton_ramo_a4.setText("---");
		boton_ramo_a5.setText("---");
		boton_ramo_d1.setText("---");
		boton_ramo_d2.setText("---");
		boton_ramo_d3.setText("---");
		boton_ramo_d4.setText("---");
		boton_ramo_d5.setText("---");
		CambiarAPanel(pane_top_ramos);
	}
	public void ClickTopProfesores(ActionEvent event) {
		error_ver_top_profesor.setText("");

		boton_profesor_a1.setText("---");
		boton_profesor_a2.setText("---");
		boton_profesor_a3.setText("---");
		boton_profesor_a4.setText("---");
		boton_profesor_a5.setText("---");
		boton_profesor_d1.setText("---");
		boton_profesor_d2.setText("---");
		boton_profesor_d3.setText("---");
		boton_profesor_d4.setText("---");
		boton_profesor_d5.setText("---");
		CambiarAPanel(pane_top_profesores);
	}
	public void ClickRandomRamo(ActionEvent event) {
		ramo_seleccionado = main.U.GetRandomRamo();
		CambiarARamo();
		CambiarAPanel(pane_ramo);
	}
	public void ClickRandomProfesor(ActionEvent event) {
		CambiarAPanel(pane_profesor);
		profesor_seleccionado = main.U.GetRandomProfesor();
		CambiarAProfesor();
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
		error_ver_top_ramo.setText("");
		if (e.getSource() instanceof Button) {
			Button chk = (Button) e.getSource(); // getText es la sigla
			if (!chk.getText().contains("---")){
			ramo_seleccionado = main.U.GetRamo(chk.getText());
			CambiarARamo();
			CambiarAPanel(pane_ramo);
			}else{
				error_ver_top_ramo.setText("ERROR: seleccione algun top");
			}
		}
	}
	public void ClickVerTopRamo (ActionEvent e){
		error_ver_top_ramo.setText("");
		if (modoDificultadSelecionado ||modoUtilidadSelecionado ||modoLikesSelecionado){
			List<Ramo> top_a = new ArrayList<Ramo>();
			List<Ramo> top_d = new ArrayList<Ramo>();
			if (modoDificultadSelecionado){
				top_a = main.U.Top5Ramos(1, 2);
				top_d = main.U.Top5Ramos(0, 2);
			}
			else if (modoLikesSelecionado){
				top_a = main.U.Top5Ramos(1, 1);
				top_d = main.U.Top5Ramos(0, 1);
			}
			else{
				top_a = main.U.Top5Ramos(1, 3);
				top_d = main.U.Top5Ramos(0, 3);
			}
			boton_ramo_a1.setText(top_a.get(0).getSigla());
			boton_ramo_a2.setText(top_a.get(1).getSigla());
			boton_ramo_a3.setText(top_a.get(2).getSigla());
			boton_ramo_a4.setText(top_a.get(3).getSigla());
			boton_ramo_a5.setText(top_a.get(4).getSigla());
			boton_ramo_d1.setText(top_d.get(0).getSigla());
			boton_ramo_d2.setText(top_d.get(1).getSigla());
			boton_ramo_d3.setText(top_d.get(2).getSigla());
			boton_ramo_d4.setText(top_d.get(3).getSigla());
			boton_ramo_d5.setText(top_d.get(4).getSigla());
		}
		else{
			error_ver_top_ramo.setText("ERROR: seleccione de nuevo");
		}
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
			error_ver_top_profesor.setText("");
			Button chk = (Button) e.getSource(); // getText es la sigla
			if (!chk.getText().contains("---")){
				String str = chk.getText().split("--")[0];
				profesor_seleccionado = main.U.GetProfesor(Integer.parseInt(str));
				CambiarAProfesor();
				CambiarAPanel(pane_profesor);
			}else {
				error_ver_top_profesor.setText("ERROR: seleccione algun top");
			}
		}
	}
	public void ClickVerTopProfesor (ActionEvent e){
		error_ver_top_profesor.setText("");
		if (modoLikesSelecionadoProfesor || modoDificultadSelecionadoProfesor){
			List<Profesor> top_a = new ArrayList<Profesor>();
			List<Profesor> top_d = new ArrayList<Profesor>();
			if (modoDificultadSelecionado){
				top_a = main.U.Top5Profesores(1, 2);
				top_d = main.U.Top5Profesores(0, 2);
			}
			else {
				top_a = main.U.Top5Profesores(1, 1);
				top_d = main.U.Top5Profesores(0, 1);
			}
			boton_profesor_a1.setText(top_a.get(0).getId_profesor()+"--"+top_a.get(0).getNombre());
			boton_profesor_a2.setText(top_a.get(1).getId_profesor()+"--"+top_a.get(1).getNombre());
			boton_profesor_a3.setText(top_a.get(2).getId_profesor()+"--"+top_a.get(2).getNombre());
			boton_profesor_a4.setText(top_a.get(3).getId_profesor()+"--"+top_a.get(3).getNombre());
			boton_profesor_a5.setText(top_a.get(4).getId_profesor()+"--"+top_a.get(4).getNombre());
			boton_profesor_d1.setText(top_d.get(0).getId_profesor()+"--"+top_d.get(0).getNombre());
			boton_profesor_d2.setText(top_d.get(1).getId_profesor()+"--"+top_d.get(1).getNombre());
			boton_profesor_d3.setText(top_d.get(2).getId_profesor()+"--"+top_d.get(2).getNombre());
			boton_profesor_d4.setText(top_d.get(3).getId_profesor()+"--"+top_d.get(3).getNombre());
			boton_profesor_d5.setText(top_d.get(4).getId_profesor()+"--"+top_d.get(4).getNombre());
		}
		else{
			error_ver_top_profesor.setText("ERROR: seleccione de nuevo");
		}
	}
	
	// EVENTOS PANTALLA BUSQUEDA
	public void ClickVerProfesor(ActionEvent e){
		Profesor p = tabla_busqueda_profesor.getSelectionModel().getSelectedItem();
		if (p!=null){
			error_seleccion_profesor.setText("");
			error_seleccion_ramo.setText("");
			profesor_seleccionado = p;
			CambiarAProfesor();
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
			CambiarARamo();
			CambiarAPanel(pane_ramo);
		}else{
			error_seleccion_ramo.setText("Error en la seleccion intente de nuevo");
		}
	}
	
	// EVENTOS PANTALLA PROFESOR
	public void ClickCalificarProfesor(ActionEvent e){
		Double u = slider_dificultad_profesor.getValue();
		profesor_seleccionado.DarDificultad(u);
		CalcularDificultadProfesor();
		
	}
	public void ClickProfesorLike(ActionEvent e){
		profesor_seleccionado.DarLike();
		contador_likes_profesor.setText(profesor_seleccionado.getLikes().toString());
	}
	
	//EVENTOS PANTALLA RAMO
	public void ClickClificarUtilidadRamo(ActionEvent e){
		Double u = slider_utilidad_ramo.getValue();
		ramo_seleccionado.DarDificultad(u);
		CalcularUtilidadRamo();
	}
	public void ClickClificarDificultadRamo(ActionEvent e){

		Double u = slider_dificultad_ramo.getValue();
		ramo_seleccionado.DarDificultad(u);
		CalcularDificultadRamo();
		
	}
	public void ClickRamoLike(ActionEvent e){
		ramo_seleccionado.DarLike();
		contador_likes_ramo.setText(ramo_seleccionado.getLikes().toString());
	}
	
	public void ClickDescarga(ActionEvent e) throws IOException {
		label_descarga.setText("Descargado!");
        BufferedWriter output = null;
        try {
    		String nombre_archivo = "programa-"+ramo_seleccionado.getSigla()+".txt";
    		File file = new File(nombre_archivo);
            output = new BufferedWriter(new FileWriter(file));
    		output.write("Programa\nRamo: "+ramo_seleccionado.getNombreRamo()+"-"+ramo_seleccionado.getSigla());
			output.newLine();
			output.newLine();
			if (ramo_seleccionado.getPrograma().size()>0){
	    		for (String line : ramo_seleccionado.getPrograma()){
	    			output.write(line);
	    			output.newLine();
	    		}
			}else{
    			output.write("Programa No Disponible.");
    			output.newLine();				
			}
    		output.close();
        } catch ( IOException e1 ) {
    		label_descarga.setText("error en la descarga");
        } finally {
            if ( output != null ) output.close();
        }
	}
	
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
	public void CambiarAProfesor(){
		ObservableList<String> items = FXCollections.observableArrayList(profesor_seleccionado.SiglasTodosCursos());
		list_view_historial_profesor.setItems(items);
		label_nombre_profesor.setText(profesor_seleccionado.toString());
		profesor_nombre_grande.setText(profesor_seleccionado.toString());
		label_facultad_profesor.setText(profesor_seleccionado.getFacultad());
		slider_dificultad_profesor.setValue(3);
		CalcularDificultadProfesor();
		contador_likes_profesor.setText(profesor_seleccionado.getLikes().toString());
	}
	public void CambiarARamo(){
		ObservableList<String> items = FXCollections.observableArrayList(ramo_seleccionado.GetPrerrequisitos());
		list_view_prerrequisitos.setItems(items);
		label_descarga.setText("");
		ramo_nombre_grande.setText(ramo_seleccionado.getNombreRamo());
		label_sigla_ramo.setText(ramo_seleccionado.getSigla());
		label_creditos_ramo.setText(String.valueOf(ramo_seleccionado.getCreditos()));
		label_semestre_ramo.setText(ramo_seleccionado.getSemestreImpartidoString());
		label_carrera_ramo.setText(ramo_seleccionado.getCarrera().getNombreCarrera());
		slider_dificultad_ramo.setValue(3);
		slider_utilidad_ramo.setValue(3);
		CalcularUtilidadRamo();
		CalcularDificultadRamo();
		contador_likes_ramo.setText(ramo_seleccionado.getLikes().toString());
	}
	public void CalcularDificultadProfesor(){
		Double u = profesor_seleccionado.getDificultad();
		pd1.setOpacity(1);
		pd2.setOpacity(1);
		pd3.setOpacity(1);
		pd4.setOpacity(1);
		pd5.setOpacity(1);
		if (u<2){
			pd2.setOpacity(u-1);
			pd3.setOpacity(0);
			pd4.setOpacity(0);
			pd5.setOpacity(0);
		}else if (u<3){
			pd3.setOpacity(u-2);
			pd4.setOpacity(0);
			pd5.setOpacity(0);
		}else if (u<4){
			pd4.setOpacity(u-3);
			pd5.setOpacity(0);
		}else if (u<5){
			pd5.setOpacity(u-4);
		}
	}
	public void CalcularUtilidadRamo(){
		Double u = ramo_seleccionado.getDificultad();
		ru1.setOpacity(1);
		ru2.setOpacity(1);
		ru3.setOpacity(1);
		ru4.setOpacity(1);
		ru5.setOpacity(1);
		if (u<2){
			ru2.setOpacity(u-1);
			ru3.setOpacity(0);
			ru4.setOpacity(0);
			ru5.setOpacity(0);
		}else if (u<3){
			ru3.setOpacity(u-2);
			ru4.setOpacity(0);
			ru5.setOpacity(0);
		}else if (u<4){
			ru4.setOpacity(u-3);
			ru5.setOpacity(0);
		}else if (u<5){
			ru5.setOpacity(u-4);
		}
	}
	public void CalcularDificultadRamo(){
		Double u = ramo_seleccionado.getDificultad();
		rd1.setOpacity(1);
		rd2.setOpacity(1);
		rd3.setOpacity(1);
		rd4.setOpacity(1);
		rd5.setOpacity(1);
		if (u<2){
			rd2.setOpacity(u-1);
			rd3.setOpacity(0);
			rd4.setOpacity(0);
			rd5.setOpacity(0);
		}else if (u<3){
			rd3.setOpacity(u-2);
			rd4.setOpacity(0);
			rd5.setOpacity(0);
		}else if (u<4){
			rd4.setOpacity(u-3);
			rd5.setOpacity(0);
		}else if (u<5){
			rd5.setOpacity(u-4);
		}
	}
}
