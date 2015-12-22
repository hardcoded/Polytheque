package polytheque.model.catalog;

import java.util.ArrayList;
import polytheque.model.pojos.Jeu;

/**
 * Classe repr�sentant la liste des jeux � emprunter.
 * 
 * @author Yves-Alain
 *
 */
public class Ensjeu {

	private ArrayList<Jeu> ensjeu;

    public Ensjeu() {
        this.ensjeu = new ArrayList<>();
    }
    
    /**
     * M�thode permettant d'ajouter un jeu � la liste.
     * 
     * @param jeu
     * 			le jeu à ajouter à la liste
     */
    public void ajouterJeu(Jeu jeu) {
        this.ensjeu.add(jeu);
    }
    
    /**
     * Methode permettant de supprimer un Jeu present dans l'ensemble de jeu
     * @param jeu
     * 		l'objet de type jeu a supprimer de la liste
     */
    public void supprimerJeu(Jeu jeu) {   
        Jeu k;        
        for (int i = 0; i< this.ensjeu.size(); i++) {
            k = this.ensjeu.get(i);
            if (k == jeu) {
                this.ensjeu.remove(k);
            } 
        }   
    }
    
    /**
     * Method de modification du booleen disponibilite Jeu utile pour les reservations
     * 
     * @param j
     * 		Jeu dont l'attribut disponibilite doit etre modifie
     */
    public void modifierDispoJeu (Jeu j) 
    {
        Jeu k;
        
        for (int i = 0; i < ensjeu.size(); i++ ) 
        {
           k = ensjeu.get(i);
           
           if (k == j) 
           {
             ensjeu.get(i).setDisponibilite(!ensjeu.get(i).isDisponibilite());
           }
        }     
    }

	public Jeu getJeu(int index) {
		Jeu jeu = null;
		for(int i = 0; i < this.ensjeu.size(); i++) {
			if (i == index) {
				jeu = this.ensjeu.get(i);
			}
		}
		return jeu;
	}
}
