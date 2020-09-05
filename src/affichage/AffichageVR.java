package affichage;

import javax.swing.JFrame;

public class AffichageVR extends JFrame {

	private static final long serialVersionUID = 1L;

	private PanneauVR vueRequete = new PanneauVR();

	public AffichageVR() {
		this.setTitle("Requetes");
		this.setSize(500, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(50, 400);

		this.setContentPane(vueRequete);
		this.setVisible(true);
	}

	public void refresh() {
		vueRequete.repaint();
	}
}
