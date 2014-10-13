package ru.tsystems.ecare.persistence.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	private static final Logger logger = LoggerFactory.getLogger(HibernateUtil.class);

	static {
		try {
			// Create the SessionFactory from standard (hibernate.cfg.xml)
			// config file.
			// sessionFactory = new AnnotationConfiguration().configure()
			// .buildSessionFactory();
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			logger.debug("Hibernate Annotation Configuration loaded");

			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			logger.debug("Hibernate Annotation serviceRegistry created");

			sessionFactory = configuration
					.buildSessionFactory(serviceRegistry);

		} catch (Throwable ex) {
			// Log the exception.
			logger.error("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static Session beginTransaction() {
		Session hibernateSession = HibernateUtil.getSession();
		hibernateSession.beginTransaction();
		return hibernateSession;
	}

	public static void commitTransaction() {
		HibernateUtil.getSession().getTransaction().commit();
	}

	public static void rollbackTransaction() {
		HibernateUtil.getSession().getTransaction().rollback();
	}

	public static void closeSession() {
		HibernateUtil.getSession().close();
	}

	public static Session getSession() {
		Session hibernateSession = sessionFactory.getCurrentSession();
		return hibernateSession;
	}
}
