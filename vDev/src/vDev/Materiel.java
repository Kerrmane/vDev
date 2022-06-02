package vDev;


import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import vDev.ContratMaintenance;









public class Materiel {

 private int numSerie;
	    private Date dateVente;
	    private Date dateinsatallation;
	    private float prixVente;
	    private String emplacement;
	    private  int numContrat;
	    private int numeroClient;
	    private int nbJoursRestants ;
	    
	    

	    public Materiel(int numSerie, Date dateVente, Date dateinsatallation, float prixVente, String emplacement, int numContrat, int numeroClient) {
	        this.numSerie = numSerie;
	        this.dateVente = dateVente;
	        this.dateinsatallation = dateinsatallation;
	        this.prixVente = prixVente;
	        this.emplacement = emplacement;
	        this.numContrat = numContrat;
	        this.numeroClient = numeroClient;
	    }
	    public Materiel(int numSerie) {
	    	this.numSerie=numSerie;
	    }
	    
	    

	    @Override
		public String toString() {
			return "Materiel [numSerie=" + numSerie + ", dateVente=" + dateVente + ", dateinsatallation="
					+ dateinsatallation + ", prixVente=" + prixVente + ", emplacement=" + emplacement
					+ ", numContrat=" + numContrat + ", numeroClient=" + numeroClient + "]";
		}
	    
	    



		public int getNumSerie() {
	        return numSerie;
	    }

	    public void setNumSerie(int numSerie) {
	        this.numSerie = numSerie;
	    }

	    public Date getDateVente() {
	        return dateVente;
	    }

	    public void setDateVente(Date dateVente) {
	        this.dateVente = dateVente;
	    }

	    public Date getDateinsatallation() {
	        return dateinsatallation;
	    }

	    public void setDateinsatallation(Date dateinsatallation) {
	        this.dateinsatallation = dateinsatallation;
	    }

	    public float getPrixVente() {
	        return prixVente;
	    }

	    public void setPrixVente(float prixVente) {
	        this.prixVente = prixVente;
	    }

	    public String getEmplacement() {
	        return emplacement;
	    }

	    public void setEmplacement(String emplacement) {
	        this.emplacement = emplacement;
	    }

	    public  int getNumContrat() {
	        return numContrat;
	    }

	    public void setNumContrat(int numContrat) {
	        this.numContrat = numContrat;
	    }
	    
	    public int getNumeroClient() {
	        return numeroClient;
	    }

	    public void setNumeroClient(int numeroClient) {
	        this.numeroClient = numeroClient;
	    }

	    public Materiel() {
	    	

	    }
	    public void xmlMateriel() {
	    	//JAXBContext jaxbContext = JAXBContext.newInstance(Materiel.class);
	    	
	    }
}


