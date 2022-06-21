package example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class CachingTest {

	@Test
	public void testCaching() throws Exception {
		SessionFactory sessionFactory = 
			new Configuration().addClass(Cat.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Cat c = (Cat) session.get(Cat.class, 1);
		tx.commit();

		session = sessionFactory.getCurrentSession();
		tx = session.beginTransaction();
		c = (Cat) session.get(Cat.class, 1);
		tx.commit();

		/*session = sessionFactory.getCurrentSession();
		tx = session.beginTransaction();
		c = (Cat) session.get(Cat.class, 1);
		c.getKittens().iterator();
		tx.commit();

		session = sessionFactory.getCurrentSession();
		tx = session.beginTransaction();
		c = (Cat) session.get(Cat.class, 1);
		c.getKittens().iterator();
		tx.commit();

		session = sessionFactory.getCurrentSession();
		tx = session.beginTransaction();
		List cats = session.createQuery("from Cat").
			setCacheable(true).list();
		tx.commit();

		session = sessionFactory.getCurrentSession();
		tx = session.beginTransaction();
		List cats = session.createQuery("from Cat").
			setCacheable(true).list();
		tx.commit();

		session = sessionFactory.getCurrentSession();
		tx = session.beginTransaction();
		c = new Cat("Z", 9);
		Integer id = (Integer) session.save(c);
		tx.commit();

		session = sessionFactory.getCurrentSession();
		tx = session.beginTransaction();
		c = (Cat) session.get(Cat.class, id);
		tx.commit();*/

		sessionFactory.close();
	}
}
