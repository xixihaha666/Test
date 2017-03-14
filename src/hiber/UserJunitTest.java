package hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.util.ConfigHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserJunitTest {
	private SessionFactory sessionFactory;
	@Before
	public void before(){
		Configuration configuration=new Configuration().configure();
		sessionFactory=configuration.buildSessionFactory();
		
	}
	
	
	@After
	public void after(){
		if(sessionFactory!=null){
			sessionFactory.close();
		}
		
		
	}
	
	@Test()
	public void delete(){
	Session openSession = sessionFactory.openSession();	
	Transaction tx=openSession.beginTransaction();
	User user=new User();
	user.setId(1);
	openSession.delete(user);
	
	tx.commit();
	sessionFactory.close();
	
	}
	
	

}
