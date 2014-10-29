package ru.tsystems.ecare.persistence.dao.implementations;

import ru.tsystems.ecare.persistence.dao.interfaces.CustomerDAO;
import org.hibernate.Query;
import ru.tsystems.ecare.dto.CustomerDTO;
import ru.tsystems.ecare.persistence.entities.Customer;

/**
 *
 * @author ilya
 */
public class CustomerDAOImpl extends GenericDAOImpl<CustomerDTO, Customer>
        implements CustomerDAO {

    @Override
    public CustomerDTO findByPassport(String passport) {
        Query query = this.getSession()
                .getNamedQuery("findCustomerByPassport")
                .setString("passport", passport);
        Customer customer = (Customer) query.uniqueResult();
        CustomerDTO customerDTO = new CustomerDTO();
        return customerDTO.readEntity(customer);
    }

    @Override
    public boolean locked(String passport) {
        Query query = this.getSession()
                .getNamedQuery("lockStatus").setString("passport", passport);
        return (Boolean) query.uniqueResult();
    }
}
