package fx.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import g4.Alumno;
import g4.AlumnoTabla;
import g4.Carrera;
import g4.Curso;
import g4.CursoTabla;
import g4.Nota;
import g4.Programacion_Academica;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

public class ProfesorOverviewController implements PrincipalController {
	/// objeto para realizar el cambio de paginas
	ScreensController controlador;
	
	@FXML
	private TextField text_field_nota;
	@FXML
	private Label labelNombre,labelNombreUsuario,labelSexo,labelEdad,mensaje_alerta,nombre_profesor,nombre_curso_info,numero_alumnos,alumnos_promedio,alumnos_aprobados,alumnos_reprobados,nombre_curso_tabla,label_nombre_alumno;
	@FXML
	private Pane pane_inicio,pane_historial,pane_evaluar,pane_foros,pane_info_profesor,pane_evaluar_alumno; 
	@FXML
	private Button boton_evaluar_guardar_cambios,boton_inicio,boton_evaluar_cursos,boton_historial_cursos,boton_foro_cursos,boton_buscador_cursos,boton_cerrar_sesion;
	@FXML
	private Button boton_historial_ir,boton_evaluar_ir,boton_evaluar_seleccionar;
	@FXML
	private ChoiceBox<String> choicebox_historial_periodo,choicebox_evaluar_cursos;
	@FXML
	private TableView<CursoTabla> tabla_historial_cursos;
	@FXML
	private TableColumn<CursoTabla,String> columna_historial_sigla,columna_historial_nombre,columna_historial_carrera,columna_historial_horarios;
	@FXML
	private ObservableList<CursoTabla> data_historial = FXCollections.observableArrayList();
	@FXML
	private TableView<AlumnoTabla> tabla_evaluar_alumno;
	@FXML
	private TableColumn<AlumnoTabla,String> columna_evaluar_nombre,columna_evaluar_nota;
	@FXML
	private ObservableList<AlumnoTabla> data_evaluar = FXCollections.observableArrayList();
	
	private Curso curso_seleccionado;
	
	
	// EVENTOS BOTONES DEL MENU LATERAL
	public void ClickInicio(ActionEvent event) {
		nombre_profesor.setText(main.U.profesor_actual.getNombre());
		labelNombre.setText(main.U.profesor_actual.getNombre());
		labelNombreUsuario.setText(main.U.profesor_actual.GetNombreUsuario());
		labelSexo.setText(main.U.profesor_actual.GetSexo().name());
		labelEdad.setText(main.U.profesor_actual.GetEdadString());
		CambiarAPanel(pane_inicio);
	}	
	public void ClickHistorialCursos(ActionEvent event) {
		nombre_profesor.setText(main.U.profesor_actual.getNombre());
		CambiarAPanel(pane_historial);
		columna_historial_sigla.setCellValueFactory(new PropertyValueFactory<CursoTabla,String>("sigla"));
		columna_historial_nombre.setCellValueFactory(new PropertyValueFactory<CursoTabla,String>("nombre"));
		columna_historial_carrera.setCellValueFactory(new PropertyValueFactory<CursoTabla,String>("carrera"));
		columna_historial_horarios.setCellValueFactory(new PropertyValueFactory<CursoTabla,String>("horarios"));
		tabla_historial_cursos.setItems(data_historial);
		
		ArrayList<String> periodos = new ArrayList<String>();
		for (Programacion_Academica j : main.U.historial_de_progrmacion_academica){
			periodos.add(j.periodo);}
		ObservableList<String> uu = FXCollections
				.observableList(periodos);
		choicebox_historial_periodo.setItems(uu);
		choicebox_historial_periodo.setValue(periodos.get(0));

	}	
	public void ClickEvaluarCursos(ActionEvent event) {
		nombre_profesor.setText(main.U.profesor_actual.getNombre());
		columna_evaluar_nota.setCellValueFactory(new PropertyValueFactory<AlumnoTabla,String>("nota"));
		columna_evaluar_nombre.setCellValueFactory(new PropertyValueFactory<AlumnoTabla,String>("nombre"));
		tabla_evaluar_alumno.setItems(data_evaluar);
		
		ArrayList<String> nombres_cursos = new ArrayList<String>();
		ArrayList<Curso> cursos = main.U.buscador.filtrar(null,main.U.profesor_actual.getNombre(), -1, null,main.U.periodo_actual);
		
		for (Curso j : cursos){
			nombres_cursos.add(j.getRamo().getSigla()+"-"+j.getSeccionCurso());}
		ObservableList<String> uu = FXCollections
				.observableList(nombres_cursos);
		choicebox_evaluar_cursos.setItems(uu);
		
		CambiarAPanel(pane_evaluar);
	}	
	public void ClickForoCursos(ActionEvent event) {
		nombre_profesor.setText(main.U.profesor_actual.getNombre());
		ForosController.CambiarNombreMenu(main.U.profesor_actual.getNombre());
		
		ArrayList<String> nombres_cursos = new ArrayList<String>();
		ArrayList<Curso> cursos = main.U.buscador.filtrar(null,main.U.profesor_actual.getNombre(), -1, null,main.U.periodo_actual);		
		for (Curso j : cursos){
			nombres_cursos.add(j.getRamo().getSigla()+"-"+j.getId_curso());}
		ObservableList<String> uu = FXCollections
				.observableList(nombres_cursos);
		ForosController.CargarChoiceBox(uu);
		controlador.setScreen(main.ForosID);
	}	
	public void ClickBuscadorCursos(ActionEvent event) {
		nombre_profesor.setText(main.U.profesor_actual.getNombre());
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
	public void ClickHistorialIr(ActionEvent event) {
		String prof = main.U.profesor_actual.getNombre();
		String periodo = choicebox_historial_periodo.getValue();
		ArrayList<Curso> cursos = main.U.buscador.filtrar(null, prof, -1, null,periodo);
		ArrayList<CursoTabla> ct = new ArrayList<CursoTabla>();
		for (Curso j : cursos){
			ct.add(new CursoTabla(j));
		}
		data_historial = FXCollections.observableArrayList(ct);
		ActualizarTablaHistorial();
	}	
	public void ActualizarTablaHistorial(){
		tabla_historial_cursos.setItems(data_historial);
	}
	
	/// EVENTOS EVALUAR CURSOS
	public void ClickEvaluarIr() {
		String str = choicebox_evaluar_cursos.getValue();
		String sigla = Arrays.asList(str.split("-")).get(0);
		int secc = Integer.parseInt(Arrays.asList(str.split("-")).get(1));
		Curso c = null;
		for (Curso j :main.U.lista_cursos){
			if (j.getRamo().getSigla().toLowerCase().equals(sigla.toLowerCase()) && j.getSeccionCurso()==secc){
				c=j;
				curso_seleccionado=j;
				break;
			}
		}
		ArrayList<AlumnoTabla> alumnos_tabla = new ArrayList<AlumnoTabla>();
		if (c!=null){
			for (Alumno j: c.lista_alumnos){
				alumnos_tabla.add(new AlumnoTabla(j,c.id_curso));
			}
		}
		data_evaluar = FXCollections.observableArrayList(alumnos_tabla);
		ActualizarTablaAlumnos();
		AtualizarInfoCurso(c,alumnos_tabla);
		
		
		
	}
	public void ActualizarTablaAlumnos(){
		tabla_evaluar_alumno.setItems(data_evaluar);
	}
	public void ClickSelccionarAlumno(ActionEvent event) {
		AlumnoTabla at = tabla_evaluar_alumno.getSelectionModel().getSelectedItem();
		label_nombre_alumno.setText(at.getNombre());
		text_field_nota.setText(at.getNota());
	}
	public void AtualizarInfoCurso(Curso c,ArrayList<AlumnoTabla> at ){
		nombre_curso_tabla.setText(c.getRamo().getSigla());
		nombre_curso_info.setText(c.getRamo().getSigla());
		Integer ss = (c.getLista_alumnos().size());
		numero_alumnos.setText(ss.toString());
		Integer cantidad_al=0;
		float suma_notas=0;
		Integer div_notas=0;
		Integer al_aprob=0;
		Integer al_reprob=0;
		for (AlumnoTabla j : at){
			cantidad_al =+ 1;
			if (!j.getNota().equals("--")){
				float nota = Float.parseFloat(j.getNota());
				suma_notas =suma_notas + nota;
				div_notas =div_notas+1;
				if (nota>=3.95){
					al_aprob = al_aprob + 1;
				}
				else{al_reprob =al_reprob + 1;}
			}
			else{al_reprob = al_reprob + 1;}}
		if (div_notas>0){
			Float tt = (float) (suma_notas/div_notas);
			alumnos_promedio.setText(tt.toString());
		}else {alumnos_promedio.setText("--");}
		alumnos_reprobados.setText(al_reprob.toString());
		alumnos_aprobados.setText(al_aprob.toString());
	}
	public void ClickGuardarCambios (ActionEvent event) {
		if (isNumeric(text_field_nota.getText())){
			Float fl = Float.parseFloat(text_field_nota.getText());
			if (fl>=1 && fl<=7){
				for (Alumno j : curso_seleccionado.getLista_alumnos()){
					if (j.getNombre().equals(label_nombre_alumno.getText())){
						for (Nota u : j.getSemestreActual().GetNotas()){
							if (u.GetCurso()==curso_seleccionado.getId_curso()){
								u.SetNota(Float.parseFloat(text_field_nota.getText()));}}}}

				mensaje_alerta.setText("nota actualizada");
				ClickEvaluarIr();
			}else{
				mensaje_alerta.setText("fuera de rango");
			}
		}else {
			mensaje_alerta.setText("valor invalido");
		}
	}
	
	// evento para cambiar de paginas.
	@Override
	public void setScreenParent(ScreensController ScreenPage) {
		controlador = ScreenPage;
	}

	// EXTRAS
	public static boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    double d = Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
	
}
