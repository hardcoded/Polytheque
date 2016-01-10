package polytheque.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 * Classe permettant de gerer la modification des informations liï¿½es au compte de l'utilisateur.
 * 
 * @author Godefroi Roussel
 *
 */
@SuppressWarnings("serial")
public class SeDeconnecter extends JPanel implements ActionListener {
	
	private JPanel buttonsPanel;
	private JButton boutonDeconnexion;
	
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
	public SeDeconnecter(TacheDAffichage afficheAppli){
		this.tacheDAffichageDeLApplication = afficheAppli;
		this.setLayout(new BorderLayout());

		ajouterBoutons();
	}

	public void ajouterBoutons(){
		this.buttonsPanel = new JPanel();

		this.boutonDeconnexion = new JButton("Déconnexion");
		this.boutonDeconnexion.addActionListener(this);
		this.buttonsPanel.add(this.boutonDeconnexion);

		this.add(this.buttonsPanel, BorderLayout.CENTER);
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		JButton boutonSelectionne = (JButton) event.getSource();

		if (boutonSelectionne == this.boutonDeconnexion)
		{
			invalidate();
			this.tacheDAffichageDeLApplication.afficherMessage("Vous avez été déconnecté avec succès !", "Déconnexion effectuée", JOptionPane.INFORMATION_MESSAGE);
			this.tacheDAffichageDeLApplication.afficherEcranConnexion();
			return;
		}
		return;
	}
	
}
