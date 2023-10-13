package es.geopol.sondeos.app;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class app {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String args[]) {        

        // Creando el Marco        
        JFrame frame = new JFrame("GEOPOL - Generador de ficheros");       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        frame.setSize(400, 400);        

        // Creando MenuBar y agregando componentes   
        JMenuBar mb = new JMenuBar();       
        JMenu m1 = new JMenu("ARCHIVO");       
        JMenu m2 = new JMenu("Ayuda");       
        mb.add(m1);       
        mb.add(m2);       
        JMenuItem m11 = new JMenuItem("Abrir");       
        JMenuItem m22 = new JMenuItem("Guardar como");       
        m1.add(m11);       
        m1.add(m22);        
 

        // Área de texto en el centro    
        JTextArea ta = new JTextArea();        
     
        frame.getContentPane().add(BorderLayout.NORTH, mb);       
        frame.getContentPane().add(BorderLayout.CENTER, ta);       
        frame.setVisible(true);   
    }

	/**
	 * Create the application.
	 */
	public app() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
