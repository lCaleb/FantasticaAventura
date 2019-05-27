package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import modelo.Empresa;

public class InicioSesionController {
	
	
	@FXML private TextField usuario;
	@FXML private PasswordField password;
	
	private String localSeleccionado;
	
	@FXML private SplitMenuButton localSeleccion;
	@FXML private MenuItem supia1;
	@FXML private MenuItem supia2;
	@FXML private MenuItem RioSucio1;
	@FXML private MenuItem RioSucio2;
	@FXML private MenuItem quinchia;
	
	
	@FXML private Button iniciarSesion;
	private Main main;
	private Empresa empresa;
	
	public void initialize() {
		localSeleccionado="vacio";
		iniciarSesion.setStyle("-fx-background-radius: 30;");
		password.setPromptText("Contraseña");
		usuario.setPromptText("Usuario");
		darFunciones();
	}
	
	public InicioSesionController() {
		
	}
	
	public void enlazar(Main main,Empresa empresa) {
		this.main=main;
		this.empresa= empresa;
	}
	
	public void darFunciones() {
		iniciarSesion.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				if(empresa.validarIngreso(usuario.getText(), password.getText(), localSeleccionado)) {
					main.cargarMenuOpciones(localSeleccionado);
					usuario.setText("");
					password.setText("");
				}else {
					Alert alerta = new Alert(AlertType.ERROR);
					alerta.setContentText("La contraseña y/o el nombre de usuario son incorrectos, ademas verifique que haya seleccionado un local!.");
					alerta.setHeaderText("Error de inicio de sesion");
					alerta.show();
				}
			}
		});
		password.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent e) {
				if (e.getCode()==KeyCode.ENTER&&!localSeleccionado.isEmpty()) {
					
					if(empresa.validarIngreso(usuario.getText(), password.getText(),localSeleccionado)) {
						main.cargarMenuOpciones(localSeleccionado);
						usuario.setText("");
						password.setText("");
					}else {
						Alert alerta = new Alert(AlertType.ERROR);
						alerta.setContentText("La contraseña y/o el nombre de usuario son incorrectos, ademas verifique que haya seleccionado un local!");
						alerta.setHeaderText("Error de inicio de sesion");
						alerta.show();
					}
				}
			}
		});
		
		
		
		supia1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent w) {
				localSeleccionado= empresa.SUPIA_1;
				localSeleccion.setText(empresa.SUPIA_1);
						
			}
			
		});
		supia2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent w) {
				localSeleccionado= empresa.SUPIA_2;
				localSeleccion.setText(empresa.SUPIA_2);
			}
		});
		RioSucio1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent w) {
				localSeleccionado= empresa.RIO_SUCIO1;
				localSeleccion.setText(empresa.RIO_SUCIO1);
			}
		});
		RioSucio2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent w) {
				localSeleccionado= empresa.RIO_SUCIO2;
				localSeleccion.setText(empresa.RIO_SUCIO2);
			}
		});
		quinchia.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent w) {
				localSeleccionado= empresa.QUINCHIA;
				localSeleccion.setText(empresa.QUINCHIA);
			}
		});
	}
	
	
	
	
	
	
	
	
	
	
	
}
