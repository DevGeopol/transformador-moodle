package es.geopol.sondeos.core;

public class KahootUtils {

	static void crearFichero(Cuestionario cuestionario, String nombreFichero, String ruta) {

		for (Pregunta pregunta : cuestionario.getListaPreguntas()) {
			System.out.print(pregunta.getEnunciado());
			System.out.print("\t");
			int correcta = 0;
			int contador = 0;
			for (Alternativa alternativa : pregunta.getListaAlternativas()) {
				contador++;
				System.out.print(alternativa.getTexto());
				System.out.print("\t");
				if (alternativa.isCorrecta()) {
					correcta = contador;
				}
			}
			System.out.print("20");
			System.out.print("\t");
			System.out.print(correcta);
			System.out.println();
		}

	}
}
