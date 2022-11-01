package application;

import java.io.File;
import java.net.MalformedURLException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		Parent root;
		try {

			// Aqui ponemos el nombre del fxml
			root = FXMLLoader.load(getClass().getResource("/InterfazInicio.fxml"));
			root.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			// Establecemos el título de la ventana
			primaryStage.setTitle("BUSCA AL PERSONAJE DE LOS SIMPSONS.");
			// Establecemos el ancho y el alto
			primaryStage.setScene(new Scene(root));
			// Mostramos la ventana
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws MalformedURLException {

		launch(args);
	}

}
