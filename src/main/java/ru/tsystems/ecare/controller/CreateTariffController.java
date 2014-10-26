/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tsystems.ecare.controller;

import ru.tsystems.ecare.persistence.entities.Tariff;
import ru.tsystems.ecare.services.TariffService;
import ru.tsystems.ecare.services.TariffServiceImpl;

/**
 *
 * @author ilya
 */
public class CreateTariffController extends AbstractController {

	private static final TariffService tariffService = new TariffServiceImpl();

	@Override
	public void execute() {

		if (this.getRequest().getSession(false).getAttribute("role").equals("employee")) {
			String name = this.getRequest().getParameter("name");
			float rate = Float.parseFloat(this.getRequest().getParameter("rate"));
			Tariff tariff = new Tariff(name, rate);
			tariffService.createTariff(tariff);
			this.setReturnPage("/AllTariffs");
		} else {
			this.setReturnPage("/index.jsp");
		}

	}
}