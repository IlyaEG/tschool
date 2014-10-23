/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tsystems.ecare.controller;

import ru.tsystems.ecare.persistence.entities.Customer;
import ru.tsystems.ecare.persistence.entities.Person;
import ru.tsystems.ecare.services.CustomerService;
import ru.tsystems.ecare.services.CustomerServiceImpl;

/**
 *
 * @author ilya
 */
public class NewCustomerController extends AbstractController {

	private static CustomerService customerService = new CustomerServiceImpl();

	@Override
	public void execute() {
		String name = this.getRequest().getParameter("name");
		String surname = this.getRequest().getParameter("surname");
		String email = this.getRequest().getParameter("email");
		String password = this.getRequest().getParameter("password");
		String address = this.getRequest().getParameter("address");
		String passport = this.getRequest().getParameter("passport");
		if (name.length() > 0 && surname.length() > 0
				&& password.length() > 0 && passport.length() > 0) {

			customerService.newCustomer(name, surname, email, password, address, passport);
			Customer newCustomer = customerService.findByPassport(passport);
			this.getRequest().setAttribute("customer", newCustomer);
			this.setReturnPage("/manageContracts.jsp");
		} else {
			this.setReturnPage("/newCustomer.jsp");
		}

	}

}
