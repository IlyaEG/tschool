package ru.tsystems.ecare.persistence.dao;

import ru.tsystems.ecare.persistence.entities.Person;

public interface PersonDAO extends GenericDAO<Person, Integer> {
	
	boolean validPerson(String login, String password);
	
	String userRole(String login);
	
}
