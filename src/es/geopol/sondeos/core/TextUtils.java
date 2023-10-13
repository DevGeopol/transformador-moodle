package es.geopol.sondeos.core;

public class TextUtils {

	public static void crearFichero(Cuestionario cuestionario, String nombreFichero, String ruta) {
		String[] respuestas = new String[cuestionario.getListaPreguntas().size()];
		int contador = 0;
		for(Pregunta pregunta:cuestionario.getListaPreguntas()) {
			System.out.println(pregunta.getEnunciado());
			System.out.println();
			
			int contAlt = 0;
			String letra = "";
			for(Alternativa alternativa:pregunta.getListaAlternativas()) {
				
				if(contAlt == 0) {
					letra = "a";
				}
				
				if(contAlt == 1) {
					letra = "b";
				}
				
				if(contAlt == 2) {
					letra = "c";
				}
				
				if(contAlt == 3) {
					letra = "d";
				}
				
				if(alternativa.isCorrecta()) {
					respuestas[contador] = letra;
				}
				
				System.out.println(letra+") "+alternativa.getTexto());
				
				contAlt++;
			}
			contador++;
			
			System.out.println();
			System.out.println();
		}
		
		System.out.println("RESPUESTAS SIMULACRO ");
		
		System.out.println();
		
		contador = 0;
		
		for(String respuesta:respuestas) {
			
			System.out.println((contador+1)+". "+respuesta);
			
			contador++;
		}
	}
	

}
