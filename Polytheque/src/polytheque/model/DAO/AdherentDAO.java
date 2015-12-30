package polytheque.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import polytheque.model.pojos.Adherent;
import polytheque.model.pojos.Jeu;

public class AdherentDAO extends DAO {

	/**
	 * Methode de creation
	 * @param adherent
	 * @return boolean 
	 */
	public boolean create(Adherent adherent) {
		try {
			super.connect();
			PreparedStatement psInsert = connection.prepareStatement("INSERT INTO "
					+ "ADHERENT(nom, prenom, date_naissance, rue, cp, ville, mail, telephone, pseudo, mdp, admin,"
					+ "liste_noire, droits, nb_retards, nb_non_recup)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"); 
			// On n'ajoute pas l'ID du jeu car il s'incrémente automatiquement dans la base de données
			psInsert.setString(1, adherent.getNom());
			psInsert.setString(2, adherent.getPrenom());
			psInsert.setDate(3, adherent.getDateNaissance());
			psInsert.setString(4, adherent.getRue());
			psInsert.setString(5, adherent.getCP());
			psInsert.setString(6, adherent.getVille());
			psInsert.setString(7, adherent.getMail());
			psInsert.setString(8, adherent.getTelephone());
			psInsert.setString(9, adherent.getPseudo());
			psInsert.setString(10, adherent.getMdp());
			psInsert.setBoolean(11, adherent.isAdmin());
			psInsert.setBoolean(12, true);
			psInsert.setBoolean(13, true);
			psInsert.setInt(14, 0);
			psInsert.setInt(15, 0);

			psInsert.executeUpdate();
			psInsert.closeOnCompletion();

			ResultSet idResult = psInsert.getGeneratedKeys();
			if (idResult != null && idResult.next()) {
				adherent.setIdAdherent(idResult.getInt(1));;
			} else {
				throw new SQLException();
			}

			super.disconnect();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Methode pour effacer
	 * @param Jeu
	 * @return boolean 
	 */
	public boolean delete(int id) {
		try {
			super.connect();
			PreparedStatement psDelete = connection.prepareStatement("DELETE * FROM ADHERENT WHERE id_adherent = ?"); 
			psDelete.setInt(1, id);
			psDelete.execute();
			psDelete.closeOnCompletion();

			super.disconnect();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Methode de mise a jour
	 * @param obj
	 * @return boolean
	 */
	public boolean update(Adherent adherent) {
		try {
			super.connect();
			PreparedStatement psUpdate = connection.prepareStatement("INSERT INTO "
					+ "ADHERENT(nom, prenom, date_naissance, rue, cp, ville, mail, telephone, pseudo, mdp, admin,"
					+ "liste_noire, droits, nb_retards, nb_non_recup)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"); 
			// On n'ajoute pas l'ID du jeu car il s'incrémente automatiquement dans la base de données
			psUpdate.setString(1, adherent.getNom());
			psUpdate.setString(2, );
			psUpdate.setDate(3, );
			psUpdate.setString(4, );
			psUpdate.setString(5, );
			psUpdate.setString(6, );
			psUpdate.setString(7, );
			psUpdate.setString(8, );
			psUpdate.setString(9, );
			psUpdate.setString(10, );
			psUpdate.setBoolean(11, );
			psUpdate.setBoolean(12, );
			psUpdate.setBoolean(13, );
			psUpdate.setInt(14, );
			psUpdate.setInt(15, );

			psUpdate.executeUpdate();
			psUpdate.closeOnCompletion();

			super.disconnect();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Methode de recherche des informations
	 * @param id
	 * @return T
	 */
	public Jeu retreive(int id) {
		try {
			super.connect();
			PreparedStatement psSelect = connection.prepareStatement("SELECT * FROM JEU WHERE id_jeu = ?");
			psSelect.setInt(1, id);
			psSelect.execute();
			psSelect.closeOnCompletion();

			ResultSet resSet = psSelect.getResultSet();
			Jeu jeu = null;
			if (resSet.next()) { // On se place sur le 1er résultat
				jeu = new Jeu(id, resSet.getString(1), resSet.getString(2), resSet.getInt(3), resSet.getString(4),
						resSet.getInt(5), resSet.getInt(6), resSet.getInt(7), resSet.getInt(8), resSet.getString(9), resSet.getString(10));
			}
			super.disconnect();
			return jeu;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}	
}
