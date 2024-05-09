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

		String consulta = "INSERT INTO cines (nombreCine, direccion) VALUES ( ?, ?)";

		try (PreparedStatement st = con.prepareStatement(consulta)) {

			con.setAutoCommit(false);

			st.setString(1, cineName);
			st.setString(2, adress);

			st.executeUpdate();
			con.commit();
			System.out.println("Insert completado");

		} catch (SQLException e) {
			System.err.println("No se ha podido completar la operacion");
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
			System.err.println("No se ha podido completar la operacion");
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
			System.err.println("No se ha podido completar la operacion");
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
			System.err.println("No se ha podido completar la operacion");
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
			System.err.println("No se ha podido completar la operacion");
			e.printStackTrace();
			con.rollback();
		}
	}

	public void leerCines(Connection con) {

		try (Statement st = con.createStatement();) {

			ResultSet rs = st.executeQuery("Select * from cines");

			while (rs.next()) {

				int indice=rs.getInt(1);
				String nombre = rs.getString(2);
				String dire = rs.getString(3);
				
				System.out.println(indice + " | "+ nombre + " | " + dire);
			}

		} catch (SQLException e) {

			System.err.println("No se a podido leer la tabla");
			e.printStackTrace();
		}

	}
	
	public void eliminarPeliculas(Connection con, int indice) throws SQLException {

		String consultaEliminada = "Delete from peliculas where identificador = ?";

		try (PreparedStatement pst = con.prepareStatement(consultaEliminada)) {

			con.setAutoCommit(false);

			pst.setInt(1, indice);

			pst.executeUpdate();
			con.commit();
			

			System.out.println("La pelicula ha sido eliminada");

		} catch (SQLException e) {
			System.err.println("No se ha podido completar la operacion");
			e.printStackTrace();
			con.rollback();
		}
	}
	
	public void modificarNombrePeli(Connection con, int identificador, String nombrePeli) throws SQLException {

		String consulta_Update = "UPDATE peliculas SET titulo = ? WHERE identificador = ? ";

		try (PreparedStatement pst = con.prepareStatement(consulta_Update)) {

			con.setAutoCommit(false);

			pst.setString(1, nombrePeli);
			pst.setInt(2, identificador);

			pst.execute();
			con.commit();

			System.out.println("Modificacion realizada");

		} catch (SQLException e) {
			System.err.println("No se ha podido completar la operacion");
			e.printStackTrace();
			con.rollback();
		}
	}
	
	public void leerPeliculas(Connection con) {

		try (Statement st = con.createStatement();) {

			ResultSet rs = st.executeQuery("Select * from peliculas");

			while (rs.next()) {

				int indice=rs.getInt(1);
				String nombre = rs.getString(2);
				int duracion=rs.getInt(3);
				String genero = rs.getString(4);
				String director = rs.getString(5);
				int pegi=rs.getInt(6);
				int precio=rs.getInt(7);
				
				System.out.println(indice + " | "+ nombre + " | " + duracion+ " | " + genero+ " | " + director+ " | " + pegi + " | " + precio);
			}

		} catch (SQLException e) {

			System.err.println("No se a podido leer la tabla");
			e.printStackTrace();
		}

	}

}
