import java.awt.Dimension;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class PanelMM1 extends JPanel implements ActionListener{
	
	private JButton simular;
	private JLabel datosL, semillaL, lambdaL, miuL, tiempoL1, tiempoL2;
	private TextField semilla, lambda, miu, tiempo;

	public PanelMM1(){

		this.simular = new JButton("Simular");
		this.datosL = new JLabel("Datos para simulación");
		this.semillaL = new JLabel("Semilla:");
		this.lambdaL = new JLabel("Lambda λ:");
		this.tiempoL1 = new JLabel("Tiempo de");
		this.tiempoL2 = new JLabel("simulación:");
		this.miuL = new JLabel("Miu μ:");
		this.semilla = new TextField(4);
		this.lambda = new TextField(4); 
		this.miu = new TextField(4); 
		this.tiempo = new TextField(4);
		
		this.setPreferredSize(new Dimension(-450, 450));
				
		/*
		 * @Add action listeners to buttons and text fields*/
		this.semilla.addActionListener(this);
		this.lambda.addActionListener(this);
		this.miu.addActionListener(this);
		this.tiempo.addActionListener(this);
		this.simular.addActionListener(this);
		
		this.setLayout(null);

		this.datosL.setBounds(55, 20, 150, 30);
		this.add(this.datosL);
		
		this.semillaL.setBounds(40, 80, 60, 30);
		this.add(this.semillaL);
		this.semilla.setBounds(110, 80, 80, 25);
		this.add(this.semilla);
		
		this.lambdaL.setBounds(35, 140, 60, 30);
		this.add(this.lambdaL);
		this.lambda.setBounds(110, 140, 80, 25);
		this.add(this.lambda);
		
		this.miuL.setBounds(45, 200, 60, 30);
		this.add(this.miuL);
		this.miu.setBounds(110, 200, 80, 25);
		this.add(this.miu);
		
		this.tiempoL1.setBounds(30, 245, 60, 40);
		this.add(this.tiempoL1);
		this.tiempoL2.setBounds(30, 260, 70, 40);
		this.add(this.tiempoL2);
		this.tiempo.setBounds(110, 260, 80, 25);
		this.add(this.tiempo);
		
		this.simular.setBounds(70, 330, 100, 30);
		this.add(this.simular);
	}

	public boolean numEntero(String s) {  
	    return s.matches("\\d*");  
	} 
	public boolean numDoble(String s) {  
	    return s.matches("\\d+(\\.\\d+)?");  
	}

	public void actionPerformed(ActionEvent e) {
		
		boolean enteros, dobles;
		
		if(e.getSource()==this.simular){
			
			String txtSemilla = this.semilla.getText();
			String txtLambda = this.lambda.getText();
			String txtMiu = this.miu.getText();
			String txtTiempo = this.tiempo.getText();
			
			System.out.println("Semilla: "+txtSemilla);
			System.out.println("Lambda: "+txtLambda);
			System.out.println("Miu: "+txtMiu);
			System.out.println("Tiempo: "+txtTiempo);
			
			/*
			 * @Validar que los campos no estén vacíos
			 */
			if(txtSemilla.length()== 0 || txtLambda.length()== 0 || txtMiu.length()== 0 ){
				JOptionPane.showMessageDialog(null, "¡Hay algún campo vacío!");
			}
			else{
				/*
				 * @Validar que los campos sólo tengan números
				 */
				boolean numSemilla, numLambda, numMiu, numTiempo;
				numSemilla=numEntero(txtSemilla);
				numLambda=numDoble(txtLambda);
				numMiu=numDoble(txtMiu);
				numTiempo=numEntero(txtTiempo);
				
				enteros=true;
				dobles=true;
				
				if(!numSemilla || !numTiempo){
					JOptionPane.showMessageDialog(null, "¡La semilla y el tiempo deben de ser números enteros!");
					enteros=false;
				}
				if(!numLambda || !numMiu){
					JOptionPane.showMessageDialog(null, "¡λ y μ deben de ser un número doble!");
					dobles=false;
				}
				if(enteros && dobles){
					System.out.println("Todo en orden!");
				}
				
			}
					
		}
	}
    

}
