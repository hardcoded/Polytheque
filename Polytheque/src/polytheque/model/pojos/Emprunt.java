package polytheque.model.pojos;

import java.util.Calendar;

/**
 * Classe permettant de reprÃ©senter un emprunt
 * 
 * @author Laure Marchal
 */
public class Emprunt {

	private Adherent adherent;
	private Jeu jeu;
	private Extension extention;
	private Calendar dateDebut;
	private Calendar dateFin;
	private boolean retardCompte;

	/**
	 * Constructeur de la classe Emprunt
	 * Pour un jeu uniquement
	 * 
	 * @param adherent
	 * 				l'adhÃ©rent qui emprunte
	 * @param extention
	 * 				l'extention Ã  emprunter
	 * @param dateDebut
	 * 				la date du dÃ©but de l'emprunt
	 * @param dateFin
	 * 				la date de fin de l'emprunt
	 */	
	public Emprunt(Adherent adherent,Jeu jeu, Calendar dateDebut,Calendar dateFin, boolean retard) {
		this.setAdherent(adherent);
		this.setJeu(jeu);
		this.setDateDebut(dateDebut);
		this.setDateFin(dateFin);
		this.setRetard(retard);
	}


	/**
	 * Constructeur de la classe Emprunt
	 * Pour une extension uniquement
	 * 
	 * @param adherent
	 * 				l'adhÃ©rent qui emprunte
	 * @param extention
	 * 				l'extention Ã  emprunter
	 * @param dateDebut
	 * 				la date du dÃ©but de l'emprunt
	 * @param dateFin
	 * 				la date de fin de l'emprunt
	 */
	public Emprunt(Adherent adherent, Extension extention, Calendar dateDebut,Calendar dateFin) {
		this.setAdherent(adherent);
		this.setExtension(extention);
		this.setDateDebut(dateDebut);
		this.setDateFin(dateFin);
	}

	/**
	 * Constructeur de la classe Emprunt
	 * Pour un jeu et une extension
	 * 
	 * @param adherent
	 * 				l'adhÃ©rent qui emprunte
	 * @param jeu
	 * 				le jeu Ã  emprunter
	 * @param extention
	 * 				l'extention Ã  emprunter
	 * @param dateDebut
	 * 				la date du dÃ©but de l'emprunt
	 * @param dateFin
	 * 				la date de fin de l'emprunt
	 */
	public Emprunt(Adherent adherent,Jeu jeu, Extension extention, Calendar dateDebut,Calendar dateFin) {
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

	public Calendar getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Calendar dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Calendar getDateFin() {
		return dateFin;
	}

	public void setDateFin(Calendar dateFin) {
		this.dateFin = dateFin;
	}

	public boolean getRetard(){
		return retardCompte;
	}

	public void setRetard(boolean retard) {
		this.retardCompte = retard;
	}

	Emprunt emprunterJeu(Adherent adh, Jeu jeu, Calendar dateDebut, Calendar dateFin, boolean retard){
		return new Emprunt(adh, jeu, dateDebut, dateFin, retard);
	}

	Emprunt emprunterExtension(Adherent adh, Extension extension, Calendar dateDebut, Calendar dateFin){
		return new Emprunt(adh, extension, dateDebut, dateFin);
	}

	Emprunt emprunterJeuExtension(Adherent adh, Jeu jeu, Extension extension, Calendar dateDebut, Calendar dateFin){
		return new Emprunt(adh, jeu, extension, dateDebut, dateFin);
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
	 * @return true si la date de fin de l'emprunt est inferieur ï¿½ la date du jour, false sinon
	 */
	public boolean estEnRetard(){
		//Par defaut, date d'aujourd'hui
		Calendar currentDate = Calendar.getInstance();
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
	 * Permet de dire qu'un emprunt est ramené et donc de remettre les valeurs de l'emprunt à leurs états initiaux
	 */
	public void annulerEmprunt(){
		//vérifier le nombre d'extension emprunter par l'adhérent
		//vérifier que l'adhérent à tout ramener
		this.adherent.setPeutEmprunter(true);
		this.jeu.setDisponibilite(true);
		this.jeu.setNbReserves(this.jeu.getNbReserves()+1);
		this.extention.setNbReserves(this.extention.getNbReserves()+1);
		ajoutRetard();
	}


}
