import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class VentanaMM1 {
	

	public static void main(String[] args) {
		
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
		
		PanelMM1 panel = new PanelMM1();
		PanelResultadosMM1 panelResp = new PanelResultadosMM1();
		
		JScrollBar scroll = new JScrollBar(JScrollBar.HORIZONTAL);
		scroll.setMinimum(0);
		scroll.setMaximum(100);
		scroll.setBlockIncrement(30);
		scroll.addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent e) {
                 System.out.println("Adjustment changed");
            }
        });
		
		ventana.setContentPane(p);
		p.add(panel);
		p.add(panelResp);

		JScrollPane scroller = new JScrollPane(panelResp);
		ventana.getContentPane().add(scroller);
		
		
		/*JPanel p = new JPanel();
		PanelMM1 panel = new PanelMM1();
		PanelResultadosMM1 panelResp = new PanelResultadosMM1();
		
		ventana.setContentPane(p);
		p.add(panel,BorderLayout.WEST);
		p.add(panelResp, BorderLayout.EAST);
		
		p.setLayout(new GridLayout(2,1));*/
		ventana.pack();
			
	}


}
