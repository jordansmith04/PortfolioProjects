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
import com.revature.service.ManagerService;

/**
 * Servlet implementation class PendingRequests
 */
public class PendingRequests extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ManagerService man = new ManagerService();
	private static final Logger LOGGY = LogManager.getLogger(PendingRequests.class);
    /**
     * Default constructor. 
     */
    public PendingRequests() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Request> req = new ArrayList<Request>();

		HttpSession session = request.getSession(false);
		boolean isMan = (Boolean) session.getAttribute("isManager");
		int ID = (Integer) session.getAttribute("employeeID");
		
		if(!isMan) {
		req = man.getAllPendingByID(ID);
		
		} else {
			req = man.getAllPending();
		}
			Gson json = new Gson();
		
			response.getWriter().write(json.toJson(req));
//			System.out.println(json.toJson(req));
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
