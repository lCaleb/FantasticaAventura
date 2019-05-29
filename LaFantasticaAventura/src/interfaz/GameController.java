package interfaz;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import model.StartGame;

public class GameController {

    @FXML
    private TextField playerName;

    @FXML
    private Button playButton;

    @FXML
    private Button scoreButton;
    
    private String player;
    
    private Main main;
    
 
    private StartGame start;
    
    @FXML
    private AnchorPane anchor;
    
    

    @FXML
    void playButton(ActionEvent event) throws IOException {
    	player=playerName.getText();
    	main.getSelection();
    	//main.getSpace();
    }

    @FXML
    void scoreButton(ActionEvent event) {

    }
    
    public void link(Main main, StartGame start) {
    	this.main=main;
    	this.start=start;
    	player="";
    	
    	ImageView pruebaA= new ImageView(new Image("/Character/frieza/0.png"));

    	pruebaA.setLayoutX(0);
    	pruebaA.setLayoutY(0);
    	SpritePower prueba= new SpritePower();
    	prueba.run(-1);
    	prueba.setLayoutX(150);
    	prueba.setLayoutY(0);
   	
    	
    	
     	anchor.getChildren().add(pruebaA);
     	anchor.getChildren().add(prueba);
     	
    }

}
