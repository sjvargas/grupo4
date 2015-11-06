package fx.view;
	

import java.util.List;

import g4.Profesor;
import g4.Universidad;
import g4.Usuario;
import g4.Alumno;
import g4.Administrador_academico;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class main extends Application {
	//@Override

	
	/// cade vez que agreguemos una pantalla hay que guardar aca si ID y su filename.
	
	public static String InicioFile = "inicio.fxml";
	public static String InicioID = "inicio";
	public static String AlumnoFile = "AlumnoOverview.fxml";
	public static String AlumnoID = "Alumno";
	public static String AdminFile = "AdminOverview.fxml";
	public static String AdminID = "Admin";
	public static String BuscadorFile = "BuscadorDeCursosOverview.fxml";
	public static String BuscadorID = "Buscador";
	
	public static Universidad U;
	
	@Override
	public void start(Stage primaryStage) {
		U = new Universidad();
		
		
		ScreensController Contenedor = new ScreensController();
		Contenedor.loadScreen(main.AlumnoID, main.AlumnoFile);
		Contenedor.loadScreen(main.InicioID, main.InicioFile);
		Contenedor.loadScreen(main.AdminID, main.AdminFile);
		Contenedor.loadScreen(main.BuscadorID, main.BuscadorFile);
		
		Contenedor.setScreen(main.InicioID);
		
		Group root = new Group();
		root.getChildren().addAll(Contenedor);
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
//		
//		try {
//			
//			Parent root = FXMLLoader.load(getClass().getResource("inicio.fxml"));
//			
//			primaryStage.setTitle("titulo");
//			primaryStage.setScene(new Scene(root,800,500));
//			primaryStage.show();
//			
//			
//			//Parent root2 = FXMLLoader.load(getClass().getResource("AdminOverview.fxml"));
//			//primaryStage.setScene(new Scene(root2,800,500));
//			//primaryStage.show();
//			
//
//			
//		
//			
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
		
		
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public static Universidad getU(){
		return U;
	};
	
	
}
