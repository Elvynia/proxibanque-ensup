package eu.ensup.formulaire.service;

import java.util.ArrayList;

import eu.ensup.formulaire.dao.ConseillerDao;
import eu.ensup.formulaire.domaine.Compte;
import eu.ensup.formulaire.domaine.Personne;

public class ConseillerService {

	private ConseillerDao conseillerDao;

	public ConseillerService() {
		this.conseillerDao = new ConseillerDao();
	}

	public boolean creationClient(Personne personne, String idConseiller) {
		return conseillerDao.creationClient(personne, idConseiller);
	}

	public Personne afficherInfoClient(String id) {
		return conseillerDao.afficherInfoClient(id);
	}

	public boolean modificationClient(Personne personne) {
		return conseillerDao.modificationClient(personne);
	}

	public boolean suppressionClient(String id) {
		return conseillerDao.suppressionClient(id);
	}

	public ArrayList<Personne> listeDesClients() {
		return conseillerDao.listeDesClients();
	}

	// Permet d'afficher les comptes d'un client
	public ArrayList<Compte> listeDesComptes(String id) {
		return conseillerDao.listeDesComptes(id);
	}

}