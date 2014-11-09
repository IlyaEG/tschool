/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tsystems.ecare.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.tsystems.ecare.services.TariffService;
import ru.tsystems.ecare.services.impl.TariffServiceImpl;

public class EditOptionRelationsController extends AbstractController {

	private static final Logger logger = LoggerFactory.getLogger(EditTariffOptionsController.class);

	private static final TariffService tariffService = new TariffServiceImpl();

	@Override
	public void execute() {
		if (this.getRequest().getSession(false).getAttribute("role").equals("employee")) {
			throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		} else {
			logger.debug("Unauthorized attemp to acess to EditOptionRelationsController");
			this.getRequest().getSession(false).invalidate();
			this.setReturnPage("/index.jsp");
		}
	}

}
