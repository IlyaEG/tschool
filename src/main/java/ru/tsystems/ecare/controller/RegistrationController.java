package ru.tsystems.ecare.controller;

public class RegistrationController extends AbstractController {

	@Override
	public void execute() {
		String login = this.getRequest().getParameter("login");
		String password = this.getRequest().getParameter("password");
		System.out.println(login + password);


		// TODO
		String optionsNames = "name1";

		this.setReturnPage("/controlPanel.jsp");

		this.getRequest().setAttribute("allOptions", optionsNames);

	}

}
