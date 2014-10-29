/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tsystems.ecare.services.implementations;

import ru.tsystems.ecare.services.interfaces.CustomerService;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import ru.tsystems.ecare.ECareException;
import ru.tsystems.ecare.dto.ContractDTO;
import ru.tsystems.ecare.dto.CustomerDTO;
import ru.tsystems.ecare.dto.EmployeeDTO;
import ru.tsystems.ecare.dto.PersonDTO;
import ru.tsystems.ecare.dto.RoleDTO;
import ru.tsystems.ecare.persistence.dao.interfaces.ContractDAO;
import ru.tsystems.ecare.persistence.dao.implementations.ContractDAOImpl;
import ru.tsystems.ecare.persistence.dao.interfaces.CustomerDAO;
import ru.tsystems.ecare.persistence.dao.implementations.CustomerDAOImpl;
import ru.tsystems.ecare.persistence.dao.interfaces.EmployeeDAO;
import ru.tsystems.ecare.persistence.dao.implementations.EmployeeDAOImpl;
import ru.tsystems.ecare.persistence.dao.interfaces.RoleDAO;
import ru.tsystems.ecare.persistence.dao.implementations.RoleDAOImpl;
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
    public List<CustomerDTO> getAllCustomers() {
        HibernateUtil.beginTransaction();
        List<CustomerDTO> customers = customerDAO.findAll(CustomerDTO.class);
        HibernateUtil.commitTransaction();
        return customers;
    }

    @Override
    public List<ContractDTO> getAllContracts() {
        //todo if needed
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void lockCustomer(CustomerDTO toLock) {
        HibernateUtil.beginTransaction();
        toLock.setLocked(Boolean.TRUE);
        customerDAO.save(toLock);
        HibernateUtil.commitTransaction();
    }

    @Override
    public void unlockCustomer(CustomerDTO toUnlock) {
        HibernateUtil.beginTransaction();
        toUnlock.setLocked(Boolean.FALSE);
        customerDAO.save(toUnlock);
        HibernateUtil.commitTransaction();
    }

    @Override
    public CustomerDTO findByNumber(Integer number) {
        HibernateUtil.beginTransaction();
        ContractDTO contract = contractDAO.findByNumber(number);
        CustomerDTO customer = contract.getCustomer();
        HibernateUtil.commitTransaction();
        return customer;
    }

    @Override
    public void newCustomer(CustomerDTO newCustomer) {
        try {
            HibernateUtil.beginTransaction();

//            CustomerDTO newCustomer = new CustomerDTO();
//            PersonDTO newPerson = new PersonDTO();
//            todo
//            newPerson.setAdress(address);
//            newPerson.setName(name);
//            newPerson.setSurname(surname);
//            DateFormat birthdateFormat = new SimpleDateFormat("yyyy-mm-dd");
//            newPerson.setBirthdate(birthdateFormat.parse(birthdate));
//            newPerson.setEmail(email);
//            newPerson.setPassword(password);
//            newPerson.setRole(roleDAO.findByName("customer"));
//            newCustomer.setPerson(newPerson);
//            newCustomer.setCustomerPassport(passport);
//            newCustomer.setLocked(false);

            customerDAO.save(newCustomer);

//        } catch (ParseException ex) {
//            throw new ECareException(ex.getMessage());
        } finally {
            HibernateUtil.commitTransaction();
        }

    }

    @Override
    public CustomerDTO findByPassport(String passport) {
        HibernateUtil.beginTransaction();
        CustomerDTO customer = customerDAO.findByPassport(passport);
        HibernateUtil.commitTransaction();
        return customer;
    }

    @Override
    public void newEmployee(EmployeeDTO newEmployee) {
        HibernateUtil.beginTransaction();
//        if (role.getName().equals(roleDAO.findByName("employee").getName())) {
////todo
////            EmployeeDTO employee = new EmployeeDTO(person);
////            employeeDAO.save(employee);
//        } else {
//            HibernateUtil.commitTransaction();
//            throw new ECareException("Wrong role for employee");
//        }
        HibernateUtil.commitTransaction();

    }

    @Override
    public boolean isLocked(CustomerDTO toLock) {
        HibernateUtil.beginTransaction();
        boolean locked = false;
        try {
            locked = customerDAO.locked(toLock.getPassport());
        } catch (NullPointerException e) {
            //todo log
        }
        HibernateUtil.commitTransaction();
        return locked;
    }
}
