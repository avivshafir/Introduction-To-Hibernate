package com.simpleprogrammer;

import org.hibernate.Session;

public class Program {
	public static void main(String[] args) {
		System.out.println("Hello World");
		
		Session session = HibernateUtilities.getSessionFactory().openSession();
		session.close();
	}
}
