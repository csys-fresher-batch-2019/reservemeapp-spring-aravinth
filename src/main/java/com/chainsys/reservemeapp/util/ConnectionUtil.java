package com.chainsys.reservemeapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.chainsys.reservemeapp.exception.DbException;

public class ConnectionUtil {
	public static Connection connect() throws SQLException, DbException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String server = "13.235.147.120";
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@" + server + ":1521:XE", "aravinth","aravinth");
		   // Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system","oracle");
			System.out.println(connection);
			return connection;
		} catch (ClassNotFoundException |SQLException e) {
			e.printStackTrace();
			throw new DbException(InfoMessages.CONNECTION, e);

		}

	}
}
