package controller;

import javax.swing.SwingUtilities;

//import view.VentanaPrincipal;
import view.VentanaPrincipal;

/**
 * @author Victor Alzorriz, Carlos Bernal y Blas Solano
 */

public class Main {
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				
				VentanaPrincipal vp = new VentanaPrincipal();
				ControladorPrincipal cp = new ControladorPrincipal(vp);
				vp.annadirControlador(cp);
			}
		});
		
	}
}
