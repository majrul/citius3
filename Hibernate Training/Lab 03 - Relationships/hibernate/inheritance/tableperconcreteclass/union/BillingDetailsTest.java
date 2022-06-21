package hibernate.inheritance.tableperconcreteclass.union;

import java.util.List;

import hibernate.inheritance.BankAccount;
import hibernate.inheritance.BillingDetails;
import hibernate.inheritance.CreditCard;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class BillingDetailsTest {

	@Test
	public void testCase1() {
		SessionFactory sessionFactory = 
			new Configuration().configure("hibernate/inheritance/tableperconcreteclass/union/hibernate.cfg.xml").buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		BankAccount bankAcc = new BankAccount();
		bankAcc.setOwner("Majrul Ansari");
		bankAcc.setNumber("12345");
		bankAcc.setBankName("ICICI Bank");

		CreditCard creditCard = new CreditCard();
		creditCard.setOwner("Majrul Ansari");
		creditCard.setNumber("412901234567890");
		creditCard.setType("VISA");
		creditCard.setExpiryMonth("12");
		creditCard.setExpiryYear("2099");
		
		session.save(bankAcc);
		session.save(creditCard);
		
		tx.commit();
	}

	@Test
	public void testCase2() {
		SessionFactory sessionFactory = 
			new Configuration().configure("hibernate/inheritance/tableperconcreteclass/union/hibernate.cfg.xml").buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		List<BillingDetails> list = session.createQuery("from hibernate.inheritance.BillingDetails").list();
		for(BillingDetails b : list)
			System.out.println(b.getClass());
		
		tx.commit();
	}
	
}
