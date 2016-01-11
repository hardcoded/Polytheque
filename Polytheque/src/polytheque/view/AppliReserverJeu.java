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

import java.sql.Date;
import com.toedter.calendar.JDateChooser;

import polytheque.model.pojos.Reservation;

@SuppressWarnings("serial")
public class AppliReserverJeu extends JPanel implements ActionListener
{
	private TacheDAffichage tacheDAffichageDeLApplication;
	private JButton boutonValider;
	private JTextField searchContent;
	private JTextField searchExtension;
	private JDateChooser dateChooser;
	
	
	public AppliReserverJeu(TacheDAffichage afficheAppli)
	{		
		
		this.tacheDAffichageDeLApplication = afficheAppli;
		this.setLayout(null);
		creerPanneauRecherche();
		creerPanneauDate();	
		

	}


	private void creerPanneauRecherche() 
	{
		JLabel titrePrincipal = new JLabel("Cr�ation de la R�servation");
		titrePrincipal.setBounds(480, 20, 260, 30);
		this.add(titrePrincipal);
		
		JLabel labelSearch = new JLabel("Recherche par nom du jeu :");
		labelSearch.setBounds(400, 100, 200, 30);
		this.add(labelSearch);
		this.searchContent = new JTextField();
		this.searchContent.setBounds(570, 100, 100, 30);
		this.searchContent.setColumns(10);
		this.add(searchContent);		
		
		JLabel labelExtension = new JLabel("Recherche par de l'extension :");
		labelExtension.setBounds(400, 150, 200, 30);
		this.add(labelExtension);
		this.searchExtension = new JTextField();
		this.searchExtension.setBounds(590, 150, 100, 30);
		this.searchExtension.setColumns(10);
		this.add(searchExtension);
	}

	private void creerPanneauDate() {
		JLabel labelDate = new JLabel("Cliquez sur la date a laquelle vous voudriez emprunter le jeux :");
		labelDate.setBounds(400, 200, 400, 30);
		this.add(labelDate);
		this.dateChooser = new JDateChooser();
		this.dateChooser.setBounds(770, 200, 100, 30);
		this.add(this.dateChooser);
		this.boutonValider = new JButton("Valider");
		this.boutonValider.setBounds(480, 250, 100, 30);
		this.boutonValider.addActionListener(this);
		this.add(boutonValider);
	}

	
	
	public void actionPerformed(ActionEvent e) 
	{
		JButton boutonSelectionne = (JButton) e.getSource();
		if (boutonSelectionne == this.boutonValider && this.dateChooser.getDate() != null && this.searchContent.getText() != null)
		{
			int NbExemplaires = this.tacheDAffichageDeLApplication.getJeu(this.searchContent.getText()).getNbExemplaires();
			int NbReserves = this.tacheDAffichageDeLApplication.getJeu(this.searchContent.getText()).getNbExemplaires();
			if (NbExemplaires > NbReserves )
			{
				Date dateReservation = new Date(this.dateChooser.getDate().getTime());
				int IdAdherent = this.tacheDAffichageDeLApplication.getAdherentByNothing().getIdAdherent();
				int IdJeu = this.tacheDAffichageDeLApplication.getJeu(this.searchContent.getText()).getIdJeu();
				Reservation reservation = new Reservation(IdAdherent,IdJeu,dateReservation);
			
				if(this.tacheDAffichageDeLApplication.createReservation2(reservation,IdAdherent,IdJeu,dateReservation))
					{
						this.tacheDAffichageDeLApplication.afficherMessage("Reservation de Jeu confirmee"," Confirmation", JOptionPane.INFORMATION_MESSAGE);
						this.tacheDAffichageDeLApplication.afficherAccueil();
					}
				
			}
			
			else
			{
				this.tacheDAffichageDeLApplication.afficherMessage("Ce jeu n'est plus disponible veuiller en choisir un autre svp!!"," Oups :( ", JOptionPane.INFORMATION_MESSAGE);
			}
		}
			else
			{
				this.tacheDAffichageDeLApplication.afficherMessage("Veuillez verifier que toute les informations requises on �t� entr�e"," Erreur", JOptionPane.INFORMATION_MESSAGE);
			}
		
		}	
}

