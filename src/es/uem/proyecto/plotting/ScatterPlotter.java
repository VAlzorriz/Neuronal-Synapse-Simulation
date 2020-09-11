package es.uem.proyecto.plotting;

import java.awt.Graphics;

/**
 * <p>
 * Clase para representar gráficos de dispersión (<em>scatter plot</em>), 
 * utilizando la biblioteca <b>JavaPlot</b> de <b>ac.essex.graphing</b>.
 * </p>
 * <p>
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version,
 * provided that any use properly credits the author.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details at http://www.gnu.org
 * </p>
 * @author JM.López
 * @version Dec. 2018
 */
public abstract class ScatterPlotter extends Plotter {

	protected double[] x, y;
	
	/**
	 * Constructor a partir de un array de puntos (x, y).
	 * @param x El array de valores de x (eje de abscisas).
	 * @param y El array de valores de y (eje de ordenadas).
	 */
	public ScatterPlotter(double[] x, double[] y) {
		this.x = x;
		this.y = y;
		if (x.length != y.length)
			System.err.println("Error: las listas de X e Y tienen distinto número de elementos.");
	}
	
	/**
	 * Dibuja una marca en forma de cruz en cada punto (x, y).
	 */
	@Override public void plot(Graph p, Graphics g, int chartWidth, int chartHeight) {
		
		for (int i=0; i<x.length; i++) {
			if (x[i]>p.plotSettings.getMinX() && x[i]<p.plotSettings.getMaxX() && 
					y[i]>p.plotSettings.getMinY() && y[i]<p.plotSettings.getMaxY()) {
				p.drawPoint(g, x[i], y[i]);
			}
		}
		
	}

	public int length() {
		return x.length;
	}
	
	public double getX(int i) {
		return x[i];
	}
	
	public double getY(int i) {
		return y[i];
	}
	
}
