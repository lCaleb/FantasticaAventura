package interfaz;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import model.StartGame;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	private static Stage primaryStage;
	private static GameController gameController;
	private static SelectionController select;
	private static SpaceController space;
	private static ResultadosController resultados;
	private static Scene selection;
	private static Scene spaceScene;
	private static Scene resultScene;
	private static StartGame start;
	@Override
	public void start(Stage primaryStage) throws IOException {
			this.primaryStage=primaryStage;
			start= new StartGame();
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
		primaryStage.centerOnScreen();
		primaryStage.show();
	}
	
	public void getSpace() throws IOException {
		FXMLLoader loader= new FXMLLoader(getClass().getResource("Space.fxml"));
		AnchorPane root=  (AnchorPane) loader.load();
		space= loader.getController();

		spaceScene= new Scene(root);
		space.link(this,start, spaceScene);
		primaryStage.setScene(spaceScene);
		primaryStage.centerOnScreen(); 	
		primaryStage.show();
		
//		spaceScene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
//			public void handle(KeyEvent event) {
//				
//			}
//		});
	}
	
	public void getResultados() throws IOException {
		FXMLLoader loader= new FXMLLoader(getClass().getResource("Results.fxml"));
		AnchorPane root=  (AnchorPane) loader.load();
		resultados= loader.getController();
		resultados.link(this,start);
		resultScene= new Scene(root);
		primaryStage.setScene(resultScene);
		primaryStage.centerOnScreen();
		primaryStage.show();
	}
	
	
	public static Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void setPrimaryStage(Stage primaryStage) {
		Main.primaryStage = primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
