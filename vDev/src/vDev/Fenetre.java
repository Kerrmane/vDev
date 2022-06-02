package vDev;

import java.awt.BorderLayout;
import java.util.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import doa.ClientDao;

import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Label;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.Button;
import javax.swing.JLabel;

public class Fenetre extends JFrame {

	private JPanel contentPane;
	private JTable tableClient;
	private DefaultTableModel model;
	private Client client ;
	ResultSet rs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fenetre frame = new Fenetre();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public void Table() {
		try {
			Connection connexion = null;
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        connexion = DriverManager.getConnection("jdbc:mysql:///cashcash", "root", "");
			String[] entet = {"num","ape","r","tel","mail","dis","du","con","c","nr"};
			String[] ligne =new String[10];
			DefaultTableModel model = new DefaultTableModel(null,entet);
			
			String sql ="select * from client";
			Statement st = connexion.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				ligne[0]=client.getNumClient();
	            ligne[1]=client.getRaisonSociale();
	            ligne[2]=client.getEmail();
	            
	            ligne[6]=client.getTelClient();
	            ligne[7]=client.getNumClient();
	            ligne[8]=client.getNumClient();
	            ligne[9]=client.getNumClient();
	            ligne[0]=client.getNumClient();
			}
			
	}//
		catch (Exception e) {
			}
		}
	
	
	
	public Fenetre() throws ClassNotFoundException, SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1071, 552);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 1047, 1);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(83, 181, 805, 334);
		contentPane.add(scrollPane);
		
		Connection connexion = null;
		tableClient = new JTable();
		String[] entet = {"numClient","Raison sociale","email","telClient","N Siren","Code APE","Distance en KM","Duree du déplacement"};
		String[] ligne =new String[8];
		DefaultTableModel model = new DefaultTableModel(null,entet);
		tableClient.setModel(model);
		Class.forName("com.mysql.cj.jdbc.Driver");
        connexion = DriverManager.getConnection("jdbc:mysql:///cashcash", "root", "");
		String sql ="select * from client";
		Statement st = connexion.createStatement();
		rs = st.executeQuery(sql);
		int i=0;
		int j=200;
		ClientDao.getAll();
		while (rs.next()) {
			//tableauClient();
			
			System.out.println("oook :"+ClientDao.LesClients.get(i));
			Client clins=ClientDao.LesClients.get(i);
			
			i++;
			ligne[0]=clins.getNumClient();
            ligne[1]=clins.getRaisonSociale();  
            ligne[2]=clins.getEmail();
            ligne[3]=clins.getTelClient();
            ligne[4]=clins.getSiren();
            ligne[5]=clins.getCodeApe();
            //ligne[6]=clins.getTelClient();
           // ligne[7]=clins.getNumeroAgence);
            ligne[6]=clins.getDistanceKm();
            ligne[7]=clins.getDureeDeplacement();
            model.addRow(ligne); 
            
            Button button = new Button("XML : "+ligne[0]);
            
            String util=ligne[0]; 
             
    		button.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				// generation du fichier xml methode 
    				try {
						GenFileXML.Generation(util);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
  
    			}
    		});
    		
    		button.setBounds(894, j, 84, 18);
    		j+=16;
    		contentPane.add(button);
		}
		
		scrollPane.setViewportView(tableClient);
		
				
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(5, 5, 1042, 73);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		Label label = new Label("vDev Fiche Client ");
		label.setFont(new Font("Dialog", Font.BOLD, 25));
		label.setAlignment(Label.CENTER);
		label.setBounds(323, 10, 334, 38);
		panel_1.add(label);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(886, 181, 145, 334);
		contentPane.add(panel_2);
		
		JLabel lblNewLabel = new JLabel("Generation du fichier Xml");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(379, 140, 265, 31);
		contentPane.add(lblNewLabel);
		
		
		
	}
	public void tableauClient() throws ClassNotFoundException, SQLException {
		ArrayList<Client> mat = ClientDao.getAll();
		for(Client mat1 : ClientDao.getAll() ){
            System.out.println(mat1.toString());
            Object[] fila = new Object[10];
            fila[0]=client.getNumClient();
            fila[1]=client.getRaisonSociale();
            fila[2]=client.getEmail();
            fila[3]=client.getDureeDeplacement();
            fila[4]=client.getDistanceKm();
            fila[5]=client.getNumeroAgence();
            fila[6]=client.getTelClient();
            fila[7]=client.getNumClient();
            fila[8]=client.getNumClient();
            fila[9]=client.getNumClient();
            fila[0]=client.getNumClient();  
            
            model.addRow(fila);
            
        }
	}
}
