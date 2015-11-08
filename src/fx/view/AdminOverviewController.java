package fx.view;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
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
import java.util.Arrays;
import java.util.List;

import g4.Administrador_academico;
import g4.Alumno;
import g4.Carrera;
import g4.Curso;
import g4.CursoTabla;
import g4.Profesor;
import g4.Programacion_Academica;
import g4.Ramo;
import g4.Sexo;

public class AdminOverviewController implements PrincipalController {
	
	/// para realizar el cambio de paginas
	ScreensController controlador;
	
	
	// Constructor que recibe el administrador
	public AdminOverviewController(){
	}
	
	// Botones del menu de inicio
	@FXML
	private Button buttonAdminInicio;
	@FXML
	private Button buttonAdminProfesor;
	@FXML
	private Button buttonAdminAlumnos;
	@FXML
	private Button buttonAdminRamos;
	@FXML
	private Button buttonAdminCarreras;
	@FXML
	private Button buttonAdminProgramacionA;
	@FXML
	private Button buttonAdminModificarD;
	@FXML
	private Button buttonAdminCerrarSesion;
	
	// Paneles del Administrador:
	@FXML
	private Pane paneAdminBasico;
	@FXML
	private Pane paneAdminInicio;	
	@FXML
	private Pane paneAdminProfesores;	
	@FXML
	private Pane paneAdminAlumnos;	
	@FXML
	private Pane paneAdminRamos;	
	@FXML
	private Pane paneAdminCarreras;	
	@FXML
	private Pane paneAdminProgramacionAcademica;	
	@FXML
	private Pane paneAdminModificarDatos;
	@FXML
	private Pane paneAdminCursos;

	// Label Panel Admin Estado
	@FXML
    private Label LabelPanelAdminEstado;
	
	// Metodo para cambiar el panel
	protected void CambiarAPanel(Pane paneDeseado){
		paneAdminCursos.setVisible(false);
		paneAdminInicio.setVisible(false);
		paneAdminProfesores.setVisible(false);
		paneAdminAlumnos.setVisible(false);
		paneAdminRamos.setVisible(false);
		paneAdminCarreras.setVisible(false);
		paneAdminProgramacionAcademica.setVisible(false);
		paneAdminModificarDatos.setVisible(false);
		paneDeseado.setVisible(true);
	}
	
	// Eventos de apretar el boton en el menu
	public void ApretarBotonInicio(ActionEvent event){
		CambiarAPanel(paneAdminInicio);
		LabelPanelAdminEstado.setText("Inicio");
		labelNombre.setText(main.U.administrador_actual.getNombre());
		labelNombreUsuario.setText(main.U.administrador_actual.GetNombreUsuario());
		labelSexo.setText(main.U.administrador_actual.GetSexo().name());
		labelEdad.setText(main.U.administrador_actual.GetEdadString());
	}
	public void ApretarBotonProfesores(ActionEvent event){
		CambiarAPanel(paneAdminProfesores);
		LabelPanelAdminEstado.setText("Profesores");
		ActualizarVistasTablaProfesor();
	}
	public void ApretarBotonAlumnos(ActionEvent event){
		CambiarAPanel(paneAdminAlumnos);
		LabelPanelAdminEstado.setText("Alumnos");
		ActualizarVistasTablaAlumnos();
	}
	public void ApretarBotonRamos(ActionEvent event){
		CambiarAPanel(paneAdminRamos);
		LabelPanelAdminEstado.setText("Ramos");
		ActualizarValoresChoiseBoxProf();
		ActualizarVistasTablaRamos();
	}
	public void ApretarBotonCarreras(ActionEvent event){
		CambiarAPanel(paneAdminCarreras);
		LabelPanelAdminEstado.setText("Carreras");
		ActualizarVistasTablaCarreras();
	}
	public void ApretarBotonProgramacion(ActionEvent event){
		CambiarAPanel(paneAdminProgramacionAcademica);
		LabelPanelAdminEstado.setText("Programacion Academica");
	}
	public void ApretarBotonModificarDatos(ActionEvent event){
		CambiarAPanel(paneAdminModificarDatos);
		LabelPanelAdminEstado.setText("Modificar Datos");
	}
	public void ApretarBotonCursos(ActionEvent event){
		CambiarAPanel(paneAdminCursos);
		LabelPanelAdminEstado.setText("Cursos");
		ActualizarChoiceBoxAgregarCurso();
		ActualizarVistasTablaCursos();
	}
	public void ApretarBotonCerrarSesion(ActionEvent event){
		main.U.administrador_actual.Cerrar_sesion();
		main.U.administrador_actual = null;
		controlador.setScreen(main.InicioID);
		
		Serializador.serializar(main.U);
	}
	
	// MODULO INICIO:
	@FXML
    private Label labelNombre;
	@FXML
    private Label labelNombreUsuario;
	@FXML
    private Label labelSexo;
	@FXML
    private Label labelEdad;
	
	// MODULO PROFESORES:
	@FXML
    private TextField campoANombreProfesor;
	@FXML
    private TextField campoAApPatProfesor;
	@FXML
    private TextField campoAApMatProfesor;
	@FXML
    private TextField campoANombreUsuarioProfesor;
	@FXML
    private TextField campoAContrasenaProfesor;
	@FXML
    private TextField campoASexoProfesor;
	@FXML
    private TextField campoAEdadProfesor;
	@FXML
    private TextField campoASueldoProfesor;
	@FXML
    private TextField campoAFacultadProfesor;
	@FXML
    private TextField campoEliminarProfID;
	@FXML
    private Label labelAvisoProfesor;
	@FXML
	private TableView<Profesor> tabla2AdminListaProfesores;
	@FXML
	private TableColumn<Profesor,String> tCINombreProfesor, tCIApPatProfesor,tCIApMatProfesor ,tCIFacultadProfesor ;
	@FXML
	private TableColumn<Profesor,Integer> tCIdProfesor,tCISueldoProfesor;
	@FXML
	private ObservableList<Profesor> datosProfesores = FXCollections.observableArrayList();
	private boolean seCreoTablaProfesores = false;
	// Tabla Lista Profesores:
	
	// Agregar Nuevo Profesor:
	public void ApretarAgregarProfesor(ActionEvent event){
		String nombreProfesor = campoANombreProfesor.getText();
		String apellidoPatProfesor = campoAApPatProfesor.getText();
		String apellidoMatProfesor = campoAApMatProfesor.getText();
		String nombreUsuarioProfesor = campoANombreUsuarioProfesor.getText();
		String contrasenaProfesor = campoAContrasenaProfesor.getText();
		String sexoProfesor = campoASexoProfesor.getText();
		String edadProfesor = campoAEdadProfesor.getText();
		int edadPreforesorInt = Integer.parseInt(edadProfesor);
		String sueldoProfesor = campoASueldoProfesor.getText();
		int sueldoProfesor2 = Integer.parseInt(sueldoProfesor);
		String facultadProfesor = campoAFacultadProfesor.getText();
		if(nombreProfesor != "" && apellidoPatProfesor!= "" && apellidoMatProfesor!= "" &&
				nombreUsuarioProfesor != "" && contrasenaProfesor!= "" && sexoProfesor!= "" &&
						edadProfesor != "" && sueldoProfesor!= "" && facultadProfesor!= "")
		{
			main.U.administrador_actual.agregar_profesor(nombreProfesor, apellidoPatProfesor, apellidoMatProfesor, nombreUsuarioProfesor, contrasenaProfesor, Sexo.Masculino, edadPreforesorInt , sueldoProfesor2, facultadProfesor);
			labelAvisoProfesor.setText("Agregado");
		}
		else{
			labelAvisoProfesor.setText("Completar");
		}
	}

	public void ActualizarVistasTablaProfesor(){
		if(!seCreoTablaProfesores){
			tCIdProfesor.setCellValueFactory(new PropertyValueFactory<Profesor,Integer>("id_profesor"));
			tCINombreProfesor.setCellValueFactory(new PropertyValueFactory<Profesor,String>("nombre"));
			tCIApPatProfesor.setCellValueFactory(new PropertyValueFactory<Profesor,String>("apellidoPaterno"));
			tCIApMatProfesor.setCellValueFactory(new PropertyValueFactory<Profesor,String>("apellidoMaterno"));
			tCIFacultadProfesor.setCellValueFactory(new PropertyValueFactory<Profesor,String>("facultad"));
			tCISueldoProfesor.setCellValueFactory(new PropertyValueFactory<Profesor,Integer>("sueldo"));
			tabla2AdminListaProfesores.setItems(datosProfesores);
		}
		List<Profesor> profesores = main.U.lista_profesores;
		datosProfesores = FXCollections.observableArrayList(profesores);
		tabla2AdminListaProfesores.setItems(datosProfesores);
	}
	
	// Eliminar Profesor: Rellenar!!!!
	public void ApretarEliminarProfesor(ActionEvent event){
		
	}
	
	// MODULO ALUMNOS
	@FXML
    private TextField textFieldIdAlumno;
	@FXML
    private Label labelEstadoRestringirAlumno;
	@FXML
	private TableView<Alumno> tViewnAlumnos;
	@FXML
	private TableColumn<Alumno,String> tCNombreAlumnos, tCApPatAlumnos,tCApMatAlumnos ,tCAccesoAlumnos ;
	@FXML
	private TableColumn<Alumno,Integer> tCIdAlumnos,tCCredAprobAlumnos, tCCredReprobAlumnos;
	@FXML
	private ObservableList<Alumno> datosAlumnos = FXCollections.observableArrayList();
	private boolean seCreoTablaAlumnos = false;
	
	public void ApretarRestringirAlumno(ActionEvent event){
		String idAlumno = textFieldIdAlumno.getText();
		if(idAlumno != ""){
			main.U.RestringirAccesoAlumno(Integer.parseInt(idAlumno));
			//main.U.administrador_actual.restringir_acceso_alumno(idAlumno);
		}
		else{
			labelEstadoRestringirAlumno.setText("Campo Vacio");
		}
		ActualizarVistasTablaAlumnos();
	}
	public void ActualizarVistasTablaAlumnos(){
		if(!seCreoTablaAlumnos){
			tCIdAlumnos.setCellValueFactory(new PropertyValueFactory<Alumno,Integer>("idAlumno"));
			tCNombreAlumnos.setCellValueFactory(new PropertyValueFactory<Alumno,String>("nombre"));
			tCApPatAlumnos.setCellValueFactory(new PropertyValueFactory<Alumno,String>("apellidoPaterno"));
			tCApMatAlumnos.setCellValueFactory(new PropertyValueFactory<Alumno,String>("apellidoMaterno"));
			tCCredAprobAlumnos.setCellValueFactory(new PropertyValueFactory<Alumno,Integer>("creditosAprobados"));
			tCCredReprobAlumnos.setCellValueFactory(new PropertyValueFactory<Alumno,Integer>("creditosReprobados"));
			tCAccesoAlumnos.setCellValueFactory(new PropertyValueFactory<Alumno,String>("acceso"));
			tViewnAlumnos.setItems(datosAlumnos);
		}
		
		List<Alumno> alumnos = main.U.lista_alumnos;
		datosAlumnos = FXCollections.observableArrayList(alumnos);
		tViewnAlumnos.setItems(datosAlumnos);
	}
	
	
	// MODULO RAMOS
	@FXML
	private TextField textFieldNombreRamo;
	@FXML
    private TextField textFieldSiglaRamo;
	@FXML
    private TextField textFieldCarreraRamo;
	@FXML
    private TextField textFieldCreditosRamo;
	@FXML
    private TextField textFieldSemestreImpartidoRamo;
	@FXML
    private TextField textFieldContenidoRamo;
	@FXML
    private TextField textFieldObjetivosRamo;
	@FXML
    private Label labelAgregarRamo;
	@FXML
	private ChoiceBox cBAgPrerreqRamo;
	@FXML
	private ChoiceBox cBAgPrerreqPrerrequisito;
	@FXML
	private TableView<Ramo> tViewRamos;
	@FXML
	private TableColumn<Ramo,String> tCSiglaRamos, tCNombreRamos,tCCarreraRamos ,tCSemestreRamos ;
	@FXML
	private TableColumn<Ramo,Integer> tCCreditosRamos;
	@FXML
	private ObservableList<Ramo> datosRamos = FXCollections.observableArrayList();
	private boolean seCreoTablaRamos = false;
	
	public void AgregarRamo(){
		String nombreRamo = textFieldNombreRamo.getText();
		String siglaRamo = textFieldSiglaRamo.getText();
		String carreraRamo = textFieldCarreraRamo.getText();
		String creditosRamo = textFieldCreditosRamo.getText();
		String semestreImpartidoRamo = textFieldSemestreImpartidoRamo.getText();
		String contenidoRamo = textFieldContenidoRamo.getText();
		String objetivosRamo = textFieldObjetivosRamo.getText();
		int creditosRamo2 = Integer.parseInt(creditosRamo);
		Carrera c = main.U.administrador_actual.GetCarrera(carreraRamo);
		if(nombreRamo != "" && siglaRamo != "" && carreraRamo!= "" && creditosRamo!= "" &&
				semestreImpartidoRamo!= "" && contenidoRamo!= "" && objetivosRamo!= "" ){
			main.U.administrador_actual.agregar_ramo(nombreRamo ,siglaRamo, c, creditosRamo2, semestreImpartidoRamo, contenidoRamo, objetivosRamo);
			labelAgregarRamo.setText("Ramo Agregado");
			ActualizarValoresChoiseBoxProf();
			ActualizarVistasTablaRamos();
		}
		else{
			labelAgregarRamo.setText("Error al agregar Ramo");
		}
	}
	public void ActualizarValoresChoiseBoxProf(){
		ObservableList<String> listaCargaRamos = FXCollections.observableList(main.getU().GetSiglasRamos());
		cBAgPrerreqRamo.setItems(listaCargaRamos);
		cBAgPrerreqRamo.setValue(listaCargaRamos);
		cBAgPrerreqPrerrequisito.setItems(listaCargaRamos);
		cBAgPrerreqPrerrequisito.setValue(listaCargaRamos);
	}	
	
	public void ApretarAgregarPrerrequisito(ActionEvent event){
		String siglaRamo = cBAgPrerreqRamo.getValue().toString();
		String siglaPrerrequisito = cBAgPrerreqPrerrequisito.getValue().toString();
		main.U.administrador_actual.AgregarPrerrequisito(siglaRamo, siglaPrerrequisito);
		System.out.println("para"+ siglaRamo+"el prerrequisito es" + main.getU().GetRamo(siglaRamo).GetPrerrequisitos().get(0));
	}
	
	public void ActualizarVistasTablaRamos(){
		if(!seCreoTablaRamos){
			tCSiglaRamos.setCellValueFactory(new PropertyValueFactory<Ramo,String>("sigla"));
			tCNombreRamos.setCellValueFactory(new PropertyValueFactory<Ramo,String>("nombreRamo"));
			tCCarreraRamos.setCellValueFactory(new PropertyValueFactory<Ramo,String>("nombreCarrera"));
			tCSemestreRamos.setCellValueFactory(new PropertyValueFactory<Ramo,String>("semestreImpartidoString"));
			tCCreditosRamos.setCellValueFactory(new PropertyValueFactory<Ramo,Integer>("creditos"));
			tViewRamos.setItems(datosRamos);
		}
		
		List<Ramo> ramos = main.U.lista_ramos;
		datosRamos = FXCollections.observableArrayList(ramos);
		tViewRamos.setItems(datosRamos);
	}

	
	// MODULO CARRERAS
	@FXML
    private TextField textFieldNombreCarrera;
	@FXML
    private TextField textFieldFacultadCarrera;
	@FXML
    private TextField textFieldDecanoCarrera;
	@FXML
    private Label labelEstadoAgregarCarrera;	
	@FXML
	private TableView<Carrera> tViewCarrera;
	@FXML
	private TableColumn<Carrera,String> tCNombreCarrera, tCFacultadCarrera,tCDecanoCarrera;
	@FXML
	private ObservableList<Carrera> datosCarreras = FXCollections.observableArrayList();
	private boolean seCreoTablaCarreras = false;
	
	
	
	public void AgregarCarrera(){
		String nombreCarrera = textFieldNombreCarrera.getText();
		String facultadCarrera = textFieldFacultadCarrera.getText();
		String decanoCarrera = textFieldDecanoCarrera.getText();
		if(nombreCarrera!="" && facultadCarrera!="" && decanoCarrera!=""){
			main.U.administrador_actual.agregar_carrera(decanoCarrera, facultadCarrera, nombreCarrera);
			labelEstadoAgregarCarrera.setText("Carrera Agregada");
		}
		else{
			labelEstadoAgregarCarrera.setText("Campo Vacio");
		}
	}
	public void ActualizarVistasTablaCarreras(){
		if(!seCreoTablaRamos){
			tCNombreCarrera.setCellValueFactory(new PropertyValueFactory<Carrera,String>("nombreCarrera"));
			tCFacultadCarrera.setCellValueFactory(new PropertyValueFactory<Carrera,String>("facultad"));
			tCDecanoCarrera.setCellValueFactory(new PropertyValueFactory<Carrera,String>("decano"));
			tViewCarrera.setItems(datosCarreras);
		}
		
		List<Carrera> carreras = main.U.lista_carreras;
		datosCarreras = FXCollections.observableArrayList(carreras);
		tViewCarrera.setItems(datosCarreras);
	}
	
	// MODULO CURSOS
	
	@FXML
	private TextField tFCursoSeccion, tFCursoHorario, tFCursoCreditos, tFCursoSala;
	@FXML
	private ChoiceBox cBCursoSiglaRamo, cBCursoPeriodo, cBCursoProfesor;
	@FXML
	private TableView<Curso> tViewCursos;
	@FXML
	private TableColumn<Curso,String> tCNombreCursos, tCProfesorPrincipal, tCPeriodoCurso;
	@FXML
	private TableColumn<Curso,Integer> tCIdCursos, tCSeccionCursos, tCCreditosCursos;
	@FXML
	private ObservableList<Curso> datosCursos = FXCollections.observableArrayList();
	private boolean seCreoTablaCursos = false;
	
	public void ApretarAgregarCurso(ActionEvent event){
		main.U.GetProgramacionAcademicaPeriodo(cBCursoPeriodo.getValue().toString()).crear_curso(
				cBCursoPeriodo.getValue().toString(), GenerarListaSalas(tFCursoSala.getText()), GenerarHorario(tFCursoHorario.getText()),
				Integer.parseInt(tFCursoCreditos.getText()), Integer.parseInt(tFCursoSeccion.getText()), 
				(Profesor) cBCursoProfesor.getValue(), main.U.GetRamo((String)cBCursoSiglaRamo.getValue()));	
		ActualizarVistasTablaCursos();
	}
	public void ActualizarChoiceBoxAgregarCurso(){
		// listado de los ramos
		ObservableList<String> listaCargaRamos = FXCollections.observableList(main.getU().GetSiglasRamos());
		cBCursoSiglaRamo.setItems(listaCargaRamos);
		cBCursoSiglaRamo.setValue(listaCargaRamos);
		
		// listado de periodos
		List<String> periodos = new ArrayList<String>();
		for (Programacion_Academica j : main.U.historial_de_progrmacion_academica){periodos.add(j.periodo);}
		ObservableList<String> listaCargaPeriodo = FXCollections.observableList(periodos);
		cBCursoPeriodo.setItems(listaCargaPeriodo);
		cBCursoPeriodo.setValue(listaCargaPeriodo);
		
		// listado de profesores
		ObservableList<Profesor> listaCargaProfesores = FXCollections.observableList(main.getU().lista_profesores);
		cBCursoProfesor.setItems(listaCargaProfesores);
		cBCursoProfesor.setValue(listaCargaProfesores);
	}
	
	public void ActualizarVistasTablaCursos(){
		if(!seCreoTablaCursos){
			tCNombreCursos.setCellValueFactory(new PropertyValueFactory<Curso,String>("nombreCurso"));
			tCProfesorPrincipal.setCellValueFactory(new PropertyValueFactory<Curso,String>("nombreProfesorPrincipal"));
			tCPeriodoCurso.setCellValueFactory(new PropertyValueFactory<Curso,String>("periodo"));
			tCIdCursos.setCellValueFactory(new PropertyValueFactory<Curso,Integer>("id_curso"));
			tCSeccionCursos.setCellValueFactory(new PropertyValueFactory<Curso,Integer>("seccionCurso"));
			tCCreditosCursos.setCellValueFactory(new PropertyValueFactory<Curso,Integer>("creditos"));
			tViewCursos.setItems(datosCursos);
		}
		
		List<Curso> cursos = main.U.lista_cursos;
		datosCursos = FXCollections.observableArrayList(cursos);
		tViewCursos.setItems(datosCursos);
	}
	
	private List<String> GenerarHorario(String stringHorario){
		String[] listaRetornoSeparado = stringHorario.split(",");
		return Arrays.asList(listaRetornoSeparado);
	}
	private Integer GetSemestre(String periodo){
		String[] listaRetornoSeparado = periodo.split("-");
		return Integer.parseInt(Arrays.asList(listaRetornoSeparado).get(1)); 
	}
	private List<String> GenerarListaSalas(String stringSalas){
		String[] listaRetornoSeparado = stringSalas.split(",");
		return Arrays.asList(listaRetornoSeparado);
	}
	
	// MODULO PROGRAMACION ACADEMICA
	@FXML
    private TextField textFieldSemestreProgramacionAcademica;
	@FXML
    private Label LabelEstadoProgramacionAcademica;
	
	public void AgregarProgramacionAcademica(){
		String semestre = textFieldSemestreProgramacionAcademica.getText();
		if(semestre != ""){
			main.U.administrador_actual.crear_programacion_academica(semestre);
			LabelEstadoProgramacionAcademica.setText("Agregado");
		}
		else{
			LabelEstadoProgramacionAcademica.setText("Campo Vacio");
		}
	}

	/// metodo para realizar el cambio de paginas.
	@Override
	public void setScreenParent(ScreensController ScreenPage) {
		controlador = ScreenPage;	
	}
	
	// MODULO MODIFICAR DATOS
	
	
	
}
