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
		
		
		if (loginservice.userValid(login, password))
		{
			HttpSession session = this.getRequest().getSession(true);
			session.setAttribute("user", login);
			session.setAttribute("role", loginservice.userRole(login));
			this.setReturnPage("/test.jsp"); // TODO logged-in page
		}

		else {
			this.setReturnPage("/invalidLogin.jsp"); // error page
		}

		// TODO http://www.java-only.com/LoadTutorial.javaonly?id=13


		//this.getRequest().setAttribute("user", login);

	}

}
