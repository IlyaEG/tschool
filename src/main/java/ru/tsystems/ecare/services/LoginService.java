package ru.tsystems.ecare.services;

import ru.tsystems.ecare.persistence.entities.Customer;
import ru.tsystems.ecare.persistence.entities.Person;
import ru.tsystems.ecare.persistence.entities.Role;

public interface LoginService {

	Person userValid(String login, String password);

	Role userRole(String login);
	
	Role findRoleByName(String roleName);
	
	Customer findByEmail(String email);

	public void closeSession();

}
