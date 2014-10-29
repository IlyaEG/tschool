/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tsystems.ecare.dto;

import java.io.Serializable;
import ru.tsystems.ecare.persistence.entities.GenericEntity;

/**
 *
 * @author ilya
 * @param <E>
 */
public interface GenericDTO<E extends GenericEntity> extends Serializable {

    GenericDTO readEntity(E entity);

}
