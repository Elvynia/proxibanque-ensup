package eu.ensup.formulaire.presentation;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eu.ensup.formulaire.dao.ConseillerDao;
import eu.ensup.formulaire.domaine.Compte;

/**
 * Servlet implementation class CompteServlet
 */
@WebServlet("/CompteServlet")
public class CompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("servlet compte");
		String id = request.getParameter("id");
		System.out.println("id est : " + id);
		
		ConseillerDao conseillerDao = new ConseillerDao();
		ArrayList<Compte> reponse = conseillerDao.listeDesComptes(id);
		
		if (reponse.size() > 0)
		{
			RequestDispatcher rs = request.getRequestDispatcher("success.jsp");
			rs.forward(request, response);
			
		}
		else {
			RequestDispatcher rs = request.getRequestDispatcher("404.jsp");
			rs.forward(request, response);
		}
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
