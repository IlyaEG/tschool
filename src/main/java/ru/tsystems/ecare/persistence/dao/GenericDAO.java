package ru.tsystems.ecare.persistence.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;

public interface GenericDAO<T, ID extends Serializable> {
    
	void justSave(T entity);
	
	void save(T entity);
 
    void merge(T entity);
 
    void delete(T entity);
 
    List<T> findMany(Query query);
 
    T findOne(Query query);
 
    List<T> findAll(Class<?> clazz);
 
    T findByID(Class<?> clazz, Integer id);
}