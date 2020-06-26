package com.revature.service;

import com.revature.model.Employee;
import com.revature.repository.EmployeeRepositoryImplement;

public class EmployeeService {

	EmployeeRepositoryImplement empRepo = new EmployeeRepositoryImplement();

	public Employee login(String username, String password) {
		return this.empRepo.login(username, password);
	};
	
	public void updateInfo(String username, String oldusername, String firstName, String lastname, String password) {
		this.empRepo.updateInfo( username, oldusername, firstName, lastname, password);
	}
	

}