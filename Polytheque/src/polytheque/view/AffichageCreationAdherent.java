package polytheque.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

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
		private JTextField userPseudo;
		private JTextField userRue;
		private JTextField userCP;
		private JTextField userVille;
		private JTextField userPhone;
		private JTextField userMail;
		private JTextField userCptRetard;
		private JDateChooser dateChooser;
		
		private JPasswordField password;
		
		private JButton boutonValider;
		
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
			this.setLayout(null);
			
			ajouterChamps();
			creerPanneauDate();
			ajouterBoutons();
		}
		
		public void ajouterChamps() {		
			/*JPanel grosPanel = new JPanel();
			grosPanel.setLayout(new BorderLayout());
			JPanel titrePanel = new JPanel();*/
			
			JLabel titrePrincipal = new JLabel("Cr�ation Adh�rent");
			titrePrincipal.setHorizontalAlignment(SwingConstants.CENTER);
			titrePrincipal.setBounds(480, 20, 260, 30);
			//titrePanel.add(titrePrincipal);
			//this.add(titrePanel, BorderLayout.NORTH);
			this.add(titrePrincipal);
			//grosPanel.add(titrePanel, BorderLayout.NORTH);
			
			//JPanel userInfoPanel = new JPanel();
			
			JLabel labelUserName = new JLabel("Nom :");
			labelUserName.setBounds(150, 150, 100, 30);
			//userInfoPanel.add(labelUserName);
			this.add(labelUserName);
			this.userName = new JTextField();
			this.userName.setBounds(200, 150, 100, 30);
			//userInfoPanel.add(this.userName);
			//this.add(userInfoPanel,BorderLayout.WEST);
			this.add(userName);
						
			JLabel labelUserFirstName = new JLabel("Prenom :");
			labelUserFirstName.setBounds(150, 200, 100, 30);
			//userInfoPanel.add(labelUserFirstName);
			this.add(labelUserFirstName);
			this.userFirstName = new JTextField();
			this.userFirstName.setBounds(210, 200, 100, 30);
			//userInfoPanel.add(this.userFirstName);
			//this.add(userInfoPanel,BorderLayout.WEST); 
			//grosPanel.add(userInfoPanel, BorderLayout.WEST);
			this.add(userFirstName);
			
			JLabel labelUserRue = new JLabel("Rue :");
			labelUserRue.setBounds(150, 240, 100, 30);
			this.add(labelUserRue);
			this.userRue = new JTextField();
			this.userRue.setBounds(200, 240, 130, 30);
			this.add(this.userRue);
			//this.add(this.userInfoPanel, BorderLayout.WEST);
			
			JLabel labelUserCP = new JLabel("Code Postal:");
			labelUserCP.setBounds(150, 270, 100, 30);
			this.add(labelUserCP);
			this.userCP = new JTextField();
			this.userCP.setBounds(240, 270, 100, 30);
			this.add(this.userCP);
			//this.add(this.userInfoPanel, BorderLayout.WEST);
	
			
			JLabel labelUserVille = new JLabel("Ville :");
			labelUserVille.setBounds(150, 300, 100, 30);
			this.add(labelUserVille);
			this.userVille = new JTextField();
			this.userVille.setBounds(200, 300, 100, 30);
			this.add(this.userVille);
			//this.add(this.userInfoPanel, BorderLayout.WEST);
			
			JLabel labelUserMail = new JLabel("Mail :");
			labelUserMail.setBounds(150, 330, 100, 30);
			this.add(labelUserMail);
			this.userMail = new JTextField();
			this.userMail.setBounds(200, 330, 100, 30);
			this.add(this.userMail);
			//this.add(this.userInfoPanel, BorderLayout.WEST);
			
			
			JLabel labelUserTelephone = new JLabel("Telephone :");
			labelUserTelephone.setBounds(150, 360, 100, 30);
			this.add(labelUserTelephone);
			this.userPhone = new JTextField();
			this.userPhone.setBounds(220, 360, 100, 30);
			this.add(this.userPhone);
			//this.add(this.userInfoPanel, BorderLayout.WEST);
			
			
			JLabel labelUserPseudo = new JLabel("Pseudo :");
			labelUserPseudo.setBounds(150, 390, 100, 30);
			this.add(labelUserPseudo);
			this.userPseudo = new JTextField();
			this.userPseudo.setBounds(210, 390, 100, 30);
			this.add(this.userPseudo);
			//this.add(this.userInfoPanel, BorderLayout.WEST);
			

			JLabel labelpassword = new JLabel("Mot de passe :");
			labelpassword.setBounds(150, 420, 100, 30);
			this.add(labelpassword);
			this.password = new JPasswordField();
			this.password.setBounds(230, 420, 190, 30);
			this.password.setColumns(10);
			this.add(this.password);
			//this.add(this.userInfoPanel, BorderLayout.WEST);
			
			JLabel labelUserCptRetard = new JLabel("Compteur Retard :");
			labelUserCptRetard.setBounds(150, 450, 150, 30);
			this.add(labelUserCptRetard);
			this.userCptRetard = new JTextField("0");
			this.userCptRetard.setBounds(270, 450, 20, 30);
			this.userCptRetard.setColumns(2);
			this.add(this.userCptRetard);
			//this.add(userInfoPanel, BorderLayout.CENTER);  
			
			//userIsAdminPanel = new JPanel();
			//userIsAdminPanel.setPreferredSize(new Dimension(100, 20));
			
			JLabel labelUserIsAdmin = new JLabel("Admin :");
			labelUserIsAdmin.setBounds(600, 300, 100, 30);
			this.add(labelUserIsAdmin);
			//this.userIsAdminPanel.add(labelUserIsAdmin);			
			this.userIsAdmin = new JComboBox<Boolean>();
			this.userIsAdmin.addItem(Boolean.TRUE);
			this.userIsAdmin.addItem(Boolean.FALSE);
			this.userIsAdmin.setPreferredSize(new Dimension(100, 20));
			this.userIsAdmin.setBounds(600, 350, 100, 30);
			this.add(userIsAdmin);
			//userIsAdminPanel.add(this.userIsAdmin);
			//this.add(userIsAdminPanel, BorderLayout.CENTER);
			//grosPanel.add(userIsAdminPanel, BorderLayout.CENTER);
			
			//userPeutEmprunterPanel = new JPanel();
			//userPeutEmprunterPanel.setPreferredSize(new Dimension(100, 20));
			
			JLabel labelUserPeutEmprunter = new JLabel("Peut Emprunter :");
			labelUserPeutEmprunter.setBounds(600, 100, 100, 30);
			this.add(labelUserPeutEmprunter);
			//this.userPeutEmprunterPanel.add(labelUserPeutEmprunter);
			this.userPeutEmprunter = new JComboBox<Boolean>();
			this.userPeutEmprunter.addItem(Boolean.TRUE);
			this.userPeutEmprunter.addItem(Boolean.FALSE);
			this.userPeutEmprunter.setPreferredSize(new Dimension(100, 20));
		    this.userPeutEmprunter.setBounds(600, 150, 100, 30);
		   // userPeutEmprunterPanel.add(this.userPeutEmprunter);
		    this.add(userPeutEmprunter);
			//this.add(userPeutEmprunterPanel, BorderLayout.CENTER);
		  //  grosPanel.add(userPeutEmprunterPanel, BorderLayout.CENTER);
			
			//userEstAJourPanel = new JPanel();
			//userEstAJourPanel.setPreferredSize(new Dimension(20, 20));
			
			JLabel labelUserEstAJour = new JLabel("Est a jour :");
			labelUserEstAJour.setBounds(600, 200, 100, 30);
			this.add(labelUserEstAJour);
			//userEstAJourPanel.add(labelUserEstAJour);
			this.userEstAJour = new JComboBox<Boolean>();
			this.userEstAJour.addItem(Boolean.TRUE);
			this.userEstAJour.addItem(Boolean.FALSE);
			this.userEstAJour.setPreferredSize(new Dimension(20, 20));
			this.userEstAJour.setBounds(600, 250, 100, 30);
			this.add(this.userEstAJour);
		}
		
		
		private void creerPanneauDate() {
			//JPanel DatePanel = new JPanel();
			//DatePanel.setPreferredSize(new Dimension(TacheDAffichage.LARGEUR, 50));
			JLabel labelUserBirthday = new JLabel("Date de naissance :");
			labelUserBirthday.setBounds(850, 150, 150, 30);
			this.add(labelUserBirthday);
			this.dateChooser = new JDateChooser();
			this.dateChooser.setBounds(850, 200, 150, 30);
			this.add(this.dateChooser);
			//this.add(DatePanel, BorderLayout.EAST);
		}
		
		
		public void ajouterBoutons(){
			//JPanel panelButton = new JPanel();
			this.boutonValider = new JButton("Valider");
			this.boutonValider.setBounds(480, 500, 200, 30);
			this.boutonValider.addActionListener(this);
			this.add(this.boutonValider);
			//this.add(panelButton, BorderLayout.SOUTH);
		}

		@Override
		public void actionPerformed(ActionEvent event) {
			JButton boutonSelectionne = (JButton) event.getSource();

			if (boutonSelectionne == this.boutonValider)
			{
				int cptRetard = Integer.parseInt(this.userCptRetard.getText());
				String password = new String(this.password.getPassword());
				//TODO faire un DatePicker pour la date de naissance car besoin d'un format date pour insérer nouvel adhérent
				Adherent adherent = new Adherent(this.userName.getText(), this.userFirstName.getText(), (Date) this.dateChooser.getDate(), this.userRue.getText(), this.userCP.getText(), this.userVille.getText(), this.userMail.getText(), this.userPhone.getText(), this.userPseudo.getText(), password, this.userIsAdmin.getAutoscrolls(), this.userEstAJour.getAutoscrolls(),this.userPeutEmprunter.getAutoscrolls(), cptRetard);
				this.tacheDAffichageDeLApplication.afficherMessage("Un nouvel adhérent a ete crée !", "Création terminée", JOptionPane.INFORMATION_MESSAGE);
				this.tacheDAffichageDeLApplication.creerAdherent(adherent);
				this.tacheDAffichageDeLApplication.afficherGestionAdherent();
				return;
				}

			return;
		}



}
