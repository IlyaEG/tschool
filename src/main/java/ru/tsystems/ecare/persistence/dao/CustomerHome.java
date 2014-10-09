package ru.tsystems.ecare.persistence.dao;
// default package
// Generated 09.10.2014 13:21:53 by Hibernate Tools 4.3.1

import java.util.List;

import javax.naming.InitialContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import ru.tsystems.ecare.persistence.entities.Customer;

/**
 * Home object for domain model class Customer.
 * @see .Customer
 * @author Hibernate Tools
 */
public class CustomerHome {

	private static final Logger loger = LoggerFactory.getLogger(CustomerHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext()
					.lookup("SessionFactory");
		} catch (Exception e) {
			loger.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Customer transientInstance) {
		loger.debug("persisting Customer instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			loger.debug("persist successful");
		} catch (RuntimeException re) {
			loger.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Customer instance) {
		loger.debug("attaching dirty Customer instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			loger.debug("attach successful");
		} catch (RuntimeException re) {
			loger.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Customer instance) {
		loger.debug("attaching clean Customer instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			loger.debug("attach successful");
		} catch (RuntimeException re) {
			loger.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Customer persistentInstance) {
		loger.debug("deleting Customer instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			loger.debug("delete successful");
		} catch (RuntimeException re) {
			loger.error("delete failed", re);
			throw re;
		}
	}

	public Customer merge(Customer detachedInstance) {
		loger.debug("merging Customer instance");
		try {
			Customer result = (Customer) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			loger.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			loger.error("merge failed", re);
			throw re;
		}
	}

	public Customer findById(java.lang.Integer id) {
		loger.debug("getting Customer instance with id: " + id);
		try {
			Customer instance = (Customer) sessionFactory.getCurrentSession()
					.get("Customer", id);
			if (instance == null) {
				loger.debug("get successful, no instance found");
			} else {
				loger.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			loger.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Customer instance) {
		loger.debug("finding Customer instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("Customer").add(Example.create(instance))
					.list();
			loger.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			loger.error("find by example failed", re);
			throw re;
		}
	}
}
