package es.geopol.sondeos.core;
import java.util.ArrayList;
import java.util.List;

public class Cuestionario {
	
	private String contenido;
	
	private List<Pregunta> listaPreguntas;

	public List<Pregunta> getListaPreguntas() {
		return listaPreguntas;
	}

	public void setListaPreguntas(List<Pregunta> listaPreguntas) {
		this.listaPreguntas = listaPreguntas;
	}
	
	public Cuestionario() {
		listaPreguntas = new ArrayList<Pregunta>();
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
}
