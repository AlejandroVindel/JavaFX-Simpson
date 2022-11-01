package application;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ControladorPrograma implements Initializable {
	public static ArrayList<Double> puntos = new ArrayList<Double>();
	static ArrayList<Integer> preguntaselegidas = new ArrayList<Integer>();

	// Contadores para comprobar que preguntas han sido ya respondidas
	static int contvent1 = 0;
	static int contvent2 = 0;
	static int contvent3 = 0;
	static int contvent4 = 0;
	static int contvent5 = 0;
	static int nollenesarraymasveces = 0;

	public static String nombrePersonaje = "";

	Juego juego = new Juego();
	ConexionBD bd = new ConexionBD();
	IA ia = new IA();
	Sonidos musica = new Sonidos();

	@FXML
	private ImageView btReverendo;
	@FXML
	private ImageView btDuff;

	@FXML
	private ImageView btLisa;

	@FXML
	private ImageView btJeff;

	@FXML
	private ImageView btHomer;

	@FXML
	private Button btnSiguiente;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		int personajeGanador;

		if (nollenesarraymasveces == 0) {
			bd.sacorandoms(preguntaselegidas);
			bd.arrayListIniciales(puntos);
			// musica.sonidofondo();
			nollenesarraymasveces++;
		}

		if (contvent1 >= 1 && contvent2 >= 1 && contvent3 >= 1 && contvent4 >= 1 && contvent5 >= 1) {

			personajeGanador = bd.personajeGanador(puntos);
			nombrePersonaje = bd.guardarPuntuacion(personajeGanador);
			System.out.println("El personaje ganador es " + nombrePersonaje);

			juego.abroventananuevanormalini("/InterfazFinal.fxml");
			juego.cierroventananormalini(btnSiguiente);

		}

	}

	@FXML
	void mostrarHomer(MouseEvent event) {
		if (contvent1 < 1) {
			juego.abroventananueva(event, "/InterfazPreguntas1.fxml");
			juego.cierroventana(event, btHomer);
			contvent1++;
		} else {
			juego.abroventananuevanormalini("/AlertPersonalizado.fxml");
		}

	}

	@FXML
	void mostrarJeff(MouseEvent event) {
		if (contvent2 < 1) {
			juego.abroventananueva(event, "/InterfazPreguntas2.fxml");
			juego.cierroventana(event, btJeff);
			contvent2++;
		} else {
			juego.abroventananuevanormalini("/AlertPersonalizado.fxml");
		}
	}

	@FXML
	void mostrarLisa(MouseEvent event) {
		if (contvent3 < 1) {
			juego.abroventananueva(event, "/InterfazPreguntas3.fxml");
			juego.cierroventana(event, btLisa);
			contvent3++;
		} else {
			juego.abroventananuevanormalini("/AlertPersonalizado.fxml");
		}
	}

	@FXML
	void mostrarDuff(MouseEvent event) {
		if (contvent4 < 1) {
			juego.abroventananueva(event, "/InterfazPreguntas4.fxml");
			juego.cierroventana(event, btDuff);
			contvent4++;
		} else {
			juego.abroventananuevanormalini("/AlertPersonalizado.fxml");
		}
	}

	@FXML
	void mostrarReverendo(MouseEvent event) {
		if (contvent5 < 1) {
			juego.abroventananueva(event, "/InterfazPreguntas5.fxml");
			juego.cierroventana(event, btReverendo);
			contvent5++;
		} else {
			juego.abroventananuevanormalini("/AlertPersonalizado.fxml");
		}
	}

	@FXML
	void sacarResultados(ActionEvent event) {
		int personajeGanador;

		personajeGanador = bd.personajeGanador(puntos);

		nombrePersonaje = bd.guardarPuntuacion(personajeGanador);

		System.out.println("El personaje ganador es " + nombrePersonaje);

		juego.abroventananuevanormal(event, "/InterfazFinal.fxml");
		juego.cierroventananormal(event, btnSiguiente);

	}

}
