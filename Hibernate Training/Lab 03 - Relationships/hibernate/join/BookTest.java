package hibernate.join;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class BookTest {

	@Test
	public void testCase1() {
		SessionFactory sessionFactory = 
			new Configuration().addClass(Book.class).buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		Book book = new Book();
		book.setIsbn(1234567890);
		book.setTitle("Beginning Hibernate");
		book.setAuthor("Jeff Linwood");
		book.setPublication("Apress");
		
		session.save(book);
		tx.commit();
	}
	
}
