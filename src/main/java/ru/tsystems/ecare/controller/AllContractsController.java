/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tsystems.ecare.controller;

import java.util.List;
import ru.tsystems.ecare.persistence.entities.Contract;
import ru.tsystems.ecare.services.ContractService;
import ru.tsystems.ecare.services.impl.ContractServiceImpl;

/**
 *
 * @author ilya
 */
public class AllContractsController extends AbstractController {
	private static final ContractService contractService = new ContractServiceImpl();
	@Override
	public void execute() {
		if (this.getRequest().getSession(false).getAttribute("role").equals("employee")) {
				List<Contract> contracts = contractService.getAllContracts();
				this.getRequest().setAttribute("contracts", contracts);
				this.setReturnPage("/allContracts.jsp");
			
		} else {
			this.getRequest().getSession(false).invalidate();
			this.setReturnPage("/index.jsp");
		}
	}
	
}
