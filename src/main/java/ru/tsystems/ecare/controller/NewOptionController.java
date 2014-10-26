/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tsystems.ecare.controller;

import ru.tsystems.ecare.persistence.entities.Option;
import ru.tsystems.ecare.services.OptionService;
import ru.tsystems.ecare.services.OptionServiceImpl;

/**
 *
 * @author ilya
 */
public class NewOptionController extends AbstractController {

	private static final OptionService optionService = new OptionServiceImpl();
	
	@Override
	public void execute() {
		if (this.getRequest().getSession().getAttribute("role").equals("employee")) {
			
			String name = this.getRequest().getParameter("name");
			float rate = Float.parseFloat(this.getRequest().getParameter("rate"));
			float price = Float.parseFloat(this.getRequest().getParameter("price"));
			optionService.createOption(new Option(name, rate, price));
			
			this.setReturnPage("/AllOptions");
		} else {
			this.setReturnPage("/index.jsp");
		}
	}
	
}
