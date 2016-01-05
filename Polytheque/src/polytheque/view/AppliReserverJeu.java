package polytheque.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import polytheque.controller.PolythequeApplication;
import polytheque.model.pojos.Jeu;
import polytheque.view.modeles.ModeleTableauListeJeux;

@SuppressWarnings("serial")
public class AppliReserverJeu extends JPanel implements ActionListener
{
	public final static int LONGUEUR_COLONNE_0 = 200;
	public final static int LONGUEUR_COLONNE_1 = 200;
	public final static int LONGUEUR_COLONNE_2 = 50;
	public final static int LONGUEUR_COLONNE_3 = 100;
	public final static int LONGUEUR_COLONNE_4 = 50;
	public final static int LONGUEUR_COLONNE_5 = 50;
	public final static int LONGUEUR_COLONNE_6 = 150;
	public final static int LONGUEUR_COLONNE_7 = 150;

	/**
	 * Hauteur des lignes.
	 */
	public final static int HAUTEUR_DES_LIGNES = 35;
	
	/**
	 * Nombre de colonnes du tableau.
	 */
	public final static int NOMBRE_COLONNES = 8;

	/**
	 * Les libellés des entêtes.
	 */
	public final static String[] LIBELLES = new String[] {"Nom", "Descritpion", "Année de parution", "Statut", "Age mini", "Nombre de joueurs mini", "Catégorie", "Editeur"};

	private TacheDAffichage tacheDAffichageDeLApplication;
	private JButton boutonvalider = new JButton("Valider");
	private Date datedebut;
	private Date datefin;
	private JButton boutonRetourAccueil;
	private JButton boutonRecherche;
	private JTextField searchContent;
	private JTextField DateContent;
	

	//TODO
	//"Veuiller indiquer la date souhait� de l'emprunt"
	//faire un afficherListe de jeux avec que ces jeux l�
	
	public AppliReserverJeu(TacheDAffichage afficheAppli)
	{
		creerPanneauDate();
		
	}
	
	
	private void creerTableau(ArrayList<Jeu> listeJeux) 
	{
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

		this.add(new JScrollPane(tableau), BorderLayout.CENTER);

		this.add(tableau);
		
	}
	
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
			donnees[index][5] = jeuCourant.getNbJoueurs();
			donnees[index][6] = jeuCourant.getCategorie();
			donnees[index][7] = jeuCourant.getEditeur();
			index++;
		}
		return donnees;
	}
	
	
	private void creerPanneauDate() {
		JPanel DatePanel = new JPanel();

		JLabel labelDate = new JLabel("Entrez la date a laquelle vous voudriez emprunter le jeux :");
		labelDate.setBounds(0, 150, 100, 30);
		DatePanel.add(labelDate);
		this.DateContent = new JTextField();
		this.searchContent.setBounds(100, 150, 100, 30);
		this.searchContent.setColumns(10);
		DatePanel.add(this.searchContent);
		this.boutonvalider = new JButton("OK");
		this.boutonvalider.addActionListener(this);
		DatePanel.add(boutonRecherche);

		this.add(DatePanel);
	}
	
	
	private void creerPanneauRecherche() {
		JPanel searchPanel = new JPanel();

		JLabel labelSearch = new JLabel("Recherche par nom :");
		labelSearch.setBounds(0, 150, 100, 30);
		searchPanel.add(labelSearch);
		this.searchContent = new JTextField();
		this.searchContent.setBounds(100, 150, 100, 30);
		this.searchContent.setColumns(10);
		searchPanel.add(this.searchContent);
		
		this.boutonRecherche = new JButton("Rechercher");
		this.boutonRecherche.addActionListener(this);
		searchPanel.add(boutonRecherche);

		this.add(searchPanel);
	}

	public void actionPerformed(ActionEvent e) 
	{
		ArrayList<Jeu> listeJeux = null;
		JButton boutonSelectionne = (JButton) e.getSource();

		if (boutonSelectionne == this.boutonvalider)
		{
			this.Applireservation2(this.searchContent.getText(),listeJeux);
			// Dans applireservation2 il faut afficher la liste des jeux disponibles pour la date donnee par l'user
			return;
		}
		// TODO Auto-generated method stub
		
	}


	private void Applireservation2(String text, ArrayList<Jeu> listeJeux) {
		// TODO Auto-generated method stub
		
	}


	


	
	
}
