package polytheque.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 * Classe permettant de gerer la deconnexion de l'utilisateur.
 * 
 * @author Godefroi Roussel
 *
 */
@SuppressWarnings("serial")
public class Deconnexion extends JPanel implements ActionListener {

	private JPanel buttonsPanel;
	private JButton boutonDeconnexion;

	/**
	 * Une tache d'affichage de l'application.
	 */
	private TacheDAffichage tacheDAffichageDeLApplication;

	/**
	 * Creation de la page pour se d�connecter.
	 * 
	 * @param afficheAppli
	 *            Une tache d'affichage de l'application.
	 */
	public Deconnexion(TacheDAffichage afficheAppli){
		this.tacheDAffichageDeLApplication = afficheAppli;
		this.setLayout(new BorderLayout());

		ajouterBoutons();
	}

	/**
	 * Ajoute le bouton pour valider les informations et le place sur la page.
	 */
	public void ajouterBoutons(){
		this.buttonsPanel = new JPanel();

		this.boutonDeconnexion = new JButton("D�connexion");
		this.boutonDeconnexion.addActionListener(this);
		this.buttonsPanel.add(this.boutonDeconnexion);

		this.add(this.buttonsPanel, BorderLayout.CENTER);
	}

	@Override
	/**
	 * Permet de rendre le bouton fonctionnel. D'abord on invalide les diff�rentes informations de l'utilisateur puis on affiche le message
	 * disant que l'utilisateur a bien �t� d�connect� pour enfin le ramener � l'�cran de connexion.
	 */
	public void actionPerformed(ActionEvent event) {
		JButton boutonSelectionne = (JButton) event.getSource();

		if (boutonSelectionne == this.boutonDeconnexion)
		{
			invalidate();
			this.tacheDAffichageDeLApplication.afficherMessage("Vous avez �t� d�connect� avec succ�s !", "D�connexion effectu�e", JOptionPane.INFORMATION_MESSAGE);
			this.tacheDAffichageDeLApplication.afficherEcranConnexion();
			return;
		}
		return;
	}

}
