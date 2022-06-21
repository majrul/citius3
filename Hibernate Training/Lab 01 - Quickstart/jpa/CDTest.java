package jpa;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

import annotations.CD;

public class CDTest {

	@Test
	public void testCase1() {
		EntityManagerFactory entityManagerFactory = 
			Persistence.createEntityManagerFactory("JPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		
		CD cd = new CD("Some Title", "Some Artist", new Date(), 9.99);
		entityManager.persist(cd);
		
		tx.commit();
		entityManager.close();
	}
}
