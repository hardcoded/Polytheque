package polytheque.model.pojos;

import java.sql.Date;

import polytheque.model.DAO.AdherentDAO;
/**
 * Classe permettant la réservation d'un jeu
 * 
 * @author Laure Marchal
 */
public class Reservation {

	private int idReservation;
	private Date date;
	private Adherent adherent;
	private Jeu jeu;
	private AdherentDAO adherentDAO;

	/**
	 * Constructeur de la classe Reservation
	 * 
	 * @param adherent
	 * @param jeu
	 * @param date
	 */
	public Reservation(Adherent adherent,Jeu jeu, Date date) {
		this.setAdherent(adherent);
		this.setJeu(jeu);
		this.setDate(date);
	}

	/**
	 * Constructeur de la classe Reservation
	 *  
	 * @param idReservation
	 * @param adherent
	 * @param jeu
	 * @param date
	 */
	public Reservation(int id, Adherent adherent,Jeu jeu, Date date) {
		this.setIdReservation(id);
		this.setAdherent(adherent);
		this.setJeu(jeu);
		this.setDate(date);
	}

	/**
	 * Constructeur de la classe Reservation
	 * 
	 * @param idReservation
	 * @param idAdherent
	 * @param date
	 */
	public Reservation(int id, Date date, int idAdherent) {
		this.adherentDAO = new AdherentDAO();
		this.setIdReservation(id);
		this.setDate(date);
		this.setAdherent(adherentDAO.retreive(idAdherent));
	}

	/**
	 * méthodes
	 * getter et setter qui permettent de récupérer ou modifier les attributs de cette classe dans d'autres classes
	 */
	public Adherent getAdherent() {
		return adherent;
	}

	public void setAdherent(Adherent adherent) {
		this.adherent = adherent;
	}

	public Jeu getJeu() {
		return jeu;
	}

	public int getIdReservation() {
		return idReservation;
	}

	public void setIdReservation(int idReservation) {
		this.idReservation = idReservation;
	}
	
	public void setJeu(Jeu jeu) {
		this.jeu = jeu;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
