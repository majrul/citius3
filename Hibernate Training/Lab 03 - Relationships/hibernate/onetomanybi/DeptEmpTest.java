package hibernate.onetomanybi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class DeptEmpTest {

	@Test
	public void testCase1() {
		SessionFactory sessionFactory = 
			new Configuration().addClass(Employee.class).buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		Department dept = new Department();
		dept.setDeptno(10);
		dept.setName("Admin");
		dept.setLocation("Andheri, Mumbai");
		
		session.save(dept);
		tx.commit();
	}

	@Test
	public void testCase2() {
		SessionFactory sessionFactory = 
			new Configuration().addClass(Employee.class).buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		Department dept = (Department) session.get(Department.class, 10);
		
		Employee emp = new Employee();
		emp.setEmpno(1001);
		emp.setName("Majrul Ansari");
		emp.setSalary(1000.0);
		emp.setDept(dept);
		
		session.save(emp);
		tx.commit();
	}
}
