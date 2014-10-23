package ru.tsystems.ecare.services;

import ru.tsystems.ecare.persistence.dao.PersonDAO;
import ru.tsystems.ecare.persistence.dao.PersonDAOImpl;
import ru.tsystems.ecare.persistence.entities.Person;
import ru.tsystems.ecare.persistence.entities.Role;
import ru.tsystems.ecare.persistence.utils.HibernateUtil;

public class LoginServiceImpl implements LoginService {

	private static PersonDAO personDAO = new PersonDAOImpl();

	@Override
	public Person userValid(String login, String password) {
		HibernateUtil.beginTransaction();
		Person validPerson = personDAO.validPerson(login, password);
		HibernateUtil.commitTransaction();

		return validPerson;

	}

	@Override
	public Role userRole(String login) {
		HibernateUtil.beginTransaction();
		Role role = personDAO.userRole(login);
		HibernateUtil.commitTransaction();
		return role;

	}

}
