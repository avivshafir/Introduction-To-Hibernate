package aviv.example.hibernate;

import org.hibernate.Session;

public class Program {
	public static void main(String[] args) {
		System.out.println("Hello World");
		
		Session session = HibernateUtilities.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		User user = new User();
		user.setName("Joe");
		user.setGoal(250);
		session.save(user);
		
		session.getTransaction().commit();
		
		session.beginTransaction();
		
		//User loadedUser = (User)session.get(User.class, 1);
		User loadedUser = (User)session.load(User.class, 1);
		System.out.println(loadedUser.getName());
		System.out.println(loadedUser.getGoal());
		
		loadedUser.setTotal(loadedUser.getTotal() + 50);
		
		session.getTransaction().commit();
		
		session.close();
		HibernateUtilities.getSessionFactory().close();
	}
}
