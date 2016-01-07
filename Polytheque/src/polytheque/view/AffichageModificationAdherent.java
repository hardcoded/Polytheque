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
	public AffichageModificationAdherent(TacheDAffichage afficheAppli, Adherent adherent) {
		this.tacheDAffichageDeLApplication = afficheAppli;
		this.adherentCourant = adherent;
		this.setLayout(new BorderLayout());
		ajouterChamps();
		ajouterBoutons();
	}

	public void ajouterChamps() {
		JPanel champsPanel = new JPanel(); 
		
		JLabel titrePrincipal = new JLabel("Mon compte");
		champsPanel.add(titrePrincipal, BorderLayout.CENTER);

		JLabel labelUserName = new JLabel("Nom :");
		champsPanel.add(labelUserName, BorderLayout.WEST);
		this.userName = new JTextField(this.adherentCourant.getNom());
		champsPanel.add(this.userName, BorderLayout.WEST);

		JLabel labelUserFirstName = new JLabel("Prenom :");
		champsPanel.add(labelUserFirstName, BorderLayout.WEST);
		this.userFirstName = new JTextField(this.adherentCourant.getPrenom());
		champsPanel.add(this.userFirstName, BorderLayout.WEST);


		JLabel labelUserBirthday = new JLabel("Date de naissance :");
		champsPanel.add(labelUserBirthday, BorderLayout.WEST);
		this.userBirthday = new JTextField(this.adherentCourant.getDateNaissance().toString());
		champsPanel.add(this.userBirthday, BorderLayout.WEST);


		JLabel labelUserRue = new JLabel("Rue :");
		champsPanel.add(labelUserRue, BorderLayout.WEST);
		this.userRue = new JTextField(this.adherentCourant.getRue());
		champsPanel.add(this.userRue, BorderLayout.WEST);



		JLabel labelUserCP = new JLabel("Code Postal:");
		champsPanel.add(labelUserCP);
		this.userCP = new JTextField(this.adherentCourant.getCP());
		champsPanel.add(this.userCP, BorderLayout.WEST);


		JLabel labelUserVille = new JLabel("Ville :");
		champsPanel.add(labelUserVille, BorderLayout.WEST);
		this.userVille = new JTextField(this.adherentCourant.getVille());
		champsPanel.add(this.userVille, BorderLayout.WEST);

		JLabel labelUserMail = new JLabel("Mail :");
		champsPanel.add(labelUserMail, BorderLayout.WEST);
		this.userMail = new JTextField(this.adherentCourant.getMail());
		champsPanel.add(this.userMail, BorderLayout.WEST);


		JLabel labelUserTelephone = new JLabel("Telephone :");
		champsPanel.add(labelUserTelephone, BorderLayout.WEST);
		this.userPhone = new JTextField(this.adherentCourant.getTelephone());
		champsPanel.add(this.userPhone, BorderLayout.WEST);


		JLabel labelUserPseudo = new JLabel("Pseudo :");
		champsPanel.add(labelUserPseudo, BorderLayout.EAST);
		this.userPseudo = new JTextField(this.adherentCourant.getPseudo());
		champsPanel.add(this.userPseudo, BorderLayout.EAST);


		JLabel labelpassword = new JLabel("Mot de passe :");
		champsPanel.add(labelpassword, BorderLayout.EAST);
		this.password = new JPasswordField(this.adherentCourant.getMdp());
		this.password.setColumns(10);
		champsPanel.add(this.password, BorderLayout.EAST);

		JLabel labelUserIsAdmin = new JLabel("Admin :");
		champsPanel.add(labelUserIsAdmin, BorderLayout.EAST);			
		JComboBox<Boolean>userIsAdmin = new JComboBox<Boolean>();
		userIsAdmin.addItem(Boolean.TRUE);
		userIsAdmin.addItem(Boolean.FALSE);
		userIsAdmin.setPreferredSize(new Dimension(100, 20));
		champsPanel.add(userIsAdmin, BorderLayout.EAST);

		JLabel labelUserPeutEmprunter = new JLabel("Peut Emprunter :");
		champsPanel.add(labelUserPeutEmprunter, BorderLayout.EAST);
		JComboBox<Boolean> userPeutEmprunter = new JComboBox<Boolean>();
		userPeutEmprunter.addItem(Boolean.TRUE);
		userPeutEmprunter.addItem(Boolean.FALSE);
		userPeutEmprunter.setPreferredSize(new Dimension(100, 20));
		champsPanel.add(userPeutEmprunter, BorderLayout.EAST);

		JLabel labelUserEstAJour = new JLabel("Est a jour :");
		champsPanel.add(labelUserEstAJour, BorderLayout.EAST);
		JComboBox<Boolean> userEstAJour = new JComboBox<Boolean>();
		userEstAJour.addItem(Boolean.TRUE);
		userEstAJour.addItem(Boolean.FALSE);
		userEstAJour.setPreferredSize(new Dimension(100, 20));
		champsPanel.add(userEstAJour, BorderLayout.EAST);

		JLabel labelUserCptRetard = new JLabel("Compteur Retard :");
		champsPanel.add(labelUserCptRetard, BorderLayout.EAST);
		this.userCptRetard = new JTextField(this.adherentCourant.getCompteurRetard());
		champsPanel.add(this.userCptRetard);
		this.add(champsPanel, BorderLayout.EAST);
	}

	public void ajouterBoutons(){
		JPanel boutonPanel = new JPanel();
		
		this.boutonValider = new JButton("Valider");
		this.boutonValider.addActionListener(this);
		boutonPanel.add(this.boutonValider, BorderLayout.CENTER);
		
		this.add(boutonPanel, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		JButton boutonSelectionne = (JButton) event.getSource();

		if (boutonSelectionne == this.boutonValider)
		{
			String password = new String(this.password.getPassword());
			Adherent adherent = new Adherent(this.adherentCourant.getIdAdherent(), this.userName.getText(), this.userFirstName.getText(),this.adherentCourant.getDateNaissance(), this.userRue.getText(), this.userCP.getText(), this.userVille.getText(), this.userMail.getText(), this.userPhone.getText(), this.userPseudo.getText(), password, this.adherentCourant.isAdmin(), this.adherentCourant.estAJour(),this.adherentCourant.peutEmprunter(), this.adherentCourant.getCompteurRetard());
			this.tacheDAffichageDeLApplication.afficherMessage("Vos modifications ont bien ete prises en compte !", "Modifications terminées", JOptionPane.INFORMATION_MESSAGE);
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
