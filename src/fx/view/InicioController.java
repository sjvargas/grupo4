package fx.view;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
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
import java.util.List;

import g4.Administrador_academico;
import g4.Alumno;
import g4.AplicacionInicio;
import g4.Carrera;
import g4.Curso;
import g4.Malla_curricular;
import g4.Usuario;
import javafx.beans.property.SimpleStringProperty;

public class InicioController {
	
	

//	public List<Alumno> alumnos;
//	public List<Administrador_academico> admins;
	public Usuario Usuario_conectado;
	public String Usuario_tipo;  /// aca va un string que si es "alumno" o si es "admin".
	
	
	
	
	// el siguiente boolean es para saber si esta en modo alumno (en true) o en modo Admin(en false)
	boolean modoAlumnoSelecionado;
	AplicacionInicio aplicacionInicio;
	@FXML
    private TextField tfNombre;
	@FXML
    private TextField tfCont;
	@FXML
    private TextField tfSexo;
	@FXML
    private TextField tfEdad;
	@FXML
    private TextField a_nombre;
	@FXML
    private TextField a_clave;
	@FXML
	private Button ingresar;
	@FXML
	private Button registrar;
	@FXML
    private Label error_ingreso;
	@FXML
	private Pane pantalla_inicio;
	@FXML
	private Pane pantalla_alumno;
	@FXML
	private Button cerrar_sesion;
	
	/// variables de Usuario

	@FXML
	private Button boton_carreras_alumno;
	@FXML
	private Pane pane_carreras_alumno;
	@FXML
	private Button boton_semestres_alumno;
	@FXML
	private Pane pane_semestres_alumno;
	@FXML
	private Button boton_cursos_alumno;
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
	
	//crea instancia de  Apicacion inicio-.. No estoy seguro de si se crea acá o en Main
	
	
	
	
	
	
	public void IngresarUsuario(ActionEvent event){
		String nombre = a_nombre.getText() ;
		String clave = a_clave.getText();
		if (modoAlumnoSelecionado)
		{
			if (aplicacionInicio.listaAlumnos.isEmpty())
			{
				error_ingreso.setText("no existe ningun alumno");
			}
			boolean aux = false;
			for (Alumno j : aplicacionInicio.listaAlumnos)
			{
				if ( j.nombre.equals(nombre) && j.contraseña.equals(clave) )
				{
					aux = true;
					if (j.acceso== true)
					{
						System.out.println("con acceso");
						j.Iniciar_sesion();
						Usuario_conectado = j;
						Usuario_tipo = "alumno";
						error_ingreso.setText("perfecto te conectaste!!");

						pantalla_alumno.setVisible(true);
						pantalla_inicio.setVisible(false);
						
					}
					else {
						error_ingreso.setText("tu excediste el numero de creditos reprobados :(");

					}
					break;
				}
			}
			if (!aux){
				error_ingreso.setText("tu usuario o contraseña son incorrectas");
				}
		}
		else
		{
			error_ingreso.setText("admiiin");
			
			
			
			
			
			
		}
		
		
	}
	

	public InicioController(){
		
		aplicacionInicio = new AplicacionInicio();

		
		modoAlumnoSelecionado = true;

		
		
	}

	public void CerrarSesion(ActionEvent event){
		pantalla_inicio.setVisible(true);
		pantalla_alumno.setVisible(false);
		Usuario_conectado.Cerrar_sesion();
	}
	
	
	
	public void registrarse(){
		
		
		if(modoAlumnoSelecionado){
			
			
			System.out.println("nombre: "+tfNombre.getText());
			Alumno a = new Alumno(tfNombre.getText(), tfCont.getText(), tfSexo.getText(), Integer.parseInt(tfEdad.getText()));
			
			aplicacionInicio.agregarAlumno(a);
			
			pantalla_inicio.setVisible(false);
			pantalla_alumno.setVisible(true);
			
			a.Iniciar_sesion();
			Usuario_conectado = a;
			Usuario_tipo = "alumno";
		}
		
		else{
			Administrador_academico a =new Administrador_academico(tfNombre.getText(), tfCont.getText(), tfSexo.getText(), Integer.parseInt(tfEdad.getText()));
			aplicacionInicio.agregarAdministrador(a);
			
			pantalla_inicio.setVisible(false);
			pantalla_alumno.setVisible(true); /// cambiar esta pantalla que se vea
			a.Iniciar_sesion();
			Usuario_conectado = a;
			Usuario_tipo = "admin";
		}
		
		//if()
		
	}
	
	
	public void seleccionarModoAlumno(){
		modoAlumnoSelecionado = true;
		//System.out.println("Modo alumno seleccionado");
	}
	public void seleccionarModoAdmin(){
		modoAlumnoSelecionado = false;
		//System.out.println("Modo Admin seleccionado");
		
	}
	

	//// eventos paneles de usuario
	
	public void clicksemestres()
	{
		mostrar_panel(pane_semestres_alumno);
	}
	
	public void clickcursos()
	{
		mostrar_panel(pane_cursos_alumno);
		
		//ObservableList<Curso>  ss = FXCollections.observableList(aplicacionInicio.listaAdministradores.get(0).getListaCarrera());
		//choise_carreras_alumno.setItems(ss);
	}
	
	public void clickcarreras()
	{
		mostrar_panel(pane_carreras_alumno);
		
		ObservableList<Carrera>  ss = FXCollections.observableList(aplicacionInicio.listaAdministradores.get(0).getListaCarrera());
		choise_carreras_alumno.setItems(ss);
		
		choise_carreras_alumno.setValue(aplicacionInicio.listaAdministradores.get(0).getListaCarrera().get(0));
		
		this.actualizarTablaConCarrerasInscritas();
		ObservableList<Malla_curricular>  mallasDeLaCarrera = FXCollections.observableList(aplicacionInicio.listaAdministradores.get(0).getListaCarrera().get(0).getMallas_curriculares());
		//choice_malla.setItems(mallasDeLaCarrera);
		//choice_malla.setValue(mallasDeLaCarrera.get(0));
		
	}
	
	
	public void mostrar_panel(Pane a)
	{
		if (pane_cursos_alumno.isVisible()){
			pane_cursos_alumno.setVisible(false);
		}
		if (pane_carreras_alumno.isVisible()){
			pane_carreras_alumno.setVisible(false);
		}
		if (pane_semestres_alumno.isVisible()){
			pane_semestres_alumno.setVisible(false);
		}
		
		a.setVisible(true);
	}
	
	
	/// eventos paneles de carreras
	
	public void clickvercarrera()
	{
		Carrera c = (Carrera) choise_carreras_alumno.getValue();
		label_nombre_carrera_alumno.setText(c.getnombre_carrera());
		label_decano_carrera_alumno.setText(c.getDecano());
		label_facultad_carrera_alumno.setText(c.getFacultad());
		
		
		ObservableList<Malla_curricular>  mallasDeLaCarrera = FXCollections.observableList(c.getMallas_curriculares());
	//	choice_malla.setItems(mallasDeLaCarrera);
	//	choice_malla.setValue(mallasDeLaCarrera.get(0));
		
		
		
	}
	
	public void clickInscribirCarreraYMalla(){
		System.out.println("metal");
		
		((Alumno)Usuario_conectado).Inscribir_carrera(((Carrera) choise_carreras_alumno.getValue()).getId_carrera());
		
	//	((Alumno)Usuario_conectado).Inscribir_malla_curricular(((Malla_curricular) choice_malla.getValue()).getId_malla());
		
		
		
		//
		this.actualizarTablaConCarrerasInscritas();
		 
		
	}
	
	private void actualizarTablaConCarrerasInscritas(){
		//listViewCarrerasInscritas = new ListView<String>();
		List<String> nombresCarrerasInscritas= new ArrayList<String>();
		
		for(int i=0;i<((Alumno)Usuario_conectado).GetCarreras().size();i++){
			nombresCarrerasInscritas.add(aplicacionInicio.listaAdministradores.get(0).GetCarrera(((Alumno)Usuario_conectado).GetCarreras().get(i)).getnombre_carrera());
			
		}
		
		ObservableList<String> items =FXCollections.observableArrayList (nombresCarrerasInscritas);
		listViewCarrerasInscritas.setItems(items);
		
		//
	}
	
	
	
}
