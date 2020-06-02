import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;



public class TelaLogin extends JFrame implements ActionListener{
	
	//Declaration of objects
	
	
	// Texts
	JLabel textologin;
	JLabel textosenha;
	
	// Login Box
	JTextField login;
	
	//Password 
	JPasswordField password;
	
	
	//Buttons
	JButton botaologar;
	JButton botaolimpar;
	
	
	
	// constructor
	public TelaLogin() {
		//  title
		setTitle("Tela De Login");
		
		
		//size window
		setSize(400, 270);
		
		
		// open centralized form
		this.setLocationRelativeTo(null);
		
		
		// close the windown
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		//not maximized
		setResizable(false);
		
		//background
		getContentPane().setBackground(new Color(255, 255, 255));
		
		
		
		// text text login
		textologin  = new JLabel("Digite login:");
		//font text login
		textologin.setFont(new Font("Arial", Font.BOLD, 14));
		//position text login
		textologin.setBounds(10, 10, 200, 30);
		
		login = new JTextField();
		login.setBounds(150, 10, 200, 30);
		
		
		
		textosenha = new JLabel("Digite a senha:");
		textosenha.setFont(new Font("Arial", Font.BOLD, 14));
		textosenha.setBounds(10, 70, 200, 30);
		
		
		
		//password box
		password = new JPasswordField();
		// show '*' on password 
		password.setEchoChar('*');
		//password positon
		password.setBounds(150, 70, 200, 30);
		
		
		PlainDocument document = (PlainDocument) password.getDocument();
		document.setDocumentFilter(new DocumentFilter() {
	         @Override
	         public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) 
	        		 throws BadLocationException {
	            String string = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
	               if (string.length() < 4) {
	                  super.replace(fb, offset, length, text, attrs);
	               }
	         }
	      });
		
		
		//text button
		botaologar = new JButton("LOGAR");
		//button position
		botaologar.setBounds(80,160, 120, 60);
		
		
		//text button
		botaolimpar = new JButton("Limpar");
		//button position
		botaolimpar.setBounds(240,160, 120, 60);
		
		
		
		//layout that java will go to use
		getContentPane().setLayout(null);
		
		//add elements
		getContentPane().add(textologin);
		getContentPane().add(login);
		getContentPane().add(textosenha);
		getContentPane().add(password);
		getContentPane().add(botaologar);
		getContentPane().add(botaolimpar);
		
		
		// add action on buttons
		botaologar.addActionListener(this);
		botaolimpar.addActionListener(this);
		
		
	}
	
		
	
	
	// abstract method 
	// this method listen the click of mouse
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == botaologar) {
			
			// login and password correct			
			if (login.getText().equals("adm") && String.valueOf(password.getPassword()).equals("adm")) {
				JOptionPane.showMessageDialog(null, "Logado com sucesso!");
				
				// call class ComboBox
				Splash tela = new Splash();
				
				this.dispose();
				
				tela.setVisible(true);
				
			}else {
				JOptionPane.showMessageDialog(null, "Login ou Senha inválidos");
				
				//clear login and password
				limpar();
			}
				
		}
		
		if (e.getSource() == botaolimpar) {
			limpar();	
		}
		
	}

	private void limpar() {
		login.setText("");
		password.setText("");
		
		login.requestFocus();
		
	}
}


