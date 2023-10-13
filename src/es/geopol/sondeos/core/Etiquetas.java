package es.geopol.sondeos.core;

public enum Etiquetas {

	DELIMITADOR_CORRECTA("-"),
	TIPO("TIPO"),
	RETRO("RETRO"),
	FINRETRO("FINRETRO"),
	CLAVE("CLAVE"),
	ETIQUETAS("ETIQUETAS");
	
	private String value;
	
	
	Etiquetas(String string) {
		value = string;
	}
	
	@Override
    public String toString() {
        return value;
    }
}
