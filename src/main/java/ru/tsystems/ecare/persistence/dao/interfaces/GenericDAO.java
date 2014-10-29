package ru.tsystems.ecare.persistence.dao.interfaces;

import java.io.Serializable;
import java.util.List;

import ru.tsystems.ecare.dto.GenericDTO;
import ru.tsystems.ecare.persistence.entities.GenericEntity;

/**
 *
 * @author ilya
 * @param <T>
 */
public interface GenericDAO<T extends GenericDTO, E extends GenericEntity>
        extends Serializable {

    void justSave(T dto);

    void save(T dto);

    void merge(T dto);

    void delete(T dto);

    List<T> findAll(Class<T> clazz);

    T findByID(Class<T> clazz, Integer id);
}
