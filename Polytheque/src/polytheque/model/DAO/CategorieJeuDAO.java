package polytheque.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import polytheque.model.pojos.Jeu;
import polytheque.model.pojos.Reservation;

public class CategorieJeuDAO extends DAO {
	
	public Jeu retreiveCategorie(int idCategorie) {
		try {
			super.connect();
			PreparedStatement psSelect = connection.prepareStatement("SELECT * FROM CATEGORIE WHERE id_categorie = ?");
			psSelect.setInt(1, idCategorie);
			psSelect.execute();
			psSelect.closeOnCompletion();

			ResultSet resSet = psSelect.getResultSet();
			Jeu categorie = null;
			if (resSet.next()) { // On se place sur le 1er résultat
				categorie = new Jeu(idCategorie, resSet.getString(1));
			}
			super.disconnect();
			return categorie;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
} 
}