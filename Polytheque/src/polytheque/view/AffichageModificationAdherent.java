package polytheque.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.Dimension;

import polytheque.model.pojos.Adherent;

/**
 * Classe permettant de gerer la modification des informations li�es au compte de l'utilisateur.
 * 
 * @author Godefroi Roussel
 *
 */
@SuppressWarnings("serial")
public class AffichageModificationAdherent extends JPanel implements ActionListener {
	
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
		private JComboBox userIsAdmin;
		private JComboBox userPeutEmprunter;
		private JComboBox userEstAJour;
		
		private JButton boutonValider;
		private JButton boutonRetourAccueil;
		private JButton boutonRetourGestionAdherent;
		private Adherent adherentCourant;
		
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
		public AffichageModificationAdherent(TacheDAffichage afficheAppli, Adherent adherent){
			this.tacheDAffichageDeLApplication = afficheAppli;
			this.adherentCourant = adherent;
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
			this.userName = new JTextField(this.adherentCourant.getNom());
			this.userName.setBounds(350, 150, 100, 30);
			this.add(this.userName);
			
			JLabel labelUserFirstName = new JLabel("Prenom :");
			labelUserFirstName.setBounds(300, 180, 100, 30);
			this.add(labelUserFirstName);
			this.userFirstName = new JTextField(this.adherentCourant.getPrenom());
			this.userFirstName.setBounds(360, 180, 100, 30);
			this.add(this.userFirstName);
			
			
			JLabel labelUserBirthday = new JLabel("Date de naissance :");
			labelUserBirthday.setBounds(300, 210, 150, 30);
			this.add(labelUserBirthday);
			this.userBirthday = new JTextField(this.adherentCourant.getDateNaissance().toString());
			this.userBirthday.setBounds(420, 210, 100, 30);
			this.add(this.userBirthday);
			
			
			JLabel labelUserRue = new JLabel("Rue :");
			labelUserRue.setBounds(300, 240, 100, 30);
			this.add(labelUserRue);
			this.userRue = new JTextField(this.adherentCourant.getRue());
			this.userRue.setBounds(350, 240, 100, 30);
			this.add(this.userRue);
			
			
			
			JLabel labelUserCP = new JLabel("Code Postal:");
			labelUserCP.setBounds(300, 270, 100, 30);
			this.add(labelUserCP);
			this.userCP = new JTextField(this.adherentCourant.getCP());
			this.userCP.setBounds(390, 270, 100, 30);
			this.add(this.userCP);
	
			
			JLabel labelUserVille = new JLabel("Ville :");
			labelUserVille.setBounds(300, 300, 100, 30);
			this.add(labelUserVille);
			this.userVille = new JTextField(this.adherentCourant.getVille());
			this.userVille.setBounds(350, 300, 100, 30);
			this.add(this.userVille);
			
			JLabel labelUserMail = new JLabel("Mail :");
			labelUserMail.setBounds(300, 330, 100, 30);
			this.add(labelUserMail);
			this.userMail = new JTextField(this.adherentCourant.getMail());
			this.userMail.setBounds(350, 330, 100, 30);
			this.add(this.userMail);
			
			
			JLabel labelUserTelephone = new JLabel("Telephone :");
			labelUserTelephone.setBounds(300, 360, 100, 30);
			this.add(labelUserTelephone);
			this.userPhone = new JTextField(this.adherentCourant.getTelephone());
			this.userPhone.setBounds(370, 360, 100, 30);
			this.add(this.userPhone);
			
			
			JLabel labelUserPseudo = new JLabel("Pseudo :");
			labelUserPseudo.setBounds(300, 390, 100, 30);
			this.add(labelUserPseudo);
			this.userPseudo = new JTextField(this.adherentCourant.getPseudo());
			this.userPseudo.setBounds(360, 390, 100, 30);
			this.add(this.userPseudo);
			

			JLabel labelpassword = new JLabel("Mot de passe :");
			labelpassword.setBounds(300, 420, 100, 30);
			this.add(labelpassword);
			this.password = new JPasswordField(this.adherentCourant.getMdp());
			this.password.setBounds(380, 420, 190, 30);
			this.password.setColumns(10);
			this.add(this.password);
			
			JLabel labelUserIsAdmin = new JLabel("Admin :");
			labelUserIsAdmin.setBounds(300, 390, 100, 30);
			this.add(labelUserIsAdmin);
			JComboBox userIsAdmin = new JComboBox();
		    this.userIsAdmin.setPreferredSize(new Dimension(100, 20));
		    this.userIsAdmin.addItem("True");
		    this.userIsAdmin.addItem("False");
			this.userIsAdmin.setBounds(360, 390, 100, 30);
			this.add(this.userIsAdmin);
			
			JLabel labelUserPeutEmprunter = new JLabel("Peut Emprunter :");
			labelUserPeutEmprunter.setBounds(300, 390, 100, 30);
			this.add(labelUserPeutEmprunter);
			JComboBox userPeutEmprunter = new JComboBox();
		    this.userPeutEmprunter.setPreferredSize(new Dimension(100, 20));
		    this.userPeutEmprunter.addItem("True");
		    this.userPeutEmprunter.addItem("False");
			this.userPeutEmprunter.setBounds(360, 390, 100, 30);
			this.add(this.userPeutEmprunter);
			
			JLabel labelUserEstAJour = new JLabel("Est a jour :");
			labelUserEstAJour.setBounds(300, 390, 100, 30);
			this.add(labelUserEstAJour);
			JComboBox userEstAJour = new JComboBox();
		    this.userEstAJour.setPreferredSize(new Dimension(100, 20));
		    this.userEstAJour.addItem("True");
		    this.userEstAJour.addItem("False");
			this.userEstAJour.setBounds(360, 390, 100, 30);
			this.add(this.userEstAJour);
			
			JLabel labelUserCptRetard = new JLabel("Compteur Retard :");
			labelUserCptRetard.setBounds(300, 390, 100, 30);
			this.add(labelUserCptRetard);
			this.userCptRetard = new JTextField(this.adherentCourant.getCompteurRetard());
			this.userCptRetard.setBounds(360, 390, 100, 30);
			this.add(this.userCptRetard);
		}
		
		public void ajouterBoutons(){
			this.boutonValider = new JButton("Valider");
			this.boutonValider.setBounds(200, 500, 150, 30);
			this.boutonValider.addActionListener(this);
			this.add(this.boutonValider);
			
			this.boutonRetourAccueil = new JButton("Accueil");
			this.boutonRetourAccueil.setBounds(500, 500, 150, 30);
			this.boutonRetourAccueil.addActionListener(this);
			this.add(this.boutonRetourAccueil);
			
			this.boutonRetourGestionAdherent = new JButton("Gestion Adherent");
			this.boutonRetourGestionAdherent.setBounds(800, 500, 150, 30);
			this.boutonRetourGestionAdherent.addActionListener(this);
			this.add(this.boutonRetourGestionAdherent);
		}

		@Override
		public void actionPerformed(ActionEvent event) {
			JButton boutonSelectionne = (JButton) event.getSource();

			if (boutonSelectionne == this.boutonValider)
			{
				String password = new String(this.password.getPassword());
				Adherent adherent = new Adherent(this.adherentCourant.getIdAdherent(), this.userName.getText(), this.userFirstName.getText(),this.adherentCourant.getDateNaissance(), this.userRue.getText(), this.userCP.getText(), this.userVille.getText(), this.userMail.getText(), this.userPhone.getText(), this.userPseudo.getText(), password, this.adherentCourant.isAdmin(), this.adherentCourant.estAJour(),this.adherentCourant.peutEmprunter(), this.adherentCourant.getCompteurRetard());
				this.tacheDAffichageDeLApplication.afficherMessage("Vos modifications ont bien ete prises en compte");
				this.tacheDAffichageDeLApplication.modifAdherent(adherent);
				return;
				}
			
			if (boutonSelectionne == this.boutonRetourAccueil)
			{
				this.tacheDAffichageDeLApplication.afficherAccueil();
				return;
			}
			return;
		}



}
