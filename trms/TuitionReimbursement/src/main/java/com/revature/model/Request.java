package com.revature.model;

import java.io.InputStream;
import java.util.Arrays;

public class Request {

	
	 private int requestNumber;
	private String description;
	private double amount;
	 private int employeeID;
	
	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Request(int requestNumber, String description, double amount, int employeeID) {
		super();
		this.requestNumber = requestNumber;
		this.description = description;
		this.amount = amount;
		this.employeeID = employeeID;
	}

	@Override
	public String toString() {
		return "Request [requestNumber=" + requestNumber + ", description=" + description + ", amount=" + amount
				+ ", employeeID=" + employeeID + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + employeeID;
		result = prime * result + requestNumber;
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
		Request other = (Request) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (employeeID != other.employeeID)
			return false;
		if (requestNumber != other.requestNumber)
			return false;
		return true;
	}

	public int getRequestNumber() {
		return requestNumber;
	}

	public void setRequestNumber(int requestNumber) {
		this.requestNumber = requestNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	
}