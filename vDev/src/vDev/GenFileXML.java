package vDev;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

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

import doa.ContratMaintenanceDao;
import doa.MaterielDao;
 
public class GenFileXML{
 
   public static void Generation(String idClient ) throws ClassNotFoundException, SQLException {
 
      try { 
 
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
 
        // élément de racine
        Document doc = docBuilder.newDocument();
        Element racine = doc.createElement("ListeMateriel");
        doc.appendChild(racine);
 
        // l'élément materiels
        Element materiels = doc.createElement("materiels");
        racine.appendChild(materiels);
 
        // attributs de l'élément contact
        Attr attr = doc.createAttribute("idClient");
        attr.setValue(idClient);
        materiels.setAttributeNode(attr);
        
        //if condition
        //sousContrat
        // chuf ajmi khas ntl3o dik lwhile bash sous contrat o hore contrat ijiw lteht bash la kan hors contart nhydo dik date restant fhmti 
        //mafhmtch ajmi quan
        
        //khssni ndir lcodition hna mais maendi kindir ?prq bach ila kan kbr mn 0 andira hsoahuashacohnatrat ah ajmi imkn ncoupiw dak lmorco dl code deux fois mera ikoun bb sous contrst et apres hors ??
        
 
        //Boucle while (sql)
        ArrayList<Materiel> insta = MaterielDao.getListMateriel(idClient);
        Connection connexion = null;
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    connexion = DriverManager.getConnection("jdbc:mysql:///cashcash", "root", "");
	    PreparedStatement stt = connexion.prepareStatement("SELECT numero_de_serie,Date_vente,Date_insatallation,Emplacement,numero_de_contrat FROM `materiel` WHERE numero_client  = ?");
	    stt.setString(1, idClient);
	    ResultSet resultSet = stt.executeQuery();
	 while (resultSet.next()) {
	      String numSerie1=resultSet.getString("numero_de_serie");
	      String date_vente1=resultSet.getString("Date_vente");
	      String date_installation1=resultSet.getString("Date_insatallation");
	      String emplacement1=resultSet.getString("Emplacement");
	      String numero_de_contrat1=resultSet.getString("numero_de_contrat");
	      int nbr1 = ContratMaintenanceDao.getContratBynumeroContrat(numero_de_contrat1).getJoursRestant()	; //atkhdem gha b dak nbr1 ajmi rah int nadi
	      String nbJours1 = String.valueOf(nbr1) ;
	      
	     if (nbr1>0) {
	    	 Element typeContrat = doc.createElement("sousContrat");
	         materiels.appendChild(typeContrat);
	         
	         // l'élément matériel
	         Element materiel = doc.createElement("materiel");
	         typeContrat.appendChild(materiel);
	  
	         // attributs de l'élément materiel
	         Attr attr1 = doc.createAttribute("numSerie");
	         attr1.setValue(numSerie1);
	         materiel.setAttributeNode(attr1);
	       
	         //quantite 
	         Element quantite = doc.createElement("quantite");
	         quantite.appendChild(doc.createTextNode("24"));
	         materiel.appendChild(quantite);
	  
	         // date_vente
	         Element date_vente = doc.createElement("date_vente");
	         date_vente.appendChild(doc.createTextNode(date_vente1));
	         materiel.appendChild(date_vente);
	  
	         // la date_installation
	       

	         Element date_installation = doc.createElement("date_installation");
	         date_installation.appendChild(doc.createTextNode(date_installation1));
	         materiel.appendChild(date_installation);
	   
	         // prix_vente
	         Element prix_vente = doc.createElement("prix_vente");
	         prix_vente.appendChild(doc.createTextNode("38"));
	         materiel.appendChild(prix_vente);
	  
	         // emplacement
	         Element emplacement = doc.createElement("emplacement");
	         emplacement.appendChild(doc.createTextNode(emplacement1));
	         materiel.appendChild(emplacement);
	  
	         // nbJourAvantEcheance
	         
	         Element nbJourAvantEcheance = doc.createElement("nbJourAvantEcheance");
	         nbJourAvantEcheance.appendChild(doc.createTextNode(nbJours1));
	         materiel.appendChild(nbJourAvantEcheance);
	         // finn nb jour echeance 
	     
	         
	         
	     }
	     else {
	    	 Element typeContrat = doc.createElement("horsContrat");
	         materiels.appendChild(typeContrat);
	         
	      // l'élément matériel
	         
	         Element materiel = doc.createElement("materiel");
	         typeContrat.appendChild(materiel);
	  
	         // attributs de l'élément materiel
	         Attr attr1 = doc.createAttribute("numSerie");
	         attr1.setValue(numSerie1);
	         materiel.setAttributeNode(attr1);
	       
	         //quantite 
	         Element quantite = doc.createElement("quantite");
	         quantite.appendChild(doc.createTextNode("24"));
	         materiel.appendChild(quantite);
	  
	         // date_vente
	         Element date_vente = doc.createElement("date_vente");
	         date_vente.appendChild(doc.createTextNode(date_vente1));
	         materiel.appendChild(date_vente);
	  
	         // la date_installation
	       

	         Element date_installation = doc.createElement("date_installation");
	         date_installation.appendChild(doc.createTextNode(date_installation1));
	         materiel.appendChild(date_installation);
	   
	         // prix_vente
	         Element prix_vente = doc.createElement("prix_vente");
	         prix_vente.appendChild(doc.createTextNode("38"));
	         materiel.appendChild(prix_vente);
	  
	         // emplacement
	         Element emplacement = doc.createElement("emplacement");
	         emplacement.appendChild(doc.createTextNode(emplacement1));
	         materiel.appendChild(emplacement);
	     }
	 }
	 
        
        // write the content into xml file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult resultat = new StreamResult(new File("C:\\Users\\ayman\\vdevDocument\\FichClient"+idClient+".xml"));
 
        transformer.transform(source, resultat);
 
        System.out.println("Fichier sauvegardé avec succès!");
 
     } catch (ParserConfigurationException pce) {
         pce.printStackTrace();
     } catch (TransformerException tfe) {
         tfe.printStackTrace();
     }
  }
}

