package traitement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChoixMouvementMinimum implements ChoixAscenseur {

	/**
	 * Determine si une requete externe est sur le trajet d'un ascenseur.
	 */
	private boolean SurLeTrajet(Ascenseur ascenseur, RequeteExterne requete) {
		if ((ascenseur.getRequetes().get(0).getEtageDeLaRequete() > ascenseur.getEtageCourant())
				&& requete.getDirection().equals(Constante.KHaut())) {
			return true;
		} else if ((ascenseur.getRequetes().get(0).getEtageDeLaRequete() < ascenseur.getEtageCourant())
				&& requete.getDirection().equals(Constante.KBas())) {
			// sinon si on descend

			return true;
		} else
			return false;
	}

	/**
	 * Chosit un ascenseur de la facon la plus optimisee.
	 */
	@Override
	public void choisir() {
		Iterator<RequeteExterne> iterRequete = Controleur.getInstance().getRequetes().iterator();
		List<Ascenseur> listeAscenseursImmobiles = new ArrayList<Ascenseur>();

		// Pour chaque requete externe
		while (iterRequete.hasNext()) {
			RequeteExterne requete = iterRequete.next();

			for (Ascenseur ascenseur : Controleur.getInstance().getAscenseurs()) {
				// Si l'ascenseur est immobile
				if (ascenseur.getRequetes().size() == 0) {
					// et si c'est un ascenseur immobile se trouvant deja a l'etage
					if (ascenseur.getEtageCourant() == requete.getEtageDeLaRequete()) {
						ascenseur.ajouterRequete(requete);
						// On la supprime de la collection de requetes externes du controleur
						iterRequete.remove();
						break;
					}

					listeAscenseursImmobiles.add(ascenseur);
				} else if (SurLeTrajet(ascenseur, requete)) {
					ascenseur.ajouterRequete(requete);
					// On la supprime de la collection
					iterRequete.remove();
					break;
				}
			}
		}

		Iterator<RequeteExterne> iterRequeteNonAttribuee = Controleur.getInstance().getRequetes().iterator();
		Iterator<Ascenseur> iterAscenseurImmobiles = listeAscenseursImmobiles.iterator();

		// Tant qu'il y a des ascenseurs immobiles et des requetes non attribuees
		while ((iterAscenseurImmobiles.hasNext()) && (iterRequeteNonAttribuee.hasNext())) {
			// L'ascenseur immobile recoit une requete non attribuee
			iterAscenseurImmobiles.next().ajouterRequete(iterRequeteNonAttribuee.next());
			iterRequeteNonAttribuee.remove();
		}

		/*
		 * Il se peut qu'il reste toujours des requetes externes non attribuees. 
		 * Il faut donc appeler choisirAscenseur a chaque iteration meme si aucune
		 * nouvelle requete n'a ete saisie.
		 */
	}
}
