package polytheque.model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe abstraite permettant de gérer la connexion à la base de données (BDD)
 * 
 * @author Johan Brunet
 */
public abstract class DAO {

	/**
	 * Attribut représentant la connexion à la BDD.
	 * Trois états possibles :
	 * <ul>
	 * 	<li> Null : connexion non existante </li>
	 * 	<li> Fermée : connexion existante mais inutilisable </li>
	 * 	<li> Ouverte : connexion existante et exploitable </li>
	 * </ul>
	 */
	protected static Connection connection;

	/**
	 * Pilote JDBC à utiliser pour se connecter à la BDD (ici mySQL)
	 */
	private final static String DRIVER = "com.mysql.jdbc.Driver";

	/**
	 * URL utilisée par JDBC pour accéder à la BDD
	 */
	private final static String URL = "jdbc:mysql://localhost:3306/polytheque";

	/**
	 * Nom d'utilisateur à utiliser pour se connecter à la BDD
	 */
	private final static String USER_NAME = "root";

	/**
	 * Mot de passe pour se connecter à la BDD
	 */
	private final static String PASSWORD = "";

	/**
	 * Vérifie si le pilote JDBC spécifié existe bien dans l'application
	 * 
	 * @return true 
	 * 			le pilote JDBC est bien présent dans l'application
	 * @return false 
	 * 			le pilote JDBC n'a pas été trouvé
	 */
	public boolean checkDriver() {
		try {
			Class.forName(DRIVER);
			return true;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Ouvre une connexion à la base de données avec à l'URL, 
	 * le nom d'utilisateur et le mot de passe spécifiés
	 */
	protected void connect() {
		try {
			if (connection == null || connection.isClosed()) {
				connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Ferme la connexion à la base de données
	 */
	protected void disconnect() {
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}