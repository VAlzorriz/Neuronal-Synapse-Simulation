package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.ControladorPrincipal;

/**
 * @author Victor Alzorriz, Carlos Bernal y Blas Solano
 */

public class VentanaPrincipal extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ControladorPrincipal controlador;

	private Font fuente = new Font("Segoe UI", Font.BOLD, 40);
	private Font fuente2 = new Font("Segoe UI", Font.PLAIN, 30);
	private Font fuente3 = new Font("Segoe UI", Font.PLAIN, 20);

	private JButton botonDefault1 = new JButton("Valores por defecto");
	private JButton botonEstimulo = new JButton("Grafica Estimulo");
	private JButton botonInFire1 = new JButton("Grafica InFire");
	private JButton botonSalir1 = new JButton("Salir");

	private JButton botonDefault2 = new JButton("Valores por defecto");
	private JButton botonEstimuloSinapsis1 = new JButton("Grafica Estimulo Sinapsis");
	private JButton botonInFire2 = new JButton("Grafica InFire");
	private JButton botonSalir2 = new JButton("Salir");

	private JButton botonDefault3 = new JButton("Valores por defecto");
	private JButton botonEstimuloSinapsis2 = new JButton("Grafica Estimulo Sinapsis Multiple");
	private JButton botonInFire3 = new JButton("Grafica InFire");
	private JButton botonSalir3 = new JButton("Salir");

	JPanelEstimulo JPE = new JPanelEstimulo();
	JPanelNeurona JPN1 = new JPanelNeurona();

	JPanelSinapsis JPS1 = new JPanelSinapsis();
	JPanelNeurona JPN2 = new JPanelNeurona();

	JPanelSinapsis JPS2 = new JPanelSinapsis();
	JPanelNeurona JPN3 = new JPanelNeurona();

	public VentanaPrincipal() {
		super("Integracion y Disparo");

		JLabelTitulos titulo1 = new JLabelTitulos("Integracion y Disparo (1º Neurona)");
		JLabel autores1 = new JLabel("Creado por: Victor Alzorriz, Carlos Bernal y Blas Solano");

		JLabelTitulos titulo2 = new JLabelTitulos("Integracion y Disparo (2º Neurona)");
		JLabel autores2 = new JLabel("Creado por: Victor Alzorriz, Carlos Bernal y Blas Solano");

		JLabelTitulos titulo3 = new JLabelTitulos("Integracion y Disparo (3º Neurona)");
		JLabel autores3 = new JLabel("Creado por: Victor Alzorriz, Carlos Bernal y Blas Solano");

		botonDefault1.addActionListener(this);
		botonEstimulo.addActionListener(this);
		botonInFire1.addActionListener(this);
		botonSalir1.addActionListener(this);

		botonDefault2.addActionListener(this);
		botonEstimuloSinapsis1.addActionListener(this);
		botonInFire2.addActionListener(this);
		botonSalir2.addActionListener(this);

		botonDefault3.addActionListener(this);
		botonEstimuloSinapsis2.addActionListener(this);
		botonInFire3.addActionListener(this);
		botonSalir3.addActionListener(this);

		JPanel botonPanel1 = new JPanel();
		botonPanel1.setLayout(new FlowLayout());
		botonPanel1.add(botonDefault1);
		botonPanel1.add(botonEstimulo);
		botonPanel1.add(botonInFire1);
		botonPanel1.add(botonSalir1);

		JPanel botonPanel2 = new JPanel();
		botonPanel2.setLayout(new FlowLayout());
		botonPanel2.add(botonDefault2);
		botonPanel2.add(botonEstimuloSinapsis1);
		botonPanel2.add(botonInFire2);
		botonPanel2.add(botonSalir2);

		JPanel botonPanel3 = new JPanel();
		botonPanel3.setLayout(new FlowLayout());
		botonPanel3.add(botonDefault3);
		botonPanel3.add(botonEstimuloSinapsis2);
		botonPanel3.add(botonInFire3);
		botonPanel3.add(botonSalir3);

		JPanel tituloPanel1 = new JPanel();
		tituloPanel1.setLayout(new FlowLayout());
		tituloPanel1.add(titulo1);

		JPanel tituloPanel2 = new JPanel();
		tituloPanel2.setLayout(new FlowLayout());
		tituloPanel2.add(titulo2);

		JPanel tituloPanel3 = new JPanel();
		tituloPanel3.setLayout(new FlowLayout());
		tituloPanel3.add(titulo3);

		JPanel datosPanel1 = new JPanel();
		datosPanel1.setLayout(new GridLayout(1, 5));
		datosPanel1.add(JPE.JPanelEstimulo());
		datosPanel1.add(JPN1.JPanelNeurona());

		JPanel datosPanel2 = new JPanel();
		datosPanel2.setLayout(new GridLayout(1, 5));
		datosPanel2.add(JPS1.JPanelSinapsis());
		datosPanel2.add(JPN2.JPanelNeurona());

		JPanel datosPanel3 = new JPanel();
		datosPanel3.setLayout(new GridLayout(1, 5));
		datosPanel3.add(JPS2.JPanelSinapsis());
		datosPanel3.add(JPN3.JPanelNeurona());

		JPanel autoresPanel1 = new JPanel();
		autoresPanel1.setLayout(new FlowLayout());
		autoresPanel1.add(autores1);

		JPanel autoresPanel2 = new JPanel();
		autoresPanel2.setLayout(new FlowLayout());
		autoresPanel2.add(autores2);

		JPanel autoresPanel3 = new JPanel();
		autoresPanel3.setLayout(new FlowLayout());
		autoresPanel3.add(autores3);

		JPanel piePanel1 = new JPanel();
		piePanel1.setLayout(new GridLayout(2, 1));
		piePanel1.add(botonPanel1);
		piePanel1.add(autoresPanel1);

		JPanel piePanel2 = new JPanel();
		piePanel2.setLayout(new GridLayout(2, 1));
		piePanel2.add(botonPanel2);
		piePanel2.add(autoresPanel2);

		JPanel piePanel3 = new JPanel();
		piePanel3.setLayout(new GridLayout(2, 1));
		piePanel3.add(botonPanel3);
		piePanel3.add(autoresPanel3);

		JPanel mainPanel1 = new JPanel();
		mainPanel1.setLayout(new BorderLayout());
		mainPanel1.add(tituloPanel1, BorderLayout.NORTH);
		mainPanel1.add(datosPanel1, BorderLayout.CENTER);
		mainPanel1.add(piePanel1, BorderLayout.SOUTH);

		JPanel mainPanel2 = new JPanel();
		mainPanel2.setLayout(new BorderLayout());
		mainPanel2.add(tituloPanel2, BorderLayout.NORTH);
		mainPanel2.add(datosPanel2, BorderLayout.CENTER);
		mainPanel2.add(piePanel2, BorderLayout.SOUTH);

		JPanel mainPanel3 = new JPanel();
		mainPanel3.setLayout(new BorderLayout());
		mainPanel3.add(tituloPanel3, BorderLayout.NORTH);
		mainPanel3.add(datosPanel3, BorderLayout.CENTER);
		mainPanel3.add(piePanel3, BorderLayout.SOUTH);

		JTabbedPane tabbedPanel = new JTabbedPane();

		tabbedPanel.addTab("Neurona Primaria", mainPanel1);
		tabbedPanel.addTab("Neurona Segundaria", mainPanel2);
		tabbedPanel.addTab("Neurona Terciaria", mainPanel3);

		add(tabbedPanel);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setSize(new Dimension(1300, 480));

		setVisible(true);
	}

	public void annadirControlador(ControladorPrincipal controlador) {
		this.controlador = controlador;
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == botonDefault1) {
			System.out.println("Boton Default 1");
			JPE.setDefault();
			JPN1.setDefault();
		}

		if (arg0.getSource() == botonDefault2) {
			System.out.println("Boton Default 2");
			JPS1.setDefault();
			JPN2.setDefault();
		}

		if (arg0.getSource() == botonDefault3) {
			System.out.println("Boton Default 3");
			JPS2.setDefault();
			JPN3.setDefault();
		}

		if (arg0.getSource() == botonEstimulo) {
			System.out.println("Boton Estimulo");
			controlador.controladorBotonEstimulo(JPE.gettIniEstim(), JPE.gettFinEstim(), JPE.gettFinSimul(),
					JPE.getIntensidad(), JPE.getResTemp());
		}

		if (arg0.getSource() == botonEstimuloSinapsis1) {
			controlador.controladorBotonEstimuloSinapsis(JPE.gettIniEstim(), JPE.gettFinEstim(), JPE.gettFinSimul(),
					JPE.getIntensidad(), JPE.getResTemp(), JPN1.getResistencia(), JPN1.getTau(), JPN1.getvRep(),
					JPN1.getvDis(), JPN1.getvReset(), JPN1.getvSpike(), JPS1.getiSpike(), JPS1.gettSpike());
		}

		if (arg0.getSource() == botonEstimuloSinapsis2) {
			controlador.controladorBotonEstimuloSinapsisMultiple(JPE.gettIniEstim(), JPE.gettFinEstim(), JPE.gettFinSimul(),
					JPE.getIntensidad(), JPE.getResTemp(), JPN1.getResistencia(), JPN1.getTau(), JPN1.getvRep(),
					JPN1.getvDis(), JPN1.getvReset(), JPN1.getvSpike(), JPN2.getResistencia(), JPN2.getTau(), JPN2.getvRep(),
					JPN2.getvDis(), JPN2.getvReset(), JPN2.getvSpike(), JPS1.getiSpike(), JPS1.gettSpike(), JPS2.getiSpike(), JPS2.gettSpike());
		}

		if (arg0.getSource() == botonInFire1) {
			System.out.println("Boton InFire");
			controlador.controladorBotonInFire(JPE.gettIniEstim(), JPE.gettFinEstim(), JPE.gettFinSimul(),
					JPE.getIntensidad(), JPE.getResTemp(), JPN1.getResistencia(), JPN1.getTau(), JPN1.getvRep(),
					JPN1.getvDis(), JPN1.getvReset(), JPN1.getvSpike());
		}

		if (arg0.getSource() == botonInFire2) {
			System.out.println("Boton InFire");
			controlador.controladorBotonInFireSinapsis(JPE.gettIniEstim(), JPE.gettFinEstim(), JPE.gettFinSimul(),
					JPE.getIntensidad(), JPE.getResTemp(), JPN1.getResistencia(), JPN1.getTau(), JPN1.getvRep(),
					JPN1.getvDis(), JPN1.getvReset(), JPN1.getvSpike(), JPN2.getResistencia(), JPN2.getTau(),
					JPN2.getvRep(), JPN2.getvDis(), JPN2.getvReset(), JPN2.getvSpike(), JPS1.getiSpike(),
					JPS1.gettSpike());
		}

		if (arg0.getSource() == botonInFire3) {
			System.out.println("Boton InFire");
			controlador.controladorBotonInFireSinapsisMultiple(JPE.gettIniEstim(), JPE.gettFinEstim(), JPE.gettFinSimul(),
					JPE.getIntensidad(), JPE.getResTemp(), JPN1.getResistencia(), JPN1.getTau(), JPN1.getvRep(),
					JPN1.getvDis(), JPN1.getvReset(), JPN1.getvSpike(), JPN2.getResistencia(), JPN2.getTau(),
					JPN2.getvRep(), JPN2.getvDis(), JPN2.getvReset(), JPN2.getvSpike(), JPN3.getResistencia(),
					JPN3.getTau(), JPN3.getvRep(), JPN3.getvDis(), JPN3.getvReset(), JPN3.getvSpike(), JPS1.getiSpike(),
					JPS1.gettSpike(), JPS2.getiSpike(), JPS2.gettSpike());
		}

		if (arg0.getSource() == botonSalir1) {
			System.out.println("Saliendo");
			System.exit(0);
		}

		if (arg0.getSource() == botonSalir2) {
			System.out.println("Saliendo");
			System.exit(0);
		}

		if (arg0.getSource() == botonSalir3) {
			System.out.println("Saliendo");
			System.exit(0);
		}
	}

	protected class JLabelTitulos extends JLabel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public JLabelTitulos(String s) {
			setLayout(new FlowLayout(FlowLayout.CENTER));
			setHorizontalAlignment(JTextField.CENTER);
			setFont(fuente);
			setText(s);
		}
	}

	protected class JLabelSubtitulos extends JLabel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public JLabelSubtitulos(String s) {
			setLayout(new FlowLayout(FlowLayout.CENTER));
			setHorizontalAlignment(JTextField.CENTER);
			setFont(fuente2);
			setText(s);
		}
	}

	protected class JLabelDato extends JLabel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public JLabelDato(String s) {
			setLayout(new FlowLayout(FlowLayout.CENTER));
			setHorizontalAlignment(JTextField.CENTER);
			setFont(fuente3);
			setText(s);
		}
	}

	protected class JTextFieldDato extends JTextField {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public JTextFieldDato(String s) {
			setLayout(new FlowLayout(FlowLayout.CENTER));
			setHorizontalAlignment(JTextField.CENTER);
			setFont(fuente3);
			setText(s);
		}
	}

	protected class JPanelDato extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public JPanelDato(Component a, Component b) {
			setLayout(new GridLayout(1, 2));
			setBorder(new EmptyBorder(5, 20, 5, 20));
			add(a);
			add(b);
		}
	}

	protected class JPanelNeurona extends JPanel {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private JTextFieldDato resistenciaText = new JTextFieldDato("10.0");
		private JTextFieldDato tauText = new JTextFieldDato("10.0");
		private JTextFieldDato vRepText = new JTextFieldDato("-65.0");
		private JTextFieldDato vDisText = new JTextFieldDato("-50.0");
		private JTextFieldDato vResetText = new JTextFieldDato("-70.0");
		private JTextFieldDato vSpikeText = new JTextFieldDato("30.0");

		public JPanel JPanelNeurona() {
			JLabelSubtitulos tituloInFire = new JLabelSubtitulos("Datos Neurona: ");

			JLabelDato resistenciaLabel = new JLabelDato("Resistencia (MOh): ");
			JLabelDato tauLabel = new JLabelDato("Tau (ms): ");
			JLabelDato vRepLabel = new JLabelDato("Voltaje de reposo (mV): ");
			JLabelDato vDisLabel = new JLabelDato("Voltaje de disparo (mV): ");
			JLabelDato vResetLabel = new JLabelDato("Voltaje de reset (mV): ");
			JLabelDato vSpikeLabel = new JLabelDato("Voltaje de pico (mV): ");

			JPanelDato resistenciaPanel = new JPanelDato(resistenciaLabel, resistenciaText);
			JPanelDato tauPanel = new JPanelDato(tauLabel, tauText);
			JPanelDato vRepPanel = new JPanelDato(vRepLabel, vRepText);
			JPanelDato vDisPanel = new JPanelDato(vDisLabel, vDisText);
			JPanelDato vResetPanel = new JPanelDato(vResetLabel, vResetText);
			JPanelDato vSpikePanel = new JPanelDato(vSpikeLabel, vSpikeText);

			JPanel inFirePanel = new JPanel();
			inFirePanel.setLayout(new GridLayout(7, 1));
			inFirePanel.setBorder(new EmptyBorder(0, 10, 10, 10));
			inFirePanel.add(tituloInFire);
			inFirePanel.add(resistenciaPanel);
			inFirePanel.add(tauPanel);
			inFirePanel.add(vRepPanel);
			inFirePanel.add(vDisPanel);
			inFirePanel.add(vResetPanel);
			inFirePanel.add(vSpikePanel);
			inFirePanel.add(vSpikePanel);

			return inFirePanel;
		}

		public void setDefault() {
			resistenciaText.setText("10.0");
			tauText.setText("10.0");
			vRepText.setText("-65.0");
			vDisText.setText("-50.0");
			vResetText.setText("-70.0");
			vSpikeText.setText("30.0");
		}

		public String[] getDatosNeurona() {
			String[] neurona = { resistenciaText.getText(), tauText.getText(), vRepText.getText(), vDisText.getText(),
					vResetText.getText(), vSpikeText.getText() };
			return neurona;
		}

		public String getResistencia() {
			return resistenciaText.getText();
		}

		public String getTau() {
			return tauText.getText();
		}

		public String getvRep() {
			return vRepText.getText();
		}

		public String getvDis() {
			return vDisText.getText();
		}

		public String getvReset() {
			return vResetText.getText();
		}

		public String getvSpike() {
			return vSpikeText.getText();
		}
	}

	protected class JPanelEstimulo extends JPanel {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private JTextFieldDato tIniEstimText = new JTextFieldDato("100.0");
		private JTextFieldDato tFinEstimText = new JTextFieldDato("400.0");
		private JTextFieldDato tFinSimulText = new JTextFieldDato("500.0");
		private JTextFieldDato intensidadText = new JTextFieldDato("1.8");
		private JTextFieldDato resTempText = new JTextFieldDato("0.1");

		public JPanel JPanelEstimulo() {
			JLabelSubtitulos tituloEstimulo = new JLabelSubtitulos("Datos Estimulo: ");

			JLabelDato tIniEstimLabel = new JLabelDato("Tiempo inicio estimulo (ms): ");
			JLabelDato tFinEstimLabel = new JLabelDato("Tiempo fin estimulo (ms): ");
			JLabelDato tFinSimulLabel = new JLabelDato("Tiempo fin simulacion (ms): ");
			JLabelDato intensidadLabel = new JLabelDato("Intensidad del estimulo (nA): ");
			JLabelDato resTempLabel = new JLabelDato("Resolucion temporal (ms): ");

			JPanelDato tIniEstimPanel = new JPanelDato(tIniEstimLabel, tIniEstimText);
			JPanelDato tFinEstimPanel = new JPanelDato(tFinEstimLabel, tFinEstimText);
			JPanelDato tFinSimulPanel = new JPanelDato(tFinSimulLabel, tFinSimulText);
			JPanelDato intensidadPanel = new JPanelDato(intensidadLabel, intensidadText);
			JPanelDato resTempPanel = new JPanelDato(resTempLabel, resTempText);

			JPanel estimuloPanel = new JPanel();
			estimuloPanel.setLayout(new GridLayout(7, 1));
			estimuloPanel.setBorder(new EmptyBorder(0, 10, 10, 10));
			estimuloPanel.add(tituloEstimulo);
			estimuloPanel.add(tIniEstimPanel);
			estimuloPanel.add(tFinEstimPanel);
			estimuloPanel.add(tFinSimulPanel);
			estimuloPanel.add(intensidadPanel);
			estimuloPanel.add(intensidadPanel);
			estimuloPanel.add(resTempPanel);

			return estimuloPanel;
		}

		public void setDefault() {
			tIniEstimText.setText("100.0");
			tFinEstimText.setText("400.0");
			tFinSimulText.setText("500.0");
			intensidadText.setText("1.8");
			resTempText.setText("0.1");
		}

		public String[] getDatosEstimulo() {
			String[] estimulo = { tIniEstimText.getText(), tFinEstimText.getText(), tFinSimulText.getText(),
					intensidadText.getText(), resTempText.getText() };
			return estimulo;
		}

		public String gettIniEstim() {
			return tIniEstimText.getText();
		}

		public String gettFinEstim() {
			return tFinEstimText.getText();
		}

		public String gettFinSimul() {
			return tFinSimulText.getText();
		}

		public String getIntensidad() {
			return intensidadText.getText();
		}

		public String getResTemp() {
			return resTempText.getText();
		}
	}

	protected class JPanelSinapsis extends JPanel {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private JTextFieldDato iSpikeText = new JTextFieldDato("2.1");
		private JTextFieldDato tSpikeText = new JTextFieldDato("10.0");

		public JPanel JPanelSinapsis() {
			JLabelSubtitulos tituloSinapsis = new JLabelSubtitulos("Datos Sinapsis: ");

			JLabelDato iSpikeLabel = new JLabelDato("Tiempo intensidad de pico (mV): ");
			JLabelDato tSpikeLabel = new JLabelDato("Tiempo duracion de pico (ms): ");

			JPanelDato iSpikePanel = new JPanelDato(iSpikeLabel, iSpikeText);
			JPanelDato tSpikePanel = new JPanelDato(tSpikeLabel, tSpikeText);

			JPanel sinapsisPanel = new JPanel();
			sinapsisPanel.setLayout(new GridLayout(7, 1));
			sinapsisPanel.setBorder(new EmptyBorder(0, 10, 10, 10));
			sinapsisPanel.add(tituloSinapsis);
			sinapsisPanel.add(iSpikePanel);
			sinapsisPanel.add(tSpikePanel);

			return sinapsisPanel;
		}

		public void setDefault() {
			iSpikeText.setText("2.1");
			tSpikeText.setText("10.0");
		}

		public String[] getDatosSinapsis() {
			String[] sinapsis = { iSpikeText.getText(), iSpikeText.getText() };
			return sinapsis;
		}

		public String getiSpike() {
			return iSpikeText.getText();
		}

		public String gettSpike() {
			return tSpikeText.getText();
		}
	}
}
