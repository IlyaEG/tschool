/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tsystems.ecare.controller;

import ru.tsystems.ecare.persistence.entities.Tariff;
import ru.tsystems.ecare.services.interfaces.TariffService;
import ru.tsystems.ecare.services.implementations.TariffServiceImpl;

/**
 *
 * @author ilya
 */
public class NewTariffController extends AbstractController {
	
	private static final TariffService tariffService = new TariffServiceImpl();

	@Override
	public void execute() {
		if (this.getRequest().getSession().getAttribute("role").equals("employee")) {
			//TODO add options
			this.setReturnPage("/newTariff.jsp");
		} else {
			this.setReturnPage("/index.jsp");
		}

	}

}
