package ru.tsystems.ecare.services;

import ru.tsystems.ecare.ECareException;
import ru.tsystems.ecare.persistence.dao.PersonDAO;
import ru.tsystems.ecare.persistence.utils.HibernateUtil;

public class LoginServiceImpl implements LoginService {

	private PersonDAO personDAO;

	@Override
	public boolean userValid(String login, String password) {
		try {
			HibernateUtil.beginTransaction();
			return personDAO.validPerson(login, password);
		} catch (ECareException e) {
			// TODO logger.log
			throw (e);
		} finally {
			HibernateUtil.commitTransaction();
		}

	}

	@Override
	public String userRole(String login) {
		HibernateUtil.beginTransaction();
		String role = personDAO.userRole(login);
		HibernateUtil.commitTransaction();
		return role;

	}

}
