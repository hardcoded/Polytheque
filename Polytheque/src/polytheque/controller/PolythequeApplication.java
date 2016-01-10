package polytheque.controller;

import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JOptionPane;

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

public class PolythequeApplication {

	private AdherentDAO adherentDAO;
	private JeuDAO jeuDAO;
	private ReservationDAO reservationDAO;
	private ExtensionDAO extensionDAO;
	private EmpruntDAO empruntDAO;
	
	private TacheDAffichage tacheDAffichageDeLApplication;

	private Adherent adherentCourant;

	public PolythequeApplication(){
		this.adherentDAO = new AdherentDAO();
		this.jeuDAO = new JeuDAO();
		this.reservationDAO = new ReservationDAO();
		this.extensionDAO = new ExtensionDAO();
	}

	public void associerTacheDAffichage(TacheDAffichage affichageAppli) {
		this.tacheDAffichageDeLApplication = affichageAppli;
	}

	public boolean checkConnexion(String userName, String password) {
		if(this.adherentDAO.connectionAuthorized(userName, password) != null) {
			this.adherentCourant = this.adherentDAO.retreive(this.adherentDAO.connectionAuthorized(userName, password).getIdAdherent());
			return true;
		}
		return false;
	}

	public boolean checkAdmin() {
		if(this.adherentDAO.isAdmin(this.adherentCourant.getPseudo())) {
			return true;
		}
		return false;
	}

	public ArrayList<Jeu> getGamesList() {
		return this.jeuDAO.getAll();
	}

	public ArrayList<Jeu> searchGames(String nomJeu) {
		return this.jeuDAO.searchByName(nomJeu);
	}

	public ArrayList<Extension> getExtensionsList() {
		return this.extensionDAO.getAll();
	}

	public ArrayList<Extension> searchExtensions(String nomExtension) {
		return this.extensionDAO.searchByName(nomExtension);
	}

	public Adherent getAdherentCourant() {
		return this.adherentCourant;
	}

	public ArrayList<Adherent> getAdherentsList() {
		return this.adherentDAO.getAll();
	}

	public ArrayList<Adherent> searchAdherents(String nomAdherent) {
		return this.adherentDAO.searchByName(nomAdherent);
	}

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
	
	public Adherent getAdherent(String pseudo) {
		return this.adherentDAO.getByPseudo(pseudo);
	}
	
	public boolean creerAdherent(Adherent adherent){
		if (this.adherentDAO.create(adherent)) {
			return true;
		}
		return false;
	}
	
	public boolean supprimerAdherent(String nom) {
		 if (this.adherentDAO.deleteAdherent(nom)) {
			 return true;
		 }
		 else {
			 return false;
		 }
	}
	
	public ArrayList<Reservation> getReservationList() {
		return this.reservationDAO.getAll();
	}
	
	public Jeu getByName(String nom) {
		return this.jeuDAO.getByName(nom);
	}
	
	public void annulerReservation(){
		Date d = null;
		Adherent adh=null;
		//adh = this.adherentDAO.retreive(this.adherentDAO.getIdAdherent());
		Reservation r = this.reservationDAO.retreive(adh,d);
		this.reservationDAO.delete(r.getIdReservation());
	}
	
	public boolean createReservation(Reservation reservation,int idAdherent, int idJeu, int idJextension,Date date)
	{
		if(this.reservationDAO.create(reservation, idAdherent, idJeu, idJextension))
			{return true;}
		else
			{return false;}
	}
	
	public boolean createReservation2(Reservation reservation,int idAdherent, int idJeu,Date date)
	{
		if(this.reservationDAO.create2(reservation, idAdherent, idJeu))
			{return true;}
		else
			{return false;}
	}
	
	public boolean creerEmprunt(Emprunt emprunt){
		Date datedeb=emprunt.getDateDebut();
		Date datefin = emprunt.getDateFin();
		Adherent adh=emprunt.getAdherent();
		Jeu jeu=emprunt.getJeu();
		Extension ext =emprunt.getExtension();
		Reservation res= new Reservation(adh,jeu,datedeb);
		if (this.empruntDAO.create(datedeb,datefin,res,adh,jeu,ext)) {
			return true;
		}
		return false;
	}
}