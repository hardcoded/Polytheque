package polytheque.view;

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

import polytheque.model.pojos.Adherent;

/**
 * Classe permettant de gerer la modification des informations liï¿½es au compte de l'utilisateur.
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
			ajouterChamps();
			ajouterBoutons();
		}
		
		public void ajouterChamps() {
			this.setLayout(null);

			JLabel titrePrincipal = new JLabel("Mon compte");
			titrePrincipal.setHorizontalAlignment(SwingConstants.CENTER);
			titrePrincipal.setBounds(350, 20, 260, 30);
			this.add(titrePrincipal);

			JLabel labelUserName = new JLabel("Nom :");
			labelUserName.setBounds(300, 150, 100, 30);
			this.add(labelUserName);
			this.userName = new JTextField();
			this.userName.setBounds(350, 150, 100, 30);
			this.add(this.userName);
			
			JLabel labelUserFirstName = new JLabel("Prenom :");
			labelUserFirstName.setBounds(300, 180, 100, 30);
			this.add(labelUserFirstName);
			this.userFirstName = new JTextField();
			this.userFirstName.setBounds(360, 180, 100, 30);
			this.add(this.userFirstName);
			
			
			JLabel labelUserBirthday = new JLabel("Date de naissance :");
			labelUserBirthday.setBounds(300, 210, 150, 30);
			this.add(labelUserBirthday);
			this.userBirthday = new JTextField();
			this.userBirthday.setBounds(420, 210, 100, 30);
			this.add(this.userBirthday);
			
			
			JLabel labelUserRue = new JLabel("Rue :");
			labelUserRue.setBounds(300, 240, 100, 30);
			this.add(labelUserRue);
			this.userRue = new JTextField();
			this.userRue.setBounds(350, 240, 100, 30);
			this.add(this.userRue);
			
			
			
			JLabel labelUserCP = new JLabel("Code Postal:");
			labelUserCP.setBounds(300, 270, 100, 30);
			this.add(labelUserCP);
			this.userCP = new JTextField();
			this.userCP.setBounds(390, 270, 100, 30);
			this.add(this.userCP);
	
			
			JLabel labelUserVille = new JLabel("Ville :");
			labelUserVille.setBounds(300, 300, 100, 30);
			this.add(labelUserVille);
			this.userVille = new JTextField();
			this.userVille.setBounds(350, 300, 100, 30);
			this.add(this.userVille);
			
			JLabel labelUserMail = new JLabel("Mail :");
			labelUserMail.setBounds(300, 330, 100, 30);
			this.add(labelUserMail);
			this.userMail = new JTextField();
			this.userMail.setBounds(350, 330, 100, 30);
			this.add(this.userMail);
			
			
			JLabel labelUserTelephone = new JLabel("Telephone :");
			labelUserTelephone.setBounds(300, 360, 100, 30);
			this.add(labelUserTelephone);
			this.userPhone = new JTextField();
			this.userPhone.setBounds(370, 360, 100, 30);
			this.add(this.userPhone);
			
			
			JLabel labelUserPseudo = new JLabel("Pseudo :");
			labelUserPseudo.setBounds(300, 390, 100, 30);
			this.add(labelUserPseudo);
			this.userPseudo = new JTextField();
			this.userPseudo.setBounds(360, 390, 100, 30);
			this.add(this.userPseudo);
			

			JLabel labelpassword = new JLabel("Mot de passe :");
			labelpassword.setBounds(300, 420, 100, 30);
			this.add(labelpassword);
			this.password = new JPasswordField();
			this.password.setBounds(380, 420, 190, 30);
			this.password.setColumns(10);
			this.add(this.password);
			
			JLabel labelUserIsAdmin = new JLabel("Admin :");
			labelUserIsAdmin.setBounds(300, 390, 100, 30);
			this.add(labelUserIsAdmin);			
			this.userIsAdmin = new JComboBox<Boolean>();
			this.userIsAdmin.addItem(Boolean.TRUE);
			this.userIsAdmin.addItem(Boolean.FALSE);
			this.userIsAdmin.setPreferredSize(new Dimension(100, 20));
			this.userIsAdmin.setBounds(360, 390, 100, 30);
			this.add(this.userIsAdmin);
			
			JLabel labelUserPeutEmprunter = new JLabel("Peut Emprunter :");
			labelUserPeutEmprunter.setBounds(600, 100, 100, 30);
			this.add(labelUserPeutEmprunter);
			this.userPeutEmprunter = new JComboBox<Boolean>();
			this.userPeutEmprunter.addItem(Boolean.TRUE);
			this.userPeutEmprunter.addItem(Boolean.FALSE);
			this.userPeutEmprunter.setPreferredSize(new Dimension(100, 20));
		    this.userPeutEmprunter.setBounds(600, 150, 100, 30);
			this.add(this.userPeutEmprunter);
			
			JLabel labelUserEstAJour = new JLabel("Est a jour :");
			labelUserEstAJour.setBounds(600, 200, 100, 30);
			this.add(labelUserEstAJour);
			this.userEstAJour = new JComboBox<Boolean>();
			this.userEstAJour.addItem(Boolean.TRUE);
			this.userEstAJour.addItem(Boolean.FALSE);
			this.userEstAJour.setPreferredSize(new Dimension(100, 20));
			this.userEstAJour.setBounds(600, 250, 100, 30);
			this.add(this.userEstAJour);
			
			JLabel labelUserCptRetard = new JLabel("Compteur Retard :");
			labelUserCptRetard.setBounds(600, 300, 150, 30);
			this.add(labelUserCptRetard);
			this.userCptRetard = new JTextField();
			this.userCptRetard.setBounds(600, 350, 100, 30);
			this.add(this.userCptRetard);
		}
		
		
		public void ajouterBoutons(){
			this.boutonValider = new JButton("Valider");
			this.boutonValider.setBounds(200, 500, 200, 30);
			this.boutonValider.addActionListener(this);
			this.add(this.boutonValider);
			
			this.boutonRetourAccueil = new JButton("Accueil");
			this.boutonRetourAccueil.setBounds(500, 500, 200, 30);
			this.boutonRetourAccueil.addActionListener(this);
			this.add(this.boutonRetourAccueil);
		}

		@Override
		public void actionPerformed(ActionEvent event) {
			JButton boutonSelectionne = (JButton) event.getSource();

			if (boutonSelectionne == this.boutonValider)
			{
				int cptRetard = Integer.parseInt(this.userCptRetard.getText());
				String password = new String(this.password.getPassword());
				Adherent adherent = new Adherent(this.userName.getText(), this.userFirstName.getText(),this.adherentCourant.getDateNaissance(), this.userRue.getText(), this.userCP.getText(), this.userVille.getText(), this.userMail.getText(), this.userPhone.getText(), this.userPseudo.getText(), password, this.userIsAdmin.getAutoscrolls(), this.userEstAJour.getAutoscrolls(),this.userPeutEmprunter.getAutoscrolls(), cptRetard);
				this.tacheDAffichageDeLApplication.afficherMessage("Un nouvel adhérent a ete cree !", "Creation terminee", JOptionPane.INFORMATION_MESSAGE);
				this.tacheDAffichageDeLApplication.creerAdherent(adherent);
				this.tacheDAffichageDeLApplication.afficherGestionAdherent();
				return;
				}

			return;
		}



}
