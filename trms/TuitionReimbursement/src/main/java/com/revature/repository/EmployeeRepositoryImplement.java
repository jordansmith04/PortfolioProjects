package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.model.Employee;
import com.revature.util.ConnectionClosers;
import com.revature.util.ConnectionFactory;

public class EmployeeRepositoryImplement implements EmployeeRepositoryInterface {

	private static final Logger LOGGY = LogManager.getLogger(EmployeeRepositoryImplement.class);
	public Employee login(String employeeID, String password) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet set = null;
		Employee employee = null;
		
		final String SQL ="select * from employee where username = '" + employeeID + "' and pass = '" + password +"';";
		
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(SQL);
			ps.execute();
			
			set = ps.getResultSet();
			
			while(set.next()) {
				employee = new Employee(
						set.getInt(1),
						set.getString(2),
						set.getString(3),
						set.getString(4),
						set.getString(5),
						set.getBoolean(6)
						);
			}
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(ps);
			ConnectionClosers.closeResultSet(set);
		}
		LOGGY.debug("loggy was successfully called, and it returns " + employee);
		return employee;
	}
	
	public void updateInfo(String username, String oldusername, String firstName, String lastname, String password) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		
		final String SQL ="update employee set username = ?, firstname = ?, lastname = ?, pass = ? where username = ?;";

		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(SQL);
			
			//Set pStmt variables
			ps.setString(1, username);
			ps.setString(2, firstName);
			ps.setString(3, lastname);
			ps.setString(4, password);
			ps.setString(5, oldusername);
			ps.execute();

			
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(ps);
		}
		LOGGY.debug("loggy was successfully called, and it returns void");
	}
	
};
	