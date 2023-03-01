package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.owner;



/**
 * Servlet implementation class AddOwnerServlet
 */
@WebServlet("/AddOwnerServlet")
public class AddOwnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddOwnerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
	
		if (name.isEmpty() || email.isEmpty() ||name == null || email == null) {
			getServletContext().getRequestDispatcher("/car.html").forward(request, response);
		} else {
			owner li = new owner(name, email);
			OwnerHelper dao = new OwnerHelper();
			dao.insertOwner(li);

			getServletContext().getRequestDispatcher("/car.html").forward(request, response);
		}
	}
}
