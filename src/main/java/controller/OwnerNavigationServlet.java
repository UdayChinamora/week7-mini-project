	package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.owner;

/**
 * Servlet implementation class OwnerNavigationServlet
 */
@WebServlet("/OwnerNavigationServlet")
public class OwnerNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OwnerNavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		OwnerHelper oh = new OwnerHelper();
		String act = request.getParameter("doThisToOwner");
		String path = "/ViewAllOwnersServlet";
		
		if (act.equals("add")) {
			path = "/addOwner.jsp";
		} else if (act.equals("edit")) {
			try {
				Integer id = Integer.parseInt(request.getParameter("id"));
				owner toEdit = oh.searchOwnerById(id);
				request.setAttribute("ownerToEdit", toEdit);
				path = "/edit-owner.jsp";
			} catch (NumberFormatException e) {
				System.out.println("Select Owner");
			}
		} else if (act.equals("delete")) {
			try {
				Integer id = Integer.parseInt(request.getParameter("id"));
				owner toDelete = oh.searchOwnerById(id);
				oh.deleteOwner(toDelete);
			} catch (NumberFormatException e) {
				System.out.println("Select Owner");
			}
		} 
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
