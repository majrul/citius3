package example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LockingTest {

	static SessionFactory sessionFactory;

	static {
		Configuration configuration = new Configuration();
		configuration.addClass(Product.class);
		sessionFactory = configuration.buildSessionFactory();
	}

	public static void main(String[] args) {
		TestSession1 s1 = new TestSession1();
		TestSession2 s2 = new TestSession2();
		new Thread(s1).start();
		new Thread(s2).start();
	}
}

class TestSession1 implements Runnable {

	public void run() {
		try {
			Thread.sleep(1000);
			Session session = LockingTest.sessionFactory.getCurrentSession();
			Transaction tx = session.beginTransaction();

			Product p = (Product) session.get(Product.class, new Integer(1));
			System.out.println("Thread-1: Version " + p.getVersion() + " before update");
			p.setPrice(200);

			tx.commit();
			System.out.println("Thread-1: Version " + p.getVersion() + " after update");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class TestSession2 implements Runnable {

	public void run() {
		try {
			Thread.sleep(500);
			Session session = LockingTest.sessionFactory.getCurrentSession();
			Transaction tx = session.beginTransaction();	

			Product p = (Product) session.get(Product.class, new Integer(1));
			System.out.println("Thread-2: Version " + p.getVersion() + " before update");
			Thread.sleep(1000);		
			p.setPrice(300);

			tx.commit();
			System.out.println("Thread-2: Version " + p.getVersion() + " after update");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
