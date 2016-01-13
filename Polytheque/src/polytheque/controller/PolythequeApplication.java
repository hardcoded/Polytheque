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
 * @author Johan Brunet, Yves-alain Agbodjogbe, Laure Marchal, San Wei Lee, Godefroi roussel
 *
 */
public class PolythequeApplication {

	/**
	 * DAOs permettant l'interraction avec la base de données.
	 */
	private AdherentDAO adherentDAO;
	private JeuDAO jeuDAO;
	private ReservationDAO reservationDAO;
	private ExtensionDAO extensionDAO;
	private EmpruntDAO empruntDAO;

	/**
	 * Gestion de la vue de l'application.
	 */
	private TacheDAffichage tacheDAffichageDeLApplication;

	/**
	 * L'adhérent connecté à l'application.
	 */
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

	/**
	 * Méthode permettant d'associer la vue au controller
	 * 
	 * @param affichageAppli
	 * 			La vue de l'application.
	 */
	public void associerTacheDAffichage(TacheDAffichage affichageAppli) {
		this.tacheDAffichageDeLApplication = affichageAppli;
	}

	// Partie permettant la gestion des adhérents

	/**
	 * Méthode permettant de vérifier si la connexion demandée est valide.
	 * 
	 * @param userName
	 * 			Le pseudo de l'adhérent qui tente de se connecter.
	 * @param password
	 * 			Le mot de passe de l'adhérent qui tente de se connecter.
	 * @return true si la connexion est valide (identifiants existants + bonne combinaison pseudo/mdp), false sinon.
	 */
	public boolean checkConnexion(String userName, String password) {
		if(this.adherentDAO.connectionAuthorized(userName, password) != null) {
			this.adherentCourant = this.adherentDAO.retreive(this.adherentDAO.connectionAuthorized(userName, password).getIdAdherent());
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Méthode permettant de vérifier si l'adhérent qui vient de se connecter à l'application est un administrateur.
	 * 
	 * @return true si l'adhérent est un administrateur, false sinon.
	 */
	public boolean checkAdmin() {
		if(this.adherentDAO.isAdmin(this.adherentCourant.getPseudo())) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Méthode permettant de récupérer l'adhérent courant (celui qui est connecté)
	 * 
	 * @return l'adherent courant.
	 */
	public Adherent getAdherentCourant() {
		return this.adherentCourant;
	}

	/**
	 * 	Méthode permettant de récupérer la liste de tous les adhérents présents dans la BDD.
	 * 
	 * @return La liste de tous les adhérents dans un tableau.
	 */
	public ArrayList<Adherent> getAdherentsList() {
		return this.adherentDAO.getAll();
	}

	/**
	 * Méthode permettant de récupérer les adhérents par leur nom ou un bout de leur nom.
	 * 
	 * @param nomAdherent
	 * 			Le nom ou bout de nom de l'adhérent/des adhérents à récupérer
	 * @return La liste des adhérents correspondants
	 */
	public ArrayList<Adherent> searchAdherents(String nomAdherent) {
		return this.adherentDAO.searchByName(nomAdherent);
	}

	/**
	 * Méthode pour la modification des informations d'un adhérent, charge les nouvelles données 
	 * concernant l'adhérent après modification.
	 * @param adherent
	 * 		L'adhérent à modifier
	 * @return true si les modifications ont été enregistrées, false sinon.
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

	/**
	 * Obtenir les informations concernant l'adhérent connecté à l'application grâce à son ID.
	 * @return L'adhérent correspondant à l'ID.
	 */
	public Adherent getCurrentAdherent() {
		return this.adherentCourant = this.adherentDAO.retreive(this.adherentCourant.getIdAdherent());
	}

	/**
	 * Obtenir un adhérent par son pseudo (qui est unique).
	 * @param pseudo
	 * 		Le pseudo de l'adhérent à rechercher.
	 * @return L'adhérent correspondant au pseudo.
	 */
	public Adherent getAdherent(String pseudo) {
		return this.adherentDAO.getByPseudo(pseudo);
	}

	/**
	 * Créer un nouvel adhérent dans la base de données.
	 * @param adherent
	 * 		Le nouvel adhérent à créer.
	 * @return true si l'adhérent a bien été créé, false sinon.
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
	 * Supprimer un adhérent par son pseudo (unique).
	 * @param pseudo
	 * 		Le pseudo de l'adhérent à supprimer de la BDD.
	 * @return true si l'adhérent a bien été supprimé, false sinon.
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

	/**
	 * Obtenir la liste de tous les jeux enregistrés dans la BDD.
	 * @return La liste des jeux.
	 */
	public ArrayList<Jeu> getGamesList() {
		return this.jeuDAO.getAll();
	}

	/**
	 * Obtenir une liste de jeux par leur nom ou une partie de leur nom.
	 * @param nomJeu
	 * 		Le nom ou partie de nom du jeu.
	 * @return Une liste de jeux.
	 */
	public ArrayList<Jeu> searchGames(String nomJeu) {
		return this.jeuDAO.searchByName(nomJeu);
	}

	/**
	 * Obtenir un jeu par son nom exact.
	 * @param nom
	 * 		Le nom du jeu à rechercher.
	 * @return Le jeu correspondant au nom.
	 */
	public Jeu getByName(String nom) {
		return this.jeuDAO.getByName(nom);
	}

	/**
	 * Modifier un jeu dans la BDD.
	 * @param jeu
	 * 		Le jeu à modifier.
	 * @return true si les modifications ont été enregistrées, false sinon.
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
	 * Créer une nouvelle entrée de jeu dans la base de données.
	 * @param jeu
	 * 		Le jeu à créer.
	 * @return true si le jeu a bien été créé, false sinon.
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
	 * Supprimer un jeu de la BDD par son ID.
	 * @param idJeu
	 * 		L'ID du jeu à supprimer.
	 * @return true si le jeu a bien été supprimé, false sinon.
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

	/**
	 * Obtenir la liste de toutes les extensions enregistrés dans la BDD.
	 * @return La liste des extensions.
	 */
	public ArrayList<Extension> getExtensionsList() {
		return this.extensionDAO.getAll();
	}

	/**
	 * Obtenir une liste des extensions par leur nom ou une partie de leur nom.
	 * @param nomExtension
	 * 		Le nom ou partie de nom d'extensions.
	 * @return Une liste d'extensions.
	 */
	public ArrayList<Extension> searchExtensions(String nomExtension) {
		return this.extensionDAO.searchByName(nomExtension);
	}

	/**
	 * Obtenir une extension par son nom exact.
	 * @param nom
	 * 		Le nom de l'extension à retrouver.
	 * @return L'extension correspondant au nom.
	 */
	public Extension getExtByName(String nom) {
		return this.extensionDAO.getExtByName(nom);
	}

	// Partie permettant la gestion des réservations
	
	/**
	 * Obtenir une réservation par son ID.
	 * @param id
	 * 		L'ID de la réservation à récupérer.
	 * @return La réservation correspondant à l'ID.
	 */
	public Reservation getById(int id) {
		return this.reservationDAO.getById(id);
	}

	/**
	 * Obtenir la liste de toutes les réservations.
	 * @return La liste des réservations.
	 */
	public ArrayList<Reservation> getReservationList() {
		return this.reservationDAO.getAll();
	}

	/**
	 * Obtenir les réservations concernant un adhérent.
	 * @param nomAdherent
	 * 		Le pseudo de l'adhérent dont on recherche les réservations.
	 * @return La liste des réservations effectuées par l'adhérent.
	 */
	public ArrayList<Reservation> searchReservations(String nomAdherent) {
		return this.reservationDAO.searchByPseudo(nomAdherent);
	}
	
	/**
	 * Supprimer une réservation de la BDD.
	 * @param res
	 */
	public void annulerReservation(Reservation res) {
		this.reservationDAO.delete(res.getIdReservation());
	}
	/**
	 * creation reservation dans la base de donn�es
	 * @param reservation
	 * @param idAdherent
	 * @param idJeu
	 * @param idJextension
	 * @param date
	 * @return
	 */
	public boolean createReservation(Reservation reservation,int idAdherent, int idJeu, int idJextension,Date date) {
		if(this.reservationDAO.create(reservation, idAdherent, idJeu, idJextension)) {
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * creation reservation dans la base de donn�es
	 * @param reservation
	 * @param idAdherent
	 * @param idJeu
	 * @param date
	 * @return
	 */
	public boolean createReservation2(Reservation reservation,int idAdherent, int idJeu,Date date) {
		if(this.reservationDAO.create2(reservation, idAdherent, idJeu)) {
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * creation reservation dans la base de donn�es
	 * @param reservation
	 * @param idAdherent
	 * @param idExtention
	 * @param date
	 * @return
	 */
	public boolean createReservation3(Reservation reservation,int idAdherent, int idExtention,Date date) {
		if(this.reservationDAO.create3(reservation, idAdherent, idExtention)) {
			return true;
		}
		else {
			return false;
		}
	}

	// Partie permettant la gestion des emprunts
	/**
	 * creation d'un emprunt
	 * @param emprunt
	 * @return
	 */
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
	/**
	 * met � jour le compteur de retard d'un adherent si un emprunt est rendu en retard
	 */
	public void updateRetard() {
		this.adherentDAO.updateRetard(this.adherentCourant.getCompteurRetard(),this.adherentCourant.getIdAdherent());
	}
}