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
   private int nbExemplaires;
   private int nbReserves;
   private int nbJoueurs;
   
   public Jeu(String nom, String description, int ageMini, String edition, boolean disponibilite, String etat,
			String statut, String anneeParution, int nbExemplaires, int nbReserves, int nbJoueurs) {
		this.setNom(nom);
		this.setDescription(description);
		this.setAgeMini(ageMini);
		this.setEdition(edition);
		this.setDisponibilite(disponibilite);
		this.setEtat(etat);
		this.setStatus(statut);
		this.setAnneeParution(anneeParution);
		this.setNbExemplaires(nbExemplaires);
		this.setNbReserves(nbReserves);
		this.setNbJoueurs(nbJoueurs);
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
   
   public boolean isDisponibilite() {
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

   public int getNbExemplaires() {
	   return nbExemplaires;
   }

   public void setNbExemplaires(int nbExemplaires) {
	   this.nbExemplaires = nbExemplaires;
   }

   public int getNbReserves() {
	   return nbReserves;
   }

   public void setNbReserves(int nbReserves) {
	   this.nbReserves = nbReserves;
   }

   public int getNbJoueurs() {
	   return nbJoueurs;
   }

   public void setNbJoueurs(int nbJoueurs) {
	   this.nbJoueurs = nbJoueurs;
   }
}
