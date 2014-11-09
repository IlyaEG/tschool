/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tsystems.ecare.controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.tsystems.ecare.persistence.entities.Contract;
import ru.tsystems.ecare.persistence.entities.Option;
import ru.tsystems.ecare.persistence.entities.Tariff;
import ru.tsystems.ecare.services.ContractService;
import ru.tsystems.ecare.services.impl.ContractServiceImpl;
import ru.tsystems.ecare.services.OptionService;
import ru.tsystems.ecare.services.impl.OptionServiceImpl;
import ru.tsystems.ecare.services.TariffService;
import ru.tsystems.ecare.services.impl.TariffServiceImpl;

/**
 *
 * @author ilya
 */
public class ChangeContractOptionsController extends AbstractController {

	private static final Logger logger = LoggerFactory.getLogger(AddTariffOptionsController.class);
	
	private static final ContractService contractService = new ContractServiceImpl();
	private static final TariffService tariffService = new TariffServiceImpl();
	private static final OptionService optionService = new OptionServiceImpl();

	HttpServletRequest request;

	@Override
	public void execute() {
		if (this.getRequest().getSession(false).getAttribute("role").equals("employee") ||
				this.getRequest().getSession(false).getAttribute("role").equals("customer")) {
			
			request = this.getRequest();
			int number = Integer.parseInt(this.getRequest().getParameter("number"));
			Contract contract = contractService.findByNumber(number);
			
			Tariff tariff = contract.getTariff();
			
			Set<Option> availableOptions = tariff.getOptions();
			Set<Option> activeOptions = contract.getOptions();
			
			List<Option> toRem = getOptions("rem");
			if (toRem.size() > 0) {
				activeOptions.removeAll(toRem);
			}
			
			List<Option> toAdd = getOptions("add");
			if (toAdd.size() > 0) {
				activeOptions.addAll(toAdd);
			}
			//save contract
			contract.setOptions(activeOptions);
			contractService.save(contract);
			//reread from db
			contract = contractService.findByNumber(number);
			activeOptions = contract.getOptions();
			if (activeOptions.size() > 0) {
				availableOptions.removeAll(activeOptions);
			}
			
			request.setAttribute("availableOptions", availableOptions);
			request.setAttribute("contract", contract);
			this.setReturnPage("/editContractOptions.jsp");
		} else {
			logger.debug("Unauthorized attemp to acess to AddTariffOptionsController");
			this.getRequest().getSession(false).invalidate();
			this.setReturnPage("/index.jsp");
		}
	}

	protected List<Option> getOptions(String prefix) {
		Enumeration names = request.getParameterNames();
		List<Option> options = new ArrayList<>();
		String temp;
		while (names.hasMoreElements()) {
			temp = (String)names.nextElement();
			if (temp.substring(0, 3).equals(prefix)) {
				options.add(optionService.findByName(temp.substring(3)));
			}
		}
		return options;
	}
	
}
