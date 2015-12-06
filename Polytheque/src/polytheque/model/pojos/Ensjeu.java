package polytheque.model.pojos;

import java.util.ArrayList;
import polytheque.model.pojos.Jeu;

public class Ensjeu {

	private Jeu jeu;
    private ArrayList<Jeu> ensjeu;

    public Ensjeu() {
        this.ensjeu = new ArrayList<>();
    }
       
    public void ajouterJeu(String nom,String description,String edition,String etat,String statut,int ageMini,String anneeParution) {
        this.jeu = new Jeu(nom, description, ageMini, edition, true, etat, statut, anneeParution);
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
