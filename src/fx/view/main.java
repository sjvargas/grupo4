package fx.view;
	
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
	
	
	public void start(Stage primaryStage) {
		try {
			
			Parent root = FXMLLoader.load(getClass().getResource("AlumnoOverview.fxml"));
			
			primaryStage.setTitle("titulo");
			primaryStage.setScene(new Scene(root,800,500));
			primaryStage.show();
			
			/*
			window = primaryStage;
			
			Label label1 = new Label("Welcome to first scene!");
			
			
			Button btn1 = new Button("Go to scene2"); 
			
			btn1.setOnAction(e -> window.setScene(scene2));
			
			//Layout 1 
			
			VBox layout1 = new VBox(20);
			
			layout1.getChildren().addAll(label1,btn1);
			
			scene1 = new Scene(layout1,200,200);
			
			
			
			
			//Button2
			
			Button btn2 = new Button("This scene sucks, go back to scene1"); 
			
			btn2.setOnAction(e -> window.setScene(scene1));
//layout2
			
			StackPane layout2 = new StackPane();
			
			layout2.getChildren().add(btn2);
			
			scene2 = new Scene(layout2,600,300);
			
			
			window.setScene(scene1);
			window.setTitle("metal");
			window.show();
			*/
		
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
