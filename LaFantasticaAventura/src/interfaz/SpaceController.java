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
	
	public final static int LIMITE_IZQUIERDO =0;
	public final static int LIMITE_DERECHO =-1800;
	public final static int LIMITE_ARRIBA =0;
	public final static int LIMITE_ABAJO =-1200;

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
		space.setLayoutX(-1700);
		space.setLayoutY(-1100);
	}
	
	public void key() {
	//	System.out.println("Pelosss");
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
					
					if (space.getLayoutX()<LIMITE_IZQUIERDO) {
					double posx=space.getLayoutX();
					space.setLayoutX(posx+10);
					}
				}else if (e.getCode()==KeyCode.LEFT) {
					if (space.getLayoutX()>LIMITE_DERECHO) {
					double posx=space.getLayoutX();
					space.setLayoutX(posx-10);
					}
				}else if (e.getCode()==KeyCode.UP) {
					if (space.getLayoutY()>LIMITE_ABAJO) {
					double posY=space.getLayoutY();
					space.setLayoutY(posY-10);
					}
				}else if (e.getCode()==KeyCode.DOWN) {
					if (space.getLayoutY()<LIMITE_ARRIBA) {
					double posY=space.getLayoutY();
					space.setLayoutY(posY+10);
					}
				}
				
				
				
			}
			
		});
		
		
		
		
	}
	
	public boolean checkSpaceLayout() {
		boolean what= false;
		if (space.getLayoutX()<LIMITE_IZQUIERDO&&space.getLayoutX()>LIMITE_DERECHO&&space.getLayoutY()<LIMITE_ARRIBA&&space.getLayoutY()>LIMITE_ABAJO) {
			what= true;
		}
		return what;
	}
	
	public void link(Main main, StartGame start, Scene spaceScene) {
		this.main = main;
		this.start = start;
		this.spaceScene= spaceScene;
		functions();
	}
}
