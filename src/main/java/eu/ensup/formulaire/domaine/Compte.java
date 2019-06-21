package eu.ensup.formulaire.domaine;

import java.sql.Date;

public class Compte {

	private String numCompte;
	private Float solde;
	private Date dateOuverture;
	private boolean type;

	public Compte() {
		super();
	}

	public Compte(String numCompte, Float solde, Date dateOuverture, boolean type) {
		super();
		this.numCompte = numCompte;
		this.solde = solde;
		this.dateOuverture = dateOuverture;
		this.type = type;
	}

	public Date getDateOuverture() {
		return this.dateOuverture;
	}

	public String getNumCompte() {
		return this.numCompte;
	}

	public float getSolde() {
		return this.solde;
	}

	public boolean isType() {
		return this.type;
	}

	public void setDateOuverture(Date dateOuverture) {
		this.dateOuverture = dateOuverture;
	}

	public void setNumCompte(String numCompte) {
		this.numCompte = numCompte;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}

	public void setType(boolean type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Compte [numCompte=" + this.numCompte + ", solde=" + this.solde + ", dateOuverture=" + this.dateOuverture
				+ ", type=" + this.type + "]";
	}

}