package polytheque.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EditeurJeuDAO extends DAO {
	
	public String retreiveEditeur(int idEditeur) {
		try {
			super.connect();
			PreparedStatement psSelect = connection.prepareStatement("SELECT * FROM EDITEUR WHERE id_editeur = ?");
			psSelect.setInt(1, idEditeur);
			psSelect.execute();
			psSelect.closeOnCompletion();

			ResultSet resSet = psSelect.getResultSet();
			String editeur = null;
			if (resSet.next()) { // On se place sur le 1er résultat
				editeur = resSet.getString("nom_editeur");
			}
			super.disconnect();
			return editeur;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		} 
}
}
