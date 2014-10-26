package ru.tsystems.ecare.persistence.dao;


import org.hibernate.Query;
import ru.tsystems.ecare.persistence.entities.Customer;
/**
 *
 * @author ilya
 */
public class CustomerDAOImpl extends GenericDAOImpl<Customer, Integer>
		implements CustomerDAO {

	@Override
	public Customer findByPassport(String passport) {
		Query query = this.getSession()
				.getNamedQuery("findCustomerByPassport").setString("passport", passport);
		return (Customer) query.uniqueResult();
	}

	@Override
	public boolean locked(String passport) {
		Query query = this.getSession()
				.getNamedQuery("lockStatus").setString("passport", passport);
		return (Boolean) query.uniqueResult();
	}
}
