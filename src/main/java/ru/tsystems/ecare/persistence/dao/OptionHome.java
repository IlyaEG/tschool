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

import ru.tsystems.ecare.persistence.entities.Option;

/**
 * Home object for domain model class Option.
 * @see .Option
 * @author Hibernate Tools
 */
public class OptionHome {

	private static final Logger logger = LoggerFactory.getLogger(OptionHome.class);

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

	public void persist(Option transientInstance) {
		logger.debug("persisting Option instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			logger.debug("persist successful");
		} catch (RuntimeException re) {
			logger.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Option instance) {
		logger.debug("attaching dirty Option instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			logger.debug("attach successful");
		} catch (RuntimeException re) {
			logger.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Option instance) {
		logger.debug("attaching clean Option instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			logger.debug("attach successful");
		} catch (RuntimeException re) {
			logger.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Option persistentInstance) {
		logger.debug("deleting Option instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			logger.debug("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		}
	}

	public Option merge(Option detachedInstance) {
		logger.debug("merging Option instance");
		try {
			Option result = (Option) sessionFactory.getCurrentSession().merge(
					detachedInstance);
			logger.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			logger.error("merge failed", re);
			throw re;
		}
	}

	public Option findById(java.lang.Integer id) {
		logger.debug("getting Option instance with id: " + id);
		try {
			Option instance = (Option) sessionFactory.getCurrentSession().get(
					"Option", id);
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

	public List findByExample(Option instance) {
		logger.debug("finding Option instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("Option").add(Example.create(instance))
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
