package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class IA {

	ArrayList<Integer> idValidos = new ArrayList<Integer>();
	ArrayList<Integer> idBasura = new ArrayList<Integer>();
	static ArrayList<Integer> puntos = new ArrayList<Integer>();

	private static ResultSet result;
	private static Statement sentenciaSQL;
	private static Connection conexion;
	private static String sql;

	final static String tabla1 = "personajes";
	final String tabla2 = "preguntas";

	static ConexionBD BD = new ConexionBD();

	

}
