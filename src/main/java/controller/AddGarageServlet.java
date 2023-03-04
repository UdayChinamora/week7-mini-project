package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.owner;

/**
 * Servlet implementation class AddGarageServlet
 */
@WebServlet("/AddGarageServlet")
public class AddGarageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddGarageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		carHelper ch = new carHelper();
		GarageHelper gh = new GarageHelper();
		OwnerHelper oh = new OwnerHelper();
		
		String path = "/ViewAllGaragesServlet";
		
		String oEmail = request.getParameter("email");
		String oName = request.getParameter("name");
		
		owner someOwner = oh.searchOwnerByEmail(oEmail);
		
		//More to be added here
		
		
		String gTitle = request.getParameter("garageTitle");
		
		
	}

}
