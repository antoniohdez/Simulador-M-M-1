import java.awt.Dimension;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class PanelControlesMM1 extends JPanel implements ActionListener{
	
	protected JButton simular;
	protected JLabel datosL, semillaL, lambdaL, miuL, tiempoL1, tiempoL2;
	protected TextField semilla, lambda, miu, tiempo;

	public PanelControlesMM1(){
		
		super();
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
				
		/*
		 * @Add action listeners to buttons and text fields*/
		this.semilla.addActionListener(this);
		this.lambda.addActionListener(this);
		this.miu.addActionListener(this);
		this.tiempo.addActionListener(this);
		this.simular.addActionListener(this);
		
		
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
			 * @Validar que los campos no estÃ©n vacÃ­os
			 */
			if(txtSemilla.length()== 0 || txtLambda.length()== 0 || txtMiu.length()== 0 ){
				JOptionPane.showMessageDialog(null, "¡Hay algún campo vacío!");
			}
			else{
				/*
				 * @Validar que los campos sÃ³lo tengan nÃºmeros
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
					JOptionPane.showMessageDialog(null, "¡λ y μ deben de ser un número doble o entero!");
					dobles=false;
				}
				if(enteros && dobles){
					System.out.println("Todo en orden!");
					
				}
				
			}
					
		}
	}
    

}
