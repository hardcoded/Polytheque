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
	 * @return le nom de l'adh�rent
	 */
	
	public String getNom() {
		return nom;
	}
	
	/**
	 * 
	 * @param nom
	 * Permet de changer le nom de l'adh�rent (fonction disponible que par l'administrateur)
	 */
	
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * 
	 * @return le pr�nonom de l'adh�rent
	 */
	
	public String getPrenom() {
		return prenom;
	}

	/**
	 * 
	 * @param prenom
	 * Permet de changer le pr�nom de l'adh�rent (fonction disponible que par l'administrateur)
	 */
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	/**
	 * 
	 * @return l'�ge de l'adh�rent
	 */
	
	public int getAge() {
		return age;
	}

	/**
	 * 
	 * @param age
	 * Permet de changer la date de naissance de l'adh�rent (fonction disponible que par l'administrateur)
	 */
	
	public void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * 
	 * @return la rue de l'adh�rent
	 */
	
	public String getRue() {
		return rue;
	}

	/**
	 * 
	 * @param rue
	 * Permet de changer la rue de l'adh�rent
	 */
	
	public void setRue(String rue) {
		this.rue = rue;
	}

	/**
	 * 	
	 * @return le Code Postal de l'adh�rent
	 */
	
	public int getCP() {
		return CP;
	}

	/**
	 * 
	 * @param cP 
	 * Permet de changer le Code Postal de l'adh�rent
	 */
	
	public void setCP(int cP) {
		CP = cP;
	}

	/**
	 * 
	 * @return le nom de la ville de l'adh�rent
	 */
	
	public String getVille() {
		return ville;
	}

	/**
	 * 
	 * @param ville
	 * Permet de changer la ville de l'adh�rent
	 */
	
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * 
	 * @return l'adresse mail de l'adh�rent
	 */
	
	public String getMail() {
		return mail;
	}

	/**
	 * 
	 * @param mail
	 * Permet de changer l'adresse mail de l'adh�rent
	 */
	
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * 
	 * @return le num�ro de t�l�phone de l'adh�rent
	 */
	
	public int getTelephone() {
		return telephone;
	}

	/**
	 * 
	 * @param telephone
	 * Permet de changer le num�ro de t�l�phone de l'adh�rent
	 */
	
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	/**
	 * 
	 * @return le pseudo qu'a choisi l'adh�rent
	 */
	
	public String getPseudo() {
		return pseudo;
	}

	/**
	 * 
	 * @param pseudo
	 * Permet de changer le pseudo de l'adh�rent
	 */
	
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	/**
	 * 
	 * @return le mot de passe de l'adh�rent
	 */
	
	public String getMdp() {
		return mdp;
	}

	/**
	 * 
	 * @param mdp
	 * Permet de changer le mot de passe de l'adh�rent
	 */
	
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	/**
	 * 
	 * @return un bool�en disant si l'adh�rent est � jour
	 */
	
	public boolean isEstAJour() {
		return estAJour;
	}

	/**
	 * 
	 * @param estAJour
	 * Permet de changer le bool�en disant si l'adh�rent est � jour
	 */
	
	public void setEstAJour(boolean estAJour) {
		this.estAJour = estAJour;
	}

	/**
	 * 
	 * @return le bool�en disant si l'adh�rent est � jour
	 */
	
	public boolean isPeutEmprunter() {
		return peutEmprunter;
	}

	/**
	 * 
	 * @param peutEmprunter
	 * Permet de changer le bool�en disant si l'adh�rent est � jour
	 */
	
	public void setPeutEmprunter(boolean peutEmprunter) {
		this.peutEmprunter = peutEmprunter;
	}

	/**
	 * 
	 * @return le nombre de retard accumul� par le client
	 */
	
	public int getCompteurRetard(){
		return this.cptRetard;
	}
	
	/**
	 * 
	 * @param ajoutRetard
	 * Permet de modifier le nombre de retard accumul� par le client
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
	 * Cette fonction permet de savoir si l'adh�rent est en retard pour rendre son jeu et on 
	 * Question est-ce qu'on rajoute un retard pour chaque jour ou �a compte juste +1 pour un jeu?
	 */
	public void estEnRetard(Emprunt e){
		//Par d�faut, date d'aujourd'hui
        Calendar calAujourdhui = Calendar.getInstance();
        if(e.getDateFin().before(calAujourdhui)){
        	// v�rification si l'ajout de est en retard � d�j� �t� effectu� pour ce jeu?
			ajoutCompteurRetard(); //compteurRetard � ajouter sur la structure de donn�e (initialis� � 0 � la cr�ation de la variable)
        }
	}
	
	
	
}
