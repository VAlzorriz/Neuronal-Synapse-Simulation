package model;

import java.util.ArrayList;

public class Sinapsis {

	private Neurona neurona;
	private double iSpike;
	private double tSpike;

	public Sinapsis(Neurona neurona, double iSpike, double tSpike) {
		this.neurona = neurona;
		this.iSpike = iSpike;
		this.tSpike = tSpike;
	}

	public double[] inyectada() {
		ArrayList<Double> arrayInt = new ArrayList<Double>();
		double[] listaInFire = neurona.inFire();

		for (int i = 0; i < listaInFire.length; i++) {
			if (listaInFire[i] >= neurona.getvSpike()) {
				for (double e = 0.0; e <= tSpike; e = e + neurona.getResTemp()) {
					i++;
					arrayInt.add(iSpike);
				}
			} else {
				arrayInt.add(0.0);
			}
		}
		return listaArray(arrayInt);
	}

	private static double[] listaArray(ArrayList<Double> array) {
		double[] lista = new double[array.size()];

		for (int i = 0; i < array.size(); i++) {
			lista[i] = array.get(i);
		}
		return lista;
	}

	public double getiSpike() {
		return iSpike;
	}

	public void setiSpike(double iSpike) {
		this.iSpike = iSpike;
	}

	public double gettSpike() {
		return tSpike;
	}

	public void settSpike(double tSpike) {
		this.tSpike = tSpike;
	}
}
