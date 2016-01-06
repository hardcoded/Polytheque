package polytheque.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class AffichageListeReservations extends JPanel implements ActionListener {

	public final static int LONGUEUR_COLONNE_0 = 50;
	public final static int LONGUEUR_COLONNE_1 = 50;
	public final static int LONGUEUR_COLONNE_2 = 150;
	public final static int LONGUEUR_COLONNE_3 = 50;

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
	public final static String[] LIBELLES = new String[] {"Nom", "Pr�nom", "Titre", "Date"};

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
