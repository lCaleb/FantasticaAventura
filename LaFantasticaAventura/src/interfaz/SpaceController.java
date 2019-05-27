package interfaz;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import model.StartGame;

public class SpaceController {

	public Main main;
	public StartGame start;
	

	@FXML 
	private Window win;
	@FXML
	private AnchorPane anchorPane;
	@FXML
	private AnchorPane root;

	@FXML
	private ImageView space;
	@FXML
	private Stage primary;
	@FXML
	private Scene spaceScene;

	public void initialize() {
		
	}
	
	public void key() {
		System.out.println("Pelosss");
//		if (e.getCode()==KeyCode.ENTER) {
//			System.out.println("pelos");
//			double posx=space.getLayoutX();
//			space.setLayoutX(posx+10);
//		}
	}
	public void functions() {
		
		
		spaceScene.setOnKeyPressed(new EventHandler<KeyEvent>(){
			@Override
			public void handle(KeyEvent e) {
				
				if (e.getCode()==KeyCode.RIGHT) {
					
					double posx=space.getLayoutX();
					space.setLayoutX(posx+10);
				}else if (e.getCode()==KeyCode.LEFT) {
					
					double posx=space.getLayoutX();
					space.setLayoutX(posx-10);
				}else if (e.getCode()==KeyCode.UP) {
					
					double posY=space.getLayoutY();
					space.setLayoutY(posY-10);
				}else if (e.getCode()==KeyCode.DOWN) {
					
					double posY=space.getLayoutY();
					space.setLayoutY(posY+10);
				}
				
				
			}
			
		});
		
		
		
		
	}
	
	public void link(Main main, StartGame start, Scene spaceScene) {
		this.main = main;
		this.start = start;
		this.spaceScene= spaceScene;
		functions();
	}
}
