package es.uem.proyecto.plotting;

import java.awt.Graphics;

/**
 * <p/>
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
 *
 * @author Olly Oechsle, University of Essex, Date: 13-Jun-2007
 * @version 1.0
 */
public abstract class Plotter {

    public abstract String getName();

    /**
     * Genera una representación gráfica.
     * @param p El objeto <code>Graph</code> a representar.
     * @param g El entorno gráfico.
     * @param chartWidth La anchura de la figura en píxeles.
     * @param chartHeight La altura de la figura en píxeles.
     */
    public abstract void plot(Graph p, Graphics g, int chartWidth, int chartHeight);

}
