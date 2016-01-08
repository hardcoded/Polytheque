package polytheque.view;

import java.awt.BorderLayout;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class EcranConnexion extends JPanel implements ActionListener {

	private JTextField userName;
	private JPasswordField password;	
	private JButton boutonValider;

	/**
	 * Une tache d'affichage de l'application.
	 */
	private TacheDAffichage tacheDAffichageDeLApplication;

	/**
	 * Création de la page d'accueil.
	 * 
	 * @param tacheDAffichageDeLApplication
	 *            Une tache d'affichage de l'application.
	 */
	public EcranConnexion(TacheDAffichage afficheAppli){
		this.setLayout(new BorderLayout());

		this.tacheDAffichageDeLApplication = afficheAppli;
		ajouterChamps();
	}

	public void ajouterChamps() {
		JPanel titrePanel = new JPanel();
		JPanel champsPanel = new JPanel();
		JPanel boutonPanel = new JPanel();

		JLabel titrePrincipal = new JLabel("Veuillez vous identifier s'il vous plaît !");
		titrePrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		//titrePrincipal.setBounds(450, 20, 260, 30);
		titrePanel.add(titrePrincipal);		
		this.add(titrePanel, BorderLayout.NORTH);
		
		JLabel labelUserName = new JLabel("Pseudo :");
		//labelUserName.setBounds(500, 150, 100, 30);
		champsPanel.add(labelUserName, BorderLayout.CENTER);
		this.userName = new JTextField();
		//this.userName.setBounds(450, 200, 190, 30);
		this.userName.setColumns(10);
		champsPanel.add(this.userName, BorderLayout.CENTER);

		JLabel labelPassword = new JLabel("Mot de passe :");
		//labelPassword.setBounds(500, 300, 100, 30);
		champsPanel.add(labelPassword, BorderLayout.CENTER);
		this.password = new JPasswordField();
		//this.password.setBounds(450, 350, 190, 30);
		this.password.setColumns(10);
		
		this.password.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				loginRequest();				
			}
		});
		
		champsPanel.add(this.password, BorderLayout.CENTER);
		this.add(champsPanel, BorderLayout.CENTER);

		this.boutonValider = new JButton("Valider");
		//this.boutonValider.setBounds(350, 450, 400, 30);
		this.boutonValider.addActionListener(this);
		boutonPanel.add(this.boutonValider, BorderLayout.CENTER);
		this.add(boutonValider, BorderLayout.SOUTH);
	}
	
	public void loginRequest() {
		String pwd = new String(this.password.getPassword());
		if (this.tacheDAffichageDeLApplication.testerValiditeConnexion(this.userName.getText(), pwd) == false) {
			this.tacheDAffichageDeLApplication.afficherMessage("Identifiant ou mot de passe incorrect !", "Erreur !", JOptionPane.ERROR_MESSAGE);
			this.tacheDAffichageDeLApplication.afficherEcranConnexion();
		}
		else {
			this.tacheDAffichageDeLApplication.afficherAccueil();
		}
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		JButton boutonSelectionne = (JButton) event.getSource();

		if (boutonSelectionne == this.boutonValider)
		{
			loginRequest();
		}
		return;
	}
}
