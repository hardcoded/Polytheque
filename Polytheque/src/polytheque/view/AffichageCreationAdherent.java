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
			JPanel titrePanel = new JPanel();
			
			JLabel titrePrincipal = new JLabel("Cr�ation Adh�rent");
			titrePrincipal.setHorizontalAlignment(SwingConstants.CENTER);
			titrePrincipal.setBounds(350, 20, 260, 30);
			titrePanel.add(titrePrincipal);
			this.add(titrePanel, BorderLayout.NORTH);
			
			JPanel userInfoPanel = new JPanel();
			
			JLabel labelUserName = new JLabel("Nom :");
			userInfoPanel.add(labelUserName);
			//labelUserName.setBounds(300, 150, 100, 30);
			this.userName = new JTextField();
			//this.userName.setBounds(350, 150, 100, 30);
			userInfoPanel.add(this.userName);
			//this.add(userInfoPanel, BorderLayout.WEST);
						
			JLabel labelUserFirstName = new JLabel("Prenom :");
			labelUserFirstName.setBounds(300, 180, 100, 30);
			userInfoPanel.add(labelUserFirstName);
			this.userFirstName = new JTextField();
			this.userFirstName.setBounds(360, 180, 100, 30);
			userInfoPanel.add(this.userFirstName);
			//this.add(this.userInfoPanel, BorderLayout.WEST); 
			
			JLabel labelUserRue = new JLabel("Rue :");
			labelUserRue.setBounds(300, 240, 100, 30);
			userInfoPanel.add(labelUserRue);
			this.userRue = new JTextField();
			this.userRue.setBounds(350, 240, 100, 30);
			userInfoPanel.add(this.userRue);
			//this.add(this.userInfoPanel, BorderLayout.WEST);
			
			JLabel labelUserCP = new JLabel("Code Postal:");
			labelUserCP.setBounds(300, 270, 100, 30);
			userInfoPanel.add(labelUserCP);
			this.userCP = new JTextField();
			this.userCP.setBounds(390, 270, 100, 30);
			userInfoPanel.add(this.userCP);
			//this.add(this.userInfoPanel, BorderLayout.WEST);
	
			
			JLabel labelUserVille = new JLabel("Ville :");
			labelUserVille.setBounds(300, 300, 100, 30);
			userInfoPanel.add(labelUserVille);
			this.userVille = new JTextField();
			this.userVille.setBounds(350, 300, 100, 30);
			userInfoPanel.add(this.userVille);
			//this.add(this.userInfoPanel, BorderLayout.WEST);
			
			JLabel labelUserMail = new JLabel("Mail :");
			labelUserMail.setBounds(300, 330, 100, 30);
			userInfoPanel.add(labelUserMail);
			this.userMail = new JTextField();
			this.userMail.setBounds(350, 330, 100, 30);
			userInfoPanel.add(this.userMail);
			//this.add(this.userInfoPanel, BorderLayout.WEST);
			
			
			JLabel labelUserTelephone = new JLabel("Telephone :");
			labelUserTelephone.setBounds(300, 360, 100, 30);
			userInfoPanel.add(labelUserTelephone);
			this.userPhone = new JTextField();
			this.userPhone.setBounds(370, 360, 100, 30);
			userInfoPanel.add(this.userPhone);
			//this.add(this.userInfoPanel, BorderLayout.WEST);
			
			
			JLabel labelUserPseudo = new JLabel("Pseudo :");
			labelUserPseudo.setBounds(300, 390, 100, 30);
			userInfoPanel.add(labelUserPseudo);
			this.userPseudo = new JTextField();
			this.userPseudo.setBounds(360, 390, 100, 30);
			userInfoPanel.add(this.userPseudo);
			//this.add(this.userInfoPanel, BorderLayout.WEST);
			

			JLabel labelpassword = new JLabel("Mot de passe :");
			labelpassword.setBounds(300, 420, 100, 30);
			userInfoPanel.add(labelpassword);
			this.password = new JPasswordField();
			this.password.setBounds(380, 420, 190, 30);
			this.password.setColumns(10);
			userInfoPanel.add(this.password);
			//this.add(this.userInfoPanel, BorderLayout.WEST);
			
			JLabel labelUserCptRetard = new JLabel("Compteur Retard :");
			labelUserCptRetard.setBounds(300, 450, 100, 30);
			userInfoPanel.add(labelUserCptRetard);
			this.userCptRetard = new JTextField("0");
			this.userCptRetard.setBounds(380, 450, 190, 30);
			this.userCptRetard.setColumns(2);
			userInfoPanel.add(this.userCptRetard);
			this.add(userInfoPanel, BorderLayout.WEST); 
			
			/*userIsAdminPanel = new JPanel();
			userIsAdminPanel.setPreferredSize(new Dimension(100, 20));
			
			JLabel labelUserIsAdmin = new JLabel("Admin :");
			labelUserIsAdmin.setBounds(800, 450, 100, 30);
			this.userIsAdminPanel.add(labelUserIsAdmin);			
			this.userIsAdmin = new JComboBox<Boolean>();
			this.userIsAdmin.addItem(Boolean.TRUE);
			this.userIsAdmin.addItem(Boolean.FALSE);
			this.userIsAdmin.setPreferredSize(new Dimension(100, 20));
			this.userIsAdmin.setBounds(860, 450, 100, 30);
			userIsAdminPanel.add(this.userIsAdmin);
			this.add(userIsAdminPanel, BorderLayout.CENTER);
			
			userPeutEmprunterPanel = new JPanel();
			userPeutEmprunterPanel.setPreferredSize(new Dimension(100, 20));
			
			JLabel labelUserPeutEmprunter = new JLabel("Peut Emprunter :");
			labelUserPeutEmprunter.setBounds(600, 100, 100, 30);
			this.userPeutEmprunterPanel.add(labelUserPeutEmprunter);
			this.userPeutEmprunter = new JComboBox<Boolean>();
			this.userPeutEmprunter.addItem(Boolean.TRUE);
			this.userPeutEmprunter.addItem(Boolean.FALSE);
			this.userPeutEmprunter.setPreferredSize(new Dimension(100, 20));
		    this.userPeutEmprunter.setBounds(600, 150, 100, 30);
		    userPeutEmprunterPanel.add(this.userPeutEmprunter);
			this.add(userPeutEmprunterPanel, BorderLayout.CENTER);
			
			userEstAJourPanel = new JPanel();
			userEstAJourPanel.setPreferredSize(new Dimension(20, 20));
			
			JLabel labelUserEstAJour = new JLabel("Est a jour :");
			labelUserEstAJour.setBounds(600, 200, 100, 30);
			userEstAJourPanel.add(labelUserEstAJour);
			this.userEstAJour = new JComboBox<Boolean>();
			this.userEstAJour.addItem(Boolean.TRUE);
			this.userEstAJour.addItem(Boolean.FALSE);
			this.userEstAJour.setPreferredSize(new Dimension(20, 20));
			this.userEstAJour.setBounds(600, 250, 100, 30);
			userEstAJourPanel.add(this.userEstAJour);
			this.add(userEstAJourPanel, BorderLayout.CENTER);*/
		}
		
		
		private void creerPanneauDate() {
			JPanel DatePanel = new JPanel();
			DatePanel.setPreferredSize(new Dimension(TacheDAffichage.LARGEUR, 50));
			JLabel labelUserBirthday = new JLabel("Date de naissance :");
			labelUserBirthday.setBounds(400, 150, 100, 30);
			DatePanel.add(labelUserBirthday);
			JDateChooser dateChooser = new JDateChooser();
			dateChooser.setBounds(400, 200, 200, 30);
			DatePanel.add(dateChooser);
			this.add(DatePanel, BorderLayout.EAST);
		}
		
		
		public void ajouterBoutons(){
			JPanel panelButton = new JPanel();
			this.boutonValider = new JButton("Valider");
			//this.boutonValider.setBounds(200, 500, 200, 30);
			this.boutonValider.addActionListener(this);
			panelButton.add(this.boutonValider);
			this.add(panelButton, BorderLayout.SOUTH);
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
