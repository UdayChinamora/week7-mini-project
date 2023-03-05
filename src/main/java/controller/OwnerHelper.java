/**
 * @author Isaiah Aldiano - iealdiano
 * CIS175 - Spring 2023
 * Feb 27, 2023
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.garage;
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
	
	public owner searchOwnerById(int ID) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		owner someOwner = em.find(owner.class, ID);
		
		return someOwner;
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
			found = new owner(ownerEmail);
		}
		
		em.close();
		return found;
	}
	
	public void deleteOwnersGarages(int id) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<garage> ownersGarages = em.createQuery("SELECT ownersGarage FROM garage ownersGarage WHERE ownersGarage.garageOwner.id = :ownerID", garage.class);
		
		ownersGarages.setParameter("ownerID", id);
		
		List<garage> allOwnersGarages = ownersGarages.getResultList();
		
		GarageHelper gh = new GarageHelper();
		
		for (garage g : allOwnersGarages) {
			gh.deleteGarage(g);
		}
		
		em.getTransaction().commit();
		em.close();
	}
	
	
	public void deleteOwner(owner toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		this.deleteOwnersGarages(toDelete.getId());
		
		TypedQuery<owner> typedQuery = em.createQuery("SELECT toDel FROM owner toDel where toDel.id = :toDelId", owner.class);
		
		typedQuery.setParameter("toDelId", toDelete.getId());
		
		typedQuery.setMaxResults(1);
		
		owner toDel = typedQuery.getSingleResult();
		
		em.remove(toDel);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<owner> getAllOwners() {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		List<owner> allOwners= em.createQuery("SELECT allOwners FROM owner allOwners").getResultList();
		
		return allOwners;
	}
}
