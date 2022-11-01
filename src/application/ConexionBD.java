package application;

import java.awt.Label;
import java.awt.TextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
import java.util.Scanner;
import javax.swing.JTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.text.Text;

public class ConexionBD {

	private static ResultSet result;
	private static Statement sentenciaSQL;
	private static Connection conexion;
	private static String sql;
	private static String sql2;
	
	final static String tabla1 = "personajes";
	final static String tabla2 = "preguntas";

	// ------------------------------------CONECTAR------------------

	public static void conectar() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/pf", "root", "1234");
			sentenciaSQL = conexion.createStatement();
		} catch (ClassNotFoundException cn) {
			cn.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	// -------------------------------------DESCONECTAR---------------

	public static void desconectar() {
		try {
			sentenciaSQL.close();
			conexion.close();
		} catch (SQLException ex) {
			System.out.println("<----- ERROR ----->");
		}
	}

	// ------------------MOSTRAR UNA PREGUNTA EN TEXT FIELD------------------

	public void muestropregunta(javafx.scene.control.TextField dametitulo, int id) {
		try {

			conectar();
			// Mostramos la pregunta con la id del parametro
			sentenciaSQL = conexion.createStatement();
			sql = ("SELECT pregunta FROM pf.preguntas where idpregunta=" + id);
			result = sentenciaSQL.executeQuery(sql);

			while (result.next()) {
				dametitulo.setText(result.getString("pregunta"));
				System.out.println(result.getString("pregunta"));

			}

		} catch (Exception e) {
		} finally {
			desconectar();
		}
	}
	
	// ------------------MOSTRAR UNA PREGUNTA EN LAVEL------------------
	public void muestropreguntaX(javafx.scene.control.Label dametitulo, int id) {
		try {
			conectar();
			// Mostramos la pregunta con la id del parametro
			sentenciaSQL = conexion.createStatement();
			sql = ("SELECT pregunta FROM pf.preguntas where idpregunta=" + id);
			result = sentenciaSQL.executeQuery(sql);

			while (result.next()) {
				dametitulo.setText(result.getString("pregunta"));
				System.out.println(result.getString("pregunta"));

			}

		} catch (Exception e) {
		} finally {
			desconectar();
		}
	}

	// SOLO DEJAMOS SEGUIR SI HA CLICKADO EN LAS PREGUNTAS
	public void noRespuestaNoAvanzo(ArrayList<Integer> notas, ActionEvent event, String interfaz, Button btnContinuar) {
		try {
			// CONECTAMOS CON BD
			conectar();
			// MODIFICAMOS BD
			if (notas.size() < 5) {
				Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
				alert.setHeaderText(null);
				alert.setTitle("ACCION DENEGADA");
				alert.setContentText(
						"Debes responder todas las preguntas para continuar. Si no sabes las respuestas cree en el azar!!!");
				Optional<ButtonType> action = alert.showAndWait();
			} else {
				Juego juego = new Juego();
				juego.cierroventananormal(event, btnContinuar);
				juego.abroventananuevanormal(event, interfaz);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			desconectar();
		}
	}
	
	//------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	
	// METODO PARA LLENAR UN ARRAYLIST DE 10 NUMEROS AL
	// AZAR-----------------------------

	public ArrayList<Integer> sacorandoms(ArrayList<Integer> azar) {
		int[] unoaldiez = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
		int i = 0;
		// Sacamos numero al azar
		do {
			int numero = (int) (Math.random() * 10);
			if (unoaldiez[numero] != 0) {
				azar.add(i, numero + 1);
				i++;
				unoaldiez[numero] = 0;
			}
		} while (i < 10);

		System.out.println(azar.toString());

		return azar;
	}

	// METODO PARA LLENAR DE CEROS LOS PUNTOS
	// INICIALES---------------------------------
	public void arrayListIniciales(ArrayList<Double> puntos) {
		try {
			conectar();
			int num = 0;
			sentenciaSQL = conexion.createStatement();
			sql = ("SELECT MAX(idpersonaje) FROM personajes");
			result = sentenciaSQL.executeQuery(sql);

			if (result.next()) {
				num = result.getInt(1);

			}

			for (int i = 0; i < num; i++) {
				puntos.add((double) 1);
			}
			System.out.println(puntos.toString());

		} catch (Exception e) {
		} finally {
			desconectar();
		}
	}

	// METODO PARA COMPARAR LA DIFERENCIA DE LA BARRA CON EL TANTO POR CIENTO DE BD
	public static double comparoRangos(double numbarra, double idpersonaje, int quecolumna) throws SQLException {
		double diferencia = 0;
		double datobd=0;
		sentenciaSQL = conexion.createStatement();
		sql = ("SELECT * from pf.personajes where idpersonaje = "+idpersonaje);
		result = sentenciaSQL.executeQuery(sql);

		if (result.next()) {
			datobd = result.getInt(quecolumna);
		}

		diferencia = numbarra - datobd;

		if (diferencia < 0) {
			diferencia = diferencia * (-1);
		} else {
			diferencia = diferencia;
		}

		return diferencia;
	}

	// METODO PARA SUMAR A CADA PAIS EN FUNCION DE LO QUE COINCIDE
	public static double sumoPuntos(double diferencia) {

		double cuantosumo;
		// Dependiendo de la diferencia entre la caracteristica del personaje y la
		// marcada por el usuario se obtiene mas o menos puntuacion

		if (diferencia <= 10) {
			cuantosumo = 1;
		}
		if (diferencia > 10 && diferencia <= 20) {
			cuantosumo = 0.8;
		}
		if (diferencia > 20 && diferencia <= 30) {
			cuantosumo = 0.5;
		}
		if (diferencia > 30 && diferencia <= 50) {
			cuantosumo = 0.25;
		}

		return diferencia;
	}

	// METODO PARA TENER EN CUENTA LA IMPORTANCIA QUE SE LE DA A UN CAMPO EN LA BASE
	// DE DATOS

	public static double bdTieneEnCuenta(double puntuacion, int idpregunta, int numcolumna, double num) {
		double puntuacionfinal = 0;
		try {

			puntuacionfinal = (puntuacion * num) / 100;

		} catch (Exception e) {
		} finally {
			return puntuacionfinal;
		}

	}

	// METODO QUE CALCULA LA PUNTUACION TOTAL SACADA DE 1 PREGUNTA
	public static double puntoTotalPersonaje(int idpregunta, double numbarra, double idpersonaje) {
		double pfinal = 0;
		try {
			conectar();
			int num = 0;
			int datobd = 0;
			
			double diferencia;
			double puntcolumna;
			double puntconbd;
			// Sacamos el numero de columnas de la tabla preguntas
			sentenciaSQL = conexion.createStatement();
			sql = ("SELECT count( COLUMN_NAME ) FROM INFORMATION_SCHEMA.COLUMNS WHERE table_name = '" + tabla1 + "' ");
			result = sentenciaSQL.executeQuery(sql);

			if (result.next()) {
				num = result.getInt(1);
			}
			
			// Recorremos todas las columnas de una pregunta (obviando la id y el nombre de
			// la pregunta)
			for (int i = 3; i <=num; i++) {
				sql2 = ("SELECT * FROM pf.preguntas WHERE  idpregunta = " + idpregunta);
				//-------------------AQUI HAY ROBLEMA------------------------------------
				result = sentenciaSQL.executeQuery(sql2);
				
				if (result.next()) {
					datobd = (result.getInt(i));
				}
				// Calculamos la difrerencia y la puntuacion

				diferencia = comparoRangos(numbarra, idpersonaje, i+1);
				// Sacamos la puntuacion sin tener en cuenta la importancia que tiene ese campo
				// en la pregunta


				puntcolumna = sumoPuntos(diferencia);
				// Tenemos en cuenta la importancia de ese campo en la pregunta
				puntconbd = bdTieneEnCuenta(puntcolumna, idpregunta, i, datobd);
				// se la sumamos a la total
				pfinal = pfinal + puntconbd;
			}
			

		} catch (Exception e) {
		} finally {
			desconectar();
			return pfinal;
		}
	}

	// METODO PARA SACAR LOS PUNTOS DE TODOS LOS PERSONAJES EN UNA PREGUNTA
	public static void puntosTotalPregunta(ArrayList<Double> puntos, int idpregunta, double numbarra) {
		double puntpersonaje;
		double posicionArrayList = 0;
		
		System.out.println(puntos.size());
		// Recorremos todo el ArrayList para asignar puntuaciones
		for (int cont = 0; cont < puntos.size(); cont++) {
			// Calculamos la puntuacion de un personaje coon el metodo de arriba
			puntpersonaje = puntoTotalPersonaje(idpregunta, numbarra, (cont+1));

			posicionArrayList = puntos.get(cont) + puntpersonaje;
			puntos.set(cont, posicionArrayList);
			
		}
		
		

	}

	// METODO PARA SACAR EL PERSONAJE GANADOR
	public static int personajeGanador(ArrayList<Double> puntuacionFinal) {
		int idPersonaje = 0;

		try {
			// Cogemos el valor máximo de la ArrayList.
			double i = Collections.max(puntuacionFinal);
			
			

			// Buscamos la posicion del valor máximo.
			for (int j = 0; j < puntuacionFinal.size(); j++) {
				if (puntuacionFinal.get(j) == i) {
					idPersonaje = j;
				}
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			return idPersonaje;
		}

	}

	// METODO PARA SACAR EL NOMBRE DEL PERSONAJE FINAL.
	public String guardarPuntuacion(int idPersonaje) {
		String nombrePersonaje = null;

		try {
			// Conectamos con la base de datos.
			conectar();

			sentenciaSQL = conexion.createStatement();
			sql = ("SELECT * FROM pf." + tabla1 + " where idpersonaje='" + idPersonaje + "'");
			result = sentenciaSQL.executeQuery(sql);

			if (result.next()) {

				nombrePersonaje = result.getString(2);

			}

		} catch (Exception e) {

		} finally {

			desconectar();
			return nombrePersonaje;

		}

	}
	
}
