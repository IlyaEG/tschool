/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tsystems.ecare.controller;

import java.util.ArrayList;
import java.util.List;
import ru.tsystems.ecare.persistence.entities.Customer;
import ru.tsystems.ecare.services.interfaces.CustomerService;
import ru.tsystems.ecare.services.implementations.CustomerServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author ilya
 */
public class SearchController extends AbstractController {
	
	private static final Logger logger = LoggerFactory.getLogger(SearchController.class);
	
	private static final CustomerService customerService = new CustomerServiceImpl();

	@Override
	public void execute() {
		if (this.getRequest().getSession(false).getAttribute("role").equals("employee")) {
			try {
			int number = Integer.parseInt(this.getRequest().getParameter("number"));
			List<Customer> customers = new ArrayList<>();
			customers.add(customerService.findByNumber(number));
			this.getRequest().setAttribute("customers", customers);
			this.setReturnPage("/allCustomers.jsp");
			} catch (NumberFormatException nfe) {
				logger.debug(nfe.getMessage());
				this.getRequest().setAttribute("message", "Wrong nuber for search.");
				this.setReturnPage("/error.jsp");
			} catch (NullPointerException npe) {
				logger.debug(npe.getMessage());
				this.getRequest().setAttribute("message", "No contracts with this number.");
				this.setReturnPage("/error.jsp");
			}
		} else {
			this.getRequest().getSession(false).invalidate();
			this.setReturnPage("/index.jsp");
		}
	}

}
