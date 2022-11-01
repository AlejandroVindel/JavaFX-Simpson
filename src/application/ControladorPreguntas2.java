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


public class ControladorPreguntas2 implements Initializable{
	ConexionBD bd = new ConexionBD();
	Juego juego = new Juego();
	IA ia = new IA();
	static double barra1;
	static double barra2;
	
	@FXML
	private TextField tf3;
	@FXML
	private TextField tf4;
	@FXML
	private Slider lbl3;
	@FXML
	private Slider lbl4;

	@FXML
	private Button btTerminar;
	
	@FXML
    private Label lb3;
	
    @FXML
    private Label lb4;
    
    @FXML
    private ImageView imgSiguiente;

	public void initialize(URL arg0, ResourceBundle arg1) {
		/*bd.muestropregunta(tf3, ControladorPrograma.preguntaselegidas.get(2));
		bd.muestropregunta(tf4, ControladorPrograma.preguntaselegidas.get(3));*/
		bd.muestropreguntaX(lb3, ControladorPrograma.preguntaselegidas.get(2));
    	bd.muestropreguntaX(lb4, ControladorPrograma.preguntaselegidas.get(3));
		
		System.out.println("pregunta: "+ ControladorPrograma.preguntaselegidas.get(2));
		System.out.println("pregunta: "+ ControladorPrograma.preguntaselegidas.get(3));
	}

	@FXML
	void salirPreguntas2(ActionEvent event) {
		barra1 = (int) lbl3.getValue();
		barra2 = (int) lbl4.getValue();

		bd.puntosTotalPregunta(ControladorPrograma.puntos, ControladorPrograma.preguntaselegidas.get(2), barra1);
		bd.puntosTotalPregunta(ControladorPrograma.puntos, ControladorPrograma.preguntaselegidas.get(3), barra2);


		juego.abroventananuevanormal(event, "/interfazPrograma.fxml");
		juego.cierroventananormal(event, btTerminar);
	}
}
