package polytheque.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
	public final static int LARGEUR = 1000;
	
	/**
	 * La hauteur.
	 */
	public final static int HAUTEUR = 600;
	
	/**
	 * Création d'une tache d'affichage de l'application.
	 * 
	 * @param suiviDuJardin
	 *            Une application de suivi du jardin.
	 */
	public TacheDAffichage() {
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
	
	public void afficherAccueilAdmin() {
		this.viderFenetre();
		this.add(new AdminHomePage(this));
		this.rafraichirFenetre();
	}
	
	public void afficherAccueilAdherent() {
		this.viderFenetre();
		this.add(new adherentHomePage(this));
		this.rafraichirFenetre();
	}
	
	public void afficherTexteConsole(String message) {
		System.out.println(message);
	}
	
	public boolean testerValiditeConnexion(String userName, String password) {
		if (userName.equals("admin") && password.equals("admin")) {
			return true;
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
}
