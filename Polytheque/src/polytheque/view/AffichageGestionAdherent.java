package polytheque.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import polytheque.model.pojos.Adherent;
import polytheque.view.modeles.ModeleTableauListeJeux;

/**
 * Classe permettant de gerer la modification des informations li�es au compte de l'utilisateur.
 * 
 * @author Godefroi Roussel
 *
 */
@SuppressWarnings("serial")
public class AffichageGestionAdherent extends JPanel implements ActionListener {

	public final static int LONGUEUR_COLONNE_0 = 100;
	public final static int LONGUEUR_COLONNE_1 = 100;
	public final static int LONGUEUR_COLONNE_2 = 100;
	public final static int LONGUEUR_COLONNE_3 = 100;
	public final static int LONGUEUR_COLONNE_4 = 100;
	public final static int LONGUEUR_COLONNE_5 = 100;
	public final static int LONGUEUR_COLONNE_6 = 100;
	public final static int LONGUEUR_COLONNE_7 = 100;
	public final static int LONGUEUR_COLONNE_8 = 100;
	public final static int LONGUEUR_COLONNE_9 = 100;
	public final static int LONGUEUR_COLONNE_10 = 100;
	public final static int LONGUEUR_COLONNE_11 = 100;

	/**
	 * Hauteur des lignes.
	 */
	public final static int HAUTEUR_DES_LIGNES = 35;

	/**
	 * Nombre de colonnes du tableau.
	 */
	public final static int NOMBRE_COLONNES = 12;

	/**
	 * Les libellés des entêtes.
	 */
	public final static String[] LIBELLES = new String[] {"Nom", "Prénom", "Date de naissance", "Rue", 
			"Code postal", "Ville", "Mail", "Téléphone", "Pseudo", 
			"Sur liste noire", "Est à jour", "Nombre de retards"};

	private JTextField searchContent;
	private JTextField modifContent;	

	private JButton boutonCreerAdherent;
	private JButton boutonModifierAdherent;
	private JButton boutonSupprimerAdherent;
	private JButton boutonRecherche;
	
	private JPanel buttonsPanel;
	private JPanel mainPanel;
	private JPanel searchPanel;

	/**
	 * Une tache d'affichage de l'application.
	 */
	private TacheDAffichage tacheDAffichageDeLApplication;

	/**
	 * Creation de la page d'accueil.
	 * 
	 * @param tacheDAffichageDeLApplication
	 *            Une tache d'affichage de l'application.
	 * @return 
	 */
	public AffichageGestionAdherent(TacheDAffichage afficheAppli, ArrayList<Adherent> listeAdherents){
		this.tacheDAffichageDeLApplication = afficheAppli;
		this.setLayout(new BorderLayout());

		creerPanneauRecherche();
		creerTableau(listeAdherents);
		ajouterBoutons();
	}

	/**
	 * Panneau de recherche
	 */
	private void creerPanneauRecherche() {
		this.searchPanel = new JPanel();

		JLabel nameSearch = new JLabel("Recherche par nom :");
		this.searchPanel.add(nameSearch);
		this.searchContent = new JTextField();
		this.searchContent.setColumns(10);
		this.searchPanel.add(this.searchContent, BorderLayout.NORTH);

		this.boutonRecherche = new JButton("Rechercher");
		this.boutonRecherche.addActionListener(this);
		this.searchPanel.add(boutonRecherche, BorderLayout.NORTH);
		
		JLabel pseudoSearch = new JLabel("Modifier par pseudo :");
		this.searchPanel.add(pseudoSearch);
		this.modifContent = new JTextField();
		this.modifContent.setColumns(10);
		this.searchPanel.add(this.modifContent, BorderLayout.NORTH);

		this.boutonModifierAdherent = new JButton("Modifier Adherent");
		this.boutonModifierAdherent.addActionListener(this);
		this.searchPanel.add(boutonModifierAdherent, BorderLayout.NORTH);

		this.add(this.searchPanel, BorderLayout.NORTH);
	}

	public void creerTableau(ArrayList<Adherent> listeAdherents) {
		this.mainPanel = new JPanel();
		this.mainPanel.setLayout(new BorderLayout());

		JTable tableau = new JTable(new ModeleTableauListeJeux(initialiserDonnees(listeAdherents), LIBELLES));
		tableau.getColumn(LIBELLES[0]).setPreferredWidth(LONGUEUR_COLONNE_0);
		tableau.getColumn(LIBELLES[1]).setPreferredWidth(LONGUEUR_COLONNE_1);
		tableau.getColumn(LIBELLES[2]).setPreferredWidth(LONGUEUR_COLONNE_2);
		tableau.getColumn(LIBELLES[3]).setPreferredWidth(LONGUEUR_COLONNE_3);
		tableau.getColumn(LIBELLES[4]).setPreferredWidth(LONGUEUR_COLONNE_4);
		tableau.getColumn(LIBELLES[5]).setPreferredWidth(LONGUEUR_COLONNE_5);
		tableau.getColumn(LIBELLES[6]).setPreferredWidth(LONGUEUR_COLONNE_6);
		tableau.getColumn(LIBELLES[7]).setPreferredWidth(LONGUEUR_COLONNE_7);
		tableau.getColumn(LIBELLES[5]).setPreferredWidth(LONGUEUR_COLONNE_8);
		tableau.getColumn(LIBELLES[6]).setPreferredWidth(LONGUEUR_COLONNE_9);
		tableau.getColumn(LIBELLES[7]).setPreferredWidth(LONGUEUR_COLONNE_10);
		tableau.getColumn(LIBELLES[5]).setPreferredWidth(LONGUEUR_COLONNE_11);

		tableau.setRowHeight(HAUTEUR_DES_LIGNES);
		tableau.getTableHeader().setReorderingAllowed(true);
		tableau.getTableHeader().setResizingAllowed(true);
		tableau.setAutoCreateRowSorter(true);

		this.mainPanel.add(new JScrollPane(tableau), BorderLayout.CENTER);
		this.add(this.mainPanel, BorderLayout.CENTER);
	}

	/**
	 * Initialiser les données du tableau.
	 * 
	 * @param tachesARealiser
	 *            Une collection de taches à réaliser.
	 * @return Un tableau d'objets.
	 */
	private static Object[][] initialiserDonnees(ArrayList<Adherent> listeAdherents)
	{
		Object[][] donnees = new Object[listeAdherents.size()][NOMBRE_COLONNES];

		int index = 0;		
		for (Adherent adherentCourant : listeAdherents)
		{
			donnees[index][0] = adherentCourant.getNom();
			donnees[index][1] = adherentCourant.getPrenom();
			donnees[index][2] = adherentCourant.getDateNaissance();
			donnees[index][3] = adherentCourant.getRue();
			donnees[index][4] = adherentCourant.getCP();
			donnees[index][5] = adherentCourant.getVille();
			donnees[index][6] = adherentCourant.getMail();
			donnees[index][7] = adherentCourant.getTelephone();
			donnees[index][8] = adherentCourant.getPseudo();
			donnees[index][9] = adherentCourant.peutEmprunter();
			donnees[index][10] = adherentCourant.estAJour();
			donnees[index][11] = adherentCourant.getCompteurRetard();
			index++;
		}		
		return donnees;
	}

	public void ajouterBoutons(){
		this.buttonsPanel = new JPanel();
		this.boutonCreerAdherent = new JButton("Créer Adherent");
		this.boutonCreerAdherent.addActionListener(this);
		this.buttonsPanel.add(this.boutonCreerAdherent);

		this.boutonSupprimerAdherent = new JButton("Supprimer Adherent");
		this.boutonSupprimerAdherent.addActionListener(this);
		this.buttonsPanel.add(this.boutonSupprimerAdherent);

		this.add(this.buttonsPanel, BorderLayout.SOUTH);
	}
	
	public void modifierMainPanel(JPanel panel) {
		this.mainPanel.removeAll();
		this.mainPanel.add(panel);
		this.add(this.mainPanel, BorderLayout.CENTER);
		this.updateUI();
	}
	
	public void rafraichir(ArrayList<Adherent> adherents) {
		this.mainPanel.removeAll();
		this.creerTableau(adherents);
		this.updateUI();
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		JButton boutonSelectionne = (JButton) event.getSource();

		if (boutonSelectionne == this.boutonRecherche)
		{
			this.rafraichir(this.tacheDAffichageDeLApplication.rechercherAdherents(this.searchContent.getText()));
			return;
		}

		if (boutonSelectionne == this.boutonCreerAdherent)
		{
			this.modifierMainPanel(this.tacheDAffichageDeLApplication.afficherCreationAdherent()); 
			return;
		}

		if (boutonSelectionne == this.boutonSupprimerAdherent)
		{
			this.modifierMainPanel(this.tacheDAffichageDeLApplication.afficherSupprimerAdherent());
			return;
		}

		if (boutonSelectionne == this.boutonModifierAdherent)
		{
			this.modifierMainPanel(this.tacheDAffichageDeLApplication.afficherModificationAdherent(this.tacheDAffichageDeLApplication.getAdherent(this.modifContent.getText())));
			return;
		}
		return;
	}




}
