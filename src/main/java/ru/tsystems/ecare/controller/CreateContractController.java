/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tsystems.ecare.controller;

import java.util.List;
import ru.tsystems.ecare.persistence.entities.Contract;
import ru.tsystems.ecare.persistence.entities.Customer;
import ru.tsystems.ecare.persistence.entities.Tariff;
import ru.tsystems.ecare.services.ContractService;
import ru.tsystems.ecare.services.ContractServiceImpl;
import ru.tsystems.ecare.services.CustomerService;
import ru.tsystems.ecare.services.CustomerServiceImpl;
import ru.tsystems.ecare.services.TariffService;
import ru.tsystems.ecare.services.TariffServiceImpl;


public class CreateContractController extends AbstractController {
	private static final CustomerService customerService = new CustomerServiceImpl();
	private static final TariffService tariffService = new TariffServiceImpl();
	private static final ContractService contractService = new ContractServiceImpl();

	@Override
	public void execute() {
		//TODO create contact and proceed to choosing options
		Customer customer = customerService.findByPassport(this.getRequest().getParameter("passport"));
		this.getRequest().setAttribute("customer", customer);
		List<Tariff> allTariffs = tariffService.getAvailableTariffs();
		List<Integer> numbers = contractService.getAvailableNumbers();
		//TODO contractService.newContract(new Contract(customer, null, null))
		this.setReturnPage("/manageContractOptions.jsp");
	}
	
}
