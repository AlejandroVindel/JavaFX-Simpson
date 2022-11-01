package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class ControladorPreguntas4 implements Initializable{
	ConexionBD bd = new ConexionBD();
	Juego juego = new Juego();
	IA ia = new IA();
	static double barra1;
	static double barra2;
	
	@FXML
	private Slider lbl7;
	@FXML
	private Slider lbl8;

	@FXML
	private Button btTerminar;
	
	@FXML
    private Label lb7;
	
    @FXML
    private Label lb8;
    
    @FXML
    private ImageView imgSiguiente;

	public void initialize(URL arg0, ResourceBundle arg1) {
		/*bd.muestropregunta(tf7, ControladorPrograma.preguntaselegidas.get(6));
		bd.muestropregunta(tf8, ControladorPrograma.preguntaselegidas.get(7));*/
		bd.muestropreguntaX(lb7, ControladorPrograma.preguntaselegidas.get(6));
    	bd.muestropreguntaX(lb8, ControladorPrograma.preguntaselegidas.get(7));
	}

	@FXML
	void salirPreguntas4(ActionEvent event) {
		barra1 = (int) lbl7.getValue();
		barra2 = (int) lbl8.getValue();

		bd.puntosTotalPregunta(ControladorPrograma.puntos, ControladorPrograma.preguntaselegidas.get(6), barra1);
		bd.puntosTotalPregunta(ControladorPrograma.puntos, ControladorPrograma.preguntaselegidas.get(7), barra2);

		juego.abroventananuevanormal(event, "/interfazPrograma.fxml");
		juego.cierroventananormal(event, btTerminar);
	}
}
