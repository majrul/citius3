package test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import example.Item;
import example.OldItem;

public class CriteriaTest {

	@Test
	public void testCriteria() {
		SessionFactory sessionFactory = new Configuration().
		addClass(Item.class).buildSessionFactory();
		
		Session session = sessionFactory.openSession();

	    //"from Item where "+"name "+"like "+'S%'"
	    Criteria criteria = session.createCriteria(Item.class);
	    criteria.add(Restrictions.like( "name","S%"));
	    List list = criteria.list();
	    Iterator itr = list.iterator();
	    displayItem(itr);
	    
	    
	    /*Criteria criteria = session.createCriteria(Item.class);
	    criteria.add(Restrictions.in("name", new String[]{"MARUTI 800","SAHARA LAPTOP"}));
	    Disjunction subcriteria = Restrictions.disjunction();
	    subcriteria.add(Restrictions.gt("initialPrice", new Double(20000.0)));
	    subcriteria.add(Restrictions.lt("reservePrice", new Double(30000.0)));
	    criteria = criteria.add(subcriteria);
	    															    														
	    List list = criteria.list();
	    Iterator itr = list.iterator();
	    displayItem(itr);*/
	 
	    //from Item i join i.categories c where i.initialPrice > 100 and c.name like 'E%' 
	    /*Criteria criteria = session.createCriteria(Item.class);
	    criteria.add(Restrictions.gt("initialPrice", new Double(100.0)));
	    criteria.createCriteria("categories");
	    criteria.add(Restrictions.like("name","E%"));
	    List list = criteria.list();
	    Iterator itr = list.iterator();
	    displayItem(itr);*/
	    
	    session.close();
	    
	}
	
	private static void displayItem(Iterator itr) {
		while(itr.hasNext()) {
			Item item = (Item) itr.next();
			System.out.println(item);
			//System.out.println(item.getBids());			
		}
	}
}
