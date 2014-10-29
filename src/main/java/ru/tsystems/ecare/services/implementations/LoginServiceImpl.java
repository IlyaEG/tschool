package ru.tsystems.ecare.services.implementations;

import ru.tsystems.ecare.services.interfaces.LoginService;
import ru.tsystems.ecare.dto.CustomerDTO;
import ru.tsystems.ecare.dto.PersonDTO;
import ru.tsystems.ecare.dto.RoleDTO;
import ru.tsystems.ecare.persistence.dao.interfaces.CustomerDAO;
import ru.tsystems.ecare.persistence.dao.implementations.CustomerDAOImpl;
import ru.tsystems.ecare.persistence.dao.interfaces.PersonDAO;
import ru.tsystems.ecare.persistence.dao.implementations.PersonDAOImpl;
import ru.tsystems.ecare.persistence.dao.interfaces.RoleDAO;
import ru.tsystems.ecare.persistence.dao.implementations.RoleDAOImpl;
import ru.tsystems.ecare.persistence.utils.HibernateUtil;

public class LoginServiceImpl implements LoginService {

    private static final PersonDAO personDAO = new PersonDAOImpl();
    private static final RoleDAO roleDAO = new RoleDAOImpl();
    private static final CustomerDAO customerDAO = new CustomerDAOImpl();

    @Override
    public PersonDTO userValid(String login, String password) {
        HibernateUtil.beginTransaction();
        PersonDTO validPerson = personDAO.validPerson(login, password);
        HibernateUtil.commitTransaction();
        return validPerson;

    }

    @Override
    public RoleDTO userRole(String login) {
        HibernateUtil.beginTransaction();
        RoleDTO role = personDAO.userRole(login);
        HibernateUtil.commitTransaction();
        return role;

    }

    @Override
    public RoleDTO findRoleByName(String roleName) {
        HibernateUtil.beginTransaction();
        RoleDTO role = roleDAO.findByName(roleName);
        HibernateUtil.commitTransaction();
        return role;
    }

    @Override
    public CustomerDTO findByEmail(String email) {
        HibernateUtil.beginTransaction();
        PersonDTO person = personDAO.findByEmail(email);
        CustomerDTO customer = customerDAO.findByID(CustomerDTO.class, person.getId());
        HibernateUtil.commitTransaction();
        return customer;
    }

    @Override
    public void closeSession() {
        HibernateUtil.closeSession();
    }

}
