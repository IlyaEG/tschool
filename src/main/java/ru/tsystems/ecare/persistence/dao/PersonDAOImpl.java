package ru.tsystems.ecare.persistence.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import ru.tsystems.ecare.ECareException;
import ru.tsystems.ecare.persistence.entities.Person;

public class PersonDAOImpl extends GenericDAOImpl<Person, Integer> implements
		PersonDAO {

	@Override
	public boolean validPerson(String login, String password) {
		Session hibernateSession = this.getSession();
		Query query = hibernateSession.getNamedQuery("PersonByEmail&Password");
		query.setString("userEmail", login);
		query.setString("userPassword", password);
		Person person = (Person)query.uniqueResult();
		if (person != null && person.getEmail().equalsIgnoreCase(login) && person.getPassword().equals(password)) {
			return true;
		} else {
			throw new ECareException("Wrong Login, Password pair");
		}
	}

	@Override
	public String userRole(String login) {
		Session hibernateSession = this.getSession();
		Query query = hibernateSession.getNamedQuery("PersonRole");
		query.setString("userEmail", login);
		return (String)query.uniqueResult();
	}
}
