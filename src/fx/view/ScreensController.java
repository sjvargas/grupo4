package fx.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

/// esta es la clase de la que heredan todos los controllers
/// esta basada en el codigo mostrado en https://www.youtube.com/watch?v=5GsdaZWDcdY

public class ScreensController extends StackPane{
	
	// nodo es el root a la pantalla particular.
	private HashMap<String, Node> screens = new HashMap<>();
	public List<PrincipalController> pantallas = new ArrayList<PrincipalController>();;

	public ScreensController() {
		super();
	}
	
	public void addScreen(String nombre,Node nodo ){
		screens.put(nombre, nodo);
	}	
	
	public Node getScreen(String nombre){
		return screens.get(nombre);
	}
	
	
	/// resorce es el archivo FXML que queremos :) 
	// nombre es el id
	
	public boolean loadScreen(String nombre,String resourse){
		try {
			FXMLLoader cargador = new FXMLLoader(getClass().getResource(resourse));
			Parent proxima_pantalla = cargador.load();
			PrincipalController pantalla = ((PrincipalController) cargador.getController());
			pantalla.setScreenParent(this);
			System.out.println("agregando a "+nombre+" :) ");
			addScreen(nombre, proxima_pantalla);
			pantallas.add(pantalla);
			return true;
		}
		catch (Exception e){
			System.out.println(e);
			System.out.println("no se pudoo agregar a "+nombre+" :( ");
			return false;
		}
	}
	
	
	public boolean setScreen(final String nombre){
		System.out.println("\n abriendo: "+nombre);
		if (screens.get(nombre) != null){
			if(!getChildren().isEmpty()){
				
				getChildren().remove(0);
				getChildren().add(0, screens.get(nombre));
				
			} else {
				
				getChildren().add(screens.get(nombre));
			}
			return true;
		} else {
			System.out.println("no se pudo cargar el screen!! \n");
			return false;
		}
	}
	
	
	public boolean unloadScreen(String nombre){
		if (screens.remove(nombre) == null) {
			System.out.println("la pantalla no existia");
			return false;
		} else {
			return true;
			
		}
	}
	

}
