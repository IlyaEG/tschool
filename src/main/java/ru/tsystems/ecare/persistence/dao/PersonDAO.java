package ru.tsystems.ecare.persistence.dao;

import ru.tsystems.ecare.persistence.entities.Person;
import ru.tsystems.ecare.persistence.entities.Role;

public interface PersonDAO extends GenericDAO<Person, Integer> {

	Person validPerson(String login, String password);

	Role userRole(String login);

	public Person findByEmail(String email);

}
