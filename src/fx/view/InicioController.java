package fx.view;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import jdk.nashorn.internal.runtime.ListAdapter;
import g4.AplicacionInicio;




public class InicioController {
	
	
	
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
	//crea instancia de  Apicacion inicio-.. No estoy seguro de si se crea acá o en Main
	
	public InicioController(){
		
		aplicacionInicio = new AplicacionInicio();
		
		modoAlumnoSelecionado = true;
		
	}
	
	
	public void registrarse(){
		
		
		if(modoAlumnoSelecionado){
			
			
			System.out.println("nombre: "+tfNombre.getText());
			aplicacionInicio.agregarAlumno(tfNombre.getText(), tfCont.getText(), tfSexo.getText(), Integer.parseInt(tfEdad.getText()));
		}
		
		else{
			aplicacionInicio.agregarAdministrador(tfNombre.getText(), tfCont.getText(), tfSexo.getText(), Integer.parseInt(tfEdad.getText()));

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
	

}
