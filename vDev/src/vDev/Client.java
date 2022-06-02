package vDev;
import java.sql.SQLException;

import java.util.*;

import doa.ClientDao;
import doa.MaterielDao;
import doa.ContratMaintenanceDao;

public class Client {

private String numClient;
private  String raisonSociale;
private  String siren;
private  String codeApe;
private  String adresse;
private String telClient;
private  String email;
private  String dureeDeplacement;
private  String distanceKm;
private String numeroAgence;
private   ArrayList<Materiel> lesMateriels;
private   ContratMaintenance leContrat;





@Override
public String toString() {
	return "Client [numClient=" + numClient + ", raisonSociale=" + raisonSociale + ", siren=" + siren + ", codeApe="
			+ codeApe + ", adresse=" + adresse + ", telClient=" + telClient + ", email=" + email + ", dureeDeplacement="
			+ dureeDeplacement + ", distanceKm=" + distanceKm + ", numeroAgence=" + numeroAgence + "]";
}

public Client(String numClient, String raisonSociale, String siren, String codeApe, String adresse, String telClient, String email, String dureeDeplacement, String distanceKm, String numeroAgence) throws SQLException, ClassNotFoundException {
    this.numClient = numClient;
    this.raisonSociale = raisonSociale;
    this.siren = siren;
    this.codeApe = codeApe;
    this.adresse = adresse;
    this.telClient = telClient;
    this.email = email;
    this.dureeDeplacement = dureeDeplacement;
    this.distanceKm = distanceKm;
    this.numeroAgence = numeroAgence;
    
}

public Client() {

}

public String getNumClient() {
    return numClient;
}

public void setNumClient(String numClient) {
    this.numClient = numClient;
}

public String getRaisonSociale() {
    return raisonSociale;
}

public void setRaisonSociale(String raisonSociale) {
    this.raisonSociale = raisonSociale;
}

public String getSiren() {
    return siren;
}

public void setSiren(String siren) {
    this.siren = siren;
}

public String getCodeApe() {
    return codeApe;
}

public void setCodeApe(String codeApe) {
    this.codeApe = codeApe;
}

public String getAdresse() {
    return adresse;
}

public void setAdresse(String adresse) {
    this.adresse = adresse;
}

public String getTelClient() {
    return telClient;
}

public void setTelClient(String telClient) {
    this.telClient = telClient;
}

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}

public String getDureeDeplacement() {
    return dureeDeplacement;
}

public void setDureeDeplacement(String dureeDeplacement) {
    this.dureeDeplacement = dureeDeplacement;
}

public String getDistanceKm() {
    return distanceKm;
}

public void setDistanceKm(String distanceKm) {
    this.distanceKm = distanceKm;
}

public String getNumeroAgence() {
    return numeroAgence;
}

public void setNumeroAgence(String numeroAgence) {
    this.numeroAgence = numeroAgence;
}

public  ArrayList<Materiel> getLesMateriels() {
    return lesMateriels;
}

public  void setLesMateriels(ArrayList<Materiel> lesMateriels) {
    this.lesMateriels = lesMateriels;
}

public  ContratMaintenance getLeContrat() {
    return leContrat;
}

public  void setLeContrat(ContratMaintenance leContrat) {
    this.leContrat = leContrat;
}
public ArrayList<Materiel> getMaterielsSousContrat() throws ClassNotFoundException, SQLException{

    ArrayList<Materiel> ListeSousContrat = new ArrayList<Materiel>();
    for( Materiel mat : getLesMateriels()) {
          if (getLeContrat().estValide()== true){
            ListeSousContrat.add(mat);}}
    return ListeSousContrat;
}

public  ArrayList<Materiel>  getMaterielsHorsContrat() throws SQLException, ClassNotFoundException {

    ArrayList<Materiel> ListeHorsContrat = new ArrayList<Materiel>();
    for( Materiel mat : getLesMateriels()) {
          if (getLeContrat().estValide()== false){
           ListeHorsContrat.add(mat);}}
    return ListeHorsContrat;
}

/*public boolean estAssure(){
    if (leContrat == null){
    return false;}
    else
        return true;

}*/
}