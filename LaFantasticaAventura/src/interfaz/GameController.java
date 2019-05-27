package interfaz;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
    void playButton(ActionEvent event) throws IOException {
    	player=playerName.getText();
    	//main.getSelection();
    	main.getSpace();
    }

    @FXML
    void scoreButton(ActionEvent event) {

    }
    
    public void link(Main main, StartGame start) {
    	this.main=main;
    	this.start=start;
    	player="";
    }

}
