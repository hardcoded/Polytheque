package polytheque.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import polytheque.model.pojos.Jeu;

public class JeuDAO extends DAO {

	/**
	 * Methode de creation
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
			psInsert.setString(3, jeu.getAnneeParution());
			psInsert.setString(4, jeu.getStatut());
			psInsert.setInt(5, jeu.getNbExemplaires());
			psInsert.setInt(6, jeu.getNbReserves());
			psInsert.setInt(7, jeu.getAgeMini());
			psInsert.setInt(8, jeu.getNbJoueurs());
			psInsert.setInt(9, idCategorie);
			psInsert.setInt(10, idEditeur);

			psInsert.executeUpdate();
			psInsert.closeOnCompletion();

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
	 * Methode pour effacer
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
	 * Methode de mise a jour
	 * @param obj
	 * @return boolean
	 */
	public boolean update(Jeu jeu, int idCategorie, int idEditeur) {
		try {

			super.connect();
			PreparedStatement psUpdate = connection.prepareStatement("UPDATE JEU "
					+ "SET nom = ?, description = ?, annee_parution = ?, statut = ?, nombre_exemplaires = ?,"
					+ "nombre_reserves = ?, age_mini = ?, nombre_joueurs = ?, id_categorie = ?, id_editeur = ?)" 
					+ " WHERE id_jeu = ?");
			psUpdate.setString(1, jeu.getNom());
			psUpdate.setString(2, jeu.getDescription());
			psUpdate.setString(3, jeu.getAnneeParution());
			psUpdate.setString(4, jeu.getStatut());
			psUpdate.setInt(5, jeu.getNbExemplaires());
			psUpdate.setInt(6, jeu.getNbReserves());
			psUpdate.setInt(7, jeu.getAgeMini());
			psUpdate.setInt(8, jeu.getNbJoueurs());
			psUpdate.setInt(9, idCategorie);
			psUpdate.setInt(10, idEditeur);
			psUpdate.setInt(11, jeu.getIdJeu());

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
	 * 			L'id du jeu à récupérer dans la BDD
	 * @return Un jeu
	 */
	public Jeu retreive(int id) {
		try {
			super.connect();
			PreparedStatement psSelect = connection.prepareStatement("SELECT *, CATEGORIE.nom as nom_categorie, EDITEUR.nom as nom_editeur FROM JEU"
					+ "JOIN CATEGORIE ON CATEGORIE.id_categorie = JEU.id_categorie"
					+ "JOIN EDITEUR ON EDITEUR.id_editeur = JEU.id_editeur"
					+ "WHERE id_jeu = ?");
			psSelect.setInt(1, id);
			psSelect.execute();
			psSelect.closeOnCompletion();

			ResultSet resSet = psSelect.getResultSet();
			Jeu jeu = null;
			if (resSet.next()) { // On se place sur le 1er résultat
				jeu = new Jeu(id, resSet.getString("nom"), resSet.getString("description"), resSet.getString("annee_parution"), resSet.getString("statut"),
						resSet.getInt("nb_exemplaires"), resSet.getInt("nb_reserves"), resSet.getInt("age_mini"), resSet.getInt("nb_joueurs"), 
						resSet.getString("nom_categorie"), resSet.getString("nom_editeur"));
			}
			super.disconnect();
			return jeu;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}


