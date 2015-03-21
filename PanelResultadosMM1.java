import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;


public class PanelResultadosMM1 extends JPanel implements ActionListener{
	
	private JLabel resultado;
	
	public PanelResultadosMM1(){
		//width del panel: 680
		//height panel: 400
		
		this.resultado = new JLabel("Resultados:");
		
		this.setLayout(null);
		
		this.resultado.setBounds(300, 20, 100, 30);
		this.add(this.resultado);

		this.setBackground(Color.getHSBColor(240, 15, 90));
	}
	

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
