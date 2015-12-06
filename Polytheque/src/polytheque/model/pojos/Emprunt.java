package polytheque.model.pojos;

import java.sql.Date;

public class Emprunt {
	
	private Adherent adherent;
	private Jeu jeu;
	private Date dateDebut;
	private Date dateFin;
		
	public Emprunt(Adherent adherent,Jeu jeu, Date dateDebut,Date dateFin) {
		this.setAdherent(adherent);
		this.setJeu(jeu);
		this.setDateDebut(dateDebut);
		this.setDateFin(dateFin);
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

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	
	/*méthodes
	 *Emprunt emprunter_jeu(Jeu jeu,Adherent adh,int date){
	 *e=Emprunt(adh,jeu,date,date+21);
	 *return e;
	 *}
	 **/
}
