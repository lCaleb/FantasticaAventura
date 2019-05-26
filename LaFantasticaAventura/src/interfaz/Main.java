package interfaz;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import model.StartGame;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	private static Stage primaryStage;
	private static GameController gameController;
	private static SelectionController select;
	private static Scene selection;
	private static StartGame start;
	@Override
	public void start(Stage primaryStage) {
			this.primaryStage=primaryStage;
		try {
			FXMLLoader loader= new FXMLLoader(getClass().getResource("Game.fxml"));
			AnchorPane root = (AnchorPane) loader.load();
			Scene scene = new Scene(root,500,500);
			gameController= loader.getController();
			gameController.link(this,start);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.centerOnScreen();
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getSelection() throws IOException {
		FXMLLoader loader= new FXMLLoader(getClass().getResource("Selection.fxml"));
		AnchorPane root=  (AnchorPane) loader.load();
		select= loader.getController();
		select.link(this,start);
		selection= new Scene(root);
		primaryStage.setScene(selection);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
