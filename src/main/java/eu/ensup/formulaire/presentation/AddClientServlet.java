package eu.ensup.formulaire.presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.ensup.formulaire.domaine.Client;
import eu.ensup.formulaire.service.ConseillerService;

@WebServlet("/addClient")
public class AddClientServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AddClientServlet.class);

	private ConseillerService service;
	
	@Override
	public void init() throws ServletException {
		this.service = new ConseillerService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idConseiller = req.getParameter("id");
		AddClientServlet.LOGGER.debug("Appel à doGet avec idConseiller -> {}", idConseiller);
		this.getServletContext().getRequestDispatcher("/addClient.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idConseiller = req.getParameter("id");
		// Récupération des informations du formulaire.
		String firstname = req.getParameter("prenom");
		String name = req.getParameter("nom");
		String address = req.getParameter("adresse");
		String city = req.getParameter("ville");
		String zipCode = req.getParameter("code");
		String tel = req.getParameter("tel");
		// Construction du nouveau client.
		Client newClient = new Client();
		newClient.setId(RandomStringUtils.random(10, "azertyuiopqsdfghjklmwxcvbn012345789"));
		newClient.setAdresse(address);
		newClient.setCodePostal(
				zipCode != null && !zipCode.isEmpty() ?
						Integer.parseInt(zipCode) : 0);
		newClient.setNom(name != null && !name.isEmpty() ?
				name : null);
		newClient.setPrenom(firstname != null && !firstname.isEmpty() ?
				firstname : null);
		newClient.setTelephone(
				tel != null && !tel.isEmpty() ?
				Integer.parseInt(tel) : 0);
		newClient.setVille(city);
		// Appel du service pour traiter l'ajout du client.
		AddClientServlet.LOGGER.info("Ajout du client {} {} en base de données", firstname, name);
		boolean result = this.service.creationClient(newClient, idConseiller);
		if (result) {
			req.setAttribute("isError", false);
			req.setAttribute("message", "Le client "
					+ firstname + " " + name
					+ " a bien été enregistré en base !");
		} else {
			req.setAttribute("isError", true);
			req.setAttribute("message", "ERREUR : Le client "
					+ firstname + " " + name
					+ " n'a pas été enregistré en base...");
		}
		// Redirection vers la page success.
//		resp.sendRedirect(this.getServletContext().getContextPath()
//				+ "/Connection?id=" + idConseiller);
		this.doGet(req, resp);
	}
	
}
