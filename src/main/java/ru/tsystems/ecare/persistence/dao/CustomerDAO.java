package ru.tsystems.ecare.persistence.dao;

import ru.tsystems.ecare.persistence.entities.Customer;

/**
 * DAO of customer.
 */
public interface CustomerDAO extends GenericDAO<Customer, Integer> {

    public Customer findByPassport(String passport);

    public boolean lockStatus(Customer customer);

}
