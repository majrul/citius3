package example;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AddProduct {

	public static void main(String[] args) throws Exception {
		SessionFactory sessionFactory = 
			new Configuration().addClass(Product.class).buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		Product c = new Product("Nokia Handset",100);
		Serializable id = session.save(c);
		
		tx.commit();
		System.out.println("Primary key of record inserted : "+id);
	}
}
