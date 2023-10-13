package es.geopol.sondeos.core;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JOptionPane;


public class WebexUtils {
	
	static void crearFichero(Cuestionario cuestionario, String nombreFichero, String ruta) {
		
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
				+ "\n\n"
				+ "<POLL TYPE=\"anonymous\" SHOWTIMER=\"yes\" ALARM=\"15:0\" NOANSWER=\"\" SHOWRESPONSE=\"yes\" >\n";
		String footer = "</POLL>";
		String resultado = header;
		for(Pregunta pregunta:cuestionario.getListaPreguntas()) {
			resultado += "<QUESTION TYPE=\"mcone\" TITLE=\""+pregunta.getEnunciado()+"\">\n";
			for(Alternativa alternativa:pregunta.getListaAlternativas()) {
				resultado += "<ANSWER ISCORRECT=\""+alternativa.isCorrecta()+"\">"+alternativa.getTexto()+"</ANSWER>\n";
			}
			resultado += "</QUESTION>\n";
		}
		resultado += footer;
		try {
			Files.write( Paths.get(ruta + "webex\\"+nombreFichero.split("\\.")[0]+".atp"), resultado.getBytes(StandardCharsets.ISO_8859_1));
			JOptionPane.showMessageDialog(null, "Fichero '"+nombreFichero+".atp' creado correctamente", "Éxito", JOptionPane.OK_OPTION);
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al crear el fichero '"+nombreFichero+".atp'", "Error", JOptionPane.OK_OPTION);
		}
	}

}
