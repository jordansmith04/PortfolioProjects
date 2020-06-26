package com.revature.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectionFactory {

private static final Logger LOGGER = LogManager.getLogger(ConnectionFactory.class);

public static Connection connector = null;

public static Connection getConnection() {
	
	connector = null;
	
	if (connector == null) {
		
		try {
			
			//Please load the driver
			Class.forName("org.postgresql.Driver");
			
			//connect with DB using properties 
			connector = DriverManager.getConnection(
					System.getenv("projectone"), 
					System.getenv("learningSQLDBusername"), 
					System.getenv("projectzeropassword")
					);
			LOGGER.debug("Connection to database established.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.error("SQL Exception generated when attempting to access the database.");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} //end if
	return connector;
}
}
