import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class VentanaMM1 {
	
	public VentanaMM1(){
		
		JFrame ventana = new JFrame("Simulador M/M/1");
		ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		ventana.setResizable(false);
		ventana.setLocation(400,300);
		ventana.setPreferredSize(new Dimension(950, 450));
		ventana.addWindowListener( new WindowAdapter(){
		    public void windowClosing(WindowEvent e){
		        JFrame frame = (JFrame)e.getSource();
		
		        int result = JOptionPane.showConfirmDialog(frame,"¿Seguro que desea salir del simulador M/M/1?", "Salir", JOptionPane.YES_NO_OPTION);
		        if (result == JOptionPane.YES_OPTION)
		            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    }
		});
		
		ventana.setVisible(true);
			
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p,BoxLayout.X_AXIS));
		
		PanelControlesMM1 panel = new PanelControlesMM1();
		PanelResultadosMM1 panelResp = new PanelResultadosMM1(panel);
		
		ventana.setContentPane(p);
		p.add(panel);
		p.add(panelResp);

		JScrollPane scroller = new JScrollPane(panelResp);
		ventana.getContentPane().add(scroller);
		
		ventana.pack();
			
	}
	
}
