package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.car;

/**
 * Servlet implementation class AddCarServlet
 */
@WebServlet("/AddCarServlet")
public class AddCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		carHelper ch = new carHelper();
		String path = "/ViewAllCarsServlet";
		
		String make = request.getParameter("make");
		String model = request.getParameter("model");
		String value = request.getParameter("year");
		int year = Integer.parseInt(value);
		
		LocalDate ld = LocalDate.now();
		
		//checks to see if car already exists in car table
		car doesCarExist = new car(make, model, year, ld);
		
		//If exists then car not inserted, else its inserted
		if (!ch.searchCarMakeModelYear(doesCarExist)) {
			ch.insertCar(doesCarExist);
		} 
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
