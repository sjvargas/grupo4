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
	@FXML
	private Button ver_mallas;

	///
	
	@FXML
	private Pane pane_carreras_alumno;
	@FXML
	private Pane pane_mallas_alumno;
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
	@FXML
	private Button boton_eliminar_carrera;
	
	
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
	@FXML
	ListView<String> listViewCarrerasInscritas1;
	
	
	
	// INICIO ELEMENTOS semestre ACTUAL textos de cursos y notas
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
	////////
	@FXML
	Label label_curso1_semestre_actual;
	@FXML
	Label label_curso2_semestre_actual;
	@FXML
	Label label_curso3_semestre_actual;
	@FXML
	Label label_curso4_semestre_actual;
	@FXML
	Label label_curso5_semestre_actual;
	@FXML
	Label label_curso6_semestre_actual;
	@FXML
	Label label_curso7_semestre_actual;
	@FXML
	Label label_curso8_semestre_actual;
	// FIN DE ELEMENTOS DE SEMESTRE ACTUAL
	
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
		if(pane_mallas_alumno.isVisible()){
			pane_mallas_alumno.setVisible(false);
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
			
			//borrar: es para verificar que Se vuelve a escribir los cursos con sus notas
			System.out.println("EL SEMESTRE DE ALUMNO NO ES NULL!");
			
			text_curso1_semestre_actual.setText("");
			text_curso2_semestre_actual.setText("");
			text_curso3_semestre_actual.setText("");
			text_curso4_semestre_actual.setText("");
			text_curso5_semestre_actual.setText("");
			text_curso6_semestre_actual.setText("");
			text_curso7_semestre_actual.setText("");
			text_curso8_semestre_actual.setText("");
			
			text_nota1_semestre_actual.setText("");
			text_nota2_semestre_actual.setText("");
			text_nota3_semestre_actual.setText("");
			text_nota4_semestre_actual.setText("");
			text_nota5_semestre_actual.setText("");
			text_nota6_semestre_actual.setText("");
			text_nota7_semestre_actual.setText("");
			text_nota8_semestre_actual.setText("");
		

			//borrar
			
			int cantidadCursos = idsCursos.size();
				
			// los IF son para ir rellenando las casillas de idCursos y notas solo si hay mas cursos en los arreglos de curso
			System.out.println("cantidad de cursos: "+cantidadCursos);
			if(cantidadCursos>=1){
				
				text_curso1_semestre_actual.setText(""+idsCursos.get(0));
				text_nota1_semestre_actual.setText(""+notas.get(0).GetNota());
				label_curso1_semestre_actual.setText(""+main.U.getCursoConID(idsCursos.get(0)).getRamo().getSigla());
				if(cantidadCursos>=2){
					text_curso2_semestre_actual.setText(""+idsCursos.get(1));
					text_nota2_semestre_actual.setText(""+notas.get(1).GetNota());	
					label_curso2_semestre_actual.setText(""+main.U.getCursoConID(idsCursos.get(1)).getRamo().getSigla());

					
					if(cantidadCursos>=3){
						text_curso3_semestre_actual.setText(""+idsCursos.get(2));
						text_nota3_semestre_actual.setText(""+notas.get(2).GetNota());	
						label_curso3_semestre_actual.setText(""+main.U.getCursoConID(idsCursos.get(2)).getRamo().getSigla());

						
						if(cantidadCursos>=4){
							text_curso4_semestre_actual.setText(""+idsCursos.get(3));
							text_nota4_semestre_actual.setText(""+notas.get(3).GetNota());
							label_curso4_semestre_actual.setText(""+main.U.getCursoConID(idsCursos.get(3)).getRamo().getSigla());

							
							if(cantidadCursos>=5){
								text_curso5_semestre_actual.setText(""+idsCursos.get(4));
								text_nota5_semestre_actual.setText(""+notas.get(4).GetNota());
								label_curso5_semestre_actual.setText(""+main.U.getCursoConID(idsCursos.get(4)).getRamo().getSigla());

								if(cantidadCursos>=6){
									text_curso6_semestre_actual.setText(""+idsCursos.get(5));
									text_nota6_semestre_actual.setText(""+notas.get(5).GetNota());
									label_curso6_semestre_actual.setText(""+main.U.getCursoConID(idsCursos.get(5)).getRamo().getSigla());

									
									if(cantidadCursos>=7){
										text_curso7_semestre_actual.setText(""+idsCursos.get(6));
										text_nota7_semestre_actual.setText(""+notas.get(6).GetNota());
										label_curso7_semestre_actual.setText(""+main.U.getCursoConID(idsCursos.get(6)).getRamo().getSigla());

										if(cantidadCursos>=8){
											text_curso8_semestre_actual.setText(""+idsCursos.get(7));
											text_nota8_semestre_actual.setText(""+notas.get(7).GetNota());
											label_curso8_semestre_actual.setText(""+main.U.getCursoConID(idsCursos.get(7)).getRamo().getSigla());

										}
									}
									
								}
							}
							
						}
					}
				}
				
			}
			
			

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
	public void clickMallas(){
		mostrar_panel(pane_mallas_alumno);
	}

	public void clickInscribirCarreraYMalla() {
		System.out.println("metal");

		main.U.alumno_actual.Inscribir_carrera(((Carrera) choise_carreras_alumno.getValue()));

		// ((Alumno)Usuario_conectado).Inscribir_malla_curricular(((Malla_curricular)
		// choice_malla.getValue()).getId_malla());

		//
		this.actualizarTablaConCarrerasInscritas();

	}

	private void actualizarTablaConCarrerasInscritas() {
		// listViewCarrerasInscritas = new ListView<String>();
		List<String> nombresCarrerasInscritas = new ArrayList<String>();

		for (int i = 0; i < main.U.alumno_actual.GetCarreras().size(); i++) {
			nombresCarrerasInscritas.add((main.U.alumno_actual.GetCarreras()).get(i).getnombre_carrera());

		}

		ObservableList<String> items = FXCollections.observableArrayList(nombresCarrerasInscritas);
		listViewCarrerasInscritas.setItems(items);
		listViewCarrerasInscritas1.setItems(items);

		//
	}
	
	
	
	// cambia el semestre actual del alumno, en base a la informacion que ingrese
	public void actualizarSemestreActual(){
		
		Semestre semestreActual;
		/*
		 * DA LO MISMO SI HAY UN SEMESTRE YA CREADO, SE SOBREESCRIBE CON LOS NUEVOS DATOS YA CARGADOS
		if(main.U.alumno_actual.GetSemestreActual()!= null){
			semestreActual = main.U.alumno_actual.GetSemestreActual();
		}
		*/
		//else{
			
			
			semestreActual = new Semestre(""+text_periodo_semestre_actual.textProperty());
			
			List<Curso> listaCursos = new ArrayList<Curso>();
			List<Float> listaNotas = new ArrayList<Float>();

			
			// Se revisan las casillas para los cursos, si no estan vacias, se agregan a la lista de cursos
			
			if(text_curso1_semestre_actual.getText().isEmpty() == false){
				listaCursos.add(main.U.getCursoConID(Integer.parseInt(""+text_curso1_semestre_actual.getText())));
				if(text_nota1_semestre_actual.getText().isEmpty() == false){
					listaNotas.add(Float.parseFloat(""+text_nota1_semestre_actual.getText()));
				}
				else{
					// valor default si no hay nada ingresado en nota 
					listaNotas.add((float) 1);

				}
			}
			if(text_curso2_semestre_actual.getText().isEmpty() == false){
				listaCursos.add(main.U.getCursoConID(Integer.parseInt(""+text_curso2_semestre_actual.getText())));
				if(text_nota2_semestre_actual.getText().isEmpty() == false){
					listaNotas.add(Float.parseFloat(""+text_nota2_semestre_actual.getText()));
				}
				else{
					// valor default si no hay nada ingresado en nota 
					listaNotas.add((float)1);

				}
			}
			if(text_curso3_semestre_actual.getText().isEmpty() == false){
				listaCursos.add(main.U.getCursoConID(Integer.parseInt(""+text_curso3_semestre_actual.getText())));
				if(text_nota3_semestre_actual.getText().isEmpty() == false){
					listaNotas.add(Float.parseFloat(""+text_nota3_semestre_actual.getText()));
				}
				else{
					// valor default si no hay nada ingresado en nota 
					listaNotas.add((float)1);

				}
			}
			if(text_curso4_semestre_actual.getText().isEmpty() == false){
				listaCursos.add(main.U.getCursoConID(Integer.parseInt(""+text_curso4_semestre_actual.getText())));
				if(text_nota4_semestre_actual.getText().isEmpty() == false){
					listaNotas.add(Float.parseFloat(""+text_nota4_semestre_actual.getText()));
				}
				else{
					// valor default si no hay nada ingresado en nota 
					listaNotas.add((float)1);

				}
			}
			if(text_curso5_semestre_actual.getText().isEmpty() == false){
				listaCursos.add(main.U.getCursoConID(Integer.parseInt(""+text_curso5_semestre_actual.getText())));
				if(text_nota5_semestre_actual.getText().isEmpty() == false){
					listaNotas.add(Float.parseFloat(""+text_nota5_semestre_actual.getText()));
				}
				else{
					// valor default si no hay nada ingresado en nota 
					listaNotas.add((float)1);

				}
			}
			if(text_curso6_semestre_actual.getText().isEmpty() == false){
				listaCursos.add(main.U.getCursoConID(Integer.parseInt(""+text_curso6_semestre_actual.getText())));
				if(text_nota6_semestre_actual.getText().isEmpty() == false){
					listaNotas.add(Float.parseFloat(""+text_nota6_semestre_actual.getText()));
				}
				else{
					// valor default si no hay nada ingresado en nota 
					listaNotas.add((float)1);

				}
			}
			if(text_curso7_semestre_actual.getText().isEmpty() == false){
				listaCursos.add(main.U.getCursoConID(Integer.parseInt(""+text_curso7_semestre_actual.getText())));
				if(text_nota7_semestre_actual.getText().isEmpty() == false){
					listaNotas.add(Float.parseFloat(""+text_nota7_semestre_actual.getText()));
				}
				else{
					// valor default si no hay nada ingresado en nota 
					listaNotas.add((float)1);

				}
			}
			if(text_curso8_semestre_actual.getText().isEmpty() == false){
				listaCursos.add(main.U.getCursoConID(Integer.parseInt(""+text_curso8_semestre_actual.getText())));
				if(text_nota8_semestre_actual.getText().isEmpty() == false){
					listaNotas.add(Float.parseFloat(""+text_nota8_semestre_actual.getText()));
				}
				else{
					// valor default si no hay nada ingresado en nota 
					listaNotas.add((float)1);

				}
			}
			
			
			// se actualiza el semesrtre del alumno
			main.U.alumno_actual.setSemestreActual(semestreActual);
			// se rellena el semestre en base a los cursos ingresados
			for(int i=0;i<listaCursos.size();i++){
				main.U.alumno_actual.GetSemestreActual().Agregar_Curso(listaCursos.get(i).getId_curso());
				main.U.alumno_actual.GetSemestreActual().Poner_Nota(listaCursos.get(i).getId_curso(), listaNotas.get(i));
			}
			
			// falta ver donde mas se agrega el semestre (hasta el momento solo esta en el alumno
			
			
		//}
		
		
	}
	
	public void eliminarCarrera(){
		////System.out.println("Hay que eliminar carrera: "+listViewCarrerasInscritas.getSelectionModel().getSelectedItem());
		
		String carreraAEliminar = listViewCarrerasInscritas.getSelectionModel().getSelectedItem();
		if(carreraAEliminar!=null){
			main.U.alumno_actual.eliminar_carrera(carreraAEliminar);
			
		}
		
		this.actualizarTablaConCarrerasInscritas();
	}

}
