package reyesMagos;

import java.util.ArrayList;

public class Carta {

	private Ninyo ninyo;
	private ReyMago reyMago;
	private ArrayList<Juguete> juguetes;
	private ArrayList<Ninyo> ninyos;
	private ArrayList<ReyMago> reyes;

	public Carta(Ninyo ninyo, ReyMago reyMago, ArrayList<Juguete> juguetes) {
		this.reyMago = reyMago;
		this.juguetes = juguetes;
		this.ninyo = ninyo;
	}

	public ArrayList<Ninyo> getNinyos() {
		return ninyos;
	}

	public void setNinyos(ArrayList<Ninyo> ninyos) {
		this.ninyos = ninyos;
	}

	public Ninyo getNinyo() {
		return ninyo;
	}

	public void setNinyo(Ninyo ninyo) {
		this.ninyo = ninyo;
	}

	public ReyMago getReyMago() {
		return reyMago;
	}

	public void setReyMago(ReyMago reyMago) {
		this.reyMago = reyMago;
	}

	public ArrayList<Juguete> getJuguetes() {
		return juguetes;
	}

	public void setJuguetes(ArrayList<Juguete> juguetes) {
		this.juguetes = juguetes;
	}

	public ArrayList<ReyMago> getReyes() {
		return reyes;
	}

	public void setReyes(ArrayList<ReyMago> reyes) {
		this.reyes = reyes;
	}




	
	

}
