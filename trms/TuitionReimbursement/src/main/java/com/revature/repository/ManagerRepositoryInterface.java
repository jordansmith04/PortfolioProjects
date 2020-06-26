package com.revature.repository;

import java.io.InputStream;
import java.util.List;

import com.revature.model.Employee;
import com.revature.model.Manager;
import com.revature.model.Request;

public interface ManagerRepositoryInterface {
	
	public List<Employee> getAllEmployees();
	
	public void insertManager(int managerId, int employeeId, String password, String firstName, String lastName);
	
	public void insertEmployee(String password, String firstname, String lastname, boolean isManager);
	
	public List<Manager> getAllManagers();
	
	public List<Request> getApprovedRequests();

	public List<Request> getAllPendingByID(int managerId);
	
	public void moveApprovedRequest(int requestNumber, String description, double amount, int employeeID);
	
	public void removeRequest(int requestNumber);
	
	public List<Request> getAllPending();
}