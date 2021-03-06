package traitement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Tri optimise par rapport a la premiere requete du tableau. Il minimise les
 * mouvements en traitant toutes les requetes pouvant etre satisfaites dans la
 * direction de la premiere requete, puis toutes les autres. Dans le pire des
 * cas, on execute toutes les requetes en une montee puis descente ou
 * inversement
 */
public class TriRequeteOptimise implements TriRequete {

	@Override
	public void trier(IAscenseur ascenseur) {
		String direction = null;

		// Si l'asc a des requetes on compare l'etage courant a la 1ere requete
		if (ascenseur.getAscenseur().getRequetes().size() != 0) {
			direction = (ascenseur.getAscenseur().getRequetes().get(0).getEtageDeLaRequete() > ascenseur.getAscenseur()
					.getEtageCourant()) ? "monter"
							: (ascenseur.getAscenseur().getRequetes().get(0).getEtageDeLaRequete() == ascenseur
									.getAscenseur().getEtageCourant()) ? "ouvrir" : "descendre";
		}

		List<Requete> ReqMonte = new ArrayList<Requete>();
		List<Requete> ReqDescend = new ArrayList<Requete>();

		if (direction != "ouvrir") { // si l'asc doit se deplacer
			for (Requete req : ascenseur.getAscenseur().getRequetes()) {
				if (req.getEtageDeLaRequete() > ascenseur.getAscenseur().getEtageCourant()) { // cas monter
					ReqMonte.add(req);
				} else if (req.getEtageDeLaRequete() < ascenseur.getAscenseur().getEtageCourant()) { // cas descendre
					ReqDescend.add(req);
				} else {
					// rappel : on doit se deplacer ;
					// cas etage destination = etage courant du moment initial
					if (direction == "monter") { // si on est en train de monter
						ReqDescend.add(req);
					} else if (direction == "descendre") { // si on est en train de descendre
						ReqMonte.add(req);
					}
				}
			}

			Collections.sort(ReqMonte, new Comparator<Requete>() { // on trie par ordre croissant
				@Override
				public int compare(Requete req1, Requete req2) {
					return req1.compareTo(req2);
				}
			});

			Collections.sort(ReqDescend, new Comparator<Requete>() { // on trie par ordre decroissant
				@Override
				public int compare(Requete req1, Requete req2) {
					return req2.compareTo(req1);
				}
			});

			ascenseur.getAscenseur().getRequetes().removeAll(ascenseur.getAscenseur().getRequetes());

			if (direction == "monter") {
				ascenseur.getAscenseur().getRequetes().addAll(ReqMonte);
				ascenseur.getAscenseur().getRequetes().addAll(ReqDescend);
			} else {
				ascenseur.getAscenseur().getRequetes().addAll(ReqDescend);
				ascenseur.getAscenseur().getRequetes().addAll(ReqMonte);
			}
		}
	}
}
