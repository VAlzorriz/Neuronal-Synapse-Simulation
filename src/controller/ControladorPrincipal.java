
package controller;

import java.awt.Color;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import es.uem.proyecto.plotting.ContinuousFunctionPlotter;
import es.uem.proyecto.plotting.Graph;
import es.uem.proyecto.plotting.PlotSettings;
import es.uem.proyecto.plotting.ScatterPlotter;
import es.uem.proyecto.swing.GraphApplication;
import model.Estimulo;
import model.Neurona;
import model.Sinapsis;
import model.SinapsisMultiple;

/**
 * @author Victor Alzorriz, Carlos Bernal y Blas Solano
 */

public class ControladorPrincipal {

	// private JFrame vp;

	public ControladorPrincipal(JFrame vp) {
		// this.vp = vp;
	}

	public void controladorBotonInFireSinapsisMultiple(String tIniEstim, String tFinEstim, String tFinSimul,
			String intensidad, String resTemp, String resistencia1, String tau1, String vRep1, String vDis1,
			String vReset1, String vSpike1, String resistencia2, String tau2, String vRep2, String vDis2,
			String vReset2, String vSpike2, String resistencia3, String tau3, String vRep3, String vDis3,
			String vReset3, String vSpike3, String iSpike1, String tSpike1, String iSpike2, String tSpike2) {
		if (esNumero(tIniEstim) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor de Tiempo inicio de estimulo no valido",
					"Error al introducir los datos", JOptionPane.ERROR_MESSAGE);
		else if (esNumero(tFinEstim) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor de Tiempo fin de estimulo no valido",
					"Error al introducir los datos", JOptionPane.ERROR_MESSAGE);
		else if (esNumero(tFinSimul) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor de Tiempo fin de simulacion no valido",
					"Error al introducir los datos", JOptionPane.ERROR_MESSAGE);
		else if (esNumero(intensidad) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor de Intensidad no valido",
					"Error al introducir los datos", JOptionPane.ERROR_MESSAGE);
		else if (esNumero(resTemp) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor de Resolucion temporal no valido",
					"Error al introducir los datos", JOptionPane.ERROR_MESSAGE);
		else if (esNumero(resistencia1) == false || esNumero(resistencia2) == false || esNumero(resistencia3) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor de Resistencia no valido",
					"Error al introducir los datos", JOptionPane.ERROR_MESSAGE);
		else if (esNumero(tau1) == false || esNumero(tau2) == false || esNumero(tau3) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor de Tau no valido", "Error al introducir los datos",
					JOptionPane.ERROR_MESSAGE);
		else if (esNumero(vRep1) == false || esNumero(vRep2) == false || esNumero(vRep3) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor Voltaje de reposo no valido",
					"Error al introducir los datos", JOptionPane.ERROR_MESSAGE);
		else if (esNumero(vDis1) == false || esNumero(vDis2) == false || esNumero(vDis3) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor Voltaje de disparo no valido",
					"Error al introducir los datos", JOptionPane.ERROR_MESSAGE);
		else if (esNumero(vReset1) == false || esNumero(vReset2) == false || esNumero(vReset3) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor Voltaje de reset no valido",
					"Error al introducir los datos", JOptionPane.ERROR_MESSAGE);
		else if (esNumero(vSpike1) == false || esNumero(vSpike2) == false || esNumero(vSpike3) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor Voltaje de pico no valido",
					"Error al introducir los datos", JOptionPane.ERROR_MESSAGE);
		else if (esNumero(iSpike1) == false || esNumero(iSpike2) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor Intensidad de pico no valido",
					"Error al introducir los datos", JOptionPane.ERROR_MESSAGE);
		else if (esNumero(tSpike1) == false || esNumero(tSpike2) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor Tiempo de pico no valido",
					"Error al introducir los datos", JOptionPane.ERROR_MESSAGE);
		else {
			Estimulo estimulo = new Estimulo(Double.parseDouble(tIniEstim), Double.parseDouble(tFinEstim),
					Double.parseDouble(tFinSimul), Double.parseDouble(intensidad), Double.parseDouble(resTemp));

			Neurona neurona1 = new Neurona(Double.parseDouble(resistencia1), Double.parseDouble(tau1),
					Double.parseDouble(vRep1), Double.parseDouble(vDis1), Double.parseDouble(vReset1),
					Double.parseDouble(vSpike1), Double.parseDouble(resTemp), estimulo.estimulo());

			Sinapsis sinapsis1 = new Sinapsis(neurona1, Double.parseDouble(iSpike1), Double.parseDouble(tSpike1));

			Neurona neurona2 = new Neurona(Double.parseDouble(resistencia2), Double.parseDouble(tau2),
					Double.parseDouble(vRep2), Double.parseDouble(vDis2), Double.parseDouble(vReset2),
					Double.parseDouble(vSpike2), Double.parseDouble(resTemp), sinapsis1.inyectada());

			Sinapsis sinapsis2 = new Sinapsis(neurona1, Double.parseDouble(iSpike2), Double.parseDouble(tSpike2));

			Sinapsis sinapsis3 = new Sinapsis(neurona2, Double.parseDouble(iSpike2), Double.parseDouble(tSpike2));

			SinapsisMultiple sinapsisMultiple = new SinapsisMultiple(sinapsis2, sinapsis3, Double.parseDouble(iSpike2),
					Double.parseDouble(tSpike2));

			Neurona neurona3 = new Neurona(Double.parseDouble(resistencia3), Double.parseDouble(tau3),
					Double.parseDouble(vRep3), Double.parseDouble(vDis3), Double.parseDouble(vReset3),
					Double.parseDouble(vSpike3), Double.parseDouble(resTemp), sinapsisMultiple.sumarEstimulos());

			graficaInFire(neurona3, estimulo);
		}
	}

	public void controladorBotonEstimuloSinapsisMultiple(String tIniEstim, String tFinEstim, String tFinSimul,
			String intensidad, String resTemp, String resistencia1, String tau1, String vRep1, String vDis1,
			String vReset1, String vSpike1, String resistencia2, String tau2, String vRep2, String vDis2,
			String vReset2, String vSpike2, String iSpike1, String tSpike1, String iSpike2, String tSpike2) {
		if (esNumero(tIniEstim) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor de Tiempo inicio de estimulo no valido",
					"Error al introducir los datos", JOptionPane.ERROR_MESSAGE);
		else if (esNumero(tFinEstim) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor de Tiempo fin de estimulo no valido",
					"Error al introducir los datos", JOptionPane.ERROR_MESSAGE);
		else if (esNumero(tFinSimul) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor de Tiempo fin de simulacion no valido",
					"Error al introducir los datos", JOptionPane.ERROR_MESSAGE);
		else if (esNumero(intensidad) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor de Intensidad no valido",
					"Error al introducir los datos", JOptionPane.ERROR_MESSAGE);
		else if (esNumero(resTemp) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor de Resolucion temporal no valido",
					"Error al introducir los datos", JOptionPane.ERROR_MESSAGE);
		else if (esNumero(resistencia1) == false || esNumero(resistencia2) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor de Resistencia no valido",
					"Error al introducir los datos", JOptionPane.ERROR_MESSAGE);
		else if (esNumero(tau1) == false || esNumero(tau2) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor de Tau no valido", "Error al introducir los datos",
					JOptionPane.ERROR_MESSAGE);
		else if (esNumero(vRep1) == false || esNumero(vRep2) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor Voltaje de reposo no valido",
					"Error al introducir los datos", JOptionPane.ERROR_MESSAGE);
		else if (esNumero(vDis1) == false || esNumero(vDis2) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor Voltaje de disparo no valido",
					"Error al introducir los datos", JOptionPane.ERROR_MESSAGE);
		else if (esNumero(vReset1) == false || esNumero(vReset2) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor Voltaje de reset no valido",
					"Error al introducir los datos", JOptionPane.ERROR_MESSAGE);
		else if (esNumero(vSpike1) == false || esNumero(vSpike2) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor Voltaje de pico no valido",
					"Error al introducir los datos", JOptionPane.ERROR_MESSAGE);
		else if (esNumero(iSpike1) == false || esNumero(iSpike2) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor Intensidad de pico no valido",
					"Error al introducir los datos", JOptionPane.ERROR_MESSAGE);
		else if (esNumero(tSpike1) == false || esNumero(tSpike2) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor Tiempo de pico no valido",
					"Error al introducir los datos", JOptionPane.ERROR_MESSAGE);
		else {
			Estimulo estimulo = new Estimulo(Double.parseDouble(tIniEstim), Double.parseDouble(tFinEstim),
					Double.parseDouble(tFinSimul), Double.parseDouble(intensidad), Double.parseDouble(resTemp));

			Neurona neurona1 = new Neurona(Double.parseDouble(resistencia1), Double.parseDouble(tau1),
					Double.parseDouble(vRep1), Double.parseDouble(vDis1), Double.parseDouble(vReset1),
					Double.parseDouble(vSpike1), Double.parseDouble(resTemp), estimulo.estimulo());

			Sinapsis sinapsis1 = new Sinapsis(neurona1, Double.parseDouble(iSpike1), Double.parseDouble(tSpike1));

			Neurona neurona2 = new Neurona(Double.parseDouble(resistencia2), Double.parseDouble(tau2),
					Double.parseDouble(vRep2), Double.parseDouble(vDis2), Double.parseDouble(vReset2),
					Double.parseDouble(vSpike2), Double.parseDouble(resTemp), sinapsis1.inyectada());

			Sinapsis sinapsis2 = new Sinapsis(neurona1, Double.parseDouble(iSpike2), Double.parseDouble(tSpike2));

			Sinapsis sinapsis3 = new Sinapsis(neurona2, Double.parseDouble(iSpike2), Double.parseDouble(tSpike2));

			SinapsisMultiple sinapsisMultiple = new SinapsisMultiple(sinapsis2, sinapsis3, Double.parseDouble(iSpike2),
					Double.parseDouble(tSpike2));

			graficaSinapsisMultiple(sinapsisMultiple, estimulo);
		}
	}

	public void controladorBotonInFireSinapsis(String tIniEstim, String tFinEstim, String tFinSimul, String intensidad,
			String resTemp, String resistencia1, String tau1, String vRep1, String vDis1, String vReset1,
			String vSpike1, String resistencia2, String tau2, String vRep2, String vDis2, String vReset2,
			String vSpike2, String iSpike, String tSpike) {
		if (esNumero(tIniEstim) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor de Tiempo inicio de estimulo no valido",
					"Error al introducir los datos", JOptionPane.ERROR_MESSAGE);
		else if (esNumero(tFinEstim) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor de Tiempo fin de estimulo no valido",
					"Error al introducir los datos", JOptionPane.ERROR_MESSAGE);
		else if (esNumero(tFinSimul) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor de Tiempo fin de simulacion no valido",
					"Error al introducir los datos", JOptionPane.ERROR_MESSAGE);
		else if (esNumero(intensidad) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor de Intensidad no valido",
					"Error al introducir los datos", JOptionPane.ERROR_MESSAGE);
		else if (esNumero(resTemp) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor de Resolucion temporal no valido",
					"Error al introducir los datos", JOptionPane.ERROR_MESSAGE);
		else if (esNumero(resistencia1) == false || esNumero(resistencia2) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor de Resistencia no valido",
					"Error al introducir los datos", JOptionPane.ERROR_MESSAGE);
		else if (esNumero(tau1) == false || esNumero(tau2) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor de Tau no valido", "Error al introducir los datos",
					JOptionPane.ERROR_MESSAGE);
		else if (esNumero(vRep1) == false || esNumero(vRep2) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor Voltaje de reposo no valido",
					"Error al introducir los datos", JOptionPane.ERROR_MESSAGE);
		else if (esNumero(vDis1) == false || esNumero(vDis2) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor Voltaje de disparo no valido",
					"Error al introducir los datos", JOptionPane.ERROR_MESSAGE);
		else if (esNumero(vReset1) == false || esNumero(vReset2) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor Voltaje de reset no valido",
					"Error al introducir los datos", JOptionPane.ERROR_MESSAGE);
		else if (esNumero(vSpike1) == false || esNumero(vSpike2) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor Voltaje de pico no valido",
					"Error al introducir los datos", JOptionPane.ERROR_MESSAGE);
		else if (esNumero(iSpike) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor Intensidad de pico no valido",
					"Error al introducir los datos", JOptionPane.ERROR_MESSAGE);
		else if (esNumero(tSpike) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor Tiempo de pico no valido",
					"Error al introducir los datos", JOptionPane.ERROR_MESSAGE);
		else {
			Estimulo estimulo = new Estimulo(Double.parseDouble(tIniEstim), Double.parseDouble(tFinEstim),
					Double.parseDouble(tFinSimul), Double.parseDouble(intensidad), Double.parseDouble(resTemp));

			Neurona neurona = new Neurona(Double.parseDouble(resistencia1), Double.parseDouble(tau1),
					Double.parseDouble(vRep1), Double.parseDouble(vDis1), Double.parseDouble(vReset1),
					Double.parseDouble(vSpike1), Double.parseDouble(resTemp), estimulo.estimulo());

			Sinapsis sinapsis = new Sinapsis(neurona, Double.parseDouble(iSpike), Double.parseDouble(tSpike));

			Neurona neurona2 = new Neurona(Double.parseDouble(resistencia2), Double.parseDouble(tau2),
					Double.parseDouble(vRep2), Double.parseDouble(vDis2), Double.parseDouble(vReset2),
					Double.parseDouble(vSpike2), Double.parseDouble(resTemp), sinapsis.inyectada());

			graficaInFire(neurona2, estimulo);
		}
	}

	public void controladorBotonEstimuloSinapsis(String tIniEstim, String tFinEstim, String tFinSimul,
			String intensidad, String resTemp, String resistencia1, String tau1, String vRep1, String vDis1,
			String vReset1, String vSpike1, String iSpike, String tSpike) {
		if (esNumero(tIniEstim) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor de Tiempo inicio de estimulo no valido",
					"Error al introducir los datos", JOptionPane.ERROR_MESSAGE);
		else if (esNumero(tFinEstim) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor de Tiempo fin de estimulo no valido",
					"Error al introducir los datos", JOptionPane.ERROR_MESSAGE);
		else if (esNumero(tFinSimul) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor de Tiempo fin de simulacion no valido",
					"Error al introducir los datos", JOptionPane.ERROR_MESSAGE);
		else if (esNumero(intensidad) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor de Intensidad no valido",
					"Error al introducir los datos", JOptionPane.ERROR_MESSAGE);
		else if (esNumero(resTemp) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor de Resolucion temporal no valido",
					"Error al introducir los datos", JOptionPane.ERROR_MESSAGE);
		else if (esNumero(resistencia1) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor de Resistencia no valido",
					"Error al introducir los datos", JOptionPane.ERROR_MESSAGE);
		else if (esNumero(tau1) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor de Tau no valido", "Error al introducir los datos",
					JOptionPane.ERROR_MESSAGE);
		else if (esNumero(vRep1) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor Voltaje de reposo no valido",
					"Error al introducir los datos", JOptionPane.ERROR_MESSAGE);
		else if (esNumero(vDis1) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor Voltaje de disparo no valido",
					"Error al introducir los datos", JOptionPane.ERROR_MESSAGE);
		else if (esNumero(vReset1) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor Voltaje de reset no valido",
					"Error al introducir los datos", JOptionPane.ERROR_MESSAGE);
		else if (esNumero(vSpike1) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor Voltaje de pico no valido",
					"Error al introducir los datos", JOptionPane.ERROR_MESSAGE);
		else if (esNumero(iSpike) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor Intensidad de pico no valido",
					"Error al introducir los datos", JOptionPane.ERROR_MESSAGE);
		else if (esNumero(tSpike) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor Tiempo de pico no valido",
					"Error al introducir los datos", JOptionPane.ERROR_MESSAGE);
		else {
			Estimulo estimulo = new Estimulo(Double.parseDouble(tIniEstim), Double.parseDouble(tFinEstim),
					Double.parseDouble(tFinSimul), Double.parseDouble(intensidad), Double.parseDouble(resTemp));

			Neurona neurona = new Neurona(Double.parseDouble(resistencia1), Double.parseDouble(tau1),
					Double.parseDouble(vRep1), Double.parseDouble(vDis1), Double.parseDouble(vReset1),
					Double.parseDouble(vSpike1), Double.parseDouble(resTemp), estimulo.estimulo());

			Sinapsis sinapsis = new Sinapsis(neurona, Double.parseDouble(iSpike), Double.parseDouble(tSpike));

			graficaSinapsis(sinapsis, estimulo);
		}
	}

	public void controladorBotonInFire(String tIniEstim, String tFinEstim, String tFinSimul, String intensidad,
			String resTemp, String resistencia, String tau, String vRep, String vDis, String vReset, String vSpike) {
		if (esNumero(tIniEstim) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor de Tiempo inicio de estimulo no valido",
					"Error al introducir los datos", JOptionPane.ERROR_MESSAGE);
		else if (esNumero(tFinEstim) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor de Tiempo fin de estimulo no valido",
					"Error al introducir los datos", JOptionPane.ERROR_MESSAGE);
		else if (esNumero(tFinSimul) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor de Tiempo fin de simulacion no valido",
					"Error al introducir los datos", JOptionPane.ERROR_MESSAGE);
		else if (esNumero(intensidad) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor de Intensidad no valido",
					"Error al introducir los datos", JOptionPane.ERROR_MESSAGE);
		else if (esNumero(resTemp) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor de Resolucion temporal no valido",
					"Error al introducir los datos", JOptionPane.ERROR_MESSAGE);
		else if (esNumero(resistencia) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor de Resistencia no valido",
					"Error al introducir los datos", JOptionPane.ERROR_MESSAGE);
		else if (esNumero(tau) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor de Tau no valido", "Error al introducir los datos",
					JOptionPane.ERROR_MESSAGE);
		else if (esNumero(vRep) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor Voltaje de reposo no valido",
					"Error al introducir los datos", JOptionPane.ERROR_MESSAGE);
		else if (esNumero(vDis) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor Voltaje de disparo no valido",
					"Error al introducir los datos", JOptionPane.ERROR_MESSAGE);
		else if (esNumero(vReset) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor Voltaje de reset no valido",
					"Error al introducir los datos", JOptionPane.ERROR_MESSAGE);
		else if (esNumero(vSpike) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor Voltaje de pico no valido",
					"Error al introducir los datos", JOptionPane.ERROR_MESSAGE);
		else {
			Estimulo estimulo = new Estimulo(Double.parseDouble(tIniEstim), Double.parseDouble(tFinEstim),
					Double.parseDouble(tFinSimul), Double.parseDouble(intensidad), Double.parseDouble(resTemp));

			Neurona neurona = new Neurona(Double.parseDouble(resistencia), Double.parseDouble(tau),
					Double.parseDouble(vRep), Double.parseDouble(vDis), Double.parseDouble(vReset),
					Double.parseDouble(vSpike), Double.parseDouble(resTemp), estimulo.estimulo());

			graficaInFire(neurona, estimulo);
		}
	}

	public void controladorBotonEstimulo(String tIniEstim, String tFinEstim, String tFinSimul, String intensidad,
			String resTemp) {
		if (esNumero(tIniEstim) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor de Tiempo inicio de estimulo no valido",
					"Error al introducir los datos", JOptionPane.ERROR_MESSAGE);
		else if (esNumero(tFinEstim) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor de Tiempo fin de estimulo no valido",
					"Error al introducir los datos", JOptionPane.ERROR_MESSAGE);
		else if (esNumero(tFinSimul) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor de Tiempo fin de simulacion no valido",
					"Error al introducir los datos", JOptionPane.ERROR_MESSAGE);
		else if (esNumero(intensidad) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor de Intensidad no valido",
					"Error al introducir los datos", JOptionPane.ERROR_MESSAGE);
		else if (esNumero(resTemp) == false)
			JOptionPane.showMessageDialog(new JOptionPane(), "Valor de Resolucion temporal no valido",
					"Error al introducir los datos", JOptionPane.ERROR_MESSAGE);
		else {
			Estimulo estimulo = new Estimulo(Double.parseDouble(tIniEstim), Double.parseDouble(tFinEstim),
					Double.parseDouble(tFinSimul), Double.parseDouble(intensidad), Double.parseDouble(resTemp));

			graficaEstimulo(estimulo);
		}
	}

	private void graficaSinapsisMultiple(SinapsisMultiple sinapsisMultiple, Estimulo estimulo) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new GraphApplication(dibujarSinapsisMultiple(sinapsisMultiple.sumarEstimulos(), estimulo.getResTemp(),
						sinapsisMultiple, estimulo));
			}
		});
	}

	private void graficaSinapsis(Sinapsis sinapsis, Estimulo estimulo) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new GraphApplication(dibujarSinapsis(sinapsis.inyectada(), estimulo.getResTemp(), sinapsis, estimulo));
			}
		});
	}

	private void graficaInFire(Neurona neurona, Estimulo estimulo) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new GraphApplication(
						dibujarFire(neurona.inFire(), neurona.getvDis(), neurona.getResTemp(), neurona, estimulo));
			}
		});
	}

	private void graficaEstimulo(Estimulo estimulo) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new GraphApplication(dibujarEstimulo(estimulo.estimulo(), estimulo.getResTemp(), estimulo));
			}
		});
	}

	private static Graph dibujarFire(double[] Y, double vDis, double resTemp, Neurona neurona, Estimulo estimulo) {
		PlotSettings p = new PlotSettings(0, estimulo.gettFinSimul(), neurona.getvReset() - 10.0,
				neurona.getvSpike() + 10.0);
		p.setAxisColor(Color.RED);
		p.setTitle("Potencial de membrana (mV) de la neurona frente al tiempo (ms)");
		p.setGridSpacingX(50);
		p.setGridSpacingY(10);
		p.setNumberFormatterX(new DecimalFormat("0"));
		p.setNumberFormatterY(new DecimalFormat("0"));
		Graph graph = new Graph(p);

		graph.functions.add(new ScatterPlotter(listaX(Y, resTemp), Y) {
			public String getName() {
				return "Potencial de membrana";
			}
		});

		graph.functions.add(new ContinuousFunctionPlotter() {
			public double getY(double x) {
				return (vDis);
			}

			public String getName() {
				return "Potencial Umbral";
			}
		});

		return graph;
	}

	private static Graph dibujarEstimulo(double[] Y, double resTemp, Estimulo estimulo) {
		PlotSettings p = new PlotSettings(0, estimulo.gettFinSimul(), -estimulo.getResTemp(),
				estimulo.getIntensidad() + estimulo.getResTemp());
		p.setAxisColor(Color.RED);
		p.setTitle("Intensidad del estimulo de corriente (nA) inyectada frente al tiempo (ms)");
		p.setGridSpacingX(50);
		p.setGridSpacingY(0.2);
		p.setNumberFormatterX(new DecimalFormat("0"));
		p.setNumberFormatterY(new DecimalFormat("0.0"));
		Graph graph = new Graph(p);

		graph.functions.add(new ScatterPlotter(listaX(Y, resTemp), Y) {
			public String getName() {
				return "Intensidad del estimulo";
			}
		});
		return graph;
	}

	private static Graph dibujarSinapsis(double[] Y, double resTemp, Sinapsis sinapsis, Estimulo estimulo) {
		PlotSettings p = new PlotSettings(0, estimulo.gettFinSimul(), -estimulo.getResTemp(),
				sinapsis.getiSpike() + estimulo.getResTemp());
		p.setAxisColor(Color.RED);
		p.setTitle("Intensidad del estimulo de corriente (nA) inyectada frente al tiempo (ms)");
		p.setGridSpacingX(50);
		p.setGridSpacingY(0.2);
		p.setNumberFormatterX(new DecimalFormat("0"));
		p.setNumberFormatterY(new DecimalFormat("0.0"));
		Graph graph = new Graph(p);

		graph.functions.add(new ScatterPlotter(listaX(Y, resTemp), Y) {
			public String getName() {
				return "Intensidad del estimulo";
			}
		});
		return graph;
	}

	private static Graph dibujarSinapsisMultiple(double[] Y, double resTemp, SinapsisMultiple sinapsisMultiple,
			Estimulo estimulo) {
		PlotSettings p = new PlotSettings(0, estimulo.gettFinSimul(), -estimulo.getResTemp(),
				(sinapsisMultiple.getSinapsis1().getiSpike() + sinapsisMultiple.getSinapsis2().getiSpike())
						+ estimulo.getResTemp());
		p.setAxisColor(Color.RED);
		p.setTitle("Intensidad del estimulo de corriente (nA) inyectada frente al tiempo (ms)");
		p.setGridSpacingX(50);
		p.setGridSpacingY(0.2);
		p.setNumberFormatterX(new DecimalFormat("0"));
		p.setNumberFormatterY(new DecimalFormat("0.0"));
		Graph graph = new Graph(p);

		graph.functions.add(new ScatterPlotter(listaX(Y, resTemp), Y) {
			public String getName() {
				return "Intensidad del estimulo";
			}
		});
		return graph;
	}

	private static double[] listaX(double[] listaY, double resTemp) {
		double[] listaX = new double[listaY.length];

		double e = 0.0;
		for (int i = 0; i < listaY.length; i++) {
			listaX[i] = e;
			e = e + resTemp;
		}

		return listaX;
	}

	private boolean esNumero(String numero) {
		try {
			Double.parseDouble(numero);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private static double[] listaArray(ArrayList<Double> array) {
		double[] lista = new double[array.size()];

		for (int i = 0; i < array.size(); i++) {
			lista[i] = array.get(i);
		}
		return lista;
	}

	public double[] sumarEstimulos(double[] lista1, double[] lista2) {
		ArrayList<Double> array = new ArrayList<Double>();

		for (int i = 0; i < lista1.length; i++) {
			array.add(lista1[i] + lista2[i]);
		}
		return listaArray(array);
	}
}
