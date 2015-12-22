package polytheque.model.pojos;

import java.util.Calendar;

/**
 * Classe permettant de représenter un emprunt
 * 
 * @author Laure Marchal
 */
public class Emprunt {
	
	private Adherent adherent;
	private Jeu jeu;
	private Extension extention;
	private Calendar dateDebut;
	private Calendar dateFin;
	
	/**
	 * Constructeur de la classe Emprunt
	 * Pour un jeu uniquement
	 * 
	 * @param adherent
	 * 				l'adhérent qui emprunte
	 * @param extention
	 * 				l'extention à emprunter
	 * @param dateDebut
	 * 				la date du début de l'emprunt
	 * @param dateFin
	 * 				la date de fin de l'emprunt
	 */	
	public Emprunt(Adherent adherent,Jeu jeu, Calendar dateDebut,Calendar dateFin) {
		this.setAdherent(adherent);
		this.setJeu(jeu);
		this.setDateDebut(dateDebut);
		this.setDateFin(dateFin);
	}
	
	/**
	 * Constructeur de la classe Emprunt
	 * Pour une extension uniquement
	 * 
	 * @param adherent
	 * 				l'adhérent qui emprunte
	 * @param extention
	 * 				l'extention à emprunter
	 * @param dateDebut
	 * 				la date du début de l'emprunt
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
	 * 				l'adhérent qui emprunte
	 * @param jeu
	 * 				le jeu à emprunter
	 * @param extention
	 * 				l'extention à emprunter
	 * @param dateDebut
	 * 				la date du début de l'emprunt
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
	
	Emprunt emprunterJeu(Jeu jeu, Adherent adh,Calendar date){
		 Emprunt emprunt = new Emprunt(adh,jeu,date,date);
		 return emprunt;
	 }

}
