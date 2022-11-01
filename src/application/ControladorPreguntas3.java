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

public class ControladorPreguntas3 implements Initializable{
	ConexionBD bd = new ConexionBD();
	Juego juego = new Juego();
	IA ia = new IA();
	static double barra1;
	static double barra2;
	
	@FXML
	private Slider lbl5;
	
	@FXML
	private Slider lbl6;

	@FXML
	private Button btTerminar;
	
	@FXML
    private Label lb5;
	
    @FXML
    private Label lb6;
    
    @FXML
    private ImageView imgSiguiente;

	public void initialize(URL arg0, ResourceBundle arg1) {
		/*bd.muestropregunta(tf5, ControladorPrograma.preguntaselegidas.get(4));
		bd.muestropregunta(tf6, ControladorPrograma.preguntaselegidas.get(5));*/
		bd.muestropreguntaX(lb5, ControladorPrograma.preguntaselegidas.get(4));
    	bd.muestropreguntaX(lb6, ControladorPrograma.preguntaselegidas.get(5));
	}

	@FXML
	void salirPreguntas3(ActionEvent event) {
		barra1 = (int) lbl5.getValue();
		barra2 = (int) lbl6.getValue();

		bd.puntosTotalPregunta(ControladorPrograma.puntos, ControladorPrograma.preguntaselegidas.get(4), barra1);
		bd.puntosTotalPregunta(ControladorPrograma.puntos, ControladorPrograma.preguntaselegidas.get(5), barra2);


		juego.abroventananuevanormal(event, "/interfazPrograma.fxml");
		juego.cierroventananormal(event, btTerminar);
	}
}
