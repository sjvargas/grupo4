package fx.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import jdk.nashorn.internal.runtime.ListAdapter;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

import g4.Alumno;
import g4.Carrera;
import g4.Curso;
import g4.Malla_curricular;
import g4.Nota;
import g4.Semestre;
import g4.Usuario;

public class AlumnoOverviewController implements PrincipalController {
	/// objeto para realizar el cambio de paginas
	ScreensController controlador;


	/// variables de Usuario

	// panel basico
	@FXML
	private Pane pantalla_alumno;
	@FXML
	private Button boton_carreras_alumno;
	@FXML
	private Button boton_inicio_alumno;
	@FXML
	private Button boton_semestres_alumno;
	@FXML
	private Button boton_cursos_alumno;
	@FXML
	private Button boton_semestre_actual_alumno;
	@FXML
	private Button boton_buscador_alumno;
	@FXML
	private Button boton_avance_malla_alumno;
	@FXML
	private Button cerrar_sesion;

	///
	
	@FXML
	private Pane pane_carreras_alumno;
	@FXML
	private Pane pane_semestres_alumno;
	@FXML
	private Pane pane_semestre_actual_alumno;
	@FXML
	private Pane pane_cursos_alumno;
	@FXML
	private Pane pane_inicio_alumno;
	@FXML
	private Label label_nombre_carrera_alumno;
	@FXML
	private Label label_decano_carrera_alumno;
	@FXML
	private Label label_facultad_carrera_alumno;
	@FXML
	private Button boton_ver_carrera_alumno;
	@FXML
	private Button boton_actualizar_semestre_actual;
	
	//label de inicio alumno
	@FXML
	private Label label_nombre_inicio_alumno;
	@FXML
	private Label label_sexo_inicio_alumno;
	@FXML
	private Label label_edad_inicio_alumno;
	
	@FXML
	private ChoiceBox choise_carreras_alumno;
	@FXML
	private ChoiceBox choice_malla;
	@FXML
	private ChoiceBox choice_curso;

	
	

	// tabla
	@FXML
	ListView<String> listViewCarrerasInscritas;
	
	
	
	
	// semestre ACTUAL textos de cursos y notas
	@FXML
	TextField text_periodo_semestre_actual;
	@FXML
	TextField text_curso1_semestre_actual;
	@FXML
	TextField text_curso2_semestre_actual;
	@FXML
	TextField text_curso3_semestre_actual;
	@FXML
	TextField text_curso4_semestre_actual;
	@FXML
	TextField text_curso5_semestre_actual;
	@FXML
	TextField text_curso6_semestre_actual;
	@FXML
	TextField text_curso7_semestre_actual;
	@FXML
	TextField text_curso8_semestre_actual;
	@FXML
	TextField text_nota1_semestre_actual;
	@FXML
	TextField text_nota2_semestre_actual;
	@FXML
	TextField text_nota3_semestre_actual;
	@FXML
	TextField text_nota4_semestre_actual;
	@FXML
	TextField text_nota5_semestre_actual;
	@FXML
	TextField text_nota6_semestre_actual;
	@FXML
	TextField text_nota7_semestre_actual;
	@FXML
	TextField text_nota8_semestre_actual;
	
	
	// crea instancia de Apicacion inicio-.. No estoy seguro de si se crea acá o
	// en Main

	public void botonPrueba() {
		controlador.setScreen(main.AdminID);
	}

	/// metodo para realizar el cambio de paginas.
	@Override
	public void setScreenParent(ScreensController ScreenPage) {
		controlador = ScreenPage;
	}

	//// eventos paneles de usuario

	public void clicksemestres() {
		mostrar_panel(pane_semestres_alumno);
	}
	
	public void clickcursos() {
		mostrar_panel(pane_cursos_alumno);

		// ObservableList<Curso> ss =
		// FXCollections.observableList(main.U.lista_administradores.get(0).getListaCarrera());
		// choise_carreras_alumno.setItems(ss);
	}

	public void clickcarreras() {
		mostrar_panel(pane_carreras_alumno);

		ObservableList<Carrera> ss = FXCollections
				.observableList(main.U.lista_administradores.get(0).getListaCarrera());
		choise_carreras_alumno.setItems(ss);

		choise_carreras_alumno.setValue(main.U.lista_administradores.get(0).getListaCarrera().get(0));

		this.actualizarTablaConCarrerasInscritas();
		ObservableList<Malla_curricular> mallasDeLaCarrera = FXCollections.observableList(
				main.U.lista_administradores.get(0).getListaCarrera().get(0).getMallas_curriculares());
		// choice_malla.setItems(mallasDeLaCarrera);
		// choice_malla.setValue(mallasDeLaCarrera.get(0));

	}

	public void mostrar_panel(Pane a) {
		if (pane_cursos_alumno.isVisible()) {
			pane_cursos_alumno.setVisible(false);
		}
		if (pane_carreras_alumno.isVisible()) {
			pane_carreras_alumno.setVisible(false);
		}
		if (pane_semestres_alumno.isVisible()) {
			pane_semestres_alumno.setVisible(false);
		}
		if(pane_inicio_alumno.isVisible()){
			pane_inicio_alumno.setVisible(false);
		}
		if(pane_semestre_actual_alumno.isVisible()){
			pane_semestre_actual_alumno.setVisible(false);
		}

		a.setVisible(true);
	}
	
	public void clickinicio() {
		//mostrar_panel(pane_semestres_alumno);
		label_nombre_inicio_alumno.textProperty().setValue(main.U.alumno_actual.nombre);
		label_edad_inicio_alumno.textProperty().set(main.U.alumno_actual.GetEdad());
		label_sexo_inicio_alumno.textProperty().set(main.U.alumno_actual.GetSexo());
		
		mostrar_panel(pane_inicio_alumno);

	}	
	
	public void clickbuscador() {
		mostrar_panel(pane_semestres_alumno);
	}	
	
	public void clicksemestreactual() {
		
		Semestre semestreActual;
		if(main.U.alumno_actual.GetSemestreActual()!= null){
			semestreActual = main.U.alumno_actual.GetSemestreActual();
			List<Integer> idsCursos = semestreActual.GetCursos();
			List<Nota> notas = semestreActual.GetNotas();

		}

		
		
		
		
		
		mostrar_panel(pane_semestre_actual_alumno);
	}	
	
	public void clickavancemalla() {
		mostrar_panel(pane_semestres_alumno);
	}	
	
	public void CerrarSesion(ActionEvent event) {
		main.U.alumno_actual.Cerrar_sesion();
		main.U.alumno_actual = null;
		controlador.setScreen(main.InicioID);
	}

	
	/// eventos paneles de carreras

	public void clickvercarrera() {
		Carrera c = (Carrera) choise_carreras_alumno.getValue();
		label_nombre_carrera_alumno.setText(c.getnombre_carrera());
		label_decano_carrera_alumno.setText(c.getDecano());
		label_facultad_carrera_alumno.setText(c.getFacultad());

		ObservableList<Malla_curricular> mallasDeLaCarrera = FXCollections.observableList(c.getMallas_curriculares());
		// choice_malla.setItems(mallasDeLaCarrera);
		// choice_malla.setValue(mallasDeLaCarrera.get(0));

	}

	public void clickInscribirCarreraYMalla() {
		System.out.println("metal");

		main.U.alumno_actual.Inscribir_carrera(((Carrera) choise_carreras_alumno.getValue()).getId_carrera());

		// ((Alumno)Usuario_conectado).Inscribir_malla_curricular(((Malla_curricular)
		// choice_malla.getValue()).getId_malla());

		//
		this.actualizarTablaConCarrerasInscritas();

	}

	private void actualizarTablaConCarrerasInscritas() {
		// listViewCarrerasInscritas = new ListView<String>();
		List<String> nombresCarrerasInscritas = new ArrayList<String>();

		for (int i = 0; i < main.U.alumno_actual.GetCarreras().size(); i++) {
			nombresCarrerasInscritas.add(main.U.lista_administradores.get(0)
					.GetCarrera(main.U.alumno_actual.GetCarreras().get(i)).getnombre_carrera());

		}

		ObservableList<String> items = FXCollections.observableArrayList(nombresCarrerasInscritas);
		listViewCarrerasInscritas.setItems(items);

		//
	}
	
	
	
	// cambia el semestre actual del alumno, en base a la informacion que ingrese
	public void actualizarSemestreActual(){
		
		Semestre semestreActual;
		
		if(main.U.alumno_actual.GetSemestreActual()!= null){
			semestreActual = main.U.alumno_actual.GetSemestreActual();
		}
		
		else{
			
			semestreActual = new Semestre(""+text_periodo_semestre_actual.textProperty());
			
			List<Curso> listaCursos = new ArrayList<Curso>();
			List<Integer> listaNotas = new ArrayList<Integer>();

			
			
			
			if(text_curso1_semestre_actual.getText().isEmpty() == false){
				listaCursos.add(main.U.getCursoConID(Integer.parseInt(""+text_curso1_semestre_actual.getText())));
				if(text_nota1_semestre_actual.getText().isEmpty() == false){
					listaNotas.add(Integer.parseInt(""+text_nota1_semestre_actual.getText()));
				}
				else{
					// valor default si no hay nada ingresado en nota 
					listaNotas.add(1);

				}
			}
			if(text_curso2_semestre_actual.getText().isEmpty() == false){
				listaCursos.add(main.U.getCursoConID(Integer.parseInt(""+text_curso2_semestre_actual.getText())));
				if(text_nota2_semestre_actual.getText().isEmpty() == false){
					listaNotas.add(Integer.parseInt(""+text_nota2_semestre_actual.getText()));
				}
				else{
					// valor default si no hay nada ingresado en nota 
					listaNotas.add(1);

				}
			}
			if(text_curso3_semestre_actual.getText().isEmpty() == false){
				listaCursos.add(main.U.getCursoConID(Integer.parseInt(""+text_curso3_semestre_actual.getText())));
				if(text_nota3_semestre_actual.getText().isEmpty() == false){
					listaNotas.add(Integer.parseInt(""+text_nota3_semestre_actual.getText()));
				}
				else{
					// valor default si no hay nada ingresado en nota 
					listaNotas.add(1);

				}
			}
			if(text_curso4_semestre_actual.getText().isEmpty() == false){
				listaCursos.add(main.U.getCursoConID(Integer.parseInt(""+text_curso4_semestre_actual.getText())));
				if(text_nota4_semestre_actual.getText().isEmpty() == false){
					listaNotas.add(Integer.parseInt(""+text_nota4_semestre_actual.getText()));
				}
				else{
					// valor default si no hay nada ingresado en nota 
					listaNotas.add(1);

				}
			}
			if(text_curso5_semestre_actual.getText().isEmpty() == false){
				listaCursos.add(main.U.getCursoConID(Integer.parseInt(""+text_curso5_semestre_actual.getText())));
				if(text_nota5_semestre_actual.getText().isEmpty() == false){
					listaNotas.add(Integer.parseInt(""+text_nota5_semestre_actual.getText()));
				}
				else{
					// valor default si no hay nada ingresado en nota 
					listaNotas.add(1);

				}
			}
			if(text_curso6_semestre_actual.getText().isEmpty() == false){
				listaCursos.add(main.U.getCursoConID(Integer.parseInt(""+text_curso6_semestre_actual.getText())));
				if(text_nota6_semestre_actual.getText().isEmpty() == false){
					listaNotas.add(Integer.parseInt(""+text_nota6_semestre_actual.getText()));
				}
				else{
					// valor default si no hay nada ingresado en nota 
					listaNotas.add(1);

				}
			}
			if(text_curso7_semestre_actual.getText().isEmpty() == false){
				listaCursos.add(main.U.getCursoConID(Integer.parseInt(""+text_curso7_semestre_actual.getText())));
				if(text_nota7_semestre_actual.getText().isEmpty() == false){
					listaNotas.add(Integer.parseInt(""+text_nota7_semestre_actual.getText()));
				}
				else{
					// valor default si no hay nada ingresado en nota 
					listaNotas.add(1);

				}
			}
			if(text_curso8_semestre_actual.getText().isEmpty() == false){
				listaCursos.add(main.U.getCursoConID(Integer.parseInt(""+text_curso8_semestre_actual.getText())));
				if(text_nota8_semestre_actual.getText().isEmpty() == false){
					listaNotas.add(Integer.parseInt(""+text_nota8_semestre_actual.getText()));
				}
				else{
					// valor default si no hay nada ingresado en nota 
					listaNotas.add(1);

				}
			}
		}
		
		
	}

}
