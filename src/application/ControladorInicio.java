package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ControladorInicio implements Initializable {

	// Creamos el objeto musica para poder reproducir.
	Sonidos musica = new Sonidos();
	Juego juego = new Juego();

	@FXML
	private ImageView imgComezar;

	@FXML
	private TextField tfNombre;

	@FXML
	private ImageView imgPersonajes;

	@FXML
	void comezarJuego(MouseEvent event) {

		juego.abroventananueva(event, "/InterfazPrograma.fxml");
		juego.cierroventana(event, imgComezar);

		if (tfNombre.getText().length() == 0) {

			juego.abroventananuevanormalini("/AlertPersonalizadoNombre.fxml");

		}
	}

	@FXML
	void verPersonajes(MouseEvent event) {

		juego.abroventananueva(event, "/InterfazPersonajes.fxml");

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		musica.sonidofondo();

	}

}