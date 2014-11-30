package ru.tsystems.ecare.persistence.dao.impl;

import java.util.Set;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import ru.tsystems.ecare.exceptions.ECareException;
import ru.tsystems.ecare.persistence.dao.CustomerDAO;
import ru.tsystems.ecare.persistence.entities.Contract;
import ru.tsystems.ecare.persistence.entities.Customer;

/**
 * Implementation of customer DAO.
 *
 */
@Repository("customerDAO")
public class CustomerDAOImpl extends HibernateDAO<Customer, Integer>
        implements CustomerDAO {

    @Override
    public final Customer findByPassport(final String passport) {
        Query query = currentSession().getNamedQuery("findCustomerByPassport")
                .setString("passport", passport);
        return (Customer) query.uniqueResult();
    }

    @Override
    public final void lock(final Customer customer) {
        Customer storedCustomer = find(customer.getPersonId());
        if (storedCustomer == null) {
            throw new ECareException("Customer "
                    + customer.getPerson().getName() + "not found!");
        }
        storedCustomer.setLocked(true);
        update(storedCustomer);
    }

    @Override
    public final void unlock(final Customer customer) {
        Customer storedCustomer = find(customer.getPersonId());
        if (storedCustomer == null) {
            throw new ECareException("Customer "
                    + customer.getPerson().getName() + "not found!");
        }
        storedCustomer.setLocked(false);
        update(storedCustomer);
    }

    @Override
    public final Boolean lockStatus(final Customer customer) {
        Customer storedCustomer = find(customer.getPersonId());
        if (storedCustomer == null) {
            throw new ECareException("Customer "
                    + customer.getPerson().getName() + "not found!");
        }
        return storedCustomer.getLocked();
    }

    @Override
    public final Set<Contract> getContracts(final Customer customer) {
        Customer storedCustomer = find(customer.getPersonId());
        if (storedCustomer == null) {
            throw new ECareException("Customer "
                    + customer.getPerson().getName() + "not found!");
        }
        return storedCustomer.getContracts();
    }

    @Override
    public final void addContract(final Customer customer,
            final Contract contract) {
        Customer storedCustomer = find(customer.getPersonId());
        if (storedCustomer == null) {
            throw new ECareException("Customer "
                    + customer.getPerson().getName() + "not found!");
        }
        if (!storedCustomer.getContracts().add(contract)) {
            throw new ECareException("Contract " + contract.getNumber()
                    + " is already assigned to customer");
        }
        update(storedCustomer);
    }
//to remove
    @Override
    public final void deleteContract(final Customer customer,
            final Contract contract) {
        Customer storedCustomer = find(customer.getPersonId());
        if (storedCustomer == null) {
            throw new ECareException("Customer "
                    + customer.getPerson().getName() + "not found!");
        }

        if (!storedCustomer.getContracts().remove(contract)) {
            throw new ECareException("Contract " + contract.getNumber()
                    + " is not assigned to customer");
        }
        update(storedCustomer);
    }
}
