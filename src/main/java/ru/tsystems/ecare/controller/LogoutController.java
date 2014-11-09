/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tsystems.ecare.controller;

import ru.tsystems.ecare.services.LoginService;
import ru.tsystems.ecare.services.impl.LoginServiceImpl;

public class LogoutController extends AbstractController {
	
	private static final LoginService loginservice = new LoginServiceImpl();

	@Override
	public void execute() {
		this.getRequest().getSession(false).invalidate();
		loginservice.closeSession();
		this.setReturnPage("/index.jsp");
	}

}
