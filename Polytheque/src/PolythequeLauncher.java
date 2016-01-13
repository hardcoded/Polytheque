import polytheque.controller.PolythequeApplication;
import polytheque.view.TacheDAffichage;

/**
 * Classe permettant l'éxecution du programme
 * @author Johan Brunet
 *
 */
public class PolythequeLauncher {

	public static void main(String[] args) {
		PolythequeApplication polythequeApplication = new PolythequeApplication();
		TacheDAffichage tacheDAffichageDeLApplication = new TacheDAffichage(polythequeApplication);
		polythequeApplication.associerTacheDAffichage(tacheDAffichageDeLApplication);
		tacheDAffichageDeLApplication.run();
	}
}
