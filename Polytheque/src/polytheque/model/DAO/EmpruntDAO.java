package polytheque.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import polytheque.model.pojos.Adherent;
import polytheque.model.pojos.Extension;
import polytheque.model.pojos.Jeu;
import polytheque.model.pojos.Reservation;

public class EmpruntDAO extends DAO 
{
	/**
	 * Methode de creation
	 * @param Jeu
	 * @return boolean 
	 */
	public boolean create(Calendar dateDebut, Calendar dateFin, Reservation reservation, Adherent adherent, Jeu jeu, Extension extension) 
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
}


