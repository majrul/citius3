package test;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import example.Bid;
import example.Item;
import example.Member;
import example.OldItem;

public class QueryTest {

	@Test
	public void testQueries() throws Exception {
		SessionFactory sessionFactory = new Configuration().
			addClass(Item.class).addClass(OldItem.class).buildSessionFactory();
		
	    Session session = sessionFactory.getCurrentSession();
	    Transaction tx = session.beginTransaction();

	    Item i = (Item) session.get(Item.class, 1);
	    System.out.println(i);
	    System.out.println(i.getBids());

	    /*String queryString = "from Item";
	    List list = session.createQuery(queryString).list();
	    Iterator itr = list.iterator();
	    displayItem(itr,queryString);*/
	    
	    /*Item i = (Item)session.createQuery("from Item where id=1").uniqueResult();
	    System.out.println("Name : "+i.getName());*/
	    
	    /*String queryString2 = "from Item i where i.validTill < :valid";
	    List list2 = session.createQuery(queryString2)
	    					.setDate("valid", new SimpleDateFormat("yyyy-MM-dd").parse("2011-10-20"))
	    					.list();
	    Iterator itr2 = list2.iterator();
	    displayItem(itr2,queryString2);*/

	    /*String queryString3 = "from Item";
	    Query query3 = session.createQuery(queryString3);
	    query3.setFirstResult(0);
	    query3.setMaxResults(10);
	    List list3 = query3.list();
	    Iterator itr3 = list3.iterator();
	    displayItem(itr3,queryString3);

	    query3.setFirstResult(10);
	    query3.setMaxResults(10);
	    list3 = query3.list();
	    itr3 = list3.iterator();
	    displayItem(itr3,queryString3);*/
	    
	    /*String queryString4 = "select distinct i from Item i join i.bids b"; 
	    List list4 = session.createQuery(queryString4).list();
	    System.out.println(list4.size());
	    Iterator itr4 = list4.iterator();
	    displayItem(itr4,queryString4);*/

	    //select c from Category c join c.items i 
	    //select c from Item i join i.categories c 
	    //from Category
	    
	    //String queryString4a = "select distinct m from Bid bid join bid.member m";
	    /*String queryString4a = "select distinct m from Bid bid join bid.member m";
	    List list4a = session.createQuery(queryString4a).list();
	    Iterator itr4a = list4a.iterator();
	    displayMember(itr4a,queryString4a);*/
	    
	    /*String queryString5 = "select i from Category c join c.items i where c.name=:nm and i.initialPrice > :pr";
	    //String queryString5 = "select i from Item i join i.categories c where c.name=:nm and i.initialPrice > :pr";
	    List list5 = session.createQuery(queryString5).setString("nm","LAPTOP").setDouble("pr", 100000).list();
	    Iterator itr5 = list5.iterator();
	    displayItem(itr5,queryString5);*/
	    	   
	    /*String queryString6 = "select i.initialPrice, max(b.amount) from Item i join i.bids b group by i.initialPrice";
	    List list6 = session.createQuery(queryString6).list();
	    Iterator itr6 = list6.iterator();
	    while(itr6.hasNext()) {
	    	Object[] total = (Object[]) itr6.next();
	    	System.out.println(total[0]+","+total[1]);
	    }
	    System.out.println(list6);*/

	    /*String queryString7 = "from Bid bid where bid.item.initialPrice > 10000";
	   //from Bid b join fetch b.item i where bid.item.initialPrice = 500.0
	    List list7 = session.createQuery(queryString7).list();
	    Iterator itr7 = list7.iterator();
	    displayBid(itr7,queryString7);*/

	    /*String queryString8 = "from Item item where item.bids.size > 5";
	    List list8 = session.createQuery(queryString8).list();
	    Iterator itr8 = list8.iterator();
	    displayItem(itr8,queryString8);*/
    
		/*String queryString9 = "select category, childcategory from Category category join category.childCategories childcategory";
		//select category from Category category join fetch category.childCategories
	    List list9 = session.createQuery(queryString9).list();
	    Iterator itr9 = list9.iterator();
	    while(itr9.hasNext()) {
	    	Object[] tuple = (Object[]) itr9.next();
	    	Category category = (Category) tuple[0];
	    	Category childCategory = (Category) tuple[1];
	    	System.out.println(category+"||"+childCategory);	    	                                          
	    }*/    
	    
	   /*String queryString10 = "select cat from Category as cat " +
	    		"left join fetch cat.parentCategory " +
	    		"left join fetch cat.childCategories child " +
	    		"left join fetch child.childCategories";
	    List list10 = session.createQuery(queryString10).list();
	   System.out.println(list10);*/
	    
	   /*String queryString11 = "from Item i where i.initialPrice  < (select avg(item.initialPrice) from Item item)";
	   List list11 = session.createQuery(queryString11).list();
	   Iterator itr11 = list11.iterator();
	   displayItem(itr11, queryString11);*/
	   
	    /*Query q = session.getNamedQuery("example.items.getAll");
	    q.setInteger(0, 1);
	    List items = q.list();
	    displayItem(items.iterator(),"");*/
	    
	    /*Query q = session.createQuery("update Item i set i.reservePrice = :res where i.id = :id");
	    q.setDouble("res", 135000);
	    q.setInteger("id", 1);
	    int count = q.executeUpdate();
	    System.out.println(count);*/
	    
	    /*Query q = session.createQuery("delete Cat");
	    int count = q.executeUpdate();
	    System.out.println(count);*/
	    
	    /*Query q = session.createQuery("insert into OldItem (id, name, expiredOn) select i.id, i.name, i.validTill from Item i where i.validTill < :valid");
	    q.setDate("valid", new SimpleDateFormat("yyyy-MM-dd").parse("2010-08-17"));
	    int count = q.executeUpdate();
	    System.out.println(count);*/
	    
	    tx.commit();
	}
	
	private static void displayItem(Iterator itr, String queryString) {
		System.out.println("HQL : "+queryString);
		while(itr.hasNext()) {
			Item item = (Item) itr.next();
			System.out.println(item);
			//System.out.println(item.getBids());			
			//System.out.println(item.getCategories());
		}
	}

	private static void displayBid(Iterator itr, String queryString) {
		System.out.println("HQL : "+queryString);
		while(itr.hasNext()) {
			Bid bid = (Bid) itr.next();
			System.out.println(bid);
			//System.out.println(bid.getItem().getName());
		}
	}

	private static void displayMember(Iterator itr, String queryString) {
		System.out.println("HQL : "+queryString);
		while(itr.hasNext()) {
			Member m = (Member) itr.next();
			System.out.println(m.getName());
		}
	}
}
