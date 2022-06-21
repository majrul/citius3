package example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StoreCat {

	public static void main(String[] args) throws Exception {
		SessionFactory sessionFactory = 
			new Configuration().addClass(Cat.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		Cat c = new Cat("A", 10);
		session.save(c);
		
		Cat c2 = new Cat("B", 10);
		session.save(c2);
		
		Cat c3 = new Cat("C", 10);
		session.save(c3);
		
		for(int i=0;i<100;i++) {
			Cat cc = new Cat("A"+i, i+1);
			session.save(cc);
		}

		for(int i=0;i<200;i++) {
			Cat cc = new Cat("B"+i, i+1);
			session.save(cc);
		}

		for(int i=0;i<300;i++) {
			Cat cc = new Cat("C"+i, i+1);
			session.save(cc);
		}

		tx.commit();
	}
}
