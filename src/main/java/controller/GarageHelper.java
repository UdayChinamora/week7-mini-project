/**
 * @author Isaiah Aldiano - iealdiano
 * CIS175 - Spring 2023
 * Feb 28, 2023
 */
package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.garage;

public class GarageHelper {
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("week7-mini-project");
	
	//Inserts new garage into garage table
	public void createGarage(garage newGarage) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(newGarage);
		em.getTransaction().commit();
		em.close();
	}
}
