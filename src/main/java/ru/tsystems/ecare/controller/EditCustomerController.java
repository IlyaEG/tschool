/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tsystems.ecare.controller;

import ru.tsystems.ecare.persistence.entities.Customer;
import ru.tsystems.ecare.services.CustomerService;
import ru.tsystems.ecare.services.impl.CustomerServiceImpl;

/**
 *
 * @author ilya
 */
public class EditCustomerController extends AbstractController {

	private static CustomerService customerService = new CustomerServiceImpl();

	@Override
	public void execute() {

		Customer newCustomer = customerService.findByPassport(this.getRequest().getParameter("passport"));
		this.getRequest().setAttribute("customer", newCustomer);
		this.setReturnPage("/manageContracts.jsp");
		
	}

}
