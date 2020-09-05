package affichage;

import javax.swing.JFrame;

import traitement.Ascenseur;
import traitement.Controleur;

public class AffichageVC extends JFrame {

	private static final long serialVersionUID = 1L;

	private PanneauVC vueCoupe = new PanneauVC();

	public AffichageVC(int x, int y) {
		this.setTitle("IHM affichage");
		this.setSize(x, y);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(600, 200);
		this.setContentPane(vueCoupe);
		this.setVisible(true);

	}

	public void refresh() {
		for (Ascenseur a : Controleur.getInstance().getAscenseurs()) {
			a.action();
		}

		Controleur.getInstance().choisirAscenseur();
		vueCoupe.repaint();
	}
}
