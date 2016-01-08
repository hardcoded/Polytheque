package polytheque.model.pojos;

import java.sql.Date;
import polytheque.model.DAO.JeuDAO;
import polytheque.model.DAO.ExtensionDAO;
import polytheque.model.DAO.AdherentDAO;
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
	private Extension extention;
	private AdherentDAO adherentDAO;
	private JeuDAO jeuDAO;
	private ExtensionDAO extentionDAO;

	/**
	 * Constructeur de Reservation qui sert dans une fonction de ReservationDAO
	 * @param id_reservation
	 * @param date
	 * @param id_adherent
	 * @param id_jeu
	 * @param id_extension
	 */
	public Reservation(int id_reservation,Date date,int id_adherent,int id_jeu,int id_extension){
		this.setIdReservation(id_reservation);
		this.setDate(date);
		Adherent adh=this.adherentDAO.retreive(id_adherent);
		this.setAdherent(adh);
		Jeu cejeu=this.jeuDAO.retreive(id_jeu);
		this.setJeu(cejeu);
		Extension ext=this.extentionDAO.retreive(id_extension);
		this.setExtension(ext);
	}
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
		this.jeu.setNbReserves(this.jeu.getNbReserves()+1);
		this.jeu.setStatus("r�serv�");
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
		this.extention.setNbReserves(this.extention.getNbReserves()+1);
		this.extention.setStatut("r�serv�");
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
		this.jeu.setNbReserves(this.jeu.getNbReserves()+1);
		this.jeu.setStatus("r�serv�");
		this.extention.setNbReserves(this.extention.getNbReserves()+1);
		this.extention.setStatut("r�serv�");
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
		this.jeu.setNbReserves(this.jeu.getNbReserves()+1);
		this.jeu.setStatus("r�serv�");
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

	/**m�thodes
	 * modifDate(date, int); elle ajoute un entier (nb jours) � la date donn�e en prenant en compte les mois et l'ann�e.
	 * emprunter()
	 * annuler_reservation()
	 * */

	public Date modifDate(Date d,int nbjours){
		@SuppressWarnings("deprecation")
		int jour = d.getDay();
		@SuppressWarnings("deprecation")
		int mois = d.getMonth();
		@SuppressWarnings("deprecation")
		int annee = d.getYear();
		if (mois==1 || mois==3 || mois==5 || mois==7 || mois==8 || mois==10 || mois==12){
			if (jour+nbjours >31 && mois==12){
				jour=(jour+nbjours)%31;
				mois=1;
				annee=annee+1;}
			else{
				if (jour+nbjours >31){
					jour=(jour+nbjours)%31;
					mois=mois+1;
				}
				else{
					jour=jour+nbjours;
				}
			}
		}
		else{
			if (mois==2){
				if (jour+nbjours >28){
					jour=(jour+nbjours)%28;
					mois=mois+1;
				}
				else{
					jour=jour+nbjours;
				}	
			}
			else{
				if (jour+nbjours >30){
					jour=(jour+nbjours)%30;
					mois=mois+1;
				}
				else{
					jour=jour+nbjours;
				}
			}	
		}
		@SuppressWarnings("deprecation")
		Date date= new Date(annee,mois,jour);
		return date;
	}

	public Emprunt validerReservation(){
		Date datefin = modifDate(this.getDate(),21); //appel � une fonction qui s'occupe d'ajouter les jours
		if (this.extention == null){
			this.jeu.setStatus("emprunt�");
			if (this.jeu.getNbReserves()==this.jeu.getNbExemplaires()){
				this.jeu.setDisponibilite(false);}
			return new Emprunt(this.adherent,this.jeu,this.date,datefin,null);}
		else{
			if (this.jeu == null){
				this.extention.setStatut("emprunt�");
				return new Emprunt(this.adherent,this.extention,this.date,datefin,null);}
			else{
				this.jeu.setStatus("emprunt�");
				this.extention.setStatut("emprunt�");
				if (this.jeu.getNbReserves()==this.jeu.getNbExemplaires()){
					this.jeu.setDisponibilite(false);}
				return new Emprunt(this.adherent,this.jeu,this.extention,this.date,datefin);}
		}
	}


	public void annulerReservation(){
		if (this.extention == null){
			this.jeu.setStatus("libre");
			this.jeu.setNbReserves(this.jeu.getNbReserves()-1);}
		else{
			if (this.jeu == null){
				this.extention.setStatut("libre");
				this.extention.setNbReserves(this.extention.getNbReserves()-1);}
			else{
				this.jeu.setStatus("libre");
				this.jeu.setNbReserves(this.jeu.getNbReserves()-1);
				this.extention.setStatut("libre");
				this.extention.setNbReserves(this.extention.getNbReserves()-1);}
		}
	}

}
