package ru.tsystems.ecare.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class FrontServlet
 */

public class FrontServlet extends HttpServlet {


	/**
	 *
	 */
	private static final long serialVersionUID = 11213123L;
	
	private static final Logger logger = LoggerFactory.getLogger(FrontServlet.class);

	@Override
	public void init() throws ServletException {
		super.init();
	}


	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			//get the request's url, it should be controller name
			String url = request.getRequestURL().substring(request.getRequestURL().lastIndexOf("/") + 1, request.getRequestURL().length());


			//Instantiate controller class
			Controller control = ControllerFactory.getControllerByFullClassName(url);
			//initialize controller
			control.init(request);

			control.execute();
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(control.getReturnPage());
			requestDispatcher.forward(request, response);

		} catch (Exception e) {
			logger.debug(e.getMessage());
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/error.jsp");
			request.setAttribute("message", e.getMessage());
			requestDispatcher.forward(request, response);
		}
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

}
