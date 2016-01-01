package polytheque.model.pojos;

import java.sql.Date;

/**
 * Classe permettant de représenter un emprunt
 * 
 * @author Laure Marchal
 */
public class Emprunt {

	private Adherent adherent;
	private Jeu jeu;
	private Extension extention;
	private Date dateDebut;
	private Date dateFin;
	private Date dateRendu;
	private boolean retardCompte;

	/**
	 * Constructeur de la classe Emprunt
	 * Pour un jeu uniquement
	 * 
	 * @param adherent
	 * 				l'adhérent qui emprunte
	 * @param extention
	 * 				l'extention à emprunter
	 * @param dateDebut
	 * 				la date du début de l'emprunt
	 * @param dateFin
	 * 				la date de fin de l'emprunt
	 */	
	public Emprunt(Adherent adherent,Jeu jeu, Date dateDebut, Date dateFin, Date dateRendu, boolean retard) {
		this.setAdherent(adherent);
		this.setJeu(jeu);
		this.setDateDebut(dateDebut);
		this.setDateFin(dateFin);
		this.setDateRendu(dateRendu);
		this.setRetard(retard);
	}


	/**
	 * Constructeur de la classe Emprunt
	 * Pour une extension uniquement
	 * 
	 * @param adherent
	 * 				l'adhérent qui emprunte
	 * @param extention
	 * 				l'extention à emprunter
	 * @param dateDebut
	 * 				la date du début de l'emprunt
	 * @param dateFin
	 * 				la date de fin de l'emprunt
	 */
	public Emprunt(Adherent adherent, Extension extention, Date dateDebut,Date dateFin, Date dateRendu) {
		this.setAdherent(adherent);
		this.setExtension(extention);
		this.setDateDebut(dateDebut);
		this.setDateFin(dateFin);
		this.setDateRendu(dateRendu);
	}

	/**
	 * Constructeur de la classe Emprunt
	 * Pour un jeu et une extension
	 * 
	 * @param adherent
	 * 				l'adhérent qui emprunte
	 * @param jeu
	 * 				le jeu à emprunter
	 * @param extention
	 * 				l'extention à emprunter
	 * @param dateDebut
	 * 				la date du début de l'emprunt
	 * @param dateFin
	 * 				la date de fin de l'emprunt
	 */
	public Emprunt(Adherent adherent,Jeu jeu, Extension extention, Date dateDebut,Date dateFin) {
		this.setAdherent(adherent);
		this.setJeu(jeu);
		this.setExtension(extention);
		this.setDateDebut(dateDebut);
		this.setDateFin(dateFin);
	}

	public Adherent getAdherent() {
		return this.adherent;
	}

	public void setAdherent(Adherent adherent) {
		this.adherent = adherent;
	}

	public Jeu getJeu() {
		return jeu;
	}

	public void setJeu(Jeu jeu) {
		this.jeu = jeu;
	}

	public Extension getExtension() {
		return this.extention;
	}

	public void setExtension(Extension extention) {
		this.extention = extention;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public boolean getRetard(){
		return retardCompte;
	}

	public void setRetard(boolean retard) {
		this.retardCompte = retard;
	}

	/**
	 * Cette fonction permet d'ajouter 1 au nombre de retard deja effectue par l'adherent et modifie la variable disant que l'adherent est en retard pour ne pas compter plusieurs retard concernant un meme jeu
	 */
	public void ajoutRetard(){
		if(estEnRetard() && !(dejaEnRetard())){ // On verifie que l'adherent est en retard pour rendre son jeu et si le jeu est deja en retard
			this.adherent.ajoutCompteurRetard();
			this.setRetard(true);
		}
	}

	/**
	 * 
	 * @param emprunt
	 * @return true si la date de fin de l'emprunt est inferieur � la date du jour, false sinon
	 */
	public boolean estEnRetard(){
		//Par defaut, date d'aujourd'hui
		Date currentDate = new Date(new java.util.Date().getTime());
		if(this.getDateFin().before(currentDate)){ 
			return true;
		}
		else 
			return false; 
	}

	/**
	 * 
	 * @param emprunt
	 * @return vrai si l'emprunt est en retard, faux sinon
	 */
	public boolean dejaEnRetard(){
		return this.retardCompte;
	}

	/**
	 * 
	 * @param e
	 * Permet de dire qu'un emprunt est ramen� et donc de remettre les valeurs de l'emprunt � leurs �tats initiaux
	 */
	public void annulerEmprunt(){
		//v�rifier le nombre d'extension emprunter par l'adh�rent
		//v�rifier que l'adh�rent � tout ramener
		this.adherent.setPeutEmprunter(true);
		this.jeu.setDisponibilite(true);
		this.jeu.setNbReserves(this.jeu.getNbReserves()+1);
		this.extention.setNbReserves(this.extention.getNbReserves()+1);
		ajoutRetard();
	}


	public Date getDateRendu() {
		return dateRendu;
	}


	public void setDateRendu(Date dateRendu) {
		this.dateRendu = dateRendu;
	}
}
