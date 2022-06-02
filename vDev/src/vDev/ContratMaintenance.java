package vDev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;

import doa.ContratMaintenanceDao;

public class ContratMaintenance {
	private static int numContrat ;
	private Date dateSignature ;
	private Date dateEcheance ;
	private int joursrestants ;
	private Materiel lesMaterielsAssures ; 
	
	
	
	
	
	
	
	
	
	
		
		
		
	
	
	
	@Override
	public String toString() {
		return "ContratMaintenance [dateSignature=" + dateSignature + ", dateEcheance=" + dateEcheance
				+ ", joursrestants=" + joursrestants + "]";
	}

	public static int getNumContrat() {
		return numContrat;
	}

	public static void setNumContrat(int numContrat) {
		ContratMaintenance.numContrat = numContrat;
	}

	public Date getDateSignature() {
		return dateSignature;
	}

	public void setDateSignature(Date dateSignature) {
		this.dateSignature = dateSignature;
	}

	public Date getDateEcheance() {
		return dateEcheance;
	}

	public void setDateEcheance(Date dateEcheance) {
		this.dateEcheance = dateEcheance;
	}

	public Materiel getLesMaterielsAssures() {
		return lesMaterielsAssures;
	}

	public void setLesMaterielsAssures(Materiel lesMaterielsAssures) {
		this.lesMaterielsAssures = lesMaterielsAssures;
	}

	public int getJoursrestants() {
		return joursrestants;
	}

	public void setJoursrestants(int joursrestants) {
		this.joursrestants = joursrestants;
	}

	public ContratMaintenance(int numContrat, Date dateSignature, Date dateEcheance, Materiel lesMaterielsAssures) {
		super();
		this.numContrat = numContrat;
		this.dateSignature = dateSignature;
		this.dateEcheance = dateEcheance;
		this.lesMaterielsAssures = lesMaterielsAssures;
	}
	public static int getJoursRestant() throws ClassNotFoundException, SQLException {

        int nbjours = 0 ;
        int r = ContratMaintenance.getNumContrat() ;
   
        Connection connexion = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        connexion = DriverManager.getConnection("jdbc:mysql:///cashcash", "root", "");

        PreparedStatement stt = connexion.prepareStatement("SELECT TIMESTAMPDIFF(DAY,NOW(),date_echeance) AS dif FROM contrat_de_maintenance where numero_de_contrat = ?");
        
        stt.setInt(1, r);


        ResultSet resultSet = stt.executeQuery();

        while (resultSet.next()) {


            nbjours =(resultSet.getInt("dif"));
            

        }
        return nbjours;
    }
	
	public ContratMaintenance() {
		
	}
	 public  boolean  estValide() throws ClassNotFoundException, SQLException {
         int r = ContratMaintenance.getNumContrat() ;
         

         if (getJoursRestant() > 0) {
         	


             return true;

         }
         else {
             
             return false ;
         }}
	
	  public static void main(String []args) throws SQLException, ClassNotFoundException, ParseException {
	        //System.out.println(ContratDao.getContratBynumeroContrat(123456).estValide());
	        System.out.println("test"+ContratMaintenanceDao.getContratBynumeroContrat("300").getJoursRestant());
	        //System.out.println(getJoursRestant(123456));
		  //System.out.println(getContratBynumeroContrat(""));
	  }

	


}
