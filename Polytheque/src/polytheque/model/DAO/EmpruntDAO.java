package polytheque.model.DAO;

import java.sql.PreparedStatement;
import java.util.Calendar;

import polytheque.model.pojos.Adherent;
import polytheque.model.pojos.Jeu;

	public class EmpruntDAO extends DAO 
	{
	/**
	 * Methode de creation
	 * @param Jeu
	 * @return boolean 
	 */
		public boolean create(Adherent adherent, Jeu jeu, Calendar dateDebut, Calendar dateFin) 
		{
			try 
			{
				super.connect();
				PreparedStatement psInsert = connection.prepareStatement("INSERT INTO "
						+"EMPRUNT(adherent,jeu,extension,dateDebut,dateFin)"+ "VALUES (?, ?, ?, ?, ?)");
				
			}

		}
	}


