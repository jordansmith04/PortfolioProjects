package com.revature.service;

import java.io.InputStream;
import java.util.List;

import com.revature.model.Employee;
import com.revature.model.Manager;
import com.revature.model.Request;
import com.revature.repository.ManagerRepositoryImplement;
import com.revature.repository.ManagerRepositoryInterface;

public class ManagerService {

	ManagerRepositoryInterface manRepo = new ManagerRepositoryImplement();
	
	public List<Employee> getAllEmployees(){
	return this.manRepo.getAllEmployees();
	};
	
	public void insertManager(int managerId, int employeeId, String password, String firstName, String lastName) {
		this.manRepo.insertManager(managerId, employeeId, password, firstName, lastName);
	};
	
	public void insertEmployee(String password, String firstname, String lastname, boolean isManager) {
		this.manRepo.insertEmployee(password, firstname, lastname, isManager);
	};
	
	public List<Manager> getAllManagers(){
		return this.manRepo.getAllManagers();
	};
	
	public List<Request> getApprovedRequests(){
		return this.manRepo.getApprovedRequests();
	};

	public List<Request> getAllPending(){
		return this.manRepo.getAllPending();
	};
	
	public List<Request> getAllPendingByID(int managerId){
		return this.manRepo.getAllPendingByID(managerId);
	};
	
	public void moveApprovedRequest(int requestNumber, String description, double amount, int employeeID) {
		this.manRepo.moveApprovedRequest(requestNumber, description, amount, employeeID);
	};
	
	public void removeRequest(int requestNumber) {
		this.manRepo.removeRequest(requestNumber);
	};
}
