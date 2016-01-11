package polytheque.model.pojos;

import java.sql.Date;

/**
 * Classe permettant de représenter un adhérent
 * 
 * @author Godefroi Roussel
 *
 */
public class Adherent {

	private int idAdherent;
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private String rue;
	private String cp;
	private String ville;
	private String mail;
	private String telephone;
	private String pseudo;
	private String mdp;
	private boolean isAdmin;
	private boolean peutEmprunter;
	private boolean estAJour;
	private int cptRetard;
	private int nbNonRecup;

	/**
	 * Constructeur de la classe Adherent, permet de créer un nouvel adhérent
	 * Le compteur de retards est donc à 0 de base
	 * 
	 * @param nom
	 * 			nom de l'adhérent
	 * @param prenom
	 * 			prénom de l'adhérent
	 * @param dateNaissance
	 * 			la date de naissance de l'adherent
	 * @param rue
	 * 			rue de l'adhérent
	 * @param cp
	 * 			code postal de l'adhérent
	 * @param ville
	 * 			ville de l'adhérent
	 * @param mail
	 * 			adresse mail de l'adhérent
	 * @param tel
	 * 			numéro de téléphone de l'adhérent
	 * @param pseudo
	 * 			pseudo de l'adhérent
	 * @param mdp
	 * 			mot de passe de l'adhérent
	 * @param estAJour
	 * 			l'adhérent est à jour ou non dans le paiement de ses droits
	 * @param peutEmprunter
	 * 			l'adhérent a le droit d'emprunter un jeu ou une extension
	 * @param cptRetard
	 * 			nombre de retards comptabilisés par l'adhérent
	 */	
	public Adherent(String nom, String prenom, Date dateNaissance, String adresse, String cp, String ville, 
			String mail, String tel, String pseudo, String mdp, boolean isAdmin){
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.rue = adresse;
		this.cp = cp;
		this.ville = ville;
		this.mail = mail;
		this.pseudo = pseudo;
		this.mdp = mdp;
		this.isAdmin = isAdmin;
		this.peutEmprunter = true;
		this.estAJour = true;
		this.cptRetard = 0;
		this.nbNonRecup = 0;
	}

	/**
	 * Constructeur de la classe Adherent, permet de créer un Adhérent à partir des données existantes
	 * 
	 * @param nom
	 * 			nom de l'adhérent
	 * @param prenom
	 * 			prénom de l'adhérent
	 * @param age
	 * 			age de l'adhérent
	 * @param rue
	 * 			rue de l'adhérent
	 * @param cp
	 * 			code postal de l'adhérent
	 * @param ville
	 * 			ville de l'adhérent
	 * @param mail
	 * 			adresse mail de l'adhérent
	 * @param tel
	 * 			numéro de téléphone de l'adhérent
	 * @param pseudo
	 * 			pseudo de l'adhérent
	 * @param mdp
	 * 			mot de passe de l'adhérent
	 * @param estAJour
	 * 			l'adhérent est à jour ou non dans le paiement de ses droits
	 * @param peutEmprunter
	 * 			l'adhérent a le droit d'emprunter un jeu ou une extension
	 * @param nbRetards
	 * 			nombre de retards comptabilisés par l'adhérent
	 */	
	public Adherent(int id, String nom, String prenom, Date dateNaissance, String adresse, String cp, String ville, 
			String mail, String tel, String pseudo, String mdp, boolean isAdmin, boolean peutEmprunter, 
			boolean estAJour, int nbRetards, int nbNonRecup){
		this.idAdherent = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.rue = adresse;
		this.cp = cp;
		this.ville = ville;
		this.mail = mail;
		this.telephone = tel;
		this.pseudo = pseudo;
		this.mdp = mdp;
		this.isAdmin = isAdmin;
		this.estAJour = estAJour;
		this.peutEmprunter = peutEmprunter;
		this.cptRetard = nbRetards;
		this.nbNonRecup = nbNonRecup;
	}
	
	/**
	 * Constructeur de la classe Adherent, permet de cr�er un Adh�rent � partir des donn�es existantes
	 * @param nom
	 * @param prenom
	 * @param dateNaissance
	 * @param adresse
	 * @param cp
	 * @param ville
	 * @param mail
	 * @param tel
	 * @param pseudo
	 * @param mdp
	 * @param isAdmin
	 * @param peutEmprunter
	 * @param estAJour
	 * @param nbRetards
	 */
	public Adherent(String nom, String prenom, Date dateNaissance, String adresse, String cp, String ville, 
			String mail, String tel, String pseudo, String mdp, boolean isAdmin, boolean peutEmprunter, 
			boolean estAJour, int nbRetards){
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.rue = adresse;
		this.cp = cp;
		this.ville = ville;
		this.mail = mail;
		this.telephone = tel;
		this.pseudo = pseudo;
		this.mdp = mdp;
		this.isAdmin = isAdmin;
		this.estAJour = estAJour;
		this.peutEmprunter = peutEmprunter;
		this.cptRetard = nbRetards;
	}

	/**
	 * Obtenir le nom de l'adherent
	 * 
	 * @return Le nom de l'adherent
	 */

	public String getNom() {
		return this.nom;
	}

	/**
	 * Modifier le nom de l'adherent
	 * Utilisable uniquement par un administrateur
	 * 
	 * @param nom
	 * 			le nom de l'adherent
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Obtenir le prenom de l'adherent
	 * 
	 * @return le prenom de l'adherent
	 */	
	public String getPrenom() {
		return this.prenom;
	}

	/**
	 * Modifier le prénom de l'adhérent
	 * Utilisable uniquement par un administrateur
	 * 
	 * @param prenom
	 * 			le prénom de l'adhérent
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Obtenir la rue de l'adhérent
	 * 
	 * @return la rue de l'adhérent
	 */
	public String getRue() {
		return this.rue;
	}

	/**
	 * Modifier la rue de l'adhérent
	 * Utilisable uniquement par un administrateur
	 * 
	 * @param rue
	 * 			la rue de l'adhérent
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}

	/**
	 * Obtenir le code postal de l'adhérent
	 * 
	 * @return le code postal de l'adhérent
	 */
	public String getCP() {
		return this.cp;
	}

	/**
	 * Modifier le code postal de l'adhérent
	 * Utilisable uniquement par un administrateur
	 * 
	 * @param cp
	 * 			le code postal de l'adhérent
	 */
	public void setCP(String cp) {
		this.cp = cp;
	}

	/**
	 * Obtenir la ville de l'adhérent
	 * 
	 * @return la ville de l'adhérent
	 */
	public String getVille() {
		return this.ville;
	}

	/**
	 * Modifier la ville de l'adhérent
	 * Utilisable uniquement par un administrateur
	 * 
	 * @param ville
	 * 			la ville de l'adhérent
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * Obtenir l'adresse mail de l'adhérent
	 * 
	 * @return le mail de l'adhérent
	 */
	public String getMail() {
		return this.mail;
	}

	/**
	 * Modifier le mail de l'adhérent
	 * Utilisable uniquement par un administrateur
	 * 
	 * @param mail
	 * 			le mail de l'adhérent
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * Obtenir le numéro de téléphone de l'adhérent
	 * 
	 * @return le téléphone de l'adhérent
	 */
	public String getTelephone() {
		return this.telephone;
	}

	/**
	 * Modifier le numéro de téléphone de l'adhérent
	 * Utilisable uniquement par un administrateur
	 * 
	 * @param telephone
	 * 			le numéro de téléphone de l'adhérent
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * Obtenir le pseudo de l'adhérent
	 * 
	 * @return le pseudo de l'adhérent
	 */
	public String getPseudo() {
		return this.pseudo;
	}

	/**
	 * Modifier le pseudo de l'adhérent
	 * Utilisable uniquement par un administrateur
	 * 
	 * @param pseudo
	 * 			le pseudo de l'adhérent
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	/**
	 * Obtenir le mot de passe de l'adhérent
	 * 
	 * @return le mot de passe de l'adhérent
	 */
	public String getMdp() {
		return this.mdp;
	}

	/**
	 * Modifier le mot de passe de l'adhérent
	 * Utilisable uniquement par un administrateur
	 * 
	 * @param mdp
	 * 			le mot de passe de l'adhérent
	 */
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	/**
	 * Obtenir l'état des droits de l'adhérent
	 * 
	 * @return true si l'adhérent est à jour dans ses droits, false sinon
	 */
	public boolean estAJour() {
		return this.estAJour;
	}

	/**
	 * Modifier l'état des droits de l'adhérent
	 * Utilisable uniquement par un administrateur
	 * 
	 * @param estAJour
	 * 			la validité des droits de l'adhérent
	 */
	public void setEstAJour(boolean estAJour) {
		this.estAJour = estAJour;
	}

	/**
	 * Savoir si l'adhérent peut emprunter ou pas
	 * 
	 * @return true si l'adhérent peut emprunter, false sinon
	 */
	public boolean peutEmprunter() {
		return this.peutEmprunter;
	}

	/**
	 * Modifier la possibilité d'emprunter de l'adhérent
	 * Utilisable uniquement par un administrateur
	 * 
	 * @param peutEmprunter
	 * 			la possibilité d'emprunter de l'adhérent
	 */
	public void setPeutEmprunter(boolean peutEmprunter) {
		this.peutEmprunter = peutEmprunter;
	}

	/**
	 * Obtenir le nombre de retards cumulés par l'adhérent
	 * 
	 * @return le nombre de retard de l'adhérent
	 */
	public int getCompteurRetard(){
		return this.cptRetard;
	}

	/**
	 * Modifier le nombre de retards de l'adhérent
	 * Utilisable uniquement par un administrateur
	 * 
	 * @param nbRetards
	 * 			le nombre de retards de l'adhérent
	 */
	public void setCompteurRetard(int nbRetards){
		this.cptRetard = nbRetards; 
	}

	/**
	 * Ajouter un retard au compteur de l'adhérent
	 */
	public void ajoutCompteurRetard(){
		this.cptRetard ++;
	}

	public int getIdAdherent() {
		return idAdherent;
	}

	public void setIdAdherent(int idAdherent) {
		this.idAdherent = idAdherent;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public int getNbNonRecup() {
		return nbNonRecup;
	}

	public void setNbNonRecup(int nbNonRecup) {
		this.nbNonRecup = nbNonRecup;
	}
}
