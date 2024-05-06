package DesafioLogica8;

import java.sql.*;
import java.util.Properties;

public class Conexion {
	

	public static void main(String[] args) {

		insertCines(getConection(), 4,"Yelmo Cartuja", "Sevilla");

	}

	private static Properties getProperties() {

		Properties p = new Properties();
		p.setProperty("user", "root");
		p.setProperty("password", "eze");

		return p;
	}

	private static Connection getConection() {

		final String URL = "jdbc:mysql://localhost:3306/tucine";

		try {

			Connection con = DriverManager.getConnection(URL, getProperties());

			return con;

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;

	}

	public static void insertCines(Connection con,int id, String cineName, String adress) {

		String consulta = "INSERT INTO cines (identificador, nombreCine, direccion) VALUES (?, ?, ?)";

		try (PreparedStatement st = con.prepareStatement(consulta)) {


			st.setInt(1, id);
			st.setString(2, cineName);
			st.setString(3, adress);
			

			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}