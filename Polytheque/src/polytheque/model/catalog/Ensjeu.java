package polytheque.model.catalog;

import java.util.ArrayList;
import polytheque.model.pojos.Jeu;

/**
 * Classe représentant la liste des jeux à emprunter.
 * 
 * @author Yves-Alain
 *
 */
public class Ensjeu {

	private Jeu jeu;
    private ArrayList<Jeu> ensjeu;

    public Ensjeu() {
        this.ensjeu = new ArrayList<>();
    }
    
    /**
     * Méthode permettant d'ajouter un jeu à la liste.
     * 
     * @param nom
     * 		nom du jeu
     * @param description
     * 		description du jeu
     * @param editeur
     * 		editeur du jeu
     * @param etat
     * 		etat du jeu (neuf, d'occasion, abimé)
     * @param statut
     * 		statut du jeu (disponible ou non)
     * @param ageMini
     * 		age minimum pour jouer au jeu
     * @param anneeParution
     * 		année de parution du jeu
     */
    public void ajouterJeu(String nom,String description,String editeur,String etat,String statut,int ageMini,String anneeParution) {
        this.jeu = new Jeu(nom, description, ageMini, editeur, true, etat, statut, anneeParution);
        this.ensjeu.add(jeu);
    }
    
    public void supprimerJeu(Jeu jeu) {   
        Jeu k;
        
        for (int i = 0; i< this.ensjeu.size(); i++) {
            k = this.ensjeu.get(i);
            
            if (k == jeu) {
                this.ensjeu.remove(this.ensjeu.get(i));
            } 
        }   
    }
  
    public void modifierNomJeu (String nm,Jeu j) {
        Jeu k;
        
        for (int i = 0; i < ensjeu.size(); i++ ) {
           k = ensjeu.get(i);
           
           if (k == j) {
             ensjeu.get(i).setNom(nm);
           }
        }     
    }
}
