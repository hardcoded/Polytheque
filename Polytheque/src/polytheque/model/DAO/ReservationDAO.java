package polytheque.model.DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import polytheque.model.pojos.Adherent;
import polytheque.model.pojos.Reservation;

public class ReservationDAO extends DAO {

	/**
	 * méthode permettant de créer une réservation dans la base de données
	 * @param reservation
	 * @param idAdherent
	 * @param idJeu
	 * @param idJextension
	 * @return
	 */
	public boolean create(Reservation reservation, int idAdherent, int idJeu, int idJextension) {
		try {
			super.connect();
			PreparedStatement psInsert = connection.prepareStatement("INSERT INTO "
					+ "RESERVATION(date_reservation, id_adherent, id_jeu, id_extension) "
					+ "VALUES (?, ?, ?, ?)"); 

			psInsert.setDate(1, reservation.getDate()); //A voir pcq return type"date"
			psInsert.setInt(2, idAdherent);
			psInsert.setInt(3, idJeu);
			psInsert.setInt(4, idJextension);

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
	 * Creation de reservation sans extention
	 * @param reservation
	 * @param idAdherent
	 * @param idJeu
	 * @return
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
	 * Créeation de reservation sans jeu
	 * @param reservation
	 * @param idAdherent
	 * @param idExtention
	 * @return
	 */
	public boolean create3(Reservation reservation, int idAdherent, int idExtention) {
		try {
			super.connect();
			PreparedStatement psInsert = connection.prepareStatement("INSERT INTO "
					+ "RESERVATION(date_reservation, id_adherent, id_extension) "
					+ "VALUES (?, ?, ?)",Statement.RETURN_GENERATED_KEYS); 

			psInsert.setDate(1, reservation.getDate()); //A voir pcq return type"date"
			psInsert.setInt(2, idAdherent);
			psInsert.setInt(3, idExtention);
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
	 * suppression d'une réservation dans la base de données par son id
	 * @param id
	 * @return
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
	 * 
	 * @param reservation
	 * @param idAdherent
	 * @param idJeu
	 * @param idJextension
	 * @param idReservation
	 * @return
	 */
	public boolean update(Reservation reservation, int idAdherent, int idJeu, int idJextension, int idReservation) {
		try {

			super.connect();
			PreparedStatement psUpdate = connection.prepareStatement("UPDATE RESERVATION "
					+ "SET date_reservation = ?, id_adherent = ?, id_jeu = ?, id_extension = ? " 
					+ " WHERE id_reservation = ?");
			psUpdate.setDate(1, reservation.getDate());
			psUpdate.setInt(2, idAdherent);
			psUpdate.setInt(3, idJeu);
			psUpdate.setInt(4, idJextension);
			psUpdate.setInt(5, idReservation);


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
	 * permet de récupérer une reservation depuis la base de données à partir d'un adherent et de la date
	 * @param adherent
	 * @param date
	 * @return
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
			if (resSet.next()) { // On se place sur le 1er rÃ©sultat
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
	 * Methode de recuperation des reservations
	 * @return La liste de toutes les reservations
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
				//while (resSet.next()) { // On se place sur le 1er rÃ©sultat				
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
	 * permet de récupérer toutes les réeservations d'un adherent en particulier
	 * @param pseudo
	 * @return
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
			if (resSet.next()) { // On se place sur le 1er rÃ©sultat
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

	public Reservation getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
