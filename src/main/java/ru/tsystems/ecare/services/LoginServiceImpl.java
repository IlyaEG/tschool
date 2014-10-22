package ru.tsystems.ecare.services;

import ru.tsystems.ecare.persistence.dao.PersonDAO;
import ru.tsystems.ecare.persistence.dao.PersonDAOImpl;
import ru.tsystems.ecare.persistence.utils.HibernateUtil;

public class LoginServiceImpl implements LoginService {

	private static PersonDAO personDAO = new PersonDAOImpl();

	@Override
	public boolean userValid(String login, String password) {
		HibernateUtil.beginTransaction();
		boolean personIsValid = personDAO.validPerson(login, password);
		HibernateUtil.commitTransaction();
		
		return personIsValid;

	}

	@Override
	public String userRole(String login) {
		HibernateUtil.beginTransaction();
		String role = personDAO.userRole(login).getName();
		HibernateUtil.commitTransaction();
		return role;

	}

}
