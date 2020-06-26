package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.repository.EmployeeRepositoryImplement;
import com.revature.service.ManagerService;

/**
 * Servlet implementation class DeleteRequest
 */
public class DeleteRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static ManagerService man = new ManagerService();
	
	private static final Logger LOGGY = LogManager.getLogger(DeleteRequest.class);
    /**
     * Default constructor. 
     */
    public DeleteRequest() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
int reqID = Integer.parseInt(request.getParameter("requestNumber"));
		
		man.removeRequest(reqID);
		
		response.sendRedirect("./manager/ManNewRequests.html");
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
