package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.model.Employee;
import com.revature.model.Manager;
import com.revature.model.Request;
import com.revature.util.ConnectionClosers;
import com.revature.util.ConnectionFactory;

public class ManagerRepositoryImplement implements ManagerRepositoryInterface {
	private static final Logger LOGGY = LogManager.getLogger(ManagerRepositoryImplement.class);

	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		final String SQL = "select * from employee join manager on employee.employeeid = manager.employeeid";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet set = null;

		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(SQL);

			ps.execute();
			set = ps.getResultSet();

			while (set.next()) {
				employees.add(new Employee(set.getInt(1), set.getString(2), set.getString(3), set.getString(4), set.getString(5),
						set.getBoolean(6)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(ps);
			ConnectionClosers.closeResultSet(set);
		}
		LOGGY.debug("loggy was successfully called, and it returns " + employees);
		return employees;
	}

	public void insertManager(int managerId, int employeeId, String password, String firstName, String lastName) {
		final String SQL = "insert into employees values(default, ?, ?, ?, ?, true)";
		final String SQL2 = "insert into managers values(?, default)";

		Connection conn = null;
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;

		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(SQL);
			ps2 = conn.prepareStatement(SQL2);
				ps.setInt(1, managerId);
				ps.setString(2, password);
				ps.setString(3, firstName);
				ps.setString(4, lastName);
				ps.execute();

				ps2.setInt(1, managerId);
				ps2.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(ps);
			ConnectionClosers.closeStatement(ps2);
			LOGGY.debug("loggy was successfully called, and it returns void");
		}
	}


	public void insertEmployee(String password, String firstname, String lastname, boolean isManager) {
		final String SQL = "insert into employee values(default, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pStmt = null;

		try {
			conn = ConnectionFactory.getConnection();
			pStmt = conn.prepareStatement(SQL);

			pStmt.setString(1, password);
			pStmt.setString(2, firstname);
			pStmt.setString(3, lastname);
			pStmt.setBoolean(4, isManager);
			pStmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(pStmt);
			LOGGY.debug("loggy was successfully called, and it returns void");
		}
	}


	public List<Manager> getAllManagers() {
		List<Manager> managers = new ArrayList<Manager>();
		final String SQL = "select * from manager";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet set = null;

		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(SQL);

			ps.execute();
			set = ps.getResultSet();

			while (set.next()) {
				managers.add(new Manager(set.getInt(1), set.getInt(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(ps);
			ConnectionClosers.closeResultSet(set);
		}
		LOGGY.debug("loggy was successfully called, and it returns " + managers);
		return managers;
	}

	public List<Request> getApprovedRequests() {
		List<Request> req = new ArrayList<Request>();
		final String SQL = "select * from approvedrequests where employeeID = ?;";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet set = null;

		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(SQL);

			ps.execute();
			set = ps.getResultSet();

			while (set.next()) {
				req.add(new Request(set.getInt(1), set.getString(2), set.getDouble(3), set.getInt(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(ps);
			ConnectionClosers.closeResultSet(set);
		}
		LOGGY.debug("loggy was successfully called, and it returns " + req);
		return req;
	}

	
	public List<Request> getAllPendingByID(int managerId) {
		List<Request> req = new ArrayList<Request>();
		final String SQL = "select * from pendingRequests where employeeID = ?;";

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet set = null;

		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(SQL);

			ps.setInt(1, managerId);

			ps.execute();
			set = ps.getResultSet();

			while (set.next()) {
				req.add(new Request(set.getInt(1), set.getString(2), set.getDouble(3),
						 set.getInt(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(ps);
			ConnectionClosers.closeResultSet(set);
		}
		LOGGY.debug("loggy was successfully called, and it returns " + req);
		return req;
	}

	public void moveApprovedRequest(int requestNumber, String description, double amount, int employeeID) {
		final String SQL = "insert into approvedRequests values (?, ?, ?, ?)";
		final String SQL2 = "delete * from pendingRequests where requestNumber = ?;";

		Connection conn = null;
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;

		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, requestNumber);
			ps.setString(2, description);
			ps.setDouble(3, amount);
			ps.setInt(4, employeeID);
			ps.execute();
			
			ps2 = conn.prepareStatement(SQL2);
			ps2.setInt(1, employeeID);
			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(ps);
			LOGGY.debug("loggy was successfully called, and it returns void");
		}
	}

	public void removeRequest(int requestNumber) {
		final String SQL = "delete * from pendingRequests where requestNumber = ?";

		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(SQL);

			ps.setInt(1, requestNumber);
			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(ps);
			LOGGY.debug("loggy was successfully called, and it returns void");
		}

	}
	public List<Request> getAllPending() {
		List<Request> req = new ArrayList<Request>();
		final String SQL = "select * from pendingRequests;";

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet set = null;

		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(SQL);
			ps.execute();
			set = ps.getResultSet();

			while (set.next()) {
				req.add(new Request(set.getInt(1), set.getString(2), set.getDouble(3),

						 set.getInt(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(ps);
			ConnectionClosers.closeResultSet(set);
		}
		LOGGY.debug("loggy was successfully called, and it returns " + req);
		return req;
	}

	
}

