package polytheque.model.pojos;

import java.util.Calendar;

/**
 * Classe permettant d'emprunter un jeu
 * 
 * @author Laure Marchal
 *
 */
public class Emprunt {
	
	private Adherent adherent;
	private Jeu jeu;
	private Calendar dateDebut;
	private Calendar dateFin;
	
	/**
	 * Constructeur de la classe Emprunt
	 * 
	 * @param adherent
	 * @param jeu
	 * @param dateDebut
	 * @param dateFin
	 */
	
	public Emprunt(Adherent adherent,Jeu jeu, Calendar dateDebut,Calendar dateFin) {
		this.setAdherent(adherent);
		this.setJeu(jeu);
		this.setDateDebut(dateDebut);
		this.setDateFin(dateFin);
	}
	
	/**
	 * méthodes getter et setter des attributs de la classe Emprunt peremettant de les récupérer ou de les modifier dans une autre classe
	 * 
	 * @return L'adhérent qui a réalisé l'emprunt
	 */
	
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
	
	Emprunt emprunterJeu(Jeu jeu,Adherent adh,Calendar date){
		 Emprunt emprunt = new Emprunt(adh,jeu,date,date);
		 return emprunt;
	 }

}
