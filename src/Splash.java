import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

public class Splash extends JFrame {
	JProgressBar barra; // progresse bar 
	JLabel texto;
	JLabel percent;
	
	public Splash() {
		setTitle("Tela de Splash");
		setSize(600,300);
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		getContentPane().setBackground(new Color (255, 255,255));
		
		texto = new JLabel("");
		texto.setFont(new Font("Arial", Font.BOLD, 14));
		texto.setBounds(20, 40, 400, 30);
		
		
		percent = new JLabel("");
		percent.setFont(new Font("Arial", Font.BOLD, 14));
		percent.setBounds(550, 40, 400, 30);
		
		barra = new JProgressBar(0,100);
		barra.setForeground(Color.green);
		barra.setBounds(2, 150, 580, 30);
		
		getContentPane().setLayout(null);
		getContentPane().add(texto);
		getContentPane().add(percent);
		getContentPane().add(barra);
		
		// Thread, quando preciso carrega mais de dois processo ao mesmo tempo
		new Thread(new carregar() ).start();
		
		
		
	
		
	}
	
	public class carregar implements Runnable{

		// metodo para percorrer a barra de progresso 
		@Override
		public void run() {
			
			//metodo para percorrer  a barra de progresso
			for (int i = 0; i <= 100; i++) {
				// se a barra não inicializar 
				
				try {
					// metodo sleep em milisegundos o tempo de vida da thread
					Thread.sleep(100);
					
					barra.setValue(i);
					
					if(barra.getValue() <= 50) {
						texto.setText("Carregando informações....");
						percent.setText(i + "%");
						
						
					}else if(barra.getValue() <= 80) {
						texto.setText("Carregando Telas....");
						percent.setText(i + "%");
						
					}else if(barra.getValue() <= 90) {
						texto.setText("Carregado banco de dados....");
						percent.setText(i + "%");
						
					}
					else {
						texto.setText("Sistema Pronto....");
						percent.setText(i + "%");
					}
					
					
					
				} catch (Exception e) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, e);
				}
				
				
				
			}
			
			
			ComboBox combo = new ComboBox();
			Splash.this.dispose(); //fechar a tela de splash
			combo.setVisible(true);
			
		}
		
	}
}
