package polytheque.view;

import javax.swing.JLabel;
import javax.swing.JTabbedPane;

/**
 * Classe permettant d'afficher la page d'accueil de l'application pour un administrateur.
 * Vient après l'écran de connexion.
 * 
 * @author Johan Brunet
 */
@SuppressWarnings("serial")
public class HomePage extends JTabbedPane {

	/**
	 * Une tache d'affichage de l'application.
	 */
	private TacheDAffichage tacheDAffichageDeLApplication;

	/**
	 * Création de la page d'accueil.
	 * 
	 * @param tacheDAffichageDeLApplication
	 *            Une tache d'affichage de l'application.
	 */
	public HomePage(TacheDAffichage afficheAppli){
		this.tacheDAffichageDeLApplication = afficheAppli;
		
		this.addTab("Jeux", this.tacheDAffichageDeLApplication.afficherListeJeux());
		this.addTab("Extensions", this.tacheDAffichageDeLApplication.afficherListeExtensions());
		this.addTab("Réserver Jeu", this.tacheDAffichageDeLApplication.afficherEcranReservationJeux());
		this.addTab("Réserver Extension", this.tacheDAffichageDeLApplication.afficherEcranReservationExtension());
		this.addTab("Profil", this.tacheDAffichageDeLApplication.afficherMonCompte());
		if (this.tacheDAffichageDeLApplication.adherentAdmin()) {
			this.addTab("Emprunt", this.tacheDAffichageDeLApplication.afficherCreationEmprunt());
			this.addTab("Adhérents", this.tacheDAffichageDeLApplication.afficherGestionAdherent());
			this.addTab("Reservations", this.tacheDAffichageDeLApplication.afficherListeReservations());
		}
		this.addTab("D�connexion", this.tacheDAffichageDeLApplication.afficherDeconnexion());
	}
}
