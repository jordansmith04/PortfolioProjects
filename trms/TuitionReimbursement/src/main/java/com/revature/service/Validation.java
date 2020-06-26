package com.revature.service;

import com.revature.model.Employee;
import com.revature.repository.EmployeeRepositoryImplement;

public class Validation {
	static EmployeeRepositoryImplement empRepo = new EmployeeRepositoryImplement();
	
	public static boolean validate(String username, String password) {
		boolean isValid = false;
		
		Employee e = empRepo.login(username, password);
		if(e != null) {
			isValid = true;
		}
		
		return isValid;
	}
}
