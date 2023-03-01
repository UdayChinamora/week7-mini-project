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
	
	public void insertOwner(owner newOwner) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(newOwner);
		em.getTransaction().commit();
		em.close();
	}
	
	public owner searchOwnerByName(String ownerName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<owner> typedQuery = em.createQuery("SELECT o FROM owner o where o.name = :ownerName", owner.class);
		
		typedQuery.setParameter("ownerName", ownerName);
		typedQuery.setMaxResults(1);
		
		owner found;
		
		try {
			found = typedQuery.getSingleResult(); 
		} catch(NoResultException e) {
			found = new owner(ownerName);
			this.insertOwner(found);
		}
		
		em.close();
		return found;
	}
	
//	public owner searchOwnerByEmail(String ownerEmail) {
//		EntityManager em = emfactory.createEntityManager();
//		em.getTransaction().begin();
//		
//		TypedQuery<owner> typedQuery = em.createQuery("SELECT o FROM owner o where o.email = :ownerEmail", owner.class);
//		
//		typedQuery.setParameter("ownerEmail", ownerEmail);
//		typedQuery.setMaxResults(1);
//		
//		owner found;
//		
//		try {
//			
//		} catch (NoResultException e) {
//			found = new owner();
//		}
//	}
}
