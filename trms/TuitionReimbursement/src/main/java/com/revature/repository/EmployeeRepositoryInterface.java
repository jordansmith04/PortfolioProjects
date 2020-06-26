package com.revature.repository;

import com.revature.model.Employee;


public interface EmployeeRepositoryInterface {
	
	public Employee login(String username, String password);
	
	public void updateInfo(String username, String oldusername, String firstName, String lastname, String password);
	
	
	
}

