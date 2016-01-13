package polytheque.model.DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import polytheque.model.pojos.Adherent;
import polytheque.model.pojos.Emprunt;
import polytheque.model.pojos.Extension;
import polytheque.model.pojos.Jeu;
import polytheque.model.pojos.Reservation;

/**
 * Classe permettant de manipuler des objets de type Emprunt dans la BDD.
 * 
 * @author Johan Brunet, San Wei Lee
 *
 */
public class EmpruntDAO extends DAO 
{
	/**
	 * Méthode de création
	 * @param dateDebut
	 * @param dateFin
	 * @param reservation
	 * @param adherent
	 * @param jeu
	 * @param extension
	 * @return
	 */
	public boolean create(Date dateDebut, Date dateFin, Reservation reservation, Adherent adherent, Jeu jeu, Extension extension) 
	{
		try 
		{
			super.connect();
			PreparedStatement psInsert = connection.prepareStatement("INSERT INTO "
					+"EMPRUNT(dateDebut, dateFin, dateRendu, id_reservation, id_adherent, id_jeu, id_extension)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?)");
			// On n'ajoute pas l'ID car il s'incrémente automatiquement dans la base de données
			psInsert.setDate(1, dateDebut);
			psInsert.setDate(2, dateFin);
			psInsert.setDate(3, null);
			psInsert.setInt(4, reservation.getIdReservation());
			psInsert.setInt(5, adherent.getIdAdherent());
			psInsert.setInt(6, jeu.getIdJeu());
			psInsert.setInt(7, extension.getIdExtension());

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
	 * suppression de la reservation par son id dans la base de donn�es
	 * @param id
	 * @return
	 */
	public boolean delete(int id) {
		try {
			super.connect();
			PreparedStatement psDelete = connection.prepareStatement("DELETE * FROM EMPRUNT WHERE id_emprunt = ?"); 
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
	 * 
	 * @param emprunt
	 * @param idReservation
	 * @param idAdherent
	 * @param idJeu
	 * @param idExtension
	 * @param idEmprunt
	 * @return
	 */
	public boolean update(Emprunt emprunt, int idReservation, int idAdherent, int idJeu, int idExtension, int idEmprunt) {
		try {

			super.connect();
			PreparedStatement psUpdate = connection.prepareStatement("UPDATE EMPRUNT "
					+ "SET date_debut = ?, date_fin = ?, date_rendu = ?, id_reservation = ?, id_adherent = ?, id_jeu = ?, id_extension = ?)" + " WHERE id_emprunt = ?");
			psUpdate.setDate(1, emprunt.getDateDebut());
			psUpdate.setDate(2, emprunt.getDateFin());
			psUpdate.setDate(3, emprunt.getDateRendu());
			psUpdate.setInt(4, idReservation);
			psUpdate.setInt(5, idAdherent);
			psUpdate.setInt(6, idJeu);
			psUpdate.setInt(7, idExtension);
			psUpdate.setInt(8, idEmprunt);


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
	 * resupere un emprunt avec son id � partir de la base de donn�es
	 * @param idEmprunt
	 * @return
	 */
	public Emprunt retreive(int idEmprunt) {
		try {
			super.connect();
			PreparedStatement psSelect = connection.prepareStatement("SELECT * FROM EMPRUNT WHERE id_emprunt = ?");
			psSelect.setInt(1, idEmprunt);
			psSelect.execute();
			psSelect.closeOnCompletion();

			ResultSet resSet = psSelect.getResultSet();
			Emprunt emprunt = null; 
			if (resSet.next()) { // On se place sur le 1er résultat
				emprunt = new Emprunt(idEmprunt, resSet.getDate("date_debut"), resSet.getDate("date_fin"), resSet.getDate("date_rendu"), resSet.getInt("id_adherent"));
			}
			super.disconnect();
			return emprunt;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}


