package ru.tsystems.ecare.controller;

import javax.servlet.http.HttpServletRequest;
import ru.tsystems.ecare.ECareException;
import ru.tsystems.ecare.persistence.entities.Person;
import ru.tsystems.ecare.persistence.entities.Role;
import ru.tsystems.ecare.services.CustomerService;
import ru.tsystems.ecare.services.CustomerServiceImpl;
import ru.tsystems.ecare.services.LoginService;
import ru.tsystems.ecare.services.LoginServiceImpl;

public class RegistrationController extends AbstractController {

	private static final LoginService loginservice = new LoginServiceImpl();
	private static final CustomerService customerService = new CustomerServiceImpl();
	private static final String rightEmployeePassword = "emp";
	private String name;
	private String email;
	private String password;
	private String surname;
	private String passport;
	private String address;
	private String isEmployee;
	private String employeePassword;
	private String role;
	HttpServletRequest request;

	@Override
	public void execute() {
		request = this.getRequest();
		name = request.getParameter("name");
		email = request.getParameter("email");
		password = request.getParameter("password");
		surname = request.getParameter("surname");
		passport = request.getParameter("passport");
		address = request.getParameter("address");
		isEmployee = request.getParameter("isemployee");
		employeePassword = request.getParameter("employeePassword");
		assignRole();
		createAccount();
	}

	private void assignRole() {
		if (isEmployee.equals("on") && employeePassword != null) {
			if (employeePassword.equals(rightEmployeePassword)) {
				role = "employee";
			} else {
				throw new ECareException("Wrong employee password!");
			}
		} else {
			role = "customer";
		}
	}

	private void createAccount() {
		switch (role) {
			case "employee":
				if (name.length() > 0 && email.length() > 0 && password.length() > 0
						&& surname.length() > 0) {
					Role employee = loginservice.findRoleByName(role);
					//create person with role employee
					Person newEmployee = new Person(employee, name, surname, password);
					newEmployee.setEmail(email);
					newEmployee.setAdress(address);
					customerService.newEmployee(employee, newEmployee);
					request.setAttribute("login", email);
					request.setAttribute("password", password);
					this.setReturnPage("/Login");
				} else {
					this.setReturnPage("/registration.jsp");
				}
				break;
			case "customer":
				if (name.length() > 0 && email.length() > 0 && password.length() > 0
						&& surname.length() > 0 && passport.length() > 0
						&& address.length() > 0) {
					//create person with role customer
					customerService.newCustomer(name, surname, email, password, address, passport);
					request.setAttribute("login", email);
					request.setAttribute("password", password);
					this.setReturnPage("/Login");
				} else {
					this.setReturnPage("/registration.jsp");
				}
				break;
			default:
				throw new ECareException("Wrong role for new account!");
		}
	}
}
