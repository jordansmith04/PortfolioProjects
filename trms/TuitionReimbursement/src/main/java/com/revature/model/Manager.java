package com.revature.model;

public class Manager {

	private int managerId;
	private int employeeId;

	
	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Manager(int managerId, int employeeId) {
		super();
		this.managerId = managerId;
		this.employeeId = employeeId;
	}


	@Override
	public String toString() {
		return "Manager [managerId=" + managerId + ", employeeId=" + employeeId + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + employeeId;
		result = prime * result + managerId;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Manager other = (Manager) obj;
		if (employeeId != other.employeeId)
			return false;
		if (managerId != other.managerId)
			return false;
		return true;
	}


	public int getManagerId() {
		return managerId;
	}


	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}


	public int getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	
	}
