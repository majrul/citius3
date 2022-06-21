package hibernate.dynamodel;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class CustomerTest {

	@Test
	public void testCase1() {
		SessionFactory sessionFactory = 
			new Configuration().configure("hibernate/dynamodel/hibernate.cfg.xml").buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		Map<String, Object> cust = new HashMap<String, Object>();
		cust.put("name", "Majrul Ansari");
		cust.put("email", "contactme@majrul.com");
		
		session.save("Customer", cust);
		
		tx.commit();
	}
}
