package eu.ensup.formulaire.domaine;

public class Personne {

	private String id;
	private String nom;
	private String prenom;
	private String adresse;
	private int codePostal;
	private String ville;
	private int telephone;

	public Personne() {
		super();
	}

	public Personne(String id, String nom, String prenom, String adresse, int codePostal, String ville, int telephone) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.telephone = telephone;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public int getCodePostal() {
		return this.codePostal;
	}

	public String getId() {
		return this.id;
	}

	public String getNom() {
		return this.nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public int getTelephone() {
		return this.telephone;
	}

	public String getVille() {
		return this.ville;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "Personne [id=" + this.id + ", nom=" + this.nom + ", prenom=" + this.prenom + ", adresse=" + this.adresse
				+ ", codePostal=" + this.codePostal + ", ville=" + this.ville + ", telephone=" + this.telephone + "]";
	}

}
