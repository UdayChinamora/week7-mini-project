/**
 * @author Isaiah Aldiano - iealdiano
 * CIS175 - Spring 2023
 * Feb 27, 2023
 */
package controller;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


import model.car;

public class carHelper {
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("mini_project");
	
	public void insertCar(car newCar) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(newCar);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<car> getAllCars() {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		List<car> allCars = em.createQuery("SELECT allCars FROM car allCars").getResultList();
		
		return allCars;
	}
	
	
	
	
	public void deleteCar(car toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<car> typedQuery = em.createQuery(
				"select li from car li where li.make = :selectedMake and li.model = :selectedModel and li.year = :selectedYear",
				car.class);
		typedQuery.setParameter("selectedMake", toDelete.getMake());

		typedQuery.setParameter("selectedModel", toDelete.getModel());
		
		typedQuery.setParameter("selectedYear", toDelete.getYear());

		typedQuery.setMaxResults(1);

		
		car  result = typedQuery.getSingleResult();

		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();

	}

	public car searchForCarById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		car found = em.find(car.class, idToEdit);
		em.close();
		return found;
	}

	public void updateCar(car toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();

		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<car> searchForCarByMake(String makeName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<car> typedQuery = em.createQuery("select li from car li where li.make = :selectedMake",car.class);
		typedQuery.setParameter("selectedMake", makeName);

		List<car> foundCars = typedQuery.getResultList();
		em.close();
		return foundCars;
	}

	public List<car> searchForCarByModel(String modelName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<car> typedQuery = em.createQuery("select li from car li where li.model = :selectedModel", car.class);
		typedQuery.setParameter("selectedModel", modelName);

		List<car> foundCars = typedQuery.getResultList();
		em.close();
		return foundCars;
	}

	public void cleanUp(){
		emfactory.close();
	}
}
