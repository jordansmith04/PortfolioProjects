package com.revature.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.repository.RequestRepositoryImplement;

/**
 * Servlet implementation class NewRequest
 */
public class NewRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestRepositoryImplement serv = new RequestRepositoryImplement();
	private static final Logger LOGGY = LogManager.getLogger(NewRequest.class);
    /**
     * Default constructor. 
     */
    public NewRequest() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double amt = Double.parseDouble(request.getParameter("amount"));
		String description = request.getParameter("description");
		
		String location = "";
		HttpSession session = request.getSession(false);
		int Id = (Integer) session.getAttribute("employeeID");
		boolean isMan = (boolean) session.getAttribute("isManager");


			serv.insertRequest(description, amt, Id);
			
			if(isMan == true) {
				location = "./manager/ManViewRequests.html";
			} else {
				location = "./employee/EmployeeViewRequests.html";
			}
			LOGGY.debug("loggy was successfully called, and it returns void");
			response.sendRedirect(location);
			
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
