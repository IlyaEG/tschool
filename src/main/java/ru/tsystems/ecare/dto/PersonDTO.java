/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tsystems.ecare.dto;

import ru.tsystems.ecare.persistence.entities.GenericEntity;
import ru.tsystems.ecare.persistence.entities.Person;


public class PersonDTO<E extends GenericEntity> implements GenericDTO<Person> {

    @Override
    public PersonDTO readEntity(Person entity) {
        //todo
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Integer getId(){
        //todo
        return null;
    }
    
}
