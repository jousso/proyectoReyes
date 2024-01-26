package reyesMagos;

import java.util.ArrayList;

public class Ninyo {

	private String nombre;

	public Ninyo(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	

	public static boolean haIntroducidoCarta(Ninyo ninyo, ArrayList<Carta> cartas) {
		
		for (Carta carta : cartas) {
			if (carta.getNinyo().getNombre().equals(ninyo.getNombre())) {
				return true;
			}
		}
		return false; 
	}
	
}
