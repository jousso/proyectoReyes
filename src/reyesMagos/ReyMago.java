package reyesMagos;

public class ReyMago {

	private String nombreRey;
	public static int contMelchor;
	public static int contGaspar;	
	public static int contBaltasar;
	
	public ReyMago(String nombreRey) {
		this.nombreRey = nombreRey;
	}

	public String getNombreRey() {
		return nombreRey;
	}

	public void setNombreRey(String nombreRey) {
		this.nombreRey = nombreRey;
	}
	
	public int getContMelchor() {
		return contMelchor;
	}

	public void setContMelchor(int contMelchor) {
		this.contMelchor = contMelchor;
	}

	public int getContGaspar() {
		return contGaspar;
	}

	public void setContGaspar(int contGaspar) {
		this.contGaspar = contGaspar;
	}

	public int getContBaltasar() {
		return contBaltasar;
	}

	public void setContBaltasar(int contBaltasar) {
		this.contBaltasar = contBaltasar;
	}

    public static boolean comprobarRey(String nombreRey) {
        if (nombreRey.toLowerCase().equals("melchor")) {
            contMelchor++;
            return true;
        } else if (nombreRey.toLowerCase().equals("baltasar")) {
            contBaltasar++;
            return true;
        } else if (nombreRey.toLowerCase().equals("gaspar")) {
            contGaspar++;
            return true;
        } else {
            return false;
        }
    }

	

	

	

}
