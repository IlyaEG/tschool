/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tsystems.ecare.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.tsystems.ecare.persistence.entities.Option;
import ru.tsystems.ecare.persistence.entities.Tariff;
import ru.tsystems.ecare.services.TariffService;
import ru.tsystems.ecare.services.TariffServiceImpl;

public class EditTariffOptionsController extends AbstractController {

	private static final Logger logger = LoggerFactory.getLogger(EditTariffOptionsController.class);

	private static final TariffService tariffService = new TariffServiceImpl();

	@Override
	public void execute() {
		if (this.getRequest().getSession(false).getAttribute("role").equals("employee")) {
			int id = Integer.parseInt(this.getRequest().getParameter("tariff"));
			Tariff tariff = tariffService.findById(id);
			List<Option> availableOptions = tariffService.getAvailableOptions();
			this.getRequest().setAttribute("availableOptions", availableOptions);
			this.getRequest().setAttribute("tariff", tariff);
			this.setReturnPage("/editTariffOptions.jsp");
			
		} else {
			logger.debug("Unauthorized attemp to acess to EditTariffOptionsController");
			this.getRequest().getSession(false).invalidate();
			this.setReturnPage("/index.jsp");
		}
	}

}
