package hibernate.xmlmodel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Element;
import org.hibernate.EntityMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class CustomerTest {

	@Test
	public void testCase1() {
		SessionFactory sessionFactory = 
			new Configuration().configure("hibernate/xmlmodel/hibernate.cfg.xml").buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		Session dom4jSession = session.getSession(EntityMode.DOM4J);
		List<Element> customers = dom4jSession.createQuery("from Customer").list();
		
		for(Element customer : customers) { 
			System.out.println(customer.attributeValue("id"));
			System.out.println(customer.attributeValue("name"));
			System.out.println(customer.attributeValue("email"));
		}		
		tx.commit();
	}
}
