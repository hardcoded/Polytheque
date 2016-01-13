package polytheque.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import polytheque.model.pojos.Reservation;
import polytheque.view.modeles.ModeleTableauReservations;
/**
 * classe d'affichage de toutes les reservations pour l'administrateur uniquement
 * @author Laure
 *
 */
@SuppressWarnings("serial")
public class AffichageListeReservations extends JPanel implements ActionListener {
	/**
	 * initialisation des colonnes utiles au tableau d'affichage
	 */
	public final static int LONGUEUR_COLONNE_0 = 50;
	public final static int LONGUEUR_COLONNE_1 = 50;
	public final static int LONGUEUR_COLONNE_2 = 150;
	public final static int LONGUEUR_COLONNE_3 = 150;
	
	/**
	 * Hauteur des lignes.
	 */
	public final static int HAUTEUR_DES_LIGNES = 35;

	/**
	 * Nombre de colonnes du tableau.
	 */
	public final static int NOMBRE_COLONNES = 4;

	/**
	 * SÃ©paration de la fenÃªtre dans le sens de la hauteur
	 */
	public final static int HAUTEUR = 3;

	/**
	 * SÃ©paration de la fenÃªtre dans le sens de la largeur
	 */
	public final static int LARGEUR = 1;

	/**
	 * Les libellÃ©s des entÃªtes.
	 */
	public final static String[] LIBELLES = new String[] {"Pseudo", "Nom jeu", "Nom extention", "Date de réservation"};

	//boutons
	private JButton boutonAnnulerReservation;
	private JButton boutonValiderReservation;
	private JButton boutonRecherche;
	
	//Panel permettant d'afficher le tableau et les boutons ou la barre de recherche sur une fenetre
	private JPanel buttonsPanel;
	private JPanel arrayPanel;
	private JPanel searchPanel;
	
	private TacheDAffichage tacheDAffichageDeLApplication; //classe ou toutes les fonctions utiles à l'affichage sont écrites
	private ModeleTableauReservations tableauReservations; //donne le modele à suivre pour le tableau

	private JTextField searchContent; //champ permettant d'écrire
	
	/**
	 * constructeur de l'affichage des reservations
	 * @param afficheAppli
	 * @param listeReservations
	 */
	public AffichageListeReservations(TacheDAffichage afficheAppli, ArrayList<Reservation> listeReservations) {
		this.tacheDAffichageDeLApplication = afficheAppli;

		this.setLayout(new BorderLayout());
		creerPanneauRecherche();
		creerTableau(listeReservations);
		ajouterBoutonAdmin();
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
	
	/**
	 * Ajouter les boutons de l'administrateur.
	 */
	private void ajouterBoutonAdmin() {
		this.buttonsPanel = new JPanel();
		this.buttonsPanel.setPreferredSize(new Dimension(TacheDAffichage.LARGEUR, 50));

		this.boutonAnnulerReservation = new JButton("Annuler une réservation");
		this.boutonAnnulerReservation.addActionListener(this);
		this.boutonValiderReservation = new JButton("Valider une réservation");
		this.boutonValiderReservation.addActionListener(this);
		
		this.buttonsPanel.add(boutonAnnulerReservation, BorderLayout.SOUTH);
		this.buttonsPanel.add(boutonValiderReservation, BorderLayout.SOUTH);
		
		this.add(this.buttonsPanel, BorderLayout.SOUTH);
	}
	
	/**
	 * création du tableau
	 * @param listeReservations
	 */
	public void creerTableau(ArrayList<Reservation> listeReservations) {
		this.arrayPanel = new JPanel();
		this.arrayPanel.setLayout(new BorderLayout());

		this.tableauReservations = new ModeleTableauReservations(initialiserDonnees(listeReservations), LIBELLES);
		JTable tableau = new JTable(tableauReservations);
		tableau.getColumn(LIBELLES[0]).setPreferredWidth(LONGUEUR_COLONNE_0);
		tableau.getColumn(LIBELLES[1]).setPreferredWidth(LONGUEUR_COLONNE_1);
		tableau.getColumn(LIBELLES[2]).setPreferredWidth(LONGUEUR_COLONNE_2);
		tableau.getColumn(LIBELLES[3]).setPreferredWidth(LONGUEUR_COLONNE_3);

		tableau.setRowHeight(HAUTEUR_DES_LIGNES);
		tableau.getTableHeader().setReorderingAllowed(true);
		tableau.getTableHeader().setResizingAllowed(true);
		tableau.setAutoCreateRowSorter(true);

		this.arrayPanel.add(new JScrollPane(tableau), BorderLayout.CENTER);
		this.add(this.arrayPanel, BorderLayout.CENTER);
	}
	
	/**
	 * Initialiser les donnÃ©es du tableau.
	 * 
	 * @param tachesARealiser
	 *            Une collection de taches Ã  rÃ©aliser.
	 * @return Un tableau d'objets.
	 */
	private static Object[][] initialiserDonnees(ArrayList<Reservation> listeReservations)
	{
		Object[][] donnees = new Object[listeReservations.size()][NOMBRE_COLONNES];

		int index = 0;		
		for (Reservation reservationCourante : listeReservations)
		{
			donnees[index][0] = reservationCourante.getAdherent().getPseudo();
			donnees[index][1] = reservationCourante.getJeu().getNom();
			//donnees[index][2] = reservationCourante.getExtension().getNom();
			donnees[index][3] = reservationCourante.getDate();
			index++;
		}		
		return donnees;
	}
	
	/**
	 * remise à jour du tableau 
	 * @param reservations
	 */
	public void rafraichir(ArrayList<Reservation> reservations) {
		creerTableau(reservations);
		this.arrayPanel.updateUI();
		this.tableauReservations.refresh(initialiserDonnees(reservations));
	}

	/**
	 * méthode qui permet de traiter les évènements (les cliques sur boutons)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton boutonSelectionne = (JButton) e.getSource();

		if (boutonSelectionne == this.boutonAnnulerReservation)
		{
			this.tacheDAffichageDeLApplication.afficherEcranAnnulationR();
			return;
		}
		if (boutonSelectionne == this.boutonValiderReservation)
		{
			this.tacheDAffichageDeLApplication.afficherMessage("Fonctionnalité non disponible", "Erreur",0);
		}
		if (boutonSelectionne == this.boutonRecherche)
		{
			this.tacheDAffichageDeLApplication.rechercherReservations(this.searchContent.getText());
		}
		return;
	}

}
