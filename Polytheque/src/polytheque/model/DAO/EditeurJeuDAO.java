package polytheque.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import polytheque.model.pojos.Jeu;

public class EditeurJeuDAO extends DAO {
	public Jeu retreiveEditeur(int idEditeur) {
		try {
			super.connect();
			PreparedStatement psSelect = connection.prepareStatement("SELECT * FROM EDITEUR WHERE id_editeur = ?");
			psSelect.setInt(1, idEditeur);
			psSelect.execute();
			psSelect.closeOnCompletion();

			ResultSet resSet = psSelect.getResultSet();
			Jeu editeur = null;
			if (resSet.next()) { // On se place sur le 1er résultat
				editeur = new Jeu(idEditeur, resSet.getString(1));
			}
			super.disconnect();
			return editeur;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		} 
}
}
