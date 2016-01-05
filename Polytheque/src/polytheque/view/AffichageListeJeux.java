package polytheque.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import polytheque.model.pojos.Jeu;
import polytheque.view.modeles.ModeleTableauListeJeux;

@SuppressWarnings("serial")
public class AffichageListeJeux extends JPanel implements ActionListener {


	public final static int LONGUEUR_COLONNE_0 = 150;
	public final static int LONGUEUR_COLONNE_1 = 150;
	public final static int LONGUEUR_COLONNE_2 = 70;
	public final static int LONGUEUR_COLONNE_3 = 50;
	public final static int LONGUEUR_COLONNE_4 = 60;
	public final static int LONGUEUR_COLONNE_5 = 100;
	public final static int LONGUEUR_COLONNE_6 = 100;
	public final static int LONGUEUR_COLONNE_7 = 100;
	public final static int LONGUEUR_COLONNE_8 = 150;

	/**
	 * Hauteur des lignes.
	 */
	public final static int HAUTEUR_DES_LIGNES = 35;
	
	/**
	 * Nombre de colonnes du tableau.
	 */
	public final static int NOMBRE_COLONNES = 9;

	/**
	 * Séparation de la fenêtre dans le sens de la hauteur
	 */
	public final static int HAUTEUR = 3;
	
	/**
	 * Séparation de la fenêtre dans le sens de la largeur
	 */
	public final static int LARGEUR = 1;
	
	/**
	 * Les libellés des entêtes.
	 */
	public final static String[] LIBELLES = new String[] {"Nom", "Descritpion", "Année de parution", "Statut", "Age mini", "Joueurs mini", "Joueurs maxi", "Catégorie", "Editeur"};

	/**
	 * Boutons.
	 */
	private JButton boutonAjouterJeu;
	private JButton boutonModifierJeu;
	private JButton boutonSupprimerJeu;	
	private JButton boutonReserverJeu;	
	private JButton boutonRetourAccueil;
	private JButton boutonRecherche;
	
	private JTextField searchContent;

	/**
	 * Une tache d'affichage de l'application.
	 */
	private TacheDAffichage tacheDAffichageDeLApplication;

	public AffichageListeJeux(TacheDAffichage afficheAppli, ArrayList<Jeu> listeJeux) {
		this.tacheDAffichageDeLApplication = afficheAppli;
		
		this.setLayout(new GridLayout(HAUTEUR, LARGEUR));
		creerPanneauRecherche();
		creerTableau(listeJeux);
		if (this.tacheDAffichageDeLApplication.adherentAdmin()) {
			ajouterBoutonsAdmin();
		}
		else {
			ajouterBoutonsAdherent();
		}
	}

	/**
	 * Panneau de recherche
	 */
	private void creerPanneauRecherche() {
		JPanel searchPanel = new JPanel();
		searchPanel.setPreferredSize(new Dimension(TacheDAffichage.LARGEUR, 50));
		
		JLabel labelSearch = new JLabel("Recherche par nom :");
		labelSearch.setBounds(300, 0, 100, 30);
		searchPanel.add(labelSearch);
		this.searchContent = new JTextField();
		this.searchContent.setBounds(450, 0, 100, 30);
		this.searchContent.setColumns(10);
		searchPanel.add(this.searchContent, BorderLayout.NORTH);
		
		this.boutonRecherche = new JButton("Rechercher");
		this.boutonRecherche.addActionListener(this);
		searchPanel.add(boutonRecherche, BorderLayout.NORTH);

		this.add(searchPanel);
	}
	
	public void creerTableau(ArrayList<Jeu> listeJeux) {
		JPanel arrayPanel = new JPanel();
		arrayPanel.setPreferredSize(new Dimension(TacheDAffichage.LARGEUR, 1000));
		arrayPanel.setLayout(new BorderLayout());
		
		JTable tableau = new JTable(new ModeleTableauListeJeux(initialiserDonnees(listeJeux), LIBELLES));
		tableau.getColumn(LIBELLES[0]).setPreferredWidth(LONGUEUR_COLONNE_0);
		tableau.getColumn(LIBELLES[1]).setPreferredWidth(LONGUEUR_COLONNE_1);
		tableau.getColumn(LIBELLES[2]).setPreferredWidth(LONGUEUR_COLONNE_2);
		tableau.getColumn(LIBELLES[3]).setPreferredWidth(LONGUEUR_COLONNE_3);
		tableau.getColumn(LIBELLES[4]).setPreferredWidth(LONGUEUR_COLONNE_4);
		tableau.getColumn(LIBELLES[5]).setPreferredWidth(LONGUEUR_COLONNE_5);
		tableau.getColumn(LIBELLES[6]).setPreferredWidth(LONGUEUR_COLONNE_6);
		tableau.getColumn(LIBELLES[7]).setPreferredWidth(LONGUEUR_COLONNE_7);

		tableau.setRowHeight(HAUTEUR_DES_LIGNES);

		tableau.getTableHeader().setReorderingAllowed(false);
		tableau.getTableHeader().setResizingAllowed(false);
		arrayPanel.add(new JScrollPane(tableau), BorderLayout.CENTER);
		this.add(arrayPanel);
	}
	
	/**
	 * Initialiser les données du tableau.
	 * 
	 * @param tachesARealiser
	 *            Une collection de taches à réaliser.
	 * @return Un tableau d'objets.
	 */
	private static Object[][] initialiserDonnees(ArrayList<Jeu> listeJeux)
	{
		Object[][] donnees = new Object[listeJeux.size()][NOMBRE_COLONNES];
		
		int index = 0;		
		for (Jeu jeuCourant : listeJeux)
		{
			if (jeuCourant.getNom() != null) {
				donnees[index][0] = jeuCourant.getNom();
			}
			if (jeuCourant.getDescription() != null) {
				donnees[index][1] = jeuCourant.getDescription();
			}
			if (jeuCourant.getAnneeParution() != null) {
				donnees[index][2] = jeuCourant.getAnneeParution();
			}
			if (jeuCourant.getStatut() != null) {
				donnees[index][3] = jeuCourant.getStatut();
			}
			donnees[index][4] = jeuCourant.getAgeMini();
			donnees[index][5] = jeuCourant.getNbJoueursMin();
			donnees[index][6] = jeuCourant.getNbJoueursMax();
			if (jeuCourant.getCategorie() != null) {
				donnees[index][7] = jeuCourant.getCategorie();
			}
			if (jeuCourant.getEditeur() != null) {
				donnees[index][8] = jeuCourant.getEditeur();
			}
			index++;
		}		
		return donnees;
	}

	/**
	 * Ajouter les boutons de l'administrateur.
	 */
	private void ajouterBoutonsAdmin() {
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setPreferredSize(new Dimension(TacheDAffichage.LARGEUR, 50));

		this.boutonAjouterJeu = new JButton("Ajouter un jeu");
		this.boutonAjouterJeu.addActionListener(this);

		this.boutonModifierJeu = new JButton("Modifier un jeu");
		this.boutonModifierJeu.addActionListener(this);

		this.boutonSupprimerJeu = new JButton("Supprimer un jeu");
		this.boutonSupprimerJeu.addActionListener(this);
		
		this.boutonRetourAccueil = new JButton("Accueil");
		this.boutonRetourAccueil.addActionListener(this);

		buttonsPanel.add(boutonAjouterJeu, BorderLayout.SOUTH);
		buttonsPanel.add(boutonModifierJeu, BorderLayout.SOUTH);
		buttonsPanel.add(boutonSupprimerJeu, BorderLayout.SOUTH);
		buttonsPanel.add(boutonRetourAccueil, BorderLayout.SOUTH);

		this.add(buttonsPanel);
	}
	
	/**
	 * Ajouter les boutons dans la this.
	 */
	private void ajouterBoutonsAdherent() {
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setPreferredSize(new Dimension(TacheDAffichage.LARGEUR, 50));
		
		this.boutonReserverJeu = new JButton("Réserver un jeu");
		this.boutonReserverJeu.addActionListener(this);
		
		this.boutonRetourAccueil = new JButton("Accueil");
		this.boutonRetourAccueil.addActionListener(this);

		buttonsPanel.add(boutonReserverJeu, BorderLayout.SOUTH);
		buttonsPanel.add(boutonRetourAccueil, BorderLayout.SOUTH);

		this.add(buttonsPanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton boutonSelectionne = (JButton) e.getSource();

		if (boutonSelectionne == this.boutonAjouterJeu)
		{
			this.tacheDAffichageDeLApplication.afficherMessage("Fonctionnalité pas disponible", "Non disponible !", JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		if (boutonSelectionne == this.boutonModifierJeu)
		{
			this.tacheDAffichageDeLApplication.afficherMessage("Fonctionnalité pas disponible", "Non disponible !", JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		if (boutonSelectionne == this.boutonSupprimerJeu)
		{
			this.tacheDAffichageDeLApplication.afficherMessage("Fonctionnalité pas disponible", "Non disponible !", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		
		if (boutonSelectionne == this.boutonReserverJeu)
		{
			this.tacheDAffichageDeLApplication.afficherMessage("Fonctionnalité pas disponible", "Non disponible !", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		
		if (boutonSelectionne == this.boutonRetourAccueil)
		{
			this.tacheDAffichageDeLApplication.afficherAccueil();
			return;
		}
		
		if (boutonSelectionne == this.boutonRecherche)
		{
			this.tacheDAffichageDeLApplication.rechercherJeux(this.searchContent.getText());;
			return;
		}
		return;
	}		
}


