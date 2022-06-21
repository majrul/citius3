package hibernate.component;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class UserTest {
	
	@Test
	public void testCase1() {
		SessionFactory sessionFactory = new Configuration().
			addClass(User.class).buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		User  u = new User();
		u.setFirstname("Majrul");
		u.setLastname("Ansari");
		u.setUsername("majrul");
		u.setPassword("majrul123");
		
		Address address = new Address();
		address.setCity("Mumbai");
		address.setStreet("Vikhroli");
		address.setZipcode("400083");
		
		Address address2 = new Address();
		address.setCity("Delhi");
		address.setStreet("Janpath");
		address.setZipcode("4101010");
		
		Map<String, String> userAttrs = new HashMap<String, String>();
		userAttrs.put("roles", "admin");
		userAttrs.put("active", "true");
		
		u.setBillingAddress(address);
		u.setShippingAddress(address2);
		u.setUserAttributes(userAttrs);
		
		session.save(u);
		tx.commit();
	}
}
