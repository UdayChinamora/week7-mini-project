package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.owner;

/**
 * Servlet implementation class EditOwnerSerlvet
 */
@WebServlet("/EditOwnerServlet")
public class EditOwnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditOwnerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		OwnerHelper oh = new OwnerHelper();
		String path = "/ViewAllOwnersServlet";
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		int id = Integer.parseInt(request.getParameter("id"));
		
		owner ownerToUpdate = oh.searchOwnerById(id);
		
		ownerToUpdate.setEmail(email);
		ownerToUpdate.setName(name);
		
		oh.updateOwner(ownerToUpdate);
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
