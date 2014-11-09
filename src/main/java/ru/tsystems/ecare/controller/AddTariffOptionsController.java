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
import ru.tsystems.ecare.persistence.entities.Option;
import ru.tsystems.ecare.persistence.entities.Tariff;
import ru.tsystems.ecare.services.OptionService;
import ru.tsystems.ecare.services.impl.OptionServiceImpl;
import ru.tsystems.ecare.services.TariffService;
import ru.tsystems.ecare.services.impl.TariffServiceImpl;

public class AddTariffOptionsController extends AbstractController {

	private static final Logger logger = LoggerFactory.getLogger(AddTariffOptionsController.class);

	private static final TariffService tariffService = new TariffServiceImpl();
	private static final OptionService optionService = new OptionServiceImpl();

	HttpServletRequest request;

	@Override
	public void execute() {
		if (this.getRequest().getSession(false).getAttribute("role").equals("employee")) {
			request = this.getRequest();
			int id = Integer.parseInt(this.getRequest().getParameter("tariff"));
			Tariff tariff = tariffService.findById(id);
			List<Option> add = getOptions("add");
			Set<Option> activeOptions = tariff.getOptions();
			for (Option o : add) {
				activeOptions.add(o);
			}
			tariff.setOptions(activeOptions);
			tariffService.updateTariff(tariff);
			
			List<Option> availableOptions = tariffService.getAvailableOptions();
			availableOptions.removeAll(activeOptions);
			request.setAttribute("availableOptions", availableOptions);
			request.setAttribute("tariff", tariff);
			this.setReturnPage("/editTariffOptions.jsp");

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

