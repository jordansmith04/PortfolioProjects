package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.revature.model.Employee;
import com.revature.model.Manager;
import com.revature.service.ManagerService;

/**
 * Servlet implementation class EmployeeTree
 */
public class EmployeeTree extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static ManagerService man = new ManagerService();
	private static final Logger LOGGY = LogManager.getLogger(EmployeeTree.class);
	
    /**
     * Default constructor. 
     */
    public EmployeeTree() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Employee> empList = man.getAllEmployees();
	
		Gson json = new Gson();
		
		PrintWriter pw = response.getWriter();
		pw.print(json.toJson(empList));
		System.out.println(json.toJson(empList));
		LOGGY.debug("loggy was successfully called, and it returns void");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
