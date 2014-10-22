package ru.tsystems.ecare.persistence.dao;

import ru.tsystems.ecare.persistence.entities.Person;
import ru.tsystems.ecare.persistence.entities.Role;

public interface PersonDAO extends GenericDAO<Person, Integer> {
	
	boolean validPerson(String login, String password);
	
	Role userRole(String login);
	
}
