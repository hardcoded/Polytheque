package polytheque.model.DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import polytheque.model.pojos.Adherent;
import polytheque.model.pojos.Extension;
import polytheque.model.pojos.Jeu;
import polytheque.model.pojos.Reservation;

public class ReservationDAO extends DAO {


	public boolean create(Reservation reservation, int idAdherent, int idJeu, int idJextension) {
		try {
			super.connect();
			PreparedStatement psInsert = connection.prepareStatement("INSERT INTO "
					+ "RESERVATION(date_reservation, id_adherent, id_jeu, id_extension)"
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


	public boolean update(Reservation reservation, int idAdherent, int idJeu, int idJextension, int idReservation) {
		try {

			super.connect();
			PreparedStatement psUpdate = connection.prepareStatement("UPDATE RESERVATION "
					+ "SET date_reservation = ?, id_adherent = ?, id_jeu = ?, id_extension = ?)" + " WHERE id_reservation = ?");
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


	public Reservation retreive(Adherent adherent, Date date) { 
		try {
			super.connect();
			PreparedStatement psSelect = connection.prepareStatement("SELECT * FROM `reservation` "
					+ "WHERE id_adherent = (SELECT id_adherent from adherent where pseudo = ?) "
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
	 * Methode de recuperation des reservations
	 * @return La liste de toutes les reservations
	 */
	public ArrayList<Reservation> getAll() {
		ArrayList<Reservation> toutesLesReservations = new ArrayList<>();
		try {
			super.connect(); //requete fausse � voir
			PreparedStatement psSelect = connection.prepareStatement("SELECT *, RESERVATION.id_reservation,ADHERENT.pseudo,EXTENSION.nom,JEU.nom,RESERVATION.date_reservation"
					+ "FROM RESERVATION"
					+ "JOIN ADHERENT ON ADHERENT.id_adherent = RESERVATION.id_adherent"
					+ "JOIN JEU ON JEU.id_jeu = RESERVATION.id_jeu"
					+ "JOIN EXTENSION ON EXTENSION.id_extension = RESERVATION.id_extension"
					+ "ORDER BY RESERVATION.id_reservation ASC");
			psSelect.execute();
			psSelect.closeOnCompletion();

			ResultSet resSet = psSelect.getResultSet();
			while (resSet.next()) { // On se place sur le 1er résultat				
				toutesLesReservations.add(new Reservation(resSet.getInt("id_reservation"),(Adherent)resSet.getObject("adherent"),(Jeu) resSet.getObject("jeu"),(Extension) resSet.getObject("extension"),resSet.getDate("date_reservation")));
			}
			super.disconnect();

		} catch(SQLException e) {
			e.printStackTrace();
		}
		return toutesLesReservations;
	}
}
