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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		System.out.println("oui");
		
		String login = request.getParameter("login");
		String pwd = request.getParameter("pwd");

		Conseiller conseiller = new Conseiller();

		List<Conseiller>conseillerList = new ArrayList<Conseiller>();

		conseillerList = Login.loginConseiller(login, pwd);

		if(!(conseillerList.isEmpty()))
		{
			RequestDispatcher rs = request.getRequestDispatcher("success.jsp");
			rs.forward(request, response);
		}
		else
		{
			out.println("<h1>Login ou mot de passe incorrect, veuillez les ressaisir</h1>");
			RequestDispatcher rs = request.getRequestDispatcher("error.jsp");
			rs.include(request, response);
		}
	}

}
