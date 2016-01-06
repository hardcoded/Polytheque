package polytheque.model.pojos;

import java.sql.Date;

import polytheque.model.DAO.AdherentDAO;
/**
 * Classe permettant la rï¿½servation d'un jeu
 * 
 * @author Laure Marchal
 */
public class Reservation {

	private int idReservation;
	private Date date;
	private Adherent adherent;
	private Jeu jeu;
	private Extension extention;
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
	 * @param adherent
	 * @param extention
	 * @param date
	 */
	public Reservation(Adherent adherent,Extension extention, Date date) {
		this.setAdherent(adherent);
		this.setExtension(extention);
		this.setDate(date);
	}
	
	/**
	 * Constructeur de la classe Reservation
	 * 
	 * @param adherent
	 * @param jeu
	 * @param extention
	 * @param date
	 */
	public Reservation(Adherent adherent,Jeu jeu,Extension extention, Date date) {
		this.setAdherent(adherent);
		this.setJeu(jeu);
		this.setExtension(extention);
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
	 * mï¿½thodes
	 * getter et setter qui permettent de rï¿½cupï¿½rer ou modifier les attributs de cette classe dans d'autres classes
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
	
	public void setExtension(Extension extention) {
		this.extention=extention;
		
	}
	
	public Extension getExtension() {
		return extention;
		
	}
	
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	/**méthodes
	 * emprunter()
	 * annuler_reservation()
	 * */
	
	public Emprunt validerReservation(){
		Date dateFin = this.date;
		//TODO trouver moyen de fixer la date de fin à 3 semaines plus tard (= 21 jours)
		if (this.extention == null){
			this.jeu.setStatus("emprunté");
			return new Emprunt(this.adherent,this.jeu,this.date,dateFin,null);}
		else{
			if (this.jeu == null){
				this.extention.setStatut("emprunté");
				return new Emprunt(this.adherent,this.extention,this.date,dateFin,null);}
			else{
				this.jeu.setStatus("emprunté");
				this.extention.setStatut("emprunté");
				return new Emprunt(this.adherent,this.jeu,this.extention,this.date,dateFin);}
		}
	}


	public void annulerReservation(){
		if (this.extention == null){
			this.jeu.setStatus("libre");}
		else{
			if (this.jeu == null){
				this.extention.setStatut("libre");}
			else{
				this.jeu.setStatus("libre");
				this.extention.setStatut("libre");}
		}
	}
	
}
