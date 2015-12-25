package polytheque.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import polytheque.model.pojos.Jeu;

public class JeuDAO extends DAO {

	/**
	 * M�thode de cr�ation
	 * @param Jeu
	 * @return boolean 
	 */
	public boolean create(Jeu jeu, int idCategorie, int idEditeur) {
		try {
			super.connect();
			PreparedStatement psInsert = connection.prepareStatement("INSERT INTO "
					+ "JEU(nom, description, annee_parution, statut, nombre_exemplaires, nombre_reserves,"
					+ "age_mini, nombre_joueurs, id_categorie, id_editeur)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"); 
			// On n'ajoute pas l'ID du jeu car il s'incrémente automatiquement dans la base de données
			psInsert.setString(1, jeu.getNom());
			psInsert.setString(2, jeu.getDescription());
			psInsert.setInt(3, jeu.getAnneeParution());
			psInsert.setString(4, jeu.getStatut());
			psInsert.setInt(5, jeu.getNbExemplaires());
			psInsert.setInt(6, jeu.getNbReserves());
			psInsert.setInt(7, jeu.getAgeMini());
			psInsert.setInt(8, jeu.getNbJoueurs());
			psInsert.setInt(9, idCategorie);
			psInsert.setInt(10, idEditeur);

			psInsert.executeUpdate();

			ResultSet idResult = psInsert.getGeneratedKeys();
			if (idResult != null && idResult.next()) {
				jeu.setIdJeu(idResult.getInt(1));;
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
	 * M�thode pour effacer
	 * @param Jeu
	 * @return boolean 
	 */
	public boolean delete(int id) {
		try {
			super.connect();
			PreparedStatement psDelete = connection.prepareStatement("DELETE * FROM JEU WHERE id_jeu = ?"); 
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
	 * M�thode de mise � jour
	 * @param obj
	 * @return boolean
	 */
	public boolean update(Jeu jeu, int idCategorie, int idEditeur) {
		try {

			super.connect();
			PreparedStatement psUpdate = connection.prepareStatement("UPDATE JEU "
					+ "SET nom = ?, description = ?, annee_parution = ?, statut = ?, nombre_exemplaires = ?,"
					+ "nombre_reserves = ?, age_mini = ?, nombre_joueurs = ?, id_categorie = ?, id_editeur = ?)" 
					+ " WHERE jeu_id = ?");
			psUpdate.setString(1, jeu.getNom());
			psUpdate.setString(2, jeu.getDescription());
			psUpdate.setInt(3, jeu.getAnneeParution());
			psUpdate.setString(4, jeu.getStatut());
			psUpdate.setInt(5, jeu.getNbExemplaires());
			psUpdate.setInt(6, jeu.getNbReserves());
			psUpdate.setInt(7, jeu.getAgeMini());
			psUpdate.setInt(8, jeu.getNbJoueurs());
			psUpdate.setInt(9, idCategorie);
			psUpdate.setInt(10, idEditeur);
			
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
	 * M�thode de recherche des informations
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


