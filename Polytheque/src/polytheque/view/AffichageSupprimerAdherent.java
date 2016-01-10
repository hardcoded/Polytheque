package polytheque.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import polytheque.model.DAO.AdherentDAO;

@SuppressWarnings("serial")
public class AffichageSupprimerAdherent extends JPanel implements ActionListener {

	private JTextField userName;
	private JPasswordField password;	
	private JButton boutonValider;
	private JButton boutonAccueil;
	private JPanel mainPanel;
	
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
	public AffichageSupprimerAdherent(TacheDAffichage afficheAppli){
		this.setLayout(new BorderLayout());

		this.tacheDAffichageDeLApplication = afficheAppli;
		ajouterChamps();
	}

	private void ajouterChamps() {
		this.mainPanel = new JPanel();
		this.mainPanel.setLayout(new BorderLayout());

		
		JLabel labelUserName = new JLabel("Nom a supprimer :");
		labelUserName.setBounds(500, 100, 200, 30);
		mainPanel.add(labelUserName, BorderLayout.NORTH);
		this.userName = new JTextField();
		this.userName.setBounds(450, 200, 190, 30);
		this.userName.setColumns(10);
		this.add(this.userName, BorderLayout.CENTER);


		this.boutonValider = new JButton("Valider");
		this.boutonValider.setBounds(350, 450, 400, 30);
		this.boutonValider.addActionListener(this);
		mainPanel.add(this.boutonValider, BorderLayout.NORTH);
		this.add(boutonValider, BorderLayout.CENTER);
		
		this.boutonAccueil = new JButton("Accueil");
		//this.boutonValider.setBounds(350, 450, 400, 30);
		this.boutonAccueil.addActionListener(this);
		mainPanel.add(this.boutonAccueil, BorderLayout.CENTER);
		this.add(boutonAccueil, BorderLayout.SOUTH);
		
		this.add(this.mainPanel, BorderLayout.CENTER);
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		JButton boutonSelectionne = (JButton) event.getSource();
		
		if (boutonSelectionne == this.boutonValider)
		{
			String nom = new String(this.userName.getText());
			this.tacheDAffichageDeLApplication.supprimerAdherent(nom);
		
			
		}
		
		if (boutonSelectionne == this.boutonAccueil)
		{
			this.tacheDAffichageDeLApplication.afficherAccueil();
			
					}
		return;
	}
}