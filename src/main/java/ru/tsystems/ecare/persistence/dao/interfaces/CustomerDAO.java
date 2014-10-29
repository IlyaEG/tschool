/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tsystems.ecare.persistence.dao.interfaces;

import ru.tsystems.ecare.dto.CustomerDTO;
import ru.tsystems.ecare.persistence.entities.Customer;

/**
 *
 * @author ilya
 */
public interface CustomerDAO extends GenericDAO<CustomerDTO, Customer> {

    public CustomerDTO findByPassport(String passport);

    public boolean locked(String customerPassport);

}
