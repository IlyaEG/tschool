/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tsystems.ecare.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import ru.tsystems.ecare.ECareException;
import ru.tsystems.ecare.persistence.dao.ContractDAO;
import ru.tsystems.ecare.persistence.dao.ContractDAOImpl;
import ru.tsystems.ecare.persistence.dao.CustomerDAO;
import ru.tsystems.ecare.persistence.dao.CustomerDAOImpl;
import ru.tsystems.ecare.persistence.dao.EmployeeDAO;
import ru.tsystems.ecare.persistence.dao.EmployeeDAOImpl;
import ru.tsystems.ecare.persistence.dao.RoleDAO;
import ru.tsystems.ecare.persistence.dao.RoleDAOImpl;
import ru.tsystems.ecare.persistence.entities.Contract;
import ru.tsystems.ecare.persistence.entities.Customer;
import ru.tsystems.ecare.persistence.entities.Employee;
import ru.tsystems.ecare.persistence.entities.Person;
import ru.tsystems.ecare.persistence.entities.Role;
import ru.tsystems.ecare.persistence.utils.HibernateUtil;

/**
 *
 * @author ilya
 */
public class CustomerServiceImpl implements CustomerService {

	private static final CustomerDAO customerDAO = new CustomerDAOImpl();
	private static final ContractDAO contractDAO = new ContractDAOImpl();
	private static final RoleDAO roleDAO = new RoleDAOImpl();
	private static final EmployeeDAO employeeDAO = new EmployeeDAOImpl();

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
		HibernateUtil.beginTransaction();
		toLock.setLocked(Boolean.TRUE);
		customerDAO.save(toLock);
		HibernateUtil.commitTransaction();
	}

	@Override
	public void unlockCustomer(Customer toUnlock) {
		HibernateUtil.beginTransaction();
		toUnlock.setLocked(Boolean.FALSE);
		customerDAO.save(toUnlock);
		HibernateUtil.commitTransaction();
	}

	@Override
	public Customer findByNumber(Integer number) {
		HibernateUtil.beginTransaction();
		Contract contract = contractDAO.findByNumber(number);
		Customer customer = contract.getCustomer();
		HibernateUtil.commitTransaction();
		return customer;
	}

	@Override
	public void newCustomer(String name, String surname, String birthdate, String email,
			String password, String address, String passport) {
		try {
			HibernateUtil.beginTransaction();
			
			Customer newCustomer = new Customer();
			Person newPerson = new Person();
			newPerson.setAdress(address);
			newPerson.setName(name);
			newPerson.setSurname(surname);
			DateFormat birthdateFormat = new SimpleDateFormat("yyyy-mm-dd");
			newPerson.setBirthdate(birthdateFormat.parse(birthdate));
			newPerson.setEmail(email);
			newPerson.setPassword(password);
			newPerson.setRole(roleDAO.findByName("customer"));
			newCustomer.setPerson(newPerson);
			newCustomer.setCustomerPassport(passport);
			newCustomer.setLocked(false);
			
			customerDAO.save(newCustomer);
			
		} catch (ParseException ex) {
			throw new ECareException(ex.getMessage());
		} finally {
			HibernateUtil.commitTransaction();
		}
		
	}

	@Override
	public Customer findByPassport(String passport) {
		HibernateUtil.beginTransaction();
		Customer customer = customerDAO.findByPassport(passport);
		HibernateUtil.commitTransaction();
		return customer;
	}

	@Override
	public void newEmployee(Role role, Person person) {
		HibernateUtil.beginTransaction();
		if (role.getName().equals(roleDAO.findByName("employee").getName())) {

			Employee employee = new Employee(person);
			employeeDAO.save(employee);
		} else {
			HibernateUtil.commitTransaction();
			throw new ECareException("Wrong role for employee");
		}
		HibernateUtil.commitTransaction();

	}

	@Override
	public boolean isLocked(Customer toLock) {
		HibernateUtil.beginTransaction();
		boolean locked = false;
		try{
			locked = customerDAO.locked(toLock.getCustomerPassport());
		} catch (NullPointerException e) {
			//todo log
		}
		HibernateUtil.commitTransaction();
		return locked;
	}
}
