package model;

import java.util.ArrayList;

/**
 * @author Victor Alzorriz, Carlos Bernal y Blas Solano
 */

public class Neurona {
	private double resistencia;
	private double tau;
	private double vRep;
	private double vDis;
	private double vReset;
	private double vSpike;
	private double resTemp;
	private double[] listaInt;

	public Neurona(double resistencia, double tau, double vRep, double vDis, double vReset, double vSpike, double resTemp, double[] listaInt) {
		this.resistencia = resistencia;
		this.tau = tau;
		this.vRep = vRep;
		this.vDis = vDis;
		this.vReset = vReset;
		this.vSpike = vSpike;
		this.resTemp = resTemp;
		this.listaInt = listaInt;
	}

	public double[] inFire() {
		ArrayList<Double> arrayY = new ArrayList<Double>();

		arrayY.add(vReset);
		double tiempo = 0.0;

		for (int i = 0; i < listaInt.length; i++) {
			double v = vRep + (resistencia * listaInt[i])
					+ (arrayY.get(i) - vRep - (resistencia * listaInt[i])) * Math.exp((-resTemp) / tau);
			tiempo = tiempo + resTemp;
			if (v >= vDis) {
				System.out.println("Disparo en el milisegundo " + Math.round(tiempo));
				arrayY.add(vSpike);

				arrayY.add(vReset);
				i++;
				tiempo = tiempo + resTemp;
			} else {
				arrayY.add(v);
			}
		}

		return listaArray(arrayY);
	}

	private static double[] listaArray(ArrayList<Double> array) {
		double[] lista = new double[array.size()];

		for (int i = 0; i < array.size(); i++) {
			lista[i] = array.get(i);
		}

		return lista;
	}

	public double getResistencia() {
		return resistencia;
	}

	public void setResistencia(double resistencia) {
		this.resistencia = resistencia;
	}

	public double getTau() {
		return tau;
	}

	public void setTau(double tau) {
		this.tau = tau;
	}

	public double getvRep() {
		return vRep;
	}

	public void setvRep(double vRep) {
		this.vRep = vRep;
	}

	public double getvDis() {
		return vDis;
	}

	public void setvDis(double vDis) {
		this.vDis = vDis;
	}

	public double getvReset() {
		return vReset;
	}

	public void setvReset(double vReset) {
		this.vReset = vReset;
	}

	public double getvSpike() {
		return vSpike;
	}

	public void setvSpike(double vSpike) {
		this.vSpike = vSpike;
	}

	public double getResTemp() {
		return resTemp;
	}

	public void setResTemp(double resTemp) {
		this.resTemp = resTemp;
	}

	public double[] getListaInt() {
		return listaInt;
	}

	public void setListaInt(double[] listaInt) {
		this.listaInt = listaInt;
	}
}
