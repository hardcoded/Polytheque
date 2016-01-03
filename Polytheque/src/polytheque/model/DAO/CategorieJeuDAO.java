package polytheque.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategorieJeuDAO extends DAO {

	public String retreiveCategorie(int idCategorie) {
		try {
			super.connect();
			PreparedStatement psSelect = connection.prepareStatement("SELECT * FROM CATEGORIE WHERE id_categorie = ?");
			psSelect.setInt(1, idCategorie);
			psSelect.execute();
			psSelect.closeOnCompletion();

			ResultSet resSet = psSelect.getResultSet();
			String categorie = null;
			if (resSet.next()) { // On se place sur le 1er résultat
				categorie = resSet.getString("nom_categorie");
			}
			super.disconnect();
			return categorie;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	} 
}