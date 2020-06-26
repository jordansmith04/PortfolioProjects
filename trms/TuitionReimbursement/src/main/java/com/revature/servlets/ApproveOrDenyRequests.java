package com.revature.servlets;

import java.io.IOException;
import java.io.InputStream;
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
import com.revature.repository.ManagerRepositoryImplement;
import com.revature.repository.RequestRepositoryImplement;

/**
 * Servlet implementation class ApproveOrDenyRequests
 */
public class ApproveOrDenyRequests extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static RequestRepositoryImplement req = new RequestRepositoryImplement();
	static ManagerRepositoryImplement man = new ManagerRepositoryImplement();
	private static final Logger LOGGY = LogManager.getLogger(ApproveOrDenyRequests.class);
	/**
     * Default constructor. 
     */
    public ApproveOrDenyRequests() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int requestNum = Integer.parseInt(request.getParameter("requestNumber"));
		boolean isApproved = Boolean.parseBoolean(request.getParameter("selector"));
		HttpSession session = request.getSession(false);
		int employeeId = (Integer) session.getAttribute("EmployeeID");
		double amount = 0;
		String description = "";
		if (isApproved == true) {
			List<Request> e = req.getPendingRequestByNumber(requestNum);
			for(Request r : e) {
				amount = r.getAmount();
				description = r.getDescription();
			}
			man.moveApprovedRequest(requestNum, description, amount,  employeeId);
		} else {
			man.removeRequest(requestNum);
		}
		Gson json = new Gson();
		response.getWriter().print(json.toJson(man.getAllPending()));
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
