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
public class AffichageSupprimerJeu extends JPanel implements ActionListener {

	private JTextField gameNom;
	private JButton boutonValider;
	
	/**
	 * Une tache d'affichage de l'application.
	 */
	private TacheDAffichage tacheDAffichageDeLApplication;

	/**
	 * CrÃ©ation de la page permettant de supprimer un jeu (accessible seulement par un admin).
	 * 
	 * @param tacheDAffichageDeLApplication
	 *            Une tache d'affichage de l'application.
	 */
	public AffichageSupprimerJeu(TacheDAffichage afficheAppli){
		this.setLayout(null);

		this.tacheDAffichageDeLApplication = afficheAppli;
		ajouterChamps();
	}
	
	/**
	 * Ajoute une zone de texte écrivable et un bouton pour valider l'information écrit dans la zone de texte 
	 */
	private void ajouterChamps() {
		JLabel labelUserName = new JLabel("Nom a supprimer :");
		labelUserName.setBounds(430, 160, 200, 30);
		this.add(labelUserName);
		this.gameNom = new JTextField();
		this.gameNom.setBounds(550, 160, 100, 30);
		this.gameNom.setColumns(10);
		this.add(gameNom);
		
		this.boutonValider = new JButton("Valider");
		this.boutonValider.setBounds(670, 160, 100, 30);
		this.boutonValider.addActionListener(this);
		this.add(this.boutonValider);
	}
	
	@Override
	/**
	 * Permet de rendre le bouton fonctionnel et affiche des messages en fonction de si il y a des erreurs ou si tout s'est déroulé comme prévu.
	 */
	public void actionPerformed(ActionEvent event) {
		JButton boutonSelectionne = (JButton) event.getSource();
		
		if (boutonSelectionne == this.boutonValider)
		{
			if (this.gameNom.getText() != null) {
				String nom = new String(this.gameNom.getText());
				if (this.tacheDAffichageDeLApplication.supprimerAdherent(nom) ==  false) {
					this.tacheDAffichageDeLApplication.afficherMessage("Problème lors de la suppression du jeu !", "Erreur suppression", JOptionPane.ERROR_MESSAGE);
				}
				else {
					this.tacheDAffichageDeLApplication.afficherMessage("Jeu supprimé avec succès !", "Suppression effectuée", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			else {
				this.tacheDAffichageDeLApplication.afficherMessage("Veuillez remplir le champs texte !", "Champ vide", JOptionPane.ERROR_MESSAGE);
			}
			String nom = new String(this.gameNom.getText());
			this.tacheDAffichageDeLApplication.supprimerJeu(nom);
			this.tacheDAffichageDeLApplication.afficherMessage("Le jeu a bien été supprimé !", "Suppression terminée", JOptionPane.INFORMATION_MESSAGE);
		}
		return;
	}
}