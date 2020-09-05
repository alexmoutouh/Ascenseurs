package traitement;

public class RequeteInterne implements Requete {

	private int etageDeLaRequete;

	public RequeteInterne(int etageDeLaRequete) {
		super();
		this.etageDeLaRequete = etageDeLaRequete;
	}

	@Override
	public String toString() {
		return "RequeteInterne [etageDeLaRequete=" + etageDeLaRequete + "]";
	}

	public int getEtageDeLaRequete() {
		return etageDeLaRequete;
	}

	@Override
	public int compareTo(Requete o) {
		return (this.etageDeLaRequete > o.getEtageDeLaRequete()) ? 1
				: (this.etageDeLaRequete == o.getEtageDeLaRequete()) ? 0 : -1;
	}

	@Override
	public String getDirection() {
		return null;
	}
}
