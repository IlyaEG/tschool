/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tsystems.ecare.controller;

import java.util.List;
import ru.tsystems.ecare.persistence.entities.Customer;
import ru.tsystems.ecare.persistence.entities.Tariff;
import ru.tsystems.ecare.services.ContractService;
import ru.tsystems.ecare.services.ContractServiceImpl;
import ru.tsystems.ecare.services.CustomerService;
import ru.tsystems.ecare.services.CustomerServiceImpl;
import ru.tsystems.ecare.services.TariffService;
import ru.tsystems.ecare.services.TariffServiceImpl;

/**
 *
 * @author ilya
 */
public class NewContractController extends AbstractController{

	private static CustomerService customerService = new CustomerServiceImpl();
	private static TariffService tariffService = new TariffServiceImpl();
	private static ContractService contractService = new ContractServiceImpl();

	@Override
	public void execute() {

		Customer customer = customerService.findByPassport(this.getRequest().getParameter("passport"));
		this.getRequest().setAttribute("customer", customer);
		List<Tariff> allTariffs = tariffService.getAvailableTariffs();
		this.getRequest().setAttribute("tariffs", allTariffs);
		List<Integer> numbers = contractService.getAvailableNumbers();
		this.getRequest().setAttribute("numbers", numbers);
		this.setReturnPage("/newContract.jsp");
	}

}
