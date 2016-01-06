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

import polytheque.model.pojos.Extension;
import polytheque.view.modeles.ModeleTableauListeJeux;

@SuppressWarnings("serial")
public class AffichageListeExtensions extends JPanel implements ActionListener {


	public final static int LONGUEUR_COLONNE_0 = 150;
	public final static int LONGUEUR_COLONNE_1 = 150;
	public final static int LONGUEUR_COLONNE_2 = 70;
	public final static int LONGUEUR_COLONNE_3 = 50;

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
	public final static String[] LIBELLES = new String[] {"Nom", "Descritpion", "Statut", "Jeu"};

	/**
	 * Boutons.
	 */
	private JButton boutonAjouterExtension;
	private JButton boutonModifierExtension;
	private JButton boutonSupprimerExtension;	
	private JButton boutonReserverExtension;	
	private JButton boutonRetourAccueil;
	private JButton boutonRecherche;
	private JButton boutonAfficherExtensions;

	private JTextField searchContent;

	/**
	 * Une tache d'affichage de l'application.
	 */
	private TacheDAffichage tacheDAffichageDeLApplication;

	public AffichageListeExtensions(TacheDAffichage afficheAppli, ArrayList<Extension> listeExtensions) {
		this.tacheDAffichageDeLApplication = afficheAppli;

		this.setLayout(new BorderLayout());
		creerPanneauRecherche();
		creerTableau(listeExtensions);
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
		//searchPanel.setPreferredSize(new Dimension(TacheDAffichage.LARGEUR, 50));

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

		this.add(searchPanel, BorderLayout.NORTH);
	}

	public void creerTableau(ArrayList<Extension> listeExtensions) {
		JPanel arrayPanel = new JPanel();
		//arrayPanel.setPreferredSize(new Dimension(TacheDAffichage.LARGEUR, 1000));
		arrayPanel.setLayout(new BorderLayout());

		JTable tableau = new JTable(new ModeleTableauListeJeux(initialiserDonnees(listeExtensions), LIBELLES));
		tableau.getColumn(LIBELLES[0]).setPreferredWidth(LONGUEUR_COLONNE_0);
		tableau.getColumn(LIBELLES[1]).setPreferredWidth(LONGUEUR_COLONNE_1);
		tableau.getColumn(LIBELLES[2]).setPreferredWidth(LONGUEUR_COLONNE_2);
		tableau.getColumn(LIBELLES[3]).setPreferredWidth(LONGUEUR_COLONNE_3);

		tableau.setRowHeight(HAUTEUR_DES_LIGNES);
		tableau.getTableHeader().setReorderingAllowed(true);
		tableau.getTableHeader().setResizingAllowed(true);
		tableau.setAutoCreateRowSorter(true);

		arrayPanel.add(new JScrollPane(tableau), BorderLayout.CENTER);

		this.add(arrayPanel, BorderLayout.CENTER);
	}

	/**
	 * Initialiser les données du tableau.
	 * 
	 * @param tachesARealiser
	 *            Une collection de taches à réaliser.
	 * @return Un tableau d'objets.
	 */
	private static Object[][] initialiserDonnees(ArrayList<Extension> listeExtensions)
	{
		Object[][] donnees = new Object[listeExtensions.size()][NOMBRE_COLONNES];

		int index = 0;		
		for (Extension extensionCourante : listeExtensions)
		{
			donnees[index][0] = extensionCourante.getNom();
			donnees[index][1] = extensionCourante.getDescription();
			donnees[index][2] = extensionCourante.getStatut();
			donnees[index][3] = extensionCourante.getNomJeu();
			index++;
		}		
		return donnees;
	}

	/**
	 * Ajouter les boutons de l'administrateur.
	 */
	private void ajouterBoutonsAdmin() {
		JPanel buttonsPanel = new JPanel();
		//buttonsPanel.setPreferredSize(new Dimension(TacheDAffichage.LARGEUR, 50));

		this.boutonAjouterExtension = new JButton("Ajouter un jeu");
		this.boutonAjouterExtension.addActionListener(this);

		this.boutonModifierExtension = new JButton("Modifier un jeu");
		this.boutonModifierExtension.addActionListener(this);

		this.boutonSupprimerExtension = new JButton("Supprimer un jeu");
		this.boutonSupprimerExtension.addActionListener(this);

		this.boutonRetourAccueil = new JButton("Accueil");
		this.boutonRetourAccueil.addActionListener(this);

		buttonsPanel.add(boutonAjouterExtension, BorderLayout.SOUTH);
		buttonsPanel.add(boutonModifierExtension, BorderLayout.SOUTH);
		buttonsPanel.add(boutonSupprimerExtension, BorderLayout.SOUTH);
		buttonsPanel.add(boutonRetourAccueil, BorderLayout.SOUTH);

		this.add(buttonsPanel, BorderLayout.SOUTH);
	}

	/**
	 * Ajouter les boutons dans la this.
	 */
	private void ajouterBoutonsAdherent() {
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setPreferredSize(new Dimension(TacheDAffichage.LARGEUR, 50));

		this.boutonAfficherExtensions = new JButton("Afficher les extensions");
		this.boutonAfficherExtensions.addActionListener(this);

		this.boutonReserverExtension = new JButton("Réserver un jeu");
		this.boutonReserverExtension.addActionListener(this);

		this.boutonRetourAccueil = new JButton("Accueil");
		this.boutonRetourAccueil.addActionListener(this);

		buttonsPanel.add(boutonAfficherExtensions, BorderLayout.SOUTH);
		buttonsPanel.add(boutonReserverExtension, BorderLayout.SOUTH);
		buttonsPanel.add(boutonRetourAccueil, BorderLayout.SOUTH);

		this.add(buttonsPanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton boutonSelectionne = (JButton) e.getSource();

		if (boutonSelectionne == this.boutonAjouterExtension)
		{
			this.tacheDAffichageDeLApplication.afficherMessage("Fonctionnalité pas disponible", "Non disponible !", JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		if (boutonSelectionne == this.boutonModifierExtension)
		{
			this.tacheDAffichageDeLApplication.afficherMessage("Fonctionnalité pas disponible", "Non disponible !", JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		if (boutonSelectionne == this.boutonSupprimerExtension)
		{
			this.tacheDAffichageDeLApplication.afficherMessage("Fonctionnalité pas disponible", "Non disponible !", JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		if (boutonSelectionne == this.boutonReserverExtension)
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
			this.tacheDAffichageDeLApplication.rechercherExtensions(this.searchContent.getText());
			return;
		}

		if (boutonSelectionne == this.boutonAfficherExtensions)
		{
			this.tacheDAffichageDeLApplication.afficherListeExtensions();
			return;
		}
		return;
	}		
}
