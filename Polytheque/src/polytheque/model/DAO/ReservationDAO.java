package polytheque.model.DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import polytheque.model.pojos.Adherent;
import polytheque.model.pojos.Reservation;

/**
 * Classe permettant de manipuler des objets de type Reservation dans la BDD.
 * 
 * @author Johan Brunet
 *
 */
public class ReservationDAO extends DAO {

	/**
	 * Méthode permettant de créer une réservation dans la base de données.
	 * @param reservation
	 * 		La réservation à créer.
	 * @param idAdherent
	 * 		L'ID de l'adhérent associé.
	 * @param idJeu
	 * 		L'ID du jeu réservé.
	 * @param idExtension
	 * 		L'ID de l'extension réservée.
	 * @return true si la création a été effectuée, false sinon.
	 */
	public boolean create(Reservation reservation, int idAdherent, int idJeu, int idExtension) {
		try {
			super.connect();
			PreparedStatement psInsert = connection.prepareStatement("INSERT INTO "
					+ "RESERVATION(date_reservation, id_adherent, id_jeu, id_extension) "
					+ "VALUES (?, ?, ?, ?)"); 

			psInsert.setDate(1, reservation.getDate()); //A voir pcq return type"date"
			psInsert.setInt(2, idAdherent);
			psInsert.setInt(3, idJeu);
			psInsert.setInt(4, idExtension);

			psInsert.executeUpdate();

			ResultSet idResult = psInsert.getGeneratedKeys();
			if (idResult != null && idResult.next()) {
				reservation.setIdReservation(idResult.getInt(1));; 
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
	 * Creation de reservation sans extension.
	 * @param reservation
	 * 		La réservation à créer.
	 * @param idAdherent
	 * 		L'ID de l'adhérent associé.
	 * @param idJeu
	 * 		L'ID du jeu réservé.
	 * @return true si la création a été effectuée, false sinon.
	 */
	public boolean create2(Reservation reservation, int idAdherent, int idJeu) {
		try {
			super.connect();
			PreparedStatement psInsert = connection.prepareStatement("INSERT INTO "
					+ "RESERVATION(date_reservation, id_adherent, id_jeu ) "
					+ "VALUES (?, ?, ? )",Statement.RETURN_GENERATED_KEYS); 

			psInsert.setDate(1, reservation.getDate()); //A voir pcq return type"date"
			psInsert.setInt(2, idAdherent);
			psInsert.setInt(3, idJeu);
			psInsert.executeUpdate();

			ResultSet idResult = psInsert.getGeneratedKeys();
			;
			if (idResult != null && idResult.next()) {
				reservation.setIdReservation(idResult.getInt(1));; 
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
	 * Creation de reservation sans jeu.
	 * @param reservation
	 * 		La réservation à créer.
	 * @param idAdherent
	 * 		L'ID de l'adhérent associé.
	 * @param idExtension
	 * 		L'ID de l'extension réservée.
	 * @return true si la création a été effectuée, false sinon.
	 */
	public boolean create3(Reservation reservation, int idAdherent, int idExtension) {
		try {
			super.connect();
			PreparedStatement psInsert = connection.prepareStatement("INSERT INTO "
					+ "RESERVATION(date_reservation, id_adherent, id_extension) "
					+ "VALUES (?, ?, ?)",Statement.RETURN_GENERATED_KEYS); 

			psInsert.setDate(1, reservation.getDate()); //A voir pcq return type"date"
			psInsert.setInt(2, idAdherent);
			psInsert.setInt(3, idExtension);
			psInsert.executeUpdate();

			ResultSet idResult = psInsert.getGeneratedKeys();

			if (idResult != null && idResult.next()) {
				reservation.setIdReservation(idResult.getInt(1));; 
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
	 * Suppression d'une réservation dans la base de données par son id.
	 * @param id
	 * 		L'ID de la réservation à supprimer.
	 * @return true si la suppression a été effectuée, false sinon.
	 */
	public boolean delete(int id) {
		try {
			super.connect();
			PreparedStatement psDelete = connection.prepareStatement("DELETE * FROM RESERVATION WHERE id_reservation = ?"); 
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
	 * Méthode permettant de créer une réservation dans la base de données.
	 * @param reservation
	 * 		La réservation à modifier.
	 * @param idAdherent
	 * 		L'ID de l'adhérent associé.
	 * @param idJeu
	 * 		L'ID du jeu réservé.
	 * @param idExtension
	 * 		L'ID de l'extension réservée.
	 * @return true si la modification a été effectuée, false sinon.
	 */
	public boolean update(Reservation reservation, int idAdherent, int idJeu, int idExtension) {
		try {

			super.connect();
			PreparedStatement psUpdate = connection.prepareStatement("UPDATE RESERVATION "
					+ "SET date_reservation = ?, id_adherent = ?, id_jeu = ?, id_extension = ? " 
					+ " WHERE id_reservation = ?");
			psUpdate.setDate(1, reservation.getDate());
			psUpdate.setInt(2, idAdherent);
			psUpdate.setInt(3, idJeu);
			psUpdate.setInt(4, idExtension);
			psUpdate.setInt(5, reservation.getIdReservation());

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
	 * Récupérer une réservation depuis la base de données à partir d'un adhérent et de la date
	 * @param adherent
	 * 		L'adhérent dont on cherche la réservation
	 * @param date
	 * 		La date de la réservation que l'on cherche
	 * @return La réseration correspondante
	 */
	public Reservation retreive(Adherent adherent, Date date) { 
		try {
			super.connect();
			PreparedStatement psSelect = connection.prepareStatement("SELECT * FROM RESERVATION "
					+ "WHERE id_adherent = (SELECT id_adherent from adherent where pseudo = ? "
					+ "AND date_reservation = ?");
			psSelect.setString(1, adherent.getPseudo());
			psSelect.setDate(2, date);
			psSelect.execute();
			psSelect.closeOnCompletion();

			ResultSet resSet = psSelect.getResultSet();
			Reservation reservation = null;
			if (resSet.next()) { // On se place sur le 1er résultat
				reservation = new Reservation(resSet.getInt("id_reservation"), resSet.getDate("date_reservation"), resSet.getInt("id_adherent"));
			}
			super.disconnect();
			return reservation;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Méthode de récuperation des réservations
	 * @return La liste de toutes les réservations
	 */
	public ArrayList<Reservation> getAll() {
		ArrayList<Reservation> toutesLesReservations = new ArrayList<>();
		try {
			super.connect();
			PreparedStatement psSelect = connection.prepareStatement("SELECT * FROM RESERVATION");
			psSelect.execute();
			psSelect.closeOnCompletion();

			ResultSet resSet = psSelect.getResultSet();

			if (resSet.next()) {
				//while (resSet.next()) { // On se place sur le 1er résultat				
				toutesLesReservations.add(new Reservation(resSet.getInt("id_adherent"), resSet.getInt("id_jeu"), resSet.getInt("id_extension"), resSet.getDate("date_reservation")));
				//}
			}
			super.disconnect();

		} catch(SQLException e) {
			e.printStackTrace();
		}
		return toutesLesReservations;
	}

	/**
	 * Récupérer toutes les réeservations d'un adhérent en particulier
	 * @param pseudo
	 * 		Le pseudo de l'adhérent dont on cherche les réservations
	 * @return La liste des réservations de l'adhérent
	 */
	public ArrayList<Reservation> searchByPseudo(String pseudo)
	{
		ArrayList<Reservation> reserv = new ArrayList<>();
		try {
			super.connect();
			PreparedStatement psSelect = connection.prepareStatement("SELECT * FROM RESERVATION "
					+ "WHERE id_adherent = (SELECT id_adherent FROM ADHERENT WHERE pseudo = ?)");
			psSelect.setString(1, pseudo);
			psSelect.execute();
			psSelect.closeOnCompletion();

			ResultSet resSet = psSelect.getResultSet();
			if (resSet.next()) { // On se place sur le 1er résultat
				while (resSet.next()) {
					reserv.add(new Reservation(resSet.getInt("id_reservation"), resSet.getInt("id_adherent"), resSet.getInt("id_jeu"), resSet.getInt("id_extension"), resSet.getDate("date_reservation")));
				}
			}
			super.disconnect();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return reserv;
	}

	/**
	 * Méthode permettant de retrouver la liste des réservations par l'ID de l'adhérent
	 * @param id
	 * 		L'ID de l'adhérent dont on cherche les réservations
	 * @return Les réservations correspondantes
	 */
	public Reservation getById(int id) {
		return null;
	}
}
