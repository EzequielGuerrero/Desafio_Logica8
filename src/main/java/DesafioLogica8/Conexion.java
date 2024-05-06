package DesafioLogica8;

import java.sql.*;
import java.util.Properties;

public class Conexion {

	private static Properties getProperties() {

		Properties p = new Properties();
		p.setProperty("user", "root");
		p.setProperty("password", "eze");

		return p;
	}

	public Connection getConection() {

		final String URL = "jdbc:mysql://localhost:3306/tucine";

		try {

			Connection con = DriverManager.getConnection(URL, getProperties());

			return con;

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;

	}

	public void insertCines(Connection con, String cineName, String adress) throws SQLException {

		String consulta = "INSERT INTO cines (identificador, nombreCine, direccion) VALUES ( ?,?, ?)";

		try (PreparedStatement st = con.prepareStatement(consulta)) {

			con.setAutoCommit(false);

			st.setInt(1, 0);
			st.setString(2, cineName);
			st.setString(3, adress);

			st.executeUpdate();
			con.commit();
			System.out.println("Insert completado");

		} catch (SQLException e) {
			System.out.println("No se ha podido completar la operacion");
			e.printStackTrace();
			con.rollback();
		}
	}

	public void insertPeliculas(Connection con, String titulo, int duracionMinutos, String genero, String director,
			int clasificacionEdad, int precio) throws SQLException {

		String consulta = "INSERT INTO peliculas (titulo, duracionMinutos, genero,director,clasificacionEdad,precio) VALUES ( ?,?, ?,?,?, ?)";

		try (PreparedStatement st = con.prepareStatement(consulta)) {

			con.setAutoCommit(false);

			st.setString(1, titulo);
			st.setInt(2, duracionMinutos);
			st.setString(3, genero);
			st.setString(4, director);
			st.setInt(5, clasificacionEdad);
			st.setInt(6, precio);

			st.executeUpdate();
			con.commit();
			System.out.println("Insert completado");

		} catch (SQLException e) {
			System.out.println("No se ha podido completar la operacion");
			e.printStackTrace();
			con.rollback();
		}

	}

	public void insertSalas(Connection con, int capacidadPersonas, double superficie) throws SQLException {

		String consulta = "INSERT INTO salas (capacidad, metrosCuadrados) VALUES ( ?, ?)";

		try (PreparedStatement st = con.prepareStatement(consulta)) {

			con.setAutoCommit(false);

			st.setInt(1, capacidadPersonas);
			st.setDouble(2, superficie);

			st.executeUpdate();
			con.commit();
			System.out.println("Insert completado");

		} catch (SQLException e) {
			System.out.println("No se ha podido completar la operacion");
			e.printStackTrace();
			con.rollback();
		}
	}
}