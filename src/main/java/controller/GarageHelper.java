/**
 * @author Isaiah Aldiano - iealdiano
 * CIS175 - Spring 2023
 * Feb 28, 2023
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.garage;

public class GarageHelper {
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("week7-mini-project");
	
	//Inserts new garage into garage table
	public void insertGarage(garage newGarage) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(newGarage);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<garage> getAllGarages() {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		List<garage> allGarages = em.createQuery("SELECT allGarage FROM garage allGarage").getResultList();
		
		em.close();
		return allGarages;
	}
	
	public void updateGarage(garage toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public garage searchById(int ID) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<garage> typedQuery = em.createQuery("SELECT someGarage FROM garage someGarage where someGarage.id = :findId", garage.class);
		
		typedQuery.setParameter("findId", ID);
		typedQuery.setMaxResults(1);
		
		garage found = typedQuery.getSingleResult();
		em.close();
		return found;
	}
	
	public void deleteGarage(garage toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<garage> typedQuery = em.createQuery("SELECT toDel FROM garage toDel where toDel.id = :garageDelId", garage.class);
		
		typedQuery.setParameter("garageDelId", toDelete.getId());
		typedQuery.setMaxResults(1);
		
		garage deleteThis = typedQuery.getSingleResult();
		
		em.remove(deleteThis);
		em.getTransaction().commit();
		em.close();
	}
	
}
