package fx.view;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import g4.Alumno;
import g4.AlumnoTabla;
import g4.Archivo;
import g4.Comentario;
import g4.Curso;
import g4.CursoTabla;
import g4.Tema;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class ForosController  implements PrincipalController , Initializable{

	ScreensController controlador;
	
	@FXML
	private Pane pane_temas, pane_comentarios, pane_nuevo_tema,pane_nuevo_comentario;
	@FXML
	private Button boton_subir_archivo,boton_bajar_archivo,buscar_archivo,boton_crear_comentario,boton_cerrar_sesion,boton_todo_tema,boton_menu,boton_tema_ir,boton_crear_tema;
	@FXML
	public TextField text_field_titulo;
	@FXML
	public TextArea text_area_comentario,text_area_comentario2; 
	@FXML
	public Label error_subir,error_descarga,mensaje_alerta,mensaje_alerta_comentario,label_curso_seleccionado,label_titulo_tema,label_nombre_archivo;
	@FXML
	public Text text_tema;
	@FXML
	public static Label l;
	@FXML
	public AnchorPane padre;
	@FXML
	public static ChoiceBox<String> choice_box_cursos;
	@FXML
	private TableView<Tema> tabla_temas;
	@FXML
	private TableView<Archivo> tabla_archivos;
	@FXML
	private TableView<Comentario> tabla_comentarios;
	@FXML
	private TableColumn<Archivo,String> columna_autor_archivo,columna_nombre_archivo;
	@FXML
	private TableColumn<Comentario,String> 	columna_autor_com,columna_status_com,columna_com_com;
	@FXML
	private TableColumn<Comentario,Date> columna_fecha_com; 	
	@FXML
	private TableColumn<Tema,String> columna_autor,columna_status,columna_tema,columna_com;
	@FXML
	private TableColumn<Tema,Date> columna_fecha; 
	@FXML
	private TableColumn<Tema,Integer> columna_respuestas;
	@FXML
	private ObservableList<Tema> data_ver_temas = FXCollections.observableArrayList();
	@FXML
	private ObservableList<Archivo> data_archivos = FXCollections.observableArrayList();
	@FXML
	private ObservableList<Comentario> data_ver_comentarios = FXCollections.observableArrayList();
	public Curso curso_seleccionado = null;
	public Tema tema_seleccionado = null;
	public final FileChooser fileChooser = new FileChooser();
	private List<String> contenido_archivo = new ArrayList<String>();
	private String nombre_archivo;
	
	public ForosController(){
	}
	
	
	//EVENTOS BOTONES MENU SUPERIOR
	public void ClickVolverMenu(ActionEvent event) {
		InicioComentarios();
		InicioTema();
		CambiarAPanel(pane_temas);
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
		InicioComentarios();
		InicioTema();
		CambiarAPanel(pane_temas);
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
	public void ClickTodoTema(ActionEvent event){
		InicioComentarios();
		InicioTema();
		mensaje_alerta.setText("");
		CambiarAPanel(pane_temas);
	}
	
	//EVENTOS PANEL TEMAS!!
	public void ClickIr(ActionEvent event){

		columna_autor_archivo.setCellValueFactory(new PropertyValueFactory<Archivo,String>("autor"));
		columna_nombre_archivo.setCellValueFactory(new PropertyValueFactory<Archivo,String>("nombre"));
		tabla_archivos.setItems(data_archivos);
		
		
		columna_com.setCellValueFactory(new PropertyValueFactory<Tema,String>("texto"));
		columna_autor.setCellValueFactory(new PropertyValueFactory<Tema,String>("usuario"));
		columna_status.setCellValueFactory(new PropertyValueFactory<Tema,String>("tipo"));
		columna_tema.setCellValueFactory(new PropertyValueFactory<Tema,String>("titulo"));
		columna_respuestas.setCellValueFactory(new PropertyValueFactory<Tema,Integer>("respuestas"));
		columna_fecha.setCellValueFactory(new PropertyValueFactory<Tema,Date>("fecha"));
		tabla_temas.setItems(data_ver_temas);
		
		String str = choice_box_cursos.getValue();
		int id_curso = Integer.parseInt(Arrays.asList(str.split("-")).get(1));
		Curso curso = null;
		for (Curso j :main.U.lista_cursos){
			if (j.id_curso==id_curso){
				curso=j;
				curso_seleccionado=j;
				break;
			}
		}
		label_curso_seleccionado.setText(curso_seleccionado.getRamo().getSigla()+" - "+curso_seleccionado.getNombreCurso());
		
		ArrayList<Tema> temas_tabla = new ArrayList<Tema>();
		if (curso!=null){
			for (Tema j: curso.temas){
				temas_tabla.add(j);
			}
			data_archivos= FXCollections.observableArrayList(curso.getApuntes());
		}
		data_ver_temas = FXCollections.observableArrayList(temas_tabla);
		ActualizarTablaTemas();
		ActualizarTablaArchivos();
		error_descarga.setText("");
		error_subir.setText("");
		
		
		
	}
	public void AgregarArchivo() throws IOException{
		fileChooser.setTitle("Open Resource File");
		fileChooser.getExtensionFilters().addAll(
		         new ExtensionFilter("Text Files", "*.txt"));
		File file = fileChooser.showOpenDialog(null);
		if (file != null) {
			label_nombre_archivo.setText(file.getName());
			nombre_archivo = file.getName();
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				contenido_archivo.add(line);
			}
			fileReader.close();
		}else {
			
		}
	}	
	public void ClickDescargar(ActionEvent e) throws IOException {
		error_descarga.setText("");
		if (curso_seleccionado!=null){
			Archivo archivo =tabla_archivos.getSelectionModel().getSelectedItem();
	        BufferedWriter output = null;
	        if (archivo!=null){
		        try {
		    		File file = new File(archivo.getNombre());
		            output = new BufferedWriter(new FileWriter(file));
					if (archivo.getContenido().size()>0){
			    		for (String line : archivo.getContenido()){
			    			output.write(line);
			    			output.newLine();
			    		}
					}else{
		    			output.write("archivo no disponible.");
		    			output.newLine();				
					}
		    		output.close();
					error_descarga.setText("descargado!");
		        } catch ( IOException e1 ) {
					error_descarga.setText("seleccione de nuevo");
		        } finally {
		            if ( output != null ) output.close();
		        }		
	        }else{
				error_descarga.setText("seleccione de nuevo");
			}
	   }else{
			error_descarga.setText("seleccione un curso");
	   }
	}	
	public void ClickSubir (){
		error_subir.setText("");
		if (curso_seleccionado!=null){
			if (contenido_archivo.size()>0){
				String nombre_usuario ="";
				if (main.U.alumno_actual!=null){
					nombre_usuario = main.U.alumno_actual.getNombre();
				}else if (main.U.profesor_actual!=null){
					nombre_usuario = main.U.profesor_actual.getNombre();
				}else if (main.U.administrador_actual!=null){
					nombre_usuario = main.U.administrador_actual.getNombre();
				}
				curso_seleccionado.agregarApunte(new Archivo(nombre_archivo,nombre_usuario,contenido_archivo));
				data_archivos= FXCollections.observableArrayList(curso_seleccionado.getApuntes());
				ActualizarTablaArchivos();
				label_nombre_archivo.setText("");
				nombre_archivo = null;
				contenido_archivo = new ArrayList<String>();
				error_subir.setText("subido!");
			}else{
				error_subir.setText("sin archivo");
			}
		}else{
			error_subir.setText("seleccione un curso");
		}
		
		
	}
	public void ClickSeleccionarTema(ActionEvent event){
			Tema tema =tabla_temas.getSelectionModel().getSelectedItem();
			if (tema!=null){
				label_titulo_tema.setText(tema.getTitulo());
				text_tema.setText(tema.getTexto());
				
				columna_com_com.setCellValueFactory(new PropertyValueFactory<Comentario,String>("texto"));
				columna_autor_com.setCellValueFactory(new PropertyValueFactory<Comentario,String>("usuario"));
				columna_status_com.setCellValueFactory(new PropertyValueFactory<Comentario,String>("tipo"));
				columna_fecha_com.setCellValueFactory(new PropertyValueFactory<Comentario,Date>("fecha"));
				
				data_ver_comentarios = FXCollections.observableArrayList(tema.getComentarios());
				tabla_comentarios.setItems(data_ver_comentarios);
				tema_seleccionado = tema;
				CambiarAPanel(pane_comentarios);
			}else{
				mensaje_alerta.setText("No hay ningun tema seleccionado, no puedes ver los comentarios.");
			}
	}
	public void ClickCrearTema(ActionEvent event){
		if (curso_seleccionado!=null){
			if (text_field_titulo.getText().length()>1 && text_area_comentario.getText().length()>1){
				if (main.U.alumno_actual!=null){
					curso_seleccionado.AgregarTema(text_field_titulo.getText(),text_area_comentario.getText(), main.U.alumno_actual, "alumno");
					mensaje_alerta.setText("tema agregado con exito!");
					text_field_titulo.setText("");text_area_comentario.setText("");
				}else if (main.U.profesor_actual!=null){
					curso_seleccionado.AgregarTema(text_field_titulo.getText(),text_area_comentario.getText(), main.U.profesor_actual, "profesor");
					mensaje_alerta.setText("tema agregado con exito!");
					mensaje_alerta.setText("tema agregado con exito!");
					text_field_titulo.setText("");text_area_comentario.setText("");
				}else{
					mensaje_alerta.setText("No se pudo agregar el tema, probalbemente problemas de conexion.");
				}
				ArrayList<Tema> temas_tabla = new ArrayList<Tema>();
				if (curso_seleccionado!=null){
					for (Tema j: curso_seleccionado.temas){
						temas_tabla.add(j);
					}
				}
				data_ver_temas = FXCollections.observableArrayList(temas_tabla);
				ActualizarTablaTemas();
			}else{
				mensaje_alerta.setText("Campos vacios, rellena bien el formulario");
			}
		}else{
			mensaje_alerta.setText("Selecciona un Curso Antes de Agregar un tema.");
		}
	}
	
	//EVENTOS PANEL COMENTARIOS!!
	public void ClickCrearComentario(ActionEvent event){
		if (tema_seleccionado != null){
			if (text_area_comentario2.getText().length()>1){
				if (main.U.alumno_actual!=null){
					tema_seleccionado.AgregarComentario(text_area_comentario2.getText(), main.U.alumno_actual, "alumno");
					mensaje_alerta_comentario.setText("Comentario agregado con exito!");
					text_area_comentario2.setText("");
				}else if (main.U.profesor_actual!=null){
					tema_seleccionado.AgregarComentario(text_area_comentario2.getText(), main.U.profesor_actual, "profesor");
					mensaje_alerta_comentario.setText("Comentario agregado con exito!");
					text_area_comentario2.setText("");
				}else{
					mensaje_alerta_comentario.setText("No se pudo agregar el Comentario, probalbemente problemas de conexion.");
				}
				data_ver_comentarios = FXCollections.observableArrayList(tema_seleccionado.getComentarios());
				ActualizarTablaComentarios();
			}else{
				mensaje_alerta_comentario.setText("Campos vacios, rellena bien el formulario");
			}
		} else {
			mensaje_alerta_comentario.setText("Error, no hay un tema seleccionado, por favor retroceder.");
		}
	}	
	
    // OTROS EVENTOS
	public void InicioComentarios(){
		data_ver_comentarios =  FXCollections.observableArrayList(new ArrayList<Comentario>());
		ActualizarTablaComentarios();
		mensaje_alerta_comentario.setText("");
		label_titulo_tema.setText("--");
		text_tema.setText("--");
	}
	public void InicioTema(){
		data_ver_temas =  FXCollections.observableArrayList(new ArrayList<Tema>());
		ActualizarTablaTemas();
		label_nombre_archivo.setText("---");
		data_archivos =  FXCollections.observableArrayList(new ArrayList<Archivo>());
		ActualizarTablaArchivos();
		mensaje_alerta.setText("");
		curso_seleccionado = null;
		tema_seleccionado = null;
		label_curso_seleccionado.setText("ningun curso seleccionado");
		error_descarga.setText("");
		error_subir.setText("");
		nombre_archivo = null;
		contenido_archivo = new ArrayList<String>();
	}
	// EVENTO PARA CAMBIAR PANES
	public void CambiarAPanel(Pane paneDeseado){
		pane_temas.setVisible(false);
		pane_comentarios.setVisible(false);
		paneDeseado.setVisible(true);
	}
	// EVENTO PARA CAMBIAR DE PAGINAS
	@Override
	public void setScreenParent(ScreensController ScreenPage) {
		controlador = ScreenPage;
	}
	//EVENTOS EXTRAS
	public void ActualizarTablaTemas(){
		tabla_temas.setItems(data_ver_temas);
	}	
	public void ActualizarTablaArchivos(){
		tabla_archivos.setItems(data_archivos);
	}	
	public void ActualizarTablaComentarios(){
		tabla_comentarios.setItems(data_ver_comentarios);
	}
	public static void CargarChoiceBox(ObservableList<String> uu){
		choice_box_cursos.setItems(uu);
	}
	public static void CambiarNombreMenu(String nombre){
		l.setText(nombre);
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		l = new Label("soy nuevooo!!!");
		padre.getChildren().add(l);
		l.setTextFill(Color.web("#0000ff"));
		l.setFont(new Font("System Bold", 14));
		l.relocate(642.0, 20.0);
		
		choice_box_cursos = new ChoiceBox<String>();
		choice_box_cursos.relocate(863.0, 41.0);
		choice_box_cursos.prefWidth(150.0);
		pane_temas.getChildren().add(choice_box_cursos);
		
	}
}
