package aviv.example.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtilities {
	
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	
	static {
		try {
			Configuration config = new Configuration().configure("hibernate.cfg.xml");
			
		    serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
			   
			sessionFactory = config.buildSessionFactory(serviceRegistry);
			
		} catch (HibernateException ex) {
			System.out.println(ex);
			System.out.println("problem creating session factory");
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
