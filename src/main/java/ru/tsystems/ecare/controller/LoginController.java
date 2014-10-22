package ru.tsystems.ecare.controller;

import javax.servlet.http.HttpSession;

import ru.tsystems.ecare.services.LoginService;
import ru.tsystems.ecare.services.LoginServiceImpl;

public class LoginController extends AbstractController {

	private static LoginService loginservice = new LoginServiceImpl();

	@Override
	public void execute() {
		String login = this.getRequest().getParameter("login");
		String password = this.getRequest().getParameter("password");
		if (login.length() > 0 && password.length() > 0 && loginservice.userValid(login, password)) {
			
				HttpSession session = this.getRequest().getSession(true);
				session.setAttribute("user", login);
				String role = loginservice.userRole(login);
				session.setAttribute("role", role);
				if (role.equals("employee")) {
					this.setReturnPage("/controlPanel.jsp"); // logged-in page for employee
				} else if (role.equals("customer")) {
					this.setReturnPage("/customerPanel.jsp");// logged-in page for customer
				} else {
					this.setReturnPage("/invalidLogin.jsp"); // error page
				}
		} else {
			this.setReturnPage("/invalidLogin.jsp"); // error page
		}
	}

}
