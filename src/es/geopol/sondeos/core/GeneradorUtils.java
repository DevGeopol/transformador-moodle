package es.geopol.sondeos.core;
import java.util.ArrayList;
import java.util.List;

public class GeneradorUtils {

	public static Integer ALTERNATIVAS = 3;
	
	public static String DELIMITADOR = "\r\n|\r|\n";

	public static void crearFichero(Cuestionario cuestionario,String nombreFichero, String ruta) {
		WebexUtils.crearFichero(cuestionario,nombreFichero, ruta);
		MoodleUtils.crearFichero(cuestionario,nombreFichero, ruta);
		//KahootUtils.crearFichero(cuestionario,nombreFichero, ruta);
		TextUtils.crearFichero(cuestionario,nombreFichero, ruta);
	}
	
	public static Cuestionario obtenerListaPreguntas(String cont) {
		cont = cont.replaceAll("\"", "'");
		Pregunta pregunta = null;
		Alternativa alternativa = null;
		Cuestionario cuestionario = new Cuestionario();
		cuestionario.setContenido(cont);
		String linea = "";
		boolean flagRetro = false, flagEtiqueta = false;
			
		while(!cuestionario.getContenido().isEmpty()) {
			
			
			if(cuestionario.getContenido().startsWith(Etiquetas.RETRO.toString())) {
				linea = getRetro(cuestionario);
				flagRetro = true;
			}
			else {
				linea = getLinea(cuestionario);
				flagEtiqueta = linea.startsWith(Etiquetas.ETIQUETAS.toString());
			}
			
			//check tipo
			if(linea.startsWith(Etiquetas.TIPO.toString())) {
				if(linea.contains("PN"))
					ALTERNATIVAS = 3;
				if(linea.contains("GC"))
					ALTERNATIVAS = 4;
				
			}
			else {
				if(linea.startsWith(Etiquetas.CLAVE.toString())) {
					setRespuestas(cuestionario);
					break;
				}
				if (pregunta == null) {
					pregunta = new Pregunta();
					pregunta.setEnunciado(linea);
				}
				else {
					if(flagRetro) {
						pregunta.setRetroalimentacion(linea);
					}
					else {
						if(flagEtiqueta) {
							pregunta.setListaEtiquetas(getListaEtiquetas(linea));
						}
						else {
							if (pregunta.getListaAlternativas().size() < ALTERNATIVAS) {
								alternativa = new Alternativa();
								alternativa.setCorrecta(linea.startsWith(Etiquetas.DELIMITADOR_CORRECTA.toString()));
								if (alternativa.isCorrecta())
									linea = linea.replaceFirst(Etiquetas.DELIMITADOR_CORRECTA.toString(), "");
								alternativa.setTexto(linea);
								pregunta.getListaAlternativas().add(alternativa);
								if (pregunta.getListaAlternativas().size() == ALTERNATIVAS.intValue()) {
									cuestionario.getListaPreguntas().add(pregunta);
									//poner la retro de la pregunta en cada alternativa
									if(!pregunta.getRetroalimentacion().isEmpty()) {
										for(Alternativa alter:pregunta.getListaAlternativas()) {
											alter.setRetro(pregunta.getRetroalimentacion());
										}
									}
									pregunta = null;
								}									
							}
						}
						
					}
				}				
			}
			
			
			flagRetro = false;
			flagEtiqueta = false;
		}		
		return cuestionario;
	}

	private static void setRespuestas(Cuestionario cuestionario) {
		String [] lineas = cuestionario.getContenido().split(DELIMITADOR);
		
		Pregunta pregunta = null;
		int alternativaCorrecta = -1;
		int contadorLineas = 0;
		int contadorPreguntas = -1;
		
		for (contadorLineas = 0; contadorLineas < lineas.length; contadorLineas++) {
			if(!lineas[contadorLineas].isEmpty()) {
				contadorPreguntas++;
				pregunta = cuestionario.getListaPreguntas().get(contadorPreguntas);
				alternativaCorrecta = -1;
				
				if (lineas[contadorLineas].contains("a")) {
					alternativaCorrecta = 0;
				}
				if (lineas[contadorLineas].contains("b")) {
					alternativaCorrecta = 1;
				}
				if (lineas[contadorLineas].contains("c")) {
					alternativaCorrecta = 2;
				}
				if (lineas[contadorLineas].contains("d")) {
					alternativaCorrecta = 3;
				}
				
				if(alternativaCorrecta != -1) {
					pregunta.getListaAlternativas().get(alternativaCorrecta).setCorrecta(true);
				}
			}
			
			
			
		}
	}

	private static List<String> getListaEtiquetas(String linea) {
		String[] vector = linea.replace(Etiquetas.ETIQUETAS.toString().concat(" "),"").split(",");
		List<String> resultado = new ArrayList<String>();
		for(String etiqueta:vector) {
			resultado.add(etiqueta);
		}
		return resultado;
	}

	private static String getRetro(Cuestionario cuestionario) {
		String []vector = cuestionario.getContenido().replaceFirst(Etiquetas.RETRO.toString()/*.concat(" ")*/,"").split(Etiquetas.FINRETRO.toString(),2);
		cuestionario.setContenido(vector[1]);
		return vector[0];
	}

	private static String getLinea(Cuestionario cues) {
		
		
		cues.setContenido(cues.getContenido().trim());
		String []resultado = cues.getContenido().split(DELIMITADOR,2);
		if(resultado.length>1) {
			cues.setContenido(resultado[1]);
		}
		else {
			cues.setContenido("");
		}
		return resultado[0];
	}

}
