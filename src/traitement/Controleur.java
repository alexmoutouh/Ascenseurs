package traitement;

import java.util.ArrayList;
import java.util.List;

public class Controleur {
	private List<RequeteExterne> requetes = new ArrayList<RequeteExterne>();
	private ArrayList<Ascenseur> ascenseurs = new ArrayList<Ascenseur>();
	private static Controleur INSTANCE;

	/**
	 * Strategie de selection de l'ascenseur.
	 */
	private ChoixAscenseur choix = new ChoixMouvementMinimum();

	private Controleur() {
	}

	public static Controleur getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Controleur();
		}

		return INSTANCE;
	}

	public void creerRequeteExterne(int etageDeLaRequete, String direction) {
		RequeteExterne nouvelleRequeteExterne = new RequeteExterne(etageDeLaRequete, direction);
		this.requetes.add(nouvelleRequeteExterne);
	}

	/**
	 * Ajoute ascenseur au tableau du controleur et renvoie l'indice qu'il a dans ce
	 * tableau : son index.
	 */
	public int ajouterAscenseur(Ascenseur ascenseur) {
		this.ascenseurs.add(ascenseur);
		return (this.ascenseurs.size() - 1);
	}

	// Pattern Strategie {
	public void choisirAscenseur() {
		choix.choisir(); // appel de l'algo de selection d'ascenseur
	}

	public void changerCritereChoix(ChoixAscenseur typeChoix) {
		choix = typeChoix;
	}
	// } Strategie

	public List<Ascenseur> getAscenseurs() {
		return this.ascenseurs;
	}

	public List<RequeteExterne> getRequetes() {
		return this.requetes;
	}
}
