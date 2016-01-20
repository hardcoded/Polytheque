package polytheque.view;

import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import polytheque.controller.PolythequeApplication;
import polytheque.model.pojos.Adherent;
import polytheque.model.pojos.Emprunt;
import polytheque.model.pojos.Extension;
import polytheque.model.pojos.Jeu;
import polytheque.model.pojos.Reservation;

/**
 * Classe permettant de gérer l'affichage de l'appication.
 * 
 * @author Johan Brunet
 */
@SuppressWarnings("serial")
public class TacheDAffichage extends JFrame {
	
	/**
	 * Le titre de l'application.
	 */
	public final static String TITRE = "Polyth�que";

	/**
	 * La largeur de la fenêtre.
	 */
	public final static int LARGEUR = 1200;

	/**
	 * La hauteur de la fenêtre.
	 */
	public final static int HAUTEUR = 800;

	/**
	 * Application de gestion de la ludothèque
	 */
	private PolythequeApplication polythequeApplication;
	/**
	 * Création d'une tache d'affichage de l'application.
	 * 
	 * @param polytechApplication
	 *            Une application de de gestion de Ludothèque.
	 */
	public TacheDAffichage(PolythequeApplication polytechApplication) {
		this.polythequeApplication = polytechApplication;
	}

	/**
	 * Démarrer l'affichage de l'application.
	 */	
	public void run()
	{
		initialiserFenetre();
	}

	/**
	 * Initialiser la fenetre.
	 */
	public void initialiserFenetre()
	{
		this.setTitle(TITRE);
		this.setSize(LARGEUR, HAUTEUR);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.afficherEcranConnexion();

		this.setVisible(true);
	}

	/**
	 * Vider la fenetre.
	 */
	public void viderFenetre()
	{
		this.getContentPane().removeAll();
	}

	/**
	 * Rafraichir la fenetre.
	 */
	public void rafraichirFenetre()
	{
		this.validate();
		this.repaint();
	}

	/**
	 * Afficher l'écran de connexion.
	 */
	public void afficherEcranConnexion() {
		this.viderFenetre();
		this.add(new EcranConnexion(this));
		this.rafraichirFenetre();
	}

	/**
	 * Afficher la page d'accueil.
	 */
	public void afficherAccueil() {
		this.viderFenetre();
		this.getContentPane().add(new HomePage(this));
		this.rafraichirFenetre();
	}

	/**
	 * Vérifier que la demande de connexion est valide.
	 * @param userName
	 * 		Le pseudo utilisé pour la connexion.
	 * @param password
	 * 		Le mot de passe utilisé pour la connexion.
	 * @return true si la connexion est autorisée, false sinon.
	 */
	public boolean testerValiditeConnexion(String userName, String password) {
		if (this.polythequeApplication.checkConnexion(userName, password)) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Vérifier si l'adhérent qui s'est connecté est un administrateur.
	 * @return true si l'adhérent est admin, false sinon.
	 */
	public boolean adherentAdmin() {
		if (this.polythequeApplication.checkAdmin()) {
			return true;
		}
		return false;
	}

	public AffichageListeJeux afficherListeJeux() {
		return new AffichageListeJeux(this, this.polythequeApplication.getGamesList());
	}
	public AffichageListeExtensions afficherListeExtensions() {
		return new AffichageListeExtensions(this, this.polythequeApplication.getExtensionsList());
	}

	public ArrayList<Jeu> tousLesJeux() {
		return this.polythequeApplication.getGamesList();
	}

	public ArrayList<Adherent> tousLesAdherents() {
		return this.polythequeApplication.getAdherentsList();
	}

	public ArrayList<Extension> toutesLesExtensions() {
		return this.polythequeApplication.getExtensionsList();
	}

	public ArrayList<Jeu> rechercherJeux(String nomJeu) {
		return this.polythequeApplication.searchGames(nomJeu);
	}

	public ArrayList<Extension> rechercherExtensions(String nomExtension) {
		return this.polythequeApplication.searchExtensions(nomExtension);
	}

	public ArrayList<Reservation> rechercherReservations(String nomAdherent) {
		return this.polythequeApplication.searchReservations(nomAdherent);
	}

	public AffichageMonCompte afficherMonCompte() {
		return new AffichageMonCompte(this, this.polythequeApplication.getAdherentCourant());
	}

	public boolean modifAdherent(Adherent adherent) {
		if (this.polythequeApplication.enregistrerModifsAdherent(adherent)) {
			return true;
		}
		else {
			return false;
		}
	}

	public ArrayList<Adherent> rechercherAdherents(String nomAdherent) {
		return this.polythequeApplication.searchAdherents(nomAdherent);
	}

	public AffichageGestionAdherent afficherGestionAdherent() {
		this.viderFenetre();
		return new AffichageGestionAdherent(this, this.polythequeApplication.getAdherentsList()); //Surement un probleme
	}

	public AffichageModificationAdherent afficherModificationAdherent(Adherent adherent) {
		return new AffichageModificationAdherent(this, this.polythequeApplication.getAdherent(adherent.getPseudo()));//Surement un probleme
	}

	public AppliReserverJeu afficherEcranReservationJeux() {
		return new AppliReserverJeu(this);
	}

	public AppliReserverExtension afficherEcranReservationExtension()
	{
		return new AppliReserverExtension(this);
	}

	public AppliAnnulerReservation afficherEcranAnnulationR() {
		//this.viderFenetre();
		return new AppliAnnulerReservation(this);
	}
	public Adherent getAdherent(String pseudo) {
		return this.polythequeApplication.getAdherent(pseudo);
	}

	public Deconnexion afficherDeconnexion() {
		return new Deconnexion(this);
	}

	public AffichageCreationAdherent afficherCreationAdherent(){
		return new AffichageCreationAdherent(this); //a commit
	}

	public AffichageSupprimerAdherent afficherSupprimerAdherent(){
		return new AffichageSupprimerAdherent(this);
	}

	public AffichageListeReservations afficherListeReservations() {
		return new AffichageListeReservations(this, this.polythequeApplication.getReservationList());
	}

	public AffichageCreationEmprunt afficherCreationEmprunt(){
		return new AffichageCreationEmprunt(this);
	}

	public boolean creerEmprunt(Emprunt emprunt) {
		if (this.polythequeApplication.creerEmprunt(emprunt)) {
			return true;
		}
		return false;
	}

	public boolean creerAdherent(Adherent adherent) {
		if (this.polythequeApplication.creerAdherent(adherent)) {
			return true;
		}
		return false;
	}

	public boolean supprimerAdherent(String nom){
		if (this.polythequeApplication.supprimerAdherent(nom)) {
			return  true;
		}
		else {
			return false;
		}
	}
	/**
	 * Afficher une fenetre de dialogue.
	 * 
	 * @param message
	 *            Le message.
	 * @param titreFenetre
	 *            Le titre de la fenetre.
	 * @param codeInformation
	 *            Le code information.
	 */
	public void afficherMessage(String message, String titreFenetre, int codeInformation) {
		JOptionPane.showMessageDialog(this, message, titreFenetre, codeInformation);
	}

	public Adherent getAdherentByNothing() {

		return this.polythequeApplication.getCurrentAdherent();
	}

	public Jeu getJeu(String nom) {
		return this.polythequeApplication.getByName(nom);
	}
	public Extension getExt(String nom) {
		return this.polythequeApplication.getExtByName(nom);
	}
	public boolean createReservation(Reservation reservation, int idAdherent, int idJeu, int idJextension,Date date)
	{
		if(this.polythequeApplication.createReservation(reservation,idAdherent, idJeu, idJextension,date))
		{return true;}
		else
		{return false;}	
	}

	public boolean createReservation2(Reservation reservation, int idAdherent, int idJeu, Date date)
	{
		if(this.polythequeApplication.createReservation2(reservation,idAdherent, idJeu,date))
		{return true;}
		else
		{return false;}	
	}

	public boolean createReservation3(Reservation reservation, int idAdherent, int idExtention, Date date)
	{
		if(this.polythequeApplication.createReservation3(reservation,idAdherent, idExtention,date))
		{return true;}
		else
		{return false;}	
	}

	public Reservation getReservation(String id){
		int idR =Integer.parseInt(id);
		return this.polythequeApplication.getById(idR);
	}
	
	public void deleteReservation(Reservation r){
		this.polythequeApplication.annulerReservation(r);
	}

	public boolean modifJeu(Jeu jeu) {
		if (this.polythequeApplication.enregistrerModifsJeu(jeu)) {
			return true;
		}
		else {
			return false;
		}
	}

	public AffichageModificationJeu afficherModificationJeu(Jeu jeu) {
		return new AffichageModificationJeu(this, this.polythequeApplication.getByName(jeu.getNom()));
	}

	public AffichageCreationJeu afficherCreationJeu(){
		return new AffichageCreationJeu(this); 
	}

	public AffichageSupprimerJeu afficherSupprimerJeu(){
		return new AffichageSupprimerJeu(this);
	}

	public boolean creerJeu(Jeu jeu) {
		if (this.polythequeApplication.creerJeu(jeu)) {
			return true;
		}
		return false;
	}

	public boolean supprimerJeu(int idJeu){
		if (this.polythequeApplication.supprimerJeu(idJeu)) {
			return  true;
		}
		else {
			return false;
		}
	}

}