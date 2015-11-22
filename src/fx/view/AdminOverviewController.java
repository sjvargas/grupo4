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
import javafx.scene.control.TextArea;
import jdk.nashorn.internal.runtime.ListAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import g4.Administrador_academico;
import g4.Alumno;
import g4.Carrera;
import g4.Curso;
import g4.CursoTabla;
import g4.Malla_curricular;
import g4.Profesor;
import g4.ProgramacionHoraria;
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
		labelInicioNombre.setText(main.U.administrador_actual.getNombre());
		labelInicioNombreUsuario.setText(main.U.administrador_actual.GetNombreUsuario());
		labelInicioApPat.setText(main.U.administrador_actual.getApellidoPaterno());
		labelInicioApMat.setText(main.U.administrador_actual.getApellidoMaterno());
		labelInicioSexo.setText(main.U.administrador_actual.GetSexo().name());
		labelInicioEdad.setText(main.U.administrador_actual.GetEdadString());
	}
	public void ApretarBotonProfesores(ActionEvent event){
		CambiarAPanel(paneAdminProfesores);
		LabelPanelAdminEstado.setText("Profesores");
		ActualizarVistasTablaProfesor();
		CargarValoresFormularioProfesor();
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
		ActualizarChoiceBoxProgramacionAcademica();
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
    private Label labelInicioNombre;
	@FXML
    private Label labelInicioApPat;
	@FXML
    private Label labelInicioApMat;
	@FXML
    private Label labelInicioNombreUsuario;
	@FXML
    private Label labelInicioSexo;
	@FXML
    private Label labelInicioEdad;
	
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
	@FXML
	private ChoiceBox cBProfesorFacultad, cBProfesorSexo, cBProfesorEdad;
	
	// Tabla Lista Profesores:
	
	// Agregar Nuevo Profesor:
	public void ApretarAgregarProfesor(ActionEvent event){
		String nombreProfesor = campoANombreProfesor.getText();
		String apellidoPatProfesor = campoAApPatProfesor.getText();
		String apellidoMatProfesor = campoAApMatProfesor.getText();
		String nombreUsuarioProfesor = campoANombreUsuarioProfesor.getText();
		String contrasenaProfesor = campoAContrasenaProfesor.getText();
		Sexo sexoProfesor = (Sexo)cBProfesorSexo.getValue();
		Integer edadProfesor = Integer.parseInt(cBProfesorEdad.getValue().toString());
		String sueldoProfesor = campoASueldoProfesor.getText();
		int sueldoProfesor2 = Integer.parseInt(sueldoProfesor);
		String facultadProfesor = cBProfesorFacultad.getValue().toString();
		if(nombreProfesor != "" && apellidoPatProfesor!= "" && apellidoMatProfesor!= "" &&
				nombreUsuarioProfesor != "" && contrasenaProfesor!= "" && sueldoProfesor!= "" )
		{
			main.U.administrador_actual.agregar_profesor(nombreUsuarioProfesor, nombreProfesor, apellidoPatProfesor, apellidoMatProfesor, contrasenaProfesor, sexoProfesor, edadProfesor , sueldoProfesor2, facultadProfesor);
			labelAvisoProfesor.setText("Agregado");
		}
		else{
			labelAvisoProfesor.setText("Completar");
		}
		ActualizarVistasTablaProfesor();
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
	//	tabla2AdminListaProfesores.refresh();
		List<Profesor> profesores = main.U.lista_profesores;
		datosProfesores = FXCollections.observableArrayList(profesores);
		tabla2AdminListaProfesores.setItems(datosProfesores);
	//	tabla2AdminListaProfesores.refresh();
	}
	
	private void CargarValoresFormularioProfesor(){
		ObservableList<String> listaCargaFacultades = FXCollections.observableList(main.getU().getFacultades());
		cBProfesorFacultad.setItems(listaCargaFacultades);
		cBProfesorFacultad.setValue(listaCargaFacultades);
		
		ObservableList<Sexo> listaCargaSexos = FXCollections.observableList(Arrays.asList(Sexo.values()));
		cBProfesorSexo.setItems(listaCargaSexos);
		cBProfesorSexo.setValue(listaCargaSexos);
		
		List<Integer> listaEdades = new ArrayList<Integer>();
		for(Integer i=1; i<100; i++){
			listaEdades.add(i);
		}
		ObservableList<Integer> listaCargaEdades = FXCollections.observableList(listaEdades);
		cBProfesorEdad.setItems(listaCargaEdades);
		cBProfesorEdad.setValue(listaCargaEdades);
	}
	
	// Eliminar Profesor
	public void ApretarEliminarProfesor(ActionEvent event){
		String respuestaIdProfesor = campoEliminarProfID.getText();
		if(respuestaIdProfesor!=""){
			main.U.EliminarProfesor(Integer.parseInt(respuestaIdProfesor));
		}
		ActualizarVistasTablaProfesor();
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
	//	tViewnAlumnos.refresh();
		List<Alumno> alumnos = main.U.lista_alumnos;
		datosAlumnos = FXCollections.observableArrayList(alumnos);
		tViewnAlumnos.setItems(datosAlumnos);
		//tViewnAlumnos.refresh();
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
	private ChoiceBox cBAgRamoPrerrequisito;
	@FXML
	private ChoiceBox cBAgPrerreqPrerrequisito;
	@FXML
	private TableView<Ramo> tViewRamos, tViewPrerrequisitos;
	// Para la tabla de ramos
	@FXML
	private TableColumn<Ramo,String> tCSiglaRamos, tCNombreRamos,tCCarreraRamos ,tCSemestreRamos ;
	@FXML
	private TableColumn<Ramo,Integer> tCCreditosRamos;
	// Para prerrequisitos
	@FXML
	private Label labelRamoPreReq;
	@FXML
	private TableColumn<Ramo,String> tCSiglaPrerrequisito, tCNombrePrerrequisito;
	@FXML
	private ObservableList<Ramo> datosRamos = FXCollections.observableArrayList();
	private ObservableList<Ramo> datosPrerrequisitos = FXCollections.observableArrayList();	
	private boolean seCreoTablaRamos = false;
	private boolean seCreoTablaPrerrequisitos = false;
	@FXML
	private ChoiceBox cBRamoSemestre, cBRamoCreditos, cBRamoCarrera;
	@FXML
	private TextArea tARamoContendio, tAObjetivos;
	
	public void AgregarRamo(){
		String nombreRamo = textFieldNombreRamo.getText();
		String siglaRamo = textFieldSiglaRamo.getText();
		Carrera carreraRamo = (Carrera)cBRamoCarrera.getValue();
		Integer creditosRamo = (Integer)cBRamoCreditos.getValue();
		String semestreImpartidoRamo = cBRamoSemestre.getValue().toString();
		String contenidoRamo = tARamoContendio.getText();
		String objetivosRamo = tAObjetivos.getText();
		if(nombreRamo != "" && siglaRamo != "" &&semestreImpartidoRamo!= "" && contenidoRamo!= "" && objetivosRamo!= "" ){
			main.U.administrador_actual.agregar_ramo(nombreRamo ,siglaRamo, carreraRamo, creditosRamo, semestreImpartidoRamo, contenidoRamo, objetivosRamo);
			labelAgregarRamo.setText("Ramo Agregado");
			ActualizarValoresChoiseBoxProf();
			ActualizarVistasTablaRamos();
		}
		else{
			labelAgregarRamo.setText("Error al agregar Ramo");
		}
		ActualizarVistasTablaRamos();
	}
	public void ActualizarValoresChoiseBoxProf(){
		//cBRamoSemestre
		List<Integer> listaSemestre = new ArrayList<Integer>();
		for(Integer i=1; i<4; i++){
			listaSemestre.add(i);
		}
		ObservableList<Integer> listaCargaSemestre = FXCollections.observableList(listaSemestre);
		cBRamoSemestre.setItems(listaCargaSemestre);
		cBRamoSemestre.setValue(listaCargaSemestre);
		//cBRamoCreditos
		List<Integer> listaCreditos = new ArrayList<Integer>();
		for(Integer i=1; i<50; i++){
			listaCreditos.add(i);
		}
		ObservableList<Integer> listaCargaCreditos = FXCollections.observableList(listaCreditos);
		cBRamoCreditos.setItems(listaCargaCreditos);
		cBRamoCreditos.setValue(listaCargaCreditos);
		//cBRamoCarrera
		ObservableList<Carrera> listaCargaCarreras = FXCollections.observableList(main.getU().lista_carreras);
		cBRamoCarrera.setItems(listaCargaCarreras);
		cBRamoCarrera.setValue(listaCargaCarreras);
		
		
		ObservableList<String> listaCargaRamos = FXCollections.observableList(main.getU().GetSiglasRamos());
		cBAgPrerreqRamo.setItems(listaCargaRamos);
		cBAgPrerreqRamo.setValue(listaCargaRamos);
		cBAgPrerreqPrerrequisito.setItems(listaCargaRamos);
		cBAgPrerreqPrerrequisito.setValue(listaCargaRamos);
		cBAgRamoPrerrequisito.setItems(listaCargaRamos);
		cBAgRamoPrerrequisito.setValue(listaCargaRamos);
	}	
	
	public void ApretarAgregarPrerrequisito(ActionEvent event){
		String siglaRamo = cBAgPrerreqRamo.getValue().toString();
		String siglaPrerrequisito = cBAgPrerreqPrerrequisito.getValue().toString();
		main.U.administrador_actual.AgregarPrerrequisito(siglaRamo, siglaPrerrequisito);
		System.out.println("para"+ siglaRamo+"el prerrequisito es" + main.getU().GetRamo(siglaRamo).GetPrerrequisitos().get(0));
		ActualizarVistasTablaRamos();
		CargarPrerrequisitosEnTabla(siglaRamo);
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
//		tViewRamos.refresh();
		List<Ramo> ramos = main.U.lista_ramos;
		datosRamos = FXCollections.observableArrayList(ramos);
		tViewRamos.setItems(datosRamos);
	//	tViewRamos.refresh();
	}

	public void ApretarVerPrerrequisitos(ActionEvent event){
		/*if(!seCreoTablaPrerrequisitos){
			tCSiglaPrerrequisito.setCellValueFactory(new PropertyValueFactory<Ramo,String>("sigla"));
			tCNombrePrerrequisito.setCellValueFactory(new PropertyValueFactory<Ramo,String>("nombreRamo"));
			tViewPrerrequisitos.setItems(datosPrerrequisitos);
		}*/
		String siglaRamo = cBAgRamoPrerrequisito.getValue().toString();
		CargarPrerrequisitosEnTabla(siglaRamo);
	}
	
	private void CargarPrerrequisitosEnTabla(String siglaRamo){
	//	tViewPrerrequisitos.refresh();
		tCSiglaPrerrequisito.setCellValueFactory(new PropertyValueFactory<Ramo,String>("sigla"));
		tCNombrePrerrequisito.setCellValueFactory(new PropertyValueFactory<Ramo,String>("nombreRamo"));
		labelRamoPreReq.setText(siglaRamo);
		if(siglaRamo != ""){
			List<Ramo> prerrequisitos = new ArrayList();
			for(String siglaPrerrequisito: main.U.GetRamo(siglaRamo).GetPrerrequisitos()){
				prerrequisitos.add(main.U.GetRamo(siglaPrerrequisito));
			}
			datosPrerrequisitos = FXCollections.observableArrayList(prerrequisitos);
			tViewPrerrequisitos.setItems(datosPrerrequisitos);
		}
	//	tViewPrerrequisitos.refresh();
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
	private TableView<Ramo> tViewRamoCarrera, tVPrerreqRamoMalla;
	@FXML
	private TableColumn<Carrera,String> tCNombreCarrera, tCFacultadCarrera,tCDecanoCarrera;
	@FXML
	private ObservableList<Carrera> datosCarreras = FXCollections.observableArrayList();
	private boolean seCreoTablaCarreras = false;
	@FXML
	private ChoiceBox cBMallasCarrera;
	private Carrera carreraSeleccionada;
	private Malla_curricular mallaSeleccionada;
	@FXML
	private TableColumn<Ramo, String> tCSiglaRamoMalla, tCNombreRamoMalla, tCSiglaRamoPreMalla, tCNombreRamoPreMalla;
	@FXML
	private TableColumn<Ramo, Integer> tCCreditosRamoMalla;
	@FXML
	private ObservableList<Ramo> datosRamoCarrera = FXCollections.observableArrayList();
	@FXML
	private ChoiceBox cBAgregarRamoMalla, cBEliminarRamoMalla;
	@FXML
	private Label labelAgregarRamoMalla, labelEliminarRamoMalla, labelCrearMalla;
	@FXML
	private ObservableList<Ramo> listaCargaRamosAgregar = FXCollections.observableArrayList();
	@FXML
	private ObservableList<Ramo> listaCargaRamosEliminar = FXCollections.observableArrayList();
	
	
	public void AgregarCarrera(){
		String nombreCarrera = textFieldNombreCarrera.getText();
		String facultadCarrera = textFieldFacultadCarrera.getText();
		String decanoCarrera = textFieldDecanoCarrera.getText();
		if(nombreCarrera!="" && facultadCarrera!="" && decanoCarrera!=""){
			main.U.administrador_actual.agregar_carrera(decanoCarrera, facultadCarrera, nombreCarrera);
			labelEstadoAgregarCarrera.setText("Carrera Agregada");
			ActualizarVistasTablaCarreras();
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
//		tViewCarrera.refresh();
		List<Carrera> carreras = main.U.lista_carreras;
		datosCarreras = FXCollections.observableArrayList(carreras);
		tViewCarrera.setItems(datosCarreras);
	//	tViewCarrera.refresh();
	}
	
	public void ApretoSeleccionarCarrera(ActionEvent event){
		carreraSeleccionada = tViewCarrera.getSelectionModel().getSelectedItem();
		// cargar en choice box las mallas curriculares
		CargarMallasDeCarrera();
	}
	public void ApretoCrearNuevaMalla(ActionEvent event){
		// crear una nueva malla curricular de la carrera
		Malla_curricular malla = new Malla_curricular();
		carreraSeleccionada.crear_malla_curricular(malla);
		labelCrearMalla.setText("Se creo una malla con id: " + malla.getId_malla());
		// cargar denuevo choice box
		CargarMallasDeCarrera();
	}
	public void ApretoVerMalla(ActionEvent event){
		// mostrar ramos de la malla en la vista de tabla
		mallaSeleccionada = (Malla_curricular)cBMallasCarrera.getValue();
		CargarChoiceBoxAgregarEliminarRamoMalla();
		CargarTablaRamosMalla();
	}
	public void ApretoAgregarRamoMalla(ActionEvent event){
		// agregar ramo a la malla
		Ramo ramo = (Ramo) cBAgregarRamoMalla.getValue();
		if(mallaSeleccionada.ExisteRamo(ramo)){
			labelAgregarRamoMalla.setText("Ya esta");
		}
		else{
			mallaSeleccionada.agregar_ramo(ramo);
			labelAgregarRamoMalla.setText("Agregado");
		}
		// actualizar la vista de tabla
		CargarTablaRamosMalla();
		CargarChoiceBoxAgregarEliminarRamoMalla();
	}
	public void ApretoEliminarRamoMalla(ActionEvent event){
		// eliminar ramo de la malla
		Ramo ramo = (Ramo) cBEliminarRamoMalla.getValue();
		mallaSeleccionada.eliminarRamo(ramo);
		labelEliminarRamoMalla.setText("Eliminado");
		// actualizar la vista de tabla
		CargarTablaRamosMalla();
		CargarChoiceBoxAgregarEliminarRamoMalla();
	}
	public void ApretoVerPrerrequisitosRamoMalla(ActionEvent event){
		// leer el ramo seleccionado
		tCSiglaRamoPreMalla.setCellValueFactory(new PropertyValueFactory<Ramo,String>("sigla"));
		tCNombreRamoPreMalla.setCellValueFactory(new PropertyValueFactory<Ramo,String>("nombreRamo"));
		Ramo ramoVisto = tViewRamoCarrera.getSelectionModel().getSelectedItem();
		List<String> listaPrerrequisitos = ramoVisto.GetPrerrequisitos();
		List<Ramo> listaPreRamos = new ArrayList<Ramo>();
		for(String sigla: listaPrerrequisitos){
			listaPreRamos.add(main.U.GetRamo(sigla));
		}
		ObservableList<Ramo> datosPrerrequisitosRamo = FXCollections.observableArrayList(listaPreRamos);
		tVPrerreqRamoMalla.setItems(datosPrerrequisitosRamo);
		// actualizar la tabla de prerrequisitos
	}
	private void CargarMallasDeCarrera(){
		// carga malla en choicebox
		List<Malla_curricular> lista = new ArrayList<Malla_curricular>();
		ObservableList<Malla_curricular> listaCargaMallas2 = FXCollections.observableList(lista);
		cBMallasCarrera.setItems(listaCargaMallas2);
		cBMallasCarrera.setValue(listaCargaMallas2);
		ObservableList<Malla_curricular> listaCargaMallas = FXCollections.observableList(carreraSeleccionada.getMallas_curriculares());
		cBMallasCarrera.setItems(listaCargaMallas);
		cBMallasCarrera.setValue(listaCargaMallas);
	}
	private void CargarTablaRamosMalla(){
		tCSiglaRamoMalla.setCellValueFactory(new PropertyValueFactory<Ramo,String>("sigla"));
		tCNombreRamoMalla.setCellValueFactory(new PropertyValueFactory<Ramo,String>("nombreRamo"));
		tCCreditosRamoMalla.setCellValueFactory(new PropertyValueFactory<Ramo,Integer>("creditos"));
//		tViewRamoCarrera.refresh();
		List<Ramo> ramosMalla = mallaSeleccionada.getRamos();
		datosRamoCarrera = FXCollections.observableArrayList(ramosMalla);
		tViewRamoCarrera.setItems(datosRamoCarrera);
	//	tViewRamoCarrera.refresh();
	}
	private void CargarChoiceBoxAgregarEliminarRamoMalla(){
		listaCargaRamosAgregar = FXCollections.observableList(main.U.lista_ramos);
		cBAgregarRamoMalla.setItems(listaCargaRamosAgregar);
		cBAgregarRamoMalla.setValue(listaCargaRamosAgregar);
		// Ramo eliminados
		List<Ramo> lista1 = new ArrayList<Ramo>();
		ObservableList<Ramo> listaCargaArreglo = FXCollections.observableList(lista1);
		cBEliminarRamoMalla.setItems(listaCargaArreglo);
		cBEliminarRamoMalla.setValue(listaCargaArreglo);
		listaCargaRamosEliminar = FXCollections.observableList(mallaSeleccionada.getRamos());
		cBEliminarRamoMalla.setItems(listaCargaRamosEliminar);
		cBEliminarRamoMalla.setValue(listaCargaRamosEliminar);
	}
	
	
	// MODULO CURSOS

	@FXML
	private ChoiceBox cBCursoSiglaRamo, cBCursoPeriodo, cBCursoProfesor, cBCursoCreditos,
						cBCursoSala, cBCursoModulo, cBCursoDia, cBCursoSeccion, cBSeleccionarPeriodo;
	@FXML
	private TableView<Curso> tViewCursos;
	@FXML
	private TableView<ProgramacionHoraria> tViewProgramacionHoraria;
	@FXML
	private TableColumn<Curso,String> tCNombreCursos, tCProfesorPrincipal, tCPeriodoCurso;
	@FXML
	private TableColumn<Curso,Integer> tCIdCursos, tCSeccionCursos, tCCreditosCursos;
	@FXML
	private TableColumn<ProgramacionHoraria,String> tCDia, tCSala;
	@FXML
	private TableColumn<ProgramacionHoraria, Integer> tCModulo;
	@FXML
	private ObservableList<Curso> datosCursos = FXCollections.observableArrayList();
	@FXML
	private ObservableList<ProgramacionHoraria> datosProgramacionHoraria = FXCollections.observableArrayList();
	private boolean seCreoTablaCursos = false;
	private boolean seCreoTablaProgramacionHoraria = false;
	private List<ProgramacionHoraria> listaProgramacionHoraria;
	@FXML
	private Label labelEstadoAgregarModulo, labelEstadoCrearCurso;
	@FXML
	private Button buttonCrearCurso, buttonModificarCurso;
	private Curso cursoSeleccionadoModificar;
	private String periodoActual = "2016-1";
	
	public void ApretarAgregarCurso(ActionEvent event){
		main.U.GetProgramacionAcademicaPeriodo(cBCursoPeriodo.getValue().toString()).crear_curso(
				cBCursoPeriodo.getValue().toString(), getListaSala(), getListaHorario(),
				Integer.parseInt(cBCursoCreditos.getValue().toString()), (Integer)cBCursoSeccion.getValue(), 
				(Profesor) cBCursoProfesor.getValue(), main.U.GetRamo((String)cBCursoSiglaRamo.getValue()));	
		ActualizarVistasTablaCursos();
		seCreoTablaProgramacionHoraria = false;
	}
	public void ApretarAgregarProgramacionHoraria(ActionEvent event){
		if(!seCreoTablaProgramacionHoraria){
			listaProgramacionHoraria = new ArrayList<ProgramacionHoraria>();
			tCDia.setCellValueFactory(new PropertyValueFactory<ProgramacionHoraria,String>("dia"));
			tCSala.setCellValueFactory(new PropertyValueFactory<ProgramacionHoraria,String>("sala"));
			tCModulo.setCellValueFactory(new PropertyValueFactory<ProgramacionHoraria,Integer>("modulo"));
			seCreoTablaProgramacionHoraria = true;
		}
		// asumiendo que entro todos los valores bien
		ProgramacionHoraria programacionHoraria = new ProgramacionHoraria(	cBCursoDia.getValue().toString(),
																	Integer.parseInt(cBCursoModulo.getValue().toString()),
																	cBCursoSala.getValue().toString());
		Profesor profesorSeleccionado = (Profesor) cBCursoProfesor.getValue();
		Integer esDisponibleHorario = main.U.EstaDisponibleHorario(programacionHoraria, profesorSeleccionado.getId_profesor());
		boolean sePuedeAgregarHorario = SePuedeAgregarHorario(programacionHoraria);
		if( esDisponibleHorario.equals(0) &&sePuedeAgregarHorario){
			listaProgramacionHoraria.add(programacionHoraria);
			datosProgramacionHoraria = FXCollections.observableArrayList(listaProgramacionHoraria);
			tViewProgramacionHoraria.setItems(datosProgramacionHoraria);
			labelEstadoAgregarModulo.setText("Agregado");
		}
		else{
			if(sePuedeAgregarHorario){
				if(sePuedeAgregarHorario){
					if(esDisponibleHorario.equals(1)){
						labelEstadoAgregarModulo.setText("Sala no disponible");
					}
					else{
						labelEstadoAgregarModulo.setText("Profesor ocupado en modulo");
					}
				}
				else{
					labelEstadoAgregarModulo.setText("Modulo ya seleccionado");
				}
			}
			else{
				labelEstadoAgregarModulo.setText("Modulo ya seleccionado");
			}
		}
	}
	public void ApretarModificarCursoSeleccionado(ActionEvent event){
		labelEstadoCrearCurso.setText("Modificar Curso");
		buttonCrearCurso.setVisible(false);
		buttonModificarCurso.setVisible(true);
		cursoSeleccionadoModificar = tViewCursos.getSelectionModel().getSelectedItem();
		// cargar informacion del curso a modificar
		cBCursoSiglaRamo.setValue(cursoSeleccionadoModificar.getRamo().getSigla());
		cBCursoPeriodo.setValue(cursoSeleccionadoModificar.periodo);
		cBCursoProfesor.setValue(cursoSeleccionadoModificar.getProfesores().get(0));
		cBCursoCreditos.setValue(cursoSeleccionadoModificar.getCreditos());
		cBCursoSeccion.setValue(cursoSeleccionadoModificar.getSeccionCurso());
		// Poner informacion en vista de programacion horaria
		tCDia.setCellValueFactory(new PropertyValueFactory<ProgramacionHoraria,String>("dia"));
		tCSala.setCellValueFactory(new PropertyValueFactory<ProgramacionHoraria,String>("sala"));
		tCModulo.setCellValueFactory(new PropertyValueFactory<ProgramacionHoraria,Integer>("modulo"));
		seCreoTablaProgramacionHoraria = true;
		listaProgramacionHoraria = cursoSeleccionadoModificar.getListaProgramacionHoraria();
		datosProgramacionHoraria = FXCollections.observableArrayList(listaProgramacionHoraria);
		tViewProgramacionHoraria.setItems(datosProgramacionHoraria);
	}
	public void ApretarEliminarProgramacion(ActionEvent event){
		// borrar la programacion seleccionada
		ProgramacionHoraria programacionHoraria = tViewProgramacionHoraria.getSelectionModel().getSelectedItem();
		listaProgramacionHoraria.remove(programacionHoraria);
	//	tViewProgramacionHoraria.refresh();
		datosProgramacionHoraria = FXCollections.observableArrayList(listaProgramacionHoraria);
		tViewProgramacionHoraria.setItems(datosProgramacionHoraria);
		labelEstadoAgregarModulo.setText("Modulo Eliminado");
	}
	public void ApretarModificarCurso(ActionEvent event){
		labelEstadoCrearCurso.setText("Crear Curso");
		buttonCrearCurso.setVisible(true);
		buttonModificarCurso.setVisible(false);
		// borrar informacion del curso modificado
		cursoSeleccionadoModificar.ModificarDatosCurso(cBCursoPeriodo.getValue().toString(), getListaSala(), getListaHorario(),
				Integer.parseInt(cBCursoCreditos.getValue().toString()), (Integer)cBCursoSeccion.getValue(), 
				(Profesor) cBCursoProfesor.getValue(), main.U.GetRamo((String)cBCursoSiglaRamo.getValue()));
		ActualizarVistasTablaCursos();
		seCreoTablaProgramacionHoraria = false;
	}
	public void ApretarVerCursosPeriodo(ActionEvent event){
		periodoActual = cBSeleccionarPeriodo.getValue().toString();
		ActualizarVistasTablaCursos();
	}
	public void ApretarVerProgramacionHoraria(ActionEvent event){
		tCDia.setCellValueFactory(new PropertyValueFactory<ProgramacionHoraria,String>("dia"));
		tCSala.setCellValueFactory(new PropertyValueFactory<ProgramacionHoraria,String>("sala"));
		tCModulo.setCellValueFactory(new PropertyValueFactory<ProgramacionHoraria,Integer>("modulo"));
		seCreoTablaProgramacionHoraria = true;
		cursoSeleccionadoModificar = tViewCursos.getSelectionModel().getSelectedItem();
		listaProgramacionHoraria = cursoSeleccionadoModificar.getListaProgramacionHoraria();
		datosProgramacionHoraria = FXCollections.observableArrayList(listaProgramacionHoraria);
		tViewProgramacionHoraria.setItems(datosProgramacionHoraria);
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
		cBSeleccionarPeriodo.setItems(listaCargaPeriodo);
		cBSeleccionarPeriodo.setValue(listaCargaPeriodo);
		
		// lista de secciones
		List<Integer> secciones = new ArrayList<Integer>(); 
		for (Integer i=1; i<21; i++){secciones.add(i);}
		ObservableList<Integer> listaCargaSecciones = FXCollections.observableList(secciones);
		cBCursoSeccion.setItems(listaCargaSecciones);
		cBCursoSeccion.setValue(listaCargaSecciones);
		
		// lista de dia
		ObservableList<String> listaCargaDias = FXCollections.observableList(main.U.dias);
		cBCursoDia.setItems(listaCargaDias);
		cBCursoDia.setValue(listaCargaDias);
		
		// lista de modulos
		ObservableList<Integer> listaCargaModulos = FXCollections.observableList(main.U.listaModulos);
		cBCursoModulo.setItems(listaCargaModulos);
		cBCursoModulo.setValue(listaCargaModulos);
		
		// lista de salas
		ObservableList<String> listaCargaSalas = FXCollections.observableList(main.U.listaSalas);
		cBCursoSala.setItems(listaCargaSalas);
		cBCursoSala.setValue(listaCargaSalas);
		
		// lista de creditos
		ObservableList<Integer> listaCargaCreditos = FXCollections.observableList(main.U.listaCreditos);
		cBCursoCreditos.setItems(listaCargaCreditos);
		cBCursoCreditos.setValue(listaCargaCreditos);
		
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
	//	tViewCursos.refresh();
		List<Curso> cursos = main.U.getCursosProgramacionAcademica(periodoActual);
		datosCursos = FXCollections.observableArrayList(cursos);
		tViewCursos.setItems(datosCursos);
//		tViewCursos.refresh();
	}

	private boolean SePuedeAgregarHorario(ProgramacionHoraria programacionHoraria){
		for(ProgramacionHoraria pH:listaProgramacionHoraria){
			if(pH.getDia().equals(programacionHoraria.getDia()) && 
					pH.getModulo().equals(programacionHoraria.getModulo()) && 
					pH.getSala().equals(programacionHoraria.getSala()))
			{
				return false;
			}
		}
		return true;
	}
	private List<String> getListaSala(){
		List<String> listaRetorno = new ArrayList<String>();
		for(ProgramacionHoraria pH: listaProgramacionHoraria){
			listaRetorno.add(pH.getSala());
		}
		return listaRetorno;
	}
	private List<String> getListaHorario(){
		List<String> listaRetorno = new ArrayList<String>();
		for(ProgramacionHoraria pH: listaProgramacionHoraria){
			listaRetorno.add(pH.getDiaEnFormato());
		}
		return listaRetorno;
	}
	
	// MODULO PROGRAMACION ACADEMICA
	@FXML
    private ChoiceBox tBPeriodoCrearPA;
	@FXML
    private ChoiceBox cBPeriodoVerCursoPA;
	@FXML
    private Label LabelEstadoProgramacionAcademica;
	@FXML
	private TableView<Curso> tViewCursosPA;
	@FXML
	private TableColumn<Curso,String> tCNombreCursoPA, tCProfesorCursoPA;
	@FXML
	private TableColumn<Curso,Integer> tCIdCursoPA, tCSeccionCursoPA, tCCreditosCursoPA;
	@FXML
	private ObservableList<Curso> datosCursosPA = FXCollections.observableArrayList();
	
	
	
	public void ActualizarVistasTablaCursosPA(ActionEvent event){
		tCNombreCursoPA.setCellValueFactory(new PropertyValueFactory<Curso,String>("nombreCurso"));
		tCProfesorCursoPA.setCellValueFactory(new PropertyValueFactory<Curso,String>("nombreProfesorPrincipal"));
		tCIdCursoPA.setCellValueFactory(new PropertyValueFactory<Curso,Integer>("id_curso"));
		tCSeccionCursoPA.setCellValueFactory(new PropertyValueFactory<Curso,Integer>("seccionCurso"));
		tCCreditosCursoPA.setCellValueFactory(new PropertyValueFactory<Curso,Integer>("creditos"));
		tViewCursosPA.setItems(datosCursosPA);
		if(cBPeriodoVerCursoPA.getValue().toString()!=""){
			List<Curso> cursosPA = main.U.getCursosProgramacionAcademica(cBPeriodoVerCursoPA.getValue().toString());
			datosCursosPA = FXCollections.observableArrayList(cursosPA);
			tViewCursosPA.setItems(datosCursosPA);
		}
	}
	
	public void AgregarProgramacionAcademica(){
		String periodo = tBPeriodoCrearPA.getValue().toString();
		main.U.administrador_actual.crear_programacion_academica(periodo);
		LabelEstadoProgramacionAcademica.setText("Agregado");
		ActualizarChoiceBoxProgramacionAcademica();

	}
	
	public void ActualizarChoiceBoxProgramacionAcademica(){
		List<String> lista1 = new ArrayList<String>();
		ObservableList<String> listaCargaArreglo = FXCollections.observableList(lista1);
		tBPeriodoCrearPA.setItems(listaCargaArreglo);
		tBPeriodoCrearPA.setValue(listaCargaArreglo);
		ObservableList<String> listaPeriodosDisponibles = FXCollections.observableList(main.getU().getPeriodosLibres());
		tBPeriodoCrearPA.setItems(listaPeriodosDisponibles);
		tBPeriodoCrearPA.setValue(listaPeriodosDisponibles);
		

		cBPeriodoVerCursoPA.setItems(listaCargaArreglo);
		cBPeriodoVerCursoPA.setValue(listaCargaArreglo);
		ObservableList<String> listaPeriodosOcupados = FXCollections.observableList(main.getU().getPeriodosOcupados());
		cBPeriodoVerCursoPA.setItems(listaPeriodosOcupados);
		cBPeriodoVerCursoPA.setValue(listaPeriodosOcupados);
	}

	/// metodo para realizar el cambio de paginas.
	@Override
	public void setScreenParent(ScreensController ScreenPage) {
		controlador = ScreenPage;	
	}
	
	// MODULO MODIFICAR DATOS
	
	@FXML
    private TextField tBModificarNombre;
	@FXML
    private TextField tBModificarApPat;
	@FXML
    private TextField tBModificarApMat;
	@FXML
    private TextField tBModificarEdad;
	@FXML
    private TextField tBModificarContrasena;
	
	
	public void ApretoModificarDatos(ActionEvent event){
		String nombreNuevo = tBModificarNombre.getText();
		String apPatNuevo = tBModificarApPat.getText();
		String apMatNuevo = tBModificarApMat.getText();
		String edadNueva = tBModificarEdad.getText();
		String contrasenaNueva = tBModificarContrasena.getText();
		if(nombreNuevo!=""&&apPatNuevo!=""&&apMatNuevo!=""&&edadNueva!=""&&contrasenaNueva!=""){
			main.U.administrador_actual.ModificarDatos(nombreNuevo, apPatNuevo, apMatNuevo, contrasenaNueva, Integer.parseInt(edadNueva));
		}
	}
	
	
	
}
