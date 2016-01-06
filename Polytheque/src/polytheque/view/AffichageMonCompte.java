package polytheque.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import polytheque.model.pojos.Adherent;
import java.sql.Date;

/**
 * Classe permettant de gerer la modification des informations li�es au compte de l'utilisateur.
 * 
 * @author Godefroi Roussel
 *
 */
@SuppressWarnings("serial")
public class AffichageMonCompte extends JPanel implements ActionListener {
	
		private JLabel userName;
		private JLabel userFirstName;
		private JLabel userBirthday;
		private JLabel userPseudo;
		private JTextField userRue;
		private JTextField userCP;
		private JTextField userVille;
		private JTextField userPhone;
		private JTextField userMail;
		private JPasswordField password;	
		private JButton boutonValider;
		private JButton boutonRetourAccueil;
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
		public AffichageMonCompte(TacheDAffichage afficheAppli, Adherent adherent){
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
			this.userName = new JLabel(this.adherentCourant.getNom());
			this.userName.setBounds(350, 150, 100, 30);
			this.add(this.userName);
			//this.adherentDAO.retreive(this.adherentCourant.getNom())
			
			JLabel labelUserFirstName = new JLabel("Prenom :");
			labelUserFirstName.setBounds(300, 180, 100, 30);
			this.add(labelUserFirstName);
			this.userFirstName = new JLabel(this.adherentCourant.getPrenom());
			this.userFirstName.setBounds(360, 180, 100, 30);
			this.add(this.userFirstName);
			//this.adherentDAO.retreive(this.adherentCourant.getPrenom())
			
			
			JLabel labelUserBirthday = new JLabel("Date de naissance :");
			labelUserBirthday.setBounds(300, 210, 150, 30);
			this.add(labelUserBirthday);
			this.userBirthday = new JLabel("TEST");
			this.userBirthday.setBounds(420, 210, 100, 30);
			this.add(this.userBirthday);
			//this.adherentDAO.retreive(this.adherentCourant.getDateNaissance())
			
			
			JLabel labelUserRue = new JLabel("Rue :");
			labelUserRue.setBounds(300, 240, 100, 30);
			this.add(labelUserRue);
			this.userRue = new JTextField("TEST");
			this.userRue.setBounds(350, 240, 100, 30);
			this.add(this.userRue);
			//this.adherentDAO.retreive(this.adherentCourant.getRue())
			
			
			
			JLabel labelUserCP = new JLabel("Code Postal:");
			labelUserCP.setBounds(300, 270, 100, 30);
			this.add(labelUserCP);
			this.userCP = new JTextField("TEST");
			this.userCP.setBounds(390, 270, 100, 30);
			this.add(this.userCP);
			//this.adherentDAO.retreive(this.adherentCourant.getCP())
			
			JLabel labelUserVille = new JLabel("Ville :");
			labelUserVille.setBounds(300, 300, 100, 30);
			this.add(labelUserVille);
			this.userVille = new JTextField("TEST");
			this.userVille.setBounds(350, 300, 100, 30);
			this.add(this.userVille);
			//this.adherentDAO.retreive(this.adherentCourant.getVille())
			
			JLabel labelUserMail = new JLabel("Mail :");
			labelUserMail.setBounds(300, 330, 100, 30);
			this.add(labelUserMail);
			this.userMail = new JTextField("TEST");
			this.userMail.setBounds(350, 330, 100, 30);
			this.add(this.userMail);
			//this.adherentDAO.retreive(this.adherentCourant.getMail())
			
			
			JLabel labelUserTelephone = new JLabel("Telephone :");
			labelUserTelephone.setBounds(300, 360, 100, 30);
			this.add(labelUserTelephone);
			this.userPhone = new JTextField("TEST");
			this.userPhone.setBounds(370, 360, 100, 30);
			this.add(this.userPhone);
			//this.adherentDAO.retreive(this.adherentCourant.getTelephone())
			
			
			JLabel labelUserPseudo = new JLabel("Pseudo :");
			labelUserPseudo.setBounds(300, 390, 100, 30);
			this.add(labelUserPseudo);
			this.userPseudo = new JLabel("TEST");
			this.userPseudo.setBounds(360, 390, 100, 30);
			this.add(this.userPseudo);
			//this.adherentDAO.retreive(this.adherentCourant.getPseudo())
			

			JLabel labelpassword = new JLabel("Mot de passe :");
			labelpassword.setBounds(300, 420, 100, 30);
			this.add(labelpassword);
			this.password = new JPasswordField("TEST");
			this.password.setBounds(380, 420, 190, 30);
			this.password.setColumns(10);
			this.add(this.password);
			//this.adherentDAO.retreive(this.adherentCourant.getMdp())
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
				String password = new String(this.password.getPassword());
				Adherent adherent = new Adherent(this.adherentCourant.getIdAdherent(), this.userName.getText(), this.userFirstName.getText(),this.adherentCourant.getDateNaissance(), this.userRue.getText(), this.userCP.getText(), this.userVille.getText(), this.userMail.getText(), this.userPhone.getText(), this.userPseudo.getText(), password, this.adherentCourant.isAdmin(), this.adherentCourant.estAJour(),this.adherentCourant.peutEmprunter(), this.adherentCourant.getCompteurRetard());
				this.tacheDAffichageDeLApplication.modifAdherent(adherent);
				this.tacheDAffichageDeLApplication.afficherMessage("Vos modifications ont bien ete prises en compte");
				this.tacheDAffichageDeLApplication.afficherMonCompte();
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
