package ru.tsystems.ecare.services.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.ecare.persistence.dao.CustomerDAO;
import ru.tsystems.ecare.persistence.dao.PersonDAO;
import ru.tsystems.ecare.persistence.dao.RoleDAO;
import ru.tsystems.ecare.persistence.entities.Customer;
import ru.tsystems.ecare.persistence.entities.Person;
import ru.tsystems.ecare.persistence.entities.Role;
import ru.tsystems.ecare.services.LoginService;

@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
@Service("loginService")
public class LoginServiceImpl implements LoginService {

    // dependencies
    private SessionFactory sessionFactory;
    private PersonDAO personDAO;
    private RoleDAO roleDAO;
    private CustomerDAO customerDAO;

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
    public void setRoleDAO(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public CustomerDAO getCustomerDAO() {
        return customerDAO;
    }

    public RoleDAO getRoleDAO() {
        return roleDAO;
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Person userValid(String login, String password) {
        Person validPerson = personDAO.validPerson(login, password);
        return validPerson;

    }

    @Override
    public Role findRoleByName(String roleName) {
        Role role = roleDAO.findByName(roleName);
        return role;
    }

    @Override
    public Customer findByEmail(String email) {
        Person person = personDAO.findByEmail(email);
        Customer customer = customerDAO.find(person.getId());
        return customer;
    }

    @Override
    public String getNameByEmail(String email) {
        Person person = personDAO.findByEmail(email);
        String name = person.getName();
        return name;
    }

}
