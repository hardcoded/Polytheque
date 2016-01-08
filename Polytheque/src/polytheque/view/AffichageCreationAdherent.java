package polytheque.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;



import polytheque.model.pojos.Adherent;

/**
 * Classe permettant de gerer la modification des informations li�es au compte de l'utilisateur.
 * 
 * @author Godefroi Roussel
 *
 */
@SuppressWarnings("serial")
public class AffichageCreationAdherent extends JPanel implements ActionListener {
	
		private JTextField userName;
		private JTextField userFirstName;
		private JTextField userBirthday;
		private JTextField userPseudo;
		private JTextField userRue;
		private JTextField userCP;
		private JTextField userVille;
		private JTextField userPhone;
		private JTextField userMail;
		private JTextField userCptRetard;
		
		private JPasswordField password;
		
		private JButton boutonValider;
		private JButton boutonRetourAccueil;
		
		private JPanel userInfoPanel;
		private JPanel userIsAdminPanel;
		private JPanel userPeutEmprunterPanel;
		private JPanel userEstAJourPanel;
		
		private Adherent adherentCourant;
		
		JComboBox<Boolean> userIsAdmin;
		JComboBox<Boolean> userPeutEmprunter;
		JComboBox<Boolean> userEstAJour;
		
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
		public AffichageCreationAdherent(TacheDAffichage afficheAppli) {
			this.tacheDAffichageDeLApplication = afficheAppli;
			this.setLayout(new BorderLayout());
			
			ajouterChamps();
			creerPanneauDate();
			//ajouterBoutons();
		}
		
		public void ajouterChamps() {			
			JLabel titrePrincipal = new JLabel("Mon compte");
			titrePrincipal.setHorizontalAlignment(SwingConstants.CENTER);
			titrePrincipal.setBounds(350, 20, 260, 30);
			this.add(titrePrincipal);
			
			this.userInfoPanel = new JPanel();

			JLabel labelUserName = new JLabel("Nom :");
			this.userInfoPanel.add(labelUserName);
			/*this.userName = new JTextField();
			this.userName.setColumns(10);
			this.add(this.userName, BorderLayout.CENTER);
			*/
			
			this.userInfoPanel.setPreferredSize(new Dimension(TacheDAffichage.LARGEUR, 50));
			
			
			this.userInfoPanel.add(labelUserName);
			labelUserName.setBounds(300, 150, 100, 30);
			this.userName = new JTextField();
			this.userName.setBounds(350, 150, 100, 30);
			this.userInfoPanel.add(this.userName);
			this.add(this.userInfoPanel);
			
			/*JLabel labelUserFirstName = new JLabel("Prenom :");
			labelUserFirstName.setBounds(300, 180, 100, 30);
			this.userInfoPanel.add(labelUserFirstName);
			this.userFirstName = new JTextField();
			this.userFirstName.setBounds(360, 180, 100, 30);
			this.userInfoPanel.add(this.userFirstName);
			//this.add(this.userInfoPanel); 
			
			JLabel labelUserRue = new JLabel("Rue :");
			labelUserRue.setBounds(300, 240, 100, 30);
			this.userInfoPanel.add(labelUserRue);
			this.userRue = new JTextField();
			this.userRue.setBounds(350, 240, 100, 30);
			this.userInfoPanel.add(this.userRue);
			//this.add(this.userInfoPanel);
			
			JLabel labelUserCP = new JLabel("Code Postal:");
			labelUserCP.setBounds(300, 270, 100, 30);
			this.userInfoPanel.add(labelUserCP);
			this.userCP = new JTextField();
			this.userCP.setBounds(390, 270, 100, 30);
			this.userInfoPanel.add(this.userCP);
			//this.add(this.userInfoPanel);
	
			
			JLabel labelUserVille = new JLabel("Ville :");
			labelUserVille.setBounds(300, 300, 100, 30);
			this.userInfoPanel.add(labelUserVille);
			this.userVille = new JTextField();
			this.userVille.setBounds(350, 300, 100, 30);
			this.userInfoPanel.add(this.userVille);
			//this.add(this.userInfoPanel);
			
			JLabel labelUserMail = new JLabel("Mail :");
			labelUserMail.setBounds(300, 330, 100, 30);
			this.userInfoPanel.add(labelUserMail);
			this.userMail = new JTextField();
			this.userMail.setBounds(350, 330, 100, 30);
			this.userInfoPanel.add(this.userMail);
			//this.add(this.userInfoPanel);
			
			
			JLabel labelUserTelephone = new JLabel("Telephone :");
			labelUserTelephone.setBounds(300, 360, 100, 30);
			this.userInfoPanel.add(labelUserTelephone);
			this.userPhone = new JTextField();
			this.userPhone.setBounds(370, 360, 100, 30);
			this.userInfoPanel.add(this.userPhone);
			//this.add(this.userInfoPanel);
			
			
			JLabel labelUserPseudo = new JLabel("Pseudo :");
			labelUserPseudo.setBounds(300, 390, 100, 30);
			this.userInfoPanel.add(labelUserPseudo);
			this.userPseudo = new JTextField();
			this.userPseudo.setBounds(360, 390, 100, 30);
			this.userInfoPanel.add(this.userPseudo);
			//this.add(this.userInfoPanel);
			

			JLabel labelpassword = new JLabel("Mot de passe :");
			labelpassword.setBounds(300, 420, 100, 30);
			this.userInfoPanel.add(labelpassword);
			this.password = new JPasswordField();
			this.password.setBounds(380, 420, 190, 30);
			this.password.setColumns(10);
			this.userInfoPanel.add(this.password);
			//this.add(this.userInfoPanel);
			
			JLabel labelUserCptRetard = new JLabel("Compteur Retard :");
			labelUserCptRetard.setBounds(300, 450, 100, 30);
			this.userInfoPanel.add(labelUserCptRetard);
			this.userCptRetard = new JTextField();
			this.userCptRetard.setBounds(380, 450, 190, 30);
			this.userInfoPanel.add(this.userCptRetard);
			this.add(this.userInfoPanel);
			
			this.userIsAdminPanel = new JPanel();
			this.userIsAdminPanel.setPreferredSize(new Dimension(100, 20));
			
			JLabel labelUserIsAdmin = new JLabel("Admin :");
			labelUserIsAdmin.setBounds(800, 450, 100, 30);
			this.userIsAdminPanel.add(labelUserIsAdmin);			
			this.userIsAdmin = new JComboBox<Boolean>();
			this.userIsAdmin.addItem(Boolean.TRUE);
			this.userIsAdmin.addItem(Boolean.FALSE);
			this.userIsAdmin.setPreferredSize(new Dimension(100, 20));
			this.userIsAdmin.setBounds(860, 450, 100, 30);
			this.userIsAdminPanel.add(this.userIsAdmin);
			this.add(this.userIsAdminPanel, BorderLayout.CENTER);
			
			this.userPeutEmprunterPanel = new JPanel();
			this.userPeutEmprunterPanel.setPreferredSize(new Dimension(100, 20));
			
			JLabel labelUserPeutEmprunter = new JLabel("Peut Emprunter :");
			labelUserPeutEmprunter.setBounds(600, 100, 100, 30);
			this.userPeutEmprunterPanel.add(labelUserPeutEmprunter);
			this.userPeutEmprunter = new JComboBox<Boolean>();
			this.userPeutEmprunter.addItem(Boolean.TRUE);
			this.userPeutEmprunter.addItem(Boolean.FALSE);
			this.userPeutEmprunter.setPreferredSize(new Dimension(100, 20));
		    this.userPeutEmprunter.setBounds(600, 150, 100, 30);
		    this.userPeutEmprunterPanel.add(this.userPeutEmprunter);
			this.add(this.userPeutEmprunterPanel);
			
			this.userEstAJourPanel = new JPanel();
			this.userEstAJourPanel.setPreferredSize(new Dimension(20, 20));
			
			JLabel labelUserEstAJour = new JLabel("Est a jour :");
			labelUserEstAJour.setBounds(600, 200, 100, 30);
			this.userEstAJourPanel.add(labelUserEstAJour);
			this.userEstAJour = new JComboBox<Boolean>();
			this.userEstAJour.addItem(Boolean.TRUE);
			this.userEstAJour.addItem(Boolean.FALSE);
			this.userEstAJour.setPreferredSize(new Dimension(20, 20));
			this.userEstAJour.setBounds(600, 250, 100, 30);
			this.userEstAJourPanel.add(this.userEstAJour);
			this.add(this.userEstAJourPanel);*/
		}
		
		
		private void creerPanneauDate() {
			JPanel DatePanel = new JPanel();
			DatePanel.setPreferredSize(new Dimension(TacheDAffichage.LARGEUR, 50));
			JLabel labelUserBirthday = new JLabel("Cliquez sur votre date de naissance :");
			labelUserBirthday.setBounds(400, 150, 200, 30);
			DatePanel.add(labelUserBirthday);
			JDateChooser dateChooser = new JDateChooser();
			dateChooser.setBounds(400, 200, 200, 30);
			DatePanel.add(dateChooser);
			this.add(DatePanel);
		}
		
		
		public void ajouterBoutons(){
			this.boutonValider = new JButton("Valider");
			this.boutonValider.setBounds(200, 500, 200, 30);
			this.boutonValider.addActionListener(this);
			this.add(this.boutonValider);
		}

		@Override
		public void actionPerformed(ActionEvent event) {
			JButton boutonSelectionne = (JButton) event.getSource();

			if (boutonSelectionne == this.boutonValider)
			{
				int cptRetard = Integer.parseInt(this.userCptRetard.getText());
				String password = new String(this.password.getPassword());
				//TODO faire un DatePicker pour la date de naissance car besoin d'un format date pour insérer nouvel adhérent
				Adherent adherent = new Adherent(this.userName.getText(), this.userFirstName.getText(),this.adherentCourant.getDateNaissance(), this.userRue.getText(), this.userCP.getText(), this.userVille.getText(), this.userMail.getText(), this.userPhone.getText(), this.userPseudo.getText(), password, this.userIsAdmin.getAutoscrolls(), this.userEstAJour.getAutoscrolls(),this.userPeutEmprunter.getAutoscrolls(), cptRetard);
				this.tacheDAffichageDeLApplication.afficherMessage("Un nouvel adhérent a ete crée !", "Création terminée", JOptionPane.INFORMATION_MESSAGE);
				this.tacheDAffichageDeLApplication.creerAdherent(adherent);
				this.tacheDAffichageDeLApplication.afficherGestionAdherent();
				return;
				}

			return;
		}



}
