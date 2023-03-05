package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.car;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/CarNavigationServlet")
public class CarNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarNavigationServlet() {
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
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		carHelper dao = new carHelper();
		String act = request.getParameter("doThisToCar");

		String path = "/ViewAllCarsServlet";

		if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				car carToDelete = dao.searchForCarById(tempId);
				dao.deleteCar(carToDelete);

			} catch (NumberFormatException e) {
				System.out.println("Forgot to select an car");
			}

		} else if (act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				car carToEdit = dao.searchForCarById(tempId);
				request.setAttribute("carToEdit", carToEdit);
				path = "/edit-car.jsp";
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select an car");
			}

		} else if (act.equals("add")) {
			path = "/addCar.html";
		}

		getServletContext().getRequestDispatcher(path).forward(request, response);

	}

}


