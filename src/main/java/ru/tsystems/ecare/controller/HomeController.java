/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tsystems.ecare.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.tsystems.ecare.services.TariffService;
import ru.tsystems.ecare.services.TariffServiceImpl;

/**
 *
 * @author ilya
 */
public class HomeController extends AbstractController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Override
	public void execute() {
		if (this.getRequest().getSession(false).getAttribute("role").equals("employee")) {
			this.setReturnPage("/controlPanel.jsp");
		} else if (this.getRequest().getSession(false).getAttribute("role").equals("customer")) {
			this.setReturnPage("/customerPanel.jsp");
		} else {
			logger.debug("Unauthorized attemp to acess to HomeController");
			this.getRequest().getSession(false).invalidate();
			this.setReturnPage("/index.jsp");
		}
	}

}