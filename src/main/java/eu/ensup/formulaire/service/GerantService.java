package eu.ensup.formulaire.service;

import java.util.ArrayList;

import eu.ensup.formulaire.dao.GerantDao;
import eu.ensup.formulaire.domaine.Personne;

public class GerantService {

	GerantDao gerantDao = new GerantDao();

	// Renvoie la liste des conseillers
	public ArrayList<Personne> listeDesConseillers() {

		ArrayList<Personne> listePersonnes = new ArrayList<>();
		listePersonnes = this.gerantDao.listeDesConseillers();
		return listePersonnes;
	}
}
