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
	private JDateChooser dateChooser;

	private JPasswordField password;

	private JButton boutonValider;

	JComboBox<Boolean> userIsAdmin;
	JComboBox<Boolean> userPeutEmprunter;
	JComboBox<Boolean> userEstAJour;

	/**
	 * Une tache d'affichage de l'application.
	 */
	private TacheDAffichage tacheDAffichageDeLApplication;

	/**
	 * Creation de la page permettant de cr�er un nouvel adh�rent.
	 * 
	 * @param afficheAppli
	 * 		Une tache d'affichage de l'application.
	 */
	public AffichageCreationAdherent(TacheDAffichage afficheAppli) {
		this.tacheDAffichageDeLApplication = afficheAppli;
		this.setLayout(null);

		ajouterChamps();
		creerPanneauDate();
		ajouterBoutons();
	}

	/**
	 * Ajoute et place tous les champs sur la page. C'est-�-dire les zones de textes �crivables (avec directement les informations de l'utilisateur), 
	 * les zones de textes seulement lisible ainsi que les boutons d�roulants.
	 */
	public void ajouterChamps() {		
		JLabel titrePrincipal = new JLabel("Cr�ation Adh�rent");
		titrePrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		titrePrincipal.setBounds(480, 20, 260, 30);
		this.add(titrePrincipal);

		JLabel labelUserName = new JLabel("Nom :");
		labelUserName.setBounds(150, 150, 100, 30);
		this.add(labelUserName);
		this.userName = new JTextField();
		this.userName.setBounds(200, 150, 100, 30);
		this.add(userName);

		JLabel labelUserFirstName = new JLabel("Prenom :");
		labelUserFirstName.setBounds(150, 200, 100, 30);
		this.add(labelUserFirstName);
		this.userFirstName = new JTextField();
		this.userFirstName.setBounds(210, 200, 100, 30);
		this.add(userFirstName);

		JLabel labelUserRue = new JLabel("Rue :");
		labelUserRue.setBounds(150, 240, 100, 30);
		this.add(labelUserRue);
		this.userRue = new JTextField();
		this.userRue.setBounds(200, 240, 130, 30);
		this.add(this.userRue);

		JLabel labelUserCP = new JLabel("Code Postal:");
		labelUserCP.setBounds(150, 270, 100, 30);
		this.add(labelUserCP);
		this.userCP = new JTextField();
		this.userCP.setBounds(240, 270, 100, 30);
		this.add(this.userCP);

		JLabel labelUserVille = new JLabel("Ville :");
		labelUserVille.setBounds(150, 300, 100, 30);
		this.add(labelUserVille);
		this.userVille = new JTextField();
		this.userVille.setBounds(200, 300, 100, 30);
		this.add(this.userVille);

		JLabel labelUserMail = new JLabel("Mail :");
		labelUserMail.setBounds(150, 330, 100, 30);
		this.add(labelUserMail);
		this.userMail = new JTextField();
		this.userMail.setBounds(200, 330, 100, 30);
		this.add(this.userMail);

		JLabel labelUserTelephone = new JLabel("Telephone :");
		labelUserTelephone.setBounds(150, 360, 100, 30);
		this.add(labelUserTelephone);
		this.userPhone = new JTextField();
		this.userPhone.setBounds(220, 360, 100, 30);
		this.add(this.userPhone);

		JLabel labelUserPseudo = new JLabel("Pseudo :");
		labelUserPseudo.setBounds(150, 390, 100, 30);
		this.add(labelUserPseudo);
		this.userPseudo = new JTextField();
		this.userPseudo.setBounds(210, 390, 100, 30);
		this.add(this.userPseudo);

		JLabel labelpassword = new JLabel("Mot de passe :");
		labelpassword.setBounds(150, 420, 100, 30);
		this.add(labelpassword);
		this.password = new JPasswordField();
		this.password.setBounds(230, 420, 190, 30);
		this.password.setColumns(10);
		this.add(this.password);

		JLabel labelUserIsAdmin = new JLabel("Admin :");
		labelUserIsAdmin.setBounds(600, 300, 100, 30);
		this.add(labelUserIsAdmin);		
		this.userIsAdmin = new JComboBox<Boolean>();
		this.userIsAdmin.addItem(Boolean.TRUE);
		this.userIsAdmin.addItem(Boolean.FALSE);
		this.userIsAdmin.setPreferredSize(new Dimension(100, 20));
		this.userIsAdmin.setBounds(600, 350, 100, 30);
		this.add(userIsAdmin);

		JLabel labelUserPeutEmprunter = new JLabel("Peut Emprunter :");
		labelUserPeutEmprunter.setBounds(600, 100, 100, 30);
		this.add(labelUserPeutEmprunter);
		this.userPeutEmprunter = new JComboBox<Boolean>();
		this.userPeutEmprunter.addItem(Boolean.TRUE);
		this.userPeutEmprunter.addItem(Boolean.FALSE);
		this.userPeutEmprunter.setPreferredSize(new Dimension(100, 20));
		this.userPeutEmprunter.setBounds(600, 150, 100, 30);
		this.add(userPeutEmprunter);

		JLabel labelUserEstAJour = new JLabel("Est a jour :");
		labelUserEstAJour.setBounds(600, 200, 100, 30);
		this.add(labelUserEstAJour);
		this.userEstAJour = new JComboBox<Boolean>();
		this.userEstAJour.addItem(Boolean.TRUE);
		this.userEstAJour.addItem(Boolean.FALSE);
		this.userEstAJour.setPreferredSize(new Dimension(20, 20));
		this.userEstAJour.setBounds(600, 250, 100, 30);
		this.add(this.userEstAJour);
	}

	/**
	 * Cr�er le champ Date et le bouton permettant de s�lectionner une date
	 */
	private void creerPanneauDate() {
		JLabel labelUserBirthday = new JLabel("Date de naissance :");
		labelUserBirthday.setBounds(850, 150, 150, 30);
		this.add(labelUserBirthday);
		this.dateChooser = new JDateChooser();
		this.dateChooser.setBounds(850, 200, 150, 30);
		this.add(this.dateChooser);
	}

	/**
	 * Ajoute le bouton 
	 */
	public void ajouterBoutons(){
		this.boutonValider = new JButton("Valider");
		this.boutonValider.setBounds(480, 500, 200, 30);
		this.boutonValider.addActionListener(this);
		this.add(this.boutonValider);
	}

	@Override
	/**
	 * Permet de rendre le bouton fonctionnel et affiche des messages en fonction de si il y a des erreurs ou si tout s'est d�roul� comme pr�vu.
	 */
	public void actionPerformed(ActionEvent event) {
		JButton boutonSelectionne = (JButton) event.getSource();

		if (boutonSelectionne == this.boutonValider) {
			if (this.userName.getText() != null && this.userFirstName.getText() != null && 
					this.dateChooser.getDate() != null && this.userRue.getText() != null &&
					this.userCP.getText() != null && this.userVille.getText() != null && 
					this.userPseudo.getText() != null && this.password.getPassword() != null) {
				String password = new String(this.password.getPassword());
				Date dateNaissance = new Date(this.dateChooser.getDate().getTime());
				boolean admin = (boolean) this.userIsAdmin.getSelectedItem();
				boolean peutEmprunter = (boolean) this.userPeutEmprunter.getSelectedItem();
				boolean AJour = (boolean) this.userEstAJour.getSelectedItem();

				Adherent adherent = new Adherent(this.userName.getText(), this.userFirstName.getText(), dateNaissance, this.userRue.getText(), this.userCP.getText(), this.userVille.getText(), this.userMail.getText(), this.userPhone.getText(), this.userPseudo.getText(), password, admin, AJour, peutEmprunter, 0);
				if (this.tacheDAffichageDeLApplication.creerAdherent(adherent) == false) {
					this.tacheDAffichageDeLApplication.afficherMessage("Erreur lors de la cr�ation d'un nouvel adh�rent", "Erreur de cr�ation", JOptionPane.ERROR_MESSAGE);
				}
				else {
					this.tacheDAffichageDeLApplication.afficherMessage("Un nouvel adh�rent a �t� cr�� !", "Cr�ation termin�e", JOptionPane.INFORMATION_MESSAGE);
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
