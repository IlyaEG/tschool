/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tsystems.ecare.controller;

public class LogoutController extends AbstractController {

	@Override
	public void execute() {
		this.getRequest().getSession(false).invalidate();
		this.setReturnPage("/index.jsp");
	}

}
