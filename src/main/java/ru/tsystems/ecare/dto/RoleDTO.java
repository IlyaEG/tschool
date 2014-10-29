/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tsystems.ecare.dto;

import java.util.Set;
import ru.tsystems.ecare.persistence.entities.Contract;
import ru.tsystems.ecare.persistence.entities.GenericEntity;
import ru.tsystems.ecare.persistence.entities.Person;
import ru.tsystems.ecare.persistence.entities.Role;


public class RoleDTO<E extends GenericEntity> implements GenericDTO<Role> {
    private Integer id;
    private String name;
    private Set<Person> persons;
    private Set<Contract> contracts;

    @Override
    public RoleDTO readEntity(final Role entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.persons = entity.getPersons();
        this.contracts = entity.getContracts();
        return this;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Person> getPersons() {
        return persons;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

}
