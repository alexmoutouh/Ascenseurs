package traitement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChoixMouvementMinimum implements ChoixAscenseur {

	/*
	 * Permet de savoir si une requete externe est sur le trajet d'un ascenseur
	 */
	private boolean SurLeTrajet(Ascenseur ascenseur, RequeteExterne requete) {
		if ((ascenseur.getRequetes().get(0).getEtageDeLaRequete() > ascenseur
				.getEtageCourant())
				&& requete.getDirection().equals(Constante.KHaut())) {
			return true;
		// sinon si on descend 
		} else if ((ascenseur.getRequetes().get(0).getEtageDeLaRequete() < ascenseur
				.getEtageCourant())
				&& requete.getDirection().equals(Constante.KBas()))
		{

			return true;
		} else
			return false;

	}

	/*
	 * methode de choix d'ascenseur la plus optimisee
	 */
	@Override
	public void choisir() {
		Iterator<RequeteExterne> iterRequete = Controleur.getInstance()
				.getRequetes().iterator();
		List<Ascenseur> listeAscenseursImmobiles = new ArrayList<Ascenseur>();

		// Pour chaque requete externe
		while (iterRequete.hasNext()) 
		{
			RequeteExterne requete = iterRequete.next();

			// Pour chaque ascenseur
			for (Ascenseur ascenseur : Controleur.getInstance().getAscenseurs()) { 
				// Si l'ascenseur est immobile
				if (ascenseur.getRequetes().size() == 0) 
				{
					// et si c'est un ascenseur immobile se trouvant deja a l'etage
					if (ascenseur.getEtageCourant() == requete
							.getEtageDeLaRequete()) {
						// on ajoute la requete
						ascenseur.ajouterRequete(requete); 
						// On la supprime de la collection
						// de requetes externes du controleur
						iterRequete.remove(); 
						break;
					}
					// on le rajoute a la liste des ascenseurs immobiles
					listeAscenseursImmobiles.add(ascenseur); 
				}

				// sinon si la requete est sur son trajet
				else if (SurLeTrajet(ascenseur, requete))
				{
					// on l'ajoute
					ascenseur.ajouterRequete(requete); 
					// On la supprime de la collection
					iterRequete.remove(); 
					break;
				}

			}
		}

		Iterator<RequeteExterne> iterRequeteNonAttribuee = Controleur
				.getInstance().getRequetes().iterator();
		Iterator<Ascenseur> iterAscenseurImmobiles = listeAscenseursImmobiles
				.iterator();
		/*
		 * Tant qu'il y a des ascenseurs immobiles et des requetes non
		 * attribuees
		 */
		while ((iterAscenseurImmobiles.hasNext())
				&& (iterRequeteNonAttribuee.hasNext())) {
			// L'ascenseur immobile recoit une requete non attribuee
			iterAscenseurImmobiles.next().ajouterRequete(
					iterRequeteNonAttribuee.next());
			iterRequeteNonAttribuee.remove();
		}

		/*
		 * il se peut qu'il reste toujours des requetes externes non attribuees
		 * apres ca. Il faut donc appeler choisirAscenseur a chaque iteration
		 * meme si aucune nouvelle requete n'a ete saisie
		 */

	}
}
