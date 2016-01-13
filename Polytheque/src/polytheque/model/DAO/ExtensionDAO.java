package polytheque.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import polytheque.model.pojos.Extension;
import polytheque.model.pojos.Jeu;

/**
 * Classe permettant de manipuler des objets de type Extension dans la BDD.
 * 
 * @author Johan Brunet
 *
 */
public class ExtensionDAO extends DAO {

	/**
	 * Méthode de création d'un extension.
	 * @param extension
	 * 		L'extension à créer.
	 * @param idJeu
	 * 		L'ID du jeu associé.
	 * @return true si l'extension abien été créée, false sinon.
	 */
	public boolean create(Extension extension, int idJeu) {
		try {
			super.connect();
			PreparedStatement psInsert = connection.prepareStatement("INSERT INTO "
					+ "Extension(nom, description, statut, nombre_exemplaires, nombre_reserves, id_jeu) "
					+ "VALUES (?, ?, ?, ?, ?, ?)"); 
			// On n'ajoute pas l'ID du jeu car il s'incrémente automatiquement dans la base de données
			psInsert.setString(1, extension.getNom());
			psInsert.setString(2, extension.getDescription());
			psInsert.setString(3, extension.getStatut());
			psInsert.setInt(4, extension.getNbExemplaires());
			psInsert.setInt(5, extension.getNbReserves());
			psInsert.setString(6, extension.getNomJeu());

			psInsert.executeUpdate();
			psInsert.closeOnCompletion();

			ResultSet idResult = psInsert.getGeneratedKeys();
			if (idResult != null && idResult.next()) {
				extension.setIdExtension(idResult.getInt(1));;
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
	 * Methode pour effacer.
	 * @param id
	 * 		L'ID de l'extension à supprimer.
	 * @return true si l'extension a été supprimée, false sinon. 
	 */
	public boolean delete(int id) {
		try {
			super.connect();
			PreparedStatement psDelete = connection.prepareStatement("DELETE * FROM EXTENSION WHERE id_extension = ? "); 
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
	 * Méthode de mise à jour.
	 * @param extension
	 * 		L'extension à mettre à jour.
	 * @param idJeu
	 * 		L'ID du jeu associé à l'extension.
	 * @return true si la modification a été effectuée, false sinon.
	 */
	public boolean update(Extension extension, int idJeu) {
		try {

			super.connect();
			PreparedStatement psUpdate = connection.prepareStatement("UPDATE EXTENSION "
					+ "SET nom = ?, description = ?, statut = ?, nombre_exemplaires = ?, nombre_reserves = ?, id_jeu = ? " 
					+ " WHERE id_extension = ? ");
			psUpdate.setString(1, extension.getNom());
			psUpdate.setString(2, extension.getDescription());
			psUpdate.setString(3, extension.getStatut());
			psUpdate.setInt(4, extension.getNbExemplaires());
			psUpdate.setInt(5, extension.getNbReserves());
			psUpdate.setInt(6, idJeu);
			psUpdate.setInt(7, extension.getIdExtension());

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
	 * 			L'id de l'extension à récupérer dans la BDD
	 * @return Une Extension
	 */
	public Extension retreive(int id) {
		Extension extension = null;
		try {
			super.connect();
			PreparedStatement psSelect = connection.prepareStatement("SELECT *, JEU.nom AS nom_jeu FROM EXTENSION "
					+ "JOIN JEU ON JEU.id_jeu = EXTENSION.id_jeu "
					+ "WHERE id_extension = ?");
			psSelect.setInt(1, id);
			psSelect.execute();
			psSelect.closeOnCompletion();

			ResultSet resSet = psSelect.getResultSet();
			if (resSet.next()) { // On se place sur le 1er résultat
				extension = new Extension(id, resSet.getString("nom"), resSet.getString("description"), resSet.getString("statut"),resSet.getInt("nb_exemplaires"), resSet.getInt("nb_reserves"),resSet.getString("nom_jeu"));
			}
			super.disconnect();
			return extension;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Extension getExtByName(String nom) {
		Extension extension = null;
		try {
			super.connect();
			PreparedStatement psSelect = connection.prepareStatement("SELECT * FROM EXTENSION "
					+ "JOIN JEU ON JEU.id_jeu = EXTENSION.id_jeu "
					+ "WHERE EXTENSION.nom = ? ");
			psSelect.setString(1, nom);
			psSelect.execute();
			psSelect.closeOnCompletion();

			ResultSet resSet = psSelect.getResultSet();
			if (resSet.next()) { // On se place sur le 1er résultat
				extension = new Extension(resSet.getInt("id_extension"), nom, resSet.getString("description"), resSet.getString("statut"),resSet.getInt("nb_exemplaires"), resSet.getInt("nb_reserves"),"");
			}
			super.disconnect();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return extension;
	}

	/**
	 * Methode de recuperation des jeux
	 * @return La liste de tous les jeux
	 */
	public ArrayList<Extension> getAll() {
		ArrayList<Extension> tousLesJeux = new ArrayList<>();
		try {
			super.connect();
			PreparedStatement psSelect = connection.prepareStatement("SELECT *, JEU.nom AS nom_jeu FROM EXTENSION "
					+ "JOIN JEU ON JEU.id_jeu = EXTENSION.id_jeu "
					+ "ORDER BY EXTENSION.nom ASC ");
			psSelect.execute();
			psSelect.closeOnCompletion();

			ResultSet resSet = psSelect.getResultSet();
			while (resSet.next()) { // On se place sur le 1er résultat				
				tousLesJeux.add(new Extension(resSet.getString("nom"), resSet.getString("description"), resSet.getString("statut"), 
						resSet.getInt("nb_exemplaires"), resSet.getInt("nb_reserves"), resSet.getString("nom_jeu")));
			}
			super.disconnect();

		} catch(SQLException e) {
			e.printStackTrace();
		}
		return tousLesJeux;
	}

	/**
	 * Methode de recherche d'extension(s)
	 * @param nomExtension
	 * 			Le nom du jeu à récupérer dans la BDD
	 * @return Un jeu
	 */
	public ArrayList<Extension> searchByName(String nomExtension) {
		ArrayList<Extension> extensionsFiltres = new ArrayList<>();
		String filtre = "%" + nomExtension.toLowerCase() + "%";
		try {
			super.connect();
			PreparedStatement psSelect = connection.prepareStatement("SELECT *, JEU.nom AS nom_jeu FROM EXTENSION "
					+ "JOIN JEU ON JEU.id_jeu = EXTENSION.id_jeu "
					+ "WHERE EXTENSION.nom LIKE ? "
					+ "ORDER BY EXTENSION.nom ASC ");
			psSelect.setString(1, filtre);
			psSelect.execute();
			psSelect.closeOnCompletion();

			ResultSet resSet = psSelect.getResultSet();
			while (resSet.next()) { // On se place sur le 1er résultat
				extensionsFiltres.add(new Extension(resSet.getString("nom"), resSet.getString("description"), resSet.getString("statut"), 
						resSet.getInt("nb_exemplaires"), resSet.getInt("nb_reserves"), resSet.getString("nom_jeu")));
			}
			super.disconnect();

		} catch(SQLException e) {
			e.printStackTrace();
		}
		return extensionsFiltres;
	}
}
