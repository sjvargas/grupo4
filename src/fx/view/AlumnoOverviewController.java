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
import g4.Malla_curricular;

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
	private Pane pane_cursos_alumno;
	@FXML
	private Label label_nombre_carrera_alumno;
	@FXML
	private Label label_decano_carrera_alumno;
	@FXML
	private Label label_facultad_carrera_alumno;
	@FXML
	private Button boton_ver_carrera_alumno;

	@FXML
	private ChoiceBox choise_carreras_alumno;
	@FXML
	private ChoiceBox choice_malla;
	@FXML
	private ChoiceBox choice_curso;

	// tabla
	@FXML
	ListView<String> listViewCarrerasInscritas;

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

		a.setVisible(true);
	}
	
	public void clickinicio() {
		mostrar_panel(pane_semestres_alumno);
	}	
	
	public void clickbuscador() {
		mostrar_panel(pane_semestres_alumno);
	}	
	
	public void clicksemestreactual() {
		mostrar_panel(pane_semestres_alumno);
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

}
