package polytheque.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.omg.CORBA.Object;
import java.sql.Date;
import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class AppliReserverJeu extends JPanel implements ActionListener
{
	private TacheDAffichage tacheDAffichageDeLApplication;
	private JButton boutonRetourAccueil;
	private JButton boutonValider;
	private JTextField searchContent;
	private JTextField ExtensionContent;
	private JDateChooser dateChooser;
	
	
	public AppliReserverJeu(TacheDAffichage afficheAppli)
	{		
		
		this.tacheDAffichageDeLApplication = afficheAppli;
		creerPanneauRecherche();
		//creerPanneauExtension();
		creerPanneauDate();	
		this.boutonRetourAccueil = new JButton();
		this.boutonRetourAccueil.setBounds(400, 700, 100, 30);
		this.boutonRetourAccueil.addActionListener(this);
		this.add(boutonRetourAccueil);
	}

	/*private void creerPanneauExtension() 
	{
	
		JPanel ExtensionPanel = new JPanel();
		ExtensionPanel.setPreferredSize(new Dimension(TacheDAffichage.LARGEUR, 50));
		JLabel labelSearch = new JLabel("Recherche par nom :");
		labelSearch.setBounds(300, 400, 100, 30);
		ExtensionPanel.add(labelSearch);
		this.ExtensionContent = new JTextField();
		this.ExtensionContent.setBounds(450,400, 100, 30);
		this.ExtensionContent.setColumns(10);
		ExtensionPanel.add(this.searchContent, BorderLayout.NORTH);
		this.add(ExtensionPanel);

	}
*/
	private void creerPanneauRecherche() 
	{
		JPanel searchPanel = new JPanel();
		searchPanel.setPreferredSize(new Dimension(TacheDAffichage.LARGEUR, 50));
		JLabel labelSearch = new JLabel("Recherche par nom :");
		labelSearch.setBounds(400, 0, 100, 30);
		searchPanel.add(labelSearch);
		this.searchContent = new JTextField();
		this.searchContent.setBounds(450, 0, 100, 30);
		this.searchContent.setColumns(10);
		searchPanel.add(this.searchContent, BorderLayout.NORTH);
		this.add(searchPanel);		
	}

	private void creerPanneauDate() {
		JPanel DatePanel = new JPanel();
		DatePanel.setPreferredSize(new Dimension(TacheDAffichage.LARGEUR, 50));
		JLabel labelDate = new JLabel("Cliquez sur la date a laquelle vous voudriez emprunter le jeux :");
		labelDate.setBounds(400, 150, 100, 30);
		DatePanel.add(labelDate);
		this.dateChooser = new JDateChooser();
		this.dateChooser.setBounds(450, 150, 100, 30);
		DatePanel.add(this.dateChooser);
		this.add(DatePanel);
		this.boutonValider = new JButton("Valider");
		this.boutonValider.setBounds(400, 500, 100, 30);
		this.boutonValider.addActionListener(this);
		this.add(boutonValider);
	}

	
	
	public void actionPerformed(ActionEvent e) 
	{
		JButton boutonSelectionne = (JButton) e.getSource();
		if (boutonSelectionne == this.boutonValider)
		{
			this.tacheDAffichageDeLApplication.createReservation(this.tacheDAffichageDeLApplication.getAdherentByNothing().getIdAdherent(),this.tacheDAffichageDeLApplication.getJeu(this.searchContent.getText()).getIdJeu(),20,(Date) this.dateChooser.getDate());
			this.tacheDAffichageDeLApplication.afficherMessage("Reservation confirmee"," Confirmation", JOptionPane.INFORMATION_MESSAGE);
			this.tacheDAffichageDeLApplication.afficherAccueil();
		}		
		else if (boutonSelectionne == this.boutonRetourAccueil)
		{
			this.tacheDAffichageDeLApplication.afficherAccueil();;
		}
	}	
}

