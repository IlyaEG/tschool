package ru.tsystems.ecare.persistence.dao;

import ru.tsystems.ecare.persistence.entities.Person;
import ru.tsystems.ecare.persistence.entities.Role;

/**
 * DAO of person.
 */
public interface PersonDAO extends GenericDAO<Person, Integer> {

	Person validPerson(String login, String password);

	Role personRole(Person person);

	Person findByEmail(String email);

}
