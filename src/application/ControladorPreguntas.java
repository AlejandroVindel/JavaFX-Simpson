package application;

import application.ControladorPrograma;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ControladorPreguntas implements Initializable{
	ConexionBD bd = new ConexionBD();
	Juego juego = new Juego();
	IA ia = new IA();
	static double barra1;
	static double barra2;
	//----------------------------------------------------------------------------------------------

    @FXML
    private Button btTerminar;

    @FXML
    private Slider lbl1;

    @FXML
    private Slider lbl2;
    
    @FXML
    private Label lb1;
    
    @FXML
    private Label lb2;
    
    @FXML
    private ImageView imgPreguntas;
    
    @FXML
    private ImageView imgSiguiente;
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	/*bd.muestropregunta(tf1, ControladorPrograma.preguntaselegidas.get(0));
    	bd.muestropregunta(tf2, ControladorPrograma.preguntaselegidas.get(1));*/
    	bd.muestropreguntaX(lb1, ControladorPrograma.preguntaselegidas.get(0));
    	bd.muestropreguntaX(lb2, ControladorPrograma.preguntaselegidas.get(1));
    	
    	
    	
	}

    @FXML
    void salirPreguntas(ActionEvent event) {
    	barra1= (int) lbl1.getValue();
    	barra2= (int) lbl2.getValue();
    	
    	bd.puntosTotalPregunta(ControladorPrograma.puntos, ControladorPrograma.preguntaselegidas.get(0), barra1);
    	bd.puntosTotalPregunta(ControladorPrograma.puntos, ControladorPrograma.preguntaselegidas.get(1), barra2);
    	
    	juego.abroventananuevanormal(event, "/interfazPrograma.fxml");
    	juego.cierroventananormal(event, btTerminar);
    }
    
}
