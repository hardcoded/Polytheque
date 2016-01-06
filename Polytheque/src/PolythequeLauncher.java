import polytheque.controller.PolythequeApplication;
import polytheque.view.TacheDAffichage;

public class PolythequeLauncher {

	public static void main(String[] args) {
		PolythequeApplication polythequeApplication = new PolythequeApplication();
		TacheDAffichage tacheDAffichageDeLApplication = new TacheDAffichage(polythequeApplication);
		polythequeApplication.associerTacheDAffichage(tacheDAffichageDeLApplication);
		tacheDAffichageDeLApplication.run();
	}
}
