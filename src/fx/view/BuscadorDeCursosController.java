package fx.view;


import java.util.ArrayList;
import java.util.List;

import g4.Carrera;
import g4.Curso;
import g4.CursoTabla;
import g4.Malla_curricular;
import g4.Programacion_Academica;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import jdk.nashorn.internal.runtime.ListAdapter;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class BuscadorDeCursosController implements PrincipalController {
	/// objeto para realizar el cambio de paginas
	ScreensController controlador;
	ArrayList<CursoTabla> cursos_seleccionados;
	
	
	@FXML
	private Label error_busqueda,error_seleccion;
	@FXML
	private Pane pane_aceptar; 
	@FXML
	private Button boton_eliminar, boton_agregar, boton_cerrar_sesion, boton_menu, boton_buscar, boton_aceptar;
	@FXML
	private ChoiceBox<String> text_periodo;
	@FXML
	private ChoiceBox<Carrera> text_carrera;
	@FXML
	private TextField text_sigla;
	@FXML
	private TextField text_profesor;
	@FXML
	private TableView<CursoTabla> tabla_seleccion,tabla_busqueda;
	@FXML
	private TableColumn<CursoTabla,String> sigla_seleccion,sigla_busqueda;
	@FXML
	private TableColumn<CursoTabla,String> secc_seleccion,secc_busqueda;
	@FXML
	private TableColumn<CursoTabla,String> profesor_seleccion,profesor_busqueda;
	@FXML
	private TableColumn<CursoTabla,String> nombre_seleccion,nombre_busqueda;
	@FXML
	private TableColumn<CursoTabla,String> horario_seleccion,horario_busqueda,carrera_busqueda,prerequisitos_busqueda;
	@FXML
	private ObservableList<CursoTabla> data_seleccion = FXCollections.observableArrayList();
	@FXML
	private ObservableList<CursoTabla> data_busqueda = FXCollections.observableArrayList();
	@FXML
	private ArrayList<String> horario_buscar = new ArrayList<String>();
	@FXML
	private CheckBox lu_1,lu_2,lu_3,lu_4,lu_5,lu_6,lu_7,lu_8; 
	@FXML
	private CheckBox ma_1,ma_2,ma_3,ma_4,ma_5,ma_6,ma_7, ma_8; 
	@FXML
	private CheckBox mi_1,mi_2,mi_3,mi_4,mi_5, mi_6,mi_7,mi_8;
	@FXML
	private CheckBox ju_1, ju_2,ju_3, ju_4,ju_5,ju_6, ju_7,ju_8;
	@FXML
	private CheckBox vi_1,vi_2,vi_3,vi_4,vi_5, vi_6,vi_7,vi_8;
	@FXML
	private CheckBox sa_1,sa_2,sa_3, sa_4,sa_5,sa_6, sa_7,sa_8;
	
	public void ClickAceptar(ActionEvent e){
		cursos_seleccionados = new ArrayList<CursoTabla>();
		
		pane_aceptar.setVisible(false);
		ObservableList<Carrera> ss = FXCollections
				.observableList(main.U.lista_carreras);
		
		text_carrera.setItems(ss);
		data_seleccion = FXCollections.observableArrayList();
		data_busqueda = FXCollections.observableArrayList();
		ArrayList<String> periodos = new ArrayList<String>();
		for (Programacion_Academica j : main.U.historial_de_progrmacion_academica){
			periodos.add(j.periodo);}
		ObservableList<String> uu = FXCollections
				.observableList(periodos);
		text_periodo.setItems(uu);
		text_periodo.setValue(periodos.get(0));


		prerequisitos_busqueda.setCellValueFactory(new PropertyValueFactory<CursoTabla,String>("prerrequisitos"));
		sigla_seleccion.setCellValueFactory(new PropertyValueFactory<CursoTabla,String>("sigla"));
		secc_seleccion.setCellValueFactory(new PropertyValueFactory<CursoTabla,String>("seccion"));
		nombre_seleccion.setCellValueFactory(new PropertyValueFactory<CursoTabla,String>("nombre"));
		profesor_seleccion.setCellValueFactory(new PropertyValueFactory<CursoTabla,String>("profesores"));
		horario_seleccion.setCellValueFactory(new PropertyValueFactory<CursoTabla,String>("horarios"));
		tabla_seleccion.setItems(data_seleccion);
		
		sigla_busqueda.setCellValueFactory(new PropertyValueFactory<CursoTabla,String>("sigla"));
		secc_busqueda.setCellValueFactory(new PropertyValueFactory<CursoTabla,String>("seccion"));
		nombre_busqueda.setCellValueFactory(new PropertyValueFactory<CursoTabla,String>("nombre"));
		profesor_busqueda.setCellValueFactory(new PropertyValueFactory<CursoTabla,String>("profesores"));
		horario_busqueda.setCellValueFactory(new PropertyValueFactory<CursoTabla,String>("horarios"));
		carrera_busqueda.setCellValueFactory(new PropertyValueFactory<CursoTabla,String>("carrera"));
		tabla_busqueda.setItems(data_busqueda);
		
		lu_1.setText("lu:1");
		lu_2.setText("lu:2");
		lu_3.setText("lu:3");
		lu_4.setText("lu:4");
		lu_5.setText("lu:5");
		lu_6.setText("lu:6");
		lu_7.setText("lu:7");
		lu_8.setText("lu:8");
		
		ma_1.setText("ma:1");
		ma_2.setText("ma:2");
		ma_3.setText("ma:3");
		ma_4.setText("ma:4");
		ma_5.setText("ma:5");
		ma_6.setText("ma:6");
		ma_7.setText("ma:7");
		ma_8.setText("ma:8");
		
		mi_1.setText("mi:1");
		mi_2.setText("mi:2");
		mi_3.setText("mi:3");
		mi_4.setText("mi:4");
		mi_5.setText("mi:5");
		mi_6.setText("mi:6");
		mi_7.setText("mi:7");
		mi_8.setText("mi:8");
		
		ju_1.setText("ju:1");
		ju_2.setText("ju:2");
		ju_3.setText("ju:3");
		ju_4.setText("ju:4");
		ju_5.setText("ju:5");
		ju_6.setText("ju:6");
		ju_7.setText("ju:7");
		ju_8.setText("ju:8");
		
		vi_1.setText("vi:1");
		vi_2.setText("vi:2");
		vi_3.setText("vi:3");
		vi_4.setText("vi:4");
		vi_5.setText("vi:5");
		vi_6.setText("vi:6");
		vi_7.setText("vi:7");
		vi_8.setText("vi:8");
		
		sa_1.setText("sa:1");
		sa_2.setText("sa:2");
		sa_3.setText("sa:3");
		sa_4.setText("sa:4");
		sa_5.setText("sa:5");
		sa_6.setText("sa:6");
		sa_7.setText("sa:7");
		sa_8.setText("sa:8");
		
		
		
	}
	
	
	
	public void ClickCerrarSesion(ActionEvent event) {
		VaciarTablas();
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
	public void ClickVolverMenu(ActionEvent event) {
		VaciarTablas();
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
	
	public void ClickEliminar(ActionEvent event) {
		error_seleccion.setText("");
		error_busqueda.setText("");
		CursoTabla curso = tabla_seleccion.getSelectionModel().getSelectedItem();
		if (curso!=null){
			data_seleccion.remove(curso);
			cursos_seleccionados.remove(curso);
			ActualizarSeleccion();
		}else{
			error_seleccion.setText("seleccione un curso");
		}
	}	
	public void ClickBuscar(ActionEvent event) {
		error_seleccion.setText("");
		error_busqueda.setText("");
		String prof = text_profesor.getText();
		String sigla = text_sigla.getText();
		int carrera = -1;
		if (text_carrera.getValue()!=null){
			carrera = ((Carrera) text_carrera.getValue()).getId_carrera();
		}
		String periodo = text_periodo.getValue();
		
		
		ArrayList<Curso> cursos = main.U.buscador.filtrar(horario_buscar, prof, carrera, sigla,periodo);
		ArrayList<CursoTabla> ct = new ArrayList<CursoTabla>();
		for (Curso j : cursos){
			ct.add(new CursoTabla(j));
		}
		data_busqueda = FXCollections.observableArrayList(ct);
		ActualizarBusqueda();
	}
	
	
	public void ClickAgregar(ActionEvent event) {
		error_seleccion.setText("");
		error_busqueda.setText("");
		CursoTabla curso =tabla_busqueda.getSelectionModel().getSelectedItem();
		if (curso!=null){
			if (!TopeDeHorario(curso)){
				data_seleccion.add(curso);
				cursos_seleccionados.add(curso);
				ActualizarSeleccion();
			}else{
				error_busqueda.setText("hay tope de horarios con tus cursos ya seleccionados");
			}
		}else{
			error_busqueda.setText("seleccione algun curso.");
		}
	}
	
	
	// evento para cambiar de paginas.
	@Override
	public void setScreenParent(ScreensController ScreenPage) {
		controlador = ScreenPage;
	}

	public void VaciarTablas(){
		pane_aceptar.setVisible(true);
		data_seleccion = FXCollections.observableArrayList(new ArrayList<CursoTabla>());
		tabla_seleccion.setItems(data_seleccion);
		tabla_busqueda.setItems(data_seleccion);
		text_sigla.setText("");
		text_profesor.setText("");
		text_carrera.setValue(null);
		cursos_seleccionados = new ArrayList<CursoTabla>();
		lu_1.setSelected(false); ma_1.setSelected(false); mi_1.setSelected(false);  ju_1.setSelected(false);  vi_1.setSelected(false);  sa_1.setSelected(false); 
		lu_2.setSelected(false); ma_2.setSelected(false); mi_2.setSelected(false);  ju_2.setSelected(false);  vi_2.setSelected(false);  sa_2.setSelected(false); 
		lu_3.setSelected(false); ma_3.setSelected(false); mi_3.setSelected(false);  ju_3.setSelected(false);  vi_3.setSelected(false);  sa_3.setSelected(false); 
		lu_4.setSelected(false); ma_4.setSelected(false); mi_4.setSelected(false);  ju_4.setSelected(false);  vi_4.setSelected(false);  sa_4.setSelected(false); 
		lu_5.setSelected(false); ma_5.setSelected(false); mi_5.setSelected(false);  ju_5.setSelected(false);  vi_5.setSelected(false);  sa_5.setSelected(false); 
		lu_6.setSelected(false); ma_6.setSelected(false); mi_6.setSelected(false);  ju_6.setSelected(false);  vi_6.setSelected(false);  sa_6.setSelected(false); 
		lu_7.setSelected(false); ma_7.setSelected(false); mi_7.setSelected(false);  ju_7.setSelected(false);  vi_7.setSelected(false);  sa_7.setSelected(false); 
		lu_8.setSelected(false); ma_8.setSelected(false); mi_8.setSelected(false);  ju_8.setSelected(false);  vi_8.setSelected(false);  sa_8.setSelected(false); 
		horario_buscar.clear();
		error_seleccion.setText("");
		error_busqueda.setText("");
	}
	
	
	public void ActualizarBusqueda(){
		tabla_busqueda.setItems(data_busqueda);
	}
	
	
	public void ActualizarSeleccion(){
		tabla_seleccion.setItems(data_seleccion);
	}
	
	public void ClickCheckbox(ActionEvent e){
		if (e.getSource() instanceof CheckBox) {
			CheckBox chk = (CheckBox) e.getSource();
			if (horario_buscar.contains(chk.getText())) {
				horario_buscar.remove(chk.getText());
            } else {
            	horario_buscar.add(chk.getText());
            }
		}
	}
	
	public boolean TopeDeHorario(CursoTabla curso){
		boolean aux = false;
		String[] horarios = curso.getHorarios().split(",");
		if (cursos_seleccionados.size()>0){
			for (CursoTabla j : cursos_seleccionados){
				for (String h: horarios){
					if (j.getHorarios().toLowerCase().contains(h.toLowerCase())){
						aux =true;}}}}
		return aux;
	}

}
