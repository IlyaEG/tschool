package ru.tsystems.ecare.persistence.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import ru.tsystems.ecare.persistence.utils.HibernateUtil;

public abstract class GenericDAOImpl<T, ID extends Serializable> implements
		GenericDAO<T, ID> {
	
	protected Session getSession() {
		return HibernateUtil.getSession();
	}

	@Override
	public void justSave(T entity) {
			Session hibernateSession = this.getSession();
			hibernateSession.save(entity);
	}
	
	public void save(T entity) {
			Session hibernateSession = this.getSession();
			hibernateSession.saveOrUpdate(entity);
	}

	@Override
	public void merge(T entity) {
		Session hibernateSession = this.getSession();
		hibernateSession.merge(entity);
	}

	@Override
	public void delete(T entity) {
		Session hibernateSession = this.getSession();
		hibernateSession.delete(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findMany(Query query) {
		List<T> t;
		t = (List<T>) query.list();
		return t;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findOne(Query query) {
		T t;
		t = (T) query.uniqueResult();
		return t;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findByID(Class<?> clazz, Integer id) {
		Session hibernateSession = this.getSession();
		T t = null;
		t = (T) hibernateSession.get(clazz, id);
		return t;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll(Class<?> clazz) {
		Session hibernateSession = this.getSession();
		List<T> T = null;
		Query query = hibernateSession.createQuery("from " + clazz.getName());
		T = query.list();
		return T;
	}
}
