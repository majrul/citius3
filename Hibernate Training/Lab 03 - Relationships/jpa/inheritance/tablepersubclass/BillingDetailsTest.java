package jpa.inheritance.tablepersubclass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class BillingDetailsTest {

	@Test
	public void testCase1() {
		SessionFactory sessionFactory = new Configuration().
			addAnnotatedClass(BillingDetails.class).
			addAnnotatedClass(BankAccount.class).
			addAnnotatedClass(CreditCard.class).buildSessionFactory();
		
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
}
