package polytheque.model.pojos;

import java.sql.Date;

/*
 * Classe permettant la réservation d'un jeu
 */
public class Reservation {
	
	private Adherent adherent;
	private Jeu jeu;
	private Date date;
	
	/*
	 * Constructeur de la classe Reservation
	 */
	public Reservation(Adherent adherent,Jeu jeu, Date date) {
		this.setAdherent(adherent);
		this.setJeu(jeu);
		this.setDate(date);
	}

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
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	/* 
	 * méthodes
	 * Emprunt valider_reservation(Reservation r);
	 * void annuler_reservation(Reservation r);
	 */
}
