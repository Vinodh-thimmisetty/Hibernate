package com.vinodh.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/***
 * 
 * Register the Driver to DriverManager
 * 	Get Connection from Driver Manager
 * 	   Create Statement
 *  Iterate the Results
 * Close the Connections
 * 
 * @author Vinodh Kumar Thimmisetty
 *
 */
public class JDBCExample {

	// JDBC Driver Details
	static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";

	// JDBC DB URL
	static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";

	// Database Credentials
	static final String USERNAME = "VINODH";
	static final String PASSWORD = "vinodh";

	public static void main(String[] args) throws SQLException {
		Connection connection = null;
		Statement statement = null;

		try {
			// Register the JDBC_DRIVER
			Class.forName(JDBC_DRIVER);

			// Open the Connection using Driver Manager
			connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

			// Execute a SQL Query & Save in a Result Set
			String sqlQuery = "Select * from DEMO_STATES";
			statement = connection.createStatement();
			connection.setSavepoint();
			ResultSet resultSet = statement.executeQuery(sqlQuery);

			// Extract Data from Result set

			while (resultSet.next()) {
				System.out.println(resultSet.getString(2));
			}
			System.out.println("--------------------------------");
			CallableStatement callableStatement  = connection.prepareCall("{call STATE_LIST(?,?)}");
			callableStatement.setString(1, String.valueOf('A'));
			callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
			callableStatement.executeUpdate();
			
			int count = Integer.parseInt(callableStatement.getString(2));
					
			System.out.println("count is --->"+count);
			
			// closing the Resource
			resultSet.close();
			statement.close();
			connection.close();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		} // end try
		System.out.println("Goodbye!");

	}
}
