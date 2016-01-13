package polytheque.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import polytheque.model.pojos.Reservation;

/**
 * Classe permettant un administrateur d'annuler une réservation grâce à son id
 * 
 * @author Laure Marchal
 *
 */
@SuppressWarnings("serial")
public class AppliAnnulerReservation extends JPanel implements ActionListener {

	private JTextField idReservation; //champ pour écrire l'idReservation
	private JButton boutonValider; //bouton
	
	/**
	 * Une tache d'affichage de l'application.
	 */
	private TacheDAffichage tacheDAffichageDeLApplication;
	
	/**
	 * Création de la page d'accueil.
	 * 
	 * @param afficheAppli
	 *            Une tache d'affichage de l'application.
	 */
	public AppliAnnulerReservation(TacheDAffichage afficheAppli){
		this.setLayout(new BorderLayout());

		this.tacheDAffichageDeLApplication = afficheAppli;
		ajouterChamps();
	}

	/**
	 * m�thode qui permet d'ajouter les champs � la fenetre d'affichage
	 * exemples : titre, questions pour l'utilisateur, boutons
	 */
	public void ajouterChamps() {
		JPanel titrePanel = new JPanel();
		JPanel champsPanel = new JPanel();
		JPanel boutonPanel = new JPanel();

		JLabel titrePrincipal = new JLabel("Veuillez entrer l'id de la r�servation que vous souhaitez annuler :");
		titrePrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		//titrePrincipal.setBounds(450, 20, 260, 30);
		titrePanel.add(titrePrincipal);		
		this.add(titrePanel, BorderLayout.NORTH);
		
		JLabel labelIdReservation = new JLabel("id Reservation :");
		//labelUserName.setBounds(500, 150, 100, 30);
		champsPanel.add(labelIdReservation, BorderLayout.CENTER);
		this.idReservation = new JTextField();
		//this.userName.setBounds(450, 200, 190, 30);
		this.idReservation.setColumns(10);
		champsPanel.add(this.idReservation, BorderLayout.CENTER);

		this.add(champsPanel, BorderLayout.CENTER);

		this.boutonValider = new JButton("Valider");
		//this.boutonValider.setBounds(350, 450, 400, 30);
		this.boutonValider.addActionListener(this);
		boutonPanel.add(this.boutonValider, BorderLayout.CENTER);
		this.add(boutonValider, BorderLayout.SOUTH);
	}
	
	/**
	 * traitement des �v�nements (click sur valider)
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		JButton boutonSelectionne = (JButton) event.getSource();

		if (boutonSelectionne == this.boutonValider)
		{
			Reservation res =this.tacheDAffichageDeLApplication.getReservation(idReservation.getText());
			this.tacheDAffichageDeLApplication.deleteReservation(res);
			this.tacheDAffichageDeLApplication.afficherMessage("Fonctionnalit� pas encore impl�mentent�e"," Pas dispo ", JOptionPane.INFORMATION_MESSAGE);
			this.tacheDAffichageDeLApplication.afficherAccueil();
		}	
	}

}
