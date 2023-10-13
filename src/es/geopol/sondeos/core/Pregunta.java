package es.geopol.sondeos.core;
import java.util.ArrayList;
import java.util.List;

public class Pregunta {

	private String enunciado;
	private List<Alternativa> listaAlternativas;
	private String retroalimentacion;
	private List<String> listaEtiquetas;
	
	public Pregunta() {
		enunciado = "";
		listaAlternativas = new ArrayList<Alternativa>();
		retroalimentacion = "";
		listaEtiquetas = new ArrayList<String>();
	}
		
	public String getEnunciado() {
		return enunciado;
	}
	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}
	public List<Alternativa> getListaAlternativas() {
		return listaAlternativas;
	}
	public void setListaAlternativas(List<Alternativa> listaAlternativas) {
		this.listaAlternativas = listaAlternativas;
	}
	public String getRetroalimentacion() {
		return retroalimentacion;
	}
	public void setRetroalimentacion(String retroalimentacion) {
		this.retroalimentacion = retroalimentacion;
	}
	
	public List<String> getListaEtiquetas() {
		return listaEtiquetas;
	}
	public void setListaEtiquetas(List<String> listaEtiquetas) {
		this.listaEtiquetas = listaEtiquetas;
	}

}
