package ru.tsystems.ecare.persistence.dao;


import org.hibernate.Query;
import ru.tsystems.ecare.persistence.entities.Customer;
import ru.tsystems.ecare.persistence.utils.HibernateUtil;

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
}
