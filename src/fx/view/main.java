package fx.view;
	
import java.util.List;

import g4.Profesor;
import g4.Usuario;
import g4.Alumno;
import g4.Administrador_academico;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class main extends Application {
	//@Override
	Stage window;
	Scene scene1,scene2;

	public List<Usuario> usuarios;
	
	
	public void start(Stage primaryStage) {
		try {
			
			Parent root = FXMLLoader.load(getClass().getResource("inicio.fxml"));
			
			primaryStage.setTitle("titulo");
			primaryStage.setScene(new Scene(root,800,500));
			primaryStage.show();
			
			
			//Parent root2 = FXMLLoader.load(getClass().getResource("AdminOverview.fxml"));
			//primaryStage.setScene(new Scene(root2,800,500));
			//primaryStage.show();
			

			
		
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
