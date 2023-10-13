package es.geopol.sondeos.core;

public class test {

	public static void main(String[] args) {

		String ejemplo = "1. asdkñajsdlakjsdkjasd";
		String []vector = ejemplo.replace(Etiquetas.RETRO.toString().concat(" "),"").split(Etiquetas.FINRETRO.toString(),2);
	}

}
