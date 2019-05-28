package interfaz;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
public class SpriteMonticulo extends ImageView {

	public int posX;
	public int posY;
	public Timeline hilo;
	
	public int shakerInt= 3;
	public SpriteMonticulo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SpriteMonticulo(Image arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	public SpriteMonticulo(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public void shake() {
		hilo = new Timeline(new KeyFrame(Duration.ZERO, e -> {
			setLayoutX(posX+shakerInt);
			setLayoutY(posY+shakerInt);
			shakerInt=shakerInt*-1;
		}), new KeyFrame(Duration.millis(2)));

		hilo.setCycleCount(Animation.INDEFINITE);
		hilo.play();
		
	}
}
