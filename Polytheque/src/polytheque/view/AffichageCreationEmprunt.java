package polytheque.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import polytheque.model.pojos.Adherent;
import polytheque.model.pojos.Emprunt;
import polytheque.model.pojos.Extension;
import polytheque.model.pojos.Jeu;
import polytheque.model.pojos.Reservation;

/**
 * Classe permettant à l'administrateur de créer un emprunt
 * @author laure
 *
 */

@SuppressWarnings("serial")
public class AffichageCreationEmprunt extends JPanel implements ActionListener{
	/**
	 * champs utiles pour que l'utilisateur écrive
	 */
	private JTextField gameName;
	private JTextField extensionName;
	private JTextField userPseudo;
	
	private JDateChooser dateChooser; //calendrier
	private JButton boutonValider; //bouton
	
	/**
	 * Une tache d'affichage de l'application.
	 */
	private TacheDAffichage tacheDAffichageDeLApplication;
	
	/**
	 * Creation de la page d'accueil.
	 * 
	 * @param tacheDAffichageDeLApplication
	 *            Une tache d'affichage de l'application.
	 * @return 
	 */
	public AffichageCreationEmprunt(TacheDAffichage afficheAppli) {
		this.tacheDAffichageDeLApplication = afficheAppli;
		this.setLayout(null);
		
		ajouterChamps();
		creerPanneauDate();
		ajouterBoutons();
	}
	
	/**
	 * méthode qui ajoutes les champs de l'affichage (titre,boutons..)
	 */
	public void ajouterChamps() {		
		
		JLabel titrePrincipal = new JLabel("Emprunter un jeu et/ou une extension");
		titrePrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		titrePrincipal.setBounds(480, 20, 260, 30);
		this.add(titrePrincipal);
		
		JLabel labelGameName = new JLabel("Nom du jeu :");
		labelGameName.setBounds(150, 150, 100, 30);
		this.add(labelGameName);
		
		this.gameName = new JTextField();
		this.gameName.setBounds(300, 150, 100, 30);
		this.add(gameName);
					
		JLabel labelExtensionName = new JLabel("Nom de l'extension :");
		labelExtensionName.setBounds(150, 200, 150, 30);
		this.add(labelExtensionName);
		
		this.extensionName = new JTextField();
		this.extensionName.setBounds(300, 200, 100, 30);
		this.add(extensionName);
		
		JLabel labelUserPseudo = new JLabel("Pseudo de l'adherent :");
		labelUserPseudo.setBounds(150, 250, 150, 30);
		this.add(labelUserPseudo);
		this.userPseudo = new JTextField();
		this.userPseudo.setBounds(300, 250, 100, 30);
		this.add(this.userPseudo);
	}
	
	/**
	 * creer le calendrier permettant de choisir la date voulue
	 */
	private void creerPanneauDate() {
		JLabel labelDateEmprunt = new JLabel("Date de l'emprunt :");
		labelDateEmprunt.setBounds(850, 150, 150, 30);
		this.add(labelDateEmprunt);
		this.dateChooser = new JDateChooser();
		this.dateChooser.setBounds(850, 200, 150, 30);
		this.add(this.dateChooser);
	}
	
	/**
	 * ajoute les boutons à la fenetre
	 */
	public void ajouterBoutons(){
		this.boutonValider = new JButton("Valider");
		this.boutonValider.setBounds(480, 500, 200, 30);
		this.boutonValider.addActionListener(this);
		this.add(this.boutonValider);
	}
	
	/**
	 * traitement des évènements (click sur bouton)
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		JButton boutonSelectionne = (JButton) event.getSource();

		if (boutonSelectionne == this.boutonValider)
		{	//on vérifie que les champs importants sont remplis
			if (this.gameName.getText() != null && this.userPseudo.getText() != null && this.dateChooser.getDate() != null)
			{
				// on récupère les paramètres pour créer notre emprunt
				Date dateEmprunt = new Date(this.dateChooser.getDate().getTime());
				Adherent adherent = this.tacheDAffichageDeLApplication.getAdherent(userPseudo.getText());
				Jeu jeu = this.tacheDAffichageDeLApplication.getJeu(gameName.getText());
				Extension extention = this.tacheDAffichageDeLApplication.getExt(extensionName.getText());
				Reservation reservation = new Reservation(adherent.getIdAdherent(),jeu.getIdJeu(),extention.getIdExtension(),dateEmprunt);
				Emprunt emprunt = reservation.validerReservation();
				//affichage des messages à l'utilisateur
				if (this.tacheDAffichageDeLApplication.creerEmprunt(emprunt)){
					this.tacheDAffichageDeLApplication.afficherMessage("Un emprunt a été effectué !", "Création terminée", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					this.tacheDAffichageDeLApplication.afficherMessage("Erreur lors de l'emprunt", "Erreur de création", JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
			else {
				this.tacheDAffichageDeLApplication.afficherMessage("Veuillez renseigner tous les champs !", "Erreur champ(s) vide(s)", JOptionPane.ERROR_MESSAGE);
			}
		}
		return;
	}

}
