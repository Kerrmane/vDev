package doa;

import java.io.PrintStream;

import java.sql.*;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;

import vDev.Materiel;
import vDev.ContratMaintenance;

import java.text.SimpleDateFormat;



public class ContratMaintenanceDao {
	
	
	

	    public static ContratMaintenance getContratBynumeroContrat(String numeroContrat) throws ClassNotFoundException, SQLException {
	        ContratMaintenance mat = new ContratMaintenance();


	        Connection connexion = null;
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        connexion = DriverManager.getConnection("jdbc:mysql:///cashcash", "root", "");

	        PreparedStatement stt = connexion.prepareStatement("select * from contrat_de_maintenance where numero_de_contrat  = ?");
	        stt.setString(1, numeroContrat);


	        ResultSet resultSet = stt.executeQuery();

	        while (resultSet.next()) {

	        	
	            mat.setNumContrat(resultSet.getInt("numero_de_contrat"));
	            mat.setDateSignature(resultSet.getDate("date_signature"));
	            mat.setDateEcheance(resultSet.getDate("date_echeance"));




	        }

	        return mat;
	    }
	    
	    
	   

	    	
	    	
	    	
	    	
	    	
	    
	    
		public static void main(String[]args) throws SQLException, ClassNotFoundException {




	        
	        /*System.out.println("jours restant : "+getJoursRestant(300) + " CONTRAT NUM : 300"  );
	        System.out.println("jours restant : "+getJoursRestant(301)+ " CONTRAT NUM : 301 " );
	        System.out.println("jours restant : "+getJoursRestant(302)+ " CONTRAT NUM : 302 " );
	        System.out.println("jours restant : "+getJoursRestant(303) + "  CONTRAT NUM : 302"  );
	        System.out.println("jours restant : "+getJoursRestant(305)+ " CONTRAT NUM : 305 " );
	        System.out.println("jours restant : "+getJoursRestant(307)+ " CONTRAT NUM : 307 " );
	        System.out.println("jours restant : "+getJoursRestant(304)+ " CONTRAT NUM : 304 " );
	        System.out.println("jours restant : "+getJoursRestant(310)+ " CONTRAT NUM : 310 " );
	        System.out.println("num de contrat est : "+getContratBynumeroContrat("300").getNumContrat());
	        System.out.println("ah"+getContratBynumeroContrat("300").estValide());
	        System.out.println("no "+getContratBynumeroContrat("302").estValide());
	        System.out.println(getContratBynumeroContrat("301").estValide());
	        System.out.println(getContratBynumeroContrat("305").estValide());
	        System.out.println(getContratBynumeroContrat("304").estValide());*/
	    	System.out.println(ContratMaintenanceDao.getContratBynumeroContrat("300").estValide());
	    	System.out.println(getContratBynumeroContrat("302").estValide());
	    	System.out.println(getContratBynumeroContrat("302").getJoursRestant());
	    }
	}