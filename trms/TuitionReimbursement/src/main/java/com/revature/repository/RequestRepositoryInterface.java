package com.revature.repository;


import java.util.List;

import com.revature.model.Request;

public interface RequestRepositoryInterface {

	
	public void insertRequest(String description, double amount, int employeeID);
	
	public List<Request> getAllPendingRequests(int employeeId);
	
	public List<Request> getPendingRequestByNumber(int requestNumber);
	
	public List<Request> getAllApproved(String username);
	
//	public InputStream getReceipt(int employeeId, int requestNumber);
	
	
}
