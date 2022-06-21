package hibernate.onetomanyuni;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class PhoneBookTest {

	@Test
	public void testCase1() {
		SessionFactory sessionFactory = 
			new Configuration().addClass(PhoneBook.class).buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		PhoneBook phBook = new PhoneBook();
		phBook.setName("My PhoneBook");
		
		Set<Entry> entries = new HashSet<Entry>();
		entries.add(new Entry("Entry1", 12345, "entry1@domain.com"));
		entries.add(new Entry("Entry2", 12345, "entry1@domain.com"));
		entries.add(new Entry("Entry3", 12345, "entry1@domain.com"));
		entries.add(new Entry("Entry4", 12345, "entry1@domain.com"));
		entries.add(new Entry("Entry5", 12345, "entry1@domain.com"));
		phBook.setEntries(entries);
		
		session.save(phBook);
		tx.commit();
	}
	
	public void testCase2() {
		SessionFactory sessionFactory = 
			new Configuration().addClass(PhoneBook.class).buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		PhoneBook phBook = (PhoneBook) session.get(PhoneBook.class, 1);
		System.out.println(phBook);
		//System.out.println(phBook.getEntries());
		
		tx.commit();
	}

	public void testCase3() {
		Entry newEntry = new Entry("New Entry", 12345, "newentry@domain.com");
		
		SessionFactory sessionFactory = 
			new Configuration().addClass(PhoneBook.class).buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		PhoneBook phBook = (PhoneBook) session.get(PhoneBook.class, 1);
		phBook.getEntries().add(newEntry);
		
		tx.commit();
	}

	/*
	 * Try adding an Entry to the PhoneBook after it has been detached.
	 * Then reattach the PhoneBook with another see and see what happpens
	 */
	public void testCase4() {
		Entry newEntry = new Entry("New Entry", 12345, "newentry@domain.com");
		
		SessionFactory sessionFactory = 
			new Configuration().addClass(PhoneBook.class).buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		PhoneBook phBook = (PhoneBook) session.get(PhoneBook.class, 1);
		
		tx.commit();
		//By now the PhoneBook object is detached
		
	}

	public void testCase5() {
		SessionFactory sessionFactory = 
			new Configuration().addClass(PhoneBook.class).buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		PhoneBook phBook = (PhoneBook) session.get(PhoneBook.class, 1);
		Iterator<Entry> itr = phBook.getEntries().iterator();
		while(itr.hasNext()) {
			Entry entry = itr.next();
			if(entry.getName().equals("New Entry"))
				itr.remove(); //the removed child is now orphan
		}
	
		tx.commit();
	}

}
