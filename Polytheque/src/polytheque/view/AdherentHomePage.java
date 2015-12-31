package polytheque.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Classe permettant d'afficher la page d'accueil de l'application pour un adhérent non administrateur.
 * Vient après l'écran de connexion.
 * 
 * @author Johan Brunet
 */
@SuppressWarnings("serial")
public class AdherentHomePage extends JPanel implements ActionListener {
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
	private JButton boutonModifierInfos;

	/**
	 * Un bouton.
	 */
	private JButton boutonEffectuerReservation;
	
	/**
	 * Un bouton.
	 */
	private JButton boutonConsulterReservations;
	
	/**
	 * Une tache d'affichage de l'application.
	 */
	@SuppressWarnings("unused")
	private TacheDAffichage tacheDAffichageDeLApplication;
	
	/**
	 * Création de la page d'accueil.
	 * 
	 * @param tacheDAffichageDeLApplication
	 *            Une tache d'affichage de l'application.
	 */
	public AdherentHomePage(TacheDAffichage afficheAppli){
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
		
		this.boutonModifierInfos = new JButton("Modifier mes informations");
		this.boutonModifierInfos.setFocusable(false);
		this.boutonModifierInfos.addActionListener(this);
		this.add(this.boutonModifierInfos);
		
		this.boutonEffectuerReservation = new JButton("Effectuer une réservation");
		this.boutonEffectuerReservation.setFocusable(false);
		this.boutonEffectuerReservation.addActionListener(this);
		this.add(this.boutonEffectuerReservation);
		
		this.boutonConsulterReservations = new JButton("Consulter mes réservations");
		this.boutonConsulterReservations.setFocusable(false);
		this.boutonConsulterReservations.addActionListener(this);
		this.add(this.boutonConsulterReservations);
		
		this.updateUI();
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		JButton boutonSelectionne = (JButton) event.getSource();
		
		if (boutonSelectionne == this.boutonAfficherListeJeux)
		{
			return;
		}
		
		if (boutonSelectionne == this.boutonModifierInfos)
		{
			return;
		}
		
		if (boutonSelectionne == this.boutonConsulterReservations)
		{
			return;
		}
		
		return;
	}
}
