package DesafioLogica8;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuGestion {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		Scanner opcMenu = new Scanner(System.in);
		Conexion con = new Conexion();

		System.out.println("Bienvenido al gestor, elige una de las siguientes opciones:");
		System.out.println(" 1. Cines." + "\n 2. Peliculas." + "\n 3. Salas.");

		int opcion = scn.nextInt();

		switch (opcion) {

		case 1:

			insertCines(opcMenu, con);

			break;

		case 2:

			insertPelis(opcMenu, con);
			break;
		case 3:

			insertSalas(opcMenu, con);

			break;

		default:

			System.out.println("Opcion no valida");
			scn.close();
			opcMenu.close();
		}
	}

	private static void insertCines(Scanner opcMenu, Conexion con) {
		try {
			System.out.println("Introduce el nombre del cine que quieres introducir:");
			String nombreCine = opcMenu.nextLine();

			System.out.println("Introduce la dirrecion del cine:");
			String direccion = opcMenu.nextLine();

			con.insertCines(con.getConection(), nombreCine, direccion);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void insertSalas(Scanner opcMenu, Conexion con) {
		try {
			System.out.println("Introduce las caracteristicas de las salas de cine:");

			System.out.println("¿Que capacidad de personas puede contener?");
			int capacidad = opcMenu.nextInt();

			System.out.println("¿Y que superficie tiene la sala?");
			double superficie = opcMenu.nextDouble();

			con.insertSalas(con.getConection(), capacidad, superficie);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("La sala no ha podido ser guardada");
		}
	}

	private static void insertPelis(Scanner opcMenu, Conexion con) {
		try {
			System.out.println("Introduce los datos de la pelicula a introducir:");

			System.out.println("Titulo de la Pelicula:");

			String titulo = opcMenu.nextLine();

			System.out.println("Genero:");
			String genero = opcMenu.nextLine();

			System.out.println("Director:");
			String director = opcMenu.nextLine();

			System.out.println("Duracion de la pelicula:");
			int duracion = opcMenu.nextInt();

			System.out.println("Clasificacion de edad:");
			int clasificacionEdad = opcMenu.nextInt();

			System.out.println("Precio:");
			int precio = opcMenu.nextInt();

			con.insertPeliculas(con.getConection(), titulo, duracion, genero, director, clasificacionEdad, precio);

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("La pelicula no se ha podido introducir en la BD");
		}
	}

}
