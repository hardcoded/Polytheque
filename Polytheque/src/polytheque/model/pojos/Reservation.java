package polytheque.model.pojos;

import java.sql.Date;
import java.util.Calendar;

/**
 * Classe permettant la r�servation d'un jeu
 * 
 * @author Laure Marchal
 */
public class Reservation {

	private int idReservation;
	private Date date;
	private Adherent adherent;
	private Jeu jeu;

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
	 * m�thodes
	 * getter et setter qui permettent de r�cup�rer ou modifier les attributs de cette classe dans d'autres classes
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

	public void setJeu(Jeu jeu) {
		this.jeu = jeu;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * m�thodes
	 * Emprunt valider_reservation();
	 * void annuler_reservation();
	 */

	Emprunt validerReservation(){
		Date dateFin = this.getDate();
		//TODO trouver moyen de fixer la date de fin à 3 semaines plus tard (= 21 jours)
		Emprunt emprunt = new Emprunt (this.getAdherent(), this.getJeu(), this.getDate(), dateFin, null);
		return emprunt;
	}

	void annulerReservation(){

	}

	public int getIdReservation() {
		return idReservation;
	}

	public void setIdReservation(int idReservation) {
		this.idReservation = idReservation;
	}
}
