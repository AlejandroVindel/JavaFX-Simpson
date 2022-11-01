package application;

import java.awt.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ControladorPersonajes {

	Juego juego = new Juego();

	@FXML
	private ImageView imgVolver;

	@FXML
	void volverInicio(MouseEvent event) {

		juego.cierroventana(event, imgVolver);

	}

}