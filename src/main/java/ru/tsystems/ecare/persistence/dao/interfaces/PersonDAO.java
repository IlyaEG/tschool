package ru.tsystems.ecare.persistence.dao.interfaces;

import ru.tsystems.ecare.dto.PersonDTO;
import ru.tsystems.ecare.dto.RoleDTO;
import ru.tsystems.ecare.persistence.entities.Person;

public interface PersonDAO extends GenericDAO<PersonDTO, Person> {

    PersonDTO validPerson(String login, String password);

    RoleDTO userRole(String login);

    public PersonDTO findByEmail(String email);

}
