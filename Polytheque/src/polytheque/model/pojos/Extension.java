package polytheque.model.pojos;

/**
 * Classe permettant de représenter une extension de jeu
 * 
 * @author Johan Brunet
 *
 */
public class Extension {

	private int idExtension;
	private String nom;
	private String description;
	private String statut;
	private int nbExemplaires;
	private int nbReserves;
	private int nbEmpruntes;
	private int idJeu;

	public Extension(String nom, String desc, String statut, int nbExemplaires, int nbReserves,int nbEmpruntes, int idJeu) {
		this.setNom(nom);
		this.setDescription(desc);
		this.setStatut(statut);
		this.setNbExemplaires(nbExemplaires);
		this.setNbReserves(nbReserves);
		this.setNbEmpruntes(nbEmpruntes);
		this.setIdJeu(idJeu);
	}
	
	public Extension(int id, String nom, String desc, String statut, int nbExemplaires, int nbReserves,int nbEmpruntes,int idJeu) {
		this.setIdExtension(id);
		this.setNom(nom);
		this.setDescription(desc);
		this.setStatut(statut);
		this.setNbExemplaires(nbExemplaires);
		this.setNbReserves(nbReserves);
		this.setNbEmpruntes(nbEmpruntes);
		this.setIdJeu(idJeu);
	}

	public int getIdExtension() {
		return idExtension;
	}

	public void setIdExtension(int idExtension) {
		this.idExtension = idExtension;
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

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
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

	
	public void setNbEmpruntes(int nbempruntes) {
		this.nbEmpruntes = nbempruntes;
	}
	
	public int getNbEmpruntes() {
		return nbEmpruntes;
	}
	
	public int getIdJeu() {
		return idJeu;
	}

	public void setIdJeu(int nomJeu) {
		this.idJeu = nomJeu;
	}
}
