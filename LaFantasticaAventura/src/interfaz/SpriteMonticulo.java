package interfaz;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
public class SpriteMonticulo extends ImageView {

	public Timeline hilo;
	public int id;
	public int shakerInt= 3;
	public int boom= 100;
	public int boomStop= 100;
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
			
			if(boom>0) {
			setLayoutX(getLayoutX()+shakerInt);
			setLayoutY(getLayoutY()+shakerInt);
			shakerInt=shakerInt*-1;
			boom--;
			}else {
				if(boom==0) {
					setImage(new Image("/images/power/0.gif"));
					boom--;
				}
				if(boomStop>0) {
					boomStop--;
				}else if(id!=0){
					setImage(new Image("/esferas/"+id+"a.png"));
					setFitHeight(50);
					setFitWidth(50);
				}else {
					hilo.stop();
					setVisible(false);
				}
			}
		}), new KeyFrame(Duration.millis(20)));

		hilo.setCycleCount(Animation.INDEFINITE);
		hilo.play();
		
	}
}
