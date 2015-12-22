package polytheque.model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;

/**
 * Classe abstraite permettant de gérer la connexion à la base de données (BDD)
 */
public abstract class DAO {

	/**
	 * Pilote JDBC à utiliser pour se connecter à la BDD (ici mySQL)
	 */
	private String driver;

	/**
	 * URL utilisée par JDBC pour accéder à la BDD
	 */
	private String url;
	
	/**
	 * Nom d'utilisateur à utiliser pour se connecter à la BDD
	 */
	private String username;
	
	/**
	 * Mot de passe pour se connecter à la BDD
	 */
	private String password;
	
	/**
	 * Attribut représentant la connexion à la BDD.
	 * Trois états possibles :
	 * <ul>
	 * 		<li> Null : connexion non existante </li>
	 * 		<li> Fermée : connexion existante mais inutilisable </li>
	 * 		<li> Ouverte : connexion existante et exploitable </li>
	 * </ul>
	 */
	protected static Connection connection;

	/**
	 * Fichier de configuration
	 */
	private static final String CONFIG_FILE = "config.xml";
	
	/**
	 * Attribut pour la lecture de la configuration dans le fichier config.xml
	 */
	private XMLConfiguration configReader;
	
	/**
	 * Vérifie si le pilote JDBC spécifié existe bien dans l'application
	 * 
	 * @return true 
	 * 				le pilote JDBC est bien présent dans l'application
	 * @return false 
	 * 				le pilote JDBC n'a pas été trouvé
	 */
	public boolean checkDriver() {
		try {
			Class.forName(driver);
			return true;
		} catch (ClassNotFoundException exception) {
			return false;
		}
	}

	/**
	 * Ouvre une connexion à la base de données grâce à l'URL spécifiée
	 */
	protected void connect() {
		try {
			if (connection == null || connection.isClosed()) {
				connection = DriverManager.getConnection(url, username, password);
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
	
	public void readConfig() {
		try {
			configReader = new XMLConfiguration(CONFIG_FILE);
			this.driver = configReader.getString("driver");
			this.url = configReader.getString("url");
			this.username = configReader.getString("username");
			this.password = configReader.getString("password");
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
		
	}

}