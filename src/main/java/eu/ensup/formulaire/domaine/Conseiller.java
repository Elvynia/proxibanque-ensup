package eu.ensup.formulaire.domaine;

public class Conseiller extends Personne {

	private boolean gerant;
	private String login;
	private String pwd;
	
	@Override
	public String toString() {
		return "Conseiller [gerant=" + gerant + ", login=" + login + ", pwd=" + pwd + "]";
	}
	public Conseiller() {
		super();
	}
	public boolean isGerant() {
		return gerant;
	}
	public void setGerant(boolean gerant) {
		this.gerant = gerant;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
