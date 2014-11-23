package ru.tsystems.ecare.persistence.dao;

import java.util.Set;

/**
 *
 * Generic DAO.
 *
 * @param <E>
 * @param <K>
 */
public interface GenericDAO<E, K> {

    void add(E entity);

    void update(E entity);

    void remove(E entity);

    E find(K key);

    Set<E> all();

}
