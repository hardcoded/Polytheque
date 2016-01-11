package polytheque.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import polytheque.model.pojos.Reservation;
import polytheque.view.modeles.ModeleTableauListeJeux;

@SuppressWarnings("serial")
public class AffichageListeReservations extends JPanel implements ActionListener {

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
	public final static String[] LIBELLES = new String[] {"Pseudo", "Nom jeu", "Nom extention", "Date de r�servation"};

	private JButton boutonAnnulerReservation;
	private JButton boutonValiderReservation;
	
	private JPanel buttonsPanel;
	private JPanel arrayPanel;
	
	private TacheDAffichage tacheDAffichageDeLApplication;
	
	public AffichageListeReservations(TacheDAffichage afficheAppli, ArrayList<Reservation> listeReservations) {
		this.tacheDAffichageDeLApplication = afficheAppli;

		this.setLayout(new BorderLayout());
		rafraichir(listeReservations);
		ajouterBoutonAdmin();
	}
	
	/**
	 * Ajouter les boutons de l'administrateur.
	 */
	private void ajouterBoutonAdmin() {
		this.buttonsPanel = new JPanel();
		this.buttonsPanel.setPreferredSize(new Dimension(TacheDAffichage.LARGEUR, 50));

		this.boutonAnnulerReservation = new JButton("Annuler une r�servation");
		this.boutonAnnulerReservation.addActionListener(this);
		this.boutonValiderReservation = new JButton("Valider une r�servation");
		this.boutonValiderReservation.addActionListener(this);
		
		this.buttonsPanel.add(boutonAnnulerReservation, BorderLayout.SOUTH);
		this.buttonsPanel.add(boutonValiderReservation, BorderLayout.SOUTH);
		
		this.add(this.buttonsPanel, BorderLayout.SOUTH);
	}
	
	public void creerTableau(ArrayList<Reservation> listeReservations) {
		this.arrayPanel = new JPanel();
		this.arrayPanel.setLayout(new BorderLayout());

		JTable tableau = new JTable(new ModeleTableauListeJeux(initialiserDonnees(listeReservations), LIBELLES));
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
	 * Initialiser les données du tableau.
	 * 
	 * @param tachesARealiser
	 *            Une collection de taches à réaliser.
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
			donnees[index][2] = reservationCourante.getExtension().getNom();
			donnees[index][3] = reservationCourante.getDate();
			index++;
		}		
		return donnees;
	}
	
	public void rafraichir(ArrayList<Reservation> reservations) {
		if (this.arrayPanel != null) {
			this.arrayPanel.removeAll();
		}
		this.creerTableau(reservations);
		this.arrayPanel.updateUI();
	}
	
	public void modifierMainPanel(JPanel panel) {
		this.arrayPanel.removeAll();
		this.arrayPanel = panel;
		this.add(this.arrayPanel, BorderLayout.CENTER);
		this.arrayPanel.updateUI();
	}

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
			this.tacheDAffichageDeLApplication.afficherMessage("Fonctionnalites non disponible", "Erreur",0);
		}
		return;
	}

}
