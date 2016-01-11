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
		JLabel titrePrincipal = new JLabel("Création de la Réservation");
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
		Date currentDate = new Date(new java.util.Date().getTime());
		JButton boutonSelectionne = (JButton) e.getSource();
		if (boutonSelectionne == this.boutonValider  )
		{
			if(this.dateChooser.getDate() != null && this.dateChooser.getDate().after(currentDate)){

				if (this.searchContent.getText() != null && this.searchExtension.getText() == null)
				{
					int NbExemplaires = this.tacheDAffichageDeLApplication.getJeu(this.searchContent.getText()).getNbExemplaires();
					int NbReserves = this.tacheDAffichageDeLApplication.getJeu(this.searchContent.getText()).getNbExemplaires();
					if (NbExemplaires > NbReserves )
					{
						Date dateReservation = new Date(this.dateChooser.getDate().getTime());
						int IdAdherent = this.tacheDAffichageDeLApplication.getAdherentByNothing().getIdAdherent();
						int IdJeu = this.tacheDAffichageDeLApplication.getJeu(this.searchContent.getText()).getIdJeu();
						Reservation reservation = new Reservation(IdAdherent,IdJeu,dateReservation);

						if(this.tacheDAffichageDeLApplication.createReservation2(reservation,IdAdherent,IdJeu,dateReservation)) {
							this.tacheDAffichageDeLApplication.afficherMessage("Reservation de Jeu confirmee"," Confirmation", JOptionPane.INFORMATION_MESSAGE);
							this.tacheDAffichageDeLApplication.afficherAccueil();
						}

					}

					else {
						this.tacheDAffichageDeLApplication.afficherMessage("Ce jeu n'est plus disponible veuiller en choisir un autre svp!!"," Oups :( ", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else if(this.searchContent.getText() == null && this.searchExtension.getText() != null){
					int NbExemplaires = this.tacheDAffichageDeLApplication.getExt(this.searchContent.getText()).getNbExemplaires();
					int NbReserves = this.tacheDAffichageDeLApplication.getExt(this.searchContent.getText()).getNbReserves();
					if (NbExemplaires > NbReserves )
					{
						Date dateReservationExt = new Date(this.dateChooser.getDate().getTime());
						int IdAdherent = this.tacheDAffichageDeLApplication.getAdherentByNothing().getIdAdherent();
						int IdExtention = this.tacheDAffichageDeLApplication.getExt(this.searchContent.getText()).getIdExtension();
						Reservation reservation = new Reservation(IdExtention,dateReservationExt,IdAdherent);

						if(this.tacheDAffichageDeLApplication.createReservation3(reservation,IdAdherent,IdExtention,dateReservationExt))
						{
							this.tacheDAffichageDeLApplication.afficherMessage("Reservation d'extention confirmee"," Confirmation", JOptionPane.INFORMATION_MESSAGE);
							this.tacheDAffichageDeLApplication.afficherAccueil();
						}

					}

					else
					{
						this.tacheDAffichageDeLApplication.afficherMessage("Cette extention n'est plus disponible veuiller en choisir un autre svp!!"," Oups :( ", JOptionPane.INFORMATION_MESSAGE);

					}

				}

				else if(this.searchContent.getText() == null && this.searchExtension.getText() == null){

					this.tacheDAffichageDeLApplication.afficherMessage("Veuillez verifier que toute les informations requises on été entrée"," Erreur", JOptionPane.INFORMATION_MESSAGE);;
				}

				else if(this.searchContent.getText() != null && this.searchExtension.getText() != null)
				{
					return;
				}
			}
			else if(this.dateChooser.getDate() == null || this.dateChooser.getDate().before(currentDate))
			{
				this.tacheDAffichageDeLApplication.afficherMessage("Veuillez verifier que vous avez entré une date valide "," Erreur", JOptionPane.INFORMATION_MESSAGE);;
			}

		}
	}	
}

