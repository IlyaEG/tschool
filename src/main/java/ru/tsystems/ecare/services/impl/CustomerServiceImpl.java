/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tsystems.ecare.services.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.ecare.ECareException;
import ru.tsystems.ecare.persistence.dao.ContractDAO;
import ru.tsystems.ecare.persistence.dao.CustomerDAO;
import ru.tsystems.ecare.persistence.dao.EmployeeDAO;
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
    public List<Customer> getAllCustomers() {
        List<Customer> customers = customerDAO.list();
        return customers;
    }

    @Override
    public List<Contract> getAllContracts() {
        //todo
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void lockCustomer(Customer toLock) {
        toLock.setLocked(Boolean.TRUE);
        customerDAO.update(toLock);
    }

    @Override
    public void unlockCustomer(Customer toUnlock) {
        toUnlock.setLocked(Boolean.FALSE);
        customerDAO.update(toUnlock);
    }

    @Override
    public Customer findByNumber(Integer number) {
        Contract contract = contractDAO.findByNumber(number);
        Customer customer = contract.getCustomer();
        return customer;
    }

    @Override
    public void newCustomer(String name, String surname, String birthdate, String email,
            String password, String address, String passport) {
        try {
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

            customerDAO.add(newCustomer);
        }
        catch (ParseException ex) {
            throw new ECareException(ex.getMessage());
        }
    }

    @Override
    public Customer findByPassport(String passport) {
        Customer customer = customerDAO.findByPassport(passport);
        return customer;
    }

    @Override
    public void newEmployee(Role role, Person person) {
        if (role.getName().equals(roleDAO.findByName("employee").getName())) {

            Employee employee = new Employee(person);
            employeeDAO.add(employee);
        } else {
            throw new ECareException("Wrong role for employee");
        }

    }

    @Override
    public boolean isLocked(Customer toLock) {
        boolean locked = false;
        try {
            locked = customerDAO.lockStatus(toLock);
        }
        catch (NullPointerException e) {
            //todo log
        }
        return locked;
    }
}
