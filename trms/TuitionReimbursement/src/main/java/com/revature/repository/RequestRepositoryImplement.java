package com.revature.repository;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.model.Request;
import com.revature.util.ConnectionClosers;
import com.revature.util.ConnectionFactory;

public class RequestRepositoryImplement implements RequestRepositoryInterface{
	private static final Logger LOGGY = LogManager.getLogger(EmployeeRepositoryImplement.class);
	
	public void insertRequest(String description, double amount, int employeeID) {
		Connection conn = null;
		PreparedStatement ps = null;
	
		final String SQL ="insert into pendingRequests values(default, ?, ?, ?)";

		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(SQL);
			
			
			ps.setString(1, description);
			ps.setDouble(2, amount);
			ps.setInt(3, employeeID);

			ps.execute();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(ps);
			LOGGY.debug("loggy was successfully called, and it returns void");
		}
		
	}


	public List<Request> getAllPendingRequests(int employeeId) {
		
		List<Request> req = new ArrayList<Request>();
		final String SQL = "select * from pendingRequests";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet set = null; 
		
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(SQL);
			ps.execute();
			set = ps.getResultSet();
			
			while(set.next()) {
				req.add(new Request(
						set.getInt(1),
						set.getString(2),
						set.getDouble(3),
						set.getInt(4)
						));
			}	
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(ps);
			ConnectionClosers.closeResultSet(set);
		}
		LOGGY.debug("loggy was successfully called, and it returns " + req);
		return req;	
	}
	
	public List<Request> getPendingRequestByNumber(int requestNumber) {
		
		List<Request> req = new ArrayList<Request>();
		final String SQL = "select * from pendingRequests where requestNumber is ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet set = null; 
		
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(SQL);
			
			ps.setInt(1, requestNumber);
			ps.execute();
			set = ps.getResultSet();
			
			while(set.next()) {
				req.add(new Request(
						set.getInt(1),
						set.getString(2),
						set.getDouble(3),
						set.getInt(4)
						));
			}	
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(ps);
			ConnectionClosers.closeResultSet(set);
		}
		LOGGY.debug("loggy was successfully called, and it returns " + req);
		return req;	
	}
	
	
	public List<Request> getAllApproved(String username) {
		
		List<Request> req = new ArrayList<Request>();
		final String SQL = "select * from approvedRequests where username = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet set = null; 
		
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(SQL);
			
			ps.setString(1, username);
			ps.execute();
			set = ps.getResultSet();
			
			while(set.next()) {
				req.add(new Request(
						set.getInt(1),
						set.getString(2),
						set.getDouble(3),
						set.getInt(4)
						));
			}	
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(ps);
			ConnectionClosers.closeResultSet(set);
		}
		LOGGY.debug("loggy was successfully called, and it returns " + req);
		return req;	
	}

	
//	public InputStream getReceipt(int employeeId, int requestNumber) {
//		InputStream receipt = null;
//		final String SQL = "select image from pendingRequests join approvedRequests on pendingrequests.requestnumber = approvedrequests.requestnumber;";
//		Connection conn = null;
//		PreparedStatement pStmt = null;
//		ResultSet set = null; 
//		
//		try {
//			conn = ConnectionFactory.getConnection();
//			pStmt = conn.prepareStatement(SQL);
//			
//			pStmt.setInt(1, requestNumber);
//			pStmt.setInt(2, employeeId);
//			pStmt.execute();
//			set = pStmt.getResultSet();
//			
//			while(set.next()) {
//				receipt = set.getBinaryStream(1);
//			}	
//		}catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			ConnectionClosers.closeConnection(conn);
//			ConnectionClosers.closeStatement(pStmt);
//			ConnectionClosers.closeResultSet(set);
//		}
//		return receipt;	
//	}

	
}

