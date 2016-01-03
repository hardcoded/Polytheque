package polytheque.controller;

import polytheque.model.DAO.AdherentDAO;
import polytheque.model.DAO.CategorieJeuDAO;
import polytheque.model.DAO.EditeurJeuDAO;
import polytheque.model.DAO.EmpruntDAO;
import polytheque.model.DAO.JeuDAO;
import polytheque.model.DAO.ReservationDAO;
import polytheque.view.TacheDAffichage;

public class PolythequeApplication {

	private AdherentDAO adherentDAO;
	private JeuDAO jeuDAO;
	private CategorieJeuDAO categorieJeuDAO;
	private EditeurJeuDAO editeurJeuDAO;
	private ReservationDAO reservationDAO;
	private EmpruntDAO empruntDAO;
	private TacheDAffichage tacheDAffichageDeLApplication;

	public PolythequeApplication(){
		this.adherentDAO = new AdherentDAO();
		this.jeuDAO = new JeuDAO();
		this.categorieJeuDAO = new CategorieJeuDAO();
		this.editeurJeuDAO = new EditeurJeuDAO();
		this.reservationDAO = new ReservationDAO();
		this.empruntDAO = new EmpruntDAO();
	}

	public void associerTacheDAffichage(TacheDAffichage affichageAppli) {
		this.tacheDAffichageDeLApplication = affichageAppli;
	}

	public boolean checkConnexion(String userName, String password) {
		if(this.adherentDAO.connectionAuthorized(userName, password)) {
			return true;
		}
		return false;
	}
	
	public boolean checkAdmin(String userName) {
		if(this.adherentDAO.isAdmin(userName)) {
			return true;
		}
		return false;
	}
}
