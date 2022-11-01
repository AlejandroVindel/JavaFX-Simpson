package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;


public class ControladorAlert {

	Juego juego = new Juego();
    @FXML
    private Button botonalert;

    @FXML
    void salir(ActionEvent event) {
		juego.cierroventananormal(event, botonalert);
    }

}
