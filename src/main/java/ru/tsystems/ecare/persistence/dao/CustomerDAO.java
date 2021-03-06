/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tsystems.ecare.persistence.dao;

import ru.tsystems.ecare.persistence.entities.Customer;

/**
 *
 * @author ilya
 */
public interface CustomerDAO extends GenericDAO<Customer, Integer> {

	public Customer findByPassport(String passport);

	public boolean locked(String customerPassport);

}
