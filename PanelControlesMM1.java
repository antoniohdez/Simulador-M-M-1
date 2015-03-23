import java.awt.Dimension;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class PanelControlesMM1 extends JPanel{// implements ActionListener{
	
	protected JButton simular;
	protected JLabel datosL, semillaL, lambdaL, miuL, tiempoL1, tiempoL2;
	protected TextField semilla, lambda, miu, tiempo;
	protected Simulator s;

	public PanelControlesMM1(){
		
		super();
		this.simular = new JButton("Simular");
		this.datosL = new JLabel("Datos para simulacion");
		this.semillaL = new JLabel("Semilla:");
		this.lambdaL = new JLabel("Lambda:");
		this.tiempoL1 = new JLabel("Tiempo de");
		this.tiempoL2 = new JLabel("simulacion:");
		this.miuL = new JLabel("Miu:");
		this.semilla = new TextField(4);
		this.lambda = new TextField(4); 
		this.miu = new TextField(4); 
		this.tiempo = new TextField(4);
		
		
	}

	public boolean numEntero(String s) {  
	    return s.matches("\\d*");  
	}
	
	public boolean numDoble(String s) {  
	    return s.matches("\\d+(\\.\\d+)?");  
	}

}
