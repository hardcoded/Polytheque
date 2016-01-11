package polytheque.view;

import java.awt.BorderLayout;
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
import polytheque.view.modeles.ModeleTableauJeux;

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
	 * Les libellés des entêtes.
	 */
	public final static String[] LIBELLES = new String[] {"Nom", "Descritpion", "Année de parution", "Statut", "Age mini", "Joueurs mini", "Joueurs maxi", "Catégorie", "Editeur"};

	/**
	 * Boutons.
	 */
	private JButton boutonAjouterJeu;
	private JButton boutonModifierJeu;
	private JButton boutonSupprimerJeu;
	private JButton boutonRecherche;

	private JTextField searchContent;
	private JTextField modifJeu;
	
	private JPanel buttonsPanel;
	private JPanel arrayPanel;
	private JPanel searchPanel;

	/**
	 * Une tache d'affichage de l'application.
	 */
	private TacheDAffichage tacheDAffichageDeLApplication;

	public AffichageListeJeux(TacheDAffichage afficheAppli, ArrayList<Jeu> listeJeux) {
		this.tacheDAffichageDeLApplication = afficheAppli;

		this.setLayout(new BorderLayout());
		creerPanneauRecherche();
		creerTableau(listeJeux);
		if (this.tacheDAffichageDeLApplication.adherentAdmin()) {
			ajouterBoutonsAdmin();
		}
	}

	/**
	 * Panneau de recherche
	 */
	private void creerPanneauRecherche() {
		this.searchPanel = new JPanel();

		JLabel labelSearch = new JLabel("Recherche par nom :");
		this.searchPanel.add(labelSearch, BorderLayout.CENTER);
		this.searchContent = new JTextField();
		this.searchContent.setColumns(10);
		this.searchPanel.add(this.searchContent, BorderLayout.CENTER);

		this.boutonRecherche = new JButton("Rechercher");
		this.boutonRecherche.addActionListener(this);
		this.searchPanel.add(boutonRecherche, BorderLayout.CENTER);

		this.add(searchPanel, BorderLayout.NORTH);
	}

	public void creerTableau(ArrayList<Jeu> listeJeux) {
		this.arrayPanel = new JPanel();
		this.arrayPanel.setLayout(new BorderLayout());

		JTable tableau = new JTable(new ModeleTableauJeux(initialiserDonnees(listeJeux), LIBELLES));
		tableau.getColumn(LIBELLES[0]).setPreferredWidth(LONGUEUR_COLONNE_0);
		tableau.getColumn(LIBELLES[1]).setPreferredWidth(LONGUEUR_COLONNE_1);
		tableau.getColumn(LIBELLES[2]).setPreferredWidth(LONGUEUR_COLONNE_2);
		tableau.getColumn(LIBELLES[3]).setPreferredWidth(LONGUEUR_COLONNE_3);
		tableau.getColumn(LIBELLES[4]).setPreferredWidth(LONGUEUR_COLONNE_4);
		tableau.getColumn(LIBELLES[5]).setPreferredWidth(LONGUEUR_COLONNE_5);
		tableau.getColumn(LIBELLES[6]).setPreferredWidth(LONGUEUR_COLONNE_6);
		tableau.getColumn(LIBELLES[7]).setPreferredWidth(LONGUEUR_COLONNE_7);

		tableau.setRowHeight(HAUTEUR_DES_LIGNES);
		tableau.getTableHeader().setReorderingAllowed(true);
		tableau.getTableHeader().setResizingAllowed(true);
		tableau.setAutoCreateRowSorter(true);

		this.arrayPanel.add(new JScrollPane(tableau), BorderLayout.CENTER);
		this.add(this.arrayPanel, BorderLayout.CENTER);
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
			donnees[index][0] = jeuCourant.getNom();
			donnees[index][1] = jeuCourant.getDescription();
			donnees[index][2] = jeuCourant.getAnneeParution();
			donnees[index][3] = jeuCourant.getStatut();
			donnees[index][4] = jeuCourant.getAgeMini();
			donnees[index][5] = jeuCourant.getNbJoueursMin();
			donnees[index][6] = jeuCourant.getNbJoueursMax();
			donnees[index][7] = jeuCourant.getCategorie();
			donnees[index][8] = jeuCourant.getEditeur();
			index++;
		}		
		return donnees;
	}

	/**
	 * Ajouter les boutons de l'administrateur.
	 */
	private void ajouterBoutonsAdmin() {
		this.buttonsPanel = new JPanel();

		this.boutonAjouterJeu = new JButton("Ajouter un jeu");
		this.boutonAjouterJeu.addActionListener(this);

		JLabel labelSearch = new JLabel("Modifier par nom :");
		this.modifJeu = new JTextField();
		this.modifJeu.setColumns(10);

		this.boutonModifierJeu = new JButton("Modifier un jeu");
		this.boutonModifierJeu.addActionListener(this);

		this.boutonSupprimerJeu = new JButton("Supprimer un jeu");
		this.boutonSupprimerJeu.addActionListener(this);
		
		this.buttonsPanel.add(boutonAjouterJeu, BorderLayout.SOUTH);
		this.buttonsPanel.add(labelSearch, BorderLayout.SOUTH);
		this.buttonsPanel.add(this.modifJeu, BorderLayout.SOUTH);
		this.buttonsPanel.add(boutonModifierJeu, BorderLayout.SOUTH);
		this.buttonsPanel.add(boutonSupprimerJeu, BorderLayout.SOUTH);

		this.add(this.buttonsPanel, BorderLayout.SOUTH);
	}
	
	public void rafraichir(ArrayList<Jeu> jeux) {
		this.arrayPanel.removeAll();
		this.creerTableau(jeux);
		this.arrayPanel.updateUI();
	}
	
	public void modifierMainPanel(JPanel panel) {
		this.arrayPanel.removeAll();
		this.arrayPanel.add(panel);
		this.add(this.arrayPanel, BorderLayout.CENTER);
		this.updateUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton boutonSelectionne = (JButton) e.getSource();

		if (boutonSelectionne == this.boutonAjouterJeu)
		{
			this.modifierMainPanel(this.tacheDAffichageDeLApplication.afficherCreationJeu());
			return;
		}

		if (boutonSelectionne == this.boutonModifierJeu)
		{
			this.modifierMainPanel(this.tacheDAffichageDeLApplication.afficherModificationJeu(this.tacheDAffichageDeLApplication.getJeu(this.modifJeu.getText())));
			return;
		}

		if (boutonSelectionne == this.boutonSupprimerJeu)
		{
			this.modifierMainPanel(this.tacheDAffichageDeLApplication.afficherSupprimerJeu());
			return;
		}
		
		if (boutonSelectionne == this.boutonRecherche)
		{
			this.rafraichir(this.tacheDAffichageDeLApplication.rechercherJeux(this.searchContent.getText()));;
			return;
		}		
		return;
	}		
}


