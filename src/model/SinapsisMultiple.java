package model;

import java.util.ArrayList;

public class SinapsisMultiple {

	private Sinapsis sinapsis1;
	private Sinapsis sinapsis2;
	private double iSpike;
	private double tSpike;

	public SinapsisMultiple(Sinapsis sinapsis1, Sinapsis sinapsis2, double iSpike, double tSpike) {
		this.sinapsis1 = sinapsis1;
		this.sinapsis2 = sinapsis2;
		this.iSpike = iSpike;
		this.tSpike = tSpike;
	}

	public double[] sumarEstimulos() {
		ArrayList<Double> arrayInt = new ArrayList<Double>();
		double[] inyectada1 = sinapsis1.inyectada();
		double[] inyectada2 = sinapsis2.inyectada();

		if (inyectada1.length <= inyectada2.length) {
			for (int i = 0; i < inyectada1.length; i++) {
				arrayInt.add(inyectada1[i] + inyectada2[i]);
			}
		} else {
			for (int i = 0; i < inyectada2.length; i++) {
				arrayInt.add(inyectada1[i] + inyectada2[i]);
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

	public Sinapsis getSinapsis1() {
		return sinapsis1;
	}

	public void setSinapsis1(Sinapsis sinapsis1) {
		this.sinapsis1 = sinapsis1;
	}

	public Sinapsis getSinapsis2() {
		return sinapsis2;
	}

	public void setSinapsis2(Sinapsis sinapsis2) {
		this.sinapsis2 = sinapsis2;
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
