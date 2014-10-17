package ru.tsystems.ecare.controller;

import javax.servlet.http.HttpServletRequest;;

public interface Controller {
	
	public void execute();
	
	public void init(HttpServletRequest request);
	
	public String getReturnPage();
}
