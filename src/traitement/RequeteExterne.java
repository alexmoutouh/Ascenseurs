package traitement;

public class RequeteExterne implements Requete {

	private int etageDeLaRequete;
	private String direction; // Constant.KMonter ou Constante.KDescendre

	public RequeteExterne(int etageDeLaRequete, String direction) {
		super();
		this.etageDeLaRequete = etageDeLaRequete;
		this.direction = direction;
	}

	public int getEtageDeLaRequete() {
		return this.etageDeLaRequete;
	}

	public String getDirection() {
		return this.direction;
	}

	@Override
	public String toString() {
		return "RequeteExterne [etageDeLaRequete=" + etageDeLaRequete + ", direction=" + direction + "]";
	}

	@Override
	public int compareTo(Requete o) {
		return (this.etageDeLaRequete > o.getEtageDeLaRequete()) ? 1
				: (this.etageDeLaRequete == o.getEtageDeLaRequete()) ? 0 : -1;
	}
}
