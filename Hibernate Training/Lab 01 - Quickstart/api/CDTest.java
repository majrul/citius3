package api;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import xml.CD;

public class CDTest {

	/*
	 * Fetching a record from the database using Session.get() method
	 */
	@Test
	public void testCase1() {
		SessionFactory sessionFactory = 
			new Configuration().configure("xml/hibernate.cfg.xml").buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		CD cd = (CD) session.get(CD.class, 1);
		System.out.println(cd);
		
		tx.commit();		
	}
	
	/*
	 * Fetching a record from the database using EntityManager.find() method
	 */
	public void testCase2() {
		EntityManagerFactory entityManagerFactory = 
			Persistence.createEntityManagerFactory("JPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		
		annotations.CD cd = (annotations.CD) entityManager.find(annotations.CD.class, 1);
		System.out.println(cd);
		
		tx.commit();
		entityManager.close();
	}
	
	/*
	 * Understanding Detached object state in Hibernate. Same applies to JPA as well
	 */
	public void testCase3() {
		SessionFactory sessionFactory = 
			new Configuration().configure("xml/hibernate.cfg.xml").buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		CD cd = (CD) session.get(CD.class, 1);
		System.out.println(cd);
		
		tx.commit(); //remember, commit will cause the session to close
		
		//now the CD instance in detached
		cd.setCost(19.99); //changes won't be reflected in the database
		
		//re-attaching a detached instance
		session = sessionFactory.getCurrentSession();
		tx = session.beginTransaction();
		
		session.update(cd);
		
		tx.commit();
	}

	/*
	 * Understanding difference between saveOrUpdate and merge method.
	 * There is no saveOrUpdate equivalent in JPA. Only merge method is available
	 */
	@Test
	public void testCase4() {
		SessionFactory sessionFactory = 
			new Configuration().configure("xml/hibernate.cfg.xml").buildSessionFactory();
		
		//assuming we have a CD object with some fields modified by the user
		CD cd = new CD();
		cd.setId(1);
		cd.setArtist("New Artist");
		cd.setTitle("Old Title");
		cd.setCost(29.99);
		cd.setPurchaseDate(new Date());
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		//insert or update based on whether the object passed is transient or detached
		session.saveOrUpdate(cd);
		
		tx.commit(); 
	}	
}
