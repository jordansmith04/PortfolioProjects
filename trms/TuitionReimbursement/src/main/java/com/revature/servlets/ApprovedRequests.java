package com.revature.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.revature.model.Request;
import com.revature.repository.EmployeeRepositoryImplement;
import com.revature.repository.RequestRepositoryImplement;

/**
 * Servlet implementation class ApprovedRequests
 */
public class ApprovedRequests extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static RequestRepositoryImplement Requests = new RequestRepositoryImplement();
	private static final Logger LOGGY = LogManager.getLogger(ApprovedRequests.class);
    /**
     * Default constructor. 
     */
    public ApprovedRequests() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Request> req = new ArrayList<Request>();
		
		HttpSession session = request.getSession(false);
		String username = (String) session.getAttribute("employeeID");
		
		req = Requests.getAllApproved(username);
						
		Gson gson = new Gson();
		
		response.getWriter().write(gson.toJson(req));
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
