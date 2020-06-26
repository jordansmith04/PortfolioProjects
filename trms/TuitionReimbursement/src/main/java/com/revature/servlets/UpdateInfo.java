package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.service.EmployeeService;

/**
 * Servlet implementation class UpdateInfo
 */
public class UpdateInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeService emp = new EmployeeService();
	Logger LOGGY = LogManager.getLogger(UpdateInfo.class);

	/**
	 * Default constructor.
	 */
	public UpdateInfo() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String oldusername = request.getParameter("oldusername");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String pass = request.getParameter("password");

		HttpSession session = request.getSession(false);
		if (username == null) {
			username = (String) session.getAttribute("username");
		} else {
			session.setAttribute("username", username);
		}
		if (oldusername == null) {

			oldusername = (String) session.getAttribute("username");
		} else {
			session.setAttribute("oldusername", oldusername);
		}
		if (firstname == null) {

			firstname = (String) session.getAttribute("firstname");
		} else {
			session.setAttribute("firstname", firstname);
		}
		if(lastname == null) {
			lastname = (String) session.getAttribute("lastname");
		} else {
			session.setAttribute("lastname", lastname);
		}
		if(pass == null) {
			pass = (String) session.getAttribute("password");
		} else {
			session.setAttribute("password", pass);
		}
		
		int id = (Integer) session.getAttribute("employeeID");
		boolean isMan = (boolean) session.getAttribute("isManager");

		emp.updateInfo(username, oldusername, firstname, lastname, pass);
		response.getWriter().println("Your information has been changed");
		System.out.println("Your information has been changed");
		LOGGY.debug("loggy was successfully called, and it returns void");
		if (isMan) {
			response.sendRedirect("/ProjectOne/manager/ManNewRequests.html");
		} else {
			response.sendRedirect("/ProjectOne/employee/EmployeeNewRequests.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
