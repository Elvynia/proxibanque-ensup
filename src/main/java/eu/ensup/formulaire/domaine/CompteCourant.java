package eu.ensup.formulaire.domaine;

public class CompteCourant extends Compte {

	private float decouvert;

	public CompteCourant(float decouvert) {
		super();
		this.decouvert = decouvert;
	}

	public float getDecouvert() {
		return this.decouvert;
	}

	public void setDecouvert(float decouvert) {
		this.decouvert = decouvert;
	}

	@Override
	public String toString() {
		return "CompteCourant [decouvert=" + this.decouvert + "]";
	}

}