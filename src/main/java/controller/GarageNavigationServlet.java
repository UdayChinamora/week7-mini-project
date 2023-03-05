package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.garage;

/**
 * Servlet implementation class GarageNavigationServlet
 */
@WebServlet("/GarageNavigationServlet")
public class GarageNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GarageNavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		GarageHelper gh = new GarageHelper();
		carHelper ch = new carHelper();
		OwnerHelper oh = new OwnerHelper();
		
		String act = request.getParameter("doThisToGarage");
		String path = "/ViewAllGaragesServlet";
		
		if (act.equals("add")) {
			path = "/AddGarageInfoServlet";
		} else if (act.equals("edit")) {
			try {
				Integer id = Integer.parseInt(request.getParameter("id"));
				garage toEdit = gh.searchById(id);
				request.setAttribute("garageToEdit", toEdit);
				path = "/edit-garage.jsp";
			} catch (NumberFormatException e) {
				System.out.println("Select Garage");
			}
		} else if (act.equals("delete")) {
			try {
				Integer id = Integer.parseInt(request.getParameter("id"));
				garage delGarage = gh.searchById(id);
				gh.deleteGarage(delGarage);
			} catch (NumberFormatException e) {
				System.out.println("Select Garage");
			}
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
		
	}

}
