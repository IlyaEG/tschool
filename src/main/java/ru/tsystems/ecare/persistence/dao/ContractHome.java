package ru.tsystems.ecare.persistence.dao;

// Generated 09.10.2014 13:21:53 by Hibernate Tools 4.3.1

import java.util.List;

import javax.naming.InitialContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import ru.tsystems.ecare.persistence.entities.Contract;

/**
 * Home object for domain model class Contract.
 * @see .Contract
 * @author Hibernate Tools
 */
public class ContractHome {

	private static final Logger logger = LoggerFactory.getLogger(ContractHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext()
					.lookup("SessionFactory");
		} catch (Exception e) {
			logger.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Contract transientInstance) {
		logger.debug("persisting Contract instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			logger.debug("persist successful");
		} catch (RuntimeException re) {
			logger.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Contract instance) {
		logger.debug("attaching dirty Contract instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			logger.debug("attach successful");
		} catch (RuntimeException re) {
			logger.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Contract instance) {
		logger.debug("attaching clean Contract instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			logger.debug("attach successful");
		} catch (RuntimeException re) {
			logger.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Contract persistentInstance) {
		logger.debug("deleting Contract instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			logger.debug("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		}
	}

	public Contract merge(Contract detachedInstance) {
		logger.debug("merging Contract instance");
		try {
			Contract result = (Contract) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			logger.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			logger.error("merge failed", re);
			throw re;
		}
	}

	public Contract findById(java.lang.Integer id) {
		logger.debug("getting Contract instance with id: " + id);
		try {
			Contract instance = (Contract) sessionFactory.getCurrentSession()
					.get("Contract", id);
			if (instance == null) {
				logger.debug("get successful, no instance found");
			} else {
				logger.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			logger.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Contract instance) {
		logger.debug("finding Contract instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("Contract").add(Example.create(instance))
					.list();
			logger.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			logger.error("find by example failed", re);
			throw re;
		}
	}
}
