package polytheque.model.pojos;

import java.util.Calendar;

/**
 * Classe permettant la réservation d'un jeu
 * @author laure
 */
public class Reservation {
	
	private Adherent adherent;
	private Jeu jeu;
	private Calendar date;
	
	/**
	 *  Constructeur de la classe Reservation
	 * @param adherent
	 * @param jeu
	 * @param date
	 */
	public Reservation(Adherent adherent,Jeu jeu, Calendar date) {
		this.setAdherent(adherent);
		this.setJeu(jeu);
		this.setDate(date);
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

	public void setJeu(Jeu jeu) {
		this.jeu = jeu;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}
	
	/**
	 * méthodes
	 * Emprunt valider_reservation();
	 * void annuler_reservation();
	 */
	
	Emprunt valider_reservation(){
		Calendar dateFin = this.getDate();
		dateFin.add(Calendar.DAY_OF_MONTH, 21);
		Emprunt emprunt = new Emprunt (this.adherent, this.jeu, this.date, dateFin);
		return emprunt;
	}
	
	void annuler_reservation(){
		
	}
}
