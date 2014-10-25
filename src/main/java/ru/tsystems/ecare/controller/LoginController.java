package ru.tsystems.ecare.controller;

import javax.servlet.http.HttpSession;

import ru.tsystems.ecare.persistence.entities.Person;
import ru.tsystems.ecare.services.LoginService;
import ru.tsystems.ecare.services.LoginServiceImpl;

public class LoginController extends AbstractController {

	private static final LoginService loginservice = new LoginServiceImpl();

	@Override
	public void execute() {
		String login = this.getRequest().getParameter("login");
		String password = this.getRequest().getParameter("password");
		if (login.length() > 0 && password.length() > 0) {
			Person person = loginservice.userValid(login, password);
			HttpSession session = this.getRequest().getSession(true);
			session.setAttribute("user", person.getName());
			String role = loginservice.userRole(login).getName();
			session.setAttribute("role", role);
			session.setAttribute("login", login);
			switch (role) {
				case "employee":
					this.setReturnPage("/controlPanel.jsp"); // logged-in page for employee
					break;
				case "customer":
					this.setReturnPage("/customerPanel.jsp");// logged-in page for customer
					break;
				default:
					this.setReturnPage("/invalidLogin.jsp"); // error page
					break;
			}
		} else {
			this.setReturnPage("/invalidLogin.jsp"); // error page
		}
	}
}
