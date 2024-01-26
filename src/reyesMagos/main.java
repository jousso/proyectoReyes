package reyesMagos;

import java.util.ArrayList;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// Arrays para almacenar reyes, niños y cartas
		ArrayList<ReyMago> reyes = new ArrayList<>();
		ArrayList<Ninyo> ninyos = new ArrayList<>();
		ArrayList<Carta> cartas = new ArrayList<>();

		// Contadores de niños y juguetes
		int contNinyo = 0;
		int contJuguete = 0;

		boolean salir = false;
		Scanner sc = new Scanner(System.in);

		while (!salir) {
			boolean salir2 = false;
			ArrayList<Juguete> juguetes = new ArrayList<>();

			// Pregunta por el nombre del niño
			System.out.println("¿Como te llamas chiquitin?");
			String sNombreNinyo = sc.nextLine();
			Ninyo nombreNinyo = new Ninyo(sNombreNinyo);
			ninyos.add(nombreNinyo);

			// Verifica si el niño ya ha introducido una carta
			if (Ninyo.haIntroducidoCarta(nombreNinyo, cartas)) {
				System.out.println("\n");
				System.err.println("Ya has introducido una carta chaval, no puedes hacer otra.");
				System.out.println("\n");
				salir = false;
			} else {
				// Pregunta a qué rey le quiere mandar la carta
				System.out.println("¿A qué rey le quieres mandar tu carta?");
				ReyMago reyPref = new ReyMago(sc.nextLine());
				contNinyo++;

				// Verifica si el rey es melchor, gaspar o baltasar
				if (!ReyMago.comprobarRey(reyPref.getNombreRey())) {
					System.out.println("\n");
					System.err.println("Por favor chaval no te inventes reyes nuevos, te toca volver a empezar");
					System.out.println("\n");
					salir = false;
				} else {
					while (!salir2) {
						reyes.add(reyPref);

						// Pregunta qué quiere pedir y de qué categoria es su deseo
						System.out.println(
								"¿Qué quieres pedir? y ¿De qué tipo es tu deseo? (Ocio tradicional, Videojuego, Educativo o Deportivo)");
						Juguete deseos = new Juguete(sc.nextLine(), sc.nextLine());

						// Verifica si la categoría del juguete es ocio, videojuego, educativo o deportivo
						if (Juguete.comCategoria(deseos.getCategoria()) == false) {
							System.out.println("\n");
							System.err.println("Por favor chaval no te inventes categorías");
							System.out.println("\n");
							salir2 = false;
						} else {
							contJuguete++;
							juguetes.add(deseos);

							// Pregunta si quiere pedir más cosas
							System.out.println("¿Quieres pedir mas cosas? s/n");
							String querer = sc.nextLine();
							
							if (querer.toLowerCase().equals("s")) {
								salir2 = false;
							} else if (querer.toLowerCase().equals("n")) {
								salir2 = true;
								// Crea la carta y cambia los videojuegos por libros educativos
								Carta carta = new Carta(nombreNinyo, reyPref, juguetes);
								cartas.add(carta);
								cambiarALibro(carta, juguetes);

								// Muestra la carta al usuario
								for (int i = 0; i < cartas.size(); i++) {
									System.out.println("\n");
									System.out.println("Me llamo: " + cartas.get(i).getNinyo().getNombre());
									System.out.println("Esta carta es para mi rey favorito "
											+ cartas.get(i).getReyMago().getNombreRey());
									System.out.println("Este año te quiero pedir: ");
									for (int j = 0; j < cartas.get(i).getJuguetes().size(); j++) {
										System.out.println(cartas.get(i).getJuguetes().get(j).getNombre());
										System.out.println("Que en la revista de juguetes está en la categoría de: "
												+ cartas.get(i).getJuguetes().get(j).getCategoria());
									}
								}
								System.out.println("\n");

								// Pregunta si quiere introducir más niños
								System.out.println("¿Quieres introducir mas niños? s/n");
								String sa = sc.nextLine();
								if (sa.toLowerCase().equals("s")) {
									salir = false;
								} else {
									// Muestra estadísticas y finaliza el programa
									System.out.println("El porcentaje de niños que han elegido a Melchor: "
											+ calculoMelchor(contNinyo) + "%");
									System.out.println("El porcentaje de niños que han elegido a Gaspar: "
											+ calculoGaspar(contNinyo) + "%");
									System.out.println("El porcentaje de niños que han elegido a Baltasar: "
											+ calculoBaltasar(contNinyo) + "%");
									System.out
											.println("El porcentaje de niños que han elegido la categoria Ocio es de: "
													+ calculOcio(contJuguete) + "%");
									System.out.println(
											"El porcentaje de niños que han elegido la categoria Deportivo es de: "
													+ calculoDeportivo(contJuguete) + "%");
									System.out.println(
											"El porcentaje de niños que han elegido la categoria Educativo es de: "
													+ calculoEducativo(contJuguete) + "%");
									System.out.println(
											"El porcentaje de niños que han elegido la categoria Videojuego es de: "
													+ calculoVideojuego(contJuguete) + "%");
									salir = true;
								}
							}
						}
					}
				}
			}
		}
		sc.close();
	}

	public static void cambiarALibro(Carta ju, ArrayList<Juguete> juguetes) {

		int cont = 0;
		String[] libros = { "Donde viven los monstruos (Maurice Sendak, 1963)",
				"Las aventuras de Alicia en el país de las maravillas (Lewis Carroll, 1865)",
				"Pippi Calzaslargas (Astrid Lindgren, 1945)", "El principito (Antoine de Saint-Exupéry, 1943)",
				"El hobbit (JRR Tolkien, 1937)", "Luces del norte (Philip Pullman, 1995)",
				"El león, la bruja y el armario (CS Lewis, 1950)", "Winnie-the-Pooh (AA Milne y EH Shepard, 1926)",
				"La telaraña de Charlotte (EB White y Garth Williams, 1952)",
				"Matilda (Roald Dahl y Quentin Blake, 1988)" };

		for (int i = 0; i < juguetes.size(); i++) {
			if (ju.getJuguetes().get(i).getCategoria().equals("videojuego")) {
				juguetes.get(i).setNombre(libros[cont++]);
				juguetes.get(i).setCategoria("Educativo");
				cont = (cont + 1) % 10;
			}
		}
	}

	public static int calculoMelchor(int contNinyo) {

		int calculoM = (ReyMago.contMelchor * 100) / contNinyo;

		return calculoM;
	}

	public static int calculoGaspar(int contNinyo) {

		int calculoG = (ReyMago.contGaspar * 100) / contNinyo;

		return calculoG;
	}

	public static int calculoBaltasar(int contNinyo) {

		int calculoB = (ReyMago.contBaltasar * 100) / contNinyo;

		return calculoB;
	}

	public static int calculOcio(int contJuguete) {

		int calculO = (Juguete.contOcio * 100) / contJuguete;

		return calculO;
	}

	public static int calculoDeportivo(int contJuguete) {

		int calculoD = (Juguete.contDeportivo * 100) / contJuguete;

		return calculoD;
	}

	public static int calculoEducativo(int contJuguete) {

		int calculoE = (Juguete.contEducativo * 100) / contJuguete;

		return calculoE;
	}

	public static int calculoVideojuego(int contJuguete) {

		int calculoV = (Juguete.contVideojuego * 100) / contJuguete;

		return calculoV;
	}
}
