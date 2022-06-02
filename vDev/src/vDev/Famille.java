package vDev;

public class Famille {
	private  String codeFamille ;
	private  String libelleFamille ;
	
	
	public String getCodeFamille() {
		return codeFamille;
	}
	
	public void setCodeFamille(String codeFamille) {
		this.codeFamille = codeFamille;
	}
	
	
	
	public  String getLibelleFamille() {
		return libelleFamille;
	}
	
	public  void setLibelleFamille(String libelleFamille) {
		this.libelleFamille = libelleFamille;
	}
	
	
	
	public Famille() {
		
		
		
	}

	@Override
	public String toString() {
		return "Famille [codeFamille=" + codeFamille + ", libelleFamille=" + libelleFamille + "]";
	}

	

	

	
	
	
	
	
	

}
