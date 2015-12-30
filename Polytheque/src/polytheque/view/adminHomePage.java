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
public class adminHomePage extends JPanel implements ActionListener {
	/**
	 * La largeur.
	 */
	private static final int LARGEUR = 3;
	
	/**
	 * La hauteur.
	 */
	private static final int HAUTEUR = 2;
	
	/**
	 * Un bouton.
	 */
	private JButton boutonAfficheListeJeux;
	
	/**
	 * Un bouton.
	 */
	private JButton boutonAjoutJeu;
	
	/**
	 * Un bouton.
	 */
	private JButton boutonModifJeu;
	
	/**
	 * Un bouton.
	 */
	private JButton boutonSupprJeu;
	
	/**
	 * Un bouton.
	 */
	private JButton boutonValiderEmprunt;
	
	/**
	 * Un bouton.
	 */
	private JButton boutonAnnulerReservation;
	
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
	public adminHomePage(TacheDAffichage afficheAppli){
		this.tacheDAffichageDeLApplication = afficheAppli;
		
		ajouterLesBoutons();
	}
	
	/**
	 * Ajouter les boutons dans la this.
	 */
	private void ajouterLesBoutons() {
		this.setLayout(new GridLayout(HAUTEUR, LARGEUR));
		
		this.boutonAfficheListeJeux = new JButton("Liste des jeux");
		this.boutonAfficheListeJeux.setFocusable(false);
		this.boutonAfficheListeJeux.addActionListener(this);
		this.add(this.boutonAfficheListeJeux);
		
		this.boutonAjoutJeu = new JButton("Ajouter un jeu");
		this.boutonAjoutJeu.setFocusable(false);
		this.boutonAjoutJeu.addActionListener(this);
		this.add(this.boutonAjoutJeu);
		
		this.boutonModifJeu = new JButton("Modifier un jeu");
		this.boutonModifJeu.setFocusable(false);
		this.boutonModifJeu.addActionListener(this);
		this.add(this.boutonModifJeu);
		
		this.boutonSupprJeu = new JButton("Supprimer un jeu");
		this.boutonSupprJeu.setFocusable(false);
		this.boutonSupprJeu.addActionListener(this);
		this.add(this.boutonSupprJeu);
		
		this.boutonValiderEmprunt = new JButton("Valider emprunt");
		this.boutonValiderEmprunt.setFocusable(false);
		this.boutonValiderEmprunt.addActionListener(this);
		this.add(this.boutonValiderEmprunt);
		
		this.boutonAnnulerReservation = new JButton("Annuler réservation");
		this.boutonAnnulerReservation.setFocusable(false);
		this.boutonAnnulerReservation.addActionListener(this);
		this.add(this.boutonAnnulerReservation);
		
		this.updateUI();
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		JButton boutonSelectionne = (JButton) event.getSource();
		
		if (boutonSelectionne == this.boutonAfficheListeJeux)
		{
			return;
		}
		
		if (boutonSelectionne == this.boutonAjoutJeu)
		{
			return;
		}
		
		if (boutonSelectionne == this.boutonModifJeu)
		{
			return;
		}
		
		if (boutonSelectionne == this.boutonSupprJeu)
		{
			return;
		}
		
		return;
	}
}
