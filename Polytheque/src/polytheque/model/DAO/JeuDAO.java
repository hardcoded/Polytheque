package polytheque.model.DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import polytheque.model.pojos.Jeu;

public abstract class JeuDAO extends DAO {
	
	public JeuDAO(Connection conn) 
	{
		super(conn);
	}
		/**
		  * Méthode de création
		  * @param Jeu
		  * @return boolean 
		  */
		  public boolean create(Jeu jeu)
		  {
			  return false;
		  }

		  /**
		  * Méthode pour effacer
		  * @param Jeu
		  * @return boolean 
		  */
		  public boolean delete(Jeu jeu)
		  {
			  return false;
		  }

		  /**
		  * Méthode de mise à jour
		  * @param obj
		  * @return boolean
		  */
		  public boolean update(Jeu jeu)
		  {
			  return false;
		  }

		  /**
		  * Méthode de recherche des informations
		  * @param id
		  * @return T
		  */
		  public Jeu find(int id)
		  {
			  Jeu jeu = new Jeu();
			  try {
			      ResultSet result = this.connect.createStatement(
			        ResultSet.TYPE_SCROLL_INSENSITIVE,
			        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM eleve WHERE elv_id = " + id);
			      if(result.first())
			        jeu = new Jeu(
			          id,
			        ));         
			    } catch (SQLException e) {
			      e.printStackTrace();
			    }
			    return jeu;
			  }  
		  }
		}
		
	


