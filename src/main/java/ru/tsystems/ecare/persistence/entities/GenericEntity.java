/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tsystems.ecare.persistence.entities;

import java.io.Serializable;
import ru.tsystems.ecare.dto.GenericDTO;

/**
 *
 * @author ilya
 * @param <D>
 */
public interface GenericEntity<D extends GenericDTO> extends Serializable {

    void readDTO(D dto);

}
