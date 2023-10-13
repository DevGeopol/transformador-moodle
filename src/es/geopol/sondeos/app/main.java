package es.geopol.sondeos.app;

import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JOptionPane;

import es.geopol.sondeos.core.Cuestionario;
import es.geopol.sondeos.core.GeneradorUtils;

public class main {

	public static String NOMBRE_FICHERO = "TEMA 23 DERECHO FISCAL";

	public static void main(final String[] args) {

		String contenido = null;
		try {
			contenido = Files.readString(Paths.get(System.getProperty("user.dir") + "/resources/txt/" + NOMBRE_FICHERO+".txt"));
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error: Fichero '" + NOMBRE_FICHERO+".txt" + "' no encontrado. \n\nDetalles del error: " + e, "Error",
					JOptionPane.OK_OPTION);
		}
		 
		String ruta = Paths.get(System.getProperty("user.dir")) + "/resources/" ;
	

		if (contenido == null)
			return;

		
		Cuestionario cuestionario = GeneradorUtils.obtenerListaPreguntas(contenido);
		
		GeneradorUtils.crearFichero(cuestionario, NOMBRE_FICHERO, ruta);
	}
}
