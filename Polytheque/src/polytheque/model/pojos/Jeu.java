package polytheque.model.pojos;

public class Jeu {

   private String nom;
   private String description;
   private int ageMini;
   private String edition;
   private boolean disponibilite;
   private String etat;
   private String status;
   private String anneeParution;
   
   public Jeu(String nom, String description, int ageMini, String edition, boolean disponibilite, String etat,
			String statut, String anneeParution) {
		this.setNom(nom);
		this.setDescription(description);
		this.setAgeMini(ageMini);
		this.setEdition(edition);
		this.setDisponibilite(disponibilite);
		this.setEtat(etat);
		this.setStatus(statut);
		this.setAnneeParution(anneeParution);
	}

   public String getNom() {
	   return nom;
   }
   
   public void setNom(String nom) {
	   this.nom = nom;
   }
   
   public String getDescription() {
	   return description;
   }
   
   public void setDescription(String description) {
	   this.description = description;
   }
   
   public int getAgeMini() {
	   return ageMini;
   }
   
   public void setAgeMini(int ageMini) {
	   this.ageMini = ageMini;
   }
   
   public String getEdition() {
	   return edition;
   }
   
   public void setEdition(String edition) {
	   this.edition = edition;
   }
   
   public boolean disponibilite() {
	   return disponibilite;
   }
   
   public void setDisponibilite(boolean disponibilite) {
	   this.disponibilite = disponibilite;
   }
   
   public String getEtat() {
	   return etat;
   }
   
   public void setEtat(String etat) {
	   this.etat = etat;
   }
   
   public String getStatus() {
	   return status;
   }
   
   public void setStatus(String status) {
	   this.status = status;
   }
   
   public String getAnneeParution() {
	   return anneeParution;
   }
   
   public void setAnneeParution(String anneeParution) {
	   this.anneeParution = anneeParution;
   }
   
}
