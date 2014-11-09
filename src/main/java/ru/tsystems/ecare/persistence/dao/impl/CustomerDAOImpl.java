package ru.tsystems.ecare.persistence.dao.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import ru.tsystems.ecare.persistence.dao.CustomerDAO;
import ru.tsystems.ecare.persistence.entities.Customer;

/**
 *
 * @author ilya
 */
@Repository("customerDAO")
public class CustomerDAOImpl extends HibernateDAO<Customer, Integer>
        implements CustomerDAO {

    @Override
    public Customer findByPassport(String passport) {
        Query query = currentSession().getNamedQuery("findCustomerByPassport")
                .setString("passport", passport);
        return (Customer) query.uniqueResult();
    }

    @Override
    public boolean lockStatus(Customer customer) {
        Query query = currentSession().getNamedQuery("lockStatus")
                .setString("passport", customer.getCustomerPassport());
        return (Boolean) query.uniqueResult();
    }
}
