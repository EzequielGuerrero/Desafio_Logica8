package DesafioLogica8;

import java.sql.*;
import java.util.Properties;

public class Conexion {

	public static void main(String[] args) {

		insertCines(getConection(), "Yelmo Cadiz", "Jerez");

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

	public static void insertCines(Connection con, String cineName, String adress) {

		String consulta = "INSERT INTO cines (identificador, nombreCine, direccion) VALUES ( ?,?, ?)";

		try (PreparedStatement st = con.prepareStatement(consulta)) {

			st.setInt(1, 0);
			st.setString(2, cineName);
			st.setString(3, adress);

			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}