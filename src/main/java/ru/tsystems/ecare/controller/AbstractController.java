package ru.tsystems.ecare.controller;

import javax.servlet.http.HttpServletRequest;

public abstract class AbstractController implements Controller {

	private HttpServletRequest request;
	protected String returnPage;

	@Override
	public void init(HttpServletRequest request) {
		this.setRequest(request);
	}

	public void setReturnPage(String page) {
		returnPage = page;
	}
	
	@Override
	public String getReturnPage() {
		return returnPage;
	}
	
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public HttpServletRequest getRequest() {
		return request;
	}
}
