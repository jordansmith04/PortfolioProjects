package com.revature.Junit;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.revature.model.Manager;
import com.revature.model.Request;
import com.revature.repository.EmployeeRepositoryImplement;
import com.revature.repository.ManagerRepositoryImplement;
import com.revature.repository.RequestRepositoryImplement;

class ManagerRepoTest {

	ManagerRepositoryImplement man;
	EmployeeRepositoryImplement emp;
	RequestRepositoryImplement req;
	
	@BeforeAll
	public void init() {
		man = new ManagerRepositoryImplement();
		emp = new EmployeeRepositoryImplement();
		req = new RequestRepositoryImplement();
	}
	
	@Test
	public void testGetAllManagers() {
		List<Manager>l = man.getAllManagers();
		Assertions.assertEquals(3, man.getAllManagers().get(0).getEmployeeId());
	}
	
	
	@Test
	public void getApprovedRequests() {
		List<Request> r = man.getApprovedRequests();
		Assertions.assertEquals(3, man.getAllManagers().get(0).getEmployeeId());
	}
	
	@Test
	public void getAllPendingById() {
		List<Request> r = man.getAllPendingByID(3);
		Assertions.assertEquals(3, man.getAllPendingByID(3).get(0).getEmployeeID());
	}
	
	@Test
	public void getAllPending() {
		List<Request> r = man.getAllPending();
		Assertions.assertEquals(3, man.getAllPending().get(0).getEmployeeID());
	}
	
}