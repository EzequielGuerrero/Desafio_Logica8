package DesafioLogica8;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuGestion {

	private boolean respuesta = true;

	public MenuGestion() {
		iniciarMenu();
	}

	private void iniciarMenu() {
		Scanner scn = new Scanner(System.in);
		Conexion con = new Conexion();

		while (respuesta) {
			System.out.println("Bienvenido al gestor, elige una de las siguientes opciones:");
			System.out.println(" 1. Cines." + "\n 2. Peliculas." + "\n 3. Salas." + "\n 4. Salir.");

			int opcion = scn.nextInt();
			scn.nextLine();

			switch (opcion) {
			case 1:
				System.out.println("¿Que operacion quieres realizar de las siguientes?:");
				System.out.println(" 1.Crear registro." + "\n 2.Modificar un registro" + "\n 3.Borrar un registro "
						+ "\n 4.Visializar todos los registros de la tabla ");

				int opcionInterna = scn.nextInt();
				scn.nextLine();

				if (opcionInterna == 1) {
					insertCines(scn, con);
				}
				if (opcionInterna == 2) {
					menuModificacion(scn, con);
				}
				if (opcionInterna == 3) {
					menuDeleteCines(scn, con);
				}
				if (opcionInterna == 4) {
					con.leerCines(con.getConection());
				}
				break;

			case 2:
				System.out.println("¿Que operacion quieres realizar de las siguientes?:");
				System.out.println(" 1.Crear registro." + "\n 2.Modificar un registro" + "\n 3.Borrar un registro "
						+ "\n 4.Visializar todos los registros de la tabla ");

				int menuDos = scn.nextInt();
				scn.nextLine();

				if (menuDos == 1) {
					insertPelis(scn, con);
				}
				if (menuDos == 2) {
					modificarPelis(scn, con);
				}
				if (menuDos == 3) {
					eliminarPeli(scn, con);
				}
				if (menuDos == 4) {
					con.leerPeliculas(con.getConection());
				}
				break;

			case 3:
				System.out.println("¿Que operacion quieres realizar de las siguientes?:");
				System.out.println(" 1.Crear registro." + "\n 2.Modificar un registro" + "\n 3.Borrar un registro "
						+ "\n 4.Visializar todos los registros de la tabla ");

				int menuTres = scn.nextInt();
				scn.nextLine();

				if (menuTres == 1) {
					insertSalas(scn, con);
				}
				if (menuTres == 2) {
					actualizarSalas(scn, con);
				}
				if (menuTres == 3) {
					borrarSala(scn, con);
				}
				if (menuTres == 4) {
					con.verSalas(con.getConection());
				}
				break;

			default:

				if (opcion > 3) {
					respuesta = false;
					scn.close();
					System.out.println("Hasta Luego.");

				}
			}
		}
	}

	public static void actualizarSalas(Scanner scn, Conexion con) {
		try {
			System.out.println("Ingresa el indice de la sala a modificar:");
			int indiceMod = scn.nextInt();
			scn.nextLine();

			System.out.println("Ingresa el nuevo tamaño de la sala:");
			int nuevoTamaño = scn.nextInt();
			scn.nextLine();

			con.modificarSalas(con.getConection(), nuevoTamaño, indiceMod);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void borrarSala(Scanner scn, Conexion con) {
		try {
			System.out.println("¿Que sala quieres eliminar?");
			int salaDelete = scn.nextInt();
			scn.nextLine();

			con.eliminarSalas(con.getConection(), salaDelete);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void modificarPelis(Scanner scn, Conexion con) {
		try {
			System.out.println("Introduce el indice de la pelicula a la que deseas cambiar el nombre:");
			int indiceMoficiado = scn.nextInt();
			scn.nextLine();

			System.out.println("Introduce el nuevo nombre:");
			String nuevoNombre = scn.nextLine();

			con.modificarNombrePeli(con.getConection(), indiceMoficiado, nuevoNombre);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void eliminarPeli(Scanner scn, Conexion con) {
		try {
			System.out.println("Introduce el indice de la pelicula a eliminar:");
			int indiceDell = scn.nextInt();
			scn.nextLine();

			con.eliminarPeliculas(con.getConection(), indiceDell);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void menuDeleteCines(Scanner scn, Conexion con) {
		try {
			System.out.println("¿Que numero de cine quieres eliminar?");
			int cineEliminado = scn.nextInt();
			scn.nextLine();

			con.eliminarCines(con.getConection(), cineEliminado);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void menuModificacion(Scanner scn, Conexion con) {
		try {
			System.out.println("Introduce el indice del cine al que deseas cambiar el nombre:");
			int indiceMoficiado = scn.nextInt();
			scn.nextLine(); 

			System.out.println("Introduce el nuevo nombre:");
			String nuevoNombre = scn.nextLine();

			con.modificarNombreCine(con.getConection(), indiceMoficiado, nuevoNombre);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insertCines(Scanner scn, Conexion con) {
		try {
			System.out.println("Introduce el nombre del cine que quieres introducir:");
			String nombre = scn.nextLine();

			System.out.println("Introduce la dirrecion del cine:");
			String direccion = scn.nextLine();

			con.crearCines(con.getConection(), nombre, direccion);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insertSalas(Scanner scn, Conexion con) {
		try {
			System.out.println("Introduce las caracteristicas de las salas de cine:");
			System.out.println("¿Que capacidad de personas puede contener?");
			int capacidad = scn.nextInt();
			scn.nextLine();

			System.out.println("¿Y que superficie tiene la sala?");
			double superficie = scn.nextDouble();
			scn.nextLine();

			con.crearSalas(con.getConection(), capacidad, superficie);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("La sala no ha podido ser guardada");
		}
	}

	public static void insertPelis(Scanner scn, Conexion con) {
		try {
			System.out.println("Introduce los datos de la pelicula a introducir:");
			System.out.println("Titulo de la Pelicula:");
			String titulo = scn.nextLine();

			System.out.println("Genero:");
			String genero = scn.nextLine();

			System.out.println("Director:");
			String director = scn.nextLine();

			System.out.println("Duracion de la pelicula:");
			int duracion = scn.nextInt();
			scn.nextLine();

			System.out.println("Clasificacion de edad:");
			int clasificacionEdad = scn.nextInt();
			scn.nextLine();

			System.out.println("Precio:");
			int precio = scn.nextInt();
			scn.nextLine();

			con.crearPeliculas(con.getConection(), titulo, duracion, genero, director, clasificacionEdad, precio);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("La pelicula no se ha podido introducir en la BD");
		}
	}
}
