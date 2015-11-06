package fx.view;


import java.util.ArrayList;

import g4.Carrera;
import g4.Curso;
import g4.Malla_curricular;
import g4.Programacion_Academica;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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
	private ChoiceBox<String> text_periodo;
	@FXML
	private ChoiceBox<Carrera> text_carrera;
	@FXML
	private TextField text_sigla;
	@FXML
	private TextField text_profesor;
	@FXML
	private TableView<Curso> tabla_seleccion;
	@FXML
	private TableColumn<Curso,String> sigla_seleccion;
	@FXML
	private TableColumn<Curso,String> secc_seleccion;
	@FXML
	private TableColumn<Curso,String> profesor_seleccion;
	@FXML
	private TableColumn<Curso,String> nombre_seleccion;
	@FXML
	private TableColumn<Curso,String> horarios_seleccion;
	@FXML
	private ObservableList<Curso> data_seleccion = FXCollections.observableArrayList();
	@FXML
	private String[] horarios_buscar;
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
	
	public BuscadorDeCursosController(){
	
		
//		ObservableList<Carrera> ss = FXCollections
//				.observableList(main.U.lista_carreras);
//		text_carrera.setItems(ss);
//		text_carrera.setValue(main.U.lista_carreras.get(0));
//		ArrayList<String> periodos = new ArrayList<String>();
//		for (Programacion_Academica j : main.U.historial_de_progrmacion_academica){
//			periodos.add(j.periodo);}
//		ObservableList<String> uu = FXCollections
//				.observableList(periodos);
//		text_periodo.setItems(uu);
//		text_periodo.setValue(periodos.get(0));


//		sigla_seleccion.setCellValueFactory(new PropertyValueFactory<Curso,String>("sigla"));
//		secc_seleccion.setCellValueFactory(new PropertyValueFactory<Curso,String>("seccion"));
//		nombre_seleccion.setCellValueFactory(new PropertyValueFactory<Curso,String>("nombre"));
//		profesor_seleccion.setCellValueFactory(new PropertyValueFactory<Curso,String>("profesores"));
//		horarios_seleccion.setCellValueFactory(new PropertyValueFactory<Curso,String>("horarios"));
//		
//		tabla_seleccion.setItems(data_seleccion);
		
		lu_1 = new CheckBox("lu:1");
		lu_2 = new CheckBox("lu:2");
		lu_3 = new CheckBox("lu:3");
		lu_4 = new CheckBox("lu:4");
		lu_5 = new CheckBox("lu:5");
		lu_6 = new CheckBox("lu:6");
		lu_7 = new CheckBox("lu:7");
		lu_8 = new CheckBox("lu:8");
		
		ma_1 = new CheckBox("ma:1");
		ma_2 = new CheckBox("ma:2");
		ma_3 = new CheckBox("ma:3");
		ma_4 = new CheckBox("ma:4");
		ma_5 = new CheckBox("ma:5");
		ma_6 = new CheckBox("ma:6");
		ma_7 = new CheckBox("ma:7");
		ma_8 = new CheckBox("ma:8");
		
		mi_1 = new CheckBox("mi:1");
		mi_2 = new CheckBox("mi:2");
		mi_3 = new CheckBox("mi:3");
		mi_4 = new CheckBox("mi:4");
		mi_5 = new CheckBox("mi:5");
		mi_6 = new CheckBox("mi:6");
		mi_7 = new CheckBox("mi:7");
		mi_8 = new CheckBox("mi:8");
		
		ju_1 = new CheckBox("ju:1");
		ju_2 = new CheckBox("ju:2");
		ju_3 = new CheckBox("ju:3");
		ju_4 = new CheckBox("ju:4");
		ju_5 = new CheckBox("ju:5");
		ju_6 = new CheckBox("ju:6");
		ju_7 = new CheckBox("ju:7");
		ju_8 = new CheckBox("ju:8");
		
		vi_1 = new CheckBox("vi:1");
		vi_2 = new CheckBox("vi:2");
		vi_3 = new CheckBox("vi:3");
		vi_4 = new CheckBox("vi:4");
		vi_5 = new CheckBox("vi:5");
		vi_6 = new CheckBox("vi:6");
		vi_7 = new CheckBox("vi:7");
		vi_8 = new CheckBox("vi:8");
		
		sa_1 = new CheckBox("sa:1");
		sa_2 = new CheckBox("sa:2");
		sa_3 = new CheckBox("sa:3");
		sa_4 = new CheckBox("sa:4");
		sa_5 = new CheckBox("sa:5");
		sa_6 = new CheckBox("sa:6");
		sa_7 = new CheckBox("sa:7");
		sa_8 = new CheckBox("sa:8");
		
		
		
	}
	
	
	
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
		ArrayList<String> horario_buscar = new ArrayList<String>();
		if(lu_1.isSelected()){horario_buscar.add(lu_1.getText());}
		if(lu_2.isSelected()){horario_buscar.add(lu_2.getText());}
		if(lu_3.isSelected()){horario_buscar.add(lu_3.getText());}
		if(lu_4.isSelected()){horario_buscar.add(lu_4.getText());}
		if(lu_5.isSelected()){horario_buscar.add(lu_5.getText());}
		if(lu_6.isSelected()){horario_buscar.add(lu_6.getText());}
		if(lu_7.isSelected()){horario_buscar.add(lu_7.getText());}
		if(lu_8.isSelected()){horario_buscar.add(lu_8.getText());}

		if(ma_1.isSelected()){horario_buscar.add(ma_1.getText());}
		if(ma_2.isSelected()){horario_buscar.add(ma_2.getText());}
		if(ma_3.isSelected()){horario_buscar.add(ma_3.getText());}
		if(ma_4.isSelected()){horario_buscar.add(ma_4.getText());}
		if(ma_5.isSelected()){horario_buscar.add(ma_5.getText());}
		if(ma_6.isSelected()){horario_buscar.add(ma_6.getText());}
		if(ma_7.isSelected()){horario_buscar.add(ma_7.getText());}
		if(ma_8.isSelected()){horario_buscar.add(ma_8.getText());}

		if(mi_1.isSelected()){horario_buscar.add(mi_1.getText());}
		if(mi_2.isSelected()){horario_buscar.add(mi_2.getText());}
		if(mi_3.isSelected()){horario_buscar.add(mi_3.getText());}
		if(mi_4.isSelected()){horario_buscar.add(mi_4.getText());}
		if(mi_5.isSelected()){horario_buscar.add(mi_5.getText());}
		if(mi_6.isSelected()){horario_buscar.add(mi_6.getText());}
		if(mi_7.isSelected()){horario_buscar.add(mi_7.getText());}
		if(mi_8.isSelected()){horario_buscar.add(mi_8.getText());}

		if(ju_1.isSelected()){horario_buscar.add(ju_1.getText());}
		if(ju_2.isSelected()){horario_buscar.add(ju_2.getText());}
		if(ju_3.isSelected()){horario_buscar.add(ju_3.getText());}
		if(ju_4.isSelected()){horario_buscar.add(ju_4.getText());}
		if(ju_5.isSelected()){horario_buscar.add(ju_5.getText());}
		if(ju_6.isSelected()){horario_buscar.add(ju_6.getText());}
		if(ju_7.isSelected()){horario_buscar.add(ju_7.getText());}
		if(ju_8.isSelected()){horario_buscar.add(ju_8.getText());}

		if(vi_1.isSelected()){horario_buscar.add(vi_1.getText());}
		if(vi_2.isSelected()){horario_buscar.add(vi_2.getText());}
		if(vi_3.isSelected()){horario_buscar.add(vi_3.getText());}
		if(vi_4.isSelected()){horario_buscar.add(vi_4.getText());}
		if(vi_5.isSelected()){horario_buscar.add(vi_5.getText());}
		if(vi_6.isSelected()){horario_buscar.add(vi_6.getText());}
		if(vi_7.isSelected()){horario_buscar.add(vi_7.getText());}
		if(vi_8.isSelected()){horario_buscar.add(vi_8.getText());}

		if(sa_1.isSelected()){horario_buscar.add(sa_1.getText());}
		if(sa_2.isSelected()){horario_buscar.add(sa_2.getText());}
		if(sa_3.isSelected()){horario_buscar.add(sa_3.getText());}
		if(sa_4.isSelected()){horario_buscar.add(sa_4.getText());}
		if(sa_5.isSelected()){horario_buscar.add(sa_5.getText());}
		if(sa_6.isSelected()){horario_buscar.add(sa_6.getText());}
		if(sa_7.isSelected()){horario_buscar.add(sa_7.getText());}
		if(sa_8.isSelected()){horario_buscar.add(sa_8.getText());}

		String prof = profesor_seleccion.getText();
		String sigla = profesor_seleccion.getText();
		int carrera = 0;//((Carrera) text_carrera.getValue()).getId_carrera);
		String periodo = ""; //text_periodo.getValue();
		
		
		ArrayList<Curso> cursos = main.U.buscador.filtrar(horario_buscar, prof, carrera, sigla,periodo);
		
		
		controlador.setScreen(main.AlumnoID);
	}
	public void ClickAgregar(ActionEvent event) {
		System.out.println(sa_1);
	}
	
	
	// evento para cambiar de paginas.
	@Override
	public void setScreenParent(ScreensController ScreenPage) {
		controlador = ScreenPage;
	}

	
	
	
	
	
	
	
}
