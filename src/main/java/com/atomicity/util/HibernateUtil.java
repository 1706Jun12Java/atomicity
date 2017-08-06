package com.atomicity.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;

	private static SessionFactory sessionFactory() {
		if(sessionFactory != null) {
			return sessionFactory;
		}
		else {
			Configuration c = new Configuration().configure("hibernate.cfg.xml");
			ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(c.getProperties()).build();
			sessionFactory = c.buildSessionFactory(sr);
			return sessionFactory;
		}
		
	}

	public static Session getSession() {
		
		return sessionFactory().openSession();
	}
}