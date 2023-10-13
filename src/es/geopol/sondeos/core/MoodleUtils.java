package es.geopol.sondeos.core;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JOptionPane;


public class MoodleUtils {

	public static void crearFichero(Cuestionario cuestionario, String nombreFichero, String ruta) {
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<quiz>";
		String footer = "</quiz>";
		String resultado = header;
		for(Pregunta pregunta:cuestionario.getListaPreguntas()) {
			resultado += "<question type=\"multichoice\">\n"
					+ "    <name><text>"+pregunta.getEnunciado()+"</text></name>\n"
					+ "    <questiontext format=\"html\"><text><![CDATA[<p dir=\"ltr\" style=\"text-align: left;\">"+pregunta.getEnunciado()+"</p>]]></text></questiontext>\n"
					+ "    <generalfeedback format=\"html\"><text><![CDATA[<p dir=\"ltr\" style=\"text-align: left;\">"+pregunta.getRetroalimentacion()+"</p>]]></text></generalfeedback>\n"
					+ "    <generalfeedback format=\"html\"></generalfeedback>\n"
					+ "    <defaultgrade>1.0000000</defaultgrade>\n"
					+ "    <penalty>0.3333333</penalty>\n"
					+ "    <hidden>0</hidden>\n"
					+ "    <idnumber></idnumber>\n"
					+ "    <single>true</single>\n"
					+ "    <shuffleanswers>true</shuffleanswers>\n"
					+ "    <answernumbering>abc</answernumbering>\n"
					+ "    <showstandardinstruction>1</showstandardinstruction>";
			for(Alternativa alternativa:pregunta.getListaAlternativas()) {
				String porcentaje = "-50";
				String textoRetro = "";
				if(!alternativa.getRetro().isEmpty()) {
					textoRetro = "<feedback format=\"html\"><text><![CDATA[<p dir=\"ltr\" style=\"text-align: left;\">"+alternativa.getRetro()+"</p>]]></text></feedback>";
				}
				
				if(pregunta.getListaAlternativas().size()==4)
					porcentaje = "-33.33333";
				if(alternativa.isCorrecta()) {
					porcentaje = "100";
				}
				resultado += "<answer fraction=\""+porcentaje+"\" format=\"html\"><text><![CDATA[<p dir=\"ltr\" style=\"text-align: left;\">"+alternativa.getTexto()+"</p>]]></text>"+textoRetro+"</answer>\n";
			}
			
			resultado += "<tags>";
			for(String etiqueta:pregunta.getListaEtiquetas()) {
				resultado += "<tag><text>"+etiqueta+"</text></tag>";
			}
			
			resultado += "</tags>";
			
			resultado += "</question>";
		}
		resultado += footer;
		//crear fichero y guardarlo con el nombre "sondeo.atp"
		try {
			Files.write( Paths.get(ruta + "moodle\\"+ nombreFichero.split("\\.")[0]+".xml"), resultado.getBytes(StandardCharsets.UTF_8));
			JOptionPane.showMessageDialog(null, "Fichero '"+nombreFichero+".xml' creado correctamente", "Éxito", JOptionPane.OK_OPTION);
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al crear el fichero '"+nombreFichero+".atp'", "Error", JOptionPane.OK_OPTION);
		}

	}

}
