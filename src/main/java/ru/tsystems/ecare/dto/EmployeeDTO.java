/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tsystems.ecare.dto;

import ru.tsystems.ecare.persistence.entities.GenericEntity;


public class EmployeeDTO<E extends GenericEntity> implements GenericDTO<E> {

    @Override
    public GenericDTO readEntity(E entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
