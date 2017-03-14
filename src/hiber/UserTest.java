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
	user.setName("����");
	user.setAddress("�ɶ�");
	//����hibernate�������ļ�
	Configuration configuration=new Configuration().configure();
	
	//��ȡSessionFactory
	SessionFactory factory= configuration.buildSessionFactory();
	//��ȡSession
	Session session=factory.openSession();
	//��������
	Transaction tx=session.beginTransaction();
	//����session�ķ�����ɳ־û�
	session.save(user);
	//�ύ����
	user.setAddress("ۯ��");//Sissionδ�رգ����ǳ־û�״̬
	
	tx.commit();
	
	
	//�ͷ���Դ
	factory.close();
	
	}
	
	
	
	
	
	
}
