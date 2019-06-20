package eu.ensup.formulaire.presentation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eu.ensup.formulaire.dao.Login;
import eu.ensup.formulaire.domaine.Conseiller;

/**
 * Servlet implementation class Connection
 */
@WebServlet("/Connection")
public class Connection extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Connection() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("ici dans la servlet");

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"utf-8\" />");
		out.println("<title>Liste de formations du catalogue</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p>Liste de formation : JAVA, WEBSERVICE, </p>");
		out.println("</body>");
		out.println("</html>");

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

		Conseiller conseiller = new Conseiller();

		List<Conseiller> conseillerList = new ArrayList<Conseiller>();

		conseillerList = Login.loginConseiller(login, pwd);

		if (!(conseillerList.isEmpty())) {
			RequestDispatcher rs = request.getRequestDispatcher("success.jsp");
			rs.forward(request, response);
		} else {
			
			RequestDispatcher rs = request.getRequestDispatcher("error.jsp");
			rs.include(request, response);
		}
	}

}
