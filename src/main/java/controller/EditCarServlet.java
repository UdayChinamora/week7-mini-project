package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.car;

/**
 * Servlet implementation class EditCarServlet
 */
@WebServlet("/EditCarServlet")
public class EditCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		carHelper dao = new carHelper();

		String make = request.getParameter("make");
		String model = request.getParameter("model");
		Integer year = Integer.parseInt(request.getParameter("year"));
		Integer tempId = Integer.parseInt(request.getParameter("id"));

		/*
		 * Searches for and updates already existing car
		 */
		car carToUpdate = dao.searchForCarById(tempId);
		carToUpdate.setModel(model);
		carToUpdate.setMake(make);
		carToUpdate.setYear(year);

		dao.updateCar(carToUpdate);

		getServletContext().getRequestDispatcher("/ViewAllCarsServlet").forward(request, response);

}

}
