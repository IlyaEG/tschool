package ru.tsystems.ecare.persistence.dao;

import java.util.Set;
import ru.tsystems.ecare.persistence.entities.Contract;
import ru.tsystems.ecare.persistence.entities.Customer;

/**
 * DAO of customer.
 */
public interface CustomerDAO extends GenericDAO<Customer, Integer> {

    Customer findByPassport(String passport);

    void lock(Customer customer);

    void unlock(Customer customer);

    Boolean lockStatus(Customer customer);

    Set<Contract> getContracts(Customer customer);

    void addContract(Customer customer, Contract contract);

    void deleteContract(Customer customer, Contract contract);

}
