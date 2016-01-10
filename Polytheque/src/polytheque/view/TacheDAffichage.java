package polytheque.view;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import polytheque.controller.PolythequeApplication;
import polytheque.model.pojos.Adherent;
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
	public final static String TITRE = "Polythèque";

	/**
	 * La largeur.
	 */
	public final static int LARGEUR = 1200;

	/**
	 * La hauteur.
	 */
	public final static int HAUTEUR = 800;

	/**
	 * Application de gestion de la ludothèque
	 */
	private PolythequeApplication polythequeApplication;

	/**
	 * Création d'une tache d'affichage de l'application.
	 * 
	 * @param suiviDuJardin
	 *            Une application de suivi du jardin.
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

	public void afficherEcranConnexion() {
		this.viderFenetre();
		this.add(new EcranConnexion(this));
		this.rafraichirFenetre();
	}

	public void afficherAccueil() {
		this.viderFenetre();
		this.getContentPane().add(new HomePage(this));
		this.rafraichirFenetre();
	}

	public boolean testerValiditeConnexion(String userName, String password) {
		if (this.polythequeApplication.checkConnexion(userName, password)) {
			return true;
		}
		else {
			return false;
		}
	}

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

	public ArrayList<Jeu> rechercherJeux(String nomJeu) {
		return this.polythequeApplication.searchGames(nomJeu);
	}

	public ArrayList<Extension> rechercherExtensions(String nomExtension) {
		return this.polythequeApplication.searchExtensions(nomExtension);
	}

	public AffichageMonCompte afficherMonCompte() {
		return new AffichageMonCompte(this, this.polythequeApplication.getAdherentCourant());
	}

	public AffichageMonCompte modifAdherent(Adherent adherent) {
		this.polythequeApplication.enregistrerModifsAdherent(adherent);
		return new AffichageMonCompte(this, this.polythequeApplication.getAdherentCourant());
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

	public AppliReserverJeu afficherEcranReservation() {
		return new AppliReserverJeu(this);
	}
	
	public AppliAnnulerReservation afficherEcranAnnulationR() {
		return new AppliAnnulerReservation(this);
	}
	public Adherent getAdherent(String pseudo) {
		return this.polythequeApplication.getAdherent(pseudo);
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
	
	public void creerAdherent(Adherent adherent) {
		this.polythequeApplication.creerAdherent(adherent);
	}

	public void supprimerAdherent(String nom){
		this.polythequeApplication.supprimerAdherent(nom);
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
		
		return this.polythequeApplication.getAdherentByNothing();
	}
	
	public Jeu getJeu(String nom) {
		return this.polythequeApplication.getByName(nom);
}
	public void createReservation(int idAdherent, int idJeu, int idJextension)
	{
		
		this.polythequeApplication.createReservation(idAdherent, idJeu, idJextension);	
	}
	
	public void deleteReservation(){
		this.polythequeApplication.annulerReservation();
	}
}
