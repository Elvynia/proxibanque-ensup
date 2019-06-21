package eu.ensup.formulaire.presentation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.ensup.formulaire.dao.ConseillerDao;
import eu.ensup.formulaire.dao.Login;
import eu.ensup.formulaire.domaine.Conseiller;

/**
 * Servlet implementation class Connection
 */
@WebServlet("/Connection")
public class Connection extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Connection.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Connection() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection.LOGGER.debug("Appel à doGet() pour charger la liste des clients");
		String id = request.getParameter("id");
		
		if (id != null) {
			request.setAttribute("id", id);
			request.setAttribute("listePersonne", new ConseillerDao().listeDesClients());
			request.getRequestDispatcher("success.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("error.jsp").include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("oui");

		String login = request.getParameter("loginuser");
		String pwd = request.getParameter("mdpuser");

		List<Conseiller> conseillerList = new ArrayList<Conseiller>();

		conseillerList = Login.loginConseiller(login, pwd);

		if (!(conseillerList.isEmpty())) {
			request.setAttribute("id", conseillerList.get(0).getId());
			request.setAttribute("listePersonne", new ConseillerDao().listeDesClients());
			RequestDispatcher rs = request.getRequestDispatcher("success.jsp");
			rs.forward(request, response);
		} else {
			
			RequestDispatcher rs = request.getRequestDispatcher("error.jsp");
			rs.include(request, response);
		}
	}

}
