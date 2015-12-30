package polytheque.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import polytheque.view.TacheDAffichage;

/**
 * Classe permettant d'afficher la page d'accueil de l'application pour un administrateur.
 * Vient après l'écran de connexion.
 * 
 * @author Johan Brunet
 */
@SuppressWarnings("serial")
public class AdminHomePage extends JPanel implements ActionListener {
	/**
	 * La largeur.
	 */
	private static final int LARGEUR = 2;
	
	/**
	 * La hauteur.
	 */
	private static final int HAUTEUR = 2;
	
	/**
	 * Un bouton.
	 */
	private JButton boutonAfficherListeJeux;
	
	/**
	 * Un bouton.
	 */
	private JButton boutonValiderEmprunt;
	
	/**
	 * Un bouton.
	 */
	private JButton boutonAnnulerReservation;
	
	/**
	 * Un bouton.
	 */
	private JButton boutonGestionAdherent;
	
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
	public AdminHomePage(TacheDAffichage afficheAppli){
		this.tacheDAffichageDeLApplication = afficheAppli;
		
		ajouterLesBoutons();
	}
	
	/**
	 * Ajouter les boutons dans la this.
	 */
	private void ajouterLesBoutons() {
		this.setLayout(new GridLayout(HAUTEUR, LARGEUR));
		
		this.boutonAfficherListeJeux = new JButton("Afficher la liste des jeux");
		this.boutonAfficherListeJeux.setFocusable(false);
		this.boutonAfficherListeJeux.addActionListener(this);
		this.add(this.boutonAfficherListeJeux);
		
		this.boutonGestionAdherent = new JButton("Gestion adhérent");
		this.boutonGestionAdherent.setFocusable(false);
		this.boutonGestionAdherent.addActionListener(this);
		this.add(this.boutonGestionAdherent);
		
		this.boutonValiderEmprunt = new JButton("Valider un emprunt");
		this.boutonValiderEmprunt.setFocusable(false);
		this.boutonValiderEmprunt.addActionListener(this);
		this.add(this.boutonValiderEmprunt);
		
		this.boutonAnnulerReservation = new JButton("Annuler une réservation");
		this.boutonAnnulerReservation.setFocusable(false);
		this.boutonAnnulerReservation.addActionListener(this);
		this.add(this.boutonAnnulerReservation);
		
		this.updateUI();
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		JButton boutonSelectionne = (JButton) event.getSource();
		
		if (boutonSelectionne == this.boutonAfficherListeJeux)
		{
			this.tacheDAffichageDeLApplication.afficherListeJeux();
			return;
		}
		
		if (boutonSelectionne == this.boutonValiderEmprunt)
		{
			return;
		}
		
		if (boutonSelectionne == this.boutonAnnulerReservation)
		{
			return;
		}
		
		if (boutonSelectionne == this.boutonGestionAdherent)
		{
			return;
		}
		
		return;
	}
}
