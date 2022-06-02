package vDev;

public class TypeMateriel {

    private String referenceInterne;
    private String libelleTypeMateriel;
    private Famille laFamille;

    

    public TypeMateriel() {
		
	}

	@Override
	public String toString() {
		return "TypeMateriel [referenceInterne=" + referenceInterne + ", libelleTypeMateriel=" + libelleTypeMateriel
				+ ", laFamille=" + laFamille + "]";
	}

	public String getReferenceInterne() {
          return referenceInterne;
    }

    public void setReferenceInterne(String i) {
          this.referenceInterne = i;
    }

    public String getLibelleTypeMateriel() {
          return libelleTypeMateriel;
    }

    public void setLibelleTypeMateriel(String libelleTypeMateriel) {
          this.libelleTypeMateriel = libelleTypeMateriel;
    }

    public Famille getLaFamille() {
          return laFamille;
    }

    public void setLaFamille(Famille laFamille) {
          this.laFamille = laFamille;
    }
}
