package hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.util.ConfigHelper;
import org.hibernate.sql.ordering.antlr.Factory;


public class UserTest {
	
	public static void main(String[] args) {
		
	User user=new User();
	user.setName("张三");
	user.setAddress("成都");
	//加载hibernate的配置文件
	Configuration configuration=new Configuration().configure();
	
	//获取SessionFactory
	SessionFactory factory= configuration.buildSessionFactory();
	//获取Session
	Session session=factory.openSession();
	//开启事务
	Transaction tx=session.beginTransaction();
	//调用session的方法完成持久化
	session.save(user);
	//提交事务
	user.setAddress("郫县");//Sission未关闭，便是持久化状态
	
	tx.commit();
	
	
	//释放资源
	factory.close();
	
	}
	
	
	
	
	
	
}
