package polytheque.model.pojos;

import java.util.Calendar;

/**
 * Classe permettant de définir un adhérent
 * 
 * @author Godefroi Roussel
 *
 */

public class Adherent {

	private String nom;
	private String prenom;
	private int age;
	private String rue;
	private int CP;
	private String ville;
	private String mail;
	private int telephone;
	private String pseudo;
	private String mdp;
	private boolean estAJour;
	private boolean peutEmprunter;
	private int cptRetard;
	
	/**
	 * 
	 * @param nom
	 * @param prenom
	 * @param age
	 * @param adresse
	 * @param cp
	 * @param Ville
	 * @param mail
	 * @param tel
	 * @param pseudo
	 * @param MDP
	 * @param estAJour
	 * @param peutEmprunter
	 * @param cptRetard
	 */
	
	public Adherent(String nom, String prenom, int age, String adresse, int cp, String Ville, String mail, int tel, String pseudo, String MDP, boolean estAJour, boolean peutEmprunter){
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.rue = adresse;
		this.CP = cp;
		this.ville = Ville;
		this.mail = mail;
		this.pseudo = pseudo;
		this.mdp = MDP;
		this.estAJour = estAJour;
		this.peutEmprunter = peutEmprunter;
		this.cptRetard = 0;
	}

	/**
	 * 
	 * @return le nom de l'adhérent
	 */
	
	public String getNom() {
		return nom;
	}
	
	/**
	 * 
	 * @param nom
	 * Permet de changer le nom de l'adhérent (fonction disponible que par l'administrateur)
	 */
	
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * 
	 * @return le prénonom de l'adhérent
	 */
	
	public String getPrenom() {
		return prenom;
	}

	/**
	 * 
	 * @param prenom
	 * Permet de changer le prénom de l'adhérent (fonction disponible que par l'administrateur)
	 */
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	/**
	 * 
	 * @return l'âge de l'adhérent
	 */
	
	public int getAge() {
		return age;
	}

	/**
	 * 
	 * @param age
	 * Permet de changer la date de naissance de l'adhérent (fonction disponible que par l'administrateur)
	 */
	
	public void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * 
	 * @return la rue de l'adhérent
	 */
	
	public String getRue() {
		return rue;
	}

	/**
	 * 
	 * @param rue
	 * Permet de changer la rue de l'adhérent
	 */
	
	public void setRue(String rue) {
		this.rue = rue;
	}

	/**
	 * 	
	 * @return le Code Postal de l'adhérent
	 */
	
	public int getCP() {
		return CP;
	}

	/**
	 * 
	 * @param cP 
	 * Permet de changer le Code Postal de l'adhérent
	 */
	
	public void setCP(int cP) {
		CP = cP;
	}

	/**
	 * 
	 * @return le nom de la ville de l'adhérent
	 */
	
	public String getVille() {
		return ville;
	}

	/**
	 * 
	 * @param ville
	 * Permet de changer la ville de l'adhérent
	 */
	
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * 
	 * @return l'adresse mail de l'adhérent
	 */
	
	public String getMail() {
		return mail;
	}

	/**
	 * 
	 * @param mail
	 * Permet de changer l'adresse mail de l'adhérent
	 */
	
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * 
	 * @return le numéro de téléphone de l'adhérent
	 */
	
	public int getTelephone() {
		return telephone;
	}

	/**
	 * 
	 * @param telephone
	 * Permet de changer le numéro de téléphone de l'adhérent
	 */
	
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	/**
	 * 
	 * @return le pseudo qu'a choisi l'adhérent
	 */
	
	public String getPseudo() {
		return pseudo;
	}

	/**
	 * 
	 * @param pseudo
	 * Permet de changer le pseudo de l'adhérent
	 */
	
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	/**
	 * 
	 * @return le mot de passe de l'adhérent
	 */
	
	public String getMdp() {
		return mdp;
	}

	/**
	 * 
	 * @param mdp
	 * Permet de changer le mot de passe de l'adhérent
	 */
	
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	/**
	 * 
	 * @return un booléen disant si l'adhérent est à jour
	 */
	
	public boolean isEstAJour() {
		return estAJour;
	}

	/**
	 * 
	 * @param estAJour
	 * Permet de changer le booléen disant si l'adhérent est à jour
	 */
	
	public void setEstAJour(boolean estAJour) {
		this.estAJour = estAJour;
	}

	/**
	 * 
	 * @return le booléen disant si l'adhérent est à jour
	 */
	
	public boolean isPeutEmprunter() {
		return peutEmprunter;
	}

	/**
	 * 
	 * @param peutEmprunter
	 * Permet de changer le booléen disant si l'adhérent est à jour
	 */
	
	public void setPeutEmprunter(boolean peutEmprunter) {
		this.peutEmprunter = peutEmprunter;
	}

	/**
	 * 
	 * @return le nombre de retard accumulé par le client
	 */
	
	public int getCompteurRetard(){
		return this.cptRetard;
	}
	
	/**
	 * 
	 * @param ajoutRetard
	 * Permet de modifier le nombre de retard accumulé par le client
	 */
	
	public void setCompteurRetard(int ajoutRetard){
		this.cptRetard = ajoutRetard; 
	}
	
	public void ajoutCompteurRetard(){
		this.cptRetard +=1;
	}
	
	/**
	 * 
	 * @param e
	 * Cette fonction permet de savoir si l'adhérent est en retard pour rendre son jeu et on 
	 * Question est-ce qu'on rajoute un retard pour chaque jour ou ça compte juste +1 pour un jeu?
	 */
	public void estEnRetard(Emprunt e){
		//Par défaut, date d'aujourd'hui
        Calendar calAujourdhui = Calendar.getInstance();
        if(e.getDateFin().before(calAujourdhui)){
        	// vérification si l'ajout de est en retard à déjà été effectué pour ce jeu?
			ajoutCompteurRetard(); //compteurRetard à ajouter sur la structure de donnée (initialisé à 0 à la création de la variable)
        }
	}
	
	
	
}
