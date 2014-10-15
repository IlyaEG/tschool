package ru.tsystems.ecare.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.tsystems.ecare.persistence.entities.Option;
import ru.tsystems.ecare.services.OptionService;
import ru.tsystems.ecare.services.OptionServiceImpl;

/**
 * Servlet implementation class FrontServlet
 */
public class FrontServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("Options and ratios:");
		try {
			OptionService optionService = new OptionServiceImpl();
			List<Option> allOptions = optionService.getAllOptions();
			for (Option o : allOptions) {
				out.println(o.getName() + o.getRate());
			}
		} catch (Exception e) {
			out.println(e.getMessage());
		}
	}

}
