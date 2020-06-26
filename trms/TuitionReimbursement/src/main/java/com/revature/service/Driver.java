package com.revature.service;

import com.revature.model.Employee;
import com.revature.repository.ManagerRepositoryImplement;
import com.revature.repository.RequestRepositoryImplement;

public class Driver {
	static EmployeeService em = new EmployeeService();
	RequestRepositoryImplement req = new RequestRepositoryImplement();
	static ManagerRepositoryImplement man = new ManagerRepositoryImplement();
	
	static String a = "vibes";
	static String b= "suck";
	static String c= "me";
	static boolean fuck = false;
	public static void main(String[] args) {
	
//		man.insertEmployee(a, b, c, fuck);
		
		Employee e = em.login(a, b);
		System.out.println(e.getFirstname());
		
	}
	
}
