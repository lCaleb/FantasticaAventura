package interfaz;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;
import model.StartGame;

public class SpaceController {
	
	public final static int LIMITE_IZQUIERDO =0;
	public final static int LIMITE_DERECHO =-1800;
	public final static int LIMITE_ARRIBA =0;
	public final static int LIMITE_ABAJO =-1200;

	public Main main;
	public StartGame start;
	
	////////////////////////////////Monticulos///////////////////
	

	    private ImageView[] monticulos;
	

	///////////////////////////////////////////////////////////
	

	@FXML 
	private Window win;
	@FXML
	private AnchorPane anchorPane;
	@FXML
	private AnchorPane root;

	@FXML
	private ImageView space;
	
	@FXML
	private ImageView character;
	@FXML
	private Stage primary;
	@FXML
	private Scene spaceScene;
	
	public static final int SPEED = 3;
	
	public Timeline hilo;

	public void initialize() {
		space.setLayoutX(-900);
		space.setLayoutY(-1100);
		
		
	}
	
	public void key() {

	}
	
	public void cargarMonticulos() {
		for (int i = 0; i<monticulos.length; i++) {
			double posX=space.getLayoutX();
			double posY=space.getLayoutY();	
			int random= (int) (Math.random()*3)+1;
			ImageView img= new ImageView(new Image("/Character/monticulo/"+random+".png"));
			monticulos[i]= img;
			monticulos[i].setFitHeight(130);
			monticulos[i].setFitWidth(100);
			monticulos[i].setLayoutX(posX+start.points[i].getX());
			monticulos[i].setLayoutY(posY+start.points[i].getY());
			anchorPane.getChildren().add(img);
			
		}
	}
	
	public void reloadMonticulos() {
		for (int i = 0; i <monticulos.length; i++) {
			double posX=space.getLayoutX();
			double posY=space.getLayoutY();	
			
			monticulos[i].setLayoutX(posX+start.points[i].getX());
			monticulos[i].setLayoutY(posY+start.points[i].getY());
			
		}
	}
	
	public void functions() {
		
		
		spaceScene.setOnKeyPressed(new EventHandler<KeyEvent>(){
			@Override
			public void handle(KeyEvent e) {
				
				
			
				if (e.getCode()==KeyCode.RIGHT) {
					start.getCharacter().right=true;
					if (space.getLayoutX()>LIMITE_DERECHO) {
					double posx=space.getLayoutX();
					space.setLayoutX(posx-10);
					reloadMonticulos();
					}
					
				}else if (e.getCode()==KeyCode.LEFT) {
					start.getCharacter().left=true;
					if (space.getLayoutX()<LIMITE_IZQUIERDO) {
					double posx=space.getLayoutX();
					space.setLayoutX(posx+10);
					reloadMonticulos();
					}
					
				}else if (e.getCode()==KeyCode.UP) {
					start.getCharacter().up=true;
					if (space.getLayoutY()<LIMITE_ARRIBA) {
					double posY=space.getLayoutY();
					space.setLayoutY(posY+10);
					reloadMonticulos();
					}
					
				}else if (e.getCode()==KeyCode.DOWN) {
					start.getCharacter().down=true;
					if (space.getLayoutY()>LIMITE_ABAJO) {
					double posY=space.getLayoutY();
					space.setLayoutY(posY-10);
					reloadMonticulos();
					}
					
				}
				
				
				
			}
			
		});	
		
		
		spaceScene.setOnKeyReleased(new EventHandler<KeyEvent>(){
			@Override
			public void handle(KeyEvent e) {
				
				if (e.getCode()==KeyCode.RIGHT) {
					start.getCharacter().right=false;
			
				}else if (e.getCode()==KeyCode.LEFT) {
					start.getCharacter().left=false;
				
					
				}else if (e.getCode()==KeyCode.UP) {
					start.getCharacter().up=false;
				
					
				}else if (e.getCode()==KeyCode.DOWN) {
					start.getCharacter().down=false;
				
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
	
	public void perpetumMotus() {
		hilo = new Timeline(new KeyFrame(Duration.ZERO, e -> {
			start.getCharacter().motus();
			character.setImage(new Image(start.getCharacter().url));
			character.setLayoutX(start.getCharacter().x);
			character.setLayoutY(start.getCharacter().y);
			
			
		}), new KeyFrame(Duration.millis(SPEED)));

		hilo.setCycleCount(Animation.INDEFINITE);
		hilo.play();
	}
	
	public void link(Main main, StartGame start, Scene spaceScene) {
		this.main = main;
		this.start = start;
		this.spaceScene= spaceScene;
		monticulos= new ImageView[30];
		functions();
		perpetumMotus();
		cargarMonticulos();
		
	
		
	}
}
