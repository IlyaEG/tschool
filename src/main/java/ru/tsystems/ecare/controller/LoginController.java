package ru.tsystems.ecare.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpSession;

public class LoginController extends AbstractController {

	@Override
	public void execute() {
		String login = this.getRequest().getParameter("login");
		String password = this.getRequest().getParameter("password");
		System.out.println(login + password);

		if (true)// TODO login/password check
		{

			HttpSession session = this.getRequest().getSession(true);
			session.setAttribute("currentSessionUser", login);
			this.setReturnPage("/test.jsp"); // TODO logged-in page
		}

		else {
			this.setReturnPage("/invalidLogin.jsp"); // error page
		}

		// OptionService optService = new OptionServiceImpl();
		// List<Option> allOptions = optService.getAllOptions();
		// List<String> optionsNames = new ArrayList<String>();
		// for (Option o : allOptions) {
		// optionsNames.add(o.getName());
		// }

		// TODO http://www.java-only.com/LoadTutorial.javaonly?id=13

		this.setReturnPage("/test.jsp");

		this.getRequest().setAttribute("user", login);

	}

}
