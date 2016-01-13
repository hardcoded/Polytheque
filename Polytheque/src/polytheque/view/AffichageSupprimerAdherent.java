package polytheque.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * @author Sanwei Lee, Johan Brunet, Godefroi Roussel
 *
 */
@SuppressWarnings("serial")
public class AffichageSupprimerAdherent extends JPanel implements ActionListener {

	private JTextField userPseudo;
	private JButton boutonValider;
	
	/**
	 * Une tache d'affichage de l'application.
	 */
	private TacheDAffichage tacheDAffichageDeLApplication;

	/**
	 * Création de la page permettant de supprimer un adh�rent (accessible seulement par un admin).
	 * 
	 * @param afficheAppli
	 *            Une tache d'affichage de l'application.
	 */
	public AffichageSupprimerAdherent(TacheDAffichage afficheAppli){
		this.setLayout(null);

		this.tacheDAffichageDeLApplication = afficheAppli;
		ajouterChamps();
	}
	
	/**
	 * Ajoute une zone de texte �crivable et un bouton pour valider l'information �crit dans la zone de texte 
	 */
	private void ajouterChamps() {
		JLabel labelUserName = new JLabel("Pseudo � supprimer :");
		labelUserName.setBounds(430, 160, 200, 30);
		this.add(labelUserName);
		this.userPseudo = new JTextField();
		this.userPseudo.setBounds(560, 160, 100, 30);
		this.userPseudo.setColumns(10);
		this.add(userPseudo);
		
		this.boutonValider = new JButton("Valider");
		this.boutonValider.setBounds(670, 160, 100, 30);
		this.boutonValider.addActionListener(this);
		this.add(this.boutonValider);
	}
	
	@Override
	/**
	 * Permet de rendre le bouton fonctionnel et affiche des messages en fonction de si il y a des erreurs ou si tout s'est d�roul� comme pr�vu.
	 */
	public void actionPerformed(ActionEvent event) {
		JButton boutonSelectionne = (JButton) event.getSource();
		
		if (boutonSelectionne == this.boutonValider)
		{
			if (this.userPseudo.getText() != null) {
				String nom = new String(this.userPseudo.getText());
				if (this.tacheDAffichageDeLApplication.supprimerAdherent(nom) ==  false) {
					this.tacheDAffichageDeLApplication.afficherMessage("Probl�me lors de la suppression de l'adh�rent !", "Erreur suppression", JOptionPane.ERROR_MESSAGE);
				}
				else {
					this.tacheDAffichageDeLApplication.afficherMessage("Adh�rent supprim� avec succ�s !", "Suppression effectu�e", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			else {
				this.tacheDAffichageDeLApplication.afficherMessage("Veuillez remplir le champs texte !", "Champ vide", JOptionPane.ERROR_MESSAGE);
			}
			String nom = new String(this.userPseudo.getText());
			this.tacheDAffichageDeLApplication.supprimerAdherent(nom);
			this.tacheDAffichageDeLApplication.afficherMessage("Le compte a bien �t� supprim� !", "Suppression termin�e", JOptionPane.INFORMATION_MESSAGE);
		}
		return;
	}
}