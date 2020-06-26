package com.revature.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.revature.model.Manager;
import com.revature.repository.ManagerRepositoryImplement;

/**
 * Servlet implementation class ManagerTree
 */
public class ManagerTree extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ManagerRepositoryImplement manager = new ManagerRepositoryImplement();
	private static final Logger LOGGY = LogManager.getLogger(ManagerTree.class);

    /**
     * Default constructor. 
     */
    public ManagerTree() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
List<Manager> man = new ArrayList<Manager>();
		
		man = manager.getAllManagers();
		
		Gson gson = new Gson();
		
		response.getWriter().print(gson.toJson(man));
		System.out.println(gson.toJson(man));
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
