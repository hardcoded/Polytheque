package polytheque.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import polytheque.controller.PolythequeApplication;
import polytheque.model.pojos.Jeu;
import polytheque.view.modeles.ModeleTableauListeJeux;

@SuppressWarnings("serial")
public class AppliReserverJeu extends JPanel implements ActionListener
{
	
	private TacheDAffichage tacheDAffichageDeLApplication;
	private JButton boutonvalider = new JButton("Valider");
	private	Date datedebut;
	private Date datefin;
	private JButton boutonRetourAccueil;
	private JButton boutonRecherche;
	private JButton boutonValider;
	private JTextField searchContent;
	private JTextField DateContent;
	private JTextField ExtensionContent;
	
	

	//TODO
	//"Veuiller indiquer la date souhaitï¿½ de l'emprunt"
	//faire un afficherListe de jeux avec que ces jeux lï¿½
	
	public AppliReserverJeu(TacheDAffichage afficheAppli)
	{
		
		creerPanneauRecherche();
		creerPanneauExtension();
		creerPanneauDate();
		
	}
	
	
	
	private void creerPanneauExtension() 
	{
		// TODO Auto-generated method stub
		
	}



	private void creerPanneauRecherche() 
	{
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

		
	}



	private void creerPanneauDate() {
		JPanel DatePanel = new JPanel();
		DatePanel.setPreferredSize(new Dimension(TacheDAffichage.LARGEUR, 50));
		JLabel labelDate = new JLabel("Cliquez sur la date a laquelle vous voudriez emprunter le jeux :");
		labelDate.setBounds(0, 150, 100, 30);
		DatePanel.add(labelDate);
	    JDateChooser dateChooser = new JDateChooser();
	    dateChooser.setBounds(20, 20, 60, 20);
	    DatePanel.add(dateChooser);
		this.add(DatePanel);
		this.boutonValider = new JButton("Valider");
		this.boutonValider.addActionListener(this);
	}
	
	
	
	
	public void actionPerformed(ActionEvent e) 
	{
		JButton boutonSelectionne = (JButton) e.getSource();
		if (boutonSelectionne == this.boutonValider)
		{
			ArrayList<Jeu> listeJeux = new ArrayList<Jeu>();
			for(Jeu jeucourant : listeJeux)
				if (jeucourant.getNom() == this.searchContent.getText() && !jeucourant.getDisponibilite() )
				{
					this.tacheDAffichageDeLApplication.afficherMessage("Ce jeu n'est pas disponible pour la date choisie", "Erreur!", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					/*le redirigé vers la page de confirmation de la reservation*/
				}
			
			// Dans applireservation2 il faut afficher la liste des jeux disponibles pour la date donnee par l'user
		
		}
		// TODO Auto-generated method stub
		
	}

		



	


	
	
}

