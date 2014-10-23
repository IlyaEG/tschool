/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tsystems.ecare.services;

import java.util.List;
import ru.tsystems.ecare.persistence.dao.CustomerDAO;
import ru.tsystems.ecare.persistence.dao.CustomerDAOImpl;
import ru.tsystems.ecare.persistence.dao.RoleDAO;
import ru.tsystems.ecare.persistence.dao.RoleDAOImpl;
import ru.tsystems.ecare.persistence.entities.Contract;
import ru.tsystems.ecare.persistence.entities.Customer;
import ru.tsystems.ecare.persistence.entities.Person;
import ru.tsystems.ecare.persistence.utils.HibernateUtil;

/**
 *
 * @author ilya
 */
public class CustomerServiceImpl implements CustomerService {

	private static CustomerDAO customerDAO = new CustomerDAOImpl();
	private static RoleDAO roleDAO = new RoleDAOImpl();

	@Override
	public List<Customer> getAllCustomers() {
		HibernateUtil.beginTransaction();
		List<Customer> customers = customerDAO.findAll(Customer.class);
		HibernateUtil.commitTransaction();
		return customers;
	}

	@Override
	public List<Contract> getAllContracts() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void lockCustomer(Customer toLock) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void unlockCustomer(Customer toUnlock) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Customer findByNumber(Integer number) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void newCustomer(String name, String surname, String email,
			String password, String address, String passport) {
		HibernateUtil.beginTransaction();

		Customer newCustomer = new Customer();
		Person newPerson = new Person();
		newPerson.setAdress(address);
		newPerson.setName(name);
		newPerson.setSurname(surname);
		newPerson.setEmail(email);
		newPerson.setPassword(password);
		newPerson.setRole(roleDAO.findByName("customer"));
		newCustomer.setPerson(newPerson);
		newCustomer.setCustomerPassport(passport);

		customerDAO.save(newCustomer);

		HibernateUtil.commitTransaction();
	}

	@Override
	public Customer findByPassport(String passport) {
		HibernateUtil.beginTransaction();
		Customer customer = customerDAO.findByPassport(passport);
		HibernateUtil.commitTransaction();
		return customer;
	}
}
