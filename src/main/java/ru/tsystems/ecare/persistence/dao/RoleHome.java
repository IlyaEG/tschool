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

import ru.tsystems.ecare.persistence.entities.Role;

/**
 * Home object for domain model class Role.
 * @see .Role
 * @author Hibernate Tools
 */
public class RoleHome {

	private static final Logger logger = LoggerFactory.getLogger(RoleHome.class);

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

	public void persist(Role transientInstance) {
		logger.debug("persisting Role instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			logger.debug("persist successful");
		} catch (RuntimeException re) {
			logger.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Role instance) {
		logger.debug("attaching dirty Role instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			logger.debug("attach successful");
		} catch (RuntimeException re) {
			logger.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Role instance) {
		logger.debug("attaching clean Role instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			logger.debug("attach successful");
		} catch (RuntimeException re) {
			logger.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Role persistentInstance) {
		logger.debug("deleting Role instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			logger.debug("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		}
	}

	public Role merge(Role detachedInstance) {
		logger.debug("merging Role instance");
		try {
			Role result = (Role) sessionFactory.getCurrentSession().merge(
					detachedInstance);
			logger.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			logger.error("merge failed", re);
			throw re;
		}
	}

	public Role findById(java.lang.Integer id) {
		logger.debug("getting Role instance with id: " + id);
		try {
			Role instance = (Role) sessionFactory.getCurrentSession().get(
					"Role", id);
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

	public List findByExample(Role instance) {
		logger.debug("finding Role instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("Role").add(Example.create(instance))
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
