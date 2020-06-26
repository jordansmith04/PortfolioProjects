package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.service.ManagerService;

/**
 * Servlet implementation class NewEmployee
 */
public class NewEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 ManagerService man = new ManagerService();
	 private static final Logger LOGGY = LogManager.getLogger(NewEmployee.class);
    /**
     * Default constructor. 
     */
    public NewEmployee() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password = request.getParameter("employeePassword");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		boolean isManager = request.getParameter("isManager") != null;
		
		man.insertEmployee(password, firstname, lastname, isManager);
		
		LOGGY.debug("loggy was successfully called, and it returns void");
		response.sendRedirect("./manager/ManNewRequests.html");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
