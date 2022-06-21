package annotations;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class CDTest {

	@Test
	public void testCase1() {
		SessionFactory sessionFactory = 
			new Configuration().configure("annotations/hibernate.cfg.xml").buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		CD cd = new CD("Some Title", "Some Artist", new Date(), 9.99);
		session.save(cd);
		
		tx.commit();
	}
}
