/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tsystems.ecare.services.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.ecare.exceptions.ECareException;
import ru.tsystems.ecare.persistence.dao.ContractDAO;
import ru.tsystems.ecare.persistence.dao.CustomerDAO;
import ru.tsystems.ecare.persistence.dao.EmployeeDAO;
import ru.tsystems.ecare.persistence.dao.PersonDAO;
import ru.tsystems.ecare.persistence.dao.RoleDAO;
import ru.tsystems.ecare.persistence.entities.Contract;
import ru.tsystems.ecare.persistence.entities.Customer;
import ru.tsystems.ecare.persistence.entities.Employee;
import ru.tsystems.ecare.persistence.entities.Person;
import ru.tsystems.ecare.persistence.entities.Role;
import ru.tsystems.ecare.services.CustomerService;

/**
 *
 * @author ilya
 */
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

    // dependencies
    private SessionFactory sessionFactory;
    private CustomerDAO customerDAO;
    private ContractDAO contractDAO;
    private RoleDAO roleDAO;
    private EmployeeDAO employeeDAO;
    private PersonDAO personDAO;

    public PersonDAO getPersonDAO() {
        return personDAO;
    }

    @Autowired
    public void setPersonDAO(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Autowired
    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Autowired
    public void setContractDAO(ContractDAO contractDAO) {
        this.contractDAO = contractDAO;
    }

    @Autowired
    public void setRoleDAO(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Autowired
    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public CustomerDAO getCustomerDAO() {
        return customerDAO;
    }

    public ContractDAO getContractDAO() {
        return contractDAO;
    }

    public RoleDAO getRoleDAO() {
        return roleDAO;
    }

    public EmployeeDAO getEmployeeDAO() {
        return employeeDAO;
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Set<Customer> getAllCustomers() {
        return customerDAO.all();
    }

    @Override
    public Set<Contract> getAllContracts(final Customer customer) {
        return customerDAO.getContracts(customer);
    }

    @Override
    public void lockCustomer(final Customer toLock) {
        toLock.setLocked(Boolean.TRUE);
        customerDAO.update(toLock);
    }

    @Override
    public void unlockCustomer(final Customer toUnlock) {
        toUnlock.setLocked(Boolean.FALSE);
        customerDAO.update(toUnlock);
    }

    @Override
    public Customer findByNumber(final Integer number) {
        Contract contract = contractDAO.findByNumber(number);
        Customer customer = contract.getCustomer();
        return customer;
    }

    @Override
    public void saveCustomer(final String name, final String surname,
            final String birthdate, final String email,
            final String password, final String address,
            final String passport) {
        try {
            Person person;
            Customer customer = customerDAO.findByPassport(passport);
            if (customer == null) {
                if (personDAO.findByEmail(email) != null) {
                    throw new ECareException("Customer with same email ["
                            + email + "]"
                            + " is already registered in the system!");
                }
                customer = new Customer();
                person = new Person();
            } else {
                person = customer.getPerson();
            }
            person.setAdress(address);
            person.setName(name);
            person.setSurname(surname);
            DateFormat birthdateFormat = new SimpleDateFormat("yyyy-mm-dd");
            person.setBirthdate(birthdateFormat.parse(birthdate));
            person.setEmail(email);
            person.setPassword(password);
            person.setRole(roleDAO.findByName("customer"));
            customer.setPerson(person);
            customer.setCustomerPassport(passport);
            customer.setLocked(false);

            customerDAO.update(customer);
        } catch (ParseException ex) {
            throw new ECareException(ex.getMessage());
        }
    }

    @Override
    public Customer findByPassport(final String passport) {
        Customer customer = customerDAO.findByPassport(passport);
        return customer;
    }

    @Override
    public final void newEmployee(final Role role, final Person person) {
        if (role.getName().equals(roleDAO.findByName("employee").getName())) {

            Employee employee = new Employee(person);
            employeeDAO.add(employee);
        } else {
            throw new ECareException("Wrong role for employee");
        }

    }

    @Override
    public final boolean isLocked(final Customer toLock) {
        try {
            return customerDAO.lockStatus(toLock);
        } catch (NullPointerException e) {
            return false;
        }
    }

    @Override
    public final void deleteCustomer(final Integer customerId) {
        Customer c = customerDAO.find(customerId);
        Set<Contract> contracts = c.getContracts();
        for (Contract contract : contracts) {
            contractDAO.remove(contract);
        }
        int id = c.getPersonId();
        customerDAO.remove(customerDAO.find(id));
        personDAO.remove(personDAO.find(id));

    }

    @Override
    public final void changePassword(final Customer customer,
            final String password) {
        try {
            Person person = customer.getPerson();
            person.setPassword(password);
            personDAO.update(person);
        } catch (Exception e) {
            throw new ECareException(e.getMessage());
        }

    }

    @Override
    public final Customer findByID(final int id) {
        Customer c = customerDAO.find(id);
        if (c == null) {
            throw new ECareException("Customer not found!");
        }
        return c;
    }
}
