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

import model.car;

public class carHelper {
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("week7-mini-project");
	
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
}
