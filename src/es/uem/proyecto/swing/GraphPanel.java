package es.uem.proyecto.swing;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import es.uem.proyecto.plotting.Graph;

/**
 * Envuelve los objetos <code>Graph</code> para integrarlos de forma sencilla
 * en una aplicación Java Swing.
 *
 * @author Olly Oechsle, University of Essex, Date: 13-Jun-2007
 * @version 1.00
 */
public class GraphPanel extends JPanel {

	private static final long serialVersionUID = 442612554330256840L;

	/**
     * The graph object renders charts and graphs.
     */
    protected Graph graph;

    /**
     * Initialises the panel with a graph object
     */
    public void setGraph(Graph graph) {
        this.graph = graph;
        repaint();
    }

    /**
     * Draws the graph directly onto the JPanel
     */
    @Override
    public void paintComponent(Graphics g) {
       super.paintComponent(g);
       if (graph != null) graph.draw(g, getWidth(), getHeight());
    }

    /**
     * Returns an image of the graph which can be saved to disk.
     */
    public BufferedImage getImage() {
       return graph != null? graph.getImage(getWidth(), getHeight()) : null;
    }

    /**
     * Provides access to the graph object.
     * @return
     */
    public Graph getGraph() {
        return graph;
    }

}
