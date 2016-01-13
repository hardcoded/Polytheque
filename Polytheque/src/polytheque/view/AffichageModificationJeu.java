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
 * Classe permettant de gerer la modification des informations li�es au compte de l'utilisateur.
 * 
 * @author Godefroi Roussel, Johan Brunet
 *
 */
@SuppressWarnings("serial")
public class AffichageModificationJeu extends JPanel implements ActionListener {
	private JTextField gameNom;
	private JTextField gameDescription;
	private JTextField gameAnnee;
	private JTextField gameAge;
	private JTextField gameJouMin;
	private JTextField gameJouMax;
	private JTextField gameCategorie;
	private JTextField gameEditeur;
	private JTextField gameNBEx;
	private JTextField gameNBRes;
	
	private JButton boutonValider;
	
	private Jeu jeuCourant;
	
	JComboBox<Boolean> gameStatut;
	
	/**
	 * Une tache d'affichage de l'application.
	 */
	private TacheDAffichage tacheDAffichageDeLApplication;
	
	/**
	 * Creation de la page permettant de modifier les informations d'un jeu en particulier.
	 * 
	 * @param afficheAppli
	 *      Une tache d'affichage de l'application.
	 * @param jeu
	 * 		Le jeu à modifier.
	 */
	public AffichageModificationJeu(TacheDAffichage afficheAppli, Jeu jeu) {
		this.tacheDAffichageDeLApplication = afficheAppli;
		this.jeuCourant = jeu;
		this.setLayout(null);
		ajouterChamps();
		ajouterBoutons();
	}
	
	/**
	 * Ajoute et place tous les champs sur la page. C'est-�-dire les zones de textes �crivables (avec directement les informations de l'utilisateur), 
	 * les zones de textes seulement lisible ainsi que les boutons d�roulants.
	 */
	public void ajouterChamps() {
		
		JLabel titrePrincipal = new JLabel("Modification de l'adh�rent");
		titrePrincipal.setBounds(480, 20, 260, 30);
		this.add(titrePrincipal);
		
		JLabel labelGameName = new JLabel("Nom :");
		labelGameName.setBounds(150, 150, 100, 30);
		this.add(labelGameName);
		this.gameNom = new JTextField(this.jeuCourant.getNom());
		this.gameNom.setBounds(200, 150, 100, 30);
		this.add(gameNom);
					
		JLabel labelGameDescription = new JLabel("Description :");
		labelGameDescription.setBounds(150, 200, 100, 30);
		this.add(labelGameDescription);
		this.gameDescription = new JTextField(this.jeuCourant.getDescription());
		this.gameDescription.setBounds(240, 200, 100, 30);
		this.add(gameDescription);
		
		JLabel labelGameAnnee = new JLabel("Ann�e :");
		labelGameAnnee.setBounds(150, 240, 100, 30);
		this.add(labelGameAnnee);
		this.gameAnnee = new JTextField(this.jeuCourant.getAnneeParution());
		this.gameAnnee.setBounds(200, 240, 40, 30);
		this.add(this.gameAnnee);
		
		JLabel labelGameAge = new JLabel("Age:");
		labelGameAge.setBounds(150, 270, 100, 30);
		this.add(labelGameAge);
		this.gameAge = new JTextField(this.jeuCourant.getAgeMini());
		this.gameAge.setBounds(200, 270, 30, 30);
		this.add(this.gameAge);
		
		JLabel labelGameExemplaire = new JLabel("Nombre exemplaire:");
		labelGameExemplaire.setBounds(150, 300, 200, 30);
		this.add(labelGameExemplaire);
		this.gameNBEx = new JTextField(this.jeuCourant.getNbExemplaires());
		this.gameNBEx.setBounds(280, 300, 30, 30);
		this.add(this.gameNBEx);
		
		JLabel labelGameReserve = new JLabel("Nombre emprunt�:");
		labelGameReserve.setBounds(150, 330, 200, 30);
		this.add(labelGameReserve);
		this.gameNBRes = new JTextField(this.jeuCourant.getNbReserves());
		this.gameNBRes.setBounds(280, 330, 30, 30);
		this.add(this.gameNBRes);

		
		JLabel labelGameJouMin = new JLabel("Nombre de joueurs minimum :");
		labelGameJouMin.setBounds(150, 360, 200, 30);
		this.add(labelGameJouMin);
		this.gameJouMin = new JTextField(this.jeuCourant.getNbJoueursMin());
		this.gameJouMin.setBounds(330, 360, 30, 30);
		this.add(this.gameJouMin);
		
		JLabel labelGameJouMax = new JLabel("Nombre de joueurs maximum :");
		labelGameJouMax.setBounds(150, 390, 200, 30);
		this.add(labelGameJouMax);
		this.gameJouMax = new JTextField(this.jeuCourant.getNbJoueursMax());
		this.gameJouMax.setBounds(330, 390, 30, 30);
		this.add(this.gameJouMax);
		
		
		JLabel labelGameCategorie = new JLabel("Categorie :");
		labelGameCategorie.setBounds(600, 150, 100, 30);
		this.add(labelGameCategorie);
		this.gameCategorie = new JTextField(this.jeuCourant.getCategorie());
		this.gameCategorie.setBounds(670, 150, 100, 30);
		this.add(this.gameCategorie);
		
		
		JLabel labelGameEditeur = new JLabel("Editeur :");
		labelGameEditeur.setBounds(600, 180, 100, 30);
		this.add(labelGameEditeur);
		this.gameEditeur = new JTextField(this.jeuCourant.getEditeur());
		this.gameEditeur.setBounds(670, 180, 100, 30);
		this.add(this.gameEditeur);
		
		
		JLabel labelGameStatut = new JLabel("Le jeu est disponible? :");
		labelGameStatut.setBounds(600, 210, 200, 30);
		this.add(labelGameStatut);		
		this.gameStatut = new JComboBox<Boolean>();
		if (this.jeuCourant.getStatut() == "Disponible"){
			this.gameStatut.addItem(Boolean.TRUE);
			this.gameStatut.addItem(Boolean.FALSE);
		}
		else
		{
			this.gameStatut.addItem(Boolean.FALSE);
			this.gameStatut.addItem(Boolean.TRUE);
		}
		this.gameStatut.setPreferredSize(new Dimension(100, 20));
		this.gameStatut.setBounds(600, 240, 100, 30);
		this.add(gameStatut);
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
	
	@Override
	/**
	 * Permet de rendre les boutons fonctionnels et affiche des messages en fonction de si il y a des erreurs ou si tout s'est d�roul� comme pr�vu. 
	 */
	public void actionPerformed(ActionEvent event) {
		JButton boutonSelectionne = (JButton) event.getSource();
		if (boutonSelectionne == this.boutonValider)
		{
			if (this.gameNom.getText() != null && this.gameNBEx.getText() != null &&
					this.gameAnnee.getText() != null && this.gameAge.getText() != null && this.gameJouMin.getText() != null && this.gameJouMax.getText() != null) {
					String statut;
					int age = Integer.parseInt(this.gameAge.getText());
					int nbExemplaire = Integer.parseInt(this.gameNBEx.getText());
					int nbRes = Integer.parseInt(this.gameNBRes.getText());
					int nbJouMin = Integer.parseInt(this.gameJouMin.getText());
					int nbJouMax = Integer.parseInt(this.gameJouMax.getText());
					
					if ((boolean) this.gameStatut.getSelectedItem() == true){
						statut= "Disponible";
					}
					else {
						statut = "Indisponible";
					}
				
					Jeu jeu = new Jeu(this.gameNom.getText(), this.gameDescription.getText(), this.gameAnnee.getText(), statut, nbExemplaire, nbRes, age, nbJouMin, nbJouMax, this.gameCategorie.getText(), this.gameEditeur.getText());
					
					if (this.tacheDAffichageDeLApplication.modifJeu(jeu) == false) {
						this.tacheDAffichageDeLApplication.afficherMessage("Erreur lors de la modification du jeu", "Erreur de modification", JOptionPane.ERROR_MESSAGE);
					}
					else {
						this.tacheDAffichageDeLApplication.afficherMessage("Vos modifications ont bien �t� prises en compte !", "Modifications termin�es", JOptionPane.INFORMATION_MESSAGE);
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