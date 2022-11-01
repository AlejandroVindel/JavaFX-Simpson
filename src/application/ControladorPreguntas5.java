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

public class ControladorPreguntas5 implements Initializable{
	ConexionBD bd = new ConexionBD();
	Juego juego = new Juego();
	IA ia = new IA();
	static double barra1;
	static double barra2;
	
	@FXML
	private Slider lbl9;
	
	@FXML
	private Slider lbl10;

	@FXML
	private Button btTerminar;
	
	@FXML
    private Label lb9;
	
    @FXML
    private Label lb10;
    
    @FXML
    private ImageView imgSiguiente;

	public void initialize(URL arg0, ResourceBundle arg1) {
		/*bd.muestropregunta(tf9, ControladorPrograma.preguntaselegidas.get(8));
		bd.muestropregunta(tf10, ControladorPrograma.preguntaselegidas.get(9));*/
		bd.muestropreguntaX(lb9, ControladorPrograma.preguntaselegidas.get(8));
    	bd.muestropreguntaX(lb10, ControladorPrograma.preguntaselegidas.get(9));
	}

	@FXML
	void salirPreguntas5(ActionEvent event) {
		barra1 = (int) lbl9.getValue();
		barra2 = (int) lbl10.getValue();

		bd.puntosTotalPregunta(ControladorPrograma.puntos, ControladorPrograma.preguntaselegidas.get(8), barra1);
		bd.puntosTotalPregunta(ControladorPrograma.puntos, ControladorPrograma.preguntaselegidas.get(9), barra2);
		
		juego.abroventananuevanormal(event, "/InterfazPrograma.fxml");
		juego.cierroventananormal(event, btTerminar);
	}
}
