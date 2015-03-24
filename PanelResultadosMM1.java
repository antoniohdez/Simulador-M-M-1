import java.util.ArrayList;
import java.util.Queue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;


public class PanelResultadosMM1 extends PanelControlesMM1 implements ActionListener{
	
	private JLabel resultado, ocioLabel, lLabel, lqLabel, wLabel, wqLabel, oLabel, llegadas, servidor, salidas;
	private PanelControlesMM1 panel;
	
	public PanelResultadosMM1(PanelControlesMM1 panelC){
		super();
		this.panel = panelC;
		/*
		 * Add result panel components
		 */
		this.setLayout(null);
		this.resultado = new JLabel("Resultados:");
		this.resultado.setBounds(300, 20, 100, 30);
		this.add(this.resultado);
		
		this.ocioLabel = new JLabel("Tiempo de Ocio: ");
		this.lLabel = new JLabel("L: ");
		this.lqLabel = new JLabel("Lq: ");
		this.wLabel = new JLabel("W: ");
		this.wqLabel = new JLabel("Wq: ");
		this.oLabel = new JLabel("O: ");
		
		this.ocioLabel.setBounds(100, 50, 200, 15);
		this.lLabel.setBounds(400, 50, 200, 15);
		this.lqLabel.setBounds(100, 65, 200, 15);
		this.wLabel.setBounds(400, 65, 200, 15);
		this.wqLabel.setBounds(100, 80, 200, 15);
		this.oLabel.setBounds(400, 80, 200, 15);
		
		this.add(this.ocioLabel);
		this.add(this.lLabel);
		this.add(this.lqLabel);
		this.add(this.wLabel);
		this.add(this.wqLabel);
		this.add(this.oLabel);
		
		this.setBackground(Color.getHSBColor(240, 15, 90));
		
		/*
		 * Add control panel components
		 */
		panel.setLayout(null);

		panel.datosL.setBounds(55, 20, 150, 30);
		panel.semillaL.setBounds(40, 80, 60, 30);
		panel.semilla.setBounds(110, 80, 80, 25);
		panel.lambdaL.setBounds(35, 140, 60, 30);
		panel.lambda.setBounds(110, 140, 80, 25);
		panel.miuL.setBounds(45, 200, 60, 30);
		panel.miu.setBounds(110, 200, 80, 25);
		panel.tiempoL1.setBounds(30, 245, 60, 40);
		panel.tiempoL2.setBounds(30, 260, 70, 40);
		panel.tiempo.setBounds(110, 260, 80, 25);
		panel.simular.setBounds(70, 330, 100, 30);
		
		/*
		 * @Add action listeners to buttons and text fields
		 */
		panel.semilla.addActionListener(this);
		panel.lambda.addActionListener(this);
		panel.miu.addActionListener(this);
		panel.tiempo.addActionListener(this);
		panel.simular.addActionListener(this);
		
		
		panel.add(panel.datosL);
		panel.add(panel.semillaL);
		panel.add(panel.semilla);
		panel.add(panel.lambdaL);
		panel.add(panel.lambda);
		panel.add(panel.miuL);
		panel.add(panel.miu);
		panel.add(panel.tiempoL1);
		panel.add(panel.tiempoL2);
		panel.add(panel.tiempo);
		panel.add(panel.simular);
	}
	

	public void actionPerformed(ActionEvent e) {
		boolean enteros, dobles;
		
		if(e.getSource()==panel.simular){
			
			String txtSemilla = panel.semilla.getText();
			String txtLambda = panel.lambda.getText();
			String txtMiu = panel.miu.getText();
			String txtTiempo = panel.tiempo.getText();
			
			System.out.println("Semilla: " + txtSemilla);
			System.out.println("Lambda: " + txtLambda);
			System.out.println("Miu: " + txtMiu);
			System.out.println("Tiempo: " + txtTiempo);
			
			/*
			 * @Validar que los campos no estÃ©n vacÃ­os
			 */
			
			if(txtSemilla.length()== 0 || txtLambda.length()== 0 || txtMiu.length()== 0 ){
				JOptionPane.showMessageDialog(null, "�Hay algun campo vacio!");
			}
			else{
				/*
				 * @Validar que los campos sÃ³lo tengan nÃºmeros
				 */
				boolean numSemilla, numLambda, numMiu, numTiempo;
				numSemilla = numEntero(txtSemilla);
				numLambda = numDoble(txtLambda);
				numMiu = numDoble(txtMiu);
				numTiempo = numEntero(txtTiempo);
				
				enteros = true;
				dobles = true;
				
				if(!numSemilla || !numTiempo){
					JOptionPane.showMessageDialog(null, "�La semilla y el tiempo deben de ser numeros enteros!");
					enteros=false;
				}
				if(!numLambda || !numMiu){
					JOptionPane.showMessageDialog(null, "�L y M deben de ser un numero doble o entero!");
					dobles=false;
				}
				if(enteros && dobles){
					panel.s = new Simulator(Integer.parseInt(txtSemilla), Double.parseDouble(txtLambda), 
							Double.parseDouble(txtMiu), Integer.parseInt(txtTiempo));
					panel.s.run();
					System.out.println("L: " + panel.s.L());
					System.out.println("Lq: " + panel.s.Lq());
					System.out.println("W: " + panel.s.W());
					System.out.println("Wq: " + panel.s.Wq());
					System.out.println("O: " + panel.s.O());
					
					this.ocioLabel.setText( "Ocio total: " + panel.s.Ocio() );
					this.lLabel.setText( "L: " + panel.s.L() );
					this.lqLabel.setText( "Lq: " + panel.s.Lq() );
					this.wLabel.setText( "W: " + panel.s.W() );
					this.wqLabel.setText( "Wq: " + panel.s.Wq() );
					this.oLabel.setText( "Promedio ocio: " + panel.s.O() );

					repaint();
				}
			}
		}
	}

	@Override
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
		if( panel.s != null){
			ArrayList<Client> clients = panel.s.getClients();

			int size = 1000;
			//int width = panel.s.getClients().size()*10;
			int width = Integer.parseInt(panel.tiempo.getText())*size;

			setPreferredSize(new Dimension(width + 100, 450));
			g.drawLine(75, 200, width + 50, 200);
			g.drawLine(75, 300, width + 50, 300);
			
			this.llegadas = new JLabel("Llegadas");
			this.servidor = new JLabel("Servidor");
			this.salidas = new JLabel("Salidas");
			this.llegadas.setBounds(20, 175, 200, 15);
			this.servidor.setBounds(20, 240, 200, 15);
			this.salidas.setBounds(20, 300, 200, 15);
			this.add(this.llegadas);
			this.add(this.servidor);
			this.add(this.salidas);

			for(Client c : clients){
				//Arrive
				int x = (int) (c.getArrivedAt()*size);
				g.drawLine(75 + x, 150, 75 + x, 200);

				//Service
				int x1 = (int) (c.getArrivedAt()*size);
				int x2 = (int) (c.getServedAt()*size);
				g.drawLine(75 + x1, 200, 75 + x2, 300);

				//Exit
				x = (int) (c.getExitTime()*size);
				g.drawLine(75 + x, 300, 75 + x, 350);
			}

		}
		
    }
}