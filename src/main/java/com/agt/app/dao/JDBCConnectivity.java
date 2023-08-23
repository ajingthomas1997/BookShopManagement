package com.agt.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JDBCConnectivity {
	
	static Logger logger = LogManager.getLogger(DatabaseServiceImplementation.class);
	
	static{

		try {

			Class.forName(DatabaseUtils.JDBC_DRIVER_PATH);

		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		}

	}

	public Connection getConnection(String url, String username, String password) {

		try {

			return DriverManager.getConnection(url, username, password);

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return null;

	}
	
	public Connection getConnection() {

		try {

			return DriverManager.getConnection(DatabaseUtils.DB_URL, DatabaseUtils.DB_USERNAME, DatabaseUtils.DB_PASSWORD);

		} catch (SQLException e) {

			e.printStackTrace();
			
			logger.error("Error : Data cannot retrive from db.");

		}

		return null;

	}

	public void close(ResultSet resultSet, Statement statement, Connection connection) {

		try {
			if (resultSet != null && !resultSet.isClosed()) {

				resultSet.close();

			}
			if (statement != null && !statement.isClosed()) {

				statement.close();

			}
			if (connection != null && !connection.isClosed()) {

				connection.close();

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

	public void close(Statement statement, Connection connection) {

		try {

			if (statement != null && !statement.isClosed()) {

				statement.close();

			}
			if (connection != null && !connection.isClosed()) {

				connection.close();

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

}
