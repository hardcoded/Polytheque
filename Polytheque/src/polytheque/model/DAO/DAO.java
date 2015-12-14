package polytheque.model.DAO;

import java.sql.*;


public class DAO {


	  public static void main () {
	        try {
	            String url = "jdbc:msql://200.210.220.1:1114/Demo"; //adresse
	            Connection conn = DriverManager.getConnection(url,"","");
	            Statement stmt = conn.createStatement();
	            ResultSet rs;
	 
	            rs = stmt.executeQuery("SELECT id_jeu, nom, description, annee_parution, statut, nb_exemplaires, nb_reserves, age_mini, nombre_joueurs, id_categorie, id_editeur FROM jeu");
	            while ( rs.next() ) {
	               int idjeu = rs.getInt("id_jeu");
	               String nomjeu = rs.getString("nom");
	               String descriptionjeu= rs.getString("description");
	               String anneeparution= rs.getString("annee_parution");
	               String statut= rs.getString("statut");
	               int nombreexemplaires= rs.getInt("nb_exemplaires");	
	               int nombrereserves= rs.getInt("nb_reserves");
	               int ageminimum= rs.getInt("age_mini");
	               int nombrejoueurs= rs.getInt("nombre_joueurs");
	               int idcategorie= rs.getInt("id_categorie");
	               int idediteur = rs.getInt("id_editeur");
	               
	               System.out.println(idjeu + "\t" + nomjeu +
                           "\t" + descriptionjeu + "\t" + anneeparution +
                           "\t" + statut + "\t" + nombreexemplaires + "\t" + 
                           nombrereserves + "\t" + ageminimum + "\t" + nombrejoueurs
                           + "\t" +  idcategorie + "\t" + idediteur);
	               
	            }  
	            conn.close();
	        } catch (Exception e) {
	            System.err.println("Got an exception! ");
	            System.err.println(e.getMessage());
	        }
	    }
	
	
	
}
