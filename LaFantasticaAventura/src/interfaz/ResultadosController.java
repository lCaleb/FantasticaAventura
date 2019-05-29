package interfaz;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.Priority;
import model.Player;
import model.Sonidos;
import model.StartGame;

public class ResultadosController {

    @FXML
    private ListView<String> nombreList;

    @FXML
    private ListView<String> puntajeLista;
    
    
    private Main main;
    
    private StartGame start;
    
    List<String> listName = new ArrayList<String>();
    
    List<String> listScore = new ArrayList<String>();
   
    ObservableList<String> nameOb ;
    ObservableList<String> scoreOb ;
    
    public void load() {
    	PriorityQueue<Player> queue=start.getQueue();
    	while(!queue.isEmpty()) {
    		String name=queue.peek().getName();
    		String score=""+queue.peek().getScore();
    		listName.add(name);
    		listScore.add(score);
    		queue.poll();
    	}
    	nameOb=FXCollections.observableArrayList(listName);
    	scoreOb=FXCollections.observableArrayList(listScore);
    	nombreList.setItems(nameOb);
    	puntajeLista.setItems(scoreOb);
    }
    
   
    public void link(Main main, StartGame start) {
    	this.main = main;
    	this.start = start;
    	load();
    }
    
}
