/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tsystems.ecare.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.tsystems.ecare.persistence.entities.Contract;
import ru.tsystems.ecare.persistence.entities.Customer;
import ru.tsystems.ecare.persistence.entities.Tariff;
import ru.tsystems.ecare.services.ContractService;
import ru.tsystems.ecare.services.impl.ContractServiceImpl;
import ru.tsystems.ecare.services.CustomerService;
import ru.tsystems.ecare.services.impl.CustomerServiceImpl;
import ru.tsystems.ecare.services.TariffService;
import ru.tsystems.ecare.services.impl.TariffServiceImpl;

public class CreateContractController extends AbstractController {
	
	private static final Logger logger = LoggerFactory.getLogger(CreateContractController.class);

	private static final CustomerService customerService = new CustomerServiceImpl();
	private static final TariffService tariffService = new TariffServiceImpl();
	private static final ContractService contractService = new ContractServiceImpl();

	@Override
	public void execute() {
		if (this.getRequest().getSession(false).getAttribute("role").equals("employee")) {
			Customer customer = customerService.
					findByPassport(this.getRequest().
							getParameter("passport"));
			try {
			int id = Integer.parseInt(this.getRequest().getParameter("tariff"));
			Tariff tariff = tariffService.findById(id);
			Contract newContract = new Contract(customer, tariff);
			newContract.setNumber(Integer.parseInt(this.getRequest().getParameter("number")));
			contractService.newContract(newContract);
			
			//update customer from db
			customer = customerService.
					findByPassport(this.getRequest().
							getParameter("passport"));
			//list all customer contracts
			this.getRequest().setAttribute("customer", customer);
			this.setReturnPage("/manageContracts.jsp");
			} catch (NumberFormatException nfe) {
				logger.debug(nfe.getMessage());
				this.getRequest().setAttribute("message", "Tariff is not selected.");
				this.setReturnPage("/error.jsp");
			}
			
		} else {
			this.getRequest().getSession(false).invalidate();
			this.setReturnPage("/index.jsp");
		}
	}

}
