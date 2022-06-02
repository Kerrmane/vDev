package doa;

import java.sql.*;
import java.util.*;



import vDev.Client;
import vDev.ContratMaintenance;
import vDev.Materiel;



public class ClientDao {
	public static ArrayList<Client> LesClients;
    public static ArrayList<Client> getAll() throws ClassNotFoundException, SQLException {

    	LesClients = new ArrayList<Client>();

        Connection connexion = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        connexion = DriverManager.getConnection("jdbc:mysql:///cashcash", "root", "");

        PreparedStatement stt = connexion.prepareStatement("select * from client");


        ResultSet resultSet = stt.executeQuery();

        while (resultSet.next()) {
            Client mat = new Client();

            mat.setNumClient(resultSet.getString("numero_client"));
            mat.setRaisonSociale(resultSet.getString("raison_sociale"));
             mat.setSiren(resultSet.getString("numero_de_siren"));
            mat.setCodeApe(resultSet.getString("code_ape"));
            mat.setAdresse(resultSet.getString("adresse_posatle"));

            mat.setTelClient(resultSet.getString("numero_de_telephone"));
             mat.setEmail(resultSet.getString("adresse_mail"));
            mat.setDureeDeplacement(resultSet.getString("Duree_Deplacement"));
            mat.setDistanceKm(resultSet.getString("Distance_KM"));
            mat.setNumeroAgence(resultSet.getString("numero_agence"));
            


            LesClients.add(mat);
 
        }





       
        return LesClients;
    }

    public static Client getClientById(String idClient) throws ClassNotFoundException, SQLException {
        Client clt = new Client();


        Connection connexion = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        connexion = DriverManager.getConnection("jdbc:mysql:///cashcash", "root", "");

        PreparedStatement stt = connexion.prepareStatement("select * from Client where numero_client  = ?");
        stt.setString(1, idClient);


        ResultSet resultSet = stt.executeQuery();

        while (resultSet.next()) {


			clt.setNumClient(resultSet.getString("numero_client"));
			clt.setRaisonSociale(resultSet.getString("raison_sociale"));
			 clt.setSiren(resultSet.getString("numero_de_siren"));
			clt.setCodeApe(resultSet.getString("code_ape"));
			clt.setAdresse(resultSet.getString("adresse_posatle"));
			clt.setTelClient(resultSet.getString("numero_de_telephone"));
			 clt.setEmail(resultSet.getString("adresse_mail"));
			clt.setDureeDeplacement(resultSet.getString("Duree_Deplacement"));
			clt.setDistanceKm(resultSet.getString("Distance_KM"));
			clt.setNumeroAgence(resultSet.getString("numero_agence"));
			//clt.setLesMateriels(getMateriel("idClient"));

        }


        return clt;
    }
    public static Materiel getMateriel(String id) throws SQLException, ClassNotFoundException{
    	 Materiel mat = new Materiel();


         Connection connexion = null;
         Class.forName("com.mysql.cj.jdbc.Driver");
         connexion = DriverManager.getConnection("jdbc:mysql:///cashcash", "root", "");

         PreparedStatement stt = connexion.prepareStatement("select * from materiel where numero_client  = ?");
         stt.setString(1, id);


         ResultSet resultSet = stt.executeQuery();

         while (resultSet.next()) {


              mat.setNumSerie(resultSet.getInt("numero_de_serie"));
              mat.setDateVente(resultSet.getDate("Date_vente"));
              mat.setDateinsatallation(resultSet.getDate("Date_insatallation"));
              mat.setPrixVente(resultSet.getInt("Prix_vente"));
              mat.setEmplacement(resultSet.getString("Emplacement"));
              mat.setNumContrat(resultSet.getInt("numero_de_contrat"));
              mat.setNumeroClient(resultSet.getInt("numero_client"));
             

         }


         return mat;
    	
    	
    } 

    public static void main(String[]args) throws SQLException, ClassNotFoundException {

        //System.out.println( ClientDao.getClientById("1120").toString());
       System.out.println(getMateriel("1120"));
       //System.out.println(getAll());
    	 

        
        /*Client clt = new Client();
       for(Client clt1 : ClientDao.getMateriel("1121")){
            System.out.println(clt1.toString());
        }*/
    }
}


	
	



