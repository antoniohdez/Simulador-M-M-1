import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class VentanaMM1 {
	
	public VentanaMM1(){
		
		JFrame ventana = new JFrame("Simulador M/M/1");

		ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		ventana.setResizable(false);
		ventana.setLocation(400,300);
		ventana.setPreferredSize(new Dimension(900, 450));
		ventana.addWindowListener( new WindowAdapter(){
		    public void windowClosing(WindowEvent e){
		        JFrame frame = (JFrame)e.getSource();
		
		        int result = JOptionPane.showConfirmDialog(frame,"¿Seguro que desea salir del simulador M/M/1?", "Salir", JOptionPane.YES_NO_OPTION);
		        if (result == JOptionPane.YES_OPTION)
		            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    }
		});

		Panel p = new Panel();
		p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));
		
		PanelControlesMM1 panel = new PanelControlesMM1();
		
		panel.setPreferredSize(new Dimension(250, 450));
		p.add(panel);

		PanelResultadosMM1 panelResp = new PanelResultadosMM1(panel);
		panelResp.setPreferredSize(new Dimension(800, 450));
		
		JScrollPane scrollPane = new JScrollPane(panelResp);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		
		p.add(scrollPane);
		
		ventana.add(p);
		ventana.pack();

		ventana.setVisible(true);
	}

}
