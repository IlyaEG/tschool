package ru.tsystems.ecare.services;

public interface LoginService {
	
	boolean userValid(String login, String password);
	
	String userRole(String login);

}
