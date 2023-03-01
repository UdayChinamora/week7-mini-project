package controller;

import java.io.IOException;
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
		
		String make = request.getParameter("make");
		String model = request.getParameter("model");
		String value = request.getParameter("year");
		int year = Integer.parseInt(value);
		if (make.isEmpty() || model.isEmpty() || year ==0 ||make == null || model == null) {
			getServletContext().getRequestDispatcher("/addCar.html").forward(request, response);
		} else {
			car li = new car(make, model,year);
			carHelper dao = new carHelper();
			dao.insertCar(li);

			getServletContext().getRequestDispatcher("/addCar.html").forward(request, response);
		}
	}

}
