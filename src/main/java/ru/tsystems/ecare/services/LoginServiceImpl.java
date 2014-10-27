package ru.tsystems.ecare.services;

import ru.tsystems.ecare.persistence.dao.CustomerDAO;
import ru.tsystems.ecare.persistence.dao.CustomerDAOImpl;
import ru.tsystems.ecare.persistence.dao.PersonDAO;
import ru.tsystems.ecare.persistence.dao.PersonDAOImpl;
import ru.tsystems.ecare.persistence.dao.RoleDAO;
import ru.tsystems.ecare.persistence.dao.RoleDAOImpl;
import ru.tsystems.ecare.persistence.entities.Customer;
import ru.tsystems.ecare.persistence.entities.Person;
import ru.tsystems.ecare.persistence.entities.Role;
import ru.tsystems.ecare.persistence.utils.HibernateUtil;

public class LoginServiceImpl implements LoginService {

	private static final PersonDAO personDAO = new PersonDAOImpl();
	private static final RoleDAO roleDAO = new RoleDAOImpl();
	private static final CustomerDAO customerDAO = new CustomerDAOImpl();

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

	@Override
	public Role findRoleByName(String roleName) {
		HibernateUtil.beginTransaction();
		Role role = roleDAO.findByName(roleName);
		HibernateUtil.commitTransaction();
		return role;
	}

	@Override
	public Customer findByEmail(String email) {
		HibernateUtil.beginTransaction();
		Person person = personDAO.findByEmail(email);
		Customer customer = customerDAO.findByID(Customer.class, person.getId());
		HibernateUtil.commitTransaction();
		return customer;
	}

	@Override
	public void closeSession() {
		HibernateUtil.closeSession();
	}

}
