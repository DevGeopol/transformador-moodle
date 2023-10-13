package es.geopol.sondeos.core;

public class Alternativa {
	
	private String texto;
	private boolean isCorrecta;
	private String retro;
	
	public Alternativa() {
		texto = "";
		retro = "";
	}
	
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public boolean isCorrecta() {
		return isCorrecta;
	}
	public void setCorrecta(boolean isCorrecta) {
		this.isCorrecta = isCorrecta;
	}
	public String getRetro() {
		return retro;
	}
	public void setRetro(String retro) {
		this.retro = retro;
	}
}
