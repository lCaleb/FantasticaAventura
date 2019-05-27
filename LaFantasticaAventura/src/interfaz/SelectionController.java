package interfaz;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Sonidos;
import model.StartGame;

public class SelectionController {

	private Sonidos sound;

	@FXML
	private ImageView selecccionadoImage;

	@FXML
	private ImageView gokuImage;

	@FXML
	private ImageView trunksImage;

	@FXML
	private ImageView goldenImage;

	@FXML
	private ImageView continuarImage;

	@FXML
	private ImageView regresarImage;

	private Main main;

	private StartGame start;

	private String seleccionado;

	public void seleccionar() {

		gokuImage.setOnMouseClicked(e -> {
			sound.sonido(Sonidos.CLICK);
			Image img = new Image("/images/source.gif");
			selecccionadoImage.setImage(img);
			gokuImage.setOpacity(1);
			goldenImage.setOpacity(0.3);
			trunksImage.setOpacity(0.3);
		});
		goldenImage.setOnMouseClicked(e -> {
			sound.sonido(Sonidos.CLICK);
			Image img = new Image("/images/12.gif");
			selecccionadoImage.setImage(img);
			gokuImage.setOpacity(0.3);
			goldenImage.setOpacity(1);
			trunksImage.setOpacity(0.3);
		});
		trunksImage.setOnMouseClicked(e -> {
			sound.sonido(Sonidos.CLICK);
			Image img = new Image("/images/tenor.gif");
			selecccionadoImage.setImage(img);
			gokuImage.setOpacity(0.3);
			goldenImage.setOpacity(0.3);
			trunksImage.setOpacity(1);
		});
		continuarImage.setOnMouseClicked(e -> {
			sound.sonido(Sonidos.CLICK);
			try {
				main.getSpace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		regresarImage.setOnMouseClicked(e -> {
			sound.sonido(Sonidos.CLICK);
			main.start(main.getPrimaryStage());
		});
	}

	public void link(Main main, StartGame start) {
		this.main = main;
		this.start = start;
		seleccionar();
		sound= new Sonidos();
	}
}
