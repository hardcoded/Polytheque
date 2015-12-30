package polytheque.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTable;

public class AffichageListeJeux extends JFrame implements ActionListener {

	private TacheDAffichage afficheAppli;
	
	public AffichageListeJeux(TacheDAffichage afficheAppli) {
		this.afficheAppli = afficheAppli;
		
		creerContenu();
	}
	
	public void creerContenu() {
		
        Object[][] donnees = {
                {"Johnathan", "Sykes", "test", true, "dernierecase"},
                {"Nicolas", "Van de Kampf", "test", true, "dernierecase"},
                {"Damien", "Cuthbert", "test", true, "dernierecase"},
                {"Corinne", "Valance", "test", false, "dernierecase"},
                {"Emilie", "Schrödinger", "test", false, "dernierecase"},
                {"Delphine", "Duke", "test", false, "dernierecase"},
                {"Eric", "Trump", "test", true, "dernierecase"},
        };
 
        String[] entetes = {"Prénom", "Nom", "Couleur favorite", "Homme", "Sport"};
 
        JTable tableau = new JTable(donnees, entetes);
 
        getContentPane().add(tableau.getTableHeader(), BorderLayout.NORTH);
        getContentPane().add(tableau, BorderLayout.CENTER);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO
		
	}

}
