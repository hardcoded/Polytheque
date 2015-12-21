package polytheque.view;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class PolythequeApplication extends JFrame {

	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 500;
	public static final String APPLICATION_TITLE = "Polytheque";

	public PolythequeApplication() {
		
	}
	
	public void run() {
		this.makeGUI();
		this.setVisible(true);
	}

	public void makeGUI() {
		this.setTitle(APPLICATION_TITLE);
		this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		
	}

}
