/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tsystems.ecare.controller;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.tsystems.ecare.services.ContractService;
import ru.tsystems.ecare.services.ContractServiceImpl;

/**
 *
 * @author ilya
 */
public class LockContractController extends AbstractController {

	private static final Logger logger = LoggerFactory.getLogger(LockContractController.class);

	private static final ContractService contractService = new ContractServiceImpl();

	@Override
	public void execute() {
		HttpServletRequest request = this.getRequest();
		if (request.getSession(false).getAttribute("role").equals("employee")) {
			int number = Integer.parseInt(request.getParameter("number"));
			contractService.lockNumber(number, "employee");
			this.setReturnPage("AllContracts");
			
		} else if (request.getSession(false).getAttribute("role").equals("customer")) {
			int number = Integer.parseInt(request.getParameter("number"));
			contractService.lockNumber(number, "customer");
			
			this.setReturnPage("/customerPanel.jsp");// logged-in page for customer
		} else {
			logger.debug("Unauthorized attemp to acess to LockContractController");
			request.getSession(false).invalidate();
			this.setReturnPage("/index.jsp");
		}
	}

}