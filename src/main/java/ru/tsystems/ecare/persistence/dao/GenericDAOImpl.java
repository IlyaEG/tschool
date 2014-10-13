package ru.tsystems.ecare.persistence.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.tsystems.ecare.persistence.utils.HibernateUtil;

public abstract class GenericDAOImpl<T, ID extends Serializable> implements
		GenericDAO<T, ID> {

	private static final Logger logger = LoggerFactory
			.getLogger(GenericDAOImpl.class);

	protected Session getSession() {
		return HibernateUtil.getSession();
	}

	public void save(T entity) {
		logger.debug("saving entity " + this.toString());
		try {
			Session hibernateSession = this.getSession();
			hibernateSession.saveOrUpdate(entity);
			logger.error("saving successful");
		} catch (RuntimeException re) {
			logger.error("saving failed", re);
			throw re;
		}
	}

	public void merge(T entity) {
		Session hibernateSession = this.getSession();
		hibernateSession.merge(entity);
	}

	public void delete(T entity) {
		Session hibernateSession = this.getSession();
		hibernateSession.delete(entity);
	}

	@SuppressWarnings("unchecked")
	public List<T> findMany(Query query) {
		List<T> t;
		t = (List<T>) query.list();
		return t;
	}

	@SuppressWarnings("unchecked")
	public T findOne(Query query) {
		T t;
		t = (T) query.uniqueResult();
		return t;
	}

	@SuppressWarnings("unchecked")
	public T findByID(Class<?> clazz, Integer id) {
		Session hibernateSession = this.getSession();
		T t = null;
		t = (T) hibernateSession.get(clazz, id);
		return t;
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll(Class<?> clazz) {
		Session hibernateSession = this.getSession();
		List<T> T = null;
		Query query = hibernateSession.createQuery("from " + clazz.getName());
		T = query.list();
		return T;
	}
}
