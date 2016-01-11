package polytheque.controller;

import java.sql.Date;
import java.util.ArrayList;

import polytheque.model.DAO.AdherentDAO;
import polytheque.model.DAO.EmpruntDAO;
import polytheque.model.DAO.ExtensionDAO;
import polytheque.model.DAO.JeuDAO;
import polytheque.model.DAO.ReservationDAO;
import polytheque.model.pojos.Adherent;
import polytheque.model.pojos.Emprunt;
import polytheque.model.pojos.Extension;
import polytheque.model.pojos.Jeu;
import polytheque.model.pojos.Reservation;
import polytheque.view.TacheDAffichage;

/**
 * Classe représentant le controller, permettant de faire le lien entre l'affichage et les classes métier (DAO, POJOS)
 * 
 * @author Johan Brunet
 *
 */
public class PolythequeApplication {

	private AdherentDAO adherentDAO;
	private JeuDAO jeuDAO;
	private ReservationDAO reservationDAO;
	private ExtensionDAO extensionDAO;
	private EmpruntDAO empruntDAO;

	private TacheDAffichage tacheDAffichageDeLApplication;

	private Adherent adherentCourant;
	private Jeu jeuCourant;

	/**
	 * Constructeur de la classe PolythequeApplication (controller).
	 * Initialisation des DAO.
	 */
	public PolythequeApplication(){
		this.adherentDAO = new AdherentDAO();
		this.jeuDAO = new JeuDAO();
		this.reservationDAO = new ReservationDAO();
		this.extensionDAO = new ExtensionDAO();
	}

	public void associerTacheDAffichage(TacheDAffichage affichageAppli) {
		this.tacheDAffichageDeLApplication = affichageAppli;
	}

	// Partie permettant la gestion des adhérents

	public boolean checkConnexion(String userName, String password) {
		if(this.adherentDAO.connectionAuthorized(userName, password) != null) {
			this.adherentCourant = this.adherentDAO.retreive(this.adherentDAO.connectionAuthorized(userName, password).getIdAdherent());
			return true;
		}
		else {
			return false;
		}
	}

	public boolean checkAdmin() {
		if(this.adherentDAO.isAdmin(this.adherentCourant.getPseudo())) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * 
	 * @return l'adherent courant.
	 */
	public Adherent getAdherentCourant() {
		return this.adherentCourant;
	}

	/**
	 * 
	 * @return la liste de tous les adhérents dans un tableau.
	 */
	public ArrayList<Adherent> getAdherentsList() {
		return this.adherentDAO.getAll();
	}

	public ArrayList<Adherent> searchAdherents(String nomAdherent) {
		return this.adherentDAO.searchByName(nomAdherent);
	}

	/**
	 * 
	 * @param adherent
	 * @return un bool�en disant si l'enregistrement des modifications des informations de l'adh�rent a �t� effectu�.
	 * Et l'adh�rent courant prend la valeur de l'adh�rent apr�s modification. False sinon.
	 */
	public boolean enregistrerModifsAdherent(Adherent adherent) {
		if (this.adherentDAO.update(adherent)) {
			this.adherentCourant = this.adherentDAO.retreive(this.adherentCourant.getIdAdherent());
			return true;
		}
		else {
			return false;
		}
	}

	public Adherent getAdherentByNothing() {

		return this.adherentCourant = this.adherentDAO.retreive(this.adherentCourant.getIdAdherent());
	}

	/**
	 * 
	 * @param pseudo
	 * @return un adh�rent en fonction de son pseudo (qui est unique afin qu'il n'y ait pas de confusion lors de la r�cup�ration de l'adh�rent).
	 */
	public Adherent getAdherent(String pseudo) {
		return this.adherentDAO.getByPseudo(pseudo);
	}

	/**
	 * 
	 * @param adherent
	 * @return true si l'adh�rent a �t� cr��. False sinon.
	 */
	public boolean creerAdherent(Adherent adherent){
		if (this.adherentDAO.create(adherent)) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * 
	 * @param nom
	 * @return true si l'adh�rent a bien �t� supprim�. False sinon.
	 */
	public boolean supprimerAdherent(String pseudo) {
		if (this.adherentDAO.deleteAdherent(pseudo)) {
			return true;
		}
		else {
			return false;
		}
	}

	// Partie permettant la gestion des jeux

	public ArrayList<Jeu> getGamesList() {
		return this.jeuDAO.getAll();
	}

	public ArrayList<Jeu> searchGames(String nomJeu) {
		return this.jeuDAO.searchByName(nomJeu);
	}

	/**
	 * 
	 * @param nom
	 * @return un jeu. On retrouve le jeu on utilise son nom.
	 */
	public Jeu getByName(String nom) {
		return this.jeuDAO.getByName(nom);
	}

	/**
	 * 
	 * @param jeu
	 * @return un bool�en disant si l'enregistrement des modifications des informations du jeu a �t� effectu�.
	 * Et le jeu courant prend la valeur du jeu apr�s modification. False sinon.
	 */
	public boolean enregistrerModifsJeu(Jeu jeu) {
		if (this.jeuDAO.update(jeu, 0, 0)) { 
			this.jeuCourant = this.jeuDAO.retreive(this.jeuCourant.getIdJeu());
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * 
	 * @param jeu
	 * @return un bool�an disant si le jeu a bien �t� cr��. False sinon.
	 */
	public boolean creerJeu(Jeu jeu){
		if (this.jeuDAO.create(jeu)) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * 
	 * @param idJeu
	 * @return un bool�an disant si le jeu a bien �t� supprim�. False sinon.
	 */
	public boolean supprimerJeu(int idJeu) {
		if (this.jeuDAO.delete(idJeu)) {
			return true;
		}
		else {
			return false;
		}
	}

	// Partie permettant la gestion des extensions

	public ArrayList<Extension> getExtensionsList() {
		return this.extensionDAO.getAll();
	}

	public ArrayList<Extension> searchExtensions(String nomExtension) {
		return this.extensionDAO.searchByName(nomExtension);
	}

	/**
	 * 
	 * @param nom
	 * @return une extension. Pour retrouver l'extension on utilise son nom.
	 */
	public Extension getExtByName(String nom) {
		return this.extensionDAO.getExtByName(nom);
	}

	/**
	 * 
	 * @param id
	 * @return une r�servation. Pour retrouver l'extension on utilise son id.
	 */
	public Reservation getById(int id) {
		return this.reservationDAO.getById(id);
	}

	// Partie permettant la gestion des réservations

	/**
	 * 
	 * @return un tableau de toute les r�servations
	 */
	public ArrayList<Reservation> getReservationList() {
		return this.reservationDAO.getAll();
	}

	public ArrayList<Reservation> searchReservations(String nomAdherent) {
		return this.reservationDAO.searchByPseudo(nomAdherent);
	}

	public void annulerReservation(Reservation res) {
		this.reservationDAO.delete(res.getIdReservation());
	}

	public boolean createReservation(Reservation reservation,int idAdherent, int idJeu, int idJextension,Date date) {
		if(this.reservationDAO.create(reservation, idAdherent, idJeu, idJextension)) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean createReservation2(Reservation reservation,int idAdherent, int idJeu,Date date) {
		if(this.reservationDAO.create2(reservation, idAdherent, idJeu)) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean createReservation3(Reservation reservation,int idAdherent, int idExtention,Date date) {
		if(this.reservationDAO.create3(reservation, idAdherent, idExtention)) {
			return true;
		}
		else {
			return false;
		}
	}

	// Partie permettant la gestion des emprunts

	public boolean creerEmprunt(Emprunt emprunt) {
		Date datedeb=emprunt.getDateDebut();
		Adherent adh=emprunt.getAdherent();
		int idAdh=adh.getIdAdherent();
		Jeu jeu=emprunt.getJeu();
		int idJeu = jeu.getIdJeu();
		Extension ext =emprunt.getExtension();
		int idExt=ext.getIdExtension();
		Reservation res = new Reservation(idAdh,idJeu,idExt,datedeb);
		Date datefin=res.modifDate(datedeb,21);
		if (this.empruntDAO.create(datedeb,datefin,res,adh,jeu,ext)) {
			return true;
		}
		return false;
	}

	public void updateRetard() {
		this.adherentDAO.updateRetard(this.adherentCourant.getCompteurRetard(),this.adherentCourant.getIdAdherent());
	}
}