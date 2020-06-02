import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ComboBox extends JFrame implements ActionListener{

	
	JLabel texto1;
	JTextField caixa1;
	JComboBox comb;
	JButton b1;
	
	String[] cores = {"Branco", "Vermelho", "Azul", "Verde"};
	
	
	public ComboBox() {
		setTitle("Combo box"); 
		
		setSize(480, 480);
		
		this.setLocationRelativeTo(null);
		
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		setResizable(false);
		
		getContentPane().setBackground(new Color(255,255, 255));
		
		
		comb  = new JComboBox(cores);
		comb.setBounds(140, 100, 150, 35);
		comb.setEditable(false);
		
		
		texto1 = new JLabel("Conteúdo");
		texto1.setForeground(Color.blue);
		texto1.setFont(new Font("Arial", Font.BOLD, 14));
		texto1.setBounds(160, 10, 200, 30);
		
		b1 = new JButton("Mostrar Texto");
		b1.setBounds(140, 200, 200,30);
		
		
		caixa1 = new JTextField();
		caixa1.setBounds(140, 320,200,30);
		
		getContentPane().setLayout(null);
		getContentPane().add(comb);
		getContentPane().add(texto1);
		getContentPane().add(b1);
		getContentPane().add(caixa1);	
		
		b1.addActionListener(this);
		
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		if (e.getSource() == b1) {
			caixa1.setText(" " + comb.getSelectedItem());
			
		}
	
	
	
	}

}
