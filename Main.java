package paq;

import java.util.*;

import paq1.*;

public class Main {
	static Scanner scLine = new Scanner(System.in);
	static Scanner scInt = new Scanner(System.in);
	static Scanner scDouble = new Scanner(System.in);
	static Animal granja[] = new Animal[7];
	static double lecheTotal = 0;
	static double gananciaTotal = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		granja[0] = new Vaca("Romera", 230.5, 3, "leche");
		granja[1] = new Vaca("Facunda", 205.2, 3, "carne");
		granja[2] = new Vaca("Fina", 245.4, 4, "leche");
		granja[3] = new Cerdo("Petro", 90.2, 2, "rosado");
		granja[4] = new Oveja("Mota", 40.0, 3, "rizado");
		granja[5] = new Oveja("Coral", 50.0, 4, "liso");
		granja[6] = new Oveja("Cebra", 37.6, 1, "rizado");

		do {
			System.out.println("\nMENU PRINCIPAL");
			System.out.println("1.-Marcar animal como muerto");
			System.out.println("2.-Listado de animales completo");
			System.out.println("3.-Listado Completo");
			System.out.println("4.-Mostrar tipo de animal");
			System.out.println("5.-Sumar anyo a un animal");
			System.out.println("6.-Cambiar peso animal");
			System.out.println("7.-Adquirir nuevo cerdo");
			System.out.println("8.-Obtencion de leche");
			System.out.println("9.-Venta de leche");
			System.out.println("Elige una opción (1-9): ");
			int opcion = scInt.nextInt();

			switch (opcion) {
			case 1:

				animalMuerto();
				break;

			case 2:

				listadoDeAnimal();
				break;

			case 3:

				listadoCompleto();
				break;

			case 4:

				mostrarAnimal();
				break;

			case 5:

				sumarAnyo();
				break;

			case 6:
				cambiarPeso();
				break;

			case 7:
				adquirirNuevoCerdo();
				break;

			case 8:
				obtencionLeche();
				break;

			case 9:
				ventaLeche();
				break;
			}

		} while (true);

	}

	private static void ventaLeche() {
		// TODO Auto-generated method stub
		System.out.println("VENTA DE LECHE");
		System.out.println("Leche en stock: " + lecheTotal + "l");
		if (lecheTotal <= 0) {
			System.out.println("No hay leche para vender");
		} else {
			System.out.println("¿Cuánto se quiere vender?");
			double vender = scDouble.nextDouble();
			if (vender > lecheTotal || vender <= 0) {
				System.out.println("cantidad no válida");
			} else {
				double ganancias = vender * 0.5;
				lecheTotal -= vender;
				gananciaTotal += ganancias;
				System.out.println("Ganancias por esta venta: " + ganancias + " euros");
				System.out.println("Ganancias acumuladas: " + gananciaTotal + " euros");
			}

		}

		System.out.println("\nPulsa intro para volver al MENU PRINCIPAL");
		scLine.nextLine();

	}

	private static void obtencionLeche() {
		// TODO Auto-generated method stub
		System.out.println("OBTENCIÓN DE LECHE");
		int vacasVivas = 0;
		double lecheOrdenyada = 0;
		for (int i = 0; i < granja.length; i++) {
			if (granja[i] instanceof Vaca v && v.getUso().equalsIgnoreCase("leche")) {
				vacasVivas++;
				double leche = v.ordenyar();
				lecheOrdenyada += leche;
				System.out.println("Leche obtenida por " + v.getNombre() + ": " + leche + " l");
			}
		}

		if (vacasVivas < 3) {
			int vacasMuertas = 3 - vacasVivas;
			System.out.println("Vacas muertas: " + vacasMuertas);
		}
		lecheTotal += lecheOrdenyada;
		System.out.println("\nPulsa intro para volver al MENU PRINCIPAL");
		scLine.nextLine();

	}

	private static void adquirirNuevoCerdo() {
		// TODO Auto-generated method stub
		System.out.println("ADQUIRIR NUEVO CERDO");
		boolean existeCerdo = false;
		int hueco = -1;
		for (int i = 0; i < granja.length; i++) {
			if (granja[i] instanceof Cerdo) {
				existeCerdo = true;
			}
			if (granja[i] == null && hueco == -1) {
				hueco = i;
			}
		}
		if (existeCerdo) {
			System.out.println("Ya hay un cerdo en la granja");
		} else {
			if (hueco != -1) {
				System.out.println("Introduce los datos del nuevo cerdo");
				System.out.println("Nombre: \n");
				String nombre = scLine.nextLine();

				System.out.println("Peso: \n");
				double peso = scDouble.nextDouble();

				System.out.println("Edad: \n");
				int edad = scInt.nextInt();

				System.out.println("Color de piel: ");
				String color = scLine.nextLine();

				granja[hueco] = new Cerdo(nombre, peso, edad, color);
				System.out.println("Nuevo cerdo añadido");
			}
		}

		System.out.println("\nPulsa intro para volver al MENU PRINCIPAL");
		scLine.nextLine();

	}

	private static void cambiarPeso() {
		// TODO Auto-generated method stub
		System.out.println("CAMBIAR PESO A UN ANIMAL");
		for (int i = 0; i < granja.length; i++) {
			if (granja[i] != null) {

				System.out.println((i + 1) + ".-" + granja[i].getNombre() + " peso: " + granja[i].getPeso() + " Kg");

			}
		}
		System.out.println("Elija el animal");
		int opcion = scInt.nextInt();
		System.out.println("Nuevo Peso?");
		double nuevoPeso = scDouble.nextDouble();

		int indiceReal = opcion - 1;

		if (indiceReal >= 0 && indiceReal < granja.length && granja[indiceReal] != null) {
			double pesoAnterior = granja[indiceReal].getPeso();
			granja[indiceReal].setPeso(nuevoPeso);

			if (nuevoPeso > pesoAnterior) {
				double peso = nuevoPeso - pesoAnterior;
				peso = Math.round(peso * 10.0) / 10.0;
				System.out.println(granja[indiceReal].getNombre() + " ha ganado " + peso + " Kg");

			} else if (nuevoPeso < pesoAnterior) {
				double peso = pesoAnterior - nuevoPeso;
				peso = Math.round(peso * 10.0) / 10.0;

				System.out.println(granja[indiceReal].getNombre() + " ha perdido " + peso + " Kg");
			}

			System.out.println("\nPulsa intro para volver al MENU PRINCIPAL");
			scLine.nextLine();
		}
	}

	private static void sumarAnyo() {
		// TODO Auto-generated method stub
		System.out.println("SUMAR AÑO A UN ANIMAL");

		for (int i = 0; i < granja.length; i++) {
			if (granja[i] != null) {

				System.out.println((i + 1) + ".-" + granja[i].getNombre() + " edad: " + granja[i].getEdad());

			}
		}
		System.out.println("Elija el animal");
		int opcion = scInt.nextInt();

		int indiceReal = opcion - 1;

		if (indiceReal >= 0 && indiceReal < granja.length && granja[indiceReal] != null) {
			int nuevaEdad = granja[indiceReal].getEdad() + 1;
			granja[indiceReal].setEdad(nuevaEdad);
			System.out.println(
					granja[indiceReal].getNombre() + " ahora tiene " + granja[indiceReal].getEdad() + " años");

		}
		System.out.println("\nPulsa intro para volver al MENU PRINCIPAL");
		scLine.nextLine();
	}

	private static void mostrarAnimal() {
		// TODO Auto-generated method stub
		System.out.println("MOSTRAR TIPO ANIMAL");

		int nuevo[] = new int[granja.length];

		for (int i = 0; i < granja.length; i++) {
			if (granja[i] != null) {
				System.out.println((i + 1) + ".-" + granja[i].getNombre());
				nuevo[i] = i;
			}
		}

		System.out.println("Elija el animal: ");
		int opcionA = scInt.nextInt();
		int indiceReal = opcionA - 1;

		if (indiceReal >= 0 && indiceReal < granja.length && granja[indiceReal] != null) {

			if (granja[indiceReal] instanceof Vaca v) {
				System.out.println(v.getNombre() + " es vaca");
			}
			if (granja[indiceReal] instanceof Cerdo c) {
				System.out.println(c.getNombre() + " es cerdo");
			}
			if (granja[indiceReal] instanceof Oveja j) {
				System.out.println(j.getNombre() + " es oveja");
			}

		}

		System.out.println("\nPulsa intro para volver al MENU PRINCIPAL");
		scLine.nextLine();

	}

	private static void listadoCompleto() {
		// TODO Auto-generated method stub
		System.out.println("LISTADO DE ANIMALES COMPLETO");
		for (int i = 0; i < granja.length; i++) {
			if (granja[i] != null) {
				if (granja[i] instanceof Vaca v) {
					System.out.println(
							"Vaca: " + v.getNombre() + " " + v.getPeso() + " kg " + v.getEdad() + " años " + " uso: " + v.getUso());
				}
				if (granja[i] instanceof Cerdo c) {
					System.out.println(
							"Cerdo: " + c.getNombre() + " " + c.getPeso() + " kg " + c.getEdad() + " años " + " color piel: " + c.getColor());
				}
				if (granja[i] instanceof Oveja j) {
					System.out.println("Oveja: " + j.getNombre() + " " + j.getPeso() + " kg " + j.getEdad() + " años"
							+ " tipo de pelo: "+ j.getTipoDePelo());
				}
			}

		}
		System.out.println("\nPulsa intro para volver al MENU PRINCIPAL");
		scLine.nextLine();
	}

	private static void listadoDeAnimal() {
		// TODO Auto-generated method stub
		System.out.println("LISTADO DE ANIMALES");
		for (int i = 0; i < granja.length; i++) {
			if (granja[i] != null) {

				System.out.println(
						granja[i].getNombre() + " : peso: " + granja[i].getPeso() + ", edad: " + granja[i].getEdad());

			}
		}
		System.out.println("\nPulsa intro para volver al MENU PRINCIPAL");
		scLine.nextLine();
	}

	private static void animalMuerto() {
		// TODO Auto-generated method stub
		System.out.println("MARCAR ANIMAL COMO MUERTO");

		int nuevo[] = new int[granja.length];

		for (int i = 0; i < granja.length; i++) {
			if (granja[i] != null) {
				System.out.println((i + 1) + ".-" + granja[i].getNombre());
				nuevo[i] = i;
			}
		}

		System.out.printf("Elije un animal: ");
		int opcion = scInt.nextInt();
		int indiceReal = opcion - 1;
		if (indiceReal >= 0 && indiceReal < granja.length && granja[indiceReal] != null) {
			System.out.println("El animal " + granja[indiceReal].getNombre() + " ha muerto");
			granja[indiceReal] = null;
		} else {
			System.out.println("Opción inválida");
		}
		System.out.println("\nPulsa intro para volver al MENU PRINCIPAL");
		scLine.nextLine();

	}
}



		

