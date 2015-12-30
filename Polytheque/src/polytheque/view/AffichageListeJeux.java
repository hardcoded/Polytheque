package polytheque.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTable;

import polytheque.view.modeles.ModeleTableauListeJeux;

@SuppressWarnings("serial")
public class AffichageListeJeux extends JPanel implements ActionListener {

	private TacheDAffichage afficheAppli;
	
	/**
	 * Les libellés des entêtes.
	 */
	public final static String[] LIBELLES = new String[] {"Nom", "Descritpion", "Année de parution", "Statut", "Age mini", "Nombre de joueurs mini", "Catégorie", "Editeur"};
	
	
	public AffichageListeJeux(TacheDAffichage afficheAppli) {
		this.afficheAppli = afficheAppli;
		
		creerContenu();
	}
	
	public void creerContenu() {
		
        Object[][] donnees = {
                {"Nom1", "TEST", "2015", "OK", "3", "2", "Aventure", ""},
                {"Nom2", "test", "1995", "Abimé", "8", "2", "Action", "Moi"},
                {"Nom3", "Description", "2001", "OK", "12", "4", "", "Lui"},
                {"Nom4", "Jeu de société", "2012", "OK", "3", "6", "Société", "Toi"},
        };
 
        JTable tableau = new JTable(new ModeleTableauListeJeux(donnees, LIBELLES));
        this.add(tableau);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO
		
	}

}
