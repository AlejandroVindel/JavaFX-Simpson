package application;

import java.io.File;
import java.net.MalformedURLException;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Juego {

	// ESTE METODO CIERRA LA VENTANA TRAS PULSAR UN
	// BOTON----------------------------------------------------------------------------------

	@FXML
	public void cierroventana(MouseEvent event, ImageView btHomer) {

		// selecciona la vista a la que pertenece btn1
		Stage stage = (Stage) btHomer.getScene().getWindow();
		// haciendo .hide cierra la ventana con la opci�n de reabrir la vista
		stage.hide();
	}

	// ESTE METODO ABRE UNA VENTANA AL PULSAR UN
	// BOTON--------------------------------------------------------------------------------------
	public void abroventananueva(MouseEvent event, String ventanaqueabre) {

		try {
			FXMLLoader fxmlLoader = new FXMLLoader(
					getClass().getResource(/* EJEMPLO: "/ventana2.fxml" */ventanaqueabre));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Nueva Vista");
			stage.setScene(new Scene(root1));
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void cierroventananormal(ActionEvent event, Button btTerminar) {

		// selecciona la vista a la que pertenece btn1
		Stage stage = (Stage) btTerminar.getScene().getWindow();
		// haciendo .hide cierra la ventana con la opci�n de reabrir la vista
		stage.hide();
	}

	// ESTE METODO ABRE UNA VENTANA AL PULSAR UN
	// BOTON--------------------------------------------------------------------------------------
	public void abroventananuevanormal(ActionEvent event, String ventanaqueabre) {

		try {
			FXMLLoader fxmlLoader = new FXMLLoader(
					getClass().getResource(/* EJEMPLO: "/ventana2.fxml" */ventanaqueabre));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Nueva Vista");
			stage.setScene(new Scene(root1));
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void cierroventananormalini(Button btTerminar) {
		ActionEvent event;
		// selecciona la vista a la que pertenece btn1
		Stage stage = (Stage) btTerminar.getScene().getWindow();
		// haciendo .hide cierra la ventana con la opci�n de reabrir la vista
		stage.hide();
	}

	// ESTE METODO ABRE UNA VENTANA AL PULSAR UN
	// BOTON--------------------------------------------------------------------------------------
	public void abroventananuevanormalini(String ventanaqueabre) {
		ActionEvent event;
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(
					getClass().getResource(/* EJEMPLO: "/ventana2.fxml" */ventanaqueabre));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Nueva Vista");
			stage.setScene(new Scene(root1));
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//METODO PARA MOSTRAR UNA ALERTA
	public void muestroalerta() {
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setHeaderText(null);
		alert.setTitle("ACCION DENEGADA");
		alert.setContentText("ELIGE OTRA PREGUNTA");
		Optional<ButtonType> action = alert.showAndWait();
	}

}
