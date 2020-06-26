package com.revature.Junit;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.revature.model.Employee;
import com.revature.repository.EmployeeRepositoryImplement;

@RunWith(JUnitPlatform.class)
@TestInstance(Lifecycle.PER_CLASS)
public class EmployeeRepositoryImplementTesting {

	EmployeeRepositoryImplement emp;
	
	@BeforeAll
	public void init() {
		emp = new EmployeeRepositoryImplement();
	}
	
	@Test
	public void testLogin() {
		Assertions.assertEquals("jordan", emp.login("admin", "password").getFirstname());
	}
};
	
