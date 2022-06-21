package test;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import example.Summary;

public class SummaryTest {

	@Test
	public void testSummary() {
		SessionFactory sessionFactory = new Configuration().
		addClass(Summary.class).buildSessionFactory();
		
        Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();	
		
		List l = (List) session.createQuery("from Summary s").list();
		System.out.println(l);

		tx.commit();
		
        session.close();        
	}
}
