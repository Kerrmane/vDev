package vDev;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;



public class FenetreConnexion {

	private JFrame frame;
	private JTextField loginTextField;
	private final Action action = new SwingAction();
	private JPasswordField MDPTextField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreConnexion window = new FenetreConnexion();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FenetreConnexion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setAlwaysOnTop(true);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(10, 10, 516, 288);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		loginTextField = new JTextField();
		loginTextField.setBounds(150, 121, 208, 36);
		panel.add(loginTextField);
		loginTextField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Mot de passe");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(150, 167, 126, 21);
		panel.add(lblNewLabel_1);
		
		JButton btnLogin = new JButton("Se connecter");
		btnLogin.setForeground(Color.BLACK);
		btnLogin.setBackground(Color.DARK_GRAY);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean valid=false;
				Connection connexion = null;
				try {
					connexion = DaoFactory.getConnection();
					
				Statement stmt = connexion.createStatement();
		        ResultSet rs = ((java.sql.Statement) stmt).executeQuery("Select * from  utilisateurs");
		        String username=loginTextField.getText();
				String password=MDPTextField.getText();
		        while(rs.next()) {
		        	System.out.println("username : "+username+" bdd= "+rs.getString(2));
	        		System.out.println("password : "+password+" bdd= "+rs.getString(3));
	        		
		        	//System.out.println( " " + rs.getString(2) + " " + rs.getString(3) + " " );
		        	if (username.equals(rs.getString(2)) && password.equals(rs.getString(3))) {
		        		valid = true; 
		        		
		        	}
		        }
		        
		        if (valid) {
		        	System.out.println("Vous pouvez entrer");
		        	frame.setVisible(false);
					Fenetre pi= new Fenetre();
					pi.setVisible(true);
		        }
		        else {
		         	System.out.println("erreur mdp");
		        }
		       }catch(Exception ee ) {
	    			System.out.println("false");
	    			ee.printStackTrace();
	    			
	    			
	    		}
			//WindowEvent closeWindow = new WindowEvent(this,WindowEvent.WINDOW_CLOSING); 
			//close();
			
			}
		});
		
		/*public void close() {
			WindowEvent closeWindow = new WindowEvent(this,WindowEvent.WINDOW_CLOSING); 
			Toolkit.get
		}*/
		
		btnLogin.setBounds(190, 244, 134, 34);
		panel.add(btnLogin);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 10, 496, 71);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("vDev Connexion");
		lblNewLabel_1_1.setFont(new Font("Arial Black", Font.BOLD, 25));
		lblNewLabel_1_1.setBounds(135, 10, 243, 36);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(151, 96, 33, 15);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		MDPTextField = new JPasswordField();
		MDPTextField.setBounds(150, 198, 208, 36);
		panel.add(MDPTextField);
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 550, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
