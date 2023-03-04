/**
 * @author Isaiah Aldiano - iealdiano
 * CIS175 - Spring 2023
 * Feb 27, 2023
 */
package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.owner;

public class OwnerHelper {
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("week7-mini-project");
	
	//Inserts a new owner into owner table
	public void insertOwner(owner newOwner) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(newOwner);
		em.getTransaction().commit();
		em.close();
	}
	
	//Updates information for a preexisting owner
	public void updateOwner(owner ownerToUpdate) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(ownerToUpdate);
		em.getTransaction().commit();
		em.close();
	}
	
	//Creates a query to search the owner table for matching emails to given email string
	public owner searchOwnerByEmail(String ownerEmail) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<owner> typedQuery = em.createQuery("SELECT o FROM owner o where o.email = :ownerEmail", owner.class);
		
		typedQuery.setParameter("ownerEmail", ownerEmail);
		typedQuery.setMaxResults(1);
		
		owner found = null;
		
		try {
			found = typedQuery.getSingleResult(); 
		} catch(NoResultException e) {
			found = new owner();
		}
		
		em.close();
		return found;
	}
	
}
