package com.revature.service;

import java.io.InputStream;
import java.util.List;

import com.revature.model.Request;
import com.revature.repository.RequestRepositoryImplement;
import com.revature.repository.RequestRepositoryInterface;

public class RequestService {

	RequestRepositoryInterface empRepo = new RequestRepositoryImplement();
	
	public void insertRequest(String description, double amount, int employeeID) {
		this.empRepo.insertRequest(description, amount, employeeID);
	};
	
	public List<Request> getAllPendingRequests(int employeeId){
		return this.empRepo.getAllPendingRequests(employeeId);
	};
	
	public List<Request> getPendingRequestByNumber(int requestNumber){
		return this.empRepo.getPendingRequestByNumber(requestNumber);		
	};
	
	public List<Request> getAllApproved(String username){
		return this.empRepo.getAllApproved(username);
	};
	
//	public InputStream getReceipt(int employeeId, int requestNumber) {
//		return this.empRepo.getReceipt(employeeId, requestNumber);
//	};
	
	
	
}
