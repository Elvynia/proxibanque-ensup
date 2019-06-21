package eu.ensup.formulaire.domaine;

public class Conseiller extends Personne {

	private boolean gerant;
	private String login;
	private String pwd;

	public Conseiller() {
		super();
	}

	public String getLogin() {
		return this.login;
	}

	public String getPwd() {
		return this.pwd;
	}

	public boolean isGerant() {
		return this.gerant;
	}

	public void setGerant(boolean gerant) {
		this.gerant = gerant;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "Conseiller [gerant=" + this.gerant + ", login=" + this.login + ", pwd=" + this.pwd + "]";
	}

}