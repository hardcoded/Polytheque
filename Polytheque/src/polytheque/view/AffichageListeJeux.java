package polytheque.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import polytheque.view.modeles.ModeleTableauListeJeux;

@SuppressWarnings("serial")
public class AffichageListeJeux extends JPanel implements ActionListener {


	public final static int LONGUEUR_COLONNE_0 = 100;
	public final static int LONGUEUR_COLONNE_1 = 200;
	public final static int LONGUEUR_COLONNE_2 = 50;
	public final static int LONGUEUR_COLONNE_3 = 50;
	public final static int LONGUEUR_COLONNE_4 = 50;
	public final static int LONGUEUR_COLONNE_5 = 50;
	public final static int LONGUEUR_COLONNE_6 = 50;
	public final static int LONGUEUR_COLONNE_7 = 50;

	/**
	 * Hauteur des lignes.
	 */
	public final static int HAUTEUR_DES_LIGNES = 35;

	/**
	 * Les libellés des entêtes.
	 */
	public final static String[] LIBELLES = new String[] {"Nom", "Descritpion", "Année de parution", "Statut", "Age mini", "Nombre de joueurs mini", "Catégorie", "Editeur"};

	/**
	 * Un bouton.
	 */
	private JButton boutonAjouterJeu;

	/**
	 * Un bouton.
	 */
	private JButton boutonModifierJeu;

	/**
	 * Un bouton.
	 */
	private JButton boutonSupprimerJeu;

	/**
	 * Une tache d'affichage de l'application.
	 */
	@SuppressWarnings("unused")
	private TacheDAffichage tacheDAffichageDeLApplication;

	public AffichageListeJeux(TacheDAffichage afficheAppli) {
		this.tacheDAffichageDeLApplication = afficheAppli;

		creerTableau();
		ajouterLesBoutons();
	}

	public void creerTableau() {

		Object[][] donnees = {
				{"Nom1", "TEST", "2015", "OK", "3 ans", "2 pers.", "Aventure", ""},
				{"Nom2", "test", "1995", "Abime", "8 ans", "2 pers.", "Action", "Moi"},
				{"Nom3", "Description", "2001", "OK", "12 ans", "4 pers.", "", "Lui"},
				{"Nom4", "Jeu de société", "2012", "OK", "3 ans", "6 pers.", "Societe", "Toi"},
		};

		JTable tableau = new JTable(new ModeleTableauListeJeux(donnees, LIBELLES));

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

		this.add(new JScrollPane(tableau), BorderLayout.CENTER);

		this.add(tableau);
	}

	/**
	 * Ajouter les boutons dans la this.
	 */
	private void ajouterLesBoutons() {
		JPanel buttonsPanel = new JPanel();

		this.boutonAjouterJeu = new JButton("Ajouter un jeu");
		this.boutonAjouterJeu.addActionListener(this);

		this.boutonModifierJeu = new JButton("Modifier un jeu");
		this.boutonModifierJeu.addActionListener(this);

		this.boutonSupprimerJeu = new JButton("Supprimer un jeu");
		this.boutonSupprimerJeu.addActionListener(this);

		buttonsPanel.add(boutonAjouterJeu);
		buttonsPanel.add(boutonModifierJeu);
		buttonsPanel.add(boutonSupprimerJeu);

		this.updateUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton boutonSelectionne = (JButton) e.getSource();

		if (boutonSelectionne == this.boutonAjouterJeu)
		{
			return;
		}

		if (boutonSelectionne == this.boutonModifierJeu)
		{
			return;
		}

		if (boutonSelectionne == this.boutonSupprimerJeu)
		{
			return;
		}
	}		
}


