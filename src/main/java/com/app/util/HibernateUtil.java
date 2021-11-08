package com.app.util;

import java.io.File;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.app.constant.AppConstant;

public final class HibernateUtil {
	
	private static Session session = null;
	
	private static SessionFactory sessionFactory = null;
	
	private HibernateUtil() {}

	public synchronized static void initSessionFactory() {
		System.out.println("Session Factory initialized");
		sessionFactory = new Configuration().configure(new File(AppConstant.HIBERNATE_CFG_LOCATION))
				.buildSessionFactory();
	}
	
	public static Session getSession() {
		session = sessionFactory.openSession();
		return session;
	}
	
	public static Session getSession(SessionFactory sessionFactory) {
		session = sessionFactory.openSession();
		return session;
	}
	
	public static void closeSession() {
		session.close();
	}
	
	public static void closeSessionFactory() {
		sessionFactory.close();
	}
}
