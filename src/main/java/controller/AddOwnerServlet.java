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
		OwnerHelper oh = new OwnerHelper();
		String path = "/index.html";
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		/*
		 * Checks owner table if email already exists
		 * If it does then that user is return and name is updated
		 * If it doesn't a new owner is created and inserted
		 */
		
		owner newOwner = oh.searchOwnerByEmail(email);
		newOwner.setEmail(email);
		newOwner.setName(name);
		oh.updateOwner(newOwner);
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}
}
