package model;

import java.util.ArrayList;

/**
 * @author Victor Alzorriz, Carlos Bernal y Blas Solano
 */

public class Estimulo {
	private double tIniEstim;
	private double tFinEstim;
	private double tFinSimul;
	private double intensidad;
	private double resTemp;

	public Estimulo(double tIniEstim, double tFinEstim, double tFinSimul, double intensidad, double resTemp) {
		this.tIniEstim = tIniEstim;
		this.tFinEstim = tFinEstim;
		this.tFinSimul = tFinSimul;
		this.intensidad = intensidad;
		this.resTemp = resTemp;
	}

	public double[] estimulo() {
		ArrayList<Double> arrayInt = new ArrayList<Double>();

		for (double i = 0.0; i < tFinSimul; i = i + resTemp) {
			if (i >= tIniEstim && i <= tFinEstim) {
				arrayInt.add(intensidad);
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

	public double gettIniEstim() {
		return tIniEstim;
	}

	public void settIniEstim(double tIniEstim) {
		this.tIniEstim = tIniEstim;
	}

	public double gettFinEstim() {
		return tFinEstim;
	}

	public void settFinEstim(double tFinEstim) {
		this.tFinEstim = tFinEstim;
	}

	public double gettFinSimul() {
		return tFinSimul;
	}

	public void settFinSimul(double tFinSimul) {
		this.tFinSimul = tFinSimul;
	}

	public double getIntensidad() {
		return intensidad;
	}

	public void setIntensidad(double intensidad) {
		this.intensidad = intensidad;
	}

	public double getResTemp() {
		return resTemp;
	}

	public void setResTemp(double resTemp) {
		this.resTemp = resTemp;
	}
}
