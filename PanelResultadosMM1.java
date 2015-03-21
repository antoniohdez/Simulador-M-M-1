import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;


public class PanelResultadosMM1 extends PanelControlesMM1 implements ActionListener{
	
	private JLabel resultado;
	
	public PanelResultadosMM1(PanelControlesMM1 panel){
		//width del panel: 680
		//height panel: 400
		
		super();
		this.setLayout(null);
		this.resultado = new JLabel("Resultados:");
		
		this.resultado.setBounds(300, 20, 100, 30);
		this.add(this.resultado);

		this.setBackground(Color.getHSBColor(240, 15, 90));
		
		
		/*
		 * Add control panel components
		 */
		panel.setPreferredSize(new Dimension(-450, 450));
		panel.setLayout(null);

		panel.datosL.setBounds(55, 20, 150, 30);
		panel.add(panel.datosL);
		
		panel.semillaL.setBounds(40, 80, 60, 30);
		panel.add(panel.semillaL);
		panel.semilla.setBounds(110, 80, 80, 25);
		panel.add(panel.semilla);
		
		panel.lambdaL.setBounds(35, 140, 60, 30);
		panel.add(panel.lambdaL);
		panel.lambda.setBounds(110, 140, 80, 25);
		panel.add(panel.lambda);
		
		panel.miuL.setBounds(45, 200, 60, 30);
		panel.add(panel.miuL);
		panel.miu.setBounds(110, 200, 80, 25);
		panel.add(panel.miu);
		
		panel.tiempoL1.setBounds(30, 245, 60, 40);
		panel.add(panel.tiempoL1);
		panel.tiempoL2.setBounds(30, 260, 70, 40);
		panel.add(panel.tiempoL2);
		panel.tiempo.setBounds(110, 260, 80, 25);
		panel.add(panel.tiempo);
		
		panel.simular.setBounds(70, 330, 100, 30);
		panel.add(panel.simular);
	}
	

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
