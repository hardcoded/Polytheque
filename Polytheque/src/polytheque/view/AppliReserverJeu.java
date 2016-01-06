package polytheque.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import polytheque.model.pojos.Jeu;

@SuppressWarnings("serial")
public class AppliReserverJeu extends JPanel implements ActionListener
{
	private TacheDAffichage tacheDAffichageDeLApplication;
	private JButton boutonvalider;
	private	Date datedebut;
	private Date datefin;
	private JButton boutonRetourAccueil;
	private JButton boutonRecherche;
	private JButton boutonValider;
	private JTextField searchContent;
	private JTextField DateContent;
	private JTextField ExtensionContent;

	//TODO
	//"Veuiller indiquer la date souhait� de l'emprunt"
	//faire un afficherListe de jeux avec que ces jeux l�
	
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
		this.add(searchPanel);		
	}
	
	private void creerPanneauDate() {
		JPanel DatePanel = new JPanel();
		DatePanel.setPreferredSize(new Dimension(TacheDAffichage.LARGEUR, 50));
		JLabel labelDate = new JLabel("Cliquez sur la date a laquelle vous voudriez emprunter le jeux :");
		labelDate.setBounds(0, 150, 100, 30);
		this.add(labelDate);
	    JDateChooser dateChooser = new JDateChooser();
	    dateChooser.setBounds(20, 20, 60, 20);
	    DatePanel.add(dateChooser);
		this.add(DatePanel);
		this.boutonValider = new JButton("Valider");
		this.boutonValider.addActionListener(this);
		this.add(boutonValider);
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		JButton boutonSelectionne = (JButton) e.getSource();
		if (boutonSelectionne == this.boutonValider)
		{
			return;
		}		
	}	
}

