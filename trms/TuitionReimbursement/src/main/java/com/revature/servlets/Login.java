package com.revature.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.model.Employee;
import com.revature.service.EmployeeService;
import com.revature.service.Validation;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGY = LogManager.getLogger(Login.class);
	
    /**
     * Default constructor. 
     */
    public Login() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String red = "";
		String email = request.getParameter("employeeID");
		String password = request.getParameter("employeePassword");
		
		
		EmployeeService empService = new EmployeeService();
		
		Employee user = empService.login(email, password);
		HttpSession session;
		if(password.equals(user.getPassword()) && email.equals(user.getUsername())) {
				session = request.getSession();
				session.setAttribute("username", email);
				session.setAttribute("password", password);
				session.setAttribute("firstname", user.getFirstname());
				session.setAttribute("lastname", user.getLastname());
				session.setAttribute("employeeID", user.getEmployeeID());
				session.setAttribute("isManager", user.isManager());
		}
				if(user.isManager()) {
					red = "./manager/ManagerHome.html";
				} else {
					red = "./employee/EmployeeHome.html";
				}
		RequestDispatcher sender = request.getRequestDispatcher(red);
		
		sender.forward(request, response);
	
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
