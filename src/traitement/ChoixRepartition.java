package traitement;

import java.util.Iterator;

public class ChoixRepartition implements ChoixAscenseur {

	/**
	 * Choisit l'attribution des requetes de sorte qu'en moyenne tous les ascenseurs
	 * aient le meme nombre de requetes (ecart-type jamais superieur a 1).
	 */
	@Override
	public void choisir() {
		// index de l'ascenseur ayant le moins de requetes : ascenseur de reference
		int indexAscenseur = 0;

		Iterator<RequeteExterne> iterRequete = Controleur.getInstance().getRequetes().iterator();
		while (iterRequete.hasNext()) {
			RequeteExterne requete = iterRequete.next();

			for (Ascenseur a : Controleur.getInstance().getAscenseurs()) {
				// si nombre de requetes de l'ascenseur < nombre de requetes de l'ascenseur
				// reference
				if (a.getRequetes().size() < Controleur.getInstance().getAscenseurs().get(indexAscenseur).getRequetes()
						.size()) {
					indexAscenseur = a.getIndex(); // il devient ce dernier
				}
			}

			// On ajoute la requete a l'ascenseur reference
			Controleur.getInstance().getAscenseurs().get(indexAscenseur).ajouterRequete(requete);
			// On supprime la requete de la collection (elle a ete attribuee)
			iterRequete.remove();
		}
	}
}
