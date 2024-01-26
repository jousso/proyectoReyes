package reyesMagos;

public class Juguete {

	private String nombre;
	private String categoria;
	public static int contOcio;
	public static int contEducativo;	
	public static int contDeportivo;
	public static int contVideojuego;

	public Juguete(String nombre, String categoria) {
		this.nombre = nombre;
		this.categoria = categoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public static boolean comCategoria(String categoria) {
	    if (categoria.toLowerCase().equals("ocio")) {
	    	contOcio++;
	        return true;
	    } else if (categoria.toLowerCase().equals("videojuego")) {
	    	contVideojuego++;
	        return true;
	    } else if (categoria.toLowerCase().equals("educativo")) {
	    	contEducativo++;
	        return true;
	    } else if (categoria.toLowerCase().equals("deportivo")) {
	    	contDeportivo++;
	        return true;
	    }
	    return false;
	}

}
