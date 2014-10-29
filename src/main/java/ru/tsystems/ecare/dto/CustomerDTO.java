/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tsystems.ecare.dto;

import ru.tsystems.ecare.persistence.entities.GenericEntity;


public class CustomerDTO<E extends GenericEntity> implements GenericDTO<E> {

    @Override
    public CustomerDTO readEntity(E entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getPassport() {
        //TODO Not implemented yet!
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setLocked(Boolean TRUE) {
        //TODO Not implemented yet!
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
