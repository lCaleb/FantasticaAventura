package interfaz;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class SpritePower extends ImageView{
	public static final int RIGHT= 1; 
	public static final int LEFT= -1; 
	public int posX;
	public int posY;
	int n= 1;
	public boolean run;
	public Timeline hilo;
	public boolean boom=false;
	public Image[] images= {new Image("/images/power/0.gif"),new Image("/images/power/1.png"),new Image("/images/power/2.png"),new Image("/images/power/3.png"),new Image("/images/power/4.png"),};

	public SpritePower() {
		super();
		// TODO Auto-generated constructor stub
		setFitHeight(50);
		setFitWidth(80);
		run=false;
	}

	public SpritePower(Image arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
		run=false;
	}

	public SpritePower(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
		run=false;
		
	}

	
	public void runPower() {
		
		 hilo = new Timeline(new KeyFrame(Duration.ZERO, e -> {
			setImage(images[n]);
			if (n==4) {
				n=1;
			} else {
				n++;
			}
		}), new KeyFrame(Duration.millis(40)));

		hilo.setCycleCount(Animation.INDEFINITE);
		hilo.play();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
