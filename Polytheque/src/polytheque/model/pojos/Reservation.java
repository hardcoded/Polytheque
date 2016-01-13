package polytheque.model.pojos;

import java.sql.Date;

import polytheque.model.DAO.AdherentDAO;
import polytheque.model.DAO.ExtensionDAO;
import polytheque.model.DAO.JeuDAO;
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
	private JeuDAO jeuDAO;
	private ExtensionDAO extensionDAO;

	/**
	 * constructeur de Reservation utilisï¿½ dans une fonction de ReservationDAO
	 * @param id_reservation
	 * @param adh
	 * @param jeu
	 * @param ext
	 * @param date
	 */
	public Reservation(int id_reservation,Adherent adh,Jeu jeu,Extension ext,Date date){
		this.setIdReservation(id_reservation);
		this.setDate(date);
		this.setAdherent(adh);
		this.setJeu(jeu);
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
		this.jeu.setStatus("rï¿½servï¿½");
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
		this.extention.setStatut("rï¿½servï¿½");
	}

	/**
	 * Constructeur de la classe Reservation
	 * 
	 * @param adherent
	 * @param jeu
	 * @param extention
	 * @param date
	 */

	public Reservation(int idAdherent,int idJeu, Date date) {
		this.adherentDAO = new AdherentDAO();
		this.jeuDAO = new JeuDAO();
		
		this.setAdherent(this.adherentDAO.retreive(idAdherent));
		this.setJeu(this.jeuDAO.retreive(idJeu));
		this.setExtension(null);
		this.setDate(date);

	}

	/**
	 * Constructeur de la classe Reservation, permet de créer une Réservation à  partir des données existantes
	 * @param idAdherent
	 * @param idJeu
	 * @param idExtention
	 * @param date
	 */
	public Reservation(int idAdherent,int idJeu, int idExtention, Date date) {
		this.adherentDAO = new AdherentDAO();
		this.jeuDAO = new JeuDAO();
		this.extensionDAO = new ExtensionDAO();

		this.setAdherent(this.adherentDAO.retreive(idAdherent));
		this.setJeu(this.jeuDAO.retreive(idJeu));
		this.setExtension(this.extensionDAO.retreive(idExtention));
		this.setDate(date);
	}

	/**
	 *  Constructeur de la classe Reservation, permet de créer une Réservation à  partir des données existantes
	 * @param idReserv
	 * @param idAdherent
	 * @param idJeu
	 * @param idExtention
	 * @param date
	 */
	public Reservation(int idReserv,int idAdherent,int idJeu, int idExtention, Date date) {
		this.adherentDAO = new AdherentDAO();
		this.jeuDAO = new JeuDAO();
		this.extensionDAO = new ExtensionDAO();

		this.setIdReservation(idReserv);
		this.setAdherent(this.adherentDAO.retreive(idAdherent));
		this.setJeu(this.jeuDAO.retreive(idJeu));
		this.setExtension(this.extensionDAO.retreive(idExtention));
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
	public Reservation(int idExtension, Date date, int idAdherent) {
		this.adherentDAO = new AdherentDAO();
		this.extensionDAO = new ExtensionDAO();

		this.setExtension(this.extensionDAO.retreive(idExtension));
		this.setAdherent(this.adherentDAO.retreive(idAdherent));
		this.setJeu(null);
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
	 * modifDate(date, int); elle ajoute un entier (nb jours) à la date donnée en prenant en compte les mois et l'année.
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
		if (mois==1 || mois==3 || mois==5 || mois==7 || mois==8 || mois==10 || mois==12){ //cas des mois de 31 jours
			if (jour+nbjours >31 && mois==12){ // cas de fin d'année et de changement de mois
				jour=(jour+nbjours)%31;
				mois=1;
				annee=annee+1;}
			else{
				if (jour+nbjours >31){ // cas de changement de mois
					jour=(jour+nbjours)%31;
					mois=mois+1;
				}
				else{ // cas ou seul le jour change
					jour=jour+nbjours;
				}
			}
		}
		else{ //cas des mois de 30 jours
			if (mois==2){ // cas du mois de fevrier
				if (jour+nbjours >28){ // cas de changement de mois
					jour=(jour+nbjours)%28;
					mois=mois+1;
				}
				else{ // cas simple, seul le jour change
					jour=jour+nbjours;
				}	
			}
			else{//cas des autres mois de 30 jours
				if (jour+nbjours >30){ // cas de changement de mois
					jour=(jour+nbjours)%30;
					mois=mois+1;
				}
				else{ // cas simple, seul le jour change
					jour=jour+nbjours;
				}
			}	
		}
		@SuppressWarnings("deprecation")
		Date date= new Date(annee,mois,jour);
		return date;
	}
	
	public void annulerReservation(){
		if (this.extention == null){ // cas ou la reservation ne concerne qu'un jeu
			this.jeu.setStatus("libre"); //on change son statut
			this.jeu.setNbReserves(this.jeu.getNbReserves()-1);} // on soustrait 1 au nombre de réservation d'exemplaires du jeu
		else{
			if (this.jeu == null){ // cas ou la reservation ne concerne qu'une extension
				this.extention.setStatut("libre");
				this.extention.setNbReserves(this.extention.getNbReserves()-1);}
			else{ // cas ou la reservation concerne un jeu et une extension
				this.jeu.setStatus("libre");
				this.jeu.setNbReserves(this.jeu.getNbReserves()-1);
				this.extention.setStatut("libre");
				this.extention.setNbReserves(this.extention.getNbReserves()-1);}
		}
	}

	/**
	 * Fonction permettant de valider une réservation en faisant les modifications et vérifications nécessaires
	 * @return
	 */
	public Emprunt validerReservation(){
		Date datefin = modifDate(this.getDate(),21); //appel à une fonction qui s'occupe d'ajouter les jours
		if (this.extention == null){ // cas d'un seul jeu emprunté
			this.jeu.setStatus("empruntï¿½");
			if (this.jeu.getNbReserves()==this.jeu.getNbExemplaires()){
				this.jeu.setDisponibilite(false);}
			return new Emprunt(this.adherent,this.jeu,this.date,datefin,null);}
		else{
			if (this.jeu == null){ // cas d'une extension empruntée
				this.extention.setStatut("empruntï¿½");
				return new Emprunt(this.adherent,this.extention,this.date,datefin,null);}
			else{ // cas d'un jeu et d'une extension empruntés
				this.jeu.setStatus("empruntï¿½");
				this.extention.setStatut("empruntï¿½");
				if (this.jeu.getNbReserves()==this.jeu.getNbExemplaires()){
					this.jeu.setDisponibilite(false);}
				return new Emprunt(this.adherent,this.jeu,this.extention,this.date,datefin);}
		}
	}


	

}
