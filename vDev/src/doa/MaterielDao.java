package doa;

import java.util.List;

import vDev.Materiel;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;




public class MaterielDao  {

	public static ArrayList<Materiel> getListMateriel(String numero_client) throws ClassNotFoundException, SQLException {

	    ArrayList<Materiel> materielDuClient = new ArrayList<Materiel>();

	    Connection connexion = null;
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    connexion = DriverManager.getConnection("jdbc:mysql:///cashcash", "root", "");

	    PreparedStatement stt = connexion.prepareStatement("select * from Materiel where numero_client = ?");
	    stt.setString(1, numero_client);

	    ResultSet resultSet = stt.executeQuery();

	    while (resultSet.next()) {
	        Materiel mat = new Materiel();

	        mat.setNumSerie(resultSet.getInt("numero_de_serie"));
	        mat.setDateVente(resultSet.getDate("Date_vente"));
	         mat.setDateinsatallation(resultSet.getDate("Date_insatallation"));
	        mat.setPrixVente(resultSet.getInt("Prix_vente"));
	        mat.setEmplacement(resultSet.getString("emplacement"));
	        mat.setNumContrat(resultSet.getInt("numero_de_contrat"));
	        mat.setNumeroClient(resultSet.getInt("numero_client"));
	        materielDuClient.add(mat);
	    }






	    return materielDuClient;
	}

	public void ajoutMateriel(int numSerie, Date dateVente, Date dateinsatallation, float prixVente, String emplacement, int refInterne,int numeroContrat, int numeroClient )  throws ClassNotFoundException, SQLException {

	    Materiel materielDuClient = new Materiel();


	    Connection connexion = null;
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    connexion = DriverManager.getConnection("jdbc:mysql:///cashcash", "root", "");
	    String query = "INSERT INTO Materiel ("
	            + " numero_de_serie,"
	            + " Date_Vente,"
	            + " Date_insatallation,"
	            + " Prix_Vente,"
	            + " Emplacement,"
	            + " Reference_Interne,"
	            + " numero_de_contrat,"
	            + " numero_client) VALUES ("
	            + "?,?,?, ?, ?, ?, ?, ?, ?)";
	    PreparedStatement stt = connexion.prepareStatement(query);
	    stt.setInt(1, numSerie);
	    stt.setDate(2, (java.sql.Date) dateVente);
	    stt.setDate(3, (java.sql.Date) dateinsatallation);
	    stt.setFloat(4, prixVente);
	    stt.setString(5, emplacement);
	    stt.setInt(6, refInterne);
	    stt.setInt(7, numeroContrat);
	    stt.setInt(8, numeroClient);



	    // execute the preparedstatement insert
	    stt.executeUpdate();
	    stt.close();
	}
	/*public static void ajoutMateriel(Materiel materiel)  throws ClassNotFoundException, SQLException {

	    Materiel materielDuClient = new Materiel();


	    Connection connexion = null;
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    connexion = DriverManager.getConnection("jdbc:mysql:///cashcash", "root", "");
	    String query = "INSERT INTO Materiel ("
	            + " numero_de_serie,"
	            + " Date_Vente,"
	            + " Date_insatallation,"
	            + " Prix_Vente,"
	            + " Emplacement,"
	            + " Reference_Interne,"
	            + " numero_de_contrat,"
	            + " numero_client) VALUES ("
	            + "?,?,?, ?, ?, ?, ?, ?, ?)";
	    PreparedStatement stt = connexion.prepareStatement(query);
	    stt.setInt(1, materiel.getNumSerie());
	    stt.setDate(2, (java.sql.Date) materiel.getDateVente());
	    stt.setDate(3, (java.sql.Date) materiel.getDateinsatallation());
	    stt.setFloat(4, materiel.getPrixVente());
	    stt.setString(5, materiel.getEmplacement());
	    stt.setInt(6, materiel.getRefInterne());
	    stt.setInt(7, materiel.getNumeroContrat());
	    stt.setInt(8, materiel.getNumeroClient());



	    // execute the preparedstatement insert
	   
	    stt.executeUpdate();
	    stt.close();
	}*/
	
	public static ArrayList<Materiel> getListNumSerie(String numero_client) throws ClassNotFoundException, SQLException {

	    ArrayList<Materiel> listeNumSerie = new ArrayList<Materiel>();

	    Connection connexion = null;
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    connexion = DriverManager.getConnection("jdbc:mysql:///cashcash", "root", "");

	    PreparedStatement stt = connexion.prepareStatement("SELECT numero_de_serie FROM `materiel` WHERE numero_client  = ?");
	    stt.setString(1, numero_client);

	    ResultSet resultSet = stt.executeQuery();

	    while (resultSet.next()) {
	        Materiel mat = new Materiel();

	        mat.setNumSerie(resultSet.getInt("numero_de_serie"));
	        
	        listeNumSerie.add(mat);
	        String NS=resultSet.getString("numero_de_serie");
	        //System.out.println("ok: "+NS);
	    }






	    return listeNumSerie;
	}
	public void xmlMateriel() {
		
		
	}

	public static void main(String[]args) throws SQLException, ClassNotFoundException {




	    //for(Materiel mat : MaterielDao.getListMateriel("1120") ){
	       // System.out.println(mat.toString());
	      //int  r = mat.getNumeroContrat();
	        
	    //}
		//System.out.print(getListMateriel("1119").toString().get(0));
		/*ArrayList<Materiel> at=getListMateriel("1119");
		//System.out.print(getListMateriel("1119").toString().get(0));
		List<String> strings = new ArrayList<>(at.size());
		for (Materiel object : at) {
		    strings.add(object.toString());
		}
		System.out.print(at.get(0));*/
		System.out.println(getListNumSerie("1119"));
		
	}
}
