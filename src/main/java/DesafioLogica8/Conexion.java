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

	public void crearCines(Connection con, String cineName, String adress) throws SQLException {

		String consulta = "INSERT INTO  (nombreCine, direccion) VALUES ( ?, ?)";

		try (PreparedStatement st = con.prepareStatement(consulta)) {

			con.setAutoCommit(false);

			st.setString(1, cineName);
			st.setString(2, adress);

			st.executeUpdate();
			con.commit();
			System.out.println("Insert completado");

		} catch (SQLException e) {
			System.out.println("No se ha podido completar la operacion");
			e.printStackTrace();
			con.rollback();
		}
	}

	public void crearPeliculas(Connection con, String titulo, int duracionMinutos, String genero, String director,
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

	public void crearSalas(Connection con, int capacidadPersonas, double superficie) throws SQLException {

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

	public void eliminarCines(Connection con, int indice) throws SQLException {

		String consultaEliminada = "Delete from cines where identificador = ?";

		try (PreparedStatement pst = con.prepareStatement(consultaEliminada)) {

			con.setAutoCommit(false);

			pst.setInt(1, indice);

			pst.executeUpdate();
			con.commit();
			
			System.out.println("El cine ha sido eliminado");

		} catch (SQLException e) {
			System.out.println("No se ha podido completar la operacion");
			e.printStackTrace();
			con.rollback();
		}
	}

	public void modificarNombreCine(Connection con, int identificador, String nombreCine) throws SQLException {

		String consulta_Update = "UPDATE cines SET nombreCine = ? WHERE identificador = ? ";

		try (PreparedStatement pst = con.prepareStatement(consulta_Update)) {
			
			con.setAutoCommit(false);

			pst.setString(1, nombreCine);
			pst.setInt(2, identificador);

			pst.execute();
			con.commit();
			
			System.out.println("Modificacion realizada");

		} catch (SQLException e) {
			System.out.println("No se ha podido completar la operacion");
			e.printStackTrace();
			con.rollback();
		}
	}
}
