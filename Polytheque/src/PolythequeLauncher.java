import polytheque.controller.PolythequeApplication;
import polytheque.view.TacheDAffichage;

/**
 * Classe permettant de lancer l'application
 * @author Johan Brunet
 *
 */
public class PolythequeLauncher {

	/**
	 * Création du controller et de la view
	 * @param args
	 */
	public static void main(String[] args) {
		PolythequeApplication polythequeApplication = new PolythequeApplication();
		TacheDAffichage tacheDAffichageDeLApplication = new TacheDAffichage(polythequeApplication);
		polythequeApplication.associerTacheDAffichage(tacheDAffichageDeLApplication);
		tacheDAffichageDeLApplication.run();
	}
}
