package polytheque.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import polytheque.model.pojos.Jeu;

/**
 * Classe permettant de créer un nouveau jeu.
 * 
 * @author Godefroi Roussel
 *
 */
@SuppressWarnings("serial")
public class AffichageCreationJeu extends JPanel implements ActionListener {
	
		private JTextField gameNom;
		private JTextField gameAnnee;
		private JTextField gameAge;
		private JTextField gameJouMin;
		private JTextField gameEditeur;
		private JTextField gameNBEx;
		
		private JButton boutonValider;
		
		JComboBox<Boolean> gameStatut;
		
		/**
		 * Une tache d'affichage de l'application.
		 */
		private TacheDAffichage tacheDAffichageDeLApplication;

		/**
		 * Creation de la page permettant de créer un nouveau jeu.
		 * 
		 * @param tacheDAffichageDeLApplication
		 *            Une tache d'affichage de l'application.
		 * @return 
		 */
		public AffichageCreationJeu(TacheDAffichage afficheAppli) {
			this.tacheDAffichageDeLApplication = afficheAppli;
			this.setLayout(null);
			
			ajouterChamps();
			ajouterBoutons();
		}
		
		/**
		 * Ajoute et place tous les champs sur la page. C'est-à-dire les zones de textes écrivables (avec directement les informations de l'utilisateur), 
		 * les zones de textes seulement lisible ainsi que le bouton déroulant.
		 */
		public void ajouterChamps() {		
			JLabel titrePrincipal = new JLabel("Création d'un Jeu");
			titrePrincipal.setBounds(480, 20, 260, 30);
			this.add(titrePrincipal);
			
			JLabel labelGameName = new JLabel("Nom :");
			labelGameName.setBounds(150, 150, 100, 30);
			this.add(labelGameName);
			this.gameNom = new JTextField();
			this.gameNom.setBounds(200, 150, 100, 30);
			this.add(gameNom);

			
			JLabel labelGameAnnee = new JLabel("Année :");
			labelGameAnnee.setBounds(150, 190, 100, 30);
			this.add(labelGameAnnee);
			this.gameAnnee = new JTextField();
			this.gameAnnee.setBounds(200, 190, 130, 30);
			this.add(this.gameAnnee);
			
			JLabel labelGameAge = new JLabel("Age:");
			labelGameAge.setBounds(150, 230, 60, 30);
			this.add(labelGameAge);
			this.gameAge = new JTextField();
			this.gameAge.setBounds(180, 230, 30, 30);
			this.add(this.gameAge);
			
			JLabel labelGameExemplaire = new JLabel("Nombre exemplaire:");
			labelGameExemplaire.setBounds(150, 270, 200, 30);
			this.add(labelGameExemplaire);
			this.gameNBEx = new JTextField();
			this.gameNBEx.setBounds(280, 270, 30, 30);
			this.add(this.gameNBEx);
	
			
			JLabel labelGameJouMin = new JLabel("Nombre de joueurs minimum :");
			labelGameJouMin.setBounds(150, 310, 200, 30);
			this.add(labelGameJouMin);
			this.gameJouMin = new JTextField();
			this.gameJouMin.setBounds(330, 310, 60, 30);
			this.add(this.gameJouMin);
			
			JLabel labelGameEditeur = new JLabel("Editeur :");
			labelGameEditeur.setBounds(600, 180, 100, 30);
			this.add(labelGameEditeur);
			this.gameEditeur = new JTextField();
			this.gameEditeur.setBounds(670, 180, 100, 30);
			this.add(this.gameEditeur);
			
			JLabel labelGameStatut = new JLabel("Le jeu est disponible? :");
			labelGameStatut.setBounds(600, 100, 200, 30);
			this.add(labelGameStatut);		
			this.gameStatut = new JComboBox<Boolean>();
			this.gameStatut.addItem(Boolean.TRUE);
			this.gameStatut.addItem(Boolean.FALSE);
			this.gameStatut.setPreferredSize(new Dimension(100, 20));
			this.gameStatut.setBounds(600, 130, 100, 30);
			this.add(gameStatut);
		}
		
		/**
		 * Ajoute les boutons sur la page.
		 */
		public void ajouterBoutons(){
			this.boutonValider = new JButton("Valider");
			this.boutonValider.setBounds(480, 500, 200, 30);
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
				if (this.gameNom.getText() != null && this.gameNBEx.getText() != null && this.gameEditeur.getText() != null &&
					this.gameAnnee.getText() != null && this.gameAge.getText() != null && this.gameJouMin.getText() != null) {
					String statut;
					int age = Integer.parseInt(this.gameAge.getText());
					int nbExemplaire = Integer.parseInt(this.gameNBEx.getText());
					int nbJouMin = Integer.parseInt(this.gameJouMin.getText());
					
					if ((boolean) this.gameStatut.getSelectedItem() == true){
						statut= "Disponible";
					}
					else {
						statut = "Indisponible";
					}
					Jeu jeu = new Jeu(this.gameNom.getText(), this.gameAnnee.getText(), statut, nbExemplaire, 0, age, nbJouMin);
					if (this.tacheDAffichageDeLApplication.creerJeu(jeu) == false) {
						this.tacheDAffichageDeLApplication.afficherMessage("Erreur lors de la création d'un nouveau jeu", "Erreur de création", JOptionPane.ERROR_MESSAGE);
					}
					else {
						this.tacheDAffichageDeLApplication.afficherMessage("Un nouveau jeu a été créé !", "Création terminée", JOptionPane.INFORMATION_MESSAGE);
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
