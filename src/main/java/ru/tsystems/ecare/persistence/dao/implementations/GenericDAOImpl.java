package ru.tsystems.ecare.persistence.dao.implementations;

import ru.tsystems.ecare.persistence.dao.interfaces.GenericDAO;
import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import ru.tsystems.ecare.dto.GenericDTO;
import ru.tsystems.ecare.persistence.entities.GenericEntity;

import ru.tsystems.ecare.persistence.utils.HibernateUtil;

public abstract class GenericDAOImpl<T extends GenericDTO, E extends GenericEntity>
        implements GenericDAO<T, E> {

    protected Session getSession() {
        return HibernateUtil.getSession();
    }

    @Override
    public void justSave(T entity) {
        //todo dto --> entity
        Session hibernateSession = this.getSession();
        hibernateSession.save(entity);
    }

    public void save(T entity) {
        //todo dto --> entity
        Session hibernateSession = this.getSession();
        hibernateSession.saveOrUpdate(entity);
    }

    @Override
    public void merge(T entity) {
        //todo dto --> entity
        Session hibernateSession = this.getSession();
        hibernateSession.merge(entity);
    }

    @Override
    public void delete(T entity) {
        //todo dto --> entity
        Session hibernateSession = this.getSession();
        hibernateSession.delete(entity);
    }

    @SuppressWarnings("unchecked")
    @Override
    public T findByID(Class<T> clazz, Integer id) {
        //todo dto --> entity
        Session hibernateSession = this.getSession();
        T t = null;
        t = (T) hibernateSession.get(clazz, id);
        return t;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> findAll(Class<T> clazz) {
        //todo dto --> entity
        Session hibernateSession = this.getSession();
        List<T> T = null;
        Query query = hibernateSession.createQuery("from " + clazz.getName());
        T = query.list();
        return T;
    }
}
