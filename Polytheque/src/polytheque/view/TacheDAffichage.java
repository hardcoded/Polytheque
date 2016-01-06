package polytheque.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import polytheque.controller.PolythequeApplication;

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
	public final static int HAUTEUR = 700;

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
		this.rafraichirFenetre();

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
		if (this.adherentAdmin()) {
			this.add(new AdminHomePage(this));
		}
		else {
			this.add(new AdherentHomePage(this));
		}
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

	public void afficherListeJeux() {
		this.viderFenetre();
		this.add(new AffichageListeJeux(this, this.polythequeApplication.getGamesList()));
		this.rafraichirFenetre();
	}
	
	public void rechercherJeux(String nomJeu) {
		this.viderFenetre();
		this.add(new AffichageListeJeux(this, this.polythequeApplication.searchGames(nomJeu)));
		this.rafraichirFenetre();
	}
	
	public void afficherMonCompte() {
		this.viderFenetre();
		this.add(new AffichageMonCompte(this, this.polythequeApplication.getAdherentCourant()));
		this.rafraichirFenetre();
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
	
	/**
	 * 
	 * @param message
	 * 			Le message
	 */
	public void afficherMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}
}
