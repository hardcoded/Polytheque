package polytheque.view;

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
import com.toedter.calendar.JDateChooser;
import polytheque.model.pojos.Adherent;
/**
 * Classe permettant de gerer la modification des informations liï¿½es au compte de l'utilisateur.
 * 
 * @author Godefroi Roussel, Johan Brunet
 *
 */
@SuppressWarnings("serial")
public class AffichageModificationAdherent extends JPanel implements ActionListener {
	private JTextField userName;
	private JTextField userFirstName;
	private JTextField userPseudo;
	private JTextField userRue;
	private JTextField userCP;
	private JTextField userVille;
	private JTextField userPhone;
	private JTextField userMail;
	private JTextField userCptRetard;
	private JTextField userCptNonRecup;
	private JPasswordField password;
	private JDateChooser dateChooser;
	private JButton boutonValider;
	private Adherent adherentCourant;
	
	private JComboBox<Boolean> userEstAJour ;
	private JComboBox<Boolean> userPeutEmprunter;
	private JComboBox<Boolean> userIsAdmin;
	
	/**
	 * Une tache d'affichage de l'application.
	 */
	private TacheDAffichage tacheDAffichageDeLApplication;
	
	/**
	 * Creation de la page permettant de modifier les informations d'un adhérent en particulier.
	 * 
	 * @param tacheDAffichageDeLApplication
	 *            Une tache d'affichage de l'application.
	 * @return 
	 */
	public AffichageModificationAdherent(TacheDAffichage afficheAppli, Adherent adherent) {
		this.tacheDAffichageDeLApplication = afficheAppli;
		this.adherentCourant = adherent;
		this.setLayout(null);
		ajouterChamps();
		ajouterBoutons();
		creerPanneauDate();
	}
	
	/**
	 * Ajoute et place tous les champs sur la page. C'est-à-dire les zones de textes écrivables (avec directement les informations de l'utilisateur), 
	 * les zones de textes seulement lisible ainsi que les boutons déroulants.
	 */
	public void ajouterChamps() {
		
		JLabel titrePrincipal = new JLabel("Modification de l'adhérent");
		titrePrincipal.setBounds(480, 20, 260, 30);
		this.add(titrePrincipal);
		JLabel labelUserName = new JLabel("Nom :");
		labelUserName.setBounds(150, 150, 100, 30);
		this.add(labelUserName);
		this.userName = new JTextField(this.adherentCourant.getNom());
		this.userName.setBounds(200, 150, 100, 30);
		this.add(userName);
		JLabel labelUserFirstName = new JLabel("Prenom :");
		labelUserFirstName.setBounds(150, 200, 100, 30);
		this.add(labelUserFirstName);
		this.userFirstName = new JTextField(this.adherentCourant.getPrenom());
		this.userFirstName.setBounds(210, 200, 100, 30);
		this.add(userFirstName);
		JLabel labelUserRue = new JLabel("Rue :");
		labelUserRue.setBounds(150, 240, 100, 30);
		this.add(labelUserRue);
		this.userRue = new JTextField(this.adherentCourant.getRue());
		this.userRue.setBounds(200, 240, 130, 30);
		this.add(this.userRue);
		JLabel labelUserCP = new JLabel("Code Postal:");
		labelUserCP.setBounds(150, 270, 100, 30);
		this.add(labelUserCP);
		this.userCP = new JTextField(this.adherentCourant.getCP());
		this.userCP.setBounds(240, 270, 100, 30);
		this.add(this.userCP);
		JLabel labelUserVille = new JLabel("Ville :");
		labelUserVille.setBounds(150, 300, 100, 30);
		this.add(labelUserVille);
		this.userVille = new JTextField(this.adherentCourant.getVille());
		this.userVille.setBounds(200, 300, 100, 30);
		this.add(this.userVille);
		JLabel labelUserMail = new JLabel("Mail :");
		labelUserMail.setBounds(150, 330, 100, 30);
		this.add(labelUserMail);
		this.userMail = new JTextField(this.adherentCourant.getMail());
		this.userMail.setBounds(200, 330, 100, 30);
		this.add(this.userMail);
		JLabel labelUserTelephone = new JLabel("Telephone :");
		labelUserTelephone.setBounds(150, 360, 100, 30);
		this.add(labelUserTelephone);
		this.userPhone = new JTextField(this.adherentCourant.getTelephone());
		this.userPhone.setBounds(220, 360, 100, 30);
		this.add(this.userPhone);
		JLabel labelUserPseudo = new JLabel("Pseudo :");
		labelUserPseudo.setBounds(150, 390, 100, 30);
		this.add(labelUserPseudo);
		this.userPseudo = new JTextField(this.adherentCourant.getPseudo());
		this.userPseudo.setBounds(210, 390, 100, 30);
		this.add(this.userPseudo);
		JLabel labelpassword = new JLabel("Mot de passe :");
		labelpassword.setBounds(150, 420, 100, 30);
		this.add(labelpassword);
		this.password = new JPasswordField(this.adherentCourant.getMdp());
		this.password.setBounds(230, 420, 190, 30);
		this.password.setColumns(10);
		this.add(this.password);
		
		String compteur =  Integer.toString(this.adherentCourant.getCompteurRetard());
		JLabel labelUserCptRetard = new JLabel("Compteur Retard :");
		labelUserCptRetard.setBounds(150, 450, 150, 30);
		this.add(labelUserCptRetard);
		this.userCptRetard = new JTextField(compteur);
		this.userCptRetard.setBounds(270, 450, 20, 30);
		this.userCptRetard.setColumns(2);
		this.add(this.userCptRetard);
		
		String pasRecup =  Integer.toString(this.adherentCourant.getNbNonRecup());
		JLabel labelUserPasRecup = new JLabel("Compteur non récupéré :");
		labelUserPasRecup.setBounds(150, 500, 150, 30);
		this.add(labelUserPasRecup);
		this.userCptNonRecup = new JTextField(pasRecup);
		this.userCptNonRecup.setBounds(300, 500, 20, 30);
		this.userCptNonRecup.setColumns(2);
		this.add(this.userCptNonRecup);
		
		JLabel labelUserIsAdmin = new JLabel("Admin :");
		labelUserIsAdmin.setBounds(600, 300, 100, 30);
		this.add(labelUserIsAdmin);
		this.userIsAdmin = new JComboBox<Boolean>();
		if (this.adherentCourant.isAdmin() == true){
			this.userIsAdmin.addItem(Boolean.TRUE);
			this.userIsAdmin.addItem(Boolean.FALSE);
		}
		else
		{
			this.userIsAdmin.addItem(Boolean.FALSE);
			this.userIsAdmin.addItem(Boolean.TRUE);
		}
		this.userIsAdmin.setPreferredSize(new Dimension(100, 20));
		this.userIsAdmin.setBounds(600, 350, 100, 30);
		this.add(this.userIsAdmin);
		JLabel labelUserPeutEmprunter = new JLabel("Peut Emprunter :");
		labelUserPeutEmprunter.setBounds(600, 100, 100, 30);
		this.add(labelUserPeutEmprunter);
		this.userPeutEmprunter = new JComboBox<Boolean>();
		if (this.adherentCourant.peutEmprunter() == true){
			this.userPeutEmprunter.addItem(Boolean.TRUE);
			this.userPeutEmprunter.addItem(Boolean.FALSE);
		}
		else
		{
			this.userPeutEmprunter.addItem(Boolean.FALSE);
			this.userPeutEmprunter.addItem(Boolean.TRUE);
		}
		this.userPeutEmprunter.setPreferredSize(new Dimension(100, 20));
		this.userPeutEmprunter.setBounds(600, 150, 100, 30);
		this.add(this.userPeutEmprunter);
		JLabel labelUserEstAJour = new JLabel("Est a jour :");
		labelUserEstAJour.setBounds(600, 200, 100, 30);
		this.add(labelUserEstAJour);
		this.userEstAJour = new JComboBox<Boolean>();
		if (this.adherentCourant.estAJour() == true){
			this.userEstAJour.addItem(Boolean.TRUE);
			this.userEstAJour.addItem(Boolean.FALSE);
		}
		else
		{
			this.userEstAJour.addItem(Boolean.FALSE);
			this.userEstAJour.addItem(Boolean.TRUE);
		}
		this.userEstAJour.setPreferredSize(new Dimension(100, 20));
		this.userEstAJour.setBounds(600, 250, 100, 30);
		this.add(this.userEstAJour);
	}
	
	/**
	 * Ajoute le bouton pour valider les informations et le place sur la page.
	 */
	public void ajouterBoutons(){
		this.boutonValider = new JButton("Valider");
		this.boutonValider.setBounds(480, 500, 200, 30);
		this.boutonValider.addActionListener(this);
		this.add(this.boutonValider);
	}
	
	/**
	 * Créer le bouton permettant de choisir la date de naissance de l'utilisateur.
	 */
	private void creerPanneauDate() {
		JLabel labelUserBirthday = new JLabel("Date de naissance :");
		labelUserBirthday.setBounds(850, 150, 150, 30);
		this.add(labelUserBirthday);
		this.dateChooser = new JDateChooser(this.adherentCourant.getDateNaissance());
		this.dateChooser.setBounds(850, 200, 150, 30);
		this.add(this.dateChooser);
	}

	@Override
	/**
	 * Permet de rendre les boutons fonctionnels et affiche des messages en fonction de si il y a des erreurs ou si tout s'est déroulé comme prévu. 
	 */
	public void actionPerformed(ActionEvent event) {
		JButton boutonSelectionne = (JButton) event.getSource();
		if (boutonSelectionne == this.boutonValider)
		{
			if (this.userName.getText() != null && this.userFirstName.getText() != null && this.dateChooser.getDate() != null && this.userRue.getText() != null &&
				this.userCP.getText() != null && this.userVille.getText() != null && this.userPseudo.getText() != null && this.password.getPassword() != null &&
				this.userCptRetard.getText() != null && this.userCptNonRecup.getText() != null) {
					int cptRetard = Integer.parseInt(this.userCptRetard.getText());
					String password = new String(this.password.getPassword());
					Date dateNaissance = new Date(this.dateChooser.getDate().getTime());
					boolean admin = (boolean) this.userIsAdmin.getSelectedItem();
					boolean peutEmprunter = (boolean) this.userPeutEmprunter.getSelectedItem();
					boolean AJour = (boolean) this.userEstAJour.getSelectedItem();
					Adherent adherent = new Adherent(this.adherentCourant.getIdAdherent(), this.userName.getText(), this.userFirstName.getText(), dateNaissance, this.userRue.getText(), this.userCP.getText(), this.userVille.getText(), this.userMail.getText(), this.userPhone.getText(), this.userPseudo.getText(), password,(boolean) admin, AJour, peutEmprunter, cptRetard, 0);
					if (this.tacheDAffichageDeLApplication.modifAdherent(adherent) == false) {
						this.tacheDAffichageDeLApplication.afficherMessage("Erreur lors de la modification de l'adhérent", "Erreur de modification", JOptionPane.ERROR_MESSAGE);
					}
					else {
						this.tacheDAffichageDeLApplication.afficherMessage("Vos modifications ont bien été prises en compte !", "Modifications terminées", JOptionPane.INFORMATION_MESSAGE);
					}
					return;
			}
		}
		else {
			this.tacheDAffichageDeLApplication.afficherMessage("Veuillez renseigner tous les champs !", "Erreur champ(s) vide(s)", JOptionPane.ERROR_MESSAGE);
		}		
		return;
	}
}