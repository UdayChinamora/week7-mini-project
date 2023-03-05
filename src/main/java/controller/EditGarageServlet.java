package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.car;
import model.garage;
import model.owner;

/**
 * Servlet implementation class EditGarageServlet
 */
@WebServlet("/EditGarageServlet")
public class EditGarageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditGarageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String path = "/ViewAllGaragesServlet";
		
		GarageHelper gh = new GarageHelper();
		carHelper ch = new carHelper();
		OwnerHelper oh = new OwnerHelper();
		
		String title = request.getParameter("garageTitle");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
	
		owner someOwner = oh.searchOwnerById(Integer.parseInt(request.getParameter("ownerID")));
		
		someOwner.setEmail(email);
		someOwner.setName(name);
		
		int id = Integer.parseInt(request.getParameter("id"));

		
		String[] select = request.getParameterValues("carsInGarage");
		List<car> selectedCars = new ArrayList<car>();
		
		if(select != null && select.length > 0) {
			for (String carId : select) {
				car toAdd = ch.searchForCarById(Integer.parseInt(carId));
				selectedCars.add(toAdd);
			}
		}
		
		garage toEdit = gh.searchById(id);
		
		toEdit.setCars(selectedCars);
		toEdit.setGarageName(title);
		toEdit.setGarageOwner(someOwner);
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
